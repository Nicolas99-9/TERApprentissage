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
/*     */ public class swedishStemmer
/*     */   extends SnowballStemmer
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  16 */   private static final swedishStemmer methodObject = new swedishStemmer();
/*     */   
/*  18 */   private static final Among[] a_0 = {
/*  19 */     new Among("a", -1, 1, "", methodObject), 
/*  20 */     new Among("arna", 0, 1, "", methodObject), 
/*  21 */     new Among("erna", 0, 1, "", methodObject), 
/*  22 */     new Among("heterna", 2, 1, "", methodObject), 
/*  23 */     new Among("orna", 0, 1, "", methodObject), 
/*  24 */     new Among("ad", -1, 1, "", methodObject), 
/*  25 */     new Among("e", -1, 1, "", methodObject), 
/*  26 */     new Among("ade", 6, 1, "", methodObject), 
/*  27 */     new Among("ande", 6, 1, "", methodObject), 
/*  28 */     new Among("arne", 6, 1, "", methodObject), 
/*  29 */     new Among("are", 6, 1, "", methodObject), 
/*  30 */     new Among("aste", 6, 1, "", methodObject), 
/*  31 */     new Among("en", -1, 1, "", methodObject), 
/*  32 */     new Among("anden", 12, 1, "", methodObject), 
/*  33 */     new Among("aren", 12, 1, "", methodObject), 
/*  34 */     new Among("heten", 12, 1, "", methodObject), 
/*  35 */     new Among("ern", -1, 1, "", methodObject), 
/*  36 */     new Among("ar", -1, 1, "", methodObject), 
/*  37 */     new Among("er", -1, 1, "", methodObject), 
/*  38 */     new Among("heter", 18, 1, "", methodObject), 
/*  39 */     new Among("or", -1, 1, "", methodObject), 
/*  40 */     new Among("s", -1, 2, "", methodObject), 
/*  41 */     new Among("as", 21, 1, "", methodObject), 
/*  42 */     new Among("arnas", 22, 1, "", methodObject), 
/*  43 */     new Among("ernas", 22, 1, "", methodObject), 
/*  44 */     new Among("ornas", 22, 1, "", methodObject), 
/*  45 */     new Among("es", 21, 1, "", methodObject), 
/*  46 */     new Among("ades", 26, 1, "", methodObject), 
/*  47 */     new Among("andes", 26, 1, "", methodObject), 
/*  48 */     new Among("ens", 21, 1, "", methodObject), 
/*  49 */     new Among("arens", 29, 1, "", methodObject), 
/*  50 */     new Among("hetens", 29, 1, "", methodObject), 
/*  51 */     new Among("erns", 21, 1, "", methodObject), 
/*  52 */     new Among("at", -1, 1, "", methodObject), 
/*  53 */     new Among("andet", -1, 1, "", methodObject), 
/*  54 */     new Among("het", -1, 1, "", methodObject), 
/*  55 */     new Among("ast", -1, 1, "", methodObject) };
/*     */   
/*     */ 
/*  58 */   private static final Among[] a_1 = {
/*  59 */     new Among("dd", -1, -1, "", methodObject), 
/*  60 */     new Among("gd", -1, -1, "", methodObject), 
/*  61 */     new Among("nn", -1, -1, "", methodObject), 
/*  62 */     new Among("dt", -1, -1, "", methodObject), 
/*  63 */     new Among("gt", -1, -1, "", methodObject), 
/*  64 */     new Among("kt", -1, -1, "", methodObject), 
/*  65 */     new Among("tt", -1, -1, "", methodObject) };
/*     */   
/*     */ 
/*  68 */   private static final Among[] a_2 = {
/*  69 */     new Among("ig", -1, 1, "", methodObject), 
/*  70 */     new Among("lig", 0, 1, "", methodObject), 
/*  71 */     new Among("els", -1, 1, "", methodObject), 
/*  72 */     new Among("fullt", -1, 3, "", methodObject), 
/*  73 */     new Among("löst", -1, 2, "", methodObject) };
/*     */   
/*     */ 
/*  76 */   private static final char[] g_v = { '\021', 'A', '\020', '\001', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\030', '\000'' ' };
/*     */   
/*  78 */   private static final char[] g_s_ending = { 'w', '', '' };
/*     */   private int I_x;
/*     */   private int I_p1;
/*     */   
/*     */   private void copy_from(swedishStemmer other)
/*     */   {
/*  84 */     this.I_x = other.I_x;
/*  85 */     this.I_p1 = other.I_p1;
/*  86 */     super.copy_from(other);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean r_mark_regions()
/*     */   {
/*  93 */     this.I_p1 = this.limit;
/*     */     
/*  95 */     int v_1 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/*  99 */     int c = this.cursor + 3;
/* 100 */     if ((c < 0) || (c > this.limit))
/*     */     {
/* 102 */       return false;
/*     */     }
/* 104 */     this.cursor = c;
/*     */     
/*     */ 
/* 107 */     this.I_x = this.cursor;
/* 108 */     this.cursor = v_1;
/*     */     
/*     */     for (;;)
/*     */     {
/* 112 */       int v_2 = this.cursor;
/*     */       
/* 114 */       if (in_grouping(g_v, 97, 246))
/*     */       {
/*     */ 
/*     */ 
/* 118 */         this.cursor = v_2;
/* 119 */         break;
/*     */       }
/* 121 */       this.cursor = v_2;
/* 122 */       if (this.cursor >= this.limit)
/*     */       {
/* 124 */         return false;
/*     */       }
/* 126 */       this.cursor += 1;
/*     */     }
/*     */     
/*     */ 
/*     */     int v_2;
/*     */     
/* 132 */     while (!out_grouping(g_v, 97, 246))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 138 */       if (this.cursor >= this.limit)
/*     */       {
/* 140 */         return false;
/*     */       }
/* 142 */       this.cursor += 1;
/*     */     }
/*     */     
/* 145 */     this.I_p1 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 149 */     if (this.I_p1 < this.I_x)
/*     */     {
/*     */ 
/*     */ 
/* 153 */       this.I_p1 = this.I_x;
/*     */     }
/* 155 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_main_suffix()
/*     */   {
/* 164 */     int v_1 = this.limit - this.cursor;
/*     */     
/* 166 */     if (this.cursor < this.I_p1)
/*     */     {
/* 168 */       return false;
/*     */     }
/* 170 */     this.cursor = this.I_p1;
/* 171 */     int v_2 = this.limit_backward;
/* 172 */     this.limit_backward = this.cursor;
/* 173 */     this.cursor = (this.limit - v_1);
/*     */     
/*     */ 
/* 176 */     this.ket = this.cursor;
/*     */     
/* 178 */     int among_var = find_among_b(a_0, 37);
/* 179 */     if (among_var == 0)
/*     */     {
/* 181 */       this.limit_backward = v_2;
/* 182 */       return false;
/*     */     }
/*     */     
/* 185 */     this.bra = this.cursor;
/* 186 */     this.limit_backward = v_2;
/* 187 */     switch (among_var) {
/*     */     case 0: 
/* 189 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 193 */       slice_del();
/* 194 */       break;
/*     */     
/*     */     case 2: 
/* 197 */       if (!in_grouping_b(g_s_ending, 98, 121))
/*     */       {
/* 199 */         return false;
/*     */       }
/*     */       
/* 202 */       slice_del();
/*     */     }
/*     */     
/* 205 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_consonant_pair()
/*     */   {
/* 213 */     int v_1 = this.limit - this.cursor;
/*     */     
/* 215 */     if (this.cursor < this.I_p1)
/*     */     {
/* 217 */       return false;
/*     */     }
/* 219 */     this.cursor = this.I_p1;
/* 220 */     int v_2 = this.limit_backward;
/* 221 */     this.limit_backward = this.cursor;
/* 222 */     this.cursor = (this.limit - v_1);
/*     */     
/*     */ 
/* 225 */     int v_3 = this.limit - this.cursor;
/*     */     
/* 227 */     if (find_among_b(a_1, 7) == 0)
/*     */     {
/* 229 */       this.limit_backward = v_2;
/* 230 */       return false;
/*     */     }
/* 232 */     this.cursor = (this.limit - v_3);
/*     */     
/*     */ 
/* 235 */     this.ket = this.cursor;
/*     */     
/* 237 */     if (this.cursor <= this.limit_backward)
/*     */     {
/* 239 */       this.limit_backward = v_2;
/* 240 */       return false;
/*     */     }
/* 242 */     this.cursor -= 1;
/*     */     
/* 244 */     this.bra = this.cursor;
/*     */     
/* 246 */     slice_del();
/* 247 */     this.limit_backward = v_2;
/* 248 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_other_suffix()
/*     */   {
/* 256 */     int v_1 = this.limit - this.cursor;
/*     */     
/* 258 */     if (this.cursor < this.I_p1)
/*     */     {
/* 260 */       return false;
/*     */     }
/* 262 */     this.cursor = this.I_p1;
/* 263 */     int v_2 = this.limit_backward;
/* 264 */     this.limit_backward = this.cursor;
/* 265 */     this.cursor = (this.limit - v_1);
/*     */     
/*     */ 
/* 268 */     this.ket = this.cursor;
/*     */     
/* 270 */     int among_var = find_among_b(a_2, 5);
/* 271 */     if (among_var == 0)
/*     */     {
/* 273 */       this.limit_backward = v_2;
/* 274 */       return false;
/*     */     }
/*     */     
/* 277 */     this.bra = this.cursor;
/* 278 */     switch (among_var) {
/*     */     case 0: 
/* 280 */       this.limit_backward = v_2;
/* 281 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 285 */       slice_del();
/* 286 */       break;
/*     */     
/*     */ 
/*     */     case 2: 
/* 290 */       slice_from("lös");
/* 291 */       break;
/*     */     
/*     */ 
/*     */     case 3: 
/* 295 */       slice_from("full");
/*     */     }
/*     */     
/* 298 */     this.limit_backward = v_2;
/* 299 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean stem()
/*     */   {
/* 309 */     int v_1 = this.cursor;
/*     */     
/*     */ 
/* 312 */     if (!r_mark_regions()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 317 */     this.cursor = v_1;
/*     */     
/* 319 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*     */     
/*     */ 
/* 322 */     int v_2 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 325 */     if (!r_main_suffix()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 330 */     this.cursor = (this.limit - v_2);
/*     */     
/* 332 */     int v_3 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 335 */     if (!r_consonant_pair()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 340 */     this.cursor = (this.limit - v_3);
/*     */     
/* 342 */     int v_4 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 345 */     if (!r_other_suffix()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 350 */     this.cursor = (this.limit - v_4);
/* 351 */     this.cursor = this.limit_backward;return true;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o) {
/* 355 */     return o instanceof swedishStemmer;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 359 */     return swedishStemmer.class.getName().hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\swedishStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */