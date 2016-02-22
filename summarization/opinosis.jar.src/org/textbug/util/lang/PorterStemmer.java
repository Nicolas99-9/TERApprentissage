/*     */ package org.textbug.util.lang;
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
/*     */ public class PorterStemmer
/*     */ {
/*     */   public String stem(String str)
/*     */   {
/*  20 */     if (str.length() > 0)
/*     */     {
/*  22 */       char[] c = str.toCharArray();
/*  23 */       for (int i = 0; i < c.length; i++) {
/*  24 */         if (!Character.isLetter(c[i]))
/*  25 */           return "Invalid term";
/*     */       }
/*     */     } else {
/*  28 */       return "No term entered";
/*     */     }
/*  30 */     str = step1a(str);
/*  31 */     str = step1b(str);
/*  32 */     str = step1c(str);
/*  33 */     str = step2(str);
/*  34 */     str = step3(str);
/*  35 */     str = step4(str);
/*  36 */     str = step5a(str);
/*  37 */     str = step5b(str);
/*  38 */     return str;
/*     */   }
/*     */   
/*     */   protected String step1a(String str)
/*     */   {
/*  43 */     if (str.endsWith("sses")) {
/*  44 */       return str.substring(0, str.length() - 2);
/*     */     }
/*  46 */     if (str.endsWith("ies")) {
/*  47 */       return str.substring(0, str.length() - 2);
/*     */     }
/*  49 */     if (str.endsWith("ss")) {
/*  50 */       return str;
/*     */     }
/*  52 */     if (str.endsWith("s")) {
/*  53 */       return str.substring(0, str.length() - 1);
/*     */     }
/*  55 */     return str;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String step1b(String str)
/*     */   {
/*  61 */     if (str.endsWith("eed")) {
/*  62 */       if (stringMeasure(str.substring(0, str.length() - 3)) > 0) {
/*  63 */         return str.substring(0, str.length() - 1);
/*     */       }
/*  65 */       return str;
/*     */     }
/*  67 */     if ((str.endsWith("ed")) && 
/*  68 */       (containsVowel(str.substring(0, str.length() - 2)))) {
/*  69 */       return step1b2(str.substring(0, str.length() - 2));
/*     */     }
/*  71 */     if ((str.endsWith("ing")) && 
/*  72 */       (containsVowel(str.substring(0, str.length() - 3)))) {
/*  73 */       return step1b2(str.substring(0, str.length() - 3));
/*     */     }
/*  75 */     return str;
/*     */   }
/*     */   
/*     */   protected String step1b2(String str)
/*     */   {
/*  80 */     if ((str.endsWith("at")) || 
/*  81 */       (str.endsWith("bl")) || 
/*  82 */       (str.endsWith("iz")))
/*  83 */       return str + "e";
/*  84 */     if ((endsWithDoubleConsonent(str)) && 
/*  85 */       (!str.endsWith("l")) && (!str.endsWith("s")) && (!str.endsWith("z")))
/*  86 */       return str.substring(0, str.length() - 1);
/*  87 */     if ((stringMeasure(str) == 1) && 
/*  88 */       (endsWithCVC(str))) {
/*  89 */       return str + "e";
/*     */     }
/*  91 */     return str;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String step1c(String str)
/*     */   {
/*  97 */     if ((str.endsWith("y")) && 
/*  98 */       (containsVowel(str.substring(0, str.length() - 1)))) {
/*  99 */       return str.substring(0, str.length() - 1) + "i";
/*     */     }
/* 101 */     return str;
/*     */   }
/*     */   
/*     */   protected String step2(String str)
/*     */   {
/* 106 */     if ((str.endsWith("ational")) && 
/* 107 */       (stringMeasure(str.substring(0, str.length() - 5)) > 0)) {
/* 108 */       return str.substring(0, str.length() - 5) + "e";
/*     */     }
/* 110 */     if ((str.endsWith("tional")) && 
/* 111 */       (stringMeasure(str.substring(0, str.length() - 2)) > 0)) {
/* 112 */       return str.substring(0, str.length() - 2);
/*     */     }
/* 114 */     if ((str.endsWith("enci")) && 
/* 115 */       (stringMeasure(str.substring(0, str.length() - 2)) > 0)) {
/* 116 */       return str.substring(0, str.length() - 2);
/*     */     }
/* 118 */     if ((str.endsWith("anci")) && 
/* 119 */       (stringMeasure(str.substring(0, str.length() - 1)) > 0)) {
/* 120 */       return str.substring(0, str.length() - 1) + "e";
/*     */     }
/* 122 */     if ((str.endsWith("izer")) && 
/* 123 */       (stringMeasure(str.substring(0, str.length() - 1)) > 0)) {
/* 124 */       return str.substring(0, str.length() - 1);
/*     */     }
/* 126 */     if ((str.endsWith("abli")) && 
/* 127 */       (stringMeasure(str.substring(0, str.length() - 1)) > 0)) {
/* 128 */       return str.substring(0, str.length() - 1) + "e";
/*     */     }
/* 130 */     if ((str.endsWith("alli")) && 
/* 131 */       (stringMeasure(str.substring(0, str.length() - 2)) > 0)) {
/* 132 */       return str.substring(0, str.length() - 2);
/*     */     }
/* 134 */     if ((str.endsWith("entli")) && 
/* 135 */       (stringMeasure(str.substring(0, str.length() - 2)) > 0)) {
/* 136 */       return str.substring(0, str.length() - 2);
/*     */     }
/* 138 */     if ((str.endsWith("eli")) && 
/* 139 */       (stringMeasure(str.substring(0, str.length() - 2)) > 0)) {
/* 140 */       return str.substring(0, str.length() - 2);
/*     */     }
/* 142 */     if ((str.endsWith("ousli")) && 
/* 143 */       (stringMeasure(str.substring(0, str.length() - 2)) > 0)) {
/* 144 */       return str.substring(0, str.length() - 2);
/*     */     }
/* 146 */     if ((str.endsWith("ization")) && 
/* 147 */       (stringMeasure(str.substring(0, str.length() - 5)) > 0)) {
/* 148 */       return str.substring(0, str.length() - 5) + "e";
/*     */     }
/* 150 */     if ((str.endsWith("ation")) && 
/* 151 */       (stringMeasure(str.substring(0, str.length() - 3)) > 0)) {
/* 152 */       return str.substring(0, str.length() - 3) + "e";
/*     */     }
/* 154 */     if ((str.endsWith("ator")) && 
/* 155 */       (stringMeasure(str.substring(0, str.length() - 2)) > 0)) {
/* 156 */       return str.substring(0, str.length() - 2) + "e";
/*     */     }
/* 158 */     if ((str.endsWith("alism")) && 
/* 159 */       (stringMeasure(str.substring(0, str.length() - 3)) > 0)) {
/* 160 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 162 */     if ((str.endsWith("iveness")) && 
/* 163 */       (stringMeasure(str.substring(0, str.length() - 4)) > 0)) {
/* 164 */       return str.substring(0, str.length() - 4);
/*     */     }
/* 166 */     if ((str.endsWith("fulness")) && 
/* 167 */       (stringMeasure(str.substring(0, str.length() - 4)) > 0)) {
/* 168 */       return str.substring(0, str.length() - 4);
/*     */     }
/* 170 */     if ((str.endsWith("ousness")) && 
/* 171 */       (stringMeasure(str.substring(0, str.length() - 4)) > 0)) {
/* 172 */       return str.substring(0, str.length() - 4);
/*     */     }
/* 174 */     if ((str.endsWith("aliti")) && 
/* 175 */       (stringMeasure(str.substring(0, str.length() - 3)) > 0)) {
/* 176 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 178 */     if ((str.endsWith("iviti")) && 
/* 179 */       (stringMeasure(str.substring(0, str.length() - 3)) > 0)) {
/* 180 */       return str.substring(0, str.length() - 3) + "e";
/*     */     }
/* 182 */     if ((str.endsWith("biliti")) && 
/* 183 */       (stringMeasure(str.substring(0, str.length() - 5)) > 0)) {
/* 184 */       return str.substring(0, str.length() - 5) + "le";
/*     */     }
/* 186 */     return str;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String step3(String str)
/*     */   {
/* 192 */     if ((str.endsWith("icate")) && 
/* 193 */       (stringMeasure(str.substring(0, str.length() - 3)) > 0)) {
/* 194 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 196 */     if ((str.endsWith("ative")) && 
/* 197 */       (stringMeasure(str.substring(0, str.length() - 5)) > 0)) {
/* 198 */       return str.substring(0, str.length() - 5);
/*     */     }
/* 200 */     if ((str.endsWith("alize")) && 
/* 201 */       (stringMeasure(str.substring(0, str.length() - 3)) > 0)) {
/* 202 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 204 */     if ((str.endsWith("iciti")) && 
/* 205 */       (stringMeasure(str.substring(0, str.length() - 3)) > 0)) {
/* 206 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 208 */     if ((str.endsWith("ical")) && 
/* 209 */       (stringMeasure(str.substring(0, str.length() - 2)) > 0)) {
/* 210 */       return str.substring(0, str.length() - 2);
/*     */     }
/* 212 */     if ((str.endsWith("ful")) && 
/* 213 */       (stringMeasure(str.substring(0, str.length() - 3)) > 0)) {
/* 214 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 216 */     if ((str.endsWith("ness")) && 
/* 217 */       (stringMeasure(str.substring(0, str.length() - 4)) > 0)) {
/* 218 */       return str.substring(0, str.length() - 4);
/*     */     }
/* 220 */     return str;
/*     */   }
/*     */   
/*     */   protected String step4(String str)
/*     */   {
/* 225 */     if ((str.endsWith("al")) && 
/* 226 */       (stringMeasure(str.substring(0, str.length() - 2)) > 1)) {
/* 227 */       return str.substring(0, str.length() - 2);
/*     */     }
/* 229 */     if ((str.endsWith("ance")) && 
/* 230 */       (stringMeasure(str.substring(0, str.length() - 4)) > 1)) {
/* 231 */       return str.substring(0, str.length() - 4);
/*     */     }
/* 233 */     if ((str.endsWith("ence")) && 
/* 234 */       (stringMeasure(str.substring(0, str.length() - 4)) > 1)) {
/* 235 */       return str.substring(0, str.length() - 4);
/*     */     }
/* 237 */     if ((str.endsWith("er")) && 
/* 238 */       (stringMeasure(str.substring(0, str.length() - 2)) > 1)) {
/* 239 */       return str.substring(0, str.length() - 2);
/*     */     }
/* 241 */     if ((str.endsWith("ic")) && 
/* 242 */       (stringMeasure(str.substring(0, str.length() - 2)) > 1)) {
/* 243 */       return str.substring(0, str.length() - 2);
/*     */     }
/* 245 */     if ((str.endsWith("able")) && 
/* 246 */       (stringMeasure(str.substring(0, str.length() - 4)) > 1)) {
/* 247 */       return str.substring(0, str.length() - 4);
/*     */     }
/* 249 */     if ((str.endsWith("ible")) && 
/* 250 */       (stringMeasure(str.substring(0, str.length() - 4)) > 1)) {
/* 251 */       return str.substring(0, str.length() - 4);
/*     */     }
/* 253 */     if ((str.endsWith("ant")) && 
/* 254 */       (stringMeasure(str.substring(0, str.length() - 3)) > 1)) {
/* 255 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 257 */     if ((str.endsWith("ement")) && 
/* 258 */       (stringMeasure(str.substring(0, str.length() - 5)) > 1)) {
/* 259 */       return str.substring(0, str.length() - 5);
/*     */     }
/* 261 */     if ((str.endsWith("ment")) && 
/* 262 */       (stringMeasure(str.substring(0, str.length() - 4)) > 1)) {
/* 263 */       return str.substring(0, str.length() - 4);
/*     */     }
/* 265 */     if ((str.endsWith("ent")) && 
/* 266 */       (stringMeasure(str.substring(0, str.length() - 3)) > 1)) {
/* 267 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 269 */     if (((str.endsWith("sion")) || (str.endsWith("tion"))) && 
/* 270 */       (stringMeasure(str.substring(0, str.length() - 3)) > 1)) {
/* 271 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 273 */     if ((str.endsWith("ou")) && 
/* 274 */       (stringMeasure(str.substring(0, str.length() - 2)) > 1)) {
/* 275 */       return str.substring(0, str.length() - 2);
/*     */     }
/* 277 */     if ((str.endsWith("ism")) && 
/* 278 */       (stringMeasure(str.substring(0, str.length() - 3)) > 1)) {
/* 279 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 281 */     if ((str.endsWith("ate")) && 
/* 282 */       (stringMeasure(str.substring(0, str.length() - 3)) > 1)) {
/* 283 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 285 */     if ((str.endsWith("iti")) && 
/* 286 */       (stringMeasure(str.substring(0, str.length() - 3)) > 1)) {
/* 287 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 289 */     if ((str.endsWith("ous")) && 
/* 290 */       (stringMeasure(str.substring(0, str.length() - 3)) > 1)) {
/* 291 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 293 */     if ((str.endsWith("ive")) && 
/* 294 */       (stringMeasure(str.substring(0, str.length() - 3)) > 1)) {
/* 295 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 297 */     if ((str.endsWith("ize")) && 
/* 298 */       (stringMeasure(str.substring(0, str.length() - 3)) > 1)) {
/* 299 */       return str.substring(0, str.length() - 3);
/*     */     }
/* 301 */     return str;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String step5a(String str)
/*     */   {
/* 307 */     if ((stringMeasure(str.substring(0, str.length() - 1)) > 1) && 
/* 308 */       (str.endsWith("e"))) {
/* 309 */       return str.substring(0, str.length() - 1);
/*     */     }
/* 311 */     if ((stringMeasure(str.substring(0, str.length() - 1)) == 1) && 
/* 312 */       (!endsWithCVC(str.substring(0, str.length() - 1))) && 
/* 313 */       (str.endsWith("e"))) {
/* 314 */       return str.substring(0, str.length() - 1);
/*     */     }
/* 316 */     return str;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String step5b(String str)
/*     */   {
/* 322 */     if ((str.endsWith("l")) && 
/* 323 */       (endsWithDoubleConsonent(str)) && 
/* 324 */       (stringMeasure(str.substring(0, str.length() - 1)) > 1)) {
/* 325 */       return str.substring(0, str.length() - 1);
/*     */     }
/* 327 */     return str;
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
/*     */   protected boolean endsWithS(String str)
/*     */   {
/* 340 */     return str.endsWith("s");
/*     */   }
/*     */   
/*     */   protected boolean containsVowel(String str)
/*     */   {
/* 345 */     char[] strchars = str.toCharArray();
/* 346 */     for (int i = 0; i < strchars.length; i++) {
/* 347 */       if (isVowel(strchars[i])) {
/* 348 */         return true;
/*     */       }
/*     */     }
/* 351 */     if (str.indexOf('y') > -1) {
/* 352 */       return true;
/*     */     }
/* 354 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isVowel(char c)
/*     */   {
/* 359 */     if ((c == 'a') || 
/* 360 */       (c == 'e') || 
/* 361 */       (c == 'i') || 
/* 362 */       (c == 'o') || 
/* 363 */       (c == 'u')) {
/* 364 */       return true;
/*     */     }
/* 366 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean endsWithDoubleConsonent(String str)
/*     */   {
/* 371 */     char c = str.charAt(str.length() - 1);
/* 372 */     if ((c == str.charAt(str.length() - 2)) && 
/* 373 */       (!containsVowel(str.substring(str.length() - 2)))) {
/* 374 */       return true;
/*     */     }
/* 376 */     return false;
/*     */   }
/*     */   
/*     */   protected int stringMeasure(String str)
/*     */   {
/* 381 */     int count = 0;
/* 382 */     boolean vowelSeen = false;
/* 383 */     char[] strchars = str.toCharArray();
/*     */     
/* 385 */     for (int i = 0; i < strchars.length; i++) {
/* 386 */       if (isVowel(strchars[i])) {
/* 387 */         vowelSeen = true;
/* 388 */       } else if (vowelSeen) {
/* 389 */         count++;
/* 390 */         vowelSeen = false;
/*     */       }
/*     */     }
/* 393 */     return count;
/*     */   }
/*     */   
/*     */   protected boolean endsWithCVC(String str)
/*     */   {
/* 398 */     char c2 = ' ';
/* 399 */     if (str.length() >= 3) {
/* 400 */       char c = str.charAt(str.length() - 1);
/* 401 */       char v = str.charAt(str.length() - 2);
/* 402 */       c2 = str.charAt(str.length() - 3);
/*     */     } else {
/* 404 */       return false; }
/*     */     char v;
/*     */     char c;
/* 407 */     if ((c == 'w') || (c == 'x') || (c == 'y'))
/* 408 */       return false;
/* 409 */     if (isVowel(c))
/* 410 */       return false;
/* 411 */     if (!isVowel(v))
/* 412 */       return false;
/* 413 */     if (isVowel(c2)) {
/* 414 */       return false;
/*     */     }
/* 416 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\util\lang\PorterStemmer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */