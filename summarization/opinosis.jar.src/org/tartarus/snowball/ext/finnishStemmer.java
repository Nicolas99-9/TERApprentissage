/*      */ package org.tartarus.snowball.ext;
/*      */ 
/*      */ import org.tartarus.snowball.Among;
/*      */ import org.tartarus.snowball.SnowballStemmer;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class finnishStemmer
/*      */   extends SnowballStemmer
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*   16 */   private static final finnishStemmer methodObject = new finnishStemmer();
/*      */   
/*   18 */   private static final Among[] a_0 = {
/*   19 */     new Among("pa", -1, 1, "", methodObject), 
/*   20 */     new Among("sti", -1, 2, "", methodObject), 
/*   21 */     new Among("kaan", -1, 1, "", methodObject), 
/*   22 */     new Among("han", -1, 1, "", methodObject), 
/*   23 */     new Among("kin", -1, 1, "", methodObject), 
/*   24 */     new Among("hän", -1, 1, "", methodObject), 
/*   25 */     new Among("kään", -1, 1, "", methodObject), 
/*   26 */     new Among("ko", -1, 1, "", methodObject), 
/*   27 */     new Among("pä", -1, 1, "", methodObject), 
/*   28 */     new Among("kö", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*   31 */   private static final Among[] a_1 = {
/*   32 */     new Among("lla", -1, -1, "", methodObject), 
/*   33 */     new Among("na", -1, -1, "", methodObject), 
/*   34 */     new Among("ssa", -1, -1, "", methodObject), 
/*   35 */     new Among("ta", -1, -1, "", methodObject), 
/*   36 */     new Among("lta", 3, -1, "", methodObject), 
/*   37 */     new Among("sta", 3, -1, "", methodObject) };
/*      */   
/*      */ 
/*   40 */   private static final Among[] a_2 = {
/*   41 */     new Among("llä", -1, -1, "", methodObject), 
/*   42 */     new Among("nä", -1, -1, "", methodObject), 
/*   43 */     new Among("ssä", -1, -1, "", methodObject), 
/*   44 */     new Among("tä", -1, -1, "", methodObject), 
/*   45 */     new Among("ltä", 3, -1, "", methodObject), 
/*   46 */     new Among("stä", 3, -1, "", methodObject) };
/*      */   
/*      */ 
/*   49 */   private static final Among[] a_3 = {
/*   50 */     new Among("lle", -1, -1, "", methodObject), 
/*   51 */     new Among("ine", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   54 */   private static final Among[] a_4 = {
/*   55 */     new Among("nsa", -1, 3, "", methodObject), 
/*   56 */     new Among("mme", -1, 3, "", methodObject), 
/*   57 */     new Among("nne", -1, 3, "", methodObject), 
/*   58 */     new Among("ni", -1, 2, "", methodObject), 
/*   59 */     new Among("si", -1, 1, "", methodObject), 
/*   60 */     new Among("an", -1, 4, "", methodObject), 
/*   61 */     new Among("en", -1, 6, "", methodObject), 
/*   62 */     new Among("än", -1, 5, "", methodObject), 
/*   63 */     new Among("nsä", -1, 3, "", methodObject) };
/*      */   
/*      */ 
/*   66 */   private static final Among[] a_5 = {
/*   67 */     new Among("aa", -1, -1, "", methodObject), 
/*   68 */     new Among("ee", -1, -1, "", methodObject), 
/*   69 */     new Among("ii", -1, -1, "", methodObject), 
/*   70 */     new Among("oo", -1, -1, "", methodObject), 
/*   71 */     new Among("uu", -1, -1, "", methodObject), 
/*   72 */     new Among("ää", -1, -1, "", methodObject), 
/*   73 */     new Among("öö", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   76 */   private static final Among[] a_6 = {
/*   77 */     new Among("a", -1, 8, "", methodObject), 
/*   78 */     new Among("lla", 0, -1, "", methodObject), 
/*   79 */     new Among("na", 0, -1, "", methodObject), 
/*   80 */     new Among("ssa", 0, -1, "", methodObject), 
/*   81 */     new Among("ta", 0, -1, "", methodObject), 
/*   82 */     new Among("lta", 4, -1, "", methodObject), 
/*   83 */     new Among("sta", 4, -1, "", methodObject), 
/*   84 */     new Among("tta", 4, 9, "", methodObject), 
/*   85 */     new Among("lle", -1, -1, "", methodObject), 
/*   86 */     new Among("ine", -1, -1, "", methodObject), 
/*   87 */     new Among("ksi", -1, -1, "", methodObject), 
/*   88 */     new Among("n", -1, 7, "", methodObject), 
/*   89 */     new Among("han", 11, 1, "", methodObject), 
/*   90 */     new Among("den", 11, -1, "r_VI", methodObject), 
/*   91 */     new Among("seen", 11, -1, "r_LONG", methodObject), 
/*   92 */     new Among("hen", 11, 2, "", methodObject), 
/*   93 */     new Among("tten", 11, -1, "r_VI", methodObject), 
/*   94 */     new Among("hin", 11, 3, "", methodObject), 
/*   95 */     new Among("siin", 11, -1, "r_VI", methodObject), 
/*   96 */     new Among("hon", 11, 4, "", methodObject), 
/*   97 */     new Among("hän", 11, 5, "", methodObject), 
/*   98 */     new Among("hön", 11, 6, "", methodObject), 
/*   99 */     new Among("ä", -1, 8, "", methodObject), 
/*  100 */     new Among("llä", 22, -1, "", methodObject), 
/*  101 */     new Among("nä", 22, -1, "", methodObject), 
/*  102 */     new Among("ssä", 22, -1, "", methodObject), 
/*  103 */     new Among("tä", 22, -1, "", methodObject), 
/*  104 */     new Among("ltä", 26, -1, "", methodObject), 
/*  105 */     new Among("stä", 26, -1, "", methodObject), 
/*  106 */     new Among("ttä", 26, 9, "", methodObject) };
/*      */   
/*      */ 
/*  109 */   private static final Among[] a_7 = {
/*  110 */     new Among("eja", -1, -1, "", methodObject), 
/*  111 */     new Among("mma", -1, 1, "", methodObject), 
/*  112 */     new Among("imma", 1, -1, "", methodObject), 
/*  113 */     new Among("mpa", -1, 1, "", methodObject), 
/*  114 */     new Among("impa", 3, -1, "", methodObject), 
/*  115 */     new Among("mmi", -1, 1, "", methodObject), 
/*  116 */     new Among("immi", 5, -1, "", methodObject), 
/*  117 */     new Among("mpi", -1, 1, "", methodObject), 
/*  118 */     new Among("impi", 7, -1, "", methodObject), 
/*  119 */     new Among("ejä", -1, -1, "", methodObject), 
/*  120 */     new Among("mmä", -1, 1, "", methodObject), 
/*  121 */     new Among("immä", 10, -1, "", methodObject), 
/*  122 */     new Among("mpä", -1, 1, "", methodObject), 
/*  123 */     new Among("impä", 12, -1, "", methodObject) };
/*      */   
/*      */ 
/*  126 */   private static final Among[] a_8 = {
/*  127 */     new Among("i", -1, -1, "", methodObject), 
/*  128 */     new Among("j", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  131 */   private static final Among[] a_9 = {
/*  132 */     new Among("mma", -1, 1, "", methodObject), 
/*  133 */     new Among("imma", 0, -1, "", methodObject) };
/*      */   
/*      */ 
/*  136 */   private static final char[] g_AEI = { '\021', '\001', '\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\b' };
/*      */   
/*  138 */   private static final char[] g_V1 = { '\021', 'A', '\020', '\001', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\b', '\000'' ' };
/*      */   
/*  140 */   private static final char[] g_V2 = { '\021', 'A', '\020', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\b', '\000'' ' };
/*      */   
/*  142 */   private static final char[] g_particle_end = { '\021', 'a', '\030', '\001', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\b', '\000'' ' };
/*      */   
/*      */   private boolean B_ending_removed;
/*  145 */   private StringBuilder S_x = new StringBuilder();
/*      */   private int I_p2;
/*      */   private int I_p1;
/*      */   
/*      */   private void copy_from(finnishStemmer other) {
/*  150 */     this.B_ending_removed = other.B_ending_removed;
/*  151 */     this.S_x = other.S_x;
/*  152 */     this.I_p2 = other.I_p2;
/*  153 */     this.I_p1 = other.I_p1;
/*  154 */     super.copy_from(other);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_mark_regions()
/*      */   {
/*  161 */     this.I_p1 = this.limit;
/*  162 */     this.I_p2 = this.limit;
/*      */     
/*      */     for (;;)
/*      */     {
/*  166 */       int v_1 = this.cursor;
/*      */       
/*  168 */       if (in_grouping(g_V1, 97, 246))
/*      */       {
/*      */ 
/*      */ 
/*  172 */         this.cursor = v_1;
/*  173 */         break;
/*      */       }
/*  175 */       this.cursor = v_1;
/*  176 */       if (this.cursor >= this.limit)
/*      */       {
/*  178 */         return false;
/*      */       }
/*  180 */       this.cursor += 1;
/*      */     }
/*      */     
/*      */ 
/*      */     int v_1;
/*      */     
/*  186 */     while (!out_grouping(g_V1, 97, 246))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  192 */       if (this.cursor >= this.limit)
/*      */       {
/*  194 */         return false;
/*      */       }
/*  196 */       this.cursor += 1;
/*      */     }
/*      */     
/*  199 */     this.I_p1 = this.cursor;
/*      */     
/*      */     for (;;)
/*      */     {
/*  203 */       int v_3 = this.cursor;
/*      */       
/*  205 */       if (in_grouping(g_V1, 97, 246))
/*      */       {
/*      */ 
/*      */ 
/*  209 */         this.cursor = v_3;
/*  210 */         break;
/*      */       }
/*  212 */       this.cursor = v_3;
/*  213 */       if (this.cursor >= this.limit)
/*      */       {
/*  215 */         return false;
/*      */       }
/*  217 */       this.cursor += 1;
/*      */     }
/*      */     
/*      */ 
/*      */     int v_3;
/*      */     
/*  223 */     while (!out_grouping(g_V1, 97, 246))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  229 */       if (this.cursor >= this.limit)
/*      */       {
/*  231 */         return false;
/*      */       }
/*  233 */       this.cursor += 1;
/*      */     }
/*      */     
/*  236 */     this.I_p2 = this.cursor;
/*  237 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_R2() {
/*  241 */     if (this.I_p2 > this.cursor)
/*      */     {
/*  243 */       return false;
/*      */     }
/*  245 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_particle_etc()
/*      */   {
/*  254 */     int v_1 = this.limit - this.cursor;
/*      */     
/*  256 */     if (this.cursor < this.I_p1)
/*      */     {
/*  258 */       return false;
/*      */     }
/*  260 */     this.cursor = this.I_p1;
/*  261 */     int v_2 = this.limit_backward;
/*  262 */     this.limit_backward = this.cursor;
/*  263 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*  266 */     this.ket = this.cursor;
/*      */     
/*  268 */     int among_var = find_among_b(a_0, 10);
/*  269 */     if (among_var == 0)
/*      */     {
/*  271 */       this.limit_backward = v_2;
/*  272 */       return false;
/*      */     }
/*      */     
/*  275 */     this.bra = this.cursor;
/*  276 */     this.limit_backward = v_2;
/*  277 */     switch (among_var) {
/*      */     case 0: 
/*  279 */       return false;
/*      */     
/*      */     case 1: 
/*  282 */       if (!in_grouping_b(g_particle_end, 97, 246))
/*      */       {
/*  284 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */       break;
/*      */     case 2: 
/*  290 */       if (!r_R2())
/*      */       {
/*  292 */         return false;
/*      */       }
/*      */       break;
/*      */     }
/*      */     
/*  297 */     slice_del();
/*  298 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_possessive()
/*      */   {
/*  308 */     int v_1 = this.limit - this.cursor;
/*      */     
/*  310 */     if (this.cursor < this.I_p1)
/*      */     {
/*  312 */       return false;
/*      */     }
/*  314 */     this.cursor = this.I_p1;
/*  315 */     int v_2 = this.limit_backward;
/*  316 */     this.limit_backward = this.cursor;
/*  317 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*  320 */     this.ket = this.cursor;
/*      */     
/*  322 */     int among_var = find_among_b(a_4, 9);
/*  323 */     if (among_var == 0)
/*      */     {
/*  325 */       this.limit_backward = v_2;
/*  326 */       return false;
/*      */     }
/*      */     
/*  329 */     this.bra = this.cursor;
/*  330 */     this.limit_backward = v_2;
/*  331 */     switch (among_var) {
/*      */     case 0: 
/*  333 */       return false;
/*      */     
/*      */ 
/*      */ 
/*      */     case 1: 
/*  338 */       int v_3 = this.limit - this.cursor;
/*      */       
/*      */ 
/*  341 */       if (eq_s_b(1, "k"))
/*      */       {
/*      */ 
/*      */ 
/*  345 */         return false;
/*      */       }
/*  347 */       this.cursor = (this.limit - v_3);
/*      */       
/*      */ 
/*  350 */       slice_del();
/*  351 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  355 */       slice_del();
/*      */       
/*  357 */       this.ket = this.cursor;
/*      */       
/*  359 */       if (!eq_s_b(3, "kse"))
/*      */       {
/*  361 */         return false;
/*      */       }
/*      */       
/*  364 */       this.bra = this.cursor;
/*      */       
/*  366 */       slice_from("ksi");
/*  367 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  371 */       slice_del();
/*  372 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  376 */       if (find_among_b(a_1, 6) == 0)
/*      */       {
/*  378 */         return false;
/*      */       }
/*      */       
/*  381 */       slice_del();
/*  382 */       break;
/*      */     
/*      */ 
/*      */     case 5: 
/*  386 */       if (find_among_b(a_2, 6) == 0)
/*      */       {
/*  388 */         return false;
/*      */       }
/*      */       
/*  391 */       slice_del();
/*  392 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/*  396 */       if (find_among_b(a_3, 2) == 0)
/*      */       {
/*  398 */         return false;
/*      */       }
/*      */       
/*  401 */       slice_del();
/*      */     }
/*      */     
/*  404 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_LONG()
/*      */   {
/*  409 */     if (find_among_b(a_5, 7) == 0)
/*      */     {
/*  411 */       return false;
/*      */     }
/*  413 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_VI()
/*      */   {
/*  419 */     if (!eq_s_b(1, "i"))
/*      */     {
/*  421 */       return false;
/*      */     }
/*  423 */     if (!in_grouping_b(g_V2, 97, 246))
/*      */     {
/*  425 */       return false;
/*      */     }
/*  427 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_case_ending()
/*      */   {
/*  439 */     int v_1 = this.limit - this.cursor;
/*      */     
/*  441 */     if (this.cursor < this.I_p1)
/*      */     {
/*  443 */       return false;
/*      */     }
/*  445 */     this.cursor = this.I_p1;
/*  446 */     int v_2 = this.limit_backward;
/*  447 */     this.limit_backward = this.cursor;
/*  448 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*  451 */     this.ket = this.cursor;
/*      */     
/*  453 */     int among_var = find_among_b(a_6, 30);
/*  454 */     if (among_var == 0)
/*      */     {
/*  456 */       this.limit_backward = v_2;
/*  457 */       return false;
/*      */     }
/*      */     
/*  460 */     this.bra = this.cursor;
/*  461 */     this.limit_backward = v_2;
/*  462 */     switch (among_var) {
/*      */     case 0: 
/*  464 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  468 */       if (!eq_s_b(1, "a"))
/*      */       {
/*  470 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */       break;
/*      */     case 2: 
/*  476 */       if (!eq_s_b(1, "e"))
/*      */       {
/*  478 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */       break;
/*      */     case 3: 
/*  484 */       if (!eq_s_b(1, "i"))
/*      */       {
/*  486 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */       break;
/*      */     case 4: 
/*  492 */       if (!eq_s_b(1, "o"))
/*      */       {
/*  494 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */       break;
/*      */     case 5: 
/*  500 */       if (!eq_s_b(1, "ä"))
/*      */       {
/*  502 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */       break;
/*      */     case 6: 
/*  508 */       if (!eq_s_b(1, "ö"))
/*      */       {
/*  510 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */       break;
/*      */     case 7: 
/*  516 */       int v_3 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  520 */       int v_4 = this.limit - this.cursor;
/*      */       
/*      */ 
/*  523 */       int v_5 = this.limit - this.cursor;
/*      */       
/*      */ 
/*  526 */       if (!r_LONG())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  532 */         this.cursor = (this.limit - v_5);
/*      */         
/*  534 */         if (!eq_s_b(2, "ie"))
/*      */         {
/*  536 */           this.cursor = (this.limit - v_3);
/*  537 */           break;
/*      */         }
/*      */       }
/*  540 */       this.cursor = (this.limit - v_4);
/*      */       
/*  542 */       if (this.cursor <= this.limit_backward)
/*      */       {
/*  544 */         this.cursor = (this.limit - v_3);
/*      */       }
/*      */       else {
/*  547 */         this.cursor -= 1;
/*      */         
/*  549 */         this.bra = this.cursor;
/*      */       }
/*  551 */       break;
/*      */     
/*      */     case 8: 
/*  554 */       if (!in_grouping_b(g_V1, 97, 246))
/*      */       {
/*  556 */         return false;
/*      */       }
/*  558 */       if (!out_grouping_b(g_V1, 97, 246))
/*      */       {
/*  560 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */       break;
/*      */     case 9: 
/*  566 */       if (!eq_s_b(1, "e"))
/*      */       {
/*  568 */         return false;
/*      */       }
/*      */       break;
/*      */     }
/*      */     
/*  573 */     slice_del();
/*      */     
/*  575 */     this.B_ending_removed = true;
/*  576 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_other_endings()
/*      */   {
/*  586 */     int v_1 = this.limit - this.cursor;
/*      */     
/*  588 */     if (this.cursor < this.I_p2)
/*      */     {
/*  590 */       return false;
/*      */     }
/*  592 */     this.cursor = this.I_p2;
/*  593 */     int v_2 = this.limit_backward;
/*  594 */     this.limit_backward = this.cursor;
/*  595 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*  598 */     this.ket = this.cursor;
/*      */     
/*  600 */     int among_var = find_among_b(a_7, 14);
/*  601 */     if (among_var == 0)
/*      */     {
/*  603 */       this.limit_backward = v_2;
/*  604 */       return false;
/*      */     }
/*      */     
/*  607 */     this.bra = this.cursor;
/*  608 */     this.limit_backward = v_2;
/*  609 */     switch (among_var) {
/*      */     case 0: 
/*  611 */       return false;
/*      */     
/*      */ 
/*      */ 
/*      */     case 1: 
/*  616 */       int v_3 = this.limit - this.cursor;
/*      */       
/*      */ 
/*  619 */       if (eq_s_b(2, "po"))
/*      */       {
/*      */ 
/*      */ 
/*  623 */         return false;
/*      */       }
/*  625 */       this.cursor = (this.limit - v_3);
/*      */     }
/*      */     
/*      */     
/*      */ 
/*  630 */     slice_del();
/*  631 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_i_plural()
/*      */   {
/*  639 */     int v_1 = this.limit - this.cursor;
/*      */     
/*  641 */     if (this.cursor < this.I_p1)
/*      */     {
/*  643 */       return false;
/*      */     }
/*  645 */     this.cursor = this.I_p1;
/*  646 */     int v_2 = this.limit_backward;
/*  647 */     this.limit_backward = this.cursor;
/*  648 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*  651 */     this.ket = this.cursor;
/*      */     
/*  653 */     if (find_among_b(a_8, 2) == 0)
/*      */     {
/*  655 */       this.limit_backward = v_2;
/*  656 */       return false;
/*      */     }
/*      */     
/*  659 */     this.bra = this.cursor;
/*  660 */     this.limit_backward = v_2;
/*      */     
/*  662 */     slice_del();
/*  663 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_t_plural()
/*      */   {
/*  676 */     int v_1 = this.limit - this.cursor;
/*      */     
/*  678 */     if (this.cursor < this.I_p1)
/*      */     {
/*  680 */       return false;
/*      */     }
/*  682 */     this.cursor = this.I_p1;
/*  683 */     int v_2 = this.limit_backward;
/*  684 */     this.limit_backward = this.cursor;
/*  685 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*  688 */     this.ket = this.cursor;
/*      */     
/*  690 */     if (!eq_s_b(1, "t"))
/*      */     {
/*  692 */       this.limit_backward = v_2;
/*  693 */       return false;
/*      */     }
/*      */     
/*  696 */     this.bra = this.cursor;
/*      */     
/*  698 */     int v_3 = this.limit - this.cursor;
/*  699 */     if (!in_grouping_b(g_V1, 97, 246))
/*      */     {
/*  701 */       this.limit_backward = v_2;
/*  702 */       return false;
/*      */     }
/*  704 */     this.cursor = (this.limit - v_3);
/*      */     
/*  706 */     slice_del();
/*  707 */     this.limit_backward = v_2;
/*      */     
/*  709 */     int v_4 = this.limit - this.cursor;
/*      */     
/*  711 */     if (this.cursor < this.I_p2)
/*      */     {
/*  713 */       return false;
/*      */     }
/*  715 */     this.cursor = this.I_p2;
/*  716 */     int v_5 = this.limit_backward;
/*  717 */     this.limit_backward = this.cursor;
/*  718 */     this.cursor = (this.limit - v_4);
/*      */     
/*      */ 
/*  721 */     this.ket = this.cursor;
/*      */     
/*  723 */     int among_var = find_among_b(a_9, 2);
/*  724 */     if (among_var == 0)
/*      */     {
/*  726 */       this.limit_backward = v_5;
/*  727 */       return false;
/*      */     }
/*      */     
/*  730 */     this.bra = this.cursor;
/*  731 */     this.limit_backward = v_5;
/*  732 */     switch (among_var) {
/*      */     case 0: 
/*  734 */       return false;
/*      */     
/*      */ 
/*      */ 
/*      */     case 1: 
/*  739 */       int v_6 = this.limit - this.cursor;
/*      */       
/*      */ 
/*  742 */       if (eq_s_b(2, "po"))
/*      */       {
/*      */ 
/*      */ 
/*  746 */         return false;
/*      */       }
/*  748 */       this.cursor = (this.limit - v_6);
/*      */     }
/*      */     
/*      */     
/*      */ 
/*  753 */     slice_del();
/*  754 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_tidy()
/*      */   {
/*  769 */     int v_1 = this.limit - this.cursor;
/*      */     
/*  771 */     if (this.cursor < this.I_p1)
/*      */     {
/*  773 */       return false;
/*      */     }
/*  775 */     this.cursor = this.I_p1;
/*  776 */     int v_2 = this.limit_backward;
/*  777 */     this.limit_backward = this.cursor;
/*  778 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*  781 */     int v_3 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*  785 */     int v_4 = this.limit - this.cursor;
/*      */     
/*  787 */     if (r_LONG())
/*      */     {
/*      */ 
/*      */ 
/*  791 */       this.cursor = (this.limit - v_4);
/*      */       
/*      */ 
/*  794 */       this.ket = this.cursor;
/*      */       
/*  796 */       if (this.cursor > this.limit_backward)
/*      */       {
/*      */ 
/*      */ 
/*  800 */         this.cursor -= 1;
/*      */         
/*  802 */         this.bra = this.cursor;
/*      */         
/*  804 */         slice_del();
/*      */       } }
/*  806 */     this.cursor = (this.limit - v_3);
/*      */     
/*  808 */     int v_5 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*  812 */     this.ket = this.cursor;
/*  813 */     if (in_grouping_b(g_AEI, 97, 228))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*  818 */       this.bra = this.cursor;
/*  819 */       if (out_grouping_b(g_V1, 97, 246))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  824 */         slice_del(); }
/*      */     }
/*  826 */     this.cursor = (this.limit - v_5);
/*      */     
/*  828 */     int v_6 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*  832 */     this.ket = this.cursor;
/*      */     
/*  834 */     if (eq_s_b(1, "j"))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*  839 */       this.bra = this.cursor;
/*      */       
/*      */ 
/*  842 */       int v_7 = this.limit - this.cursor;
/*      */       
/*      */ 
/*  845 */       if (!eq_s_b(1, "o"))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  851 */         this.cursor = (this.limit - v_7);
/*      */         
/*  853 */         if (!eq_s_b(1, "u")) {}
/*      */ 
/*      */       }
/*      */       else
/*      */       {
/*      */ 
/*  859 */         slice_del();
/*      */       } }
/*  861 */     this.cursor = (this.limit - v_6);
/*      */     
/*  863 */     int v_8 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*  867 */     this.ket = this.cursor;
/*      */     
/*  869 */     if (eq_s_b(1, "o"))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*  874 */       this.bra = this.cursor;
/*      */       
/*  876 */       if (eq_s_b(1, "j"))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  881 */         slice_del(); }
/*      */     }
/*  883 */     this.cursor = (this.limit - v_8);
/*  884 */     this.limit_backward = v_2;
/*      */     
/*      */     for (;;)
/*      */     {
/*  888 */       int v_9 = this.limit - this.cursor;
/*      */       
/*  890 */       if (out_grouping_b(g_V1, 97, 246))
/*      */       {
/*      */ 
/*      */ 
/*  894 */         this.cursor = (this.limit - v_9);
/*  895 */         break;
/*      */       }
/*  897 */       this.cursor = (this.limit - v_9);
/*  898 */       if (this.cursor <= this.limit_backward)
/*      */       {
/*  900 */         return false;
/*      */       }
/*  902 */       this.cursor -= 1;
/*      */     }
/*      */     int v_9;
/*  905 */     this.ket = this.cursor;
/*      */     
/*  907 */     if (this.cursor <= this.limit_backward)
/*      */     {
/*  909 */       return false;
/*      */     }
/*  911 */     this.cursor -= 1;
/*      */     
/*  913 */     this.bra = this.cursor;
/*      */     
/*  915 */     this.S_x = slice_to(this.S_x);
/*      */     
/*  917 */     if (!eq_v_b(this.S_x))
/*      */     {
/*  919 */       return false;
/*      */     }
/*      */     
/*  922 */     slice_del();
/*  923 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean stem()
/*      */   {
/*  938 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/*  941 */     if (!r_mark_regions()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  946 */     this.cursor = v_1;
/*      */     
/*  948 */     this.B_ending_removed = false;
/*      */     
/*  950 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*      */     
/*      */ 
/*  953 */     int v_2 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  956 */     if (!r_particle_etc()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  961 */     this.cursor = (this.limit - v_2);
/*      */     
/*  963 */     int v_3 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  966 */     if (!r_possessive()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  971 */     this.cursor = (this.limit - v_3);
/*      */     
/*  973 */     int v_4 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  976 */     if (!r_case_ending()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  981 */     this.cursor = (this.limit - v_4);
/*      */     
/*  983 */     int v_5 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  986 */     if (!r_other_endings()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  991 */     this.cursor = (this.limit - v_5);
/*      */     
/*      */ 
/*  994 */     int v_6 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*  998 */     if (this.B_ending_removed)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/* 1003 */       int v_7 = this.limit - this.cursor;
/*      */       
/*      */ 
/* 1006 */       if (!r_i_plural()) {}
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1011 */       this.cursor = (this.limit - v_7);
/*      */     }
/*      */     else {
/* 1014 */       this.cursor = (this.limit - v_6);
/*      */       
/* 1016 */       int v_8 = this.limit - this.cursor;
/*      */       
/*      */ 
/* 1019 */       if (!r_t_plural()) {}
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1024 */       this.cursor = (this.limit - v_8);
/*      */     }
/*      */     
/* 1027 */     int v_9 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1030 */     if (!r_tidy()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1035 */     this.cursor = (this.limit - v_9);
/* 1036 */     this.cursor = this.limit_backward;return true;
/*      */   }
/*      */   
/*      */   public boolean equals(Object o) {
/* 1040 */     return o instanceof finnishStemmer;
/*      */   }
/*      */   
/*      */   public int hashCode() {
/* 1044 */     return finnishStemmer.class.getName().hashCode();
/*      */   }
/*      */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\finnishStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */