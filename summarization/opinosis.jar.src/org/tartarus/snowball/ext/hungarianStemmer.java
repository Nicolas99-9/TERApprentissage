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
/*      */ public class hungarianStemmer
/*      */   extends SnowballStemmer
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*   16 */   private static final hungarianStemmer methodObject = new hungarianStemmer();
/*      */   
/*   18 */   private static final Among[] a_0 = {
/*   19 */     new Among("cs", -1, -1, "", methodObject), 
/*   20 */     new Among("dzs", -1, -1, "", methodObject), 
/*   21 */     new Among("gy", -1, -1, "", methodObject), 
/*   22 */     new Among("ly", -1, -1, "", methodObject), 
/*   23 */     new Among("ny", -1, -1, "", methodObject), 
/*   24 */     new Among("sz", -1, -1, "", methodObject), 
/*   25 */     new Among("ty", -1, -1, "", methodObject), 
/*   26 */     new Among("zs", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   29 */   private static final Among[] a_1 = {
/*   30 */     new Among("á", -1, 1, "", methodObject), 
/*   31 */     new Among("é", -1, 2, "", methodObject) };
/*      */   
/*      */ 
/*   34 */   private static final Among[] a_2 = {
/*   35 */     new Among("bb", -1, -1, "", methodObject), 
/*   36 */     new Among("cc", -1, -1, "", methodObject), 
/*   37 */     new Among("dd", -1, -1, "", methodObject), 
/*   38 */     new Among("ff", -1, -1, "", methodObject), 
/*   39 */     new Among("gg", -1, -1, "", methodObject), 
/*   40 */     new Among("jj", -1, -1, "", methodObject), 
/*   41 */     new Among("kk", -1, -1, "", methodObject), 
/*   42 */     new Among("ll", -1, -1, "", methodObject), 
/*   43 */     new Among("mm", -1, -1, "", methodObject), 
/*   44 */     new Among("nn", -1, -1, "", methodObject), 
/*   45 */     new Among("pp", -1, -1, "", methodObject), 
/*   46 */     new Among("rr", -1, -1, "", methodObject), 
/*   47 */     new Among("ccs", -1, -1, "", methodObject), 
/*   48 */     new Among("ss", -1, -1, "", methodObject), 
/*   49 */     new Among("zzs", -1, -1, "", methodObject), 
/*   50 */     new Among("tt", -1, -1, "", methodObject), 
/*   51 */     new Among("vv", -1, -1, "", methodObject), 
/*   52 */     new Among("ggy", -1, -1, "", methodObject), 
/*   53 */     new Among("lly", -1, -1, "", methodObject), 
/*   54 */     new Among("nny", -1, -1, "", methodObject), 
/*   55 */     new Among("tty", -1, -1, "", methodObject), 
/*   56 */     new Among("ssz", -1, -1, "", methodObject), 
/*   57 */     new Among("zz", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   60 */   private static final Among[] a_3 = {
/*   61 */     new Among("al", -1, 1, "", methodObject), 
/*   62 */     new Among("el", -1, 2, "", methodObject) };
/*      */   
/*      */ 
/*   65 */   private static final Among[] a_4 = {
/*   66 */     new Among("ba", -1, -1, "", methodObject), 
/*   67 */     new Among("ra", -1, -1, "", methodObject), 
/*   68 */     new Among("be", -1, -1, "", methodObject), 
/*   69 */     new Among("re", -1, -1, "", methodObject), 
/*   70 */     new Among("ig", -1, -1, "", methodObject), 
/*   71 */     new Among("nak", -1, -1, "", methodObject), 
/*   72 */     new Among("nek", -1, -1, "", methodObject), 
/*   73 */     new Among("val", -1, -1, "", methodObject), 
/*   74 */     new Among("vel", -1, -1, "", methodObject), 
/*   75 */     new Among("ul", -1, -1, "", methodObject), 
/*   76 */     new Among("nál", -1, -1, "", methodObject), 
/*   77 */     new Among("nél", -1, -1, "", methodObject), 
/*   78 */     new Among("ból", -1, -1, "", methodObject), 
/*   79 */     new Among("ról", -1, -1, "", methodObject), 
/*   80 */     new Among("tól", -1, -1, "", methodObject), 
/*   81 */     new Among("bõl", -1, -1, "", methodObject), 
/*   82 */     new Among("rõl", -1, -1, "", methodObject), 
/*   83 */     new Among("tõl", -1, -1, "", methodObject), 
/*   84 */     new Among("ül", -1, -1, "", methodObject), 
/*   85 */     new Among("n", -1, -1, "", methodObject), 
/*   86 */     new Among("an", 19, -1, "", methodObject), 
/*   87 */     new Among("ban", 20, -1, "", methodObject), 
/*   88 */     new Among("en", 19, -1, "", methodObject), 
/*   89 */     new Among("ben", 22, -1, "", methodObject), 
/*   90 */     new Among("képpen", 22, -1, "", methodObject), 
/*   91 */     new Among("on", 19, -1, "", methodObject), 
/*   92 */     new Among("ön", 19, -1, "", methodObject), 
/*   93 */     new Among("képp", -1, -1, "", methodObject), 
/*   94 */     new Among("kor", -1, -1, "", methodObject), 
/*   95 */     new Among("t", -1, -1, "", methodObject), 
/*   96 */     new Among("at", 29, -1, "", methodObject), 
/*   97 */     new Among("et", 29, -1, "", methodObject), 
/*   98 */     new Among("ként", 29, -1, "", methodObject), 
/*   99 */     new Among("anként", 32, -1, "", methodObject), 
/*  100 */     new Among("enként", 32, -1, "", methodObject), 
/*  101 */     new Among("onként", 32, -1, "", methodObject), 
/*  102 */     new Among("ot", 29, -1, "", methodObject), 
/*  103 */     new Among("ért", 29, -1, "", methodObject), 
/*  104 */     new Among("öt", 29, -1, "", methodObject), 
/*  105 */     new Among("hez", -1, -1, "", methodObject), 
/*  106 */     new Among("hoz", -1, -1, "", methodObject), 
/*  107 */     new Among("höz", -1, -1, "", methodObject), 
/*  108 */     new Among("vá", -1, -1, "", methodObject), 
/*  109 */     new Among("vé", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  112 */   private static final Among[] a_5 = {
/*  113 */     new Among("án", -1, 2, "", methodObject), 
/*  114 */     new Among("én", -1, 1, "", methodObject), 
/*  115 */     new Among("ánként", -1, 3, "", methodObject) };
/*      */   
/*      */ 
/*  118 */   private static final Among[] a_6 = {
/*  119 */     new Among("stul", -1, 2, "", methodObject), 
/*  120 */     new Among("astul", 0, 1, "", methodObject), 
/*  121 */     new Among("ástul", 0, 3, "", methodObject), 
/*  122 */     new Among("stül", -1, 2, "", methodObject), 
/*  123 */     new Among("estül", 3, 1, "", methodObject), 
/*  124 */     new Among("éstül", 3, 4, "", methodObject) };
/*      */   
/*      */ 
/*  127 */   private static final Among[] a_7 = {
/*  128 */     new Among("á", -1, 1, "", methodObject), 
/*  129 */     new Among("é", -1, 2, "", methodObject) };
/*      */   
/*      */ 
/*  132 */   private static final Among[] a_8 = {
/*  133 */     new Among("k", -1, 7, "", methodObject), 
/*  134 */     new Among("ak", 0, 4, "", methodObject), 
/*  135 */     new Among("ek", 0, 6, "", methodObject), 
/*  136 */     new Among("ok", 0, 5, "", methodObject), 
/*  137 */     new Among("ák", 0, 1, "", methodObject), 
/*  138 */     new Among("ék", 0, 2, "", methodObject), 
/*  139 */     new Among("ök", 0, 3, "", methodObject) };
/*      */   
/*      */ 
/*  142 */   private static final Among[] a_9 = {
/*  143 */     new Among("éi", -1, 7, "", methodObject), 
/*  144 */     new Among("áéi", 0, 6, "", methodObject), 
/*  145 */     new Among("ééi", 0, 5, "", methodObject), 
/*  146 */     new Among("é", -1, 9, "", methodObject), 
/*  147 */     new Among("ké", 3, 4, "", methodObject), 
/*  148 */     new Among("aké", 4, 1, "", methodObject), 
/*  149 */     new Among("eké", 4, 1, "", methodObject), 
/*  150 */     new Among("oké", 4, 1, "", methodObject), 
/*  151 */     new Among("áké", 4, 3, "", methodObject), 
/*  152 */     new Among("éké", 4, 2, "", methodObject), 
/*  153 */     new Among("öké", 4, 1, "", methodObject), 
/*  154 */     new Among("éé", 3, 8, "", methodObject) };
/*      */   
/*      */ 
/*  157 */   private static final Among[] a_10 = {
/*  158 */     new Among("a", -1, 18, "", methodObject), 
/*  159 */     new Among("ja", 0, 17, "", methodObject), 
/*  160 */     new Among("d", -1, 16, "", methodObject), 
/*  161 */     new Among("ad", 2, 13, "", methodObject), 
/*  162 */     new Among("ed", 2, 13, "", methodObject), 
/*  163 */     new Among("od", 2, 13, "", methodObject), 
/*  164 */     new Among("ád", 2, 14, "", methodObject), 
/*  165 */     new Among("éd", 2, 15, "", methodObject), 
/*  166 */     new Among("öd", 2, 13, "", methodObject), 
/*  167 */     new Among("e", -1, 18, "", methodObject), 
/*  168 */     new Among("je", 9, 17, "", methodObject), 
/*  169 */     new Among("nk", -1, 4, "", methodObject), 
/*  170 */     new Among("unk", 11, 1, "", methodObject), 
/*  171 */     new Among("ánk", 11, 2, "", methodObject), 
/*  172 */     new Among("énk", 11, 3, "", methodObject), 
/*  173 */     new Among("ünk", 11, 1, "", methodObject), 
/*  174 */     new Among("uk", -1, 8, "", methodObject), 
/*  175 */     new Among("juk", 16, 7, "", methodObject), 
/*  176 */     new Among("ájuk", 17, 5, "", methodObject), 
/*  177 */     new Among("ük", -1, 8, "", methodObject), 
/*  178 */     new Among("jük", 19, 7, "", methodObject), 
/*  179 */     new Among("éjük", 20, 6, "", methodObject), 
/*  180 */     new Among("m", -1, 12, "", methodObject), 
/*  181 */     new Among("am", 22, 9, "", methodObject), 
/*  182 */     new Among("em", 22, 9, "", methodObject), 
/*  183 */     new Among("om", 22, 9, "", methodObject), 
/*  184 */     new Among("ám", 22, 10, "", methodObject), 
/*  185 */     new Among("ém", 22, 11, "", methodObject), 
/*  186 */     new Among("o", -1, 18, "", methodObject), 
/*  187 */     new Among("á", -1, 19, "", methodObject), 
/*  188 */     new Among("é", -1, 20, "", methodObject) };
/*      */   
/*      */ 
/*  191 */   private static final Among[] a_11 = {
/*  192 */     new Among("id", -1, 10, "", methodObject), 
/*  193 */     new Among("aid", 0, 9, "", methodObject), 
/*  194 */     new Among("jaid", 1, 6, "", methodObject), 
/*  195 */     new Among("eid", 0, 9, "", methodObject), 
/*  196 */     new Among("jeid", 3, 6, "", methodObject), 
/*  197 */     new Among("áid", 0, 7, "", methodObject), 
/*  198 */     new Among("éid", 0, 8, "", methodObject), 
/*  199 */     new Among("i", -1, 15, "", methodObject), 
/*  200 */     new Among("ai", 7, 14, "", methodObject), 
/*  201 */     new Among("jai", 8, 11, "", methodObject), 
/*  202 */     new Among("ei", 7, 14, "", methodObject), 
/*  203 */     new Among("jei", 10, 11, "", methodObject), 
/*  204 */     new Among("ái", 7, 12, "", methodObject), 
/*  205 */     new Among("éi", 7, 13, "", methodObject), 
/*  206 */     new Among("itek", -1, 24, "", methodObject), 
/*  207 */     new Among("eitek", 14, 21, "", methodObject), 
/*  208 */     new Among("jeitek", 15, 20, "", methodObject), 
/*  209 */     new Among("éitek", 14, 23, "", methodObject), 
/*  210 */     new Among("ik", -1, 29, "", methodObject), 
/*  211 */     new Among("aik", 18, 26, "", methodObject), 
/*  212 */     new Among("jaik", 19, 25, "", methodObject), 
/*  213 */     new Among("eik", 18, 26, "", methodObject), 
/*  214 */     new Among("jeik", 21, 25, "", methodObject), 
/*  215 */     new Among("áik", 18, 27, "", methodObject), 
/*  216 */     new Among("éik", 18, 28, "", methodObject), 
/*  217 */     new Among("ink", -1, 20, "", methodObject), 
/*  218 */     new Among("aink", 25, 17, "", methodObject), 
/*  219 */     new Among("jaink", 26, 16, "", methodObject), 
/*  220 */     new Among("eink", 25, 17, "", methodObject), 
/*  221 */     new Among("jeink", 28, 16, "", methodObject), 
/*  222 */     new Among("áink", 25, 18, "", methodObject), 
/*  223 */     new Among("éink", 25, 19, "", methodObject), 
/*  224 */     new Among("aitok", -1, 21, "", methodObject), 
/*  225 */     new Among("jaitok", 32, 20, "", methodObject), 
/*  226 */     new Among("áitok", -1, 22, "", methodObject), 
/*  227 */     new Among("im", -1, 5, "", methodObject), 
/*  228 */     new Among("aim", 35, 4, "", methodObject), 
/*  229 */     new Among("jaim", 36, 1, "", methodObject), 
/*  230 */     new Among("eim", 35, 4, "", methodObject), 
/*  231 */     new Among("jeim", 38, 1, "", methodObject), 
/*  232 */     new Among("áim", 35, 2, "", methodObject), 
/*  233 */     new Among("éim", 35, 3, "", methodObject) };
/*      */   
/*      */ 
/*  236 */   private static final char[] g_v = { '\021', 'A', '\020', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\001', '\021', '4', '\016' };
/*      */   private int I_p1;
/*      */   
/*      */   private void copy_from(hungarianStemmer other)
/*      */   {
/*  241 */     this.I_p1 = other.I_p1;
/*  242 */     super.copy_from(other);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_mark_regions()
/*      */   {
/*  250 */     this.I_p1 = this.limit;
/*      */     
/*      */ 
/*  253 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/*  256 */     if (in_grouping(g_v, 97, 252))
/*      */     {
/*      */ 
/*      */ 
/*      */       for (;;)
/*      */       {
/*      */ 
/*  263 */         int v_2 = this.cursor;
/*      */         
/*  265 */         if (out_grouping(g_v, 97, 252))
/*      */         {
/*      */ 
/*      */ 
/*  269 */           this.cursor = v_2;
/*  270 */           break;
/*      */         }
/*  272 */         this.cursor = v_2;
/*  273 */         if (this.cursor >= this.limit) {
/*      */           break label151;
/*      */         }
/*      */         
/*  277 */         this.cursor += 1;
/*      */       }
/*      */       
/*      */       int v_2;
/*  281 */       int v_3 = this.cursor;
/*      */       
/*      */ 
/*  284 */       if (find_among(a_0, 8) == 0)
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  290 */         this.cursor = v_3;
/*      */         
/*  292 */         if (this.cursor < this.limit)
/*      */         {
/*      */ 
/*      */ 
/*  296 */           this.cursor += 1;
/*      */         }
/*      */       } else {
/*  299 */         this.I_p1 = this.cursor;
/*      */         break label222; } }
/*      */     label151:
/*  302 */     this.cursor = v_1;
/*      */     
/*  304 */     if (!out_grouping(g_v, 97, 252))
/*      */     {
/*  306 */       return false;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  312 */     while (!in_grouping(g_v, 97, 252))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  318 */       if (this.cursor >= this.limit)
/*      */       {
/*  320 */         return false;
/*      */       }
/*  322 */       this.cursor += 1;
/*      */     }
/*      */     
/*  325 */     this.I_p1 = this.cursor;
/*      */     label222:
/*  327 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_R1() {
/*  331 */     if (this.I_p1 > this.cursor)
/*      */     {
/*  333 */       return false;
/*      */     }
/*  335 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_v_ending()
/*      */   {
/*  342 */     this.ket = this.cursor;
/*      */     
/*  344 */     int among_var = find_among_b(a_1, 2);
/*  345 */     if (among_var == 0)
/*      */     {
/*  347 */       return false;
/*      */     }
/*      */     
/*  350 */     this.bra = this.cursor;
/*      */     
/*  352 */     if (!r_R1())
/*      */     {
/*  354 */       return false;
/*      */     }
/*  356 */     switch (among_var) {
/*      */     case 0: 
/*  358 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  362 */       slice_from("a");
/*  363 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  367 */       slice_from("e");
/*      */     }
/*      */     
/*  370 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_double()
/*      */   {
/*  377 */     int v_1 = this.limit - this.cursor;
/*      */     
/*  379 */     if (find_among_b(a_2, 23) == 0)
/*      */     {
/*  381 */       return false;
/*      */     }
/*  383 */     this.cursor = (this.limit - v_1);
/*  384 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_undouble()
/*      */   {
/*  390 */     if (this.cursor <= this.limit_backward)
/*      */     {
/*  392 */       return false;
/*      */     }
/*  394 */     this.cursor -= 1;
/*      */     
/*  396 */     this.ket = this.cursor;
/*      */     
/*      */ 
/*  399 */     int c = this.cursor - 1;
/*  400 */     if ((this.limit_backward > c) || (c > this.limit))
/*      */     {
/*  402 */       return false;
/*      */     }
/*  404 */     this.cursor = c;
/*      */     
/*      */ 
/*  407 */     this.bra = this.cursor;
/*      */     
/*  409 */     slice_del();
/*  410 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_instrum()
/*      */   {
/*  417 */     this.ket = this.cursor;
/*      */     
/*  419 */     int among_var = find_among_b(a_3, 2);
/*  420 */     if (among_var == 0)
/*      */     {
/*  422 */       return false;
/*      */     }
/*      */     
/*  425 */     this.bra = this.cursor;
/*      */     
/*  427 */     if (!r_R1())
/*      */     {
/*  429 */       return false;
/*      */     }
/*  431 */     switch (among_var) {
/*      */     case 0: 
/*  433 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  437 */       if (!r_double())
/*      */       {
/*  439 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */       break;
/*      */     case 2: 
/*  445 */       if (!r_double())
/*      */       {
/*  447 */         return false;
/*      */       }
/*      */       break;
/*      */     }
/*      */     
/*  452 */     slice_del();
/*      */     
/*  454 */     if (!r_undouble())
/*      */     {
/*  456 */       return false;
/*      */     }
/*  458 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_case()
/*      */   {
/*  464 */     this.ket = this.cursor;
/*      */     
/*  466 */     if (find_among_b(a_4, 44) == 0)
/*      */     {
/*  468 */       return false;
/*      */     }
/*      */     
/*  471 */     this.bra = this.cursor;
/*      */     
/*  473 */     if (!r_R1())
/*      */     {
/*  475 */       return false;
/*      */     }
/*      */     
/*  478 */     slice_del();
/*      */     
/*  480 */     if (!r_v_ending())
/*      */     {
/*  482 */       return false;
/*      */     }
/*  484 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_case_special()
/*      */   {
/*  491 */     this.ket = this.cursor;
/*      */     
/*  493 */     int among_var = find_among_b(a_5, 3);
/*  494 */     if (among_var == 0)
/*      */     {
/*  496 */       return false;
/*      */     }
/*      */     
/*  499 */     this.bra = this.cursor;
/*      */     
/*  501 */     if (!r_R1())
/*      */     {
/*  503 */       return false;
/*      */     }
/*  505 */     switch (among_var) {
/*      */     case 0: 
/*  507 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  511 */       slice_from("e");
/*  512 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  516 */       slice_from("a");
/*  517 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  521 */       slice_from("a");
/*      */     }
/*      */     
/*  524 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_case_other()
/*      */   {
/*  531 */     this.ket = this.cursor;
/*      */     
/*  533 */     int among_var = find_among_b(a_6, 6);
/*  534 */     if (among_var == 0)
/*      */     {
/*  536 */       return false;
/*      */     }
/*      */     
/*  539 */     this.bra = this.cursor;
/*      */     
/*  541 */     if (!r_R1())
/*      */     {
/*  543 */       return false;
/*      */     }
/*  545 */     switch (among_var) {
/*      */     case 0: 
/*  547 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  551 */       slice_del();
/*  552 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  556 */       slice_del();
/*  557 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  561 */       slice_from("a");
/*  562 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  566 */       slice_from("e");
/*      */     }
/*      */     
/*  569 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_factive()
/*      */   {
/*  576 */     this.ket = this.cursor;
/*      */     
/*  578 */     int among_var = find_among_b(a_7, 2);
/*  579 */     if (among_var == 0)
/*      */     {
/*  581 */       return false;
/*      */     }
/*      */     
/*  584 */     this.bra = this.cursor;
/*      */     
/*  586 */     if (!r_R1())
/*      */     {
/*  588 */       return false;
/*      */     }
/*  590 */     switch (among_var) {
/*      */     case 0: 
/*  592 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  596 */       if (!r_double())
/*      */       {
/*  598 */         return false;
/*      */       }
/*      */       
/*      */ 
/*      */       break;
/*      */     case 2: 
/*  604 */       if (!r_double())
/*      */       {
/*  606 */         return false;
/*      */       }
/*      */       break;
/*      */     }
/*      */     
/*  611 */     slice_del();
/*      */     
/*  613 */     if (!r_undouble())
/*      */     {
/*  615 */       return false;
/*      */     }
/*  617 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_plural()
/*      */   {
/*  624 */     this.ket = this.cursor;
/*      */     
/*  626 */     int among_var = find_among_b(a_8, 7);
/*  627 */     if (among_var == 0)
/*      */     {
/*  629 */       return false;
/*      */     }
/*      */     
/*  632 */     this.bra = this.cursor;
/*      */     
/*  634 */     if (!r_R1())
/*      */     {
/*  636 */       return false;
/*      */     }
/*  638 */     switch (among_var) {
/*      */     case 0: 
/*  640 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  644 */       slice_from("a");
/*  645 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  649 */       slice_from("e");
/*  650 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  654 */       slice_del();
/*  655 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  659 */       slice_del();
/*  660 */       break;
/*      */     
/*      */ 
/*      */     case 5: 
/*  664 */       slice_del();
/*  665 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/*  669 */       slice_del();
/*  670 */       break;
/*      */     
/*      */ 
/*      */     case 7: 
/*  674 */       slice_del();
/*      */     }
/*      */     
/*  677 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_owned()
/*      */   {
/*  684 */     this.ket = this.cursor;
/*      */     
/*  686 */     int among_var = find_among_b(a_9, 12);
/*  687 */     if (among_var == 0)
/*      */     {
/*  689 */       return false;
/*      */     }
/*      */     
/*  692 */     this.bra = this.cursor;
/*      */     
/*  694 */     if (!r_R1())
/*      */     {
/*  696 */       return false;
/*      */     }
/*  698 */     switch (among_var) {
/*      */     case 0: 
/*  700 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  704 */       slice_del();
/*  705 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  709 */       slice_from("e");
/*  710 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  714 */       slice_from("a");
/*  715 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  719 */       slice_del();
/*  720 */       break;
/*      */     
/*      */ 
/*      */     case 5: 
/*  724 */       slice_from("e");
/*  725 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/*  729 */       slice_from("a");
/*  730 */       break;
/*      */     
/*      */ 
/*      */     case 7: 
/*  734 */       slice_del();
/*  735 */       break;
/*      */     
/*      */ 
/*      */     case 8: 
/*  739 */       slice_from("e");
/*  740 */       break;
/*      */     
/*      */ 
/*      */     case 9: 
/*  744 */       slice_del();
/*      */     }
/*      */     
/*  747 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_sing_owner()
/*      */   {
/*  754 */     this.ket = this.cursor;
/*      */     
/*  756 */     int among_var = find_among_b(a_10, 31);
/*  757 */     if (among_var == 0)
/*      */     {
/*  759 */       return false;
/*      */     }
/*      */     
/*  762 */     this.bra = this.cursor;
/*      */     
/*  764 */     if (!r_R1())
/*      */     {
/*  766 */       return false;
/*      */     }
/*  768 */     switch (among_var) {
/*      */     case 0: 
/*  770 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  774 */       slice_del();
/*  775 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  779 */       slice_from("a");
/*  780 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  784 */       slice_from("e");
/*  785 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  789 */       slice_del();
/*  790 */       break;
/*      */     
/*      */ 
/*      */     case 5: 
/*  794 */       slice_from("a");
/*  795 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/*  799 */       slice_from("e");
/*  800 */       break;
/*      */     
/*      */ 
/*      */     case 7: 
/*  804 */       slice_del();
/*  805 */       break;
/*      */     
/*      */ 
/*      */     case 8: 
/*  809 */       slice_del();
/*  810 */       break;
/*      */     
/*      */ 
/*      */     case 9: 
/*  814 */       slice_del();
/*  815 */       break;
/*      */     
/*      */ 
/*      */     case 10: 
/*  819 */       slice_from("a");
/*  820 */       break;
/*      */     
/*      */ 
/*      */     case 11: 
/*  824 */       slice_from("e");
/*  825 */       break;
/*      */     
/*      */ 
/*      */     case 12: 
/*  829 */       slice_del();
/*  830 */       break;
/*      */     
/*      */ 
/*      */     case 13: 
/*  834 */       slice_del();
/*  835 */       break;
/*      */     
/*      */ 
/*      */     case 14: 
/*  839 */       slice_from("a");
/*  840 */       break;
/*      */     
/*      */ 
/*      */     case 15: 
/*  844 */       slice_from("e");
/*  845 */       break;
/*      */     
/*      */ 
/*      */     case 16: 
/*  849 */       slice_del();
/*  850 */       break;
/*      */     
/*      */ 
/*      */     case 17: 
/*  854 */       slice_del();
/*  855 */       break;
/*      */     
/*      */ 
/*      */     case 18: 
/*  859 */       slice_del();
/*  860 */       break;
/*      */     
/*      */ 
/*      */     case 19: 
/*  864 */       slice_from("a");
/*  865 */       break;
/*      */     
/*      */ 
/*      */     case 20: 
/*  869 */       slice_from("e");
/*      */     }
/*      */     
/*  872 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_plur_owner()
/*      */   {
/*  879 */     this.ket = this.cursor;
/*      */     
/*  881 */     int among_var = find_among_b(a_11, 42);
/*  882 */     if (among_var == 0)
/*      */     {
/*  884 */       return false;
/*      */     }
/*      */     
/*  887 */     this.bra = this.cursor;
/*      */     
/*  889 */     if (!r_R1())
/*      */     {
/*  891 */       return false;
/*      */     }
/*  893 */     switch (among_var) {
/*      */     case 0: 
/*  895 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  899 */       slice_del();
/*  900 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  904 */       slice_from("a");
/*  905 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  909 */       slice_from("e");
/*  910 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  914 */       slice_del();
/*  915 */       break;
/*      */     
/*      */ 
/*      */     case 5: 
/*  919 */       slice_del();
/*  920 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/*  924 */       slice_del();
/*  925 */       break;
/*      */     
/*      */ 
/*      */     case 7: 
/*  929 */       slice_from("a");
/*  930 */       break;
/*      */     
/*      */ 
/*      */     case 8: 
/*  934 */       slice_from("e");
/*  935 */       break;
/*      */     
/*      */ 
/*      */     case 9: 
/*  939 */       slice_del();
/*  940 */       break;
/*      */     
/*      */ 
/*      */     case 10: 
/*  944 */       slice_del();
/*  945 */       break;
/*      */     
/*      */ 
/*      */     case 11: 
/*  949 */       slice_del();
/*  950 */       break;
/*      */     
/*      */ 
/*      */     case 12: 
/*  954 */       slice_from("a");
/*  955 */       break;
/*      */     
/*      */ 
/*      */     case 13: 
/*  959 */       slice_from("e");
/*  960 */       break;
/*      */     
/*      */ 
/*      */     case 14: 
/*  964 */       slice_del();
/*  965 */       break;
/*      */     
/*      */ 
/*      */     case 15: 
/*  969 */       slice_del();
/*  970 */       break;
/*      */     
/*      */ 
/*      */     case 16: 
/*  974 */       slice_del();
/*  975 */       break;
/*      */     
/*      */ 
/*      */     case 17: 
/*  979 */       slice_del();
/*  980 */       break;
/*      */     
/*      */ 
/*      */     case 18: 
/*  984 */       slice_from("a");
/*  985 */       break;
/*      */     
/*      */ 
/*      */     case 19: 
/*  989 */       slice_from("e");
/*  990 */       break;
/*      */     
/*      */ 
/*      */     case 20: 
/*  994 */       slice_del();
/*  995 */       break;
/*      */     
/*      */ 
/*      */     case 21: 
/*  999 */       slice_del();
/* 1000 */       break;
/*      */     
/*      */ 
/*      */     case 22: 
/* 1004 */       slice_from("a");
/* 1005 */       break;
/*      */     
/*      */ 
/*      */     case 23: 
/* 1009 */       slice_from("e");
/* 1010 */       break;
/*      */     
/*      */ 
/*      */     case 24: 
/* 1014 */       slice_del();
/* 1015 */       break;
/*      */     
/*      */ 
/*      */     case 25: 
/* 1019 */       slice_del();
/* 1020 */       break;
/*      */     
/*      */ 
/*      */     case 26: 
/* 1024 */       slice_del();
/* 1025 */       break;
/*      */     
/*      */ 
/*      */     case 27: 
/* 1029 */       slice_from("a");
/* 1030 */       break;
/*      */     
/*      */ 
/*      */     case 28: 
/* 1034 */       slice_from("e");
/* 1035 */       break;
/*      */     
/*      */ 
/*      */     case 29: 
/* 1039 */       slice_del();
/*      */     }
/*      */     
/* 1042 */     return true;
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
/*      */   public boolean stem()
/*      */   {
/* 1058 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/* 1061 */     if (!r_mark_regions()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1066 */     this.cursor = v_1;
/*      */     
/* 1068 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*      */     
/*      */ 
/* 1071 */     int v_2 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1074 */     if (!r_instrum()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1079 */     this.cursor = (this.limit - v_2);
/*      */     
/* 1081 */     int v_3 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1084 */     if (!r_case()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1089 */     this.cursor = (this.limit - v_3);
/*      */     
/* 1091 */     int v_4 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1094 */     if (!r_case_special()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1099 */     this.cursor = (this.limit - v_4);
/*      */     
/* 1101 */     int v_5 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1104 */     if (!r_case_other()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1109 */     this.cursor = (this.limit - v_5);
/*      */     
/* 1111 */     int v_6 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1114 */     if (!r_factive()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1119 */     this.cursor = (this.limit - v_6);
/*      */     
/* 1121 */     int v_7 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1124 */     if (!r_owned()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1129 */     this.cursor = (this.limit - v_7);
/*      */     
/* 1131 */     int v_8 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1134 */     if (!r_sing_owner()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1139 */     this.cursor = (this.limit - v_8);
/*      */     
/* 1141 */     int v_9 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1144 */     if (!r_plur_owner()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1149 */     this.cursor = (this.limit - v_9);
/*      */     
/* 1151 */     int v_10 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1154 */     if (!r_plural()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1159 */     this.cursor = (this.limit - v_10);
/* 1160 */     this.cursor = this.limit_backward;return true;
/*      */   }
/*      */   
/*      */   public boolean equals(Object o) {
/* 1164 */     return o instanceof hungarianStemmer;
/*      */   }
/*      */   
/*      */   public int hashCode() {
/* 1168 */     return hungarianStemmer.class.getName().hashCode();
/*      */   }
/*      */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\hungarianStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */