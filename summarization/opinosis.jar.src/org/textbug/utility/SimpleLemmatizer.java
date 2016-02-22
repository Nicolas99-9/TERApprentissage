/*     */ package org.textbug.utility;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class SimpleLemmatizer {
/*     */   private static HashMap<String, String> hm;
/*     */   private static SimpleLemmatizer instance;
/*     */   private static StringBuffer sbTemp;
/*     */   
/*  10 */   static { hm = new HashMap();
/*     */     
/*  12 */     sbTemp = new StringBuffer(300);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  17 */     hm.put("fantastic", "good");
/*  18 */     hm.put("superb", "good");
/*  19 */     hm.put("wonderful", "good");
/*  20 */     hm.put("amazing", "good");
/*  21 */     hm.put("perfect", "good");
/*  22 */     hm.put("awesome", "good");
/*  23 */     hm.put("lovely", "good");
/*  24 */     hm.put("great", "good");
/*  25 */     hm.put("attentive", "good");
/*  26 */     hm.put("pleasant", "good");
/*  27 */     hm.put("delicious", "good");
/*  28 */     hm.put("tasty", "good");
/*  29 */     hm.put("yummy", "good");
/*  30 */     hm.put("exceptional", "good");
/*  31 */     hm.put("superior", "good");
/*  32 */     hm.put("comparable", "good");
/*  33 */     hm.put("tremendous", "good");
/*  34 */     hm.put("fun", "good");
/*  35 */     hm.put("phenomenal", "good");
/*  36 */     hm.put("excellent", "good");
/*     */     
/*  38 */     hm.put("beautiful", "nice");
/*     */     
/*     */ 
/*     */ 
/*  42 */     hm.put("was", "is");
/*  43 */     hm.put("are", "is");
/*     */     
/*     */ 
/*  46 */     hm.put("item", "product");
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
/*  69 */     hm.put("poor", "bad");
/*  70 */     hm.put("lousy", "bad");
/*  71 */     hm.put("useless", "bad");
/*  72 */     hm.put("horrible", "bad");
/*  73 */     hm.put("terrible", "bad");
/*  74 */     hm.put("crappy", "bad");
/*  75 */     hm.put("unsatisfactory", "bad");
/*  76 */     hm.put("atrocious", "bad");
/*  77 */     hm.put("awful", "bad");
/*  78 */     hm.put("crummy", "bad");
/*  79 */     hm.put("subpar", "bad");
/*     */     
/*     */ 
/*     */ 
/*  83 */     hm.put("courteous", "polite");
/*  84 */     hm.put("kind", "polite");
/*     */     
/*     */ 
/*     */ 
/*  88 */     hm.put("adore", "like");
/*  89 */     hm.put("love", "like");
/*     */     
/*     */ 
/*  92 */     hm.put("audio", "sound");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  97 */     hm.put("kinda", "");
/*  98 */     hm.put("sorta", "");
/*  99 */     hm.put("very", "");
/* 100 */     hm.put("extremely", "");
/* 101 */     hm.put("also", "");
/* 102 */     hm.put("still", "");
/* 103 */     hm.put("absolutely", "");
/* 104 */     hm.put("really", "");
/* 105 */     hm.put("simply", "");
/* 106 */     hm.put("definitely", "");
/* 107 */     hm.put("too", "");
/* 108 */     hm.put("truly", "");
/* 109 */     hm.put("actually", "");
/* 110 */     hm.put("overly", "");
/* 111 */     hm.put("surprisingly", "");
/* 112 */     hm.put("amazingly", "");
/* 113 */     hm.put("totally", "");
/* 114 */     hm.put("alone", "");
/* 115 */     hm.put("exceptionally", "");
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
/* 136 */     hm.put("cost", "price");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static synchronized SimpleLemmatizer getInstance()
/*     */   {
/* 143 */     if (instance == null)
/* 144 */       instance = new SimpleLemmatizer();
/* 145 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String[] lemmatize(String[] str)
/*     */   {
/* 154 */     assert (str != null) : "bla";
/*     */     
/* 156 */     for (int i = 0; i < str.length; i++) {
/* 157 */       str[i] = lemmatizeWord(str[i]);
/*     */     }
/* 159 */     return str;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String lemmatizeSentence(String str)
/*     */   {
/* 169 */     str = str.replaceAll("is not", "isnt");
/* 170 */     str = str.replaceAll("was not", "isnt");
/*     */     
/*     */ 
/* 173 */     sbTemp.delete(0, sbTemp.length());
/* 174 */     assert (sbTemp.length() == 0);
/*     */     
/* 176 */     String[] strTemp = str.split(" ");
/* 177 */     for (int i = 0; i < strTemp.length; i++) {
/* 178 */       assert (strTemp != null) : "bla";
/* 179 */       strTemp[i] = lemmatizeWord(strTemp[i]);
/*     */       
/* 181 */       if (!strTemp[i].equals("")) {
/* 182 */         sbTemp.append(strTemp[i]);
/* 183 */         sbTemp.append(" ");
/*     */       }
/*     */     }
/* 186 */     return sbTemp.toString().trim();
/*     */   }
/*     */   
/*     */   public String lemmatizeWord(String str) {
/* 190 */     assert (str.indexOf(' ') == -1);
/* 191 */     String mapping = (String)hm.get(str);
/* 192 */     if (mapping == null)
/* 193 */       return str;
/* 194 */     return mapping;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\SimpleLemmatizer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */