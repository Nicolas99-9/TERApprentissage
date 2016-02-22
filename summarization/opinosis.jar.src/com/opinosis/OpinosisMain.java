/*     */ package com.opinosis;
/*     */ 
/*     */ import com.opinosis.summarizer.BasicSummarizer;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Properties;
/*     */ import org.jgrapht.graph.DefaultWeightedEdge;
/*     */ import org.jgrapht.graph.SimpleDirectedWeightedGraph;
/*     */ import org.kohsuke.args4j.CmdLineException;
/*     */ import org.kohsuke.args4j.CmdLineParser;
/*     */ import org.textbug.utility.FileUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OpinosisMain
/*     */   extends OpinosisSettings
/*     */ {
/*  37 */   String strRundId = "";
/*  38 */   Properties properties = new Properties();
/*     */   
/*     */   public void loadProps(String propfile) {
/*     */     try {
/*  42 */       InputStream stream = new FileInputStream(propfile);
/*  43 */       this.properties.load(stream);
/*     */       
/*  45 */       String property = this.properties.getProperty("collapse", "true");
/*  46 */       CONFIG_TURN_ON_COLLAPSE = Boolean.parseBoolean(property);
/*     */       
/*  48 */       property = this.properties.getProperty("dupelim", "true");
/*  49 */       CONFIG_TURN_ON_DUP_ELIM = Boolean.parseBoolean(property);
/*     */       
/*  51 */       property = this.properties.getProperty("normalized", "true");
/*  52 */       CONFIG_NORMALIZE_OVERALLGAIN = Boolean.parseBoolean(property);
/*     */       
/*  54 */       property = this.properties.getProperty("redundancy", "2");
/*  55 */       CONFIG_MIN_REDUNDANCY = Integer.parseInt(property);
/*     */       
/*  57 */       property = this.properties.getProperty("scoring_function", String.valueOf(GAIN_WEIGHTED_REDUNDANCY_BY_LOG_LEVEL));
/*  58 */       CONFIG_SCORING_FUNCTION = Integer.parseInt(property);
/*     */       
/*  60 */       property = this.properties.getProperty("gap", "3");
/*  61 */       CONFIG_PERMISSABLE_GAP = Integer.parseInt(property);
/*     */       
/*     */ 
/*  64 */       if (CONFIG_PERMISSABLE_GAP < 2) { CONFIG_PERMISSABLE_GAP = 3;
/*     */       }
/*  66 */       property = this.properties.getProperty("attach_after", "2");
/*  67 */       CONFIG_ATTACHMENT_AFTER = Integer.parseInt(property);
/*     */       
/*  69 */       property = this.properties.getProperty("duplicate_threshold", "0.35");
/*  70 */       CONFIG_DUPLICATE_THRESHOLD = Double.parseDouble(property);
/*     */       
/*  72 */       property = this.properties.getProperty("max_summary", "2");
/*  73 */       CONFIG_MAX_SUMMARIES = Integer.parseInt(property);
/*     */       
/*  75 */       property = this.properties.getProperty("collapse_duplicate_threshold", "0.5");
/*  76 */       CONFIG_DUPLICATE_COLLAPSE_THRESHOLD = Double.parseDouble(property);
/*     */       
/*  78 */       property = this.properties.getProperty("run_id", "1");
/*  79 */       this.strRundId = property;
/*     */     }
/*     */     catch (IOException exception)
/*     */     {
/*  83 */       exception.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/*  88 */     OpinosisMain main = new OpinosisMain();
/*  89 */     main.start(args);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void start(String[] args)
/*     */   {
/*  96 */     MyOptions bean = new MyOptions();
/*  97 */     CmdLineParser parser = new CmdLineParser(bean);
/*     */     try {
/*  99 */       parser.parseArgument(args);
/*     */       
/* 101 */       if (bean.getDirBase() == null) {
/* 102 */         parser.printUsage(System.err);
/* 103 */         System.exit(-1);
/*     */       }
/*     */     }
/*     */     catch (CmdLineException e) {
/* 107 */       System.err.println(e.getMessage() + "\n\n");
/* 108 */       System.err.println("java -jar opinosis.jar [options...] arguments...");
/* 109 */       parser.printUsage(System.err);
/* 110 */       return;
/*     */     }
/*     */     
/*     */ 
/* 114 */     long tstart = System.currentTimeMillis();
/*     */     
/*     */ 
/* 117 */     String propFile = bean.getDirBase().getAbsolutePath() + FILE_SEP + "etc" + FILE_SEP + "opinosis.properties";
/* 118 */     String inputDir = bean.getDirBase().getAbsolutePath() + FILE_SEP + "input";
/* 119 */     String outputDir = bean.getDirBase().getAbsolutePath() + FILE_SEP + "output";
/*     */     
/*     */ 
/* 122 */     loadProps(propFile);
/*     */     
/*     */ 
/* 125 */     List<String> filesToSum = new ArrayList();
/* 126 */     if ((inputDir.length() > 0) && (FileUtil.isFileExists(inputDir))) {
/* 127 */       filesToSum = FileUtil.getFilesInDirectory(inputDir);
/*     */     } else {
/* 129 */       System.err.println(inputDir + " " + " does not exist..please check your directory structure");
/*     */     }
/*     */     
/* 132 */     if (filesToSum.size() > 1000) {
/* 133 */       System.err.println("Too many files to summarize. Please limit to 200 files per run.");
/* 134 */       System.exit(-1);
/*     */     }
/*     */     
/*     */ 
/* 138 */     int i = 1;
/* 139 */     for (String infile : filesToSum) {
/* 140 */       String outfile = getOutputFileName(outputDir, infile);
/* 141 */       doGenerateSummary(infile, outfile, i++);
/*     */     }
/* 143 */     long tend = System.currentTimeMillis();
/* 144 */     System.out.println("Took " + (tend - tstart) + "ms");
/*     */   }
/*     */   
/*     */   private String getOutputFileName(String dirOut, String file)
/*     */   {
/* 149 */     int idxStart = file.lastIndexOf(FILE_SEP);
/* 150 */     int idxEnd = file.indexOf('.', idxStart);
/*     */     
/*     */ 
/* 153 */     if (idxEnd == -1) {
/* 154 */       idxEnd = file.length() - 1;
/*     */     }
/*     */     
/* 157 */     String theOutFile = "";
/*     */     
/*     */ 
/* 160 */     String runOutputPath = dirOut + FILE_SEP + this.strRundId + FILE_SEP;
/* 161 */     File f = new File(runOutputPath);
/* 162 */     f.mkdirs();
/*     */     
/*     */ 
/* 165 */     theOutFile = runOutputPath + file.substring(idxStart, idxEnd) + "." + this.strRundId + ".system";
/*     */     
/*     */ 
/*     */     try
/*     */     {
/* 170 */       PrintWriter writer = new PrintWriter(dirOut + FILE_SEP + "config." + this.strRundId + ".txt");
/* 171 */       this.properties.list(writer);
/* 172 */       writer.close();
/*     */     }
/*     */     catch (IOException exception) {
/* 175 */       exception.printStackTrace();
/* 176 */       System.err.println("There seems to be some problem with the file names, please contact kganes2@illinois.edu");
/*     */     }
/* 178 */     return theOutFile;
/*     */   }
/*     */   
/*     */ 
/*     */   public void doGenerateSummary(String fileName, String outfile, int taskId)
/*     */   {
/* 184 */     SimpleDirectedWeightedGraph<Node, DefaultWeightedEdge> g = new SimpleDirectedWeightedGraph(DefaultWeightedEdge.class);
/* 185 */     OpinosisGraphBuilder builder = new OpinosisGraphBuilder();
/* 186 */     HashMap<String, Node> wordNodeMap = null;
/*     */     
/*     */     try
/*     */     {
/* 190 */       BufferedReader reader = new BufferedReader(new FileReader(fileName));
/* 191 */       String str = "";
/* 192 */       int sentenceid = 0;
/*     */       
/* 194 */       while ((str = reader.readLine()) != null) {
/* 195 */         sentenceid++;
/* 196 */         str = str.toLowerCase();
/* 197 */         wordNodeMap = builder.growGraph(str, 1, sentenceid);
/*     */       }
/*     */     }
/*     */     catch (Exception exception) {
/* 201 */       exception.printStackTrace();
/*     */     }
/* 203 */     System.out.println("----------------TASK:" + taskId + "--------------------------");
/* 204 */     System.out.println("Generating Summaries for: " + fileName);
/* 205 */     System.out.println("Graph materialized...");
/* 206 */     Writer bla = new PrintWriter(System.out);
/* 207 */     g = builder.getGraph();
/*     */     
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 213 */       System.out.println("Started summary generation...");
/* 214 */       BufferedWriter printer = FileUtil.getWriter(outfile);
/*     */       
/* 216 */       OpinosisCore summarizer = new BasicSummarizer(g, wordNodeMap, printer);
/* 217 */       summarizer.start();
/* 218 */       System.out.println("Generated: " + outfile);
/* 219 */       System.gc();
/*     */     }
/*     */     catch (IOException exception)
/*     */     {
/* 223 */       exception.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getReviewId(String str)
/*     */   {
/* 259 */     int revid = -1;
/* 260 */     if (str.startsWith("#")) {
/* 261 */       revid = Integer.parseInt(str.substring(1, str.length()));
/*     */     }
/*     */     
/* 264 */     return revid;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\com\opinosis\OpinosisMain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */