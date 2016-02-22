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
/*     */ public class norwegianStemmer
/*     */   extends SnowballStemmer
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  16 */   private static final norwegianStemmer methodObject = new norwegianStemmer();
/*     */   
/*  18 */   private static final Among[] a_0 = {
/*  19 */     new Among("a", -1, 1, "", methodObject), 
/*  20 */     new Among("e", -1, 1, "", methodObject), 
/*  21 */     new Among("ede", 1, 1, "", methodObject), 
/*  22 */     new Among("ande", 1, 1, "", methodObject), 
/*  23 */     new Among("ende", 1, 1, "", methodObject), 
/*  24 */     new Among("ane", 1, 1, "", methodObject), 
/*  25 */     new Among("ene", 1, 1, "", methodObject), 
/*  26 */     new Among("hetene", 6, 1, "", methodObject), 
/*  27 */     new Among("erte", 1, 3, "", methodObject), 
/*  28 */     new Among("en", -1, 1, "", methodObject), 
/*  29 */     new Among("heten", 9, 1, "", methodObject), 
/*  30 */     new Among("ar", -1, 1, "", methodObject), 
/*  31 */     new Among("er", -1, 1, "", methodObject), 
/*  32 */     new Among("heter", 12, 1, "", methodObject), 
/*  33 */     new Among("s", -1, 2, "", methodObject), 
/*  34 */     new Among("as", 14, 1, "", methodObject), 
/*  35 */     new Among("es", 14, 1, "", methodObject), 
/*  36 */     new Among("edes", 16, 1, "", methodObject), 
/*  37 */     new Among("endes", 16, 1, "", methodObject), 
/*  38 */     new Among("enes", 16, 1, "", methodObject), 
/*  39 */     new Among("hetenes", 19, 1, "", methodObject), 
/*  40 */     new Among("ens", 14, 1, "", methodObject), 
/*  41 */     new Among("hetens", 21, 1, "", methodObject), 
/*  42 */     new Among("ers", 14, 1, "", methodObject), 
/*  43 */     new Among("ets", 14, 1, "", methodObject), 
/*  44 */     new Among("et", -1, 1, "", methodObject), 
/*  45 */     new Among("het", 25, 1, "", methodObject), 
/*  46 */     new Among("ert", -1, 3, "", methodObject), 
/*  47 */     new Among("ast", -1, 1, "", methodObject) };
/*     */   
/*     */ 
/*  50 */   private static final Among[] a_1 = {
/*  51 */     new Among("dt", -1, -1, "", methodObject), 
/*  52 */     new Among("vt", -1, -1, "", methodObject) };
/*     */   
/*     */ 
/*  55 */   private static final Among[] a_2 = {
/*  56 */     new Among("leg", -1, 1, "", methodObject), 
/*  57 */     new Among("eleg", 0, 1, "", methodObject), 
/*  58 */     new Among("ig", -1, 1, "", methodObject), 
/*  59 */     new Among("eig", 2, 1, "", methodObject), 
/*  60 */     new Among("lig", 2, 1, "", methodObject), 
/*  61 */     new Among("elig", 4, 1, "", methodObject), 
/*  62 */     new Among("els", -1, 1, "", methodObject), 
/*  63 */     new Among("lov", -1, 1, "", methodObject), 
/*  64 */     new Among("elov", 7, 1, "", methodObject), 
/*  65 */     new Among("slov", 7, 1, "", methodObject), 
/*  66 */     new Among("hetslov", 9, 1, "", methodObject) };
/*     */   
/*     */ 
/*  69 */   private static final char[] g_v = { '\021', 'A', '\020', '\001', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '0', '\000''' };
/*     */   
/*  71 */   private static final char[] g_s_ending = { 'w', '}', '', '\001' };
/*     */   private int I_x;
/*     */   private int I_p1;
/*     */   
/*     */   private void copy_from(norwegianStemmer other)
/*     */   {
/*  77 */     this.I_x = other.I_x;
/*  78 */     this.I_p1 = other.I_p1;
/*  79 */     super.copy_from(other);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean r_mark_regions()
/*     */   {
/*  86 */     this.I_p1 = this.limit;
/*     */     
/*  88 */     int v_1 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/*  92 */     int c = this.cursor + 3;
/*  93 */     if ((c < 0) || (c > this.limit))
/*     */     {
/*  95 */       return false;
/*     */     }
/*  97 */     this.cursor = c;
/*     */     
/*     */ 
/* 100 */     this.I_x = this.cursor;
/* 101 */     this.cursor = v_1;
/*     */     
/*     */     for (;;)
/*     */     {
/* 105 */       int v_2 = this.cursor;
/*     */       
/* 107 */       if (in_grouping(g_v, 97, 248))
/*     */       {
/*     */ 
/*     */ 
/* 111 */         this.cursor = v_2;
/* 112 */         break;
/*     */       }
/* 114 */       this.cursor = v_2;
/* 115 */       if (this.cursor >= this.limit)
/*     */       {
/* 117 */         return false;
/*     */       }
/* 119 */       this.cursor += 1;
/*     */     }
/*     */     
/*     */ 
/*     */     int v_2;
/*     */     
/* 125 */     while (!out_grouping(g_v, 97, 248))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 131 */       if (this.cursor >= this.limit)
/*     */       {
/* 133 */         return false;
/*     */       }
/* 135 */       this.cursor += 1;
/*     */     }
/*     */     
/* 138 */     this.I_p1 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 142 */     if (this.I_p1 < this.I_x)
/*     */     {
/*     */ 
/*     */ 
/* 146 */       this.I_p1 = this.I_x;
/*     */     }
/* 148 */     return true;
/*     */   }
/*     */   
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
/* 172 */     int among_var = find_among_b(a_0, 29);
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
/*     */ 
/*     */ 
/*     */     case 2: 
/* 193 */       int v_3 = this.limit - this.cursor;
/*     */       
/* 195 */       if (!in_grouping_b(g_s_ending, 98, 122))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 201 */         this.cursor = (this.limit - v_3);
/*     */         
/*     */ 
/* 204 */         if (!eq_s_b(1, "k"))
/*     */         {
/* 206 */           return false;
/*     */         }
/* 208 */         if (!out_grouping_b(g_v, 97, 248))
/*     */         {
/* 210 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 214 */       slice_del();
/* 215 */       break;
/*     */     
/*     */ 
/*     */     case 3: 
/* 219 */       slice_from("er");
/*     */     }
/*     */     
/* 222 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_consonant_pair()
/*     */   {
/* 231 */     int v_1 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 234 */     int v_2 = this.limit - this.cursor;
/*     */     
/* 236 */     if (this.cursor < this.I_p1)
/*     */     {
/* 238 */       return false;
/*     */     }
/* 240 */     this.cursor = this.I_p1;
/* 241 */     int v_3 = this.limit_backward;
/* 242 */     this.limit_backward = this.cursor;
/* 243 */     this.cursor = (this.limit - v_2);
/*     */     
/*     */ 
/* 246 */     this.ket = this.cursor;
/*     */     
/* 248 */     if (find_among_b(a_1, 2) == 0)
/*     */     {
/* 250 */       this.limit_backward = v_3;
/* 251 */       return false;
/*     */     }
/*     */     
/* 254 */     this.bra = this.cursor;
/* 255 */     this.limit_backward = v_3;
/* 256 */     this.cursor = (this.limit - v_1);
/*     */     
/* 258 */     if (this.cursor <= this.limit_backward)
/*     */     {
/* 260 */       return false;
/*     */     }
/* 262 */     this.cursor -= 1;
/*     */     
/* 264 */     this.bra = this.cursor;
/*     */     
/* 266 */     slice_del();
/* 267 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_other_suffix()
/*     */   {
/* 276 */     int v_1 = this.limit - this.cursor;
/*     */     
/* 278 */     if (this.cursor < this.I_p1)
/*     */     {
/* 280 */       return false;
/*     */     }
/* 282 */     this.cursor = this.I_p1;
/* 283 */     int v_2 = this.limit_backward;
/* 284 */     this.limit_backward = this.cursor;
/* 285 */     this.cursor = (this.limit - v_1);
/*     */     
/*     */ 
/* 288 */     this.ket = this.cursor;
/*     */     
/* 290 */     int among_var = find_among_b(a_2, 11);
/* 291 */     if (among_var == 0)
/*     */     {
/* 293 */       this.limit_backward = v_2;
/* 294 */       return false;
/*     */     }
/*     */     
/* 297 */     this.bra = this.cursor;
/* 298 */     this.limit_backward = v_2;
/* 299 */     switch (among_var) {
/*     */     case 0: 
/* 301 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 305 */       slice_del();
/*     */     }
/*     */     
/* 308 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean stem()
/*     */   {
/* 319 */     int v_1 = this.cursor;
/*     */     
/*     */ 
/* 322 */     if (!r_mark_regions()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 327 */     this.cursor = v_1;
/*     */     
/* 329 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*     */     
/*     */ 
/* 332 */     int v_2 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 335 */     if (!r_main_suffix()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 340 */     this.cursor = (this.limit - v_2);
/*     */     
/* 342 */     int v_3 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 345 */     if (!r_consonant_pair()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 350 */     this.cursor = (this.limit - v_3);
/*     */     
/* 352 */     int v_4 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 355 */     if (!r_other_suffix()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 360 */     this.cursor = (this.limit - v_4);
/* 361 */     this.cursor = this.limit_backward;return true;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 366 */     return o instanceof norwegianStemmer;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 371 */     return norwegianStemmer.class.getName().hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\norwegianStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */