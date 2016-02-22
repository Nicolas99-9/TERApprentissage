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
/*     */ public class porterStemmer
/*     */   extends SnowballStemmer
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  16 */   private static final porterStemmer methodObject = new porterStemmer();
/*     */   
/*  18 */   private static final Among[] a_0 = {
/*  19 */     new Among("s", -1, 3, "", methodObject), 
/*  20 */     new Among("ies", 0, 2, "", methodObject), 
/*  21 */     new Among("sses", 0, 1, "", methodObject), 
/*  22 */     new Among("ss", 0, -1, "", methodObject) };
/*     */   
/*     */ 
/*  25 */   private static final Among[] a_1 = {
/*  26 */     new Among("", -1, 3, "", methodObject), 
/*  27 */     new Among("bb", 0, 2, "", methodObject), 
/*  28 */     new Among("dd", 0, 2, "", methodObject), 
/*  29 */     new Among("ff", 0, 2, "", methodObject), 
/*  30 */     new Among("gg", 0, 2, "", methodObject), 
/*  31 */     new Among("bl", 0, 1, "", methodObject), 
/*  32 */     new Among("mm", 0, 2, "", methodObject), 
/*  33 */     new Among("nn", 0, 2, "", methodObject), 
/*  34 */     new Among("pp", 0, 2, "", methodObject), 
/*  35 */     new Among("rr", 0, 2, "", methodObject), 
/*  36 */     new Among("at", 0, 1, "", methodObject), 
/*  37 */     new Among("tt", 0, 2, "", methodObject), 
/*  38 */     new Among("iz", 0, 1, "", methodObject) };
/*     */   
/*     */ 
/*  41 */   private static final Among[] a_2 = {
/*  42 */     new Among("ed", -1, 2, "", methodObject), 
/*  43 */     new Among("eed", 0, 1, "", methodObject), 
/*  44 */     new Among("ing", -1, 2, "", methodObject) };
/*     */   
/*     */ 
/*  47 */   private static final Among[] a_3 = {
/*  48 */     new Among("anci", -1, 3, "", methodObject), 
/*  49 */     new Among("enci", -1, 2, "", methodObject), 
/*  50 */     new Among("abli", -1, 4, "", methodObject), 
/*  51 */     new Among("eli", -1, 6, "", methodObject), 
/*  52 */     new Among("alli", -1, 9, "", methodObject), 
/*  53 */     new Among("ousli", -1, 12, "", methodObject), 
/*  54 */     new Among("entli", -1, 5, "", methodObject), 
/*  55 */     new Among("aliti", -1, 10, "", methodObject), 
/*  56 */     new Among("biliti", -1, 14, "", methodObject), 
/*  57 */     new Among("iviti", -1, 13, "", methodObject), 
/*  58 */     new Among("tional", -1, 1, "", methodObject), 
/*  59 */     new Among("ational", 10, 8, "", methodObject), 
/*  60 */     new Among("alism", -1, 10, "", methodObject), 
/*  61 */     new Among("ation", -1, 8, "", methodObject), 
/*  62 */     new Among("ization", 13, 7, "", methodObject), 
/*  63 */     new Among("izer", -1, 7, "", methodObject), 
/*  64 */     new Among("ator", -1, 8, "", methodObject), 
/*  65 */     new Among("iveness", -1, 13, "", methodObject), 
/*  66 */     new Among("fulness", -1, 11, "", methodObject), 
/*  67 */     new Among("ousness", -1, 12, "", methodObject) };
/*     */   
/*     */ 
/*  70 */   private static final Among[] a_4 = {
/*  71 */     new Among("icate", -1, 2, "", methodObject), 
/*  72 */     new Among("ative", -1, 3, "", methodObject), 
/*  73 */     new Among("alize", -1, 1, "", methodObject), 
/*  74 */     new Among("iciti", -1, 2, "", methodObject), 
/*  75 */     new Among("ical", -1, 2, "", methodObject), 
/*  76 */     new Among("ful", -1, 3, "", methodObject), 
/*  77 */     new Among("ness", -1, 3, "", methodObject) };
/*     */   
/*     */ 
/*  80 */   private static final Among[] a_5 = {
/*  81 */     new Among("ic", -1, 1, "", methodObject), 
/*  82 */     new Among("ance", -1, 1, "", methodObject), 
/*  83 */     new Among("ence", -1, 1, "", methodObject), 
/*  84 */     new Among("able", -1, 1, "", methodObject), 
/*  85 */     new Among("ible", -1, 1, "", methodObject), 
/*  86 */     new Among("ate", -1, 1, "", methodObject), 
/*  87 */     new Among("ive", -1, 1, "", methodObject), 
/*  88 */     new Among("ize", -1, 1, "", methodObject), 
/*  89 */     new Among("iti", -1, 1, "", methodObject), 
/*  90 */     new Among("al", -1, 1, "", methodObject), 
/*  91 */     new Among("ism", -1, 1, "", methodObject), 
/*  92 */     new Among("ion", -1, 2, "", methodObject), 
/*  93 */     new Among("er", -1, 1, "", methodObject), 
/*  94 */     new Among("ous", -1, 1, "", methodObject), 
/*  95 */     new Among("ant", -1, 1, "", methodObject), 
/*  96 */     new Among("ent", -1, 1, "", methodObject), 
/*  97 */     new Among("ment", 15, 1, "", methodObject), 
/*  98 */     new Among("ement", 16, 1, "", methodObject), 
/*  99 */     new Among("ou", -1, 1, "", methodObject) };
/*     */   
/*     */ 
/* 102 */   private static final char[] g_v = { '\021', 'A', '\020', '\001' };
/*     */   
/* 104 */   private static final char[] g_v_WXY = { '\001', '\021', 'A', 'Ð', '\001' };
/*     */   private boolean B_Y_found;
/*     */   private int I_p2;
/*     */   private int I_p1;
/*     */   
/*     */   private void copy_from(porterStemmer other)
/*     */   {
/* 111 */     this.B_Y_found = other.B_Y_found;
/* 112 */     this.I_p2 = other.I_p2;
/* 113 */     this.I_p1 = other.I_p1;
/* 114 */     super.copy_from(other);
/*     */   }
/*     */   
/*     */   private boolean r_shortv()
/*     */   {
/* 119 */     if (!out_grouping_b(g_v_WXY, 89, 121))
/*     */     {
/* 121 */       return false;
/*     */     }
/* 123 */     if (!in_grouping_b(g_v, 97, 121))
/*     */     {
/* 125 */       return false;
/*     */     }
/* 127 */     if (!out_grouping_b(g_v, 97, 121))
/*     */     {
/* 129 */       return false;
/*     */     }
/* 131 */     return true;
/*     */   }
/*     */   
/*     */   private boolean r_R1() {
/* 135 */     if (this.I_p1 > this.cursor)
/*     */     {
/* 137 */       return false;
/*     */     }
/* 139 */     return true;
/*     */   }
/*     */   
/*     */   private boolean r_R2() {
/* 143 */     if (this.I_p2 > this.cursor)
/*     */     {
/* 145 */       return false;
/*     */     }
/* 147 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean r_Step_1a()
/*     */   {
/* 154 */     this.ket = this.cursor;
/*     */     
/* 156 */     int among_var = find_among_b(a_0, 4);
/* 157 */     if (among_var == 0)
/*     */     {
/* 159 */       return false;
/*     */     }
/*     */     
/* 162 */     this.bra = this.cursor;
/* 163 */     switch (among_var) {
/*     */     case 0: 
/* 165 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 169 */       slice_from("ss");
/* 170 */       break;
/*     */     
/*     */ 
/*     */     case 2: 
/* 174 */       slice_from("i");
/* 175 */       break;
/*     */     
/*     */ 
/*     */     case 3: 
/* 179 */       slice_del();
/*     */     }
/*     */     
/* 182 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_Step_1b()
/*     */   {
/* 192 */     this.ket = this.cursor;
/*     */     
/* 194 */     int among_var = find_among_b(a_2, 3);
/* 195 */     if (among_var == 0)
/*     */     {
/* 197 */       return false;
/*     */     }
/*     */     
/* 200 */     this.bra = this.cursor;
/* 201 */     switch (among_var) {
/*     */     case 0: 
/* 203 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 207 */       if (!r_R1())
/*     */       {
/* 209 */         return false;
/*     */       }
/*     */       
/* 212 */       slice_from("ee");
/* 213 */       break;
/*     */     
/*     */ 
/*     */     case 2: 
/* 217 */       int v_1 = this.limit - this.cursor;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 222 */       while (!in_grouping_b(g_v, 97, 121))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 228 */         if (this.cursor <= this.limit_backward)
/*     */         {
/* 230 */           return false;
/*     */         }
/* 232 */         this.cursor -= 1;
/*     */       }
/* 234 */       this.cursor = (this.limit - v_1);
/*     */       
/* 236 */       slice_del();
/*     */       
/* 238 */       int v_3 = this.limit - this.cursor;
/*     */       
/* 240 */       among_var = find_among_b(a_1, 13);
/* 241 */       if (among_var == 0)
/*     */       {
/* 243 */         return false;
/*     */       }
/* 245 */       this.cursor = (this.limit - v_3);
/* 246 */       switch (among_var) {
/*     */       case 0: 
/* 248 */         return false;
/*     */       
/*     */ 
/*     */ 
/*     */       case 1: 
/* 253 */         int c = this.cursor;
/* 254 */         insert(this.cursor, this.cursor, "e");
/* 255 */         this.cursor = c;
/*     */         
/* 257 */         break;
/*     */       
/*     */ 
/*     */       case 2: 
/* 261 */         this.ket = this.cursor;
/*     */         
/* 263 */         if (this.cursor <= this.limit_backward)
/*     */         {
/* 265 */           return false;
/*     */         }
/* 267 */         this.cursor -= 1;
/*     */         
/* 269 */         this.bra = this.cursor;
/*     */         
/* 271 */         slice_del();
/* 272 */         break;
/*     */       
/*     */ 
/*     */       case 3: 
/* 276 */         if (this.cursor != this.I_p1)
/*     */         {
/* 278 */           return false;
/*     */         }
/*     */         
/* 281 */         int v_4 = this.limit - this.cursor;
/*     */         
/* 283 */         if (!r_shortv())
/*     */         {
/* 285 */           return false;
/*     */         }
/* 287 */         this.cursor = (this.limit - v_4);
/*     */         
/*     */ 
/* 290 */         int c = this.cursor;
/* 291 */         insert(this.cursor, this.cursor, "e");
/* 292 */         this.cursor = c;
/*     */       }
/*     */       
/*     */       break;
/*     */     }
/*     */     
/* 298 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean r_Step_1c()
/*     */   {
/* 305 */     this.ket = this.cursor;
/*     */     
/*     */ 
/* 308 */     int v_1 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 311 */     if (!eq_s_b(1, "y"))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 317 */       this.cursor = (this.limit - v_1);
/*     */       
/* 319 */       if (!eq_s_b(1, "Y"))
/*     */       {
/* 321 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 325 */     this.bra = this.cursor;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 330 */     while (!in_grouping_b(g_v, 97, 121))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 336 */       if (this.cursor <= this.limit_backward)
/*     */       {
/* 338 */         return false;
/*     */       }
/* 340 */       this.cursor -= 1;
/*     */     }
/*     */     
/* 343 */     slice_from("i");
/* 344 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean r_Step_2()
/*     */   {
/* 351 */     this.ket = this.cursor;
/*     */     
/* 353 */     int among_var = find_among_b(a_3, 20);
/* 354 */     if (among_var == 0)
/*     */     {
/* 356 */       return false;
/*     */     }
/*     */     
/* 359 */     this.bra = this.cursor;
/*     */     
/* 361 */     if (!r_R1())
/*     */     {
/* 363 */       return false;
/*     */     }
/* 365 */     switch (among_var) {
/*     */     case 0: 
/* 367 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 371 */       slice_from("tion");
/* 372 */       break;
/*     */     
/*     */ 
/*     */     case 2: 
/* 376 */       slice_from("ence");
/* 377 */       break;
/*     */     
/*     */ 
/*     */     case 3: 
/* 381 */       slice_from("ance");
/* 382 */       break;
/*     */     
/*     */ 
/*     */     case 4: 
/* 386 */       slice_from("able");
/* 387 */       break;
/*     */     
/*     */ 
/*     */     case 5: 
/* 391 */       slice_from("ent");
/* 392 */       break;
/*     */     
/*     */ 
/*     */     case 6: 
/* 396 */       slice_from("e");
/* 397 */       break;
/*     */     
/*     */ 
/*     */     case 7: 
/* 401 */       slice_from("ize");
/* 402 */       break;
/*     */     
/*     */ 
/*     */     case 8: 
/* 406 */       slice_from("ate");
/* 407 */       break;
/*     */     
/*     */ 
/*     */     case 9: 
/* 411 */       slice_from("al");
/* 412 */       break;
/*     */     
/*     */ 
/*     */     case 10: 
/* 416 */       slice_from("al");
/* 417 */       break;
/*     */     
/*     */ 
/*     */     case 11: 
/* 421 */       slice_from("ful");
/* 422 */       break;
/*     */     
/*     */ 
/*     */     case 12: 
/* 426 */       slice_from("ous");
/* 427 */       break;
/*     */     
/*     */ 
/*     */     case 13: 
/* 431 */       slice_from("ive");
/* 432 */       break;
/*     */     
/*     */ 
/*     */     case 14: 
/* 436 */       slice_from("ble");
/*     */     }
/*     */     
/* 439 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean r_Step_3()
/*     */   {
/* 446 */     this.ket = this.cursor;
/*     */     
/* 448 */     int among_var = find_among_b(a_4, 7);
/* 449 */     if (among_var == 0)
/*     */     {
/* 451 */       return false;
/*     */     }
/*     */     
/* 454 */     this.bra = this.cursor;
/*     */     
/* 456 */     if (!r_R1())
/*     */     {
/* 458 */       return false;
/*     */     }
/* 460 */     switch (among_var) {
/*     */     case 0: 
/* 462 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 466 */       slice_from("al");
/* 467 */       break;
/*     */     
/*     */ 
/*     */     case 2: 
/* 471 */       slice_from("ic");
/* 472 */       break;
/*     */     
/*     */ 
/*     */     case 3: 
/* 476 */       slice_del();
/*     */     }
/*     */     
/* 479 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_Step_4()
/*     */   {
/* 487 */     this.ket = this.cursor;
/*     */     
/* 489 */     int among_var = find_among_b(a_5, 19);
/* 490 */     if (among_var == 0)
/*     */     {
/* 492 */       return false;
/*     */     }
/*     */     
/* 495 */     this.bra = this.cursor;
/*     */     
/* 497 */     if (!r_R2())
/*     */     {
/* 499 */       return false;
/*     */     }
/* 501 */     switch (among_var) {
/*     */     case 0: 
/* 503 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 507 */       slice_del();
/* 508 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */     case 2: 
/* 513 */       int v_1 = this.limit - this.cursor;
/*     */       
/*     */ 
/* 516 */       if (!eq_s_b(1, "s"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 522 */         this.cursor = (this.limit - v_1);
/*     */         
/* 524 */         if (!eq_s_b(1, "t"))
/*     */         {
/* 526 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 530 */       slice_del();
/*     */     }
/*     */     
/* 533 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_Step_5a()
/*     */   {
/* 541 */     this.ket = this.cursor;
/*     */     
/* 543 */     if (!eq_s_b(1, "e"))
/*     */     {
/* 545 */       return false;
/*     */     }
/*     */     
/* 548 */     this.bra = this.cursor;
/*     */     
/*     */ 
/* 551 */     int v_1 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 554 */     if (!r_R2())
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 560 */       this.cursor = (this.limit - v_1);
/*     */       
/*     */ 
/* 563 */       if (!r_R1())
/*     */       {
/* 565 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 569 */       int v_2 = this.limit - this.cursor;
/*     */       
/*     */ 
/* 572 */       if (r_shortv())
/*     */       {
/*     */ 
/*     */ 
/* 576 */         return false;
/*     */       }
/* 578 */       this.cursor = (this.limit - v_2);
/*     */     }
/*     */     
/*     */ 
/* 582 */     slice_del();
/* 583 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean r_Step_5b()
/*     */   {
/* 589 */     this.ket = this.cursor;
/*     */     
/* 591 */     if (!eq_s_b(1, "l"))
/*     */     {
/* 593 */       return false;
/*     */     }
/*     */     
/* 596 */     this.bra = this.cursor;
/*     */     
/* 598 */     if (!r_R2())
/*     */     {
/* 600 */       return false;
/*     */     }
/*     */     
/* 603 */     if (!eq_s_b(1, "l"))
/*     */     {
/* 605 */       return false;
/*     */     }
/*     */     
/* 608 */     slice_del();
/* 609 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean stem()
/*     */   {
/* 631 */     this.B_Y_found = false;
/*     */     
/* 633 */     int v_1 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 637 */     this.bra = this.cursor;
/*     */     
/* 639 */     if (eq_s(1, "y"))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 644 */       this.ket = this.cursor;
/*     */       
/* 646 */       slice_from("Y");
/*     */       
/* 648 */       this.B_Y_found = true;
/*     */     }
/* 650 */     this.cursor = v_1;
/*     */     
/* 652 */     int v_2 = this.cursor;
/*     */     
/*     */     int v_3;
/*     */     for (;;)
/*     */     {
/* 657 */       v_3 = this.cursor;
/*     */       
/*     */ 
/*     */ 
/*     */       for (;;)
/*     */       {
/* 663 */         int v_4 = this.cursor;
/*     */         
/*     */ 
/* 666 */         if (in_grouping(g_v, 97, 121))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 671 */           this.bra = this.cursor;
/*     */           
/* 673 */           if (eq_s(1, "y"))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 678 */             this.ket = this.cursor;
/* 679 */             this.cursor = v_4;
/* 680 */             break;
/*     */           } }
/* 682 */         this.cursor = v_4;
/* 683 */         if (this.cursor >= this.limit) {
/*     */           break label177;
/*     */         }
/*     */         
/* 687 */         this.cursor += 1;
/*     */       }
/*     */       int v_4;
/* 690 */       slice_from("Y");
/*     */       
/* 692 */       this.B_Y_found = true;
/*     */     }
/*     */     label177:
/* 695 */     this.cursor = v_3;
/*     */     
/*     */ 
/*     */ 
/* 699 */     this.cursor = v_2;
/* 700 */     this.I_p1 = this.limit;
/* 701 */     this.I_p2 = this.limit;
/*     */     
/* 703 */     int v_5 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 710 */     while (!in_grouping(g_v, 97, 121))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 716 */       if (this.cursor >= this.limit) {
/*     */         break label389;
/*     */       }
/*     */       
/* 720 */       this.cursor += 1;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 726 */     while (!out_grouping(g_v, 97, 121))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 732 */       if (this.cursor >= this.limit) {
/*     */         break label389;
/*     */       }
/*     */       
/* 736 */       this.cursor += 1;
/*     */     }
/*     */     
/* 739 */     this.I_p1 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 744 */     while (!in_grouping(g_v, 97, 121))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 750 */       if (this.cursor >= this.limit) {
/*     */         break label389;
/*     */       }
/*     */       
/* 754 */       this.cursor += 1;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 760 */     while (!out_grouping(g_v, 97, 121))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 766 */       if (this.cursor >= this.limit) {
/*     */         break label389;
/*     */       }
/*     */       
/* 770 */       this.cursor += 1;
/*     */     }
/*     */     
/* 773 */     this.I_p2 = this.cursor;
/*     */     label389:
/* 775 */     this.cursor = v_5;
/*     */     
/* 777 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*     */     
/*     */ 
/* 780 */     int v_10 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 783 */     if (!r_Step_1a()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 788 */     this.cursor = (this.limit - v_10);
/*     */     
/* 790 */     int v_11 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 793 */     if (!r_Step_1b()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 798 */     this.cursor = (this.limit - v_11);
/*     */     
/* 800 */     int v_12 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 803 */     if (!r_Step_1c()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 808 */     this.cursor = (this.limit - v_12);
/*     */     
/* 810 */     int v_13 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 813 */     if (!r_Step_2()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 818 */     this.cursor = (this.limit - v_13);
/*     */     
/* 820 */     int v_14 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 823 */     if (!r_Step_3()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 828 */     this.cursor = (this.limit - v_14);
/*     */     
/* 830 */     int v_15 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 833 */     if (!r_Step_4()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 838 */     this.cursor = (this.limit - v_15);
/*     */     
/* 840 */     int v_16 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 843 */     if (!r_Step_5a()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 848 */     this.cursor = (this.limit - v_16);
/*     */     
/* 850 */     int v_17 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 853 */     if (!r_Step_5b()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 858 */     this.cursor = (this.limit - v_17);
/* 859 */     this.cursor = this.limit_backward;
/* 860 */     int v_18 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 864 */     if (this.B_Y_found)
/*     */     {
/*     */       int v_19;
/*     */       
/*     */ 
/*     */       for (;;)
/*     */       {
/* 871 */         v_19 = this.cursor;
/*     */         
/*     */ 
/*     */ 
/*     */         for (;;)
/*     */         {
/* 877 */           int v_20 = this.cursor;
/*     */           
/*     */ 
/*     */ 
/* 881 */           this.bra = this.cursor;
/*     */           
/* 883 */           if (eq_s(1, "Y"))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 888 */             this.ket = this.cursor;
/* 889 */             this.cursor = v_20;
/* 890 */             break;
/*     */           }
/* 892 */           this.cursor = v_20;
/* 893 */           if (this.cursor >= this.limit) {
/*     */             break label761;
/*     */           }
/*     */           
/* 897 */           this.cursor += 1;
/*     */         }
/*     */         int v_20;
/* 900 */         slice_from("y");
/*     */       }
/*     */       label761:
/* 903 */       this.cursor = v_19;
/*     */     }
/*     */     
/*     */ 
/* 907 */     this.cursor = v_18;
/* 908 */     return true;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o) {
/* 912 */     return o instanceof porterStemmer;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 916 */     return porterStemmer.class.getName().hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\porterStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */