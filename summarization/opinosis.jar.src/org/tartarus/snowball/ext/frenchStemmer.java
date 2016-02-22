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
/*      */ public class frenchStemmer
/*      */   extends SnowballStemmer
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*   16 */   private static final frenchStemmer methodObject = new frenchStemmer();
/*      */   
/*   18 */   private static final Among[] a_0 = {
/*   19 */     new Among("col", -1, -1, "", methodObject), 
/*   20 */     new Among("par", -1, -1, "", methodObject), 
/*   21 */     new Among("tap", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   24 */   private static final Among[] a_1 = {
/*   25 */     new Among("", -1, 4, "", methodObject), 
/*   26 */     new Among("I", 0, 1, "", methodObject), 
/*   27 */     new Among("U", 0, 2, "", methodObject), 
/*   28 */     new Among("Y", 0, 3, "", methodObject) };
/*      */   
/*      */ 
/*   31 */   private static final Among[] a_2 = {
/*   32 */     new Among("iqU", -1, 3, "", methodObject), 
/*   33 */     new Among("abl", -1, 3, "", methodObject), 
/*   34 */     new Among("Ièr", -1, 4, "", methodObject), 
/*   35 */     new Among("ièr", -1, 4, "", methodObject), 
/*   36 */     new Among("eus", -1, 2, "", methodObject), 
/*   37 */     new Among("iv", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*   40 */   private static final Among[] a_3 = {
/*   41 */     new Among("ic", -1, 2, "", methodObject), 
/*   42 */     new Among("abil", -1, 1, "", methodObject), 
/*   43 */     new Among("iv", -1, 3, "", methodObject) };
/*      */   
/*      */ 
/*   46 */   private static final Among[] a_4 = {
/*   47 */     new Among("iqUe", -1, 1, "", methodObject), 
/*   48 */     new Among("atrice", -1, 2, "", methodObject), 
/*   49 */     new Among("ance", -1, 1, "", methodObject), 
/*   50 */     new Among("ence", -1, 5, "", methodObject), 
/*   51 */     new Among("logie", -1, 3, "", methodObject), 
/*   52 */     new Among("able", -1, 1, "", methodObject), 
/*   53 */     new Among("isme", -1, 1, "", methodObject), 
/*   54 */     new Among("euse", -1, 11, "", methodObject), 
/*   55 */     new Among("iste", -1, 1, "", methodObject), 
/*   56 */     new Among("ive", -1, 8, "", methodObject), 
/*   57 */     new Among("if", -1, 8, "", methodObject), 
/*   58 */     new Among("usion", -1, 4, "", methodObject), 
/*   59 */     new Among("ation", -1, 2, "", methodObject), 
/*   60 */     new Among("ution", -1, 4, "", methodObject), 
/*   61 */     new Among("ateur", -1, 2, "", methodObject), 
/*   62 */     new Among("iqUes", -1, 1, "", methodObject), 
/*   63 */     new Among("atrices", -1, 2, "", methodObject), 
/*   64 */     new Among("ances", -1, 1, "", methodObject), 
/*   65 */     new Among("ences", -1, 5, "", methodObject), 
/*   66 */     new Among("logies", -1, 3, "", methodObject), 
/*   67 */     new Among("ables", -1, 1, "", methodObject), 
/*   68 */     new Among("ismes", -1, 1, "", methodObject), 
/*   69 */     new Among("euses", -1, 11, "", methodObject), 
/*   70 */     new Among("istes", -1, 1, "", methodObject), 
/*   71 */     new Among("ives", -1, 8, "", methodObject), 
/*   72 */     new Among("ifs", -1, 8, "", methodObject), 
/*   73 */     new Among("usions", -1, 4, "", methodObject), 
/*   74 */     new Among("ations", -1, 2, "", methodObject), 
/*   75 */     new Among("utions", -1, 4, "", methodObject), 
/*   76 */     new Among("ateurs", -1, 2, "", methodObject), 
/*   77 */     new Among("ments", -1, 15, "", methodObject), 
/*   78 */     new Among("ements", 30, 6, "", methodObject), 
/*   79 */     new Among("issements", 31, 12, "", methodObject), 
/*   80 */     new Among("ités", -1, 7, "", methodObject), 
/*   81 */     new Among("ment", -1, 15, "", methodObject), 
/*   82 */     new Among("ement", 34, 6, "", methodObject), 
/*   83 */     new Among("issement", 35, 12, "", methodObject), 
/*   84 */     new Among("amment", 34, 13, "", methodObject), 
/*   85 */     new Among("emment", 34, 14, "", methodObject), 
/*   86 */     new Among("aux", -1, 10, "", methodObject), 
/*   87 */     new Among("eaux", 39, 9, "", methodObject), 
/*   88 */     new Among("eux", -1, 1, "", methodObject), 
/*   89 */     new Among("ité", -1, 7, "", methodObject) };
/*      */   
/*      */ 
/*   92 */   private static final Among[] a_5 = {
/*   93 */     new Among("ira", -1, 1, "", methodObject), 
/*   94 */     new Among("ie", -1, 1, "", methodObject), 
/*   95 */     new Among("isse", -1, 1, "", methodObject), 
/*   96 */     new Among("issante", -1, 1, "", methodObject), 
/*   97 */     new Among("i", -1, 1, "", methodObject), 
/*   98 */     new Among("irai", 4, 1, "", methodObject), 
/*   99 */     new Among("ir", -1, 1, "", methodObject), 
/*  100 */     new Among("iras", -1, 1, "", methodObject), 
/*  101 */     new Among("ies", -1, 1, "", methodObject), 
/*  102 */     new Among("îmes", -1, 1, "", methodObject), 
/*  103 */     new Among("isses", -1, 1, "", methodObject), 
/*  104 */     new Among("issantes", -1, 1, "", methodObject), 
/*  105 */     new Among("îtes", -1, 1, "", methodObject), 
/*  106 */     new Among("is", -1, 1, "", methodObject), 
/*  107 */     new Among("irais", 13, 1, "", methodObject), 
/*  108 */     new Among("issais", 13, 1, "", methodObject), 
/*  109 */     new Among("irions", -1, 1, "", methodObject), 
/*  110 */     new Among("issions", -1, 1, "", methodObject), 
/*  111 */     new Among("irons", -1, 1, "", methodObject), 
/*  112 */     new Among("issons", -1, 1, "", methodObject), 
/*  113 */     new Among("issants", -1, 1, "", methodObject), 
/*  114 */     new Among("it", -1, 1, "", methodObject), 
/*  115 */     new Among("irait", 21, 1, "", methodObject), 
/*  116 */     new Among("issait", 21, 1, "", methodObject), 
/*  117 */     new Among("issant", -1, 1, "", methodObject), 
/*  118 */     new Among("iraIent", -1, 1, "", methodObject), 
/*  119 */     new Among("issaIent", -1, 1, "", methodObject), 
/*  120 */     new Among("irent", -1, 1, "", methodObject), 
/*  121 */     new Among("issent", -1, 1, "", methodObject), 
/*  122 */     new Among("iront", -1, 1, "", methodObject), 
/*  123 */     new Among("ît", -1, 1, "", methodObject), 
/*  124 */     new Among("iriez", -1, 1, "", methodObject), 
/*  125 */     new Among("issiez", -1, 1, "", methodObject), 
/*  126 */     new Among("irez", -1, 1, "", methodObject), 
/*  127 */     new Among("issez", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*  130 */   private static final Among[] a_6 = {
/*  131 */     new Among("a", -1, 3, "", methodObject), 
/*  132 */     new Among("era", 0, 2, "", methodObject), 
/*  133 */     new Among("asse", -1, 3, "", methodObject), 
/*  134 */     new Among("ante", -1, 3, "", methodObject), 
/*  135 */     new Among("ée", -1, 2, "", methodObject), 
/*  136 */     new Among("ai", -1, 3, "", methodObject), 
/*  137 */     new Among("erai", 5, 2, "", methodObject), 
/*  138 */     new Among("er", -1, 2, "", methodObject), 
/*  139 */     new Among("as", -1, 3, "", methodObject), 
/*  140 */     new Among("eras", 8, 2, "", methodObject), 
/*  141 */     new Among("âmes", -1, 3, "", methodObject), 
/*  142 */     new Among("asses", -1, 3, "", methodObject), 
/*  143 */     new Among("antes", -1, 3, "", methodObject), 
/*  144 */     new Among("âtes", -1, 3, "", methodObject), 
/*  145 */     new Among("ées", -1, 2, "", methodObject), 
/*  146 */     new Among("ais", -1, 3, "", methodObject), 
/*  147 */     new Among("erais", 15, 2, "", methodObject), 
/*  148 */     new Among("ions", -1, 1, "", methodObject), 
/*  149 */     new Among("erions", 17, 2, "", methodObject), 
/*  150 */     new Among("assions", 17, 3, "", methodObject), 
/*  151 */     new Among("erons", -1, 2, "", methodObject), 
/*  152 */     new Among("ants", -1, 3, "", methodObject), 
/*  153 */     new Among("és", -1, 2, "", methodObject), 
/*  154 */     new Among("ait", -1, 3, "", methodObject), 
/*  155 */     new Among("erait", 23, 2, "", methodObject), 
/*  156 */     new Among("ant", -1, 3, "", methodObject), 
/*  157 */     new Among("aIent", -1, 3, "", methodObject), 
/*  158 */     new Among("eraIent", 26, 2, "", methodObject), 
/*  159 */     new Among("èrent", -1, 2, "", methodObject), 
/*  160 */     new Among("assent", -1, 3, "", methodObject), 
/*  161 */     new Among("eront", -1, 2, "", methodObject), 
/*  162 */     new Among("ât", -1, 3, "", methodObject), 
/*  163 */     new Among("ez", -1, 2, "", methodObject), 
/*  164 */     new Among("iez", 32, 2, "", methodObject), 
/*  165 */     new Among("eriez", 33, 2, "", methodObject), 
/*  166 */     new Among("assiez", 33, 3, "", methodObject), 
/*  167 */     new Among("erez", 32, 2, "", methodObject), 
/*  168 */     new Among("é", -1, 2, "", methodObject) };
/*      */   
/*      */ 
/*  171 */   private static final Among[] a_7 = {
/*  172 */     new Among("e", -1, 3, "", methodObject), 
/*  173 */     new Among("Ière", 0, 2, "", methodObject), 
/*  174 */     new Among("ière", 0, 2, "", methodObject), 
/*  175 */     new Among("ion", -1, 1, "", methodObject), 
/*  176 */     new Among("Ier", -1, 2, "", methodObject), 
/*  177 */     new Among("ier", -1, 2, "", methodObject), 
/*  178 */     new Among("ë", -1, 4, "", methodObject) };
/*      */   
/*      */ 
/*  181 */   private static final Among[] a_8 = {
/*  182 */     new Among("ell", -1, -1, "", methodObject), 
/*  183 */     new Among("eill", -1, -1, "", methodObject), 
/*  184 */     new Among("enn", -1, -1, "", methodObject), 
/*  185 */     new Among("onn", -1, -1, "", methodObject), 
/*  186 */     new Among("ett", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  189 */   private static final char[] g_v = { '\021', 'A', '\020', '\001', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '', '', 'g', '\b', '\005' };
/*      */   
/*  191 */   private static final char[] g_keep_with_s = { '\001', 'A', '\024', '\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''' };
/*      */   private int I_p2;
/*      */   private int I_p1;
/*      */   private int I_pV;
/*      */   
/*      */   private void copy_from(frenchStemmer other)
/*      */   {
/*  198 */     this.I_p2 = other.I_p2;
/*  199 */     this.I_p1 = other.I_p1;
/*  200 */     this.I_pV = other.I_pV;
/*  201 */     super.copy_from(other);
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
/*  212 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/*      */     for (;;)
/*      */     {
/*  217 */       int v_2 = this.cursor;
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  222 */       int v_3 = this.cursor;
/*      */       
/*      */ 
/*  225 */       if (in_grouping(g_v, 97, 251))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  230 */         this.bra = this.cursor;
/*      */         
/*      */ 
/*  233 */         int v_4 = this.cursor;
/*      */         
/*      */ 
/*      */ 
/*  237 */         if (eq_s(1, "u"))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  242 */           this.ket = this.cursor;
/*  243 */           if (in_grouping(g_v, 97, 251))
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*  248 */             slice_from("U");
/*      */             break label304;
/*      */           } }
/*  251 */         this.cursor = v_4;
/*      */         
/*      */ 
/*      */ 
/*  255 */         if (eq_s(1, "i"))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  260 */           this.ket = this.cursor;
/*  261 */           if (in_grouping(g_v, 97, 251))
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*  266 */             slice_from("I");
/*      */             break label304;
/*      */           } }
/*  269 */         this.cursor = v_4;
/*      */         
/*      */ 
/*  272 */         if (eq_s(1, "y"))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  277 */           this.ket = this.cursor;
/*      */           
/*  279 */           slice_from("Y");
/*      */           break label304;
/*      */         }
/*      */       }
/*  283 */       this.cursor = v_3;
/*      */       
/*      */ 
/*      */ 
/*  287 */       this.bra = this.cursor;
/*      */       
/*  289 */       if (eq_s(1, "y"))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  294 */         this.ket = this.cursor;
/*  295 */         if (in_grouping(g_v, 97, 251))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  300 */           slice_from("Y");
/*      */           break label304;
/*      */         } }
/*  303 */       this.cursor = v_3;
/*      */       
/*      */ 
/*  306 */       if (eq_s(1, "q"))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  311 */         this.bra = this.cursor;
/*      */         
/*  313 */         if (eq_s(1, "u"))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  318 */           this.ket = this.cursor;
/*      */           
/*  320 */           slice_from("U");
/*      */           label304:
/*  322 */           this.cursor = v_2;
/*  323 */           break;
/*      */         } }
/*  325 */       this.cursor = v_2;
/*  326 */       if (this.cursor >= this.limit) {
/*      */         break label344;
/*      */       }
/*      */       
/*  330 */       this.cursor += 1; }
/*      */     label344:
/*      */     int v_3;
/*      */     int v_2;
/*  334 */     this.cursor = v_1;
/*      */     
/*      */ 
/*  337 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_mark_regions()
/*      */   {
/*  345 */     this.I_pV = this.limit;
/*  346 */     this.I_p1 = this.limit;
/*  347 */     this.I_p2 = this.limit;
/*      */     
/*  349 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  354 */     int v_2 = this.cursor;
/*      */     
/*      */ 
/*  357 */     if (in_grouping(g_v, 97, 251))
/*      */     {
/*      */ 
/*      */ 
/*  361 */       if (in_grouping(g_v, 97, 251))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  366 */         if (this.cursor < this.limit)
/*      */         {
/*      */ 
/*      */ 
/*  370 */           this.cursor += 1;
/*      */           break label184;
/*      */         } } }
/*  373 */     this.cursor = v_2;
/*      */     
/*      */ 
/*  376 */     if (find_among(a_0, 3) == 0)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  382 */       this.cursor = v_2;
/*      */       
/*      */ 
/*  385 */       if (this.cursor < this.limit)
/*      */       {
/*      */ 
/*      */ 
/*  389 */         this.cursor += 1;
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  394 */         while (!in_grouping(g_v, 97, 251))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  400 */           if (this.cursor >= this.limit) {
/*      */             break label192;
/*      */           }
/*      */           
/*  404 */           this.cursor += 1;
/*      */         }
/*      */       }
/*      */     } else { label184:
/*  408 */       this.I_pV = this.cursor; }
/*      */     label192:
/*  410 */     this.cursor = v_1;
/*      */     
/*  412 */     int v_4 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  419 */     while (!in_grouping(g_v, 97, 251))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  425 */       if (this.cursor >= this.limit) {
/*      */         break label386;
/*      */       }
/*      */       
/*  429 */       this.cursor += 1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  435 */     while (!out_grouping(g_v, 97, 251))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  441 */       if (this.cursor >= this.limit) {
/*      */         break label386;
/*      */       }
/*      */       
/*  445 */       this.cursor += 1;
/*      */     }
/*      */     
/*  448 */     this.I_p1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  453 */     while (!in_grouping(g_v, 97, 251))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  459 */       if (this.cursor >= this.limit) {
/*      */         break label386;
/*      */       }
/*      */       
/*  463 */       this.cursor += 1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  469 */     while (!out_grouping(g_v, 97, 251))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  475 */       if (this.cursor >= this.limit) {
/*      */         break label386;
/*      */       }
/*      */       
/*  479 */       this.cursor += 1;
/*      */     }
/*      */     
/*  482 */     this.I_p2 = this.cursor;
/*      */     label386:
/*  484 */     this.cursor = v_4;
/*  485 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_postlude()
/*      */   {
/*      */     int v_1;
/*      */     for (;;)
/*      */     {
/*  494 */       v_1 = this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  498 */       this.bra = this.cursor;
/*      */       
/*  500 */       int among_var = find_among(a_1, 4);
/*  501 */       if (among_var == 0) {
/*      */         break;
/*      */       }
/*      */       
/*      */ 
/*  506 */       this.ket = this.cursor;
/*  507 */       switch (among_var)
/*      */       {
/*      */       case 0: 
/*      */         break;
/*      */       
/*      */       case 1: 
/*  513 */         slice_from("i");
/*  514 */         break;
/*      */       
/*      */ 
/*      */       case 2: 
/*  518 */         slice_from("u");
/*  519 */         break;
/*      */       
/*      */ 
/*      */       case 3: 
/*  523 */         slice_from("y");
/*  524 */         break;
/*      */       
/*      */ 
/*      */       case 4: 
/*  528 */         if (this.cursor >= this.limit) {
/*      */           break label131;
/*      */         }
/*      */         
/*  532 */         this.cursor += 1;
/*      */       }
/*      */       
/*      */     }
/*      */     label131:
/*  537 */     this.cursor = v_1;
/*      */     
/*      */ 
/*  540 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_RV() {
/*  544 */     if (this.I_pV > this.cursor)
/*      */     {
/*  546 */       return false;
/*      */     }
/*  548 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_R1() {
/*  552 */     if (this.I_p1 > this.cursor)
/*      */     {
/*  554 */       return false;
/*      */     }
/*  556 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_R2() {
/*  560 */     if (this.I_p2 > this.cursor)
/*      */     {
/*  562 */       return false;
/*      */     }
/*  564 */     return true;
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
/*      */   private boolean r_standard_suffix()
/*      */   {
/*  582 */     this.ket = this.cursor;
/*      */     
/*  584 */     int among_var = find_among_b(a_4, 43);
/*  585 */     if (among_var == 0)
/*      */     {
/*  587 */       return false;
/*      */     }
/*      */     
/*  590 */     this.bra = this.cursor;
/*  591 */     switch (among_var) {
/*      */     case 0: 
/*  593 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  597 */       if (!r_R2())
/*      */       {
/*  599 */         return false;
/*      */       }
/*      */       
/*  602 */       slice_del();
/*  603 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  607 */       if (!r_R2())
/*      */       {
/*  609 */         return false;
/*      */       }
/*      */       
/*  612 */       slice_del();
/*      */       
/*  614 */       int v_1 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  618 */       this.ket = this.cursor;
/*      */       
/*  620 */       if (!eq_s_b(2, "ic"))
/*      */       {
/*  622 */         this.cursor = (this.limit - v_1);
/*      */       }
/*      */       else
/*      */       {
/*  626 */         this.bra = this.cursor;
/*      */         
/*      */ 
/*  629 */         int v_2 = this.limit - this.cursor;
/*      */         
/*      */ 
/*      */ 
/*  633 */         if (r_R2())
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  638 */           slice_del();
/*      */         }
/*      */         else {
/*  641 */           this.cursor = (this.limit - v_2);
/*      */           
/*  643 */           slice_from("iqU");
/*      */         }
/*      */       }
/*  646 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  650 */       if (!r_R2())
/*      */       {
/*  652 */         return false;
/*      */       }
/*      */       
/*  655 */       slice_from("log");
/*  656 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  660 */       if (!r_R2())
/*      */       {
/*  662 */         return false;
/*      */       }
/*      */       
/*  665 */       slice_from("u");
/*  666 */       break;
/*      */     
/*      */ 
/*      */     case 5: 
/*  670 */       if (!r_R2())
/*      */       {
/*  672 */         return false;
/*      */       }
/*      */       
/*  675 */       slice_from("ent");
/*  676 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/*  680 */       if (!r_RV())
/*      */       {
/*  682 */         return false;
/*      */       }
/*      */       
/*  685 */       slice_del();
/*      */       
/*  687 */       int v_3 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  691 */       this.ket = this.cursor;
/*      */       
/*  693 */       among_var = find_among_b(a_2, 6);
/*  694 */       if (among_var == 0)
/*      */       {
/*  696 */         this.cursor = (this.limit - v_3);
/*      */       }
/*      */       else
/*      */       {
/*  700 */         this.bra = this.cursor;
/*  701 */         switch (among_var) {
/*      */         case 0: 
/*  703 */           this.cursor = (this.limit - v_3);
/*  704 */           break;
/*      */         
/*      */ 
/*      */         case 1: 
/*  708 */           if (!r_R2())
/*      */           {
/*  710 */             this.cursor = (this.limit - v_3);
/*      */           }
/*      */           else
/*      */           {
/*  714 */             slice_del();
/*      */             
/*  716 */             this.ket = this.cursor;
/*      */             
/*  718 */             if (!eq_s_b(2, "at"))
/*      */             {
/*  720 */               this.cursor = (this.limit - v_3);
/*      */             }
/*      */             else
/*      */             {
/*  724 */               this.bra = this.cursor;
/*      */               
/*  726 */               if (!r_R2())
/*      */               {
/*  728 */                 this.cursor = (this.limit - v_3);
/*      */               }
/*      */               else
/*      */               {
/*  732 */                 slice_del(); } } }
/*  733 */           break;
/*      */         
/*      */ 
/*      */ 
/*      */         case 2: 
/*  738 */           int v_4 = this.limit - this.cursor;
/*      */           
/*      */ 
/*      */ 
/*  742 */           if (r_R2())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*  747 */             slice_del();
/*      */           }
/*      */           else {
/*  750 */             this.cursor = (this.limit - v_4);
/*      */             
/*      */ 
/*  753 */             if (!r_R1())
/*      */             {
/*  755 */               this.cursor = (this.limit - v_3);
/*      */             }
/*      */             else
/*      */             {
/*  759 */               slice_from("eux"); }
/*      */           }
/*  761 */           break;
/*      */         
/*      */ 
/*      */         case 3: 
/*  765 */           if (!r_R2())
/*      */           {
/*  767 */             this.cursor = (this.limit - v_3);
/*      */           }
/*      */           else
/*      */           {
/*  771 */             slice_del(); }
/*  772 */           break;
/*      */         
/*      */ 
/*      */         case 4: 
/*  776 */           if (!r_RV())
/*      */           {
/*  778 */             this.cursor = (this.limit - v_3);
/*      */           }
/*      */           else
/*      */           {
/*  782 */             slice_from("i"); }
/*      */           break;
/*      */         }
/*      */       }
/*  786 */       break;
/*      */     
/*      */ 
/*      */     case 7: 
/*  790 */       if (!r_R2())
/*      */       {
/*  792 */         return false;
/*      */       }
/*      */       
/*  795 */       slice_del();
/*      */       
/*  797 */       int v_5 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  801 */       this.ket = this.cursor;
/*      */       
/*  803 */       among_var = find_among_b(a_3, 3);
/*  804 */       if (among_var == 0)
/*      */       {
/*  806 */         this.cursor = (this.limit - v_5);
/*      */       }
/*      */       else
/*      */       {
/*  810 */         this.bra = this.cursor;
/*  811 */         switch (among_var) {
/*      */         case 0: 
/*  813 */           this.cursor = (this.limit - v_5);
/*  814 */           break;
/*      */         
/*      */ 
/*      */ 
/*      */         case 1: 
/*  819 */           int v_6 = this.limit - this.cursor;
/*      */           
/*      */ 
/*      */ 
/*  823 */           if (r_R2())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*  828 */             slice_del();
/*      */           }
/*      */           else {
/*  831 */             this.cursor = (this.limit - v_6);
/*      */             
/*  833 */             slice_from("abl");
/*      */           }
/*  835 */           break;
/*      */         
/*      */ 
/*      */ 
/*      */         case 2: 
/*  840 */           int v_7 = this.limit - this.cursor;
/*      */           
/*      */ 
/*      */ 
/*  844 */           if (r_R2())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*  849 */             slice_del();
/*      */           }
/*      */           else {
/*  852 */             this.cursor = (this.limit - v_7);
/*      */             
/*  854 */             slice_from("iqU");
/*      */           }
/*  856 */           break;
/*      */         
/*      */ 
/*      */         case 3: 
/*  860 */           if (!r_R2())
/*      */           {
/*  862 */             this.cursor = (this.limit - v_5);
/*      */           }
/*      */           else
/*      */           {
/*  866 */             slice_del(); }
/*      */           break;
/*      */         }
/*      */       }
/*  870 */       break;
/*      */     
/*      */ 
/*      */     case 8: 
/*  874 */       if (!r_R2())
/*      */       {
/*  876 */         return false;
/*      */       }
/*      */       
/*  879 */       slice_del();
/*      */       
/*  881 */       int v_8 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  885 */       this.ket = this.cursor;
/*      */       
/*  887 */       if (!eq_s_b(2, "at"))
/*      */       {
/*  889 */         this.cursor = (this.limit - v_8);
/*      */       }
/*      */       else
/*      */       {
/*  893 */         this.bra = this.cursor;
/*      */         
/*  895 */         if (!r_R2())
/*      */         {
/*  897 */           this.cursor = (this.limit - v_8);
/*      */         }
/*      */         else
/*      */         {
/*  901 */           slice_del();
/*      */           
/*  903 */           this.ket = this.cursor;
/*      */           
/*  905 */           if (!eq_s_b(2, "ic"))
/*      */           {
/*  907 */             this.cursor = (this.limit - v_8);
/*      */           }
/*      */           else
/*      */           {
/*  911 */             this.bra = this.cursor;
/*      */             
/*      */ 
/*  914 */             int v_9 = this.limit - this.cursor;
/*      */             
/*      */ 
/*      */ 
/*  918 */             if (r_R2())
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*  923 */               slice_del();
/*      */             }
/*      */             else {
/*  926 */               this.cursor = (this.limit - v_9);
/*      */               
/*  928 */               slice_from("iqU");
/*      */             }
/*      */           } } }
/*  931 */       break;
/*      */     
/*      */ 
/*      */     case 9: 
/*  935 */       slice_from("eau");
/*  936 */       break;
/*      */     
/*      */ 
/*      */     case 10: 
/*  940 */       if (!r_R1())
/*      */       {
/*  942 */         return false;
/*      */       }
/*      */       
/*  945 */       slice_from("al");
/*  946 */       break;
/*      */     
/*      */ 
/*      */ 
/*      */     case 11: 
/*  951 */       int v_10 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  955 */       if (r_R2())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  960 */         slice_del();
/*      */       }
/*      */       else {
/*  963 */         this.cursor = (this.limit - v_10);
/*      */         
/*      */ 
/*  966 */         if (!r_R1())
/*      */         {
/*  968 */           return false;
/*      */         }
/*      */         
/*  971 */         slice_from("eux");
/*      */       }
/*  973 */       break;
/*      */     
/*      */ 
/*      */     case 12: 
/*  977 */       if (!r_R1())
/*      */       {
/*  979 */         return false;
/*      */       }
/*  981 */       if (!out_grouping_b(g_v, 97, 251))
/*      */       {
/*  983 */         return false;
/*      */       }
/*      */       
/*  986 */       slice_del();
/*  987 */       break;
/*      */     
/*      */ 
/*      */     case 13: 
/*  991 */       if (!r_RV())
/*      */       {
/*  993 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*  998 */       slice_from("ant");
/*  999 */       return false;
/*      */     
/*      */ 
/*      */     case 14: 
/* 1003 */       if (!r_RV())
/*      */       {
/* 1005 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 1010 */       slice_from("ent");
/* 1011 */       return false;
/*      */     
/*      */ 
/*      */     case 15: 
/* 1015 */       int v_11 = this.limit - this.cursor;
/*      */       
/* 1017 */       if (!in_grouping_b(g_v, 97, 251))
/*      */       {
/* 1019 */         return false;
/*      */       }
/*      */       
/* 1022 */       if (!r_RV())
/*      */       {
/* 1024 */         return false;
/*      */       }
/* 1026 */       this.cursor = (this.limit - v_11);
/*      */       
/*      */ 
/*      */ 
/* 1030 */       slice_del();
/* 1031 */       return false;
/*      */     }
/* 1033 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_i_verb_suffix()
/*      */   {
/* 1041 */     int v_1 = this.limit - this.cursor;
/*      */     
/* 1043 */     if (this.cursor < this.I_pV)
/*      */     {
/* 1045 */       return false;
/*      */     }
/* 1047 */     this.cursor = this.I_pV;
/* 1048 */     int v_2 = this.limit_backward;
/* 1049 */     this.limit_backward = this.cursor;
/* 1050 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/* 1053 */     this.ket = this.cursor;
/*      */     
/* 1055 */     int among_var = find_among_b(a_5, 35);
/* 1056 */     if (among_var == 0)
/*      */     {
/* 1058 */       this.limit_backward = v_2;
/* 1059 */       return false;
/*      */     }
/*      */     
/* 1062 */     this.bra = this.cursor;
/* 1063 */     switch (among_var) {
/*      */     case 0: 
/* 1065 */       this.limit_backward = v_2;
/* 1066 */       return false;
/*      */     
/*      */     case 1: 
/* 1069 */       if (!out_grouping_b(g_v, 97, 251))
/*      */       {
/* 1071 */         this.limit_backward = v_2;
/* 1072 */         return false;
/*      */       }
/*      */       
/* 1075 */       slice_del();
/*      */     }
/*      */     
/* 1078 */     this.limit_backward = v_2;
/* 1079 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_verb_suffix()
/*      */   {
/* 1088 */     int v_1 = this.limit - this.cursor;
/*      */     
/* 1090 */     if (this.cursor < this.I_pV)
/*      */     {
/* 1092 */       return false;
/*      */     }
/* 1094 */     this.cursor = this.I_pV;
/* 1095 */     int v_2 = this.limit_backward;
/* 1096 */     this.limit_backward = this.cursor;
/* 1097 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/* 1100 */     this.ket = this.cursor;
/*      */     
/* 1102 */     int among_var = find_among_b(a_6, 38);
/* 1103 */     if (among_var == 0)
/*      */     {
/* 1105 */       this.limit_backward = v_2;
/* 1106 */       return false;
/*      */     }
/*      */     
/* 1109 */     this.bra = this.cursor;
/* 1110 */     switch (among_var) {
/*      */     case 0: 
/* 1112 */       this.limit_backward = v_2;
/* 1113 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/* 1117 */       if (!r_R2())
/*      */       {
/* 1119 */         this.limit_backward = v_2;
/* 1120 */         return false;
/*      */       }
/*      */       
/* 1123 */       slice_del();
/* 1124 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/* 1128 */       slice_del();
/* 1129 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/* 1133 */       slice_del();
/*      */       
/* 1135 */       int v_3 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/* 1139 */       this.ket = this.cursor;
/*      */       
/* 1141 */       if (!eq_s_b(1, "e"))
/*      */       {
/* 1143 */         this.cursor = (this.limit - v_3);
/*      */       }
/*      */       else
/*      */       {
/* 1147 */         this.bra = this.cursor;
/*      */         
/* 1149 */         slice_del();
/*      */       }
/*      */       break;
/*      */     }
/* 1153 */     this.limit_backward = v_2;
/* 1154 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_residual_suffix()
/*      */   {
/* 1166 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 1170 */     this.ket = this.cursor;
/*      */     
/* 1172 */     if (!eq_s_b(1, "s"))
/*      */     {
/* 1174 */       this.cursor = (this.limit - v_1);
/*      */     }
/*      */     else
/*      */     {
/* 1178 */       this.bra = this.cursor;
/*      */       
/* 1180 */       int v_2 = this.limit - this.cursor;
/* 1181 */       if (!out_grouping_b(g_keep_with_s, 97, 232))
/*      */       {
/* 1183 */         this.cursor = (this.limit - v_1);
/*      */       }
/*      */       else {
/* 1186 */         this.cursor = (this.limit - v_2);
/*      */         
/* 1188 */         slice_del();
/*      */       }
/*      */     }
/* 1191 */     int v_3 = this.limit - this.cursor;
/*      */     
/* 1193 */     if (this.cursor < this.I_pV)
/*      */     {
/* 1195 */       return false;
/*      */     }
/* 1197 */     this.cursor = this.I_pV;
/* 1198 */     int v_4 = this.limit_backward;
/* 1199 */     this.limit_backward = this.cursor;
/* 1200 */     this.cursor = (this.limit - v_3);
/*      */     
/*      */ 
/* 1203 */     this.ket = this.cursor;
/*      */     
/* 1205 */     int among_var = find_among_b(a_7, 7);
/* 1206 */     if (among_var == 0)
/*      */     {
/* 1208 */       this.limit_backward = v_4;
/* 1209 */       return false;
/*      */     }
/*      */     
/* 1212 */     this.bra = this.cursor;
/* 1213 */     switch (among_var) {
/*      */     case 0: 
/* 1215 */       this.limit_backward = v_4;
/* 1216 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/* 1220 */       if (!r_R2())
/*      */       {
/* 1222 */         this.limit_backward = v_4;
/* 1223 */         return false;
/*      */       }
/*      */       
/*      */ 
/* 1227 */       int v_5 = this.limit - this.cursor;
/*      */       
/*      */ 
/* 1230 */       if (!eq_s_b(1, "s"))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1236 */         this.cursor = (this.limit - v_5);
/*      */         
/* 1238 */         if (!eq_s_b(1, "t"))
/*      */         {
/* 1240 */           this.limit_backward = v_4;
/* 1241 */           return false;
/*      */         }
/*      */       }
/*      */       
/* 1245 */       slice_del();
/* 1246 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/* 1250 */       slice_from("i");
/* 1251 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/* 1255 */       slice_del();
/* 1256 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/* 1260 */       if (!eq_s_b(2, "gu"))
/*      */       {
/* 1262 */         this.limit_backward = v_4;
/* 1263 */         return false;
/*      */       }
/*      */       
/* 1266 */       slice_del();
/*      */     }
/*      */     
/* 1269 */     this.limit_backward = v_4;
/* 1270 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_un_double()
/*      */   {
/* 1277 */     int v_1 = this.limit - this.cursor;
/*      */     
/* 1279 */     if (find_among_b(a_8, 5) == 0)
/*      */     {
/* 1281 */       return false;
/*      */     }
/* 1283 */     this.cursor = (this.limit - v_1);
/*      */     
/* 1285 */     this.ket = this.cursor;
/*      */     
/* 1287 */     if (this.cursor <= this.limit_backward)
/*      */     {
/* 1289 */       return false;
/*      */     }
/* 1291 */     this.cursor -= 1;
/*      */     
/* 1293 */     this.bra = this.cursor;
/*      */     
/* 1295 */     slice_del();
/* 1296 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_un_accent()
/*      */   {
/* 1304 */     int v_1 = 1;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1309 */     while (out_grouping_b(g_v, 97, 251))
/*      */     {
/*      */ 
/*      */ 
/* 1313 */       v_1--;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1318 */     if (v_1 > 0)
/*      */     {
/* 1320 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1324 */     this.ket = this.cursor;
/*      */     
/*      */ 
/* 1327 */     int v_3 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1330 */     if (!eq_s_b(1, "é"))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1336 */       this.cursor = (this.limit - v_3);
/*      */       
/* 1338 */       if (!eq_s_b(1, "è"))
/*      */       {
/* 1340 */         return false;
/*      */       }
/*      */     }
/*      */     
/* 1344 */     this.bra = this.cursor;
/*      */     
/* 1346 */     slice_from("e");
/* 1347 */     return true;
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
/*      */   public boolean stem()
/*      */   {
/* 1364 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/* 1367 */     if (!r_prelude()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1372 */     this.cursor = v_1;
/*      */     
/* 1374 */     int v_2 = this.cursor;
/*      */     
/*      */ 
/* 1377 */     if (!r_mark_regions()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1382 */     this.cursor = v_2;
/*      */     
/* 1384 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*      */     
/*      */ 
/* 1387 */     int v_3 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1392 */     int v_4 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 1396 */     int v_5 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 1400 */     int v_6 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1403 */     if (!r_standard_suffix())
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1409 */       this.cursor = (this.limit - v_6);
/*      */       
/*      */ 
/* 1412 */       if (!r_i_verb_suffix())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1418 */         this.cursor = (this.limit - v_6);
/*      */         
/* 1420 */         if (!r_verb_suffix()) {
/*      */           break label264;
/*      */         }
/*      */       }
/*      */     }
/* 1425 */     this.cursor = (this.limit - v_5);
/*      */     
/* 1427 */     int v_7 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 1431 */     this.ket = this.cursor;
/*      */     
/*      */ 
/* 1434 */     int v_8 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 1438 */     if (eq_s_b(1, "Y"))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/* 1443 */       this.bra = this.cursor;
/*      */       
/* 1445 */       slice_from("i");
/*      */     }
/*      */     else {
/* 1448 */       this.cursor = (this.limit - v_8);
/*      */       
/*      */ 
/* 1451 */       if (!eq_s_b(1, "ç"))
/*      */       {
/* 1453 */         this.cursor = (this.limit - v_7);
/*      */       }
/*      */       else
/*      */       {
/* 1457 */         this.bra = this.cursor;
/*      */         
/* 1459 */         slice_from("c");
/*      */         
/*      */         break label282;
/*      */         
/*      */         label264:
/* 1464 */         this.cursor = (this.limit - v_4);
/*      */         
/* 1466 */         if (r_residual_suffix()) {}
/*      */       }
/*      */     }
/*      */     
/*      */     label282:
/*      */     
/* 1472 */     this.cursor = (this.limit - v_3);
/*      */     
/* 1474 */     int v_9 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1477 */     if (!r_un_double()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1482 */     this.cursor = (this.limit - v_9);
/*      */     
/* 1484 */     int v_10 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1487 */     if (!r_un_accent()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1492 */     this.cursor = (this.limit - v_10);
/* 1493 */     this.cursor = this.limit_backward;
/* 1494 */     int v_11 = this.cursor;
/*      */     
/*      */ 
/* 1497 */     if (!r_postlude()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1502 */     this.cursor = v_11;
/* 1503 */     return true;
/*      */   }
/*      */   
/*      */   public boolean equals(Object o) {
/* 1507 */     return o instanceof frenchStemmer;
/*      */   }
/*      */   
/*      */   public int hashCode() {
/* 1511 */     return frenchStemmer.class.getName().hashCode();
/*      */   }
/*      */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\frenchStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */