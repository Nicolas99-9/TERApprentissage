/*     */ package org.textbug.utility;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.LineNumberReader;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import org.textbug.lucene.html.HTMLParser;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WordStatistics
/*     */   implements Runnable
/*     */ {
/*  27 */   private TextCleaner cleaner = TextCleaner.getInstance();
/*  28 */   private List<Integer> countArray = new ArrayList();
/*  29 */   private LinkedHashMap<String, TermInfo> dictionary = new LinkedHashMap();
/*  30 */   private String errMessage = "";
/*     */   
/*  32 */   private FileTypeEnum mFileType = FileTypeEnum.FILE_HTML;
/*     */   
/*     */ 
/*  35 */   private int mGram = 1;
/*     */   
/*     */ 
/*     */ 
/*     */   private String mPath;
/*     */   
/*     */ 
/*     */ 
/*  43 */   private SentenceSplitter sentenceSplitter = SentenceSplitter.getInstance();
/*     */   
/*     */   public WordStatistics() {}
/*     */   
/*     */   public WordStatistics(FileTypeEnum fileType, String path)
/*     */   {
/*  49 */     assert (path != null);
/*  50 */     assert (fileType != null);
/*     */     
/*  52 */     this.mPath = path;
/*  53 */     this.mFileType = fileType;
/*     */   }
/*     */   
/*     */   public WordStatistics(int nGram, FileTypeEnum fileType, String path)
/*     */   {
/*  58 */     assert (path != null);
/*  59 */     assert (fileType != null);
/*     */     
/*  61 */     this.mPath = path;
/*  62 */     this.mGram = nGram;
/*  63 */     this.mFileType = fileType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean computeWordStatistics()
/*     */     throws FileNotFoundException, IOException
/*     */   {
/*  73 */     if (validatePath())
/*     */     {
/*     */ 
/*  76 */       if (this.mFileType.equals(FileTypeEnum.FILE_HTML)) {
/*  77 */         htmlStatistics();
/*     */       }
/*     */       
/*  80 */       this.mFileType.equals(FileTypeEnum.DIR_HTML);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  86 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean computeWordStatistics(int nGram, String path, FileTypeEnum fileType)
/*     */     throws FileNotFoundException, IOException
/*     */   {
/*  97 */     this.mPath = path;
/*  98 */     this.mGram = nGram;
/*  99 */     this.mFileType = fileType;
/*     */     
/* 101 */     return computeWordStatistics();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getErrorMessage()
/*     */   {
/* 109 */     return this.errMessage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public TermInfo getTerm(String term)
/*     */   {
/* 117 */     return (TermInfo)this.dictionary.get(term);
/*     */   }
/*     */   
/*     */   public int getTotalFrequency(String[] terms)
/*     */   {
/* 122 */     int total = 0;
/*     */     String[] arrayOfString;
/* 124 */     int j = (arrayOfString = terms).length; for (int i = 0; i < j; i++) { String term = arrayOfString[i];
/* 125 */       TermInfo tInfo = (TermInfo)this.dictionary.get(term);
/* 126 */       if (tInfo != null) {
/* 127 */         total += tInfo.getTermFrequency();
/*     */       }
/*     */     }
/*     */     
/* 131 */     return total;
/*     */   }
/*     */   
/*     */ 
/*     */   public void getUnigramStatistics(String fileName, FileTypeEnum fileType)
/*     */     throws Exception
/*     */   {
/* 138 */     printResults(new OutputStreamWriter(System.out, "UTF-8"), SortCountsByEnum.COUNTS_DESC);
/*     */   }
/*     */   
/*     */   private void htmlStatistics() throws FileNotFoundException, IOException
/*     */   {
/*     */     try
/*     */     {
/* 145 */       FileInputStream is = new FileInputStream(this.mPath);
/* 146 */       HTMLParser htmlparse = new HTMLParser(is);
/* 147 */       LineNumberReader reader = new LineNumberReader(htmlparse.getReader());
/*     */       
/*     */ 
/* 150 */       for (String str = reader.readLine(); str != null; str = reader.readLine())
/*     */       {
/* 152 */         processRawSentence(str);
/*     */       }
/*     */     }
/*     */     catch (FileNotFoundException exception) {
/* 156 */       exception.printStackTrace();
/*     */     }
/*     */     catch (IOException exception) {
/* 159 */       exception.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   private void htmlStatistics2(String fileName) throws FileNotFoundException, IOException
/*     */   {
/*     */     try
/*     */     {
/* 167 */       FileInputStream is = new FileInputStream(fileName);
/* 168 */       HTMLParser htmlparse = new HTMLParser(is);
/* 169 */       LineNumberReader reader = new LineNumberReader(htmlparse.getReader());
/*     */       
/*     */ 
/* 172 */       for (String str = reader.readLine(); str != null; str = reader.readLine()) {}
/*     */ 
/*     */     }
/*     */     catch (FileNotFoundException exception)
/*     */     {
/*     */ 
/* 178 */       exception.printStackTrace();
/*     */     }
/*     */     catch (IOException exception) {
/* 181 */       exception.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void incrementCount(int gram, ArrayDeque<String> termArray)
/*     */   {
/* 189 */     StringBuffer sb = new StringBuffer();
/*     */     
/*     */ 
/*     */ 
/* 193 */     for (int i = 0; i < gram; i++)
/*     */     {
/* 195 */       int count = 0;
/* 196 */       sb.delete(0, sb.length());
/*     */       
/* 198 */       for (String w : termArray)
/*     */       {
/*     */ 
/* 201 */         sb.append(w);
/* 202 */         sb.append(" ");
/*     */         
/* 204 */         count++;
/* 205 */         if (count > i)
/*     */           break;
/*     */       }
/* 208 */       incrementCount(sb.toString().trim());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void incrementCount(String term)
/*     */   {
/* 216 */     TermInfo termId = (TermInfo)this.dictionary.get(term);
/*     */     
/*     */ 
/*     */ 
/* 220 */     if (termId == null) {
/* 221 */       this.dictionary.put(term, new TermInfo(term));
/*     */     } else {
/* 223 */       TermInfo info = (TermInfo)this.dictionary.get(term);
/* 224 */       info.incrementCount();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void printCountDescending()
/*     */   {
/* 233 */     List<TermInfo> tInfos = new ArrayList(this.dictionary.values());
/* 234 */     Collections.sort(tInfos);
/*     */     
/* 236 */     for (TermInfo term : tInfos)
/*     */     {
/* 238 */       System.out.print(term.getTerm());
/* 239 */       System.out.print("\t");
/* 240 */       System.out.print(term.getTermFrequency());
/* 241 */       System.out.print("\n");
/* 242 */       System.out.flush();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void printResults(OutputStreamWriter writer, SortCountsByEnum sortBy)
/*     */     throws IOException
/*     */   {
/* 250 */     if (sortBy.equals(SortCountsByEnum.COUNTS_DESC)) {
/* 251 */       printCountDescending();
/* 252 */       return;
/*     */     }
/*     */     
/* 255 */     if (sortBy.equals(SortCountsByEnum.TERM_ASC)) {
/* 256 */       printResultsTermAsc(writer);
/* 257 */       return;
/*     */     }
/*     */     
/* 260 */     if (sortBy.equals(SortCountsByEnum.COUNTS_ASC)) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void printResultsTermAsc(OutputStreamWriter writer)
/*     */     throws IOException
/*     */   {
/* 268 */     List<String> terms = new ArrayList(this.dictionary.keySet());
/* 269 */     Collections.sort(terms);
/*     */     
/* 271 */     for (String term : terms)
/*     */     {
/* 273 */       TermInfo termInfo = (TermInfo)this.dictionary.get(term);
/* 274 */       int count = termInfo.getTermFrequency();
/*     */       
/* 276 */       System.out.print(term);
/* 277 */       System.out.print("\t");
/* 278 */       System.out.print(count);
/* 279 */       System.out.print("\n");
/* 280 */       System.out.flush();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void processRawSentence(String str)
/*     */   {
/* 288 */     String chunk = SentenceSplitter.split(str);
/*     */     
/*     */ 
/* 291 */     chunk = this.cleaner.chunkClean(chunk);
/*     */     
/*     */ 
/* 294 */     String[] sentences = chunk.split("\\s*\n\\s*");
/*     */     
/* 296 */     int count = 0;
/* 297 */     ArrayDeque<String> temp = new ArrayDeque();
/* 298 */     String[] arrayOfString1; int j = (arrayOfString1 = sentences).length; for (int i = 0; i < j; i++) { String sentence = arrayOfString1[i];
/*     */       
/*     */ 
/* 301 */       String[] words = sentence.split("\\s+");
/*     */       
/* 303 */       temp.clear();
/* 304 */       String[] arrayOfString2; int m = (arrayOfString2 = words).length; for (int k = 0; k < m; k++) { String word = arrayOfString2[k];
/* 305 */         temp.add(word);
/* 306 */         if (temp.size() == this.mGram) {
/* 307 */           incrementCount(this.mGram, temp);
/* 308 */         } else if (temp.size() > this.mGram) {
/* 309 */           temp.removeFirst();
/* 310 */           incrementCount(this.mGram, temp);
/*     */         }
/*     */       }
/*     */       
/* 314 */       if (temp.size() < this.mGram) {
/* 315 */         incrementCount(temp.size(), temp);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void processRawSentence6(String str) {
/* 321 */     String chunk = SentenceSplitter.split(str);
/* 322 */     chunk = this.cleaner.chunkClean(chunk);
/* 323 */     String[] words = chunk.split("\\s+");
/*     */     String[] arrayOfString1;
/* 325 */     int j = (arrayOfString1 = words).length; for (int i = 0; i < j; i++) { String word = arrayOfString1[i];
/* 326 */       incrementCount(word);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void run() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean validatePath()
/*     */   {
/* 341 */     boolean pass = true;
/*     */     
/* 343 */     if ((this.mPath == null) || ((this.mPath != null) && (this.mPath.trim().equals("")))) {
/* 344 */       this.errMessage = ("The path provided is not valid:" + this.mPath);
/* 345 */       pass = false;
/*     */     }
/*     */     
/* 348 */     File f = new File(this.mPath);
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
/* 374 */     return pass;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\WordStatistics.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */