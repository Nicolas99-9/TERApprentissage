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
/*     */ public class germanStemmer
/*     */   extends SnowballStemmer
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  16 */   private static final germanStemmer methodObject = new germanStemmer();
/*     */   
/*  18 */   private static final Among[] a_0 = {
/*  19 */     new Among("", -1, 6, "", methodObject), 
/*  20 */     new Among("U", 0, 2, "", methodObject), 
/*  21 */     new Among("Y", 0, 1, "", methodObject), 
/*  22 */     new Among("ä", 0, 3, "", methodObject), 
/*  23 */     new Among("ö", 0, 4, "", methodObject), 
/*  24 */     new Among("ü", 0, 5, "", methodObject) };
/*     */   
/*     */ 
/*  27 */   private static final Among[] a_1 = {
/*  28 */     new Among("e", -1, 1, "", methodObject), 
/*  29 */     new Among("em", -1, 1, "", methodObject), 
/*  30 */     new Among("en", -1, 1, "", methodObject), 
/*  31 */     new Among("ern", -1, 1, "", methodObject), 
/*  32 */     new Among("er", -1, 1, "", methodObject), 
/*  33 */     new Among("s", -1, 2, "", methodObject), 
/*  34 */     new Among("es", 5, 1, "", methodObject) };
/*     */   
/*     */ 
/*  37 */   private static final Among[] a_2 = {
/*  38 */     new Among("en", -1, 1, "", methodObject), 
/*  39 */     new Among("er", -1, 1, "", methodObject), 
/*  40 */     new Among("st", -1, 2, "", methodObject), 
/*  41 */     new Among("est", 2, 1, "", methodObject) };
/*     */   
/*     */ 
/*  44 */   private static final Among[] a_3 = {
/*  45 */     new Among("ig", -1, 1, "", methodObject), 
/*  46 */     new Among("lich", -1, 1, "", methodObject) };
/*     */   
/*     */ 
/*  49 */   private static final Among[] a_4 = {
/*  50 */     new Among("end", -1, 1, "", methodObject), 
/*  51 */     new Among("ig", -1, 2, "", methodObject), 
/*  52 */     new Among("ung", -1, 1, "", methodObject), 
/*  53 */     new Among("lich", -1, 3, "", methodObject), 
/*  54 */     new Among("isch", -1, 2, "", methodObject), 
/*  55 */     new Among("ik", -1, 2, "", methodObject), 
/*  56 */     new Among("heit", -1, 3, "", methodObject), 
/*  57 */     new Among("keit", -1, 4, "", methodObject) };
/*     */   
/*     */ 
/*  60 */   private static final char[] g_v = { '\021', 'A', '\020', '\001', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\b', '\000', ' ', '\b' };
/*     */   
/*  62 */   private static final char[] g_s_ending = { 'u', '\036', '\005' };
/*     */   
/*  64 */   private static final char[] g_st_ending = { 'u', '\036', '\004' };
/*     */   private int I_x;
/*     */   private int I_p2;
/*     */   private int I_p1;
/*     */   
/*     */   private void copy_from(germanStemmer other)
/*     */   {
/*  71 */     this.I_x = other.I_x;
/*  72 */     this.I_p2 = other.I_p2;
/*  73 */     this.I_p1 = other.I_p1;
/*  74 */     super.copy_from(other);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_prelude()
/*     */   {
/*  86 */     int v_1 = this.cursor;
/*     */     int v_2;
/*     */     for (;;)
/*     */     {
/*  90 */       v_2 = this.cursor;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  95 */       int v_3 = this.cursor;
/*     */       
/*     */ 
/*     */ 
/*  99 */       this.bra = this.cursor;
/*     */       
/* 101 */       if (eq_s(1, "ß"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 106 */         this.ket = this.cursor;
/*     */         
/* 108 */         slice_from("ss");
/*     */       }
/*     */       else {
/* 111 */         this.cursor = v_3;
/*     */         
/* 113 */         if (this.cursor >= this.limit) {
/*     */           break;
/*     */         }
/*     */         
/* 117 */         this.cursor += 1;
/*     */       }
/*     */     }
/*     */     
/* 121 */     this.cursor = v_2;
/*     */     
/*     */ 
/* 124 */     this.cursor = v_1;
/*     */     
/*     */ 
/*     */ 
/* 128 */     int v_4 = this.cursor;
/*     */     
/*     */ 
/*     */     for (;;)
/*     */     {
/* 133 */       int v_5 = this.cursor;
/*     */       
/*     */ 
/* 136 */       if (in_grouping(g_v, 97, 252))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 141 */         this.bra = this.cursor;
/*     */         
/*     */ 
/* 144 */         int v_6 = this.cursor;
/*     */         
/*     */ 
/*     */ 
/* 148 */         if (eq_s(1, "u"))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 153 */           this.ket = this.cursor;
/* 154 */           if (in_grouping(g_v, 97, 252))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 159 */             slice_from("U");
/*     */             break label238;
/*     */           } }
/* 162 */         this.cursor = v_6;
/*     */         
/*     */ 
/* 165 */         if (eq_s(1, "y"))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 170 */           this.ket = this.cursor;
/* 171 */           if (in_grouping(g_v, 97, 252))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 176 */             slice_from("Y");
/*     */             label238:
/* 178 */             this.cursor = v_5;
/* 179 */             break;
/*     */           } } }
/* 181 */       this.cursor = v_5;
/* 182 */       if (this.cursor >= this.limit) {
/*     */         break label280;
/*     */       }
/*     */       
/* 186 */       this.cursor += 1;
/*     */     }
/*     */     label280:
/*     */     int v_5;
/* 190 */     this.cursor = v_4;
/*     */     
/*     */ 
/* 193 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean r_mark_regions()
/*     */   {
/* 199 */     this.I_p1 = this.limit;
/* 200 */     this.I_p2 = this.limit;
/*     */     
/* 202 */     int v_1 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 206 */     int c = this.cursor + 3;
/* 207 */     if ((c < 0) || (c > this.limit))
/*     */     {
/* 209 */       return false;
/*     */     }
/* 211 */     this.cursor = c;
/*     */     
/*     */ 
/* 214 */     this.I_x = this.cursor;
/* 215 */     this.cursor = v_1;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 220 */     while (!in_grouping(g_v, 97, 252))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 226 */       if (this.cursor >= this.limit)
/*     */       {
/* 228 */         return false;
/*     */       }
/* 230 */       this.cursor += 1;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 236 */     while (!out_grouping(g_v, 97, 252))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 242 */       if (this.cursor >= this.limit)
/*     */       {
/* 244 */         return false;
/*     */       }
/* 246 */       this.cursor += 1;
/*     */     }
/*     */     
/* 249 */     this.I_p1 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 253 */     if (this.I_p1 < this.I_x)
/*     */     {
/*     */ 
/*     */ 
/* 257 */       this.I_p1 = this.I_x;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 263 */     while (!in_grouping(g_v, 97, 252))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 269 */       if (this.cursor >= this.limit)
/*     */       {
/* 271 */         return false;
/*     */       }
/* 273 */       this.cursor += 1;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 279 */     while (!out_grouping(g_v, 97, 252))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 285 */       if (this.cursor >= this.limit)
/*     */       {
/* 287 */         return false;
/*     */       }
/* 289 */       this.cursor += 1;
/*     */     }
/*     */     
/* 292 */     this.I_p2 = this.cursor;
/* 293 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean r_postlude()
/*     */   {
/*     */     int v_1;
/*     */     for (;;)
/*     */     {
/* 302 */       v_1 = this.cursor;
/*     */       
/*     */ 
/*     */ 
/* 306 */       this.bra = this.cursor;
/*     */       
/* 308 */       int among_var = find_among(a_0, 6);
/* 309 */       if (among_var == 0) {
/*     */         break;
/*     */       }
/*     */       
/*     */ 
/* 314 */       this.ket = this.cursor;
/* 315 */       switch (among_var)
/*     */       {
/*     */       case 0: 
/*     */         break;
/*     */       
/*     */       case 1: 
/* 321 */         slice_from("y");
/* 322 */         break;
/*     */       
/*     */ 
/*     */       case 2: 
/* 326 */         slice_from("u");
/* 327 */         break;
/*     */       
/*     */ 
/*     */       case 3: 
/* 331 */         slice_from("a");
/* 332 */         break;
/*     */       
/*     */ 
/*     */       case 4: 
/* 336 */         slice_from("o");
/* 337 */         break;
/*     */       
/*     */ 
/*     */       case 5: 
/* 341 */         slice_from("u");
/* 342 */         break;
/*     */       
/*     */ 
/*     */       case 6: 
/* 346 */         if (this.cursor >= this.limit) {
/*     */           break label155;
/*     */         }
/*     */         
/* 350 */         this.cursor += 1;
/*     */       }
/*     */       
/*     */     }
/*     */     label155:
/* 355 */     this.cursor = v_1;
/*     */     
/*     */ 
/* 358 */     return true;
/*     */   }
/*     */   
/*     */   private boolean r_R1() {
/* 362 */     if (this.I_p1 > this.cursor)
/*     */     {
/* 364 */       return false;
/*     */     }
/* 366 */     return true;
/*     */   }
/*     */   
/*     */   private boolean r_R2() {
/* 370 */     if (this.I_p2 > this.cursor)
/*     */     {
/* 372 */       return false;
/*     */     }
/* 374 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_standard_suffix()
/*     */   {
/* 390 */     int v_1 = this.limit - this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 394 */     this.ket = this.cursor;
/*     */     
/* 396 */     int among_var = find_among_b(a_1, 7);
/* 397 */     if (among_var != 0)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 402 */       this.bra = this.cursor;
/*     */       
/* 404 */       if (r_R1())
/*     */       {
/*     */ 
/*     */ 
/* 408 */         switch (among_var)
/*     */         {
/*     */         case 0: 
/*     */           break;
/*     */         
/*     */         case 1: 
/* 414 */           slice_del();
/* 415 */           break;
/*     */         
/*     */         case 2: 
/* 418 */           if (in_grouping_b(g_s_ending, 98, 116))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 423 */             slice_del(); }
/*     */           break;
/*     */         } }
/*     */     }
/* 427 */     this.cursor = (this.limit - v_1);
/*     */     
/* 429 */     int v_2 = this.limit - this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 433 */     this.ket = this.cursor;
/*     */     
/* 435 */     among_var = find_among_b(a_2, 4);
/* 436 */     if (among_var != 0)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 441 */       this.bra = this.cursor;
/*     */       
/* 443 */       if (r_R1())
/*     */       {
/*     */ 
/*     */ 
/* 447 */         switch (among_var)
/*     */         {
/*     */         case 0: 
/*     */           break;
/*     */         
/*     */         case 1: 
/* 453 */           slice_del();
/* 454 */           break;
/*     */         
/*     */         case 2: 
/* 457 */           if (in_grouping_b(g_st_ending, 98, 116))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 463 */             int c = this.cursor - 3;
/* 464 */             if ((this.limit_backward <= c) && (c <= this.limit))
/*     */             {
/*     */ 
/*     */ 
/* 468 */               this.cursor = c;
/*     */               
/*     */ 
/* 471 */               slice_del();
/*     */             }
/*     */           }
/*     */           break; } } }
/* 475 */     this.cursor = (this.limit - v_2);
/*     */     
/* 477 */     int v_3 = this.limit - this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 481 */     this.ket = this.cursor;
/*     */     
/* 483 */     among_var = find_among_b(a_4, 8);
/* 484 */     if (among_var != 0)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 489 */       this.bra = this.cursor;
/*     */       
/* 491 */       if (r_R2())
/*     */       {
/*     */ 
/*     */ 
/* 495 */         switch (among_var)
/*     */         {
/*     */         case 0: 
/*     */           break;
/*     */         
/*     */         case 1: 
/* 501 */           slice_del();
/*     */           
/* 503 */           int v_4 = this.limit - this.cursor;
/*     */           
/*     */ 
/*     */ 
/* 507 */           this.ket = this.cursor;
/*     */           
/* 509 */           if (!eq_s_b(2, "ig"))
/*     */           {
/* 511 */             this.cursor = (this.limit - v_4);
/*     */           }
/*     */           else
/*     */           {
/* 515 */             this.bra = this.cursor;
/*     */             
/*     */ 
/* 518 */             int v_5 = this.limit - this.cursor;
/*     */             
/*     */ 
/* 521 */             if (eq_s_b(1, "e"))
/*     */             {
/*     */ 
/*     */ 
/* 525 */               this.cursor = (this.limit - v_4);
/*     */             }
/*     */             else {
/* 528 */               this.cursor = (this.limit - v_5);
/*     */               
/*     */ 
/* 531 */               if (!r_R2())
/*     */               {
/* 533 */                 this.cursor = (this.limit - v_4);
/*     */               }
/*     */               else
/*     */               {
/* 537 */                 slice_del(); }
/*     */             } }
/* 539 */           break;
/*     */         
/*     */ 
/*     */ 
/*     */         case 2: 
/* 544 */           int v_6 = this.limit - this.cursor;
/*     */           
/*     */ 
/* 547 */           if (!eq_s_b(1, "e"))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 553 */             this.cursor = (this.limit - v_6);
/*     */             
/*     */ 
/* 556 */             slice_del(); }
/* 557 */           break;
/*     */         
/*     */ 
/*     */         case 3: 
/* 561 */           slice_del();
/*     */           
/* 563 */           int v_7 = this.limit - this.cursor;
/*     */           
/*     */ 
/*     */ 
/* 567 */           this.ket = this.cursor;
/*     */           
/*     */ 
/* 570 */           int v_8 = this.limit - this.cursor;
/*     */           
/*     */ 
/* 573 */           if (!eq_s_b(2, "er"))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 579 */             this.cursor = (this.limit - v_8);
/*     */             
/* 581 */             if (!eq_s_b(2, "en"))
/*     */             {
/* 583 */               this.cursor = (this.limit - v_7);
/* 584 */               break;
/*     */             }
/*     */           }
/*     */           
/* 588 */           this.bra = this.cursor;
/*     */           
/* 590 */           if (!r_R1())
/*     */           {
/* 592 */             this.cursor = (this.limit - v_7);
/*     */           }
/*     */           else
/*     */           {
/* 596 */             slice_del();
/*     */           }
/* 598 */           break;
/*     */         
/*     */ 
/*     */         case 4: 
/* 602 */           slice_del();
/*     */           
/* 604 */           int v_9 = this.limit - this.cursor;
/*     */           
/*     */ 
/*     */ 
/* 608 */           this.ket = this.cursor;
/*     */           
/* 610 */           among_var = find_among_b(a_3, 2);
/* 611 */           if (among_var == 0)
/*     */           {
/* 613 */             this.cursor = (this.limit - v_9);
/*     */           }
/*     */           else
/*     */           {
/* 617 */             this.bra = this.cursor;
/*     */             
/* 619 */             if (!r_R2())
/*     */             {
/* 621 */               this.cursor = (this.limit - v_9);
/*     */             }
/*     */             else
/* 624 */               switch (among_var) {
/*     */               case 0: 
/* 626 */                 this.cursor = (this.limit - v_9);
/* 627 */                 break;
/*     */               
/*     */ 
/*     */               case 1: 
/* 631 */                 slice_del();
/*     */               }
/*     */           }
/*     */           break;
/*     */         }
/*     */       }
/*     */     }
/* 638 */     this.cursor = (this.limit - v_3);
/* 639 */     return true;
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
/* 650 */     int v_1 = this.cursor;
/*     */     
/*     */ 
/* 653 */     if (!r_prelude()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 658 */     this.cursor = v_1;
/*     */     
/* 660 */     int v_2 = this.cursor;
/*     */     
/*     */ 
/* 663 */     if (!r_mark_regions()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 668 */     this.cursor = v_2;
/*     */     
/* 670 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*     */     
/* 672 */     int v_3 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 675 */     if (!r_standard_suffix()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 680 */     this.cursor = (this.limit - v_3);
/* 681 */     this.cursor = this.limit_backward;
/* 682 */     int v_4 = this.cursor;
/*     */     
/*     */ 
/* 685 */     if (!r_postlude()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 690 */     this.cursor = v_4;
/* 691 */     return true;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 696 */     return o instanceof germanStemmer;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 701 */     return germanStemmer.class.getName().hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\germanStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */