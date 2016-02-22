/*    */ package org.textbug.utility;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TermCounter
/*    */   implements Runnable
/*    */ {
/* 18 */   private TextCleaner cleaner = TextCleaner.getInstance();
/*    */   
/* 20 */   private List<Integer> countArray = new ArrayList();
/* 21 */   private LinkedHashMap<String, Integer> dictionary = new LinkedHashMap();
/* 22 */   private SentenceSplitter sentenceSplitter = SentenceSplitter.getInstance();
/*    */   
/*    */   String theStr;
/*    */   
/*    */   public TermCounter(String str, LinkedHashMap dict, List<Integer> ctArray)
/*    */   {
/* 28 */     this.theStr = str;
/* 29 */     this.dictionary = dict;
/* 30 */     this.countArray = ctArray;
/*    */   }
/*    */   
/*    */   public void incrementCount(String term) {
/* 34 */     Integer termId = (Integer)this.dictionary.get(term);
/*    */     
/*    */ 
/* 37 */     if (termId == null) {
/* 38 */       this.countArray.add(Integer.valueOf(1));
/* 39 */       termId = Integer.valueOf(this.countArray.size() - 1);
/* 40 */       this.dictionary.put(term, termId);
/*    */     } else {
/* 42 */       int count = ((Integer)this.countArray.get(termId.intValue())).intValue() + 1;
/* 43 */       this.countArray.add(termId.intValue(), Integer.valueOf(count));
/*    */     }
/*    */   }
/*    */   
/*    */   private void processRawSentence()
/*    */   {
/* 49 */     String chunk = SentenceSplitter.split(this.theStr);
/* 50 */     chunk = this.cleaner.chunkClean(chunk);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 59 */     String[] words = chunk.split("\\s+");
/*    */     String[] arrayOfString1;
/* 61 */     int j = (arrayOfString1 = words).length; for (int i = 0; i < j; i++) { String word = arrayOfString1[i];
/* 62 */       incrementCount(word);
/*    */     }
/*    */     
/* 65 */     System.out.println();
/*    */   }
/*    */   
/*    */ 
/*    */   public void run()
/*    */   {
/* 71 */     processRawSentence();
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\TermCounter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */