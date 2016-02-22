/*     */ package org.textbug.utility;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SentenceNormalizer
/*     */ {
/*     */   private static SentenceNormalizer instance;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static synchronized SentenceNormalizer getInstance()
/*     */   {
/*  19 */     if (instance == null) {
/*  20 */       instance = new SentenceNormalizer();
/*     */     }
/*     */     
/*  23 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private String normalizeAND(String str1, String concatToStr1)
/*     */   {
/*  35 */     StringBuffer sb = new StringBuffer();
/*     */     
/*  37 */     int idxStart = str1.lastIndexOf("and") - 1;
/*  38 */     int idxEnd = str1.lastIndexOf("and") + 4;
/*     */     
/*  40 */     String strA = str1.substring(0, idxStart);
/*  41 */     String strB = str1.substring(idxEnd, str1.length());
/*     */     
/*  43 */     sb.append(concatToStr1)
/*  44 */       .append(" ")
/*  45 */       .append(strA)
/*  46 */       .append(" ")
/*  47 */       .append("and ")
/*  48 */       .append(concatToStr1)
/*  49 */       .append(" ")
/*  50 */       .append(strB);
/*     */     
/*  52 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public String normalizeIS(String str)
/*     */   {
/*  57 */     assert (str != null);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  62 */     String[] tokens = str.split("\\s+");
/*  63 */     if (tokens.length < 11)
/*     */     {
/*     */ 
/*     */ 
/*  67 */       tokens = str.split("\\sis\\s*");
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  72 */       if (tokens.length == 2) {
/*  73 */         StringBuffer sb = new StringBuffer();
/*     */         
/*     */ 
/*     */ 
/*  77 */         if ((tokens[0].contains("the ")) || (tokens[0].contains("this ")) || (tokens[0].contains("a ")))
/*     */         {
/*  79 */           int idx = tokens[0].indexOf(' ') + 1;
/*  80 */           tokens[0] = tokens[0].trim();
/*  81 */           tokens[0] = tokens[0].substring(idx, tokens[0].length());
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  88 */         String[] part1Tokens = tokens[0].split("\\s+");
/*  89 */         String[] part2Tokens = tokens[1].split("\\s+");
/*     */         
/*  91 */         if ((tokens[0].contains(" and")) && (part2Tokens.length == 1) && (part1Tokens.length < 5)) {
/*  92 */           str = normalizeAND(tokens[0], tokens[1]);
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*  97 */         else if ((part1Tokens.length < 5) && (part2Tokens.length < 3))
/*     */         {
/*     */ 
/* 100 */           sb.append(tokens[1]).append(" ").append(tokens[0]);
/*     */           
/* 102 */           str = sb.toString();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 108 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\SentenceNormalizer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */