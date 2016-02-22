/*     */ package org.textbug.utility;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.PrintStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ 
/*     */ public class ExtWordListWrapper
/*     */ {
/*  11 */   private static String FILE_AUXVBS = "org/sifaka/resources/auxi.verbs.txt";
/*  12 */   private static String FILE_COMMON_DETERMINERS = "org/sifaka/resources/determiners.txt";
/*     */   
/*     */ 
/*     */ 
/*  16 */   private static String FILE_COMMON_EN_STOPWORDS = "org/sifaka/resources/stoplist.common.txt";
/*  17 */   private static String FILE_CONJUNCTIONS = "org/sifaka/resources/conjunctions.txt";
/*  18 */   static HashMap<String, Double> mBackgroundModel = null;
/*  19 */   private static HashMap mWordIdf = null;
/*     */   
/*     */ 
/*     */ 
/*     */   public static double getIDFScore(String word)
/*     */   {
/*  25 */     if (mBackgroundModel == null) {
/*  26 */       loadBackgroundModel();
/*     */     }
/*     */     
/*  29 */     Double score = (Double)mBackgroundModel.get(word);
/*     */     
/*  31 */     if (score == null) { return 1.2000000476837158D;
/*     */     }
/*     */     
/*  34 */     return score.doubleValue();
/*     */   }
/*     */   
/*     */   private static void loadBackgroundModel()
/*     */   {
/*  39 */     mBackgroundModel = new HashMap();
/*  40 */     String line = "";
/*     */     try {
/*  42 */       BufferedReader reader = 
/*  43 */         FileUtil.getResourceFromPackage("com/opiniosistant/resources/reviews.backgroundwords");
/*  44 */       while ((line = reader.readLine()) != null) {
/*  45 */         int splitIdx = line.indexOf('\t');
/*     */         
/*  47 */         String word = line.substring(0, splitIdx);
/*  48 */         Double idf = Double.valueOf(Double.parseDouble(line.substring(splitIdx + 1, 
/*  49 */           line.length() - 1)));
/*     */         
/*  51 */         mBackgroundModel.put(word, idf);
/*     */       }
/*     */     }
/*     */     catch (Exception exception)
/*     */     {
/*  56 */       System.out.println("THIS IS HE" + line);
/*  57 */       exception.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*  62 */   private HashSet wordDict = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean containsWord(String s)
/*     */   {
/*  73 */     if (this.wordDict == null) {
/*  74 */       System.err.println("Call appropriate load method before calling this method");
/*  75 */       System.exit(-1);
/*     */     }
/*     */     
/*  78 */     boolean contains = this.wordDict.contains(s);
/*  79 */     return contains;
/*     */   }
/*     */   
/*     */   private BufferedReader getResourceReader(String strResourceName) throws Exception {
/*  83 */     BufferedReader reader = FileUtil.getResourceFromPackage(strResourceName);
/*  84 */     return reader;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void loadAuxVerbs()
/*     */   {
/*  94 */     loadFile(FILE_AUXVBS);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void loadCommonENStopWords()
/*     */   {
/* 103 */     loadFile(FILE_COMMON_EN_STOPWORDS);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void loadConjunctions()
/*     */   {
/* 111 */     loadFile(FILE_CONJUNCTIONS);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void loadDeterminers()
/*     */   {
/* 119 */     loadFile(FILE_COMMON_DETERMINERS);
/*     */   }
/*     */   
/*     */   private void loadFile(String fileName)
/*     */   {
/*     */     try {
/* 125 */       System.out.println("...Loading " + fileName);
/*     */       
/*     */ 
/* 128 */       this.wordDict = new HashSet();
/* 129 */       BufferedReader reader = getResourceReader(fileName);
/* 130 */       String word; while ((word = reader.readLine()) != null) {
/*     */         String word;
/* 132 */         if (!word.startsWith("#")) {
/* 133 */           word = word.toLowerCase().trim();
/* 134 */           this.wordDict.add(word);
/*     */         }
/*     */       }
/*     */     } catch (Exception exception) {
/* 138 */       exception.printStackTrace();
/* 139 */       System.exit(-1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public synchronized void loadStopWords(HashSet set)
/*     */   {
/* 150 */     String stopWord = "";
/*     */     try {
/* 152 */       BufferedReader reader = 
/* 153 */         FileUtil.getResourceFromPackage("org/sifaka/resources/stoplist_common.txt");
/* 154 */       while ((stopWord = reader.readLine()) != null) {
/* 155 */         stopWord = stopWord.trim();
/* 156 */         set.add(stopWord);
/*     */       }
/*     */     }
/*     */     catch (Exception exception) {
/* 160 */       exception.printStackTrace();
/* 161 */       System.exit(-1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\ExtWordListWrapper.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */