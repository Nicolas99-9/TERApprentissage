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
/*      */ public class turkishStemmer
/*      */   extends SnowballStemmer
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*   16 */   private static final turkishStemmer methodObject = new turkishStemmer();
/*      */   
/*   18 */   private static final Among[] a_0 = {
/*   19 */     new Among("m", -1, -1, "", methodObject), 
/*   20 */     new Among("n", -1, -1, "", methodObject), 
/*   21 */     new Among("miz", -1, -1, "", methodObject), 
/*   22 */     new Among("niz", -1, -1, "", methodObject), 
/*   23 */     new Among("muz", -1, -1, "", methodObject), 
/*   24 */     new Among("nuz", -1, -1, "", methodObject), 
/*   25 */     new Among("müz", -1, -1, "", methodObject), 
/*   26 */     new Among("nüz", -1, -1, "", methodObject), 
/*   27 */     new Among("mız", -1, -1, "", methodObject), 
/*   28 */     new Among("nız", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   31 */   private static final Among[] a_1 = {
/*   32 */     new Among("leri", -1, -1, "", methodObject), 
/*   33 */     new Among("ları", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   36 */   private static final Among[] a_2 = {
/*   37 */     new Among("ni", -1, -1, "", methodObject), 
/*   38 */     new Among("nu", -1, -1, "", methodObject), 
/*   39 */     new Among("nü", -1, -1, "", methodObject), 
/*   40 */     new Among("nı", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   43 */   private static final Among[] a_3 = {
/*   44 */     new Among("in", -1, -1, "", methodObject), 
/*   45 */     new Among("un", -1, -1, "", methodObject), 
/*   46 */     new Among("ün", -1, -1, "", methodObject), 
/*   47 */     new Among("ın", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   50 */   private static final Among[] a_4 = {
/*   51 */     new Among("a", -1, -1, "", methodObject), 
/*   52 */     new Among("e", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   55 */   private static final Among[] a_5 = {
/*   56 */     new Among("na", -1, -1, "", methodObject), 
/*   57 */     new Among("ne", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   60 */   private static final Among[] a_6 = {
/*   61 */     new Among("da", -1, -1, "", methodObject), 
/*   62 */     new Among("ta", -1, -1, "", methodObject), 
/*   63 */     new Among("de", -1, -1, "", methodObject), 
/*   64 */     new Among("te", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   67 */   private static final Among[] a_7 = {
/*   68 */     new Among("nda", -1, -1, "", methodObject), 
/*   69 */     new Among("nde", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   72 */   private static final Among[] a_8 = {
/*   73 */     new Among("dan", -1, -1, "", methodObject), 
/*   74 */     new Among("tan", -1, -1, "", methodObject), 
/*   75 */     new Among("den", -1, -1, "", methodObject), 
/*   76 */     new Among("ten", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   79 */   private static final Among[] a_9 = {
/*   80 */     new Among("ndan", -1, -1, "", methodObject), 
/*   81 */     new Among("nden", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   84 */   private static final Among[] a_10 = {
/*   85 */     new Among("la", -1, -1, "", methodObject), 
/*   86 */     new Among("le", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   89 */   private static final Among[] a_11 = {
/*   90 */     new Among("ca", -1, -1, "", methodObject), 
/*   91 */     new Among("ce", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   94 */   private static final Among[] a_12 = {
/*   95 */     new Among("im", -1, -1, "", methodObject), 
/*   96 */     new Among("um", -1, -1, "", methodObject), 
/*   97 */     new Among("üm", -1, -1, "", methodObject), 
/*   98 */     new Among("ım", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  101 */   private static final Among[] a_13 = {
/*  102 */     new Among("sin", -1, -1, "", methodObject), 
/*  103 */     new Among("sun", -1, -1, "", methodObject), 
/*  104 */     new Among("sün", -1, -1, "", methodObject), 
/*  105 */     new Among("sın", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  108 */   private static final Among[] a_14 = {
/*  109 */     new Among("iz", -1, -1, "", methodObject), 
/*  110 */     new Among("uz", -1, -1, "", methodObject), 
/*  111 */     new Among("üz", -1, -1, "", methodObject), 
/*  112 */     new Among("ız", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  115 */   private static final Among[] a_15 = {
/*  116 */     new Among("siniz", -1, -1, "", methodObject), 
/*  117 */     new Among("sunuz", -1, -1, "", methodObject), 
/*  118 */     new Among("sünüz", -1, -1, "", methodObject), 
/*  119 */     new Among("sınız", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  122 */   private static final Among[] a_16 = {
/*  123 */     new Among("lar", -1, -1, "", methodObject), 
/*  124 */     new Among("ler", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  127 */   private static final Among[] a_17 = {
/*  128 */     new Among("niz", -1, -1, "", methodObject), 
/*  129 */     new Among("nuz", -1, -1, "", methodObject), 
/*  130 */     new Among("nüz", -1, -1, "", methodObject), 
/*  131 */     new Among("nız", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  134 */   private static final Among[] a_18 = {
/*  135 */     new Among("dir", -1, -1, "", methodObject), 
/*  136 */     new Among("tir", -1, -1, "", methodObject), 
/*  137 */     new Among("dur", -1, -1, "", methodObject), 
/*  138 */     new Among("tur", -1, -1, "", methodObject), 
/*  139 */     new Among("dür", -1, -1, "", methodObject), 
/*  140 */     new Among("tür", -1, -1, "", methodObject), 
/*  141 */     new Among("dır", -1, -1, "", methodObject), 
/*  142 */     new Among("tır", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  145 */   private static final Among[] a_19 = {
/*  146 */     new Among("casına", -1, -1, "", methodObject), 
/*  147 */     new Among("cesine", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  150 */   private static final Among[] a_20 = {
/*  151 */     new Among("di", -1, -1, "", methodObject), 
/*  152 */     new Among("ti", -1, -1, "", methodObject), 
/*  153 */     new Among("dik", -1, -1, "", methodObject), 
/*  154 */     new Among("tik", -1, -1, "", methodObject), 
/*  155 */     new Among("duk", -1, -1, "", methodObject), 
/*  156 */     new Among("tuk", -1, -1, "", methodObject), 
/*  157 */     new Among("dük", -1, -1, "", methodObject), 
/*  158 */     new Among("tük", -1, -1, "", methodObject), 
/*  159 */     new Among("dık", -1, -1, "", methodObject), 
/*  160 */     new Among("tık", -1, -1, "", methodObject), 
/*  161 */     new Among("dim", -1, -1, "", methodObject), 
/*  162 */     new Among("tim", -1, -1, "", methodObject), 
/*  163 */     new Among("dum", -1, -1, "", methodObject), 
/*  164 */     new Among("tum", -1, -1, "", methodObject), 
/*  165 */     new Among("düm", -1, -1, "", methodObject), 
/*  166 */     new Among("tüm", -1, -1, "", methodObject), 
/*  167 */     new Among("dım", -1, -1, "", methodObject), 
/*  168 */     new Among("tım", -1, -1, "", methodObject), 
/*  169 */     new Among("din", -1, -1, "", methodObject), 
/*  170 */     new Among("tin", -1, -1, "", methodObject), 
/*  171 */     new Among("dun", -1, -1, "", methodObject), 
/*  172 */     new Among("tun", -1, -1, "", methodObject), 
/*  173 */     new Among("dün", -1, -1, "", methodObject), 
/*  174 */     new Among("tün", -1, -1, "", methodObject), 
/*  175 */     new Among("dın", -1, -1, "", methodObject), 
/*  176 */     new Among("tın", -1, -1, "", methodObject), 
/*  177 */     new Among("du", -1, -1, "", methodObject), 
/*  178 */     new Among("tu", -1, -1, "", methodObject), 
/*  179 */     new Among("dü", -1, -1, "", methodObject), 
/*  180 */     new Among("tü", -1, -1, "", methodObject), 
/*  181 */     new Among("dı", -1, -1, "", methodObject), 
/*  182 */     new Among("tı", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  185 */   private static final Among[] a_21 = {
/*  186 */     new Among("sa", -1, -1, "", methodObject), 
/*  187 */     new Among("se", -1, -1, "", methodObject), 
/*  188 */     new Among("sak", -1, -1, "", methodObject), 
/*  189 */     new Among("sek", -1, -1, "", methodObject), 
/*  190 */     new Among("sam", -1, -1, "", methodObject), 
/*  191 */     new Among("sem", -1, -1, "", methodObject), 
/*  192 */     new Among("san", -1, -1, "", methodObject), 
/*  193 */     new Among("sen", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  196 */   private static final Among[] a_22 = {
/*  197 */     new Among("miş", -1, -1, "", methodObject), 
/*  198 */     new Among("muş", -1, -1, "", methodObject), 
/*  199 */     new Among("müş", -1, -1, "", methodObject), 
/*  200 */     new Among("mış", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*  203 */   private static final Among[] a_23 = {
/*  204 */     new Among("b", -1, 1, "", methodObject), 
/*  205 */     new Among("c", -1, 2, "", methodObject), 
/*  206 */     new Among("d", -1, 3, "", methodObject), 
/*  207 */     new Among("ğ", -1, 4, "", methodObject) };
/*      */   
/*      */ 
/*  210 */   private static final char[] g_vowel = { '\021', 'A', '\020', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', ' ', '\b', '\000''\000''\000''\000''\000''\000''\001' };
/*      */   
/*  212 */   private static final char[] g_U = { '\001', '\020', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\b', '\000''\000''\000''\000''\000''\000''\001' };
/*      */   
/*  214 */   private static final char[] g_vowel1 = { '\001', '@', '\020', '\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\001' };
/*      */   
/*  216 */   private static final char[] g_vowel2 = { '\021', '\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''' };
/*      */   
/*  218 */   private static final char[] g_vowel3 = { '\001', '\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\000''\001' };
/*      */   
/*  220 */   private static final char[] g_vowel4 = { '\021' };
/*      */   
/*  222 */   private static final char[] g_vowel5 = { 'A' };
/*      */   
/*  224 */   private static final char[] g_vowel6 = { 'A' };
/*      */   private boolean B_continue_stemming_noun_suffixes;
/*      */   private int I_strlen;
/*      */   
/*      */   private void copy_from(turkishStemmer other)
/*      */   {
/*  230 */     this.B_continue_stemming_noun_suffixes = other.B_continue_stemming_noun_suffixes;
/*  231 */     this.I_strlen = other.I_strlen;
/*  232 */     super.copy_from(other);
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
/*      */   private boolean r_check_vowel_harmony()
/*      */   {
/*  249 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */     for (;;)
/*      */     {
/*  255 */       int v_2 = this.limit - this.cursor;
/*      */       
/*  257 */       if (in_grouping_b(g_vowel, 97, 305))
/*      */       {
/*      */ 
/*      */ 
/*  261 */         this.cursor = (this.limit - v_2);
/*  262 */         break;
/*      */       }
/*  264 */       this.cursor = (this.limit - v_2);
/*  265 */       if (this.cursor <= this.limit_backward)
/*      */       {
/*  267 */         return false;
/*      */       }
/*  269 */       this.cursor -= 1;
/*      */     }
/*      */     
/*      */     int v_2;
/*      */     
/*  274 */     int v_3 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*  278 */     if (eq_s_b(1, "a"))
/*      */     {
/*      */ 
/*      */       for (;;)
/*      */       {
/*      */ 
/*      */ 
/*  285 */         int v_4 = this.limit - this.cursor;
/*      */         
/*  287 */         if (in_grouping_b(g_vowel1, 97, 305))
/*      */         {
/*      */ 
/*      */ 
/*  291 */           this.cursor = (this.limit - v_4);
/*      */           break label922;
/*      */         }
/*  294 */         this.cursor = (this.limit - v_4);
/*  295 */         if (this.cursor <= this.limit_backward) {
/*      */           break;
/*      */         }
/*      */         
/*  299 */         this.cursor -= 1;
/*      */       }
/*      */     }
/*      */     
/*  303 */     this.cursor = (this.limit - v_3);
/*      */     
/*      */ 
/*      */ 
/*  307 */     if (eq_s_b(1, "e"))
/*      */     {
/*      */ 
/*      */       for (;;)
/*      */       {
/*      */ 
/*      */ 
/*  314 */         int v_5 = this.limit - this.cursor;
/*      */         
/*  316 */         if (in_grouping_b(g_vowel2, 101, 252))
/*      */         {
/*      */ 
/*      */ 
/*  320 */           this.cursor = (this.limit - v_5);
/*      */           break label922;
/*      */         }
/*  323 */         this.cursor = (this.limit - v_5);
/*  324 */         if (this.cursor <= this.limit_backward) {
/*      */           break;
/*      */         }
/*      */         
/*  328 */         this.cursor -= 1;
/*      */       }
/*      */     }
/*      */     
/*  332 */     this.cursor = (this.limit - v_3);
/*      */     
/*      */ 
/*      */ 
/*  336 */     if (eq_s_b(1, "ı"))
/*      */     {
/*      */ 
/*      */       for (;;)
/*      */       {
/*      */ 
/*      */ 
/*  343 */         int v_6 = this.limit - this.cursor;
/*      */         
/*  345 */         if (in_grouping_b(g_vowel3, 97, 305))
/*      */         {
/*      */ 
/*      */ 
/*  349 */           this.cursor = (this.limit - v_6);
/*      */           break label922;
/*      */         }
/*  352 */         this.cursor = (this.limit - v_6);
/*  353 */         if (this.cursor <= this.limit_backward) {
/*      */           break;
/*      */         }
/*      */         
/*  357 */         this.cursor -= 1;
/*      */       }
/*      */     }
/*      */     
/*  361 */     this.cursor = (this.limit - v_3);
/*      */     
/*      */ 
/*      */ 
/*  365 */     if (eq_s_b(1, "i"))
/*      */     {
/*      */ 
/*      */       for (;;)
/*      */       {
/*      */ 
/*      */ 
/*  372 */         int v_7 = this.limit - this.cursor;
/*      */         
/*  374 */         if (in_grouping_b(g_vowel4, 101, 105))
/*      */         {
/*      */ 
/*      */ 
/*  378 */           this.cursor = (this.limit - v_7);
/*      */           break label922;
/*      */         }
/*  381 */         this.cursor = (this.limit - v_7);
/*  382 */         if (this.cursor <= this.limit_backward) {
/*      */           break;
/*      */         }
/*      */         
/*  386 */         this.cursor -= 1;
/*      */       }
/*      */     }
/*      */     
/*  390 */     this.cursor = (this.limit - v_3);
/*      */     
/*      */ 
/*      */ 
/*  394 */     if (eq_s_b(1, "o"))
/*      */     {
/*      */ 
/*      */       for (;;)
/*      */       {
/*      */ 
/*      */ 
/*  401 */         int v_8 = this.limit - this.cursor;
/*      */         
/*  403 */         if (in_grouping_b(g_vowel5, 111, 117))
/*      */         {
/*      */ 
/*      */ 
/*  407 */           this.cursor = (this.limit - v_8);
/*      */           break label922;
/*      */         }
/*  410 */         this.cursor = (this.limit - v_8);
/*  411 */         if (this.cursor <= this.limit_backward) {
/*      */           break;
/*      */         }
/*      */         
/*  415 */         this.cursor -= 1;
/*      */       }
/*      */     }
/*      */     
/*  419 */     this.cursor = (this.limit - v_3);
/*      */     
/*      */ 
/*      */ 
/*  423 */     if (eq_s_b(1, "ö"))
/*      */     {
/*      */ 
/*      */       for (;;)
/*      */       {
/*      */ 
/*      */ 
/*  430 */         int v_9 = this.limit - this.cursor;
/*      */         
/*  432 */         if (in_grouping_b(g_vowel6, 246, 252))
/*      */         {
/*      */ 
/*      */ 
/*  436 */           this.cursor = (this.limit - v_9);
/*      */           break label922;
/*      */         }
/*  439 */         this.cursor = (this.limit - v_9);
/*  440 */         if (this.cursor <= this.limit_backward) {
/*      */           break;
/*      */         }
/*      */         
/*  444 */         this.cursor -= 1;
/*      */       }
/*      */     }
/*      */     
/*  448 */     this.cursor = (this.limit - v_3);
/*      */     
/*      */ 
/*      */ 
/*  452 */     if (eq_s_b(1, "u"))
/*      */     {
/*      */ 
/*      */       for (;;)
/*      */       {
/*      */ 
/*      */ 
/*  459 */         int v_10 = this.limit - this.cursor;
/*      */         
/*  461 */         if (in_grouping_b(g_vowel5, 111, 117))
/*      */         {
/*      */ 
/*      */ 
/*  465 */           this.cursor = (this.limit - v_10);
/*      */           break label922;
/*      */         }
/*  468 */         this.cursor = (this.limit - v_10);
/*  469 */         if (this.cursor <= this.limit_backward) {
/*      */           break;
/*      */         }
/*      */         
/*  473 */         this.cursor -= 1;
/*      */       }
/*      */     }
/*      */     
/*  477 */     this.cursor = (this.limit - v_3);
/*      */     
/*      */ 
/*  480 */     if (!eq_s_b(1, "ü"))
/*      */     {
/*  482 */       return false;
/*      */     }
/*      */     
/*      */     for (;;)
/*      */     {
/*  487 */       int v_11 = this.limit - this.cursor;
/*      */       
/*  489 */       if (in_grouping_b(g_vowel6, 246, 252))
/*      */       {
/*      */ 
/*      */ 
/*  493 */         this.cursor = (this.limit - v_11);
/*  494 */         break;
/*      */       }
/*  496 */       this.cursor = (this.limit - v_11);
/*  497 */       if (this.cursor <= this.limit_backward)
/*      */       {
/*  499 */         return false;
/*      */       }
/*  501 */       this.cursor -= 1;
/*      */     }
/*      */     label922:
/*  504 */     this.cursor = (this.limit - v_1);
/*  505 */     return true;
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
/*      */   private boolean r_mark_suffix_with_optional_n_consonant()
/*      */   {
/*  519 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  524 */     int v_2 = this.limit - this.cursor;
/*      */     
/*  526 */     if (eq_s_b(1, "n"))
/*      */     {
/*      */ 
/*      */ 
/*  530 */       this.cursor = (this.limit - v_2);
/*      */       
/*  532 */       if (this.cursor > this.limit_backward)
/*      */       {
/*      */ 
/*      */ 
/*  536 */         this.cursor -= 1;
/*      */         
/*      */ 
/*  539 */         int v_3 = this.limit - this.cursor;
/*  540 */         if (in_grouping_b(g_vowel, 97, 305))
/*      */         {
/*      */ 
/*      */ 
/*  544 */           this.cursor = (this.limit - v_3);
/*      */           break label261;
/*      */         } } }
/*  547 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  552 */     int v_4 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*  556 */     int v_5 = this.limit - this.cursor;
/*      */     
/*  558 */     if (eq_s_b(1, "n"))
/*      */     {
/*      */ 
/*      */ 
/*  562 */       this.cursor = (this.limit - v_5);
/*  563 */       return false;
/*      */     }
/*  565 */     this.cursor = (this.limit - v_4);
/*      */     
/*      */ 
/*  568 */     int v_6 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  571 */     if (this.cursor <= this.limit_backward)
/*      */     {
/*  573 */       return false;
/*      */     }
/*  575 */     this.cursor -= 1;
/*      */     
/*      */ 
/*  578 */     int v_7 = this.limit - this.cursor;
/*  579 */     if (!in_grouping_b(g_vowel, 97, 305))
/*      */     {
/*  581 */       return false;
/*      */     }
/*  583 */     this.cursor = (this.limit - v_7);
/*  584 */     this.cursor = (this.limit - v_6);
/*      */     label261:
/*  586 */     return true;
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
/*      */   private boolean r_mark_suffix_with_optional_s_consonant()
/*      */   {
/*  600 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  605 */     int v_2 = this.limit - this.cursor;
/*      */     
/*  607 */     if (eq_s_b(1, "s"))
/*      */     {
/*      */ 
/*      */ 
/*  611 */       this.cursor = (this.limit - v_2);
/*      */       
/*  613 */       if (this.cursor > this.limit_backward)
/*      */       {
/*      */ 
/*      */ 
/*  617 */         this.cursor -= 1;
/*      */         
/*      */ 
/*  620 */         int v_3 = this.limit - this.cursor;
/*  621 */         if (in_grouping_b(g_vowel, 97, 305))
/*      */         {
/*      */ 
/*      */ 
/*  625 */           this.cursor = (this.limit - v_3);
/*      */           break label263;
/*      */         } } }
/*  628 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  633 */     int v_4 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*  637 */     int v_5 = this.limit - this.cursor;
/*      */     
/*  639 */     if (eq_s_b(1, "s"))
/*      */     {
/*      */ 
/*      */ 
/*  643 */       this.cursor = (this.limit - v_5);
/*  644 */       return false;
/*      */     }
/*  646 */     this.cursor = (this.limit - v_4);
/*      */     
/*      */ 
/*  649 */     int v_6 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  652 */     if (this.cursor <= this.limit_backward)
/*      */     {
/*  654 */       return false;
/*      */     }
/*  656 */     this.cursor -= 1;
/*      */     
/*      */ 
/*  659 */     int v_7 = this.limit - this.cursor;
/*  660 */     if (!in_grouping_b(g_vowel, 97, 305))
/*      */     {
/*  662 */       return false;
/*      */     }
/*  664 */     this.cursor = (this.limit - v_7);
/*  665 */     this.cursor = (this.limit - v_6);
/*      */     label263:
/*  667 */     return true;
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
/*      */   private boolean r_mark_suffix_with_optional_y_consonant()
/*      */   {
/*  681 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  686 */     int v_2 = this.limit - this.cursor;
/*      */     
/*  688 */     if (eq_s_b(1, "y"))
/*      */     {
/*      */ 
/*      */ 
/*  692 */       this.cursor = (this.limit - v_2);
/*      */       
/*  694 */       if (this.cursor > this.limit_backward)
/*      */       {
/*      */ 
/*      */ 
/*  698 */         this.cursor -= 1;
/*      */         
/*      */ 
/*  701 */         int v_3 = this.limit - this.cursor;
/*  702 */         if (in_grouping_b(g_vowel, 97, 305))
/*      */         {
/*      */ 
/*      */ 
/*  706 */           this.cursor = (this.limit - v_3);
/*      */           break label263;
/*      */         } } }
/*  709 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  714 */     int v_4 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*  718 */     int v_5 = this.limit - this.cursor;
/*      */     
/*  720 */     if (eq_s_b(1, "y"))
/*      */     {
/*      */ 
/*      */ 
/*  724 */       this.cursor = (this.limit - v_5);
/*  725 */       return false;
/*      */     }
/*  727 */     this.cursor = (this.limit - v_4);
/*      */     
/*      */ 
/*  730 */     int v_6 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  733 */     if (this.cursor <= this.limit_backward)
/*      */     {
/*  735 */       return false;
/*      */     }
/*  737 */     this.cursor -= 1;
/*      */     
/*      */ 
/*  740 */     int v_7 = this.limit - this.cursor;
/*  741 */     if (!in_grouping_b(g_vowel, 97, 305))
/*      */     {
/*  743 */       return false;
/*      */     }
/*  745 */     this.cursor = (this.limit - v_7);
/*  746 */     this.cursor = (this.limit - v_6);
/*      */     label263:
/*  748 */     return true;
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
/*      */   private boolean r_mark_suffix_with_optional_U_vowel()
/*      */   {
/*  762 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  767 */     int v_2 = this.limit - this.cursor;
/*  768 */     if (in_grouping_b(g_U, 105, 305))
/*      */     {
/*      */ 
/*      */ 
/*  772 */       this.cursor = (this.limit - v_2);
/*      */       
/*  774 */       if (this.cursor > this.limit_backward)
/*      */       {
/*      */ 
/*      */ 
/*  778 */         this.cursor -= 1;
/*      */         
/*      */ 
/*  781 */         int v_3 = this.limit - this.cursor;
/*  782 */         if (out_grouping_b(g_vowel, 97, 305))
/*      */         {
/*      */ 
/*      */ 
/*  786 */           this.cursor = (this.limit - v_3);
/*      */           break label271;
/*      */         } } }
/*  789 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  794 */     int v_4 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*  798 */     int v_5 = this.limit - this.cursor;
/*  799 */     if (in_grouping_b(g_U, 105, 305))
/*      */     {
/*      */ 
/*      */ 
/*  803 */       this.cursor = (this.limit - v_5);
/*  804 */       return false;
/*      */     }
/*  806 */     this.cursor = (this.limit - v_4);
/*      */     
/*      */ 
/*  809 */     int v_6 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  812 */     if (this.cursor <= this.limit_backward)
/*      */     {
/*  814 */       return false;
/*      */     }
/*  816 */     this.cursor -= 1;
/*      */     
/*      */ 
/*  819 */     int v_7 = this.limit - this.cursor;
/*  820 */     if (!out_grouping_b(g_vowel, 97, 305))
/*      */     {
/*  822 */       return false;
/*      */     }
/*  824 */     this.cursor = (this.limit - v_7);
/*  825 */     this.cursor = (this.limit - v_6);
/*      */     label271:
/*  827 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_possessives()
/*      */   {
/*  833 */     if (find_among_b(a_0, 10) == 0)
/*      */     {
/*  835 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  839 */     if (!r_mark_suffix_with_optional_U_vowel())
/*      */     {
/*  841 */       return false;
/*      */     }
/*  843 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_sU()
/*      */   {
/*  849 */     if (!r_check_vowel_harmony())
/*      */     {
/*  851 */       return false;
/*      */     }
/*  853 */     if (!in_grouping_b(g_U, 105, 305))
/*      */     {
/*  855 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  859 */     if (!r_mark_suffix_with_optional_s_consonant())
/*      */     {
/*  861 */       return false;
/*      */     }
/*  863 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_lArI()
/*      */   {
/*  869 */     if (find_among_b(a_1, 2) == 0)
/*      */     {
/*  871 */       return false;
/*      */     }
/*  873 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_yU()
/*      */   {
/*  879 */     if (!r_check_vowel_harmony())
/*      */     {
/*  881 */       return false;
/*      */     }
/*  883 */     if (!in_grouping_b(g_U, 105, 305))
/*      */     {
/*  885 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  889 */     if (!r_mark_suffix_with_optional_y_consonant())
/*      */     {
/*  891 */       return false;
/*      */     }
/*  893 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_nU()
/*      */   {
/*  899 */     if (!r_check_vowel_harmony())
/*      */     {
/*  901 */       return false;
/*      */     }
/*      */     
/*  904 */     if (find_among_b(a_2, 4) == 0)
/*      */     {
/*  906 */       return false;
/*      */     }
/*  908 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_nUn()
/*      */   {
/*  914 */     if (!r_check_vowel_harmony())
/*      */     {
/*  916 */       return false;
/*      */     }
/*      */     
/*  919 */     if (find_among_b(a_3, 4) == 0)
/*      */     {
/*  921 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  925 */     if (!r_mark_suffix_with_optional_n_consonant())
/*      */     {
/*  927 */       return false;
/*      */     }
/*  929 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_yA()
/*      */   {
/*  935 */     if (!r_check_vowel_harmony())
/*      */     {
/*  937 */       return false;
/*      */     }
/*      */     
/*  940 */     if (find_among_b(a_4, 2) == 0)
/*      */     {
/*  942 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  946 */     if (!r_mark_suffix_with_optional_y_consonant())
/*      */     {
/*  948 */       return false;
/*      */     }
/*  950 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_nA()
/*      */   {
/*  956 */     if (!r_check_vowel_harmony())
/*      */     {
/*  958 */       return false;
/*      */     }
/*      */     
/*  961 */     if (find_among_b(a_5, 2) == 0)
/*      */     {
/*  963 */       return false;
/*      */     }
/*  965 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_DA()
/*      */   {
/*  971 */     if (!r_check_vowel_harmony())
/*      */     {
/*  973 */       return false;
/*      */     }
/*      */     
/*  976 */     if (find_among_b(a_6, 4) == 0)
/*      */     {
/*  978 */       return false;
/*      */     }
/*  980 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_ndA()
/*      */   {
/*  986 */     if (!r_check_vowel_harmony())
/*      */     {
/*  988 */       return false;
/*      */     }
/*      */     
/*  991 */     if (find_among_b(a_7, 2) == 0)
/*      */     {
/*  993 */       return false;
/*      */     }
/*  995 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_DAn()
/*      */   {
/* 1001 */     if (!r_check_vowel_harmony())
/*      */     {
/* 1003 */       return false;
/*      */     }
/*      */     
/* 1006 */     if (find_among_b(a_8, 4) == 0)
/*      */     {
/* 1008 */       return false;
/*      */     }
/* 1010 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_ndAn()
/*      */   {
/* 1016 */     if (!r_check_vowel_harmony())
/*      */     {
/* 1018 */       return false;
/*      */     }
/*      */     
/* 1021 */     if (find_among_b(a_9, 2) == 0)
/*      */     {
/* 1023 */       return false;
/*      */     }
/* 1025 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_ylA()
/*      */   {
/* 1031 */     if (!r_check_vowel_harmony())
/*      */     {
/* 1033 */       return false;
/*      */     }
/*      */     
/* 1036 */     if (find_among_b(a_10, 2) == 0)
/*      */     {
/* 1038 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1042 */     if (!r_mark_suffix_with_optional_y_consonant())
/*      */     {
/* 1044 */       return false;
/*      */     }
/* 1046 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_ki()
/*      */   {
/* 1052 */     if (!eq_s_b(2, "ki"))
/*      */     {
/* 1054 */       return false;
/*      */     }
/* 1056 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_ncA()
/*      */   {
/* 1062 */     if (!r_check_vowel_harmony())
/*      */     {
/* 1064 */       return false;
/*      */     }
/*      */     
/* 1067 */     if (find_among_b(a_11, 2) == 0)
/*      */     {
/* 1069 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1073 */     if (!r_mark_suffix_with_optional_n_consonant())
/*      */     {
/* 1075 */       return false;
/*      */     }
/* 1077 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_yUm()
/*      */   {
/* 1083 */     if (!r_check_vowel_harmony())
/*      */     {
/* 1085 */       return false;
/*      */     }
/*      */     
/* 1088 */     if (find_among_b(a_12, 4) == 0)
/*      */     {
/* 1090 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1094 */     if (!r_mark_suffix_with_optional_y_consonant())
/*      */     {
/* 1096 */       return false;
/*      */     }
/* 1098 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_sUn()
/*      */   {
/* 1104 */     if (!r_check_vowel_harmony())
/*      */     {
/* 1106 */       return false;
/*      */     }
/*      */     
/* 1109 */     if (find_among_b(a_13, 4) == 0)
/*      */     {
/* 1111 */       return false;
/*      */     }
/* 1113 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_yUz()
/*      */   {
/* 1119 */     if (!r_check_vowel_harmony())
/*      */     {
/* 1121 */       return false;
/*      */     }
/*      */     
/* 1124 */     if (find_among_b(a_14, 4) == 0)
/*      */     {
/* 1126 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1130 */     if (!r_mark_suffix_with_optional_y_consonant())
/*      */     {
/* 1132 */       return false;
/*      */     }
/* 1134 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_sUnUz()
/*      */   {
/* 1140 */     if (find_among_b(a_15, 4) == 0)
/*      */     {
/* 1142 */       return false;
/*      */     }
/* 1144 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_lAr()
/*      */   {
/* 1150 */     if (!r_check_vowel_harmony())
/*      */     {
/* 1152 */       return false;
/*      */     }
/*      */     
/* 1155 */     if (find_among_b(a_16, 2) == 0)
/*      */     {
/* 1157 */       return false;
/*      */     }
/* 1159 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_nUz()
/*      */   {
/* 1165 */     if (!r_check_vowel_harmony())
/*      */     {
/* 1167 */       return false;
/*      */     }
/*      */     
/* 1170 */     if (find_among_b(a_17, 4) == 0)
/*      */     {
/* 1172 */       return false;
/*      */     }
/* 1174 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_DUr()
/*      */   {
/* 1180 */     if (!r_check_vowel_harmony())
/*      */     {
/* 1182 */       return false;
/*      */     }
/*      */     
/* 1185 */     if (find_among_b(a_18, 8) == 0)
/*      */     {
/* 1187 */       return false;
/*      */     }
/* 1189 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_cAsInA()
/*      */   {
/* 1195 */     if (find_among_b(a_19, 2) == 0)
/*      */     {
/* 1197 */       return false;
/*      */     }
/* 1199 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_yDU()
/*      */   {
/* 1205 */     if (!r_check_vowel_harmony())
/*      */     {
/* 1207 */       return false;
/*      */     }
/*      */     
/* 1210 */     if (find_among_b(a_20, 32) == 0)
/*      */     {
/* 1212 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1216 */     if (!r_mark_suffix_with_optional_y_consonant())
/*      */     {
/* 1218 */       return false;
/*      */     }
/* 1220 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_ysA()
/*      */   {
/* 1226 */     if (find_among_b(a_21, 8) == 0)
/*      */     {
/* 1228 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1232 */     if (!r_mark_suffix_with_optional_y_consonant())
/*      */     {
/* 1234 */       return false;
/*      */     }
/* 1236 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_ymUs_()
/*      */   {
/* 1242 */     if (!r_check_vowel_harmony())
/*      */     {
/* 1244 */       return false;
/*      */     }
/*      */     
/* 1247 */     if (find_among_b(a_22, 4) == 0)
/*      */     {
/* 1249 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1253 */     if (!r_mark_suffix_with_optional_y_consonant())
/*      */     {
/* 1255 */       return false;
/*      */     }
/* 1257 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_mark_yken()
/*      */   {
/* 1263 */     if (!eq_s_b(3, "ken"))
/*      */     {
/* 1265 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 1269 */     if (!r_mark_suffix_with_optional_y_consonant())
/*      */     {
/* 1271 */       return false;
/*      */     }
/* 1273 */     return true;
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
/*      */   private boolean r_stem_nominal_verb_suffixes()
/*      */   {
/* 1289 */     this.ket = this.cursor;
/*      */     
/* 1291 */     this.B_continue_stemming_noun_suffixes = true;
/*      */     
/*      */ 
/* 1294 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1299 */     int v_2 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1302 */     if (!r_mark_ymUs_())
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1308 */       this.cursor = (this.limit - v_2);
/*      */       
/*      */ 
/* 1311 */       if (!r_mark_yDU())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1317 */         this.cursor = (this.limit - v_2);
/*      */         
/*      */ 
/* 1320 */         if (!r_mark_ysA())
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1326 */           this.cursor = (this.limit - v_2);
/*      */           
/* 1328 */           if (!r_mark_yken())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1335 */             this.cursor = (this.limit - v_1);
/*      */             
/*      */ 
/*      */ 
/* 1339 */             if (r_mark_cAsInA())
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1346 */               int v_3 = this.limit - this.cursor;
/*      */               
/*      */ 
/* 1349 */               if (!r_mark_sUnUz())
/*      */               {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1355 */                 this.cursor = (this.limit - v_3);
/*      */                 
/*      */ 
/* 1358 */                 if (!r_mark_lAr())
/*      */                 {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1364 */                   this.cursor = (this.limit - v_3);
/*      */                   
/*      */ 
/* 1367 */                   if (!r_mark_yUm())
/*      */                   {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1373 */                     this.cursor = (this.limit - v_3);
/*      */                     
/*      */ 
/* 1376 */                     if (!r_mark_sUn())
/*      */                     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1382 */                       this.cursor = (this.limit - v_3);
/*      */                       
/*      */ 
/* 1385 */                       if (!r_mark_yUz())
/*      */                       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1391 */                         this.cursor = (this.limit - v_3); }
/*      */                     }
/*      */                   } } }
/* 1394 */               if (r_mark_ymUs_()) {}
/*      */ 
/*      */             }
/*      */             else
/*      */             {
/*      */ 
/* 1400 */               this.cursor = (this.limit - v_1);
/*      */               
/*      */ 
/*      */ 
/* 1404 */               if (r_mark_lAr())
/*      */               {
/*      */ 
/*      */ 
/*      */ 
/* 1409 */                 this.bra = this.cursor;
/*      */                 
/* 1411 */                 slice_del();
/*      */                 
/* 1413 */                 int v_4 = this.limit - this.cursor;
/*      */                 
/*      */ 
/*      */ 
/* 1417 */                 this.ket = this.cursor;
/*      */                 
/*      */ 
/*      */ 
/* 1421 */                 int v_5 = this.limit - this.cursor;
/*      */                 
/*      */ 
/* 1424 */                 if (!r_mark_DUr())
/*      */                 {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1430 */                   this.cursor = (this.limit - v_5);
/*      */                   
/*      */ 
/* 1433 */                   if (!r_mark_yDU())
/*      */                   {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1439 */                     this.cursor = (this.limit - v_5);
/*      */                     
/*      */ 
/* 1442 */                     if (!r_mark_ysA())
/*      */                     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1448 */                       this.cursor = (this.limit - v_5);
/*      */                       
/* 1450 */                       if (!r_mark_ymUs_())
/*      */                       {
/* 1452 */                         this.cursor = (this.limit - v_4);
/*      */                       }
/*      */                     }
/*      */                   }
/*      */                 }
/*      */                 
/* 1458 */                 this.B_continue_stemming_noun_suffixes = false;
/*      */               }
/*      */               else {
/* 1461 */                 this.cursor = (this.limit - v_1);
/*      */                 
/*      */ 
/*      */ 
/* 1465 */                 if (r_mark_nUz())
/*      */                 {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1472 */                   int v_6 = this.limit - this.cursor;
/*      */                   
/*      */ 
/* 1475 */                   if (!r_mark_yDU())
/*      */                   {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1481 */                     this.cursor = (this.limit - v_6);
/*      */                     
/* 1483 */                     if (r_mark_ysA()) {}
/*      */                   }
/*      */                   
/*      */ 
/*      */                 }
/*      */                 else
/*      */                 {
/* 1490 */                   this.cursor = (this.limit - v_1);
/*      */                   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1496 */                   int v_7 = this.limit - this.cursor;
/*      */                   
/*      */ 
/* 1499 */                   if (!r_mark_sUnUz())
/*      */                   {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1505 */                     this.cursor = (this.limit - v_7);
/*      */                     
/*      */ 
/* 1508 */                     if (!r_mark_yUz())
/*      */                     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1514 */                       this.cursor = (this.limit - v_7);
/*      */                       
/*      */ 
/* 1517 */                       if (!r_mark_sUn())
/*      */                       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1523 */                         this.cursor = (this.limit - v_7);
/*      */                         
/* 1525 */                         if (!r_mark_yUm()) {
/*      */                           break label548;
/*      */                         }
/*      */                       }
/*      */                     }
/*      */                   }
/* 1531 */                   this.bra = this.cursor;
/*      */                   
/* 1533 */                   slice_del();
/*      */                   
/* 1535 */                   int v_8 = this.limit - this.cursor;
/*      */                   
/*      */ 
/*      */ 
/* 1539 */                   this.ket = this.cursor;
/*      */                   
/* 1541 */                   if (!r_mark_ymUs_())
/*      */                   {
/* 1543 */                     this.cursor = (this.limit - v_8);
/*      */                     
/*      */                     break label717;
/*      */                     
/*      */                     label548:
/*      */                     
/* 1549 */                     this.cursor = (this.limit - v_1);
/*      */                     
/*      */ 
/* 1552 */                     if (!r_mark_DUr())
/*      */                     {
/* 1554 */                       return false;
/*      */                     }
/*      */                     
/* 1557 */                     this.bra = this.cursor;
/*      */                     
/* 1559 */                     slice_del();
/*      */                     
/* 1561 */                     int v_9 = this.limit - this.cursor;
/*      */                     
/*      */ 
/*      */ 
/* 1565 */                     this.ket = this.cursor;
/*      */                     
/*      */ 
/*      */ 
/* 1569 */                     int v_10 = this.limit - this.cursor;
/*      */                     
/*      */ 
/* 1572 */                     if (!r_mark_sUnUz())
/*      */                     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1578 */                       this.cursor = (this.limit - v_10);
/*      */                       
/*      */ 
/* 1581 */                       if (!r_mark_lAr())
/*      */                       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1587 */                         this.cursor = (this.limit - v_10);
/*      */                         
/*      */ 
/* 1590 */                         if (!r_mark_yUm())
/*      */                         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1596 */                           this.cursor = (this.limit - v_10);
/*      */                           
/*      */ 
/* 1599 */                           if (!r_mark_sUn())
/*      */                           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1605 */                             this.cursor = (this.limit - v_10);
/*      */                             
/*      */ 
/* 1608 */                             if (!r_mark_yUz())
/*      */                             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1614 */                               this.cursor = (this.limit - v_10); }
/*      */                           }
/*      */                         } } }
/* 1617 */                     if (!r_mark_ymUs_())
/*      */                     {
/* 1619 */                       this.cursor = (this.limit - v_9); }
/*      */                   }
/*      */                 }
/*      */               }
/*      */             } } } } }
/*      */     label717:
/* 1625 */     this.bra = this.cursor;
/*      */     
/* 1627 */     slice_del();
/* 1628 */     return true;
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
/*      */   private boolean r_stem_suffix_chain_before_ki()
/*      */   {
/* 1645 */     this.ket = this.cursor;
/*      */     
/* 1647 */     if (!r_mark_ki())
/*      */     {
/* 1649 */       return false;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1654 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 1658 */     if (r_mark_DA())
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/* 1663 */       this.bra = this.cursor;
/*      */       
/* 1665 */       slice_del();
/*      */       
/* 1667 */       int v_2 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/* 1671 */       this.ket = this.cursor;
/*      */       
/*      */ 
/* 1674 */       int v_3 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/* 1678 */       if (r_mark_lAr())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1683 */         this.bra = this.cursor;
/*      */         
/* 1685 */         slice_del();
/*      */         
/* 1687 */         int v_4 = this.limit - this.cursor;
/*      */         
/*      */ 
/*      */ 
/* 1691 */         if (!r_stem_suffix_chain_before_ki())
/*      */         {
/* 1693 */           this.cursor = (this.limit - v_4);
/*      */         }
/*      */         
/*      */       }
/*      */       else
/*      */       {
/* 1699 */         this.cursor = (this.limit - v_3);
/*      */         
/*      */ 
/* 1702 */         if (!r_mark_possessives())
/*      */         {
/* 1704 */           this.cursor = (this.limit - v_2);
/*      */         }
/*      */         else
/*      */         {
/* 1708 */           this.bra = this.cursor;
/*      */           
/* 1710 */           slice_del();
/*      */           
/* 1712 */           int v_5 = this.limit - this.cursor;
/*      */           
/*      */ 
/*      */ 
/* 1716 */           this.ket = this.cursor;
/*      */           
/* 1718 */           if (!r_mark_lAr())
/*      */           {
/* 1720 */             this.cursor = (this.limit - v_5);
/*      */           }
/*      */           else
/*      */           {
/* 1724 */             this.bra = this.cursor;
/*      */             
/* 1726 */             slice_del();
/*      */             
/* 1728 */             if (!r_stem_suffix_chain_before_ki())
/*      */             {
/* 1730 */               this.cursor = (this.limit - v_5);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/* 1738 */       this.cursor = (this.limit - v_1);
/*      */       
/*      */ 
/*      */ 
/* 1742 */       if (r_mark_nUn())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1747 */         this.bra = this.cursor;
/*      */         
/* 1749 */         slice_del();
/*      */         
/* 1751 */         int v_6 = this.limit - this.cursor;
/*      */         
/*      */ 
/*      */ 
/* 1755 */         this.ket = this.cursor;
/*      */         
/*      */ 
/* 1758 */         int v_7 = this.limit - this.cursor;
/*      */         
/*      */ 
/*      */ 
/* 1762 */         if (r_mark_lArI())
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1767 */           this.bra = this.cursor;
/*      */           
/* 1769 */           slice_del();
/*      */         }
/*      */         else {
/* 1772 */           this.cursor = (this.limit - v_7);
/*      */           
/*      */ 
/*      */ 
/* 1776 */           this.ket = this.cursor;
/*      */           
/*      */ 
/* 1779 */           int v_8 = this.limit - this.cursor;
/*      */           
/*      */ 
/* 1782 */           if (!r_mark_possessives())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1788 */             this.cursor = (this.limit - v_8);
/*      */             
/* 1790 */             if (!r_mark_sU()) {}
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*      */ 
/* 1796 */             this.bra = this.cursor;
/*      */             
/* 1798 */             slice_del();
/*      */             
/* 1800 */             int v_9 = this.limit - this.cursor;
/*      */             
/*      */ 
/*      */ 
/* 1804 */             this.ket = this.cursor;
/*      */             
/* 1806 */             if (!r_mark_lAr())
/*      */             {
/* 1808 */               this.cursor = (this.limit - v_9);
/*      */               
/*      */               break label689;
/*      */             }
/* 1812 */             this.bra = this.cursor;
/*      */             
/* 1814 */             slice_del();
/*      */             
/* 1816 */             if (r_stem_suffix_chain_before_ki())
/*      */               break label689;
/* 1818 */             this.cursor = (this.limit - v_9);
/*      */             
/*      */ 
/*      */             break label689;
/*      */           }
/*      */           
/* 1824 */           this.cursor = (this.limit - v_7);
/*      */           
/*      */ 
/* 1827 */           if (!r_stem_suffix_chain_before_ki())
/*      */           {
/* 1829 */             this.cursor = (this.limit - v_6);
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 1836 */         this.cursor = (this.limit - v_1);
/*      */         
/*      */ 
/* 1839 */         if (!r_mark_ndA())
/*      */         {
/* 1841 */           return false;
/*      */         }
/*      */         
/*      */ 
/*      */ 
/* 1846 */         int v_10 = this.limit - this.cursor;
/*      */         
/*      */ 
/*      */ 
/* 1850 */         if (r_mark_lArI())
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1855 */           this.bra = this.cursor;
/*      */           
/* 1857 */           slice_del();
/*      */         }
/*      */         else {
/* 1860 */           this.cursor = (this.limit - v_10);
/*      */           
/*      */ 
/*      */ 
/*      */ 
/* 1865 */           if (r_mark_sU())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/* 1870 */             this.bra = this.cursor;
/*      */             
/* 1872 */             slice_del();
/*      */             
/* 1874 */             int v_11 = this.limit - this.cursor;
/*      */             
/*      */ 
/*      */ 
/* 1878 */             this.ket = this.cursor;
/*      */             
/* 1880 */             if (!r_mark_lAr())
/*      */             {
/* 1882 */               this.cursor = (this.limit - v_11);
/*      */             }
/*      */             else
/*      */             {
/* 1886 */               this.bra = this.cursor;
/*      */               
/* 1888 */               slice_del();
/*      */               
/* 1890 */               if (!r_stem_suffix_chain_before_ki())
/*      */               {
/* 1892 */                 this.cursor = (this.limit - v_11);
/*      */               }
/*      */             }
/*      */           }
/*      */           else
/*      */           {
/* 1898 */             this.cursor = (this.limit - v_10);
/*      */             
/*      */ 
/* 1901 */             if (!r_stem_suffix_chain_before_ki())
/*      */             {
/* 1903 */               return false; }
/*      */           }
/*      */         } } }
/*      */     label689:
/* 1907 */     return true;
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
/*      */   private boolean r_stem_noun_suffixes()
/*      */   {
/* 1941 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 1945 */     this.ket = this.cursor;
/*      */     
/* 1947 */     if (r_mark_lAr())
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/* 1952 */       this.bra = this.cursor;
/*      */       
/* 1954 */       slice_del();
/*      */       
/* 1956 */       int v_2 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/* 1960 */       if (!r_stem_suffix_chain_before_ki())
/*      */       {
/* 1962 */         this.cursor = (this.limit - v_2);
/*      */       }
/*      */       
/*      */     }
/*      */     else
/*      */     {
/* 1968 */       this.cursor = (this.limit - v_1);
/*      */       
/*      */ 
/*      */ 
/* 1972 */       this.ket = this.cursor;
/*      */       
/* 1974 */       if (r_mark_ncA())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1979 */         this.bra = this.cursor;
/*      */         
/* 1981 */         slice_del();
/*      */         
/* 1983 */         int v_3 = this.limit - this.cursor;
/*      */         
/*      */ 
/*      */ 
/*      */ 
/* 1988 */         int v_4 = this.limit - this.cursor;
/*      */         
/*      */ 
/*      */ 
/* 1992 */         this.ket = this.cursor;
/*      */         
/* 1994 */         if (r_mark_lArI())
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 1999 */           this.bra = this.cursor;
/*      */           
/* 2001 */           slice_del();
/*      */         }
/*      */         else {
/* 2004 */           this.cursor = (this.limit - v_4);
/*      */           
/*      */ 
/*      */ 
/* 2008 */           this.ket = this.cursor;
/*      */           
/*      */ 
/* 2011 */           int v_5 = this.limit - this.cursor;
/*      */           
/*      */ 
/* 2014 */           if (!r_mark_possessives())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2020 */             this.cursor = (this.limit - v_5);
/*      */             
/* 2022 */             if (!r_mark_sU()) {}
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*      */ 
/* 2028 */             this.bra = this.cursor;
/*      */             
/* 2030 */             slice_del();
/*      */             
/* 2032 */             int v_6 = this.limit - this.cursor;
/*      */             
/*      */ 
/*      */ 
/* 2036 */             this.ket = this.cursor;
/*      */             
/* 2038 */             if (!r_mark_lAr())
/*      */             {
/* 2040 */               this.cursor = (this.limit - v_6);
/*      */               
/*      */               break label1791;
/*      */             }
/* 2044 */             this.bra = this.cursor;
/*      */             
/* 2046 */             slice_del();
/*      */             
/* 2048 */             if (r_stem_suffix_chain_before_ki())
/*      */               break label1791;
/* 2050 */             this.cursor = (this.limit - v_6);
/*      */             
/*      */ 
/*      */             break label1791;
/*      */           }
/*      */           
/* 2056 */           this.cursor = (this.limit - v_4);
/*      */           
/*      */ 
/* 2059 */           this.ket = this.cursor;
/*      */           
/* 2061 */           if (!r_mark_lAr())
/*      */           {
/* 2063 */             this.cursor = (this.limit - v_3);
/*      */           }
/*      */           else
/*      */           {
/* 2067 */             this.bra = this.cursor;
/*      */             
/* 2069 */             slice_del();
/*      */             
/* 2071 */             if (!r_stem_suffix_chain_before_ki())
/*      */             {
/* 2073 */               this.cursor = (this.limit - v_3);
/*      */             }
/*      */           }
/*      */         }
/*      */       }
/*      */       else
/*      */       {
/* 2080 */         this.cursor = (this.limit - v_1);
/*      */         
/*      */ 
/*      */ 
/* 2084 */         this.ket = this.cursor;
/*      */         
/*      */ 
/*      */ 
/* 2088 */         int v_7 = this.limit - this.cursor;
/*      */         
/*      */ 
/* 2091 */         if (!r_mark_ndA())
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2097 */           this.cursor = (this.limit - v_7);
/*      */           
/* 2099 */           if (!r_mark_nA()) {}
/*      */ 
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*      */ 
/*      */ 
/* 2107 */           int v_8 = this.limit - this.cursor;
/*      */           
/*      */ 
/*      */ 
/* 2111 */           if (r_mark_lArI())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/* 2116 */             this.bra = this.cursor;
/*      */             
/* 2118 */             slice_del();
/*      */             break label1791;
/*      */           }
/* 2121 */           this.cursor = (this.limit - v_8);
/*      */           
/*      */ 
/*      */ 
/* 2125 */           if (r_mark_sU())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/* 2130 */             this.bra = this.cursor;
/*      */             
/* 2132 */             slice_del();
/*      */             
/* 2134 */             int v_9 = this.limit - this.cursor;
/*      */             
/*      */ 
/*      */ 
/* 2138 */             this.ket = this.cursor;
/*      */             
/* 2140 */             if (!r_mark_lAr())
/*      */             {
/* 2142 */               this.cursor = (this.limit - v_9);
/*      */               
/*      */               break label1791;
/*      */             }
/* 2146 */             this.bra = this.cursor;
/*      */             
/* 2148 */             slice_del();
/*      */             
/* 2150 */             if (r_stem_suffix_chain_before_ki())
/*      */               break label1791;
/* 2152 */             this.cursor = (this.limit - v_9);
/*      */             
/*      */ 
/*      */             break label1791;
/*      */           }
/*      */           
/* 2158 */           this.cursor = (this.limit - v_8);
/*      */           
/*      */ 
/* 2161 */           if (r_stem_suffix_chain_before_ki()) {
/*      */             break label1791;
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*      */ 
/* 2168 */         this.cursor = (this.limit - v_1);
/*      */         
/*      */ 
/*      */ 
/* 2172 */         this.ket = this.cursor;
/*      */         
/*      */ 
/*      */ 
/* 2176 */         int v_10 = this.limit - this.cursor;
/*      */         
/*      */ 
/* 2179 */         if (!r_mark_ndAn())
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2185 */           this.cursor = (this.limit - v_10);
/*      */           
/* 2187 */           if (!r_mark_nU()) {}
/*      */ 
/*      */ 
/*      */         }
/*      */         else
/*      */         {
/*      */ 
/*      */ 
/* 2195 */           int v_11 = this.limit - this.cursor;
/*      */           
/*      */ 
/*      */ 
/* 2199 */           if (r_mark_sU())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/* 2204 */             this.bra = this.cursor;
/*      */             
/* 2206 */             slice_del();
/*      */             
/* 2208 */             int v_12 = this.limit - this.cursor;
/*      */             
/*      */ 
/*      */ 
/* 2212 */             this.ket = this.cursor;
/*      */             
/* 2214 */             if (!r_mark_lAr())
/*      */             {
/* 2216 */               this.cursor = (this.limit - v_12);
/*      */               
/*      */               break label1791;
/*      */             }
/* 2220 */             this.bra = this.cursor;
/*      */             
/* 2222 */             slice_del();
/*      */             
/* 2224 */             if (r_stem_suffix_chain_before_ki())
/*      */               break label1791;
/* 2226 */             this.cursor = (this.limit - v_12);
/*      */             
/*      */ 
/*      */             break label1791;
/*      */           }
/*      */           
/* 2232 */           this.cursor = (this.limit - v_11);
/*      */           
/*      */ 
/* 2235 */           if (r_mark_lArI()) {
/*      */             break label1791;
/*      */           }
/*      */         }
/*      */         
/*      */ 
/*      */ 
/* 2242 */         this.cursor = (this.limit - v_1);
/*      */         
/*      */ 
/*      */ 
/* 2246 */         this.ket = this.cursor;
/*      */         
/* 2248 */         if (r_mark_DAn())
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/* 2253 */           this.bra = this.cursor;
/*      */           
/* 2255 */           slice_del();
/*      */           
/* 2257 */           int v_13 = this.limit - this.cursor;
/*      */           
/*      */ 
/*      */ 
/* 2261 */           this.ket = this.cursor;
/*      */           
/*      */ 
/*      */ 
/* 2265 */           int v_14 = this.limit - this.cursor;
/*      */           
/*      */ 
/*      */ 
/* 2269 */           if (r_mark_possessives())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/* 2274 */             this.bra = this.cursor;
/*      */             
/* 2276 */             slice_del();
/*      */             
/* 2278 */             int v_15 = this.limit - this.cursor;
/*      */             
/*      */ 
/*      */ 
/* 2282 */             this.ket = this.cursor;
/*      */             
/* 2284 */             if (!r_mark_lAr())
/*      */             {
/* 2286 */               this.cursor = (this.limit - v_15);
/*      */             }
/*      */             else
/*      */             {
/* 2290 */               this.bra = this.cursor;
/*      */               
/* 2292 */               slice_del();
/*      */               
/* 2294 */               if (!r_stem_suffix_chain_before_ki())
/*      */               {
/* 2296 */                 this.cursor = (this.limit - v_15);
/*      */               }
/*      */             }
/*      */           }
/*      */           else
/*      */           {
/* 2302 */             this.cursor = (this.limit - v_14);
/*      */             
/*      */ 
/*      */ 
/* 2306 */             if (r_mark_lAr())
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/* 2311 */               this.bra = this.cursor;
/*      */               
/* 2313 */               slice_del();
/*      */               
/* 2315 */               int v_16 = this.limit - this.cursor;
/*      */               
/*      */ 
/*      */ 
/* 2319 */               if (!r_stem_suffix_chain_before_ki())
/*      */               {
/* 2321 */                 this.cursor = (this.limit - v_16);
/*      */               }
/*      */               
/*      */             }
/*      */             else
/*      */             {
/* 2327 */               this.cursor = (this.limit - v_14);
/*      */               
/*      */ 
/* 2330 */               if (!r_stem_suffix_chain_before_ki())
/*      */               {
/* 2332 */                 this.cursor = (this.limit - v_13);
/*      */               }
/*      */             }
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 2339 */           this.cursor = (this.limit - v_1);
/*      */           
/*      */ 
/*      */ 
/* 2343 */           this.ket = this.cursor;
/*      */           
/*      */ 
/* 2346 */           int v_17 = this.limit - this.cursor;
/*      */           
/*      */ 
/* 2349 */           if (!r_mark_nUn())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2355 */             this.cursor = (this.limit - v_17);
/*      */             
/* 2357 */             if (!r_mark_ylA()) {}
/*      */ 
/*      */           }
/*      */           else
/*      */           {
/*      */ 
/* 2363 */             this.bra = this.cursor;
/*      */             
/* 2365 */             slice_del();
/*      */             
/* 2367 */             int v_18 = this.limit - this.cursor;
/*      */             
/*      */ 
/*      */ 
/*      */ 
/* 2372 */             int v_19 = this.limit - this.cursor;
/*      */             
/*      */ 
/*      */ 
/* 2376 */             this.ket = this.cursor;
/*      */             
/* 2378 */             if (r_mark_lAr())
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/* 2383 */               this.bra = this.cursor;
/*      */               
/* 2385 */               slice_del();
/*      */               
/* 2387 */               if (r_stem_suffix_chain_before_ki()) {
/*      */                 break label1791;
/*      */               }
/*      */             }
/*      */             
/*      */ 
/* 2393 */             this.cursor = (this.limit - v_19);
/*      */             
/*      */ 
/*      */ 
/* 2397 */             this.ket = this.cursor;
/*      */             
/*      */ 
/* 2400 */             int v_20 = this.limit - this.cursor;
/*      */             
/*      */ 
/* 2403 */             if (!r_mark_possessives())
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2409 */               this.cursor = (this.limit - v_20);
/*      */               
/* 2411 */               if (!r_mark_sU()) {}
/*      */ 
/*      */             }
/*      */             else
/*      */             {
/*      */ 
/* 2417 */               this.bra = this.cursor;
/*      */               
/* 2419 */               slice_del();
/*      */               
/* 2421 */               int v_21 = this.limit - this.cursor;
/*      */               
/*      */ 
/*      */ 
/* 2425 */               this.ket = this.cursor;
/*      */               
/* 2427 */               if (!r_mark_lAr())
/*      */               {
/* 2429 */                 this.cursor = (this.limit - v_21);
/*      */                 
/*      */                 break label1791;
/*      */               }
/* 2433 */               this.bra = this.cursor;
/*      */               
/* 2435 */               slice_del();
/*      */               
/* 2437 */               if (r_stem_suffix_chain_before_ki())
/*      */                 break label1791;
/* 2439 */               this.cursor = (this.limit - v_21);
/*      */               
/*      */ 
/*      */               break label1791;
/*      */             }
/*      */             
/* 2445 */             this.cursor = (this.limit - v_19);
/*      */             
/* 2447 */             if (r_stem_suffix_chain_before_ki())
/*      */               break label1791;
/* 2449 */             this.cursor = (this.limit - v_18);
/*      */             
/*      */ 
/*      */             break label1791;
/*      */           }
/*      */           
/*      */ 
/* 2456 */           this.cursor = (this.limit - v_1);
/*      */           
/*      */ 
/*      */ 
/* 2460 */           this.ket = this.cursor;
/*      */           
/* 2462 */           if (r_mark_lArI())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/* 2467 */             this.bra = this.cursor;
/*      */             
/* 2469 */             slice_del();
/*      */           }
/*      */           else {
/* 2472 */             this.cursor = (this.limit - v_1);
/*      */             
/*      */ 
/*      */ 
/* 2476 */             if (!r_stem_suffix_chain_before_ki())
/*      */             {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2482 */               this.cursor = (this.limit - v_1);
/*      */               
/*      */ 
/*      */ 
/* 2486 */               this.ket = this.cursor;
/*      */               
/*      */ 
/* 2489 */               int v_22 = this.limit - this.cursor;
/*      */               
/*      */ 
/* 2492 */               if (!r_mark_DA())
/*      */               {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2498 */                 this.cursor = (this.limit - v_22);
/*      */                 
/*      */ 
/* 2501 */                 if (!r_mark_yU())
/*      */                 {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2507 */                   this.cursor = (this.limit - v_22);
/*      */                   
/* 2509 */                   if (!r_mark_yA()) {
/*      */                     break label1653;
/*      */                   }
/*      */                 }
/*      */               }
/*      */               
/* 2515 */               this.bra = this.cursor;
/*      */               
/* 2517 */               slice_del();
/*      */               
/* 2519 */               int v_23 = this.limit - this.cursor;
/*      */               
/*      */ 
/*      */ 
/* 2523 */               this.ket = this.cursor;
/*      */               
/*      */ 
/*      */ 
/* 2527 */               int v_24 = this.limit - this.cursor;
/*      */               
/*      */ 
/*      */ 
/* 2531 */               if (r_mark_possessives())
/*      */               {
/*      */ 
/*      */ 
/*      */ 
/* 2536 */                 this.bra = this.cursor;
/*      */                 
/* 2538 */                 slice_del();
/*      */                 
/* 2540 */                 int v_25 = this.limit - this.cursor;
/*      */                 
/*      */ 
/*      */ 
/* 2544 */                 this.ket = this.cursor;
/*      */                 
/* 2546 */                 if (!r_mark_lAr())
/*      */                 {
/* 2548 */                   this.cursor = (this.limit - v_25);
/*      */                 }
/*      */                 
/*      */               }
/*      */               else
/*      */               {
/* 2554 */                 this.cursor = (this.limit - v_24);
/*      */                 
/* 2556 */                 if (!r_mark_lAr())
/*      */                 {
/* 2558 */                   this.cursor = (this.limit - v_23);
/*      */                   
/*      */                   break label1791;
/*      */                 }
/*      */               }
/* 2563 */               this.bra = this.cursor;
/*      */               
/* 2565 */               slice_del();
/*      */               
/* 2567 */               this.ket = this.cursor;
/*      */               
/* 2569 */               if (!r_stem_suffix_chain_before_ki())
/*      */               {
/* 2571 */                 this.cursor = (this.limit - v_23);
/*      */                 
/*      */                 break label1791;
/*      */                 
/*      */                 label1653:
/*      */                 
/* 2577 */                 this.cursor = (this.limit - v_1);
/*      */                 
/*      */ 
/* 2580 */                 this.ket = this.cursor;
/*      */                 
/*      */ 
/* 2583 */                 int v_26 = this.limit - this.cursor;
/*      */                 
/*      */ 
/* 2586 */                 if (!r_mark_possessives())
/*      */                 {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2592 */                   this.cursor = (this.limit - v_26);
/*      */                   
/* 2594 */                   if (!r_mark_sU())
/*      */                   {
/* 2596 */                     return false;
/*      */                   }
/*      */                 }
/*      */                 
/* 2600 */                 this.bra = this.cursor;
/*      */                 
/* 2602 */                 slice_del();
/*      */                 
/* 2604 */                 int v_27 = this.limit - this.cursor;
/*      */                 
/*      */ 
/*      */ 
/* 2608 */                 this.ket = this.cursor;
/*      */                 
/* 2610 */                 if (!r_mark_lAr())
/*      */                 {
/* 2612 */                   this.cursor = (this.limit - v_27);
/*      */                 }
/*      */                 else
/*      */                 {
/* 2616 */                   this.bra = this.cursor;
/*      */                   
/* 2618 */                   slice_del();
/*      */                   
/* 2620 */                   if (!r_stem_suffix_chain_before_ki())
/*      */                   {
/* 2622 */                     this.cursor = (this.limit - v_27); }
/*      */                 }
/*      */               }
/*      */             } } } } }
/*      */     label1791:
/* 2627 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_post_process_last_consonants()
/*      */   {
/* 2634 */     this.ket = this.cursor;
/*      */     
/* 2636 */     int among_var = find_among_b(a_23, 4);
/* 2637 */     if (among_var == 0)
/*      */     {
/* 2639 */       return false;
/*      */     }
/*      */     
/* 2642 */     this.bra = this.cursor;
/* 2643 */     switch (among_var) {
/*      */     case 0: 
/* 2645 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/* 2649 */       slice_from("p");
/* 2650 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/* 2654 */       slice_from("ç");
/* 2655 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/* 2659 */       slice_from("t");
/* 2660 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/* 2664 */       slice_from("k");
/*      */     }
/*      */     
/* 2667 */     return true;
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
/*      */ 
/*      */   private boolean r_append_U_to_stems_ending_with_d_or_g()
/*      */   {
/* 2688 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 2692 */     int v_2 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 2695 */     if (!eq_s_b(1, "d"))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2701 */       this.cursor = (this.limit - v_2);
/*      */       
/* 2703 */       if (!eq_s_b(1, "g"))
/*      */       {
/* 2705 */         return false;
/*      */       }
/*      */     }
/* 2708 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/* 2711 */     int v_3 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 2715 */     int v_4 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */     for (;;)
/*      */     {
/* 2721 */       int v_5 = this.limit - this.cursor;
/*      */       
/* 2723 */       if (in_grouping_b(g_vowel, 97, 305))
/*      */       {
/*      */ 
/*      */ 
/* 2727 */         this.cursor = (this.limit - v_5);
/* 2728 */         break;
/*      */       }
/* 2730 */       this.cursor = (this.limit - v_5);
/* 2731 */       if (this.cursor <= this.limit_backward) {
/*      */         break label253;
/*      */       }
/*      */       
/* 2735 */       this.cursor -= 1;
/*      */     }
/*      */     
/*      */     int v_5;
/* 2739 */     int v_6 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 2742 */     if (!eq_s_b(1, "a"))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2748 */       this.cursor = (this.limit - v_6);
/*      */       
/* 2750 */       if (!eq_s_b(1, "ı")) {}
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 2755 */       this.cursor = (this.limit - v_4);
/*      */       
/*      */ 
/* 2758 */       int c = this.cursor;
/* 2759 */       insert(this.cursor, this.cursor, "ı");
/* 2760 */       this.cursor = c;
/*      */       break label817;
/*      */     }
/*      */     label253:
/* 2764 */     this.cursor = (this.limit - v_3);
/*      */     
/*      */ 
/*      */ 
/* 2768 */     int v_7 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */     for (;;)
/*      */     {
/* 2774 */       int v_8 = this.limit - this.cursor;
/*      */       
/* 2776 */       if (in_grouping_b(g_vowel, 97, 305))
/*      */       {
/*      */ 
/*      */ 
/* 2780 */         this.cursor = (this.limit - v_8);
/* 2781 */         break;
/*      */       }
/* 2783 */       this.cursor = (this.limit - v_8);
/* 2784 */       if (this.cursor <= this.limit_backward) {
/*      */         break label442;
/*      */       }
/*      */       
/* 2788 */       this.cursor -= 1;
/*      */     }
/*      */     
/*      */     int v_8;
/* 2792 */     int v_9 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 2795 */     if (!eq_s_b(1, "e"))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2801 */       this.cursor = (this.limit - v_9);
/*      */       
/* 2803 */       if (!eq_s_b(1, "i")) {}
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 2808 */       this.cursor = (this.limit - v_7);
/*      */       
/*      */ 
/* 2811 */       int c = this.cursor;
/* 2812 */       insert(this.cursor, this.cursor, "i");
/* 2813 */       this.cursor = c;
/*      */       break label817;
/*      */     }
/*      */     label442:
/* 2817 */     this.cursor = (this.limit - v_3);
/*      */     
/*      */ 
/*      */ 
/* 2821 */     int v_10 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */     for (;;)
/*      */     {
/* 2827 */       int v_11 = this.limit - this.cursor;
/*      */       
/* 2829 */       if (in_grouping_b(g_vowel, 97, 305))
/*      */       {
/*      */ 
/*      */ 
/* 2833 */         this.cursor = (this.limit - v_11);
/* 2834 */         break;
/*      */       }
/* 2836 */       this.cursor = (this.limit - v_11);
/* 2837 */       if (this.cursor <= this.limit_backward) {
/*      */         break label632;
/*      */       }
/*      */       
/* 2841 */       this.cursor -= 1;
/*      */     }
/*      */     
/*      */     int v_11;
/* 2845 */     int v_12 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 2848 */     if (!eq_s_b(1, "o"))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2854 */       this.cursor = (this.limit - v_12);
/*      */       
/* 2856 */       if (!eq_s_b(1, "u")) {}
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 2861 */       this.cursor = (this.limit - v_10);
/*      */       
/*      */ 
/* 2864 */       int c = this.cursor;
/* 2865 */       insert(this.cursor, this.cursor, "u");
/* 2866 */       this.cursor = c;
/*      */       break label817;
/*      */     }
/*      */     label632:
/* 2870 */     this.cursor = (this.limit - v_3);
/*      */     
/*      */ 
/* 2873 */     int v_13 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */     for (;;)
/*      */     {
/* 2879 */       int v_14 = this.limit - this.cursor;
/*      */       
/* 2881 */       if (in_grouping_b(g_vowel, 97, 305))
/*      */       {
/*      */ 
/*      */ 
/* 2885 */         this.cursor = (this.limit - v_14);
/* 2886 */         break;
/*      */       }
/* 2888 */       this.cursor = (this.limit - v_14);
/* 2889 */       if (this.cursor <= this.limit_backward)
/*      */       {
/* 2891 */         return false;
/*      */       }
/* 2893 */       this.cursor -= 1;
/*      */     }
/*      */     
/*      */     int v_14;
/* 2897 */     int v_15 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 2900 */     if (!eq_s_b(1, "ö"))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2906 */       this.cursor = (this.limit - v_15);
/*      */       
/* 2908 */       if (!eq_s_b(1, "ü"))
/*      */       {
/* 2910 */         return false;
/*      */       }
/*      */     }
/* 2913 */     this.cursor = (this.limit - v_13);
/*      */     
/*      */ 
/* 2916 */     int c = this.cursor;
/* 2917 */     insert(this.cursor, this.cursor, "ü");
/* 2918 */     this.cursor = c;
/*      */     
/*      */     label817:
/* 2921 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_more_than_one_syllable_word()
/*      */   {
/* 2929 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 2933 */     int v_2 = 2;
/*      */     int v_3;
/*      */     for (;;)
/*      */     {
/* 2937 */       v_3 = this.cursor;
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2944 */       while (!in_grouping(g_vowel, 97, 305))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2950 */         if (this.cursor >= this.limit) {
/*      */           break label60;
/*      */         }
/*      */         
/* 2954 */         this.cursor += 1;
/*      */       }
/* 2956 */       v_2--;
/*      */     }
/*      */     label60:
/* 2959 */     this.cursor = v_3;
/*      */     
/*      */ 
/* 2962 */     if (v_2 > 0)
/*      */     {
/* 2964 */       return false;
/*      */     }
/*      */     
/* 2967 */     this.cursor = v_1;
/* 2968 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_is_reserved_word()
/*      */   {
/* 2978 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/* 2981 */     int v_2 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2988 */     while (!eq_s(2, "ad"))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 2994 */       if (this.cursor >= this.limit) {
/*      */         break label75;
/*      */       }
/*      */       
/* 2998 */       this.cursor += 1;
/*      */     }
/*      */     
/* 3001 */     this.I_strlen = 2;
/*      */     
/* 3003 */     if (this.I_strlen == this.limit)
/*      */     {
/*      */ 
/*      */ 
/* 3007 */       this.cursor = v_2;
/*      */     } else {
/*      */       label75:
/* 3010 */       this.cursor = v_1;
/*      */       
/* 3012 */       int v_4 = this.cursor;
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 3019 */       while (!eq_s(5, "soyad"))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 3025 */         if (this.cursor >= this.limit)
/*      */         {
/* 3027 */           return false;
/*      */         }
/* 3029 */         this.cursor += 1;
/*      */       }
/*      */       
/* 3032 */       this.I_strlen = 5;
/*      */       
/* 3034 */       if (this.I_strlen != this.limit)
/*      */       {
/* 3036 */         return false;
/*      */       }
/* 3038 */       this.cursor = v_4;
/*      */     }
/* 3040 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_postlude()
/*      */   {
/* 3050 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 3054 */     if (r_is_reserved_word())
/*      */     {
/*      */ 
/*      */ 
/* 3058 */       return false;
/*      */     }
/* 3060 */     this.cursor = v_1;
/*      */     
/*      */ 
/* 3063 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*      */     
/*      */ 
/* 3066 */     int v_2 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 3069 */     if (!r_append_U_to_stems_ending_with_d_or_g()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 3074 */     this.cursor = (this.limit - v_2);
/*      */     
/* 3076 */     int v_3 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 3079 */     if (!r_post_process_last_consonants()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 3084 */     this.cursor = (this.limit - v_3);
/* 3085 */     this.cursor = this.limit_backward;return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean stem()
/*      */   {
/* 3094 */     if (!r_more_than_one_syllable_word())
/*      */     {
/* 3096 */       return false;
/*      */     }
/*      */     
/*      */ 
/* 3100 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*      */     
/*      */ 
/* 3103 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 3106 */     if (!r_stem_nominal_verb_suffixes()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 3111 */     this.cursor = (this.limit - v_1);
/*      */     
/* 3113 */     if (!this.B_continue_stemming_noun_suffixes)
/*      */     {
/* 3115 */       return false;
/*      */     }
/*      */     
/* 3118 */     int v_2 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 3121 */     if (!r_stem_noun_suffixes()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 3126 */     this.cursor = (this.limit - v_2);
/* 3127 */     this.cursor = this.limit_backward;
/* 3128 */     if (!r_postlude())
/*      */     {
/* 3130 */       return false;
/*      */     }
/* 3132 */     return true;
/*      */   }
/*      */   
/*      */   public boolean equals(Object o) {
/* 3136 */     return o instanceof turkishStemmer;
/*      */   }
/*      */   
/*      */   public int hashCode() {
/* 3140 */     return turkishStemmer.class.getName().hashCode();
/*      */   }
/*      */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\turkishStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */