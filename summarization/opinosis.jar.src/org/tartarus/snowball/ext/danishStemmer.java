/*     */ package org.tartarus.snowball.ext;
/*     */ 
/*     */ import org.tartarus.snowball.Among;
/*     */ import org.tartarus.snowball.SnowballStemmer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class danishStemmer
/*     */   extends SnowballStemmer
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  16 */   private static final danishStemmer methodObject = new danishStemmer();
/*     */   
/*  18 */   private static final Among[] a_0 = {
/*  19 */     new Among("hed", -1, 1, "", methodObject), 
/*  20 */     new Among("ethed", 0, 1, "", methodObject), 
/*  21 */     new Among("ered", -1, 1, "", methodObject), 
/*  22 */     new Among("e", -1, 1, "", methodObject), 
/*  23 */     new Among("erede", 3, 1, "", methodObject), 
/*  24 */     new Among("ende", 3, 1, "", methodObject), 
/*  25 */     new Among("erende", 5, 1, "", methodObject), 
/*  26 */     new Among("ene", 3, 1, "", methodObject), 
/*  27 */     new Among("erne", 3, 1, "", methodObject), 
/*  28 */     new Among("ere", 3, 1, "", methodObject), 
/*  29 */     new Among("en", -1, 1, "", methodObject), 
/*  30 */     new Among("heden", 10, 1, "", methodObject), 
/*  31 */     new Among("eren", 10, 1, "", methodObject), 
/*  32 */     new Among("er", -1, 1, "", methodObject), 
/*  33 */     new Among("heder", 13, 1, "", methodObject), 
/*  34 */     new Among("erer", 13, 1, "", methodObject), 
/*  35 */     new Among("s", -1, 2, "", methodObject), 
/*  36 */     new Among("heds", 16, 1, "", methodObject), 
/*  37 */     new Among("es", 16, 1, "", methodObject), 
/*  38 */     new Among("endes", 18, 1, "", methodObject), 
/*  39 */     new Among("erendes", 19, 1, "", methodObject), 
/*  40 */     new Among("enes", 18, 1, "", methodObject), 
/*  41 */     new Among("ernes", 18, 1, "", methodObject), 
/*  42 */     new Among("eres", 18, 1, "", methodObject), 
/*  43 */     new Among("ens", 16, 1, "", methodObject), 
/*  44 */     new Among("hedens", 24, 1, "", methodObject), 
/*  45 */     new Among("erens", 24, 1, "", methodObject), 
/*  46 */     new Among("ers", 16, 1, "", methodObject), 
/*  47 */     new Among("ets", 16, 1, "", methodObject), 
/*  48 */     new Among("erets", 28, 1, "", methodObject), 
/*  49 */     new Among("et", -1, 1, "", methodObject), 
/*  50 */     new Among("eret", 30, 1, "", methodObject) };
/*     */   
/*     */ 
/*  53 */   private static final Among[] a_1 = {
/*  54 */     new Among("gd", -1, -1, "", methodObject), 
/*  55 */     new Among("dt", -1, -1, "", methodObject), 
/*  56 */     new Among("gt", -1, -1, "", methodObject), 
/*  57 */     new Among("kt", -1, -1, "", methodObject) };
/*     */   
/*     */ 
/*  60 */   private static final Among[] a_2 = {
/*  61 */     new Among("ig", -1, 1, "", methodObject), 
/*  62 */     new Among("lig", 0, 1, "", methodObject), 
/*  63 */     new Among("elig", 1, 1, "", methodObject), 
/*  64 */     new Among("els", -1, 1, "", methodObject), 
/*  65 */     new Among("løst", -1, 2, "", methodObject) };
/*     */   
/*     */ 
/*  68 */   private static final char[] g_v = { '\021', 'A', '\020', '\001', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '0', '\000''' };
/*     */   
/*  70 */   private static final char[] g_s_ending = { 'ï', 'þ', '*', '\003', '\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\020' };
/*     */   
/*     */   private int I_x;
/*     */   private int I_p1;
/*  74 */   private StringBuilder S_ch = new StringBuilder();
/*     */   
/*     */   private void copy_from(danishStemmer other) {
/*  77 */     this.I_x = other.I_x;
/*  78 */     this.I_p1 = other.I_p1;
/*  79 */     this.S_ch = other.S_ch;
/*  80 */     super.copy_from(other);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean r_mark_regions()
/*     */   {
/*  87 */     this.I_p1 = this.limit;
/*     */     
/*  89 */     int v_1 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/*  93 */     int c = this.cursor + 3;
/*  94 */     if ((c < 0) || (c > this.limit))
/*     */     {
/*  96 */       return false;
/*     */     }
/*  98 */     this.cursor = c;
/*     */     
/*     */ 
/* 101 */     this.I_x = this.cursor;
/* 102 */     this.cursor = v_1;
/*     */     
/*     */     for (;;)
/*     */     {
/* 106 */       int v_2 = this.cursor;
/*     */       
/* 108 */       if (in_grouping(g_v, 97, 248))
/*     */       {
/*     */ 
/*     */ 
/* 112 */         this.cursor = v_2;
/* 113 */         break;
/*     */       }
/* 115 */       this.cursor = v_2;
/* 116 */       if (this.cursor >= this.limit)
/*     */       {
/* 118 */         return false;
/*     */       }
/* 120 */       this.cursor += 1;
/*     */     }
/*     */     
/*     */ 
/*     */     int v_2;
/*     */     
/* 126 */     while (!out_grouping(g_v, 97, 248))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 132 */       if (this.cursor >= this.limit)
/*     */       {
/* 134 */         return false;
/*     */       }
/* 136 */       this.cursor += 1;
/*     */     }
/*     */     
/* 139 */     this.I_p1 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 143 */     if (this.I_p1 < this.I_x)
/*     */     {
/*     */ 
/*     */ 
/* 147 */       this.I_p1 = this.I_x;
/*     */     }
/* 149 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_main_suffix()
/*     */   {
/* 158 */     int v_1 = this.limit - this.cursor;
/*     */     
/* 160 */     if (this.cursor < this.I_p1)
/*     */     {
/* 162 */       return false;
/*     */     }
/* 164 */     this.cursor = this.I_p1;
/* 165 */     int v_2 = this.limit_backward;
/* 166 */     this.limit_backward = this.cursor;
/* 167 */     this.cursor = (this.limit - v_1);
/*     */     
/*     */ 
/* 170 */     this.ket = this.cursor;
/*     */     
/* 172 */     int among_var = find_among_b(a_0, 32);
/* 173 */     if (among_var == 0)
/*     */     {
/* 175 */       this.limit_backward = v_2;
/* 176 */       return false;
/*     */     }
/*     */     
/* 179 */     this.bra = this.cursor;
/* 180 */     this.limit_backward = v_2;
/* 181 */     switch (among_var) {
/*     */     case 0: 
/* 183 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 187 */       slice_del();
/* 188 */       break;
/*     */     
/*     */     case 2: 
/* 191 */       if (!in_grouping_b(g_s_ending, 97, 229))
/*     */       {
/* 193 */         return false;
/*     */       }
/*     */       
/* 196 */       slice_del();
/*     */     }
/*     */     
/* 199 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_consonant_pair()
/*     */   {
/* 208 */     int v_1 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 211 */     int v_2 = this.limit - this.cursor;
/*     */     
/* 213 */     if (this.cursor < this.I_p1)
/*     */     {
/* 215 */       return false;
/*     */     }
/* 217 */     this.cursor = this.I_p1;
/* 218 */     int v_3 = this.limit_backward;
/* 219 */     this.limit_backward = this.cursor;
/* 220 */     this.cursor = (this.limit - v_2);
/*     */     
/*     */ 
/* 223 */     this.ket = this.cursor;
/*     */     
/* 225 */     if (find_among_b(a_1, 4) == 0)
/*     */     {
/* 227 */       this.limit_backward = v_3;
/* 228 */       return false;
/*     */     }
/*     */     
/* 231 */     this.bra = this.cursor;
/* 232 */     this.limit_backward = v_3;
/* 233 */     this.cursor = (this.limit - v_1);
/*     */     
/* 235 */     if (this.cursor <= this.limit_backward)
/*     */     {
/* 237 */       return false;
/*     */     }
/* 239 */     this.cursor -= 1;
/*     */     
/* 241 */     this.bra = this.cursor;
/*     */     
/* 243 */     slice_del();
/* 244 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_other_suffix()
/*     */   {
/* 255 */     int v_1 = this.limit - this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 259 */     this.ket = this.cursor;
/*     */     
/* 261 */     if (eq_s_b(2, "st"))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 266 */       this.bra = this.cursor;
/*     */       
/* 268 */       if (eq_s_b(2, "ig"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 273 */         slice_del(); }
/*     */     }
/* 275 */     this.cursor = (this.limit - v_1);
/*     */     
/* 277 */     int v_2 = this.limit - this.cursor;
/*     */     
/* 279 */     if (this.cursor < this.I_p1)
/*     */     {
/* 281 */       return false;
/*     */     }
/* 283 */     this.cursor = this.I_p1;
/* 284 */     int v_3 = this.limit_backward;
/* 285 */     this.limit_backward = this.cursor;
/* 286 */     this.cursor = (this.limit - v_2);
/*     */     
/*     */ 
/* 289 */     this.ket = this.cursor;
/*     */     
/* 291 */     int among_var = find_among_b(a_2, 5);
/* 292 */     if (among_var == 0)
/*     */     {
/* 294 */       this.limit_backward = v_3;
/* 295 */       return false;
/*     */     }
/*     */     
/* 298 */     this.bra = this.cursor;
/* 299 */     this.limit_backward = v_3;
/* 300 */     switch (among_var) {
/*     */     case 0: 
/* 302 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 306 */       slice_del();
/*     */       
/* 308 */       int v_4 = this.limit - this.cursor;
/*     */       
/*     */ 
/* 311 */       if (!r_consonant_pair()) {}
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 316 */       this.cursor = (this.limit - v_4);
/* 317 */       break;
/*     */     
/*     */ 
/*     */     case 2: 
/* 321 */       slice_from("løs");
/*     */     }
/*     */     
/* 324 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_undouble()
/*     */   {
/* 332 */     int v_1 = this.limit - this.cursor;
/*     */     
/* 334 */     if (this.cursor < this.I_p1)
/*     */     {
/* 336 */       return false;
/*     */     }
/* 338 */     this.cursor = this.I_p1;
/* 339 */     int v_2 = this.limit_backward;
/* 340 */     this.limit_backward = this.cursor;
/* 341 */     this.cursor = (this.limit - v_1);
/*     */     
/*     */ 
/* 344 */     this.ket = this.cursor;
/* 345 */     if (!out_grouping_b(g_v, 97, 248))
/*     */     {
/* 347 */       this.limit_backward = v_2;
/* 348 */       return false;
/*     */     }
/*     */     
/* 351 */     this.bra = this.cursor;
/*     */     
/* 353 */     this.S_ch = slice_to(this.S_ch);
/* 354 */     this.limit_backward = v_2;
/*     */     
/* 356 */     if (!eq_v_b(this.S_ch))
/*     */     {
/* 358 */       return false;
/*     */     }
/*     */     
/* 361 */     slice_del();
/* 362 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean stem()
/*     */   {
/* 374 */     int v_1 = this.cursor;
/*     */     
/*     */ 
/* 377 */     if (!r_mark_regions()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 382 */     this.cursor = v_1;
/*     */     
/* 384 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*     */     
/*     */ 
/* 387 */     int v_2 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 390 */     if (!r_main_suffix()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 395 */     this.cursor = (this.limit - v_2);
/*     */     
/* 397 */     int v_3 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 400 */     if (!r_consonant_pair()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 405 */     this.cursor = (this.limit - v_3);
/*     */     
/* 407 */     int v_4 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 410 */     if (!r_other_suffix()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 415 */     this.cursor = (this.limit - v_4);
/*     */     
/* 417 */     int v_5 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 420 */     if (!r_undouble()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 425 */     this.cursor = (this.limit - v_5);
/* 426 */     this.cursor = this.limit_backward;return true;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 431 */     return o instanceof danishStemmer;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 436 */     return danishStemmer.class.getName().hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\danishStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */