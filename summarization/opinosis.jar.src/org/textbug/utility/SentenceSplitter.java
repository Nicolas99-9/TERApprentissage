/*     */ package org.textbug.utility;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
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
/*     */ public class SentenceSplitter
/*     */ {
/*     */   private static SentenceSplitter instance;
/*  23 */   static boolean NEED_PUNCT = true;
/*     */   
/*     */   public static synchronized SentenceSplitter getInstance() {
/*  26 */     if (instance == null) {
/*  27 */       instance = new SentenceSplitter();
/*     */     }
/*  29 */     return instance;
/*     */   }
/*     */   
/*     */   private static boolean isAbbreviation(String str)
/*     */   {
/*  34 */     int strLen = str.length();
/*  35 */     int count = 1;
/*     */     
/*  37 */     if (strLen > 6)
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     if (str.matches("etc.")) {
/*  43 */       return true;
/*     */     }
/*  45 */     int firstPeriodIdx = str.indexOf('.');
/*  46 */     int lastPeriodIdx = str.lastIndexOf('.');
/*     */     
/*  48 */     if (firstPeriodIdx != lastPeriodIdx) {
/*  49 */       return true;
/*     */     }
/*     */     
/*  52 */     if ((Character.isUpperCase(str.charAt(0))) && (lastPeriodIdx > 0))
/*     */     {
/*     */ 
/*  55 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  63 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static String split(String uText)
/*     */   {
/*  75 */     StringBuffer sb = new StringBuffer(uText.length());
/*  76 */     String[] tokens = uText.split("\\s+");
/*  77 */     boolean endFound = false;
/*  78 */     for (int i = 0; i < tokens.length; i++)
/*     */     {
/*  80 */       tokens[i] = tokens[i].trim();
/*  81 */       if (tokens[i].matches("^(\\.|!|;)"))
/*     */       {
/*     */ 
/*     */ 
/*  85 */         if (NEED_PUNCT)
/*     */         {
/*  87 */           tokens[i] = " .\n";
/*     */         }
/*     */         else {
/*  90 */           tokens[i] = "\n";
/*     */         }
/*     */         
/*     */       }
/*  94 */       else if ((tokens[i].indexOf('.') > 0) && (tokens[i].length() > 1))
/*     */       {
/*  96 */         if (!isAbbreviation(tokens[i])) {
/*  97 */           tokens[i] = tokens[i].replace(".", " .\n");
/*     */         }
/*     */       }
/* 100 */       else if (tokens[i].matches(".*(!|;)\\s*$"))
/*     */       {
/*     */ 
/* 103 */         tokens[i] = tokens[i].replaceAll("(!|;)\\s*$", "\n");
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 108 */       sb.append(tokens[i]);
/* 109 */       sb.append(" ");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 114 */     uText = sb.toString();
/*     */     
/* 116 */     return uText;
/*     */   }
/*     */   
/*     */   public static void splitFile(String filepath) throws IOException
/*     */   {
/* 121 */     BufferedReader reader = new BufferedReader(new FileReader(filepath));
/*     */     
/* 123 */     String line = "";
/* 124 */     while ((line = reader.readLine()) != null)
/*     */     {
/* 126 */       String str = split(line);
/* 127 */       System.out.print(str);
/*     */     }
/*     */     
/* 130 */     System.out.println();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean endsWith(String str, char ch)
/*     */   {
/* 138 */     return str.charAt(str.length() - 1) == ch;
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
/*     */   public List<String> splitIntoList(String uText)
/*     */   {
/* 151 */     String str = split(uText);
/* 152 */     String[] strs = str.split("\\s*\n\\s*");
/* 153 */     List<String> l = Arrays.asList(strs);
/* 154 */     return l;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\SentenceSplitter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */