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
/*     */ public class dutchStemmer
/*     */   extends SnowballStemmer
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  16 */   private static final dutchStemmer methodObject = new dutchStemmer();
/*     */   
/*  18 */   private static final Among[] a_0 = {
/*  19 */     new Among("", -1, 6, "", methodObject), 
/*  20 */     new Among("á", 0, 1, "", methodObject), 
/*  21 */     new Among("ä", 0, 1, "", methodObject), 
/*  22 */     new Among("é", 0, 2, "", methodObject), 
/*  23 */     new Among("ë", 0, 2, "", methodObject), 
/*  24 */     new Among("í", 0, 3, "", methodObject), 
/*  25 */     new Among("ï", 0, 3, "", methodObject), 
/*  26 */     new Among("ó", 0, 4, "", methodObject), 
/*  27 */     new Among("ö", 0, 4, "", methodObject), 
/*  28 */     new Among("ú", 0, 5, "", methodObject), 
/*  29 */     new Among("ü", 0, 5, "", methodObject) };
/*     */   
/*     */ 
/*  32 */   private static final Among[] a_1 = {
/*  33 */     new Among("", -1, 3, "", methodObject), 
/*  34 */     new Among("I", 0, 2, "", methodObject), 
/*  35 */     new Among("Y", 0, 1, "", methodObject) };
/*     */   
/*     */ 
/*  38 */   private static final Among[] a_2 = {
/*  39 */     new Among("dd", -1, -1, "", methodObject), 
/*  40 */     new Among("kk", -1, -1, "", methodObject), 
/*  41 */     new Among("tt", -1, -1, "", methodObject) };
/*     */   
/*     */ 
/*  44 */   private static final Among[] a_3 = {
/*  45 */     new Among("ene", -1, 2, "", methodObject), 
/*  46 */     new Among("se", -1, 3, "", methodObject), 
/*  47 */     new Among("en", -1, 2, "", methodObject), 
/*  48 */     new Among("heden", 2, 1, "", methodObject), 
/*  49 */     new Among("s", -1, 3, "", methodObject) };
/*     */   
/*     */ 
/*  52 */   private static final Among[] a_4 = {
/*  53 */     new Among("end", -1, 1, "", methodObject), 
/*  54 */     new Among("ig", -1, 2, "", methodObject), 
/*  55 */     new Among("ing", -1, 1, "", methodObject), 
/*  56 */     new Among("lijk", -1, 3, "", methodObject), 
/*  57 */     new Among("baar", -1, 4, "", methodObject), 
/*  58 */     new Among("bar", -1, 5, "", methodObject) };
/*     */   
/*     */ 
/*  61 */   private static final Among[] a_5 = {
/*  62 */     new Among("aa", -1, -1, "", methodObject), 
/*  63 */     new Among("ee", -1, -1, "", methodObject), 
/*  64 */     new Among("oo", -1, -1, "", methodObject), 
/*  65 */     new Among("uu", -1, -1, "", methodObject) };
/*     */   
/*     */ 
/*  68 */   private static final char[] g_v = { '\021', 'A', '\020', '\001', '\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''' };
/*     */   
/*  70 */   private static final char[] g_v_I = { '\001', '\000', '\000', '\021', 'A', '\020', '\001', '\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''' };
/*     */   
/*  72 */   private static final char[] g_v_j = { '\021', 'C', '\020', '\001', '\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''' };
/*     */   private int I_p2;
/*     */   private int I_p1;
/*     */   private boolean B_e_found;
/*     */   
/*     */   private void copy_from(dutchStemmer other)
/*     */   {
/*  79 */     this.I_p2 = other.I_p2;
/*  80 */     this.I_p1 = other.I_p1;
/*  81 */     this.B_e_found = other.B_e_found;
/*  82 */     super.copy_from(other);
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
/*     */   private boolean r_prelude()
/*     */   {
/*  95 */     int v_1 = this.cursor;
/*     */     int v_2;
/*     */     for (;;)
/*     */     {
/*  99 */       v_2 = this.cursor;
/*     */       
/*     */ 
/*     */ 
/* 103 */       this.bra = this.cursor;
/*     */       
/* 105 */       int among_var = find_among(a_0, 11);
/* 106 */       if (among_var == 0) {
/*     */         break;
/*     */       }
/*     */       
/*     */ 
/* 111 */       this.ket = this.cursor;
/* 112 */       switch (among_var)
/*     */       {
/*     */       case 0: 
/*     */         break;
/*     */       
/*     */       case 1: 
/* 118 */         slice_from("a");
/* 119 */         break;
/*     */       
/*     */ 
/*     */       case 2: 
/* 123 */         slice_from("e");
/* 124 */         break;
/*     */       
/*     */ 
/*     */       case 3: 
/* 128 */         slice_from("i");
/* 129 */         break;
/*     */       
/*     */ 
/*     */       case 4: 
/* 133 */         slice_from("o");
/* 134 */         break;
/*     */       
/*     */ 
/*     */       case 5: 
/* 138 */         slice_from("u");
/* 139 */         break;
/*     */       
/*     */ 
/*     */       case 6: 
/* 143 */         if (this.cursor >= this.limit) {
/*     */           break label163;
/*     */         }
/*     */         
/* 147 */         this.cursor += 1;
/*     */       }
/*     */       
/*     */     }
/*     */     label163:
/* 152 */     this.cursor = v_2;
/*     */     
/*     */ 
/* 155 */     this.cursor = v_1;
/*     */     
/* 157 */     int v_3 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 161 */     this.bra = this.cursor;
/*     */     
/* 163 */     if (!eq_s(1, "y"))
/*     */     {
/* 165 */       this.cursor = v_3;
/*     */     }
/*     */     else
/*     */     {
/* 169 */       this.ket = this.cursor;
/*     */       
/* 171 */       slice_from("Y");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 176 */     int v_4 = this.cursor;
/*     */     
/*     */ 
/*     */     for (;;)
/*     */     {
/* 181 */       int v_5 = this.cursor;
/*     */       
/*     */ 
/* 184 */       if (in_grouping(g_v, 97, 232))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 189 */         this.bra = this.cursor;
/*     */         
/*     */ 
/* 192 */         int v_6 = this.cursor;
/*     */         
/*     */ 
/*     */ 
/* 196 */         if (eq_s(1, "i"))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 201 */           this.ket = this.cursor;
/* 202 */           if (in_grouping(g_v, 97, 232))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 207 */             slice_from("I");
/*     */             break label345;
/*     */           } }
/* 210 */         this.cursor = v_6;
/*     */         
/*     */ 
/* 213 */         if (eq_s(1, "y"))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 218 */           this.ket = this.cursor;
/*     */           
/* 220 */           slice_from("Y");
/*     */           label345:
/* 222 */           this.cursor = v_5;
/* 223 */           break;
/*     */         } }
/* 225 */       this.cursor = v_5;
/* 226 */       if (this.cursor >= this.limit) {
/*     */         break label387;
/*     */       }
/*     */       
/* 230 */       this.cursor += 1;
/*     */     }
/*     */     label387:
/*     */     int v_5;
/* 234 */     this.cursor = v_4;
/*     */     
/*     */ 
/* 237 */     return true;
/*     */   }
/*     */   
/*     */   private boolean r_mark_regions()
/*     */   {
/* 242 */     this.I_p1 = this.limit;
/* 243 */     this.I_p2 = this.limit;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 248 */     while (!in_grouping(g_v, 97, 232))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 254 */       if (this.cursor >= this.limit)
/*     */       {
/* 256 */         return false;
/*     */       }
/* 258 */       this.cursor += 1;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 264 */     while (!out_grouping(g_v, 97, 232))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 270 */       if (this.cursor >= this.limit)
/*     */       {
/* 272 */         return false;
/*     */       }
/* 274 */       this.cursor += 1;
/*     */     }
/*     */     
/* 277 */     this.I_p1 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 281 */     if (this.I_p1 < 3)
/*     */     {
/*     */ 
/*     */ 
/* 285 */       this.I_p1 = 3;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 291 */     while (!in_grouping(g_v, 97, 232))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 297 */       if (this.cursor >= this.limit)
/*     */       {
/* 299 */         return false;
/*     */       }
/* 301 */       this.cursor += 1;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 307 */     while (!out_grouping(g_v, 97, 232))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 313 */       if (this.cursor >= this.limit)
/*     */       {
/* 315 */         return false;
/*     */       }
/* 317 */       this.cursor += 1;
/*     */     }
/*     */     
/* 320 */     this.I_p2 = this.cursor;
/* 321 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean r_postlude()
/*     */   {
/*     */     int v_1;
/*     */     for (;;)
/*     */     {
/* 330 */       v_1 = this.cursor;
/*     */       
/*     */ 
/*     */ 
/* 334 */       this.bra = this.cursor;
/*     */       
/* 336 */       int among_var = find_among(a_1, 3);
/* 337 */       if (among_var == 0) {
/*     */         break;
/*     */       }
/*     */       
/*     */ 
/* 342 */       this.ket = this.cursor;
/* 343 */       switch (among_var)
/*     */       {
/*     */       case 0: 
/*     */         break;
/*     */       
/*     */       case 1: 
/* 349 */         slice_from("y");
/* 350 */         break;
/*     */       
/*     */ 
/*     */       case 2: 
/* 354 */         slice_from("i");
/* 355 */         break;
/*     */       
/*     */ 
/*     */       case 3: 
/* 359 */         if (this.cursor >= this.limit) {
/*     */           break label116;
/*     */         }
/*     */         
/* 363 */         this.cursor += 1;
/*     */       }
/*     */       
/*     */     }
/*     */     label116:
/* 368 */     this.cursor = v_1;
/*     */     
/*     */ 
/* 371 */     return true;
/*     */   }
/*     */   
/*     */   private boolean r_R1() {
/* 375 */     if (this.I_p1 > this.cursor)
/*     */     {
/* 377 */       return false;
/*     */     }
/* 379 */     return true;
/*     */   }
/*     */   
/*     */   private boolean r_R2() {
/* 383 */     if (this.I_p2 > this.cursor)
/*     */     {
/* 385 */       return false;
/*     */     }
/* 387 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean r_undouble()
/*     */   {
/* 394 */     int v_1 = this.limit - this.cursor;
/*     */     
/* 396 */     if (find_among_b(a_2, 3) == 0)
/*     */     {
/* 398 */       return false;
/*     */     }
/* 400 */     this.cursor = (this.limit - v_1);
/*     */     
/* 402 */     this.ket = this.cursor;
/*     */     
/* 404 */     if (this.cursor <= this.limit_backward)
/*     */     {
/* 406 */       return false;
/*     */     }
/* 408 */     this.cursor -= 1;
/*     */     
/* 410 */     this.bra = this.cursor;
/*     */     
/* 412 */     slice_del();
/* 413 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean r_e_ending()
/*     */   {
/* 420 */     this.B_e_found = false;
/*     */     
/* 422 */     this.ket = this.cursor;
/*     */     
/* 424 */     if (!eq_s_b(1, "e"))
/*     */     {
/* 426 */       return false;
/*     */     }
/*     */     
/* 429 */     this.bra = this.cursor;
/*     */     
/* 431 */     if (!r_R1())
/*     */     {
/* 433 */       return false;
/*     */     }
/*     */     
/* 436 */     int v_1 = this.limit - this.cursor;
/* 437 */     if (!out_grouping_b(g_v, 97, 232))
/*     */     {
/* 439 */       return false;
/*     */     }
/* 441 */     this.cursor = (this.limit - v_1);
/*     */     
/* 443 */     slice_del();
/*     */     
/* 445 */     this.B_e_found = true;
/*     */     
/* 447 */     if (!r_undouble())
/*     */     {
/* 449 */       return false;
/*     */     }
/* 451 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_en_ending()
/*     */   {
/* 459 */     if (!r_R1())
/*     */     {
/* 461 */       return false;
/*     */     }
/*     */     
/* 464 */     int v_1 = this.limit - this.cursor;
/* 465 */     if (!out_grouping_b(g_v, 97, 232))
/*     */     {
/* 467 */       return false;
/*     */     }
/* 469 */     this.cursor = (this.limit - v_1);
/*     */     
/*     */ 
/* 472 */     int v_2 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 475 */     if (eq_s_b(3, "gem"))
/*     */     {
/*     */ 
/*     */ 
/* 479 */       return false;
/*     */     }
/* 481 */     this.cursor = (this.limit - v_2);
/*     */     
/*     */ 
/* 484 */     slice_del();
/*     */     
/* 486 */     if (!r_undouble())
/*     */     {
/* 488 */       return false;
/*     */     }
/* 490 */     return true;
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
/*     */ 
/*     */   private boolean r_standard_suffix()
/*     */   {
/* 507 */     int v_1 = this.limit - this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 511 */     this.ket = this.cursor;
/*     */     
/* 513 */     int among_var = find_among_b(a_3, 5);
/* 514 */     if (among_var != 0)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 519 */       this.bra = this.cursor;
/* 520 */       switch (among_var)
/*     */       {
/*     */       case 0: 
/*     */         break;
/*     */       
/*     */       case 1: 
/* 526 */         if (r_R1())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 531 */           slice_from("heid"); }
/* 532 */         break;
/*     */       
/*     */ 
/*     */       case 2: 
/* 536 */         if (r_en_ending())
/*     */           break;
/* 538 */       case 3:  if ((goto 136) && 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 544 */           (r_R1()))
/*     */         {
/*     */ 
/*     */ 
/* 548 */           if (out_grouping_b(g_v_j, 97, 232))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 553 */             slice_del(); } }
/*     */         break;
/*     */       }
/*     */     }
/* 557 */     this.cursor = (this.limit - v_1);
/*     */     
/* 559 */     int v_2 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 562 */     if (!r_e_ending()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 567 */     this.cursor = (this.limit - v_2);
/*     */     
/* 569 */     int v_3 = this.limit - this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 573 */     this.ket = this.cursor;
/*     */     
/* 575 */     if (eq_s_b(4, "heid"))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 580 */       this.bra = this.cursor;
/*     */       
/* 582 */       if (r_R2())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 588 */         int v_4 = this.limit - this.cursor;
/*     */         
/*     */ 
/* 591 */         if (!eq_s_b(1, "c"))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 597 */           this.cursor = (this.limit - v_4);
/*     */           
/*     */ 
/* 600 */           slice_del();
/*     */           
/* 602 */           this.ket = this.cursor;
/*     */           
/* 604 */           if (eq_s_b(2, "en"))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 609 */             this.bra = this.cursor;
/*     */             
/* 611 */             if (r_en_ending()) {}
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 616 */     this.cursor = (this.limit - v_3);
/*     */     
/* 618 */     int v_5 = this.limit - this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 622 */     this.ket = this.cursor;
/*     */     
/* 624 */     among_var = find_among_b(a_4, 6);
/* 625 */     if (among_var != 0)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 630 */       this.bra = this.cursor;
/* 631 */       switch (among_var)
/*     */       {
/*     */       case 0: 
/*     */         break;
/*     */       
/*     */       case 1: 
/* 637 */         if (r_R2())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 642 */           slice_del();
/*     */           
/*     */ 
/* 645 */           int v_6 = this.limit - this.cursor;
/*     */           
/*     */ 
/*     */ 
/* 649 */           this.ket = this.cursor;
/*     */           
/* 651 */           if (eq_s_b(2, "ig"))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 656 */             this.bra = this.cursor;
/*     */             
/* 658 */             if (r_R2())
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 664 */               int v_7 = this.limit - this.cursor;
/*     */               
/*     */ 
/* 667 */               if (!eq_s_b(1, "e"))
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 673 */                 this.cursor = (this.limit - v_7);
/*     */                 
/*     */ 
/* 676 */                 slice_del();
/* 677 */                 break;
/*     */               } } }
/* 679 */           this.cursor = (this.limit - v_6);
/*     */           
/* 681 */           if (r_undouble()) break;
/*     */         }
/*     */         break; case 2:  if ((goto 629) && 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 690 */           (r_R2()))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 696 */           int v_8 = this.limit - this.cursor;
/*     */           
/*     */ 
/* 699 */           if (!eq_s_b(1, "e"))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 705 */             this.cursor = (this.limit - v_8);
/*     */             
/*     */ 
/* 708 */             slice_del(); } }
/* 709 */         break;
/*     */       
/*     */ 
/*     */       case 3: 
/* 713 */         if (r_R2())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 718 */           slice_del();
/*     */           
/* 720 */           if (r_e_ending()) break;
/*     */         }
/*     */         break; case 4:  if ((goto 629) && 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 728 */           (r_R2()))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 733 */           slice_del(); }
/* 734 */         break;
/*     */       
/*     */ 
/*     */       case 5: 
/* 738 */         if (r_R2())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 743 */           if (this.B_e_found)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 748 */             slice_del(); } }
/*     */         break;
/*     */       }
/*     */     }
/* 752 */     this.cursor = (this.limit - v_5);
/*     */     
/* 754 */     int v_9 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 757 */     if (out_grouping_b(g_v_I, 73, 232))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 762 */       int v_10 = this.limit - this.cursor;
/*     */       
/*     */ 
/* 765 */       if (find_among_b(a_5, 4) != 0)
/*     */       {
/*     */ 
/*     */ 
/* 769 */         if (out_grouping_b(g_v, 97, 232))
/*     */         {
/*     */ 
/*     */ 
/* 773 */           this.cursor = (this.limit - v_10);
/*     */           
/* 775 */           this.ket = this.cursor;
/*     */           
/* 777 */           if (this.cursor > this.limit_backward)
/*     */           {
/*     */ 
/*     */ 
/* 781 */             this.cursor -= 1;
/*     */             
/* 783 */             this.bra = this.cursor;
/*     */             
/* 785 */             slice_del();
/*     */           } } } }
/* 787 */     this.cursor = (this.limit - v_9);
/* 788 */     return true;
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
/* 799 */     int v_1 = this.cursor;
/*     */     
/*     */ 
/* 802 */     if (!r_prelude()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 807 */     this.cursor = v_1;
/*     */     
/* 809 */     int v_2 = this.cursor;
/*     */     
/*     */ 
/* 812 */     if (!r_mark_regions()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 817 */     this.cursor = v_2;
/*     */     
/* 819 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*     */     
/* 821 */     int v_3 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 824 */     if (!r_standard_suffix()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 829 */     this.cursor = (this.limit - v_3);
/* 830 */     this.cursor = this.limit_backward;
/* 831 */     int v_4 = this.cursor;
/*     */     
/*     */ 
/* 834 */     if (!r_postlude()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 839 */     this.cursor = v_4;
/* 840 */     return true;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o)
/*     */   {
/* 845 */     return o instanceof dutchStemmer;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 850 */     return dutchStemmer.class.getName().hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\dutchStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */