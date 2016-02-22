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
/*      */ public class englishStemmer
/*      */   extends SnowballStemmer
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*   16 */   private static final englishStemmer methodObject = new englishStemmer();
/*      */   
/*   18 */   private static final Among[] a_0 = {
/*   19 */     new Among("arsen", -1, -1, "", methodObject), 
/*   20 */     new Among("commun", -1, -1, "", methodObject), 
/*   21 */     new Among("gener", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   24 */   private static final Among[] a_1 = {
/*   25 */     new Among("'", -1, 1, "", methodObject), 
/*   26 */     new Among("'s'", 0, 1, "", methodObject), 
/*   27 */     new Among("'s", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*   30 */   private static final Among[] a_2 = {
/*   31 */     new Among("ied", -1, 2, "", methodObject), 
/*   32 */     new Among("s", -1, 3, "", methodObject), 
/*   33 */     new Among("ies", 1, 2, "", methodObject), 
/*   34 */     new Among("sses", 1, 1, "", methodObject), 
/*   35 */     new Among("ss", 1, -1, "", methodObject), 
/*   36 */     new Among("us", 1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   39 */   private static final Among[] a_3 = {
/*   40 */     new Among("", -1, 3, "", methodObject), 
/*   41 */     new Among("bb", 0, 2, "", methodObject), 
/*   42 */     new Among("dd", 0, 2, "", methodObject), 
/*   43 */     new Among("ff", 0, 2, "", methodObject), 
/*   44 */     new Among("gg", 0, 2, "", methodObject), 
/*   45 */     new Among("bl", 0, 1, "", methodObject), 
/*   46 */     new Among("mm", 0, 2, "", methodObject), 
/*   47 */     new Among("nn", 0, 2, "", methodObject), 
/*   48 */     new Among("pp", 0, 2, "", methodObject), 
/*   49 */     new Among("rr", 0, 2, "", methodObject), 
/*   50 */     new Among("at", 0, 1, "", methodObject), 
/*   51 */     new Among("tt", 0, 2, "", methodObject), 
/*   52 */     new Among("iz", 0, 1, "", methodObject) };
/*      */   
/*      */ 
/*   55 */   private static final Among[] a_4 = {
/*   56 */     new Among("ed", -1, 2, "", methodObject), 
/*   57 */     new Among("eed", 0, 1, "", methodObject), 
/*   58 */     new Among("ing", -1, 2, "", methodObject), 
/*   59 */     new Among("edly", -1, 2, "", methodObject), 
/*   60 */     new Among("eedly", 3, 1, "", methodObject), 
/*   61 */     new Among("ingly", -1, 2, "", methodObject) };
/*      */   
/*      */ 
/*   64 */   private static final Among[] a_5 = {
/*   65 */     new Among("anci", -1, 3, "", methodObject), 
/*   66 */     new Among("enci", -1, 2, "", methodObject), 
/*   67 */     new Among("ogi", -1, 13, "", methodObject), 
/*   68 */     new Among("li", -1, 16, "", methodObject), 
/*   69 */     new Among("bli", 3, 12, "", methodObject), 
/*   70 */     new Among("abli", 4, 4, "", methodObject), 
/*   71 */     new Among("alli", 3, 8, "", methodObject), 
/*   72 */     new Among("fulli", 3, 14, "", methodObject), 
/*   73 */     new Among("lessli", 3, 15, "", methodObject), 
/*   74 */     new Among("ousli", 3, 10, "", methodObject), 
/*   75 */     new Among("entli", 3, 5, "", methodObject), 
/*   76 */     new Among("aliti", -1, 8, "", methodObject), 
/*   77 */     new Among("biliti", -1, 12, "", methodObject), 
/*   78 */     new Among("iviti", -1, 11, "", methodObject), 
/*   79 */     new Among("tional", -1, 1, "", methodObject), 
/*   80 */     new Among("ational", 14, 7, "", methodObject), 
/*   81 */     new Among("alism", -1, 8, "", methodObject), 
/*   82 */     new Among("ation", -1, 7, "", methodObject), 
/*   83 */     new Among("ization", 17, 6, "", methodObject), 
/*   84 */     new Among("izer", -1, 6, "", methodObject), 
/*   85 */     new Among("ator", -1, 7, "", methodObject), 
/*   86 */     new Among("iveness", -1, 11, "", methodObject), 
/*   87 */     new Among("fulness", -1, 9, "", methodObject), 
/*   88 */     new Among("ousness", -1, 10, "", methodObject) };
/*      */   
/*      */ 
/*   91 */   private static final Among[] a_6 = {
/*   92 */     new Among("icate", -1, 4, "", methodObject), 
/*   93 */     new Among("ative", -1, 6, "", methodObject), 
/*   94 */     new Among("alize", -1, 3, "", methodObject), 
/*   95 */     new Among("iciti", -1, 4, "", methodObject), 
/*   96 */     new Among("ical", -1, 4, "", methodObject), 
/*   97 */     new Among("tional", -1, 1, "", methodObject), 
/*   98 */     new Among("ational", 5, 2, "", methodObject), 
/*   99 */     new Among("ful", -1, 5, "", methodObject), 
/*  100 */     new Among("ness", -1, 5, "", methodObject) };
/*      */   
/*      */ 
/*  103 */   private static final Among[] a_7 = {
/*  104 */     new Among("ic", -1, 1, "", methodObject), 
/*  105 */     new Among("ance", -1, 1, "", methodObject), 
/*  106 */     new Among("ence", -1, 1, "", methodObject), 
/*  107 */     new Among("able", -1, 1, "", methodObject), 
/*  108 */     new Among("ible", -1, 1, "", methodObject), 
/*  109 */     new Among("ate", -1, 1, "", methodObject), 
/*  110 */     new Among("ive", -1, 1, "", methodObject), 
/*  111 */     new Among("ize", -1, 1, "", methodObject), 
/*  112 */     new Among("iti", -1, 1, "", methodObject), 
/*  113 */     new Among("al", -1, 1, "", methodObject), 
/*  114 */     new Among("ism", -1, 1, "", methodObject), 
/*  115 */     new Among("ion", -1, 2, "", methodObject), 
/*  116 */     new Among("er", -1, 1, "", methodObject), 
/*  117 */     new Among("ous", -1, 1, "", methodObject), 
/*  118 */     new Among("ant", -1, 1, "", methodObject), 
/*  119 */     new Among("ent", -1, 1, "", methodObject), 
/*  120 */     new Among("ment", 15, 1, "", methodObject), 
/*  121 */     new Among("ement", 16, 1, "", methodObject) };
/*      */   
/*      */ 
/*  124 */   private static final Among[] a_8 = {
/*  125 */     new Among("e", -1, 1, "", methodObject), 
/*  126 */     new Among("l", -1, 2, "", methodObject) };
/*      */   
/*      */ 
/*  129 */   private static final Among[] a_9 = {
/*  130 */     new Among("succeed", -1, -1, "", methodObject), 
/*  131 */     new Among("proceed", -1, -1, "", methodObject), 
/*  132 */     new Among("exceed", -1, -1, "", methodObject), 
/*  133 */     new Among("canning", -1, -1, "", methodObject), 
/*  134 */     new Among("inning", -1, -1, "", methodObject), 
/*  135 */     new Among("earring", -1, -1, "", methodObject), 
/*  136 */     new Among("herring", -1, -1, "", methodObject), 
/*  137 */     new Among("outing", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  140 */   private static final Among[] a_10 = {
/*  141 */     new Among("andes", -1, -1, "", methodObject), 
/*  142 */     new Among("atlas", -1, -1, "", methodObject), 
/*  143 */     new Among("bias", -1, -1, "", methodObject), 
/*  144 */     new Among("cosmos", -1, -1, "", methodObject), 
/*  145 */     new Among("dying", -1, 3, "", methodObject), 
/*  146 */     new Among("early", -1, 9, "", methodObject), 
/*  147 */     new Among("gently", -1, 7, "", methodObject), 
/*  148 */     new Among("howe", -1, -1, "", methodObject), 
/*  149 */     new Among("idly", -1, 6, "", methodObject), 
/*  150 */     new Among("lying", -1, 4, "", methodObject), 
/*  151 */     new Among("news", -1, -1, "", methodObject), 
/*  152 */     new Among("only", -1, 10, "", methodObject), 
/*  153 */     new Among("singly", -1, 11, "", methodObject), 
/*  154 */     new Among("skies", -1, 2, "", methodObject), 
/*  155 */     new Among("skis", -1, 1, "", methodObject), 
/*  156 */     new Among("sky", -1, -1, "", methodObject), 
/*  157 */     new Among("tying", -1, 5, "", methodObject), 
/*  158 */     new Among("ugly", -1, 8, "", methodObject) };
/*      */   
/*      */ 
/*  161 */   private static final char[] g_v = { '\021', 'A', '\020', '\001' };
/*      */   
/*  163 */   private static final char[] g_v_WXY = { '\001', '\021', 'A', 'Ð', '\001' };
/*      */   
/*  165 */   private static final char[] g_valid_LI = { '7', '', '\002' };
/*      */   private boolean B_Y_found;
/*      */   private int I_p2;
/*      */   private int I_p1;
/*      */   
/*      */   private void copy_from(englishStemmer other)
/*      */   {
/*  172 */     this.B_Y_found = other.B_Y_found;
/*  173 */     this.I_p2 = other.I_p2;
/*  174 */     this.I_p1 = other.I_p1;
/*  175 */     super.copy_from(other);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_prelude()
/*      */   {
/*  186 */     this.B_Y_found = false;
/*      */     
/*  188 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*  192 */     this.bra = this.cursor;
/*      */     
/*  194 */     if (eq_s(1, "'"))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*  199 */       this.ket = this.cursor;
/*      */       
/*  201 */       slice_del();
/*      */     }
/*  203 */     this.cursor = v_1;
/*      */     
/*  205 */     int v_2 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*  209 */     this.bra = this.cursor;
/*      */     
/*  211 */     if (eq_s(1, "y"))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*  216 */       this.ket = this.cursor;
/*      */       
/*  218 */       slice_from("Y");
/*      */       
/*  220 */       this.B_Y_found = true;
/*      */     }
/*  222 */     this.cursor = v_2;
/*      */     
/*  224 */     int v_3 = this.cursor;
/*      */     
/*      */     int v_4;
/*      */     for (;;)
/*      */     {
/*  229 */       v_4 = this.cursor;
/*      */       
/*      */ 
/*      */ 
/*      */       for (;;)
/*      */       {
/*  235 */         int v_5 = this.cursor;
/*      */         
/*      */ 
/*  238 */         if (in_grouping(g_v, 97, 121))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  243 */           this.bra = this.cursor;
/*      */           
/*  245 */           if (eq_s(1, "y"))
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*  250 */             this.ket = this.cursor;
/*  251 */             this.cursor = v_5;
/*  252 */             break;
/*      */           } }
/*  254 */         this.cursor = v_5;
/*  255 */         if (this.cursor >= this.limit) {
/*      */           break label221;
/*      */         }
/*      */         
/*  259 */         this.cursor += 1;
/*      */       }
/*      */       int v_5;
/*  262 */       slice_from("Y");
/*      */       
/*  264 */       this.B_Y_found = true;
/*      */     }
/*      */     label221:
/*  267 */     this.cursor = v_4;
/*      */     
/*      */ 
/*      */ 
/*  271 */     this.cursor = v_3;
/*  272 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_mark_regions()
/*      */   {
/*  279 */     this.I_p1 = this.limit;
/*  280 */     this.I_p2 = this.limit;
/*      */     
/*  282 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  287 */     int v_2 = this.cursor;
/*      */     
/*      */ 
/*  290 */     if (find_among(a_0, 3) == 0)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  296 */       this.cursor = v_2;
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  302 */       while (!in_grouping(g_v, 97, 121))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  308 */         if (this.cursor >= this.limit) {
/*      */           break label222;
/*      */         }
/*      */         
/*  312 */         this.cursor += 1;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  318 */       while (!out_grouping(g_v, 97, 121))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  324 */         if (this.cursor >= this.limit) {
/*      */           break label222;
/*      */         }
/*      */         
/*  328 */         this.cursor += 1;
/*      */       }
/*      */     }
/*      */     
/*  332 */     this.I_p1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  337 */     while (!in_grouping(g_v, 97, 121))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  343 */       if (this.cursor >= this.limit) {
/*      */         break label222;
/*      */       }
/*      */       
/*  347 */       this.cursor += 1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  353 */     while (!out_grouping(g_v, 97, 121))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  359 */       if (this.cursor >= this.limit) {
/*      */         break label222;
/*      */       }
/*      */       
/*  363 */       this.cursor += 1;
/*      */     }
/*      */     
/*  366 */     this.I_p2 = this.cursor;
/*      */     label222:
/*  368 */     this.cursor = v_1;
/*  369 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_shortv()
/*      */   {
/*  377 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  380 */     if ((!out_grouping_b(g_v_WXY, 89, 121)) || 
/*      */     
/*      */ 
/*      */ 
/*  384 */       (!in_grouping_b(g_v, 97, 121)) || 
/*      */       
/*      */ 
/*      */ 
/*  388 */       (!out_grouping_b(g_v, 97, 121)))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  394 */       this.cursor = (this.limit - v_1);
/*      */       
/*  396 */       if (!out_grouping_b(g_v, 97, 121))
/*      */       {
/*  398 */         return false;
/*      */       }
/*  400 */       if (!in_grouping_b(g_v, 97, 121))
/*      */       {
/*  402 */         return false;
/*      */       }
/*      */       
/*  405 */       if (this.cursor > this.limit_backward)
/*      */       {
/*  407 */         return false;
/*      */       }
/*      */     }
/*  410 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_R1() {
/*  414 */     if (this.I_p1 > this.cursor)
/*      */     {
/*  416 */       return false;
/*      */     }
/*  418 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_R2() {
/*  422 */     if (this.I_p2 > this.cursor)
/*      */     {
/*  424 */       return false;
/*      */     }
/*  426 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_Step_1a()
/*      */   {
/*  435 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*  439 */     this.ket = this.cursor;
/*      */     
/*  441 */     int among_var = find_among_b(a_1, 3);
/*  442 */     if (among_var == 0)
/*      */     {
/*  444 */       this.cursor = (this.limit - v_1);
/*      */     }
/*      */     else
/*      */     {
/*  448 */       this.bra = this.cursor;
/*  449 */       switch (among_var) {
/*      */       case 0: 
/*  451 */         this.cursor = (this.limit - v_1);
/*  452 */         break;
/*      */       
/*      */ 
/*      */       case 1: 
/*  456 */         slice_del();
/*      */       }
/*      */       
/*      */     }
/*      */     
/*  461 */     this.ket = this.cursor;
/*      */     
/*  463 */     among_var = find_among_b(a_2, 6);
/*  464 */     if (among_var == 0)
/*      */     {
/*  466 */       return false;
/*      */     }
/*      */     
/*  469 */     this.bra = this.cursor;
/*  470 */     switch (among_var) {
/*      */     case 0: 
/*  472 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  476 */       slice_from("ss");
/*  477 */       break;
/*      */     
/*      */ 
/*      */ 
/*      */     case 2: 
/*  482 */       int v_2 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  487 */       int c = this.cursor - 2;
/*  488 */       if ((this.limit_backward <= c) && (c <= this.limit))
/*      */       {
/*      */ 
/*      */ 
/*  492 */         this.cursor = c;
/*      */         
/*      */ 
/*  495 */         slice_from("i");
/*      */       }
/*      */       else {
/*  498 */         this.cursor = (this.limit - v_2);
/*      */         
/*  500 */         slice_from("ie");
/*      */       }
/*  502 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  506 */       if (this.cursor <= this.limit_backward)
/*      */       {
/*  508 */         return false;
/*      */       }
/*  510 */       this.cursor -= 1;
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  515 */       while (!in_grouping_b(g_v, 97, 121))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  521 */         if (this.cursor <= this.limit_backward)
/*      */         {
/*  523 */           return false;
/*      */         }
/*  525 */         this.cursor -= 1;
/*      */       }
/*      */       
/*  528 */       slice_del();
/*      */     }
/*      */     
/*  531 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_Step_1b()
/*      */   {
/*  541 */     this.ket = this.cursor;
/*      */     
/*  543 */     int among_var = find_among_b(a_4, 6);
/*  544 */     if (among_var == 0)
/*      */     {
/*  546 */       return false;
/*      */     }
/*      */     
/*  549 */     this.bra = this.cursor;
/*  550 */     switch (among_var) {
/*      */     case 0: 
/*  552 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  556 */       if (!r_R1())
/*      */       {
/*  558 */         return false;
/*      */       }
/*      */       
/*  561 */       slice_from("ee");
/*  562 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  566 */       int v_1 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  571 */       while (!in_grouping_b(g_v, 97, 121))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  577 */         if (this.cursor <= this.limit_backward)
/*      */         {
/*  579 */           return false;
/*      */         }
/*  581 */         this.cursor -= 1;
/*      */       }
/*  583 */       this.cursor = (this.limit - v_1);
/*      */       
/*  585 */       slice_del();
/*      */       
/*  587 */       int v_3 = this.limit - this.cursor;
/*      */       
/*  589 */       among_var = find_among_b(a_3, 13);
/*  590 */       if (among_var == 0)
/*      */       {
/*  592 */         return false;
/*      */       }
/*  594 */       this.cursor = (this.limit - v_3);
/*  595 */       switch (among_var) {
/*      */       case 0: 
/*  597 */         return false;
/*      */       
/*      */ 
/*      */ 
/*      */       case 1: 
/*  602 */         int c = this.cursor;
/*  603 */         insert(this.cursor, this.cursor, "e");
/*  604 */         this.cursor = c;
/*      */         
/*  606 */         break;
/*      */       
/*      */ 
/*      */       case 2: 
/*  610 */         this.ket = this.cursor;
/*      */         
/*  612 */         if (this.cursor <= this.limit_backward)
/*      */         {
/*  614 */           return false;
/*      */         }
/*  616 */         this.cursor -= 1;
/*      */         
/*  618 */         this.bra = this.cursor;
/*      */         
/*  620 */         slice_del();
/*  621 */         break;
/*      */       
/*      */ 
/*      */       case 3: 
/*  625 */         if (this.cursor != this.I_p1)
/*      */         {
/*  627 */           return false;
/*      */         }
/*      */         
/*  630 */         int v_4 = this.limit - this.cursor;
/*      */         
/*  632 */         if (!r_shortv())
/*      */         {
/*  634 */           return false;
/*      */         }
/*  636 */         this.cursor = (this.limit - v_4);
/*      */         
/*      */ 
/*  639 */         int c = this.cursor;
/*  640 */         insert(this.cursor, this.cursor, "e");
/*  641 */         this.cursor = c;
/*      */       }
/*      */       
/*      */       break;
/*      */     }
/*      */     
/*  647 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_Step_1c()
/*      */   {
/*  655 */     this.ket = this.cursor;
/*      */     
/*      */ 
/*  658 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  661 */     if (!eq_s_b(1, "y"))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  667 */       this.cursor = (this.limit - v_1);
/*      */       
/*  669 */       if (!eq_s_b(1, "Y"))
/*      */       {
/*  671 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  675 */     this.bra = this.cursor;
/*  676 */     if (!out_grouping_b(g_v, 97, 121))
/*      */     {
/*  678 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  682 */     int v_2 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  685 */     if (this.cursor <= this.limit_backward)
/*      */     {
/*      */ 
/*      */ 
/*  689 */       return false;
/*      */     }
/*  691 */     this.cursor = (this.limit - v_2);
/*      */     
/*      */ 
/*  694 */     slice_from("i");
/*  695 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_Step_2()
/*      */   {
/*  702 */     this.ket = this.cursor;
/*      */     
/*  704 */     int among_var = find_among_b(a_5, 24);
/*  705 */     if (among_var == 0)
/*      */     {
/*  707 */       return false;
/*      */     }
/*      */     
/*  710 */     this.bra = this.cursor;
/*      */     
/*  712 */     if (!r_R1())
/*      */     {
/*  714 */       return false;
/*      */     }
/*  716 */     switch (among_var) {
/*      */     case 0: 
/*  718 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  722 */       slice_from("tion");
/*  723 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  727 */       slice_from("ence");
/*  728 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  732 */       slice_from("ance");
/*  733 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  737 */       slice_from("able");
/*  738 */       break;
/*      */     
/*      */ 
/*      */     case 5: 
/*  742 */       slice_from("ent");
/*  743 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/*  747 */       slice_from("ize");
/*  748 */       break;
/*      */     
/*      */ 
/*      */     case 7: 
/*  752 */       slice_from("ate");
/*  753 */       break;
/*      */     
/*      */ 
/*      */     case 8: 
/*  757 */       slice_from("al");
/*  758 */       break;
/*      */     
/*      */ 
/*      */     case 9: 
/*  762 */       slice_from("ful");
/*  763 */       break;
/*      */     
/*      */ 
/*      */     case 10: 
/*  767 */       slice_from("ous");
/*  768 */       break;
/*      */     
/*      */ 
/*      */     case 11: 
/*  772 */       slice_from("ive");
/*  773 */       break;
/*      */     
/*      */ 
/*      */     case 12: 
/*  777 */       slice_from("ble");
/*  778 */       break;
/*      */     
/*      */ 
/*      */     case 13: 
/*  782 */       if (!eq_s_b(1, "l"))
/*      */       {
/*  784 */         return false;
/*      */       }
/*      */       
/*  787 */       slice_from("og");
/*  788 */       break;
/*      */     
/*      */ 
/*      */     case 14: 
/*  792 */       slice_from("ful");
/*  793 */       break;
/*      */     
/*      */ 
/*      */     case 15: 
/*  797 */       slice_from("less");
/*  798 */       break;
/*      */     
/*      */     case 16: 
/*  801 */       if (!in_grouping_b(g_valid_LI, 99, 116))
/*      */       {
/*  803 */         return false;
/*      */       }
/*      */       
/*  806 */       slice_del();
/*      */     }
/*      */     
/*  809 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_Step_3()
/*      */   {
/*  816 */     this.ket = this.cursor;
/*      */     
/*  818 */     int among_var = find_among_b(a_6, 9);
/*  819 */     if (among_var == 0)
/*      */     {
/*  821 */       return false;
/*      */     }
/*      */     
/*  824 */     this.bra = this.cursor;
/*      */     
/*  826 */     if (!r_R1())
/*      */     {
/*  828 */       return false;
/*      */     }
/*  830 */     switch (among_var) {
/*      */     case 0: 
/*  832 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  836 */       slice_from("tion");
/*  837 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  841 */       slice_from("ate");
/*  842 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  846 */       slice_from("al");
/*  847 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  851 */       slice_from("ic");
/*  852 */       break;
/*      */     
/*      */ 
/*      */     case 5: 
/*  856 */       slice_del();
/*  857 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/*  861 */       if (!r_R2())
/*      */       {
/*  863 */         return false;
/*      */       }
/*      */       
/*  866 */       slice_del();
/*      */     }
/*      */     
/*  869 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_Step_4()
/*      */   {
/*  877 */     this.ket = this.cursor;
/*      */     
/*  879 */     int among_var = find_among_b(a_7, 18);
/*  880 */     if (among_var == 0)
/*      */     {
/*  882 */       return false;
/*      */     }
/*      */     
/*  885 */     this.bra = this.cursor;
/*      */     
/*  887 */     if (!r_R2())
/*      */     {
/*  889 */       return false;
/*      */     }
/*  891 */     switch (among_var) {
/*      */     case 0: 
/*  893 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  897 */       slice_del();
/*  898 */       break;
/*      */     
/*      */ 
/*      */ 
/*      */     case 2: 
/*  903 */       int v_1 = this.limit - this.cursor;
/*      */       
/*      */ 
/*  906 */       if (!eq_s_b(1, "s"))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  912 */         this.cursor = (this.limit - v_1);
/*      */         
/*  914 */         if (!eq_s_b(1, "t"))
/*      */         {
/*  916 */           return false;
/*      */         }
/*      */       }
/*      */       
/*  920 */       slice_del();
/*      */     }
/*      */     
/*  923 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_Step_5()
/*      */   {
/*  932 */     this.ket = this.cursor;
/*      */     
/*  934 */     int among_var = find_among_b(a_8, 2);
/*  935 */     if (among_var == 0)
/*      */     {
/*  937 */       return false;
/*      */     }
/*      */     
/*  940 */     this.bra = this.cursor;
/*  941 */     switch (among_var) {
/*      */     case 0: 
/*  943 */       return false;
/*      */     
/*      */ 
/*      */ 
/*      */     case 1: 
/*  948 */       int v_1 = this.limit - this.cursor;
/*      */       
/*      */ 
/*  951 */       if (!r_R2())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  957 */         this.cursor = (this.limit - v_1);
/*      */         
/*      */ 
/*  960 */         if (!r_R1())
/*      */         {
/*  962 */           return false;
/*      */         }
/*      */         
/*      */ 
/*  966 */         int v_2 = this.limit - this.cursor;
/*      */         
/*      */ 
/*  969 */         if (r_shortv())
/*      */         {
/*      */ 
/*      */ 
/*  973 */           return false;
/*      */         }
/*  975 */         this.cursor = (this.limit - v_2);
/*      */       }
/*      */       
/*      */ 
/*  979 */       slice_del();
/*  980 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  984 */       if (!r_R2())
/*      */       {
/*  986 */         return false;
/*      */       }
/*      */       
/*  989 */       if (!eq_s_b(1, "l"))
/*      */       {
/*  991 */         return false;
/*      */       }
/*      */       
/*  994 */       slice_del();
/*      */     }
/*      */     
/*  997 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_exception2()
/*      */   {
/* 1003 */     this.ket = this.cursor;
/*      */     
/* 1005 */     if (find_among_b(a_9, 8) == 0)
/*      */     {
/* 1007 */       return false;
/*      */     }
/*      */     
/* 1010 */     this.bra = this.cursor;
/*      */     
/* 1012 */     if (this.cursor > this.limit_backward)
/*      */     {
/* 1014 */       return false;
/*      */     }
/* 1016 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_exception1()
/*      */   {
/* 1023 */     this.bra = this.cursor;
/*      */     
/* 1025 */     int among_var = find_among(a_10, 18);
/* 1026 */     if (among_var == 0)
/*      */     {
/* 1028 */       return false;
/*      */     }
/*      */     
/* 1031 */     this.ket = this.cursor;
/*      */     
/* 1033 */     if (this.cursor < this.limit)
/*      */     {
/* 1035 */       return false;
/*      */     }
/* 1037 */     switch (among_var) {
/*      */     case 0: 
/* 1039 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/* 1043 */       slice_from("ski");
/* 1044 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/* 1048 */       slice_from("sky");
/* 1049 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/* 1053 */       slice_from("die");
/* 1054 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/* 1058 */       slice_from("lie");
/* 1059 */       break;
/*      */     
/*      */ 
/*      */     case 5: 
/* 1063 */       slice_from("tie");
/* 1064 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/* 1068 */       slice_from("idl");
/* 1069 */       break;
/*      */     
/*      */ 
/*      */     case 7: 
/* 1073 */       slice_from("gentl");
/* 1074 */       break;
/*      */     
/*      */ 
/*      */     case 8: 
/* 1078 */       slice_from("ugli");
/* 1079 */       break;
/*      */     
/*      */ 
/*      */     case 9: 
/* 1083 */       slice_from("earli");
/* 1084 */       break;
/*      */     
/*      */ 
/*      */     case 10: 
/* 1088 */       slice_from("onli");
/* 1089 */       break;
/*      */     
/*      */ 
/*      */     case 11: 
/* 1093 */       slice_from("singl");
/*      */     }
/*      */     
/* 1096 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_postlude()
/*      */   {
/* 1104 */     if (!this.B_Y_found)
/*      */     {
/* 1106 */       return false;
/*      */     }
/*      */     int v_1;
/*      */     for (;;)
/*      */     {
/* 1111 */       v_1 = this.cursor;
/*      */       
/*      */ 
/*      */ 
/*      */       for (;;)
/*      */       {
/* 1117 */         int v_2 = this.cursor;
/*      */         
/*      */ 
/*      */ 
/* 1121 */         this.bra = this.cursor;
/*      */         
/* 1123 */         if (eq_s(1, "Y"))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1128 */           this.ket = this.cursor;
/* 1129 */           this.cursor = v_2;
/* 1130 */           break;
/*      */         }
/* 1132 */         this.cursor = v_2;
/* 1133 */         if (this.cursor >= this.limit) {
/*      */           break label99;
/*      */         }
/*      */         
/* 1137 */         this.cursor += 1;
/*      */       }
/*      */       int v_2;
/* 1140 */       slice_from("y");
/*      */     }
/*      */     label99:
/* 1143 */     this.cursor = v_1;
/*      */     
/*      */ 
/* 1146 */     return true;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean stem()
/*      */   {
/* 1166 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/* 1169 */     if (!r_exception1())
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1175 */       this.cursor = v_1;
/*      */       
/*      */ 
/*      */ 
/* 1179 */       int v_2 = this.cursor;
/*      */       
/*      */ 
/*      */ 
/* 1183 */       int c = this.cursor + 3;
/* 1184 */       if ((c >= 0) && (c <= this.limit))
/*      */       {
/*      */ 
/*      */ 
/* 1188 */         this.cursor = c;
/*      */       }
/*      */       else
/*      */       {
/* 1192 */         this.cursor = v_2;
/*      */         
/*      */         break label380;
/*      */       }
/* 1196 */       this.cursor = v_1;
/*      */       
/*      */ 
/* 1199 */       int v_3 = this.cursor;
/*      */       
/*      */ 
/* 1202 */       if (!r_prelude()) {}
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1207 */       this.cursor = v_3;
/*      */       
/* 1209 */       int v_4 = this.cursor;
/*      */       
/*      */ 
/* 1212 */       if (!r_mark_regions()) {}
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1217 */       this.cursor = v_4;
/*      */       
/* 1219 */       this.limit_backward = this.cursor;this.cursor = this.limit;
/*      */       
/*      */ 
/* 1222 */       int v_5 = this.limit - this.cursor;
/*      */       
/*      */ 
/* 1225 */       if (!r_Step_1a()) {}
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1230 */       this.cursor = (this.limit - v_5);
/*      */       
/*      */ 
/* 1233 */       int v_6 = this.limit - this.cursor;
/*      */       
/*      */ 
/* 1236 */       if (!r_exception2())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1242 */         this.cursor = (this.limit - v_6);
/*      */         
/*      */ 
/* 1245 */         int v_7 = this.limit - this.cursor;
/*      */         
/*      */ 
/* 1248 */         if (!r_Step_1b()) {}
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1253 */         this.cursor = (this.limit - v_7);
/*      */         
/* 1255 */         int v_8 = this.limit - this.cursor;
/*      */         
/*      */ 
/* 1258 */         if (!r_Step_1c()) {}
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1263 */         this.cursor = (this.limit - v_8);
/*      */         
/* 1265 */         int v_9 = this.limit - this.cursor;
/*      */         
/*      */ 
/* 1268 */         if (!r_Step_2()) {}
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1273 */         this.cursor = (this.limit - v_9);
/*      */         
/* 1275 */         int v_10 = this.limit - this.cursor;
/*      */         
/*      */ 
/* 1278 */         if (!r_Step_3()) {}
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1283 */         this.cursor = (this.limit - v_10);
/*      */         
/* 1285 */         int v_11 = this.limit - this.cursor;
/*      */         
/*      */ 
/* 1288 */         if (!r_Step_4()) {}
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1293 */         this.cursor = (this.limit - v_11);
/*      */         
/* 1295 */         int v_12 = this.limit - this.cursor;
/*      */         
/*      */ 
/* 1298 */         if (!r_Step_5()) {}
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1303 */         this.cursor = (this.limit - v_12);
/*      */       }
/* 1305 */       this.cursor = this.limit_backward;
/* 1306 */       int v_13 = this.cursor;
/*      */       
/*      */ 
/* 1309 */       if (!r_postlude()) {}
/*      */       
/*      */ 
/*      */ 
/*      */ 
/* 1314 */       this.cursor = v_13; }
/*      */     label380:
/* 1316 */     return true;
/*      */   }
/*      */   
/*      */   public boolean equals(Object o) {
/* 1320 */     return o instanceof englishStemmer;
/*      */   }
/*      */   
/*      */   public int hashCode() {
/* 1324 */     return englishStemmer.class.getName().hashCode();
/*      */   }
/*      */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\englishStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */