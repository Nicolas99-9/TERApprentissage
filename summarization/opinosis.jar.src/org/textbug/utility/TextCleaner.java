/*    */ package org.textbug.utility;
/*    */ 
/*    */ 
/*    */ public class TextCleaner
/*    */ {
/*    */   private static TextCleaner instance;
/*    */   
/*    */   public static synchronized TextCleaner getInstance()
/*    */   {
/* 10 */     if (instance == null) {
/* 11 */       instance = new TextCleaner();
/*    */     }
/* 13 */     return instance;
/*    */   }
/*    */   
/*    */ 
/* 17 */   String SPECIAL_CHARS_WITH_NOSPACE = "('|\\.|=|&|\\{|\\}|\\(|\\)|\\\"|:|-)";
/*    */   
/*    */ 
/* 20 */   String SPECIAL_CHARS_WITH_SPACE = "!|,|;|[|]|/";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String chunkClean(String str)
/*    */   {
/* 38 */     str = str.replaceAll(this.SPECIAL_CHARS_WITH_SPACE, " ");
/*    */     
/* 40 */     str = str.replaceAll(this.SPECIAL_CHARS_WITH_NOSPACE, "");
/*    */     
/*    */ 
/* 43 */     str = str.replaceAll("\n\\s+", "\n");
/*    */     
/*    */ 
/* 46 */     str = str.toLowerCase();
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 53 */     return str;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String fullSentenceClean(String str)
/*    */   {
/* 69 */     return str;
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\TextCleaner.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */