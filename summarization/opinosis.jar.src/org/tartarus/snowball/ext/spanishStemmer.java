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
/*      */ public class spanishStemmer
/*      */   extends SnowballStemmer
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*   16 */   private static final spanishStemmer methodObject = new spanishStemmer();
/*      */   
/*   18 */   private static final Among[] a_0 = {
/*   19 */     new Among("", -1, 6, "", methodObject), 
/*   20 */     new Among("á", 0, 1, "", methodObject), 
/*   21 */     new Among("é", 0, 2, "", methodObject), 
/*   22 */     new Among("í", 0, 3, "", methodObject), 
/*   23 */     new Among("ó", 0, 4, "", methodObject), 
/*   24 */     new Among("ú", 0, 5, "", methodObject) };
/*      */   
/*      */ 
/*   27 */   private static final Among[] a_1 = {
/*   28 */     new Among("la", -1, -1, "", methodObject), 
/*   29 */     new Among("sela", 0, -1, "", methodObject), 
/*   30 */     new Among("le", -1, -1, "", methodObject), 
/*   31 */     new Among("me", -1, -1, "", methodObject), 
/*   32 */     new Among("se", -1, -1, "", methodObject), 
/*   33 */     new Among("lo", -1, -1, "", methodObject), 
/*   34 */     new Among("selo", 5, -1, "", methodObject), 
/*   35 */     new Among("las", -1, -1, "", methodObject), 
/*   36 */     new Among("selas", 7, -1, "", methodObject), 
/*   37 */     new Among("les", -1, -1, "", methodObject), 
/*   38 */     new Among("los", -1, -1, "", methodObject), 
/*   39 */     new Among("selos", 10, -1, "", methodObject), 
/*   40 */     new Among("nos", -1, -1, "", methodObject) };
/*      */   
/*      */ 
/*   43 */   private static final Among[] a_2 = {
/*   44 */     new Among("ando", -1, 6, "", methodObject), 
/*   45 */     new Among("iendo", -1, 6, "", methodObject), 
/*   46 */     new Among("yendo", -1, 7, "", methodObject), 
/*   47 */     new Among("ándo", -1, 2, "", methodObject), 
/*   48 */     new Among("iéndo", -1, 1, "", methodObject), 
/*   49 */     new Among("ar", -1, 6, "", methodObject), 
/*   50 */     new Among("er", -1, 6, "", methodObject), 
/*   51 */     new Among("ir", -1, 6, "", methodObject), 
/*   52 */     new Among("ár", -1, 3, "", methodObject), 
/*   53 */     new Among("ér", -1, 4, "", methodObject), 
/*   54 */     new Among("ír", -1, 5, "", methodObject) };
/*      */   
/*      */ 
/*   57 */   private static final Among[] a_3 = {
/*   58 */     new Among("ic", -1, -1, "", methodObject), 
/*   59 */     new Among("ad", -1, -1, "", methodObject), 
/*   60 */     new Among("os", -1, -1, "", methodObject), 
/*   61 */     new Among("iv", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*   64 */   private static final Among[] a_4 = {
/*   65 */     new Among("able", -1, 1, "", methodObject), 
/*   66 */     new Among("ible", -1, 1, "", methodObject), 
/*   67 */     new Among("ante", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*   70 */   private static final Among[] a_5 = {
/*   71 */     new Among("ic", -1, 1, "", methodObject), 
/*   72 */     new Among("abil", -1, 1, "", methodObject), 
/*   73 */     new Among("iv", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*   76 */   private static final Among[] a_6 = {
/*   77 */     new Among("ica", -1, 1, "", methodObject), 
/*   78 */     new Among("ancia", -1, 2, "", methodObject), 
/*   79 */     new Among("encia", -1, 5, "", methodObject), 
/*   80 */     new Among("adora", -1, 2, "", methodObject), 
/*   81 */     new Among("osa", -1, 1, "", methodObject), 
/*   82 */     new Among("ista", -1, 1, "", methodObject), 
/*   83 */     new Among("iva", -1, 9, "", methodObject), 
/*   84 */     new Among("anza", -1, 1, "", methodObject), 
/*   85 */     new Among("logía", -1, 3, "", methodObject), 
/*   86 */     new Among("idad", -1, 8, "", methodObject), 
/*   87 */     new Among("able", -1, 1, "", methodObject), 
/*   88 */     new Among("ible", -1, 1, "", methodObject), 
/*   89 */     new Among("ante", -1, 2, "", methodObject), 
/*   90 */     new Among("mente", -1, 7, "", methodObject), 
/*   91 */     new Among("amente", 13, 6, "", methodObject), 
/*   92 */     new Among("ación", -1, 2, "", methodObject), 
/*   93 */     new Among("ución", -1, 4, "", methodObject), 
/*   94 */     new Among("ico", -1, 1, "", methodObject), 
/*   95 */     new Among("ismo", -1, 1, "", methodObject), 
/*   96 */     new Among("oso", -1, 1, "", methodObject), 
/*   97 */     new Among("amiento", -1, 1, "", methodObject), 
/*   98 */     new Among("imiento", -1, 1, "", methodObject), 
/*   99 */     new Among("ivo", -1, 9, "", methodObject), 
/*  100 */     new Among("ador", -1, 2, "", methodObject), 
/*  101 */     new Among("icas", -1, 1, "", methodObject), 
/*  102 */     new Among("ancias", -1, 2, "", methodObject), 
/*  103 */     new Among("encias", -1, 5, "", methodObject), 
/*  104 */     new Among("adoras", -1, 2, "", methodObject), 
/*  105 */     new Among("osas", -1, 1, "", methodObject), 
/*  106 */     new Among("istas", -1, 1, "", methodObject), 
/*  107 */     new Among("ivas", -1, 9, "", methodObject), 
/*  108 */     new Among("anzas", -1, 1, "", methodObject), 
/*  109 */     new Among("logías", -1, 3, "", methodObject), 
/*  110 */     new Among("idades", -1, 8, "", methodObject), 
/*  111 */     new Among("ables", -1, 1, "", methodObject), 
/*  112 */     new Among("ibles", -1, 1, "", methodObject), 
/*  113 */     new Among("aciones", -1, 2, "", methodObject), 
/*  114 */     new Among("uciones", -1, 4, "", methodObject), 
/*  115 */     new Among("adores", -1, 2, "", methodObject), 
/*  116 */     new Among("antes", -1, 2, "", methodObject), 
/*  117 */     new Among("icos", -1, 1, "", methodObject), 
/*  118 */     new Among("ismos", -1, 1, "", methodObject), 
/*  119 */     new Among("osos", -1, 1, "", methodObject), 
/*  120 */     new Among("amientos", -1, 1, "", methodObject), 
/*  121 */     new Among("imientos", -1, 1, "", methodObject), 
/*  122 */     new Among("ivos", -1, 9, "", methodObject) };
/*      */   
/*      */ 
/*  125 */   private static final Among[] a_7 = {
/*  126 */     new Among("ya", -1, 1, "", methodObject), 
/*  127 */     new Among("ye", -1, 1, "", methodObject), 
/*  128 */     new Among("yan", -1, 1, "", methodObject), 
/*  129 */     new Among("yen", -1, 1, "", methodObject), 
/*  130 */     new Among("yeron", -1, 1, "", methodObject), 
/*  131 */     new Among("yendo", -1, 1, "", methodObject), 
/*  132 */     new Among("yo", -1, 1, "", methodObject), 
/*  133 */     new Among("yas", -1, 1, "", methodObject), 
/*  134 */     new Among("yes", -1, 1, "", methodObject), 
/*  135 */     new Among("yais", -1, 1, "", methodObject), 
/*  136 */     new Among("yamos", -1, 1, "", methodObject), 
/*  137 */     new Among("yó", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*  140 */   private static final Among[] a_8 = {
/*  141 */     new Among("aba", -1, 2, "", methodObject), 
/*  142 */     new Among("ada", -1, 2, "", methodObject), 
/*  143 */     new Among("ida", -1, 2, "", methodObject), 
/*  144 */     new Among("ara", -1, 2, "", methodObject), 
/*  145 */     new Among("iera", -1, 2, "", methodObject), 
/*  146 */     new Among("ía", -1, 2, "", methodObject), 
/*  147 */     new Among("aría", 5, 2, "", methodObject), 
/*  148 */     new Among("ería", 5, 2, "", methodObject), 
/*  149 */     new Among("iría", 5, 2, "", methodObject), 
/*  150 */     new Among("ad", -1, 2, "", methodObject), 
/*  151 */     new Among("ed", -1, 2, "", methodObject), 
/*  152 */     new Among("id", -1, 2, "", methodObject), 
/*  153 */     new Among("ase", -1, 2, "", methodObject), 
/*  154 */     new Among("iese", -1, 2, "", methodObject), 
/*  155 */     new Among("aste", -1, 2, "", methodObject), 
/*  156 */     new Among("iste", -1, 2, "", methodObject), 
/*  157 */     new Among("an", -1, 2, "", methodObject), 
/*  158 */     new Among("aban", 16, 2, "", methodObject), 
/*  159 */     new Among("aran", 16, 2, "", methodObject), 
/*  160 */     new Among("ieran", 16, 2, "", methodObject), 
/*  161 */     new Among("ían", 16, 2, "", methodObject), 
/*  162 */     new Among("arían", 20, 2, "", methodObject), 
/*  163 */     new Among("erían", 20, 2, "", methodObject), 
/*  164 */     new Among("irían", 20, 2, "", methodObject), 
/*  165 */     new Among("en", -1, 1, "", methodObject), 
/*  166 */     new Among("asen", 24, 2, "", methodObject), 
/*  167 */     new Among("iesen", 24, 2, "", methodObject), 
/*  168 */     new Among("aron", -1, 2, "", methodObject), 
/*  169 */     new Among("ieron", -1, 2, "", methodObject), 
/*  170 */     new Among("arán", -1, 2, "", methodObject), 
/*  171 */     new Among("erán", -1, 2, "", methodObject), 
/*  172 */     new Among("irán", -1, 2, "", methodObject), 
/*  173 */     new Among("ado", -1, 2, "", methodObject), 
/*  174 */     new Among("ido", -1, 2, "", methodObject), 
/*  175 */     new Among("ando", -1, 2, "", methodObject), 
/*  176 */     new Among("iendo", -1, 2, "", methodObject), 
/*  177 */     new Among("ar", -1, 2, "", methodObject), 
/*  178 */     new Among("er", -1, 2, "", methodObject), 
/*  179 */     new Among("ir", -1, 2, "", methodObject), 
/*  180 */     new Among("as", -1, 2, "", methodObject), 
/*  181 */     new Among("abas", 39, 2, "", methodObject), 
/*  182 */     new Among("adas", 39, 2, "", methodObject), 
/*  183 */     new Among("idas", 39, 2, "", methodObject), 
/*  184 */     new Among("aras", 39, 2, "", methodObject), 
/*  185 */     new Among("ieras", 39, 2, "", methodObject), 
/*  186 */     new Among("ías", 39, 2, "", methodObject), 
/*  187 */     new Among("arías", 45, 2, "", methodObject), 
/*  188 */     new Among("erías", 45, 2, "", methodObject), 
/*  189 */     new Among("irías", 45, 2, "", methodObject), 
/*  190 */     new Among("es", -1, 1, "", methodObject), 
/*  191 */     new Among("ases", 49, 2, "", methodObject), 
/*  192 */     new Among("ieses", 49, 2, "", methodObject), 
/*  193 */     new Among("abais", -1, 2, "", methodObject), 
/*  194 */     new Among("arais", -1, 2, "", methodObject), 
/*  195 */     new Among("ierais", -1, 2, "", methodObject), 
/*  196 */     new Among("íais", -1, 2, "", methodObject), 
/*  197 */     new Among("aríais", 55, 2, "", methodObject), 
/*  198 */     new Among("eríais", 55, 2, "", methodObject), 
/*  199 */     new Among("iríais", 55, 2, "", methodObject), 
/*  200 */     new Among("aseis", -1, 2, "", methodObject), 
/*  201 */     new Among("ieseis", -1, 2, "", methodObject), 
/*  202 */     new Among("asteis", -1, 2, "", methodObject), 
/*  203 */     new Among("isteis", -1, 2, "", methodObject), 
/*  204 */     new Among("áis", -1, 2, "", methodObject), 
/*  205 */     new Among("éis", -1, 1, "", methodObject), 
/*  206 */     new Among("aréis", 64, 2, "", methodObject), 
/*  207 */     new Among("eréis", 64, 2, "", methodObject), 
/*  208 */     new Among("iréis", 64, 2, "", methodObject), 
/*  209 */     new Among("ados", -1, 2, "", methodObject), 
/*  210 */     new Among("idos", -1, 2, "", methodObject), 
/*  211 */     new Among("amos", -1, 2, "", methodObject), 
/*  212 */     new Among("ábamos", 70, 2, "", methodObject), 
/*  213 */     new Among("áramos", 70, 2, "", methodObject), 
/*  214 */     new Among("iéramos", 70, 2, "", methodObject), 
/*  215 */     new Among("íamos", 70, 2, "", methodObject), 
/*  216 */     new Among("aríamos", 74, 2, "", methodObject), 
/*  217 */     new Among("eríamos", 74, 2, "", methodObject), 
/*  218 */     new Among("iríamos", 74, 2, "", methodObject), 
/*  219 */     new Among("emos", -1, 1, "", methodObject), 
/*  220 */     new Among("aremos", 78, 2, "", methodObject), 
/*  221 */     new Among("eremos", 78, 2, "", methodObject), 
/*  222 */     new Among("iremos", 78, 2, "", methodObject), 
/*  223 */     new Among("ásemos", 78, 2, "", methodObject), 
/*  224 */     new Among("iésemos", 78, 2, "", methodObject), 
/*  225 */     new Among("imos", -1, 2, "", methodObject), 
/*  226 */     new Among("arás", -1, 2, "", methodObject), 
/*  227 */     new Among("erás", -1, 2, "", methodObject), 
/*  228 */     new Among("irás", -1, 2, "", methodObject), 
/*  229 */     new Among("ís", -1, 2, "", methodObject), 
/*  230 */     new Among("ará", -1, 2, "", methodObject), 
/*  231 */     new Among("erá", -1, 2, "", methodObject), 
/*  232 */     new Among("irá", -1, 2, "", methodObject), 
/*  233 */     new Among("aré", -1, 2, "", methodObject), 
/*  234 */     new Among("eré", -1, 2, "", methodObject), 
/*  235 */     new Among("iré", -1, 2, "", methodObject), 
/*  236 */     new Among("ió", -1, 2, "", methodObject) };
/*      */   
/*      */ 
/*  239 */   private static final Among[] a_9 = {
/*  240 */     new Among("a", -1, 1, "", methodObject), 
/*  241 */     new Among("e", -1, 2, "", methodObject), 
/*  242 */     new Among("o", -1, 1, "", methodObject), 
/*  243 */     new Among("os", -1, 1, "", methodObject), 
/*  244 */     new Among("á", -1, 1, "", methodObject), 
/*  245 */     new Among("é", -1, 2, "", methodObject), 
/*  246 */     new Among("í", -1, 1, "", methodObject), 
/*  247 */     new Among("ó", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*  250 */   private static final char[] g_v = { '\021', 'A', '\020', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\001', '\021', '\004', '\n' };
/*      */   private int I_p2;
/*      */   private int I_p1;
/*      */   private int I_pV;
/*      */   
/*      */   private void copy_from(spanishStemmer other)
/*      */   {
/*  257 */     this.I_p2 = other.I_p2;
/*  258 */     this.I_p1 = other.I_p1;
/*  259 */     this.I_pV = other.I_pV;
/*  260 */     super.copy_from(other);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_mark_regions()
/*      */   {
/*  270 */     this.I_pV = this.limit;
/*  271 */     this.I_p1 = this.limit;
/*  272 */     this.I_p2 = this.limit;
/*      */     
/*  274 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  279 */     int v_2 = this.cursor;
/*      */     
/*      */ 
/*  282 */     if (in_grouping(g_v, 97, 252))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  288 */       int v_3 = this.cursor;
/*      */       
/*      */ 
/*  291 */       if (out_grouping(g_v, 97, 252))
/*      */       {
/*      */ 
/*      */ 
/*      */         for (;;)
/*      */         {
/*      */ 
/*      */ 
/*  299 */           if (in_grouping(g_v, 97, 252)) {
/*      */             break label319;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*  305 */           if (this.cursor >= this.limit) {
/*      */             break;
/*      */           }
/*      */           
/*  309 */           this.cursor += 1;
/*      */         }
/*      */       }
/*      */       
/*  313 */       this.cursor = v_3;
/*      */       
/*  315 */       if (in_grouping(g_v, 97, 252))
/*      */       {
/*      */ 
/*      */ 
/*      */         for (;;)
/*      */         {
/*      */ 
/*      */ 
/*  323 */           if (out_grouping(g_v, 97, 252)) {
/*      */             break label319;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*  329 */           if (this.cursor >= this.limit) {
/*      */             break;
/*      */           }
/*      */           
/*  333 */           this.cursor += 1;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  338 */     this.cursor = v_2;
/*      */     
/*  340 */     if (out_grouping(g_v, 97, 252))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  346 */       int v_6 = this.cursor;
/*      */       
/*      */ 
/*  349 */       if (out_grouping(g_v, 97, 252))
/*      */       {
/*      */ 
/*      */ 
/*      */         for (;;)
/*      */         {
/*      */ 
/*      */ 
/*  357 */           if (in_grouping(g_v, 97, 252)) {
/*      */             break label319;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*  363 */           if (this.cursor >= this.limit) {
/*      */             break;
/*      */           }
/*      */           
/*  367 */           this.cursor += 1;
/*      */         }
/*      */       }
/*      */       
/*  371 */       this.cursor = v_6;
/*      */       
/*  373 */       if (in_grouping(g_v, 97, 252))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  378 */         if (this.cursor < this.limit)
/*      */         {
/*      */ 
/*      */ 
/*  382 */           this.cursor += 1;
/*      */           
/*      */           label319:
/*      */           
/*  386 */           this.I_pV = this.cursor;
/*      */         } } }
/*  388 */     this.cursor = v_1;
/*      */     
/*  390 */     int v_8 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  397 */     while (!in_grouping(g_v, 97, 252))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  403 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  407 */       this.cursor += 1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  413 */     while (!out_grouping(g_v, 97, 252))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  419 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  423 */       this.cursor += 1;
/*      */     }
/*      */     
/*  426 */     this.I_p1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  431 */     while (!in_grouping(g_v, 97, 252))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  437 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  441 */       this.cursor += 1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  447 */     while (!out_grouping(g_v, 97, 252))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  453 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  457 */       this.cursor += 1;
/*      */     }
/*      */     
/*  460 */     this.I_p2 = this.cursor;
/*      */     label522:
/*  462 */     this.cursor = v_8;
/*  463 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_postlude()
/*      */   {
/*      */     int v_1;
/*      */     for (;;)
/*      */     {
/*  472 */       v_1 = this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  476 */       this.bra = this.cursor;
/*      */       
/*  478 */       int among_var = find_among(a_0, 6);
/*  479 */       if (among_var == 0) {
/*      */         break;
/*      */       }
/*      */       
/*      */ 
/*  484 */       this.ket = this.cursor;
/*  485 */       switch (among_var)
/*      */       {
/*      */       case 0: 
/*      */         break;
/*      */       
/*      */       case 1: 
/*  491 */         slice_from("a");
/*  492 */         break;
/*      */       
/*      */ 
/*      */       case 2: 
/*  496 */         slice_from("e");
/*  497 */         break;
/*      */       
/*      */ 
/*      */       case 3: 
/*  501 */         slice_from("i");
/*  502 */         break;
/*      */       
/*      */ 
/*      */       case 4: 
/*  506 */         slice_from("o");
/*  507 */         break;
/*      */       
/*      */ 
/*      */       case 5: 
/*  511 */         slice_from("u");
/*  512 */         break;
/*      */       
/*      */ 
/*      */       case 6: 
/*  516 */         if (this.cursor >= this.limit) {
/*      */           break label160;
/*      */         }
/*      */         
/*  520 */         this.cursor += 1;
/*      */       }
/*      */       
/*      */     }
/*      */     label160:
/*  525 */     this.cursor = v_1;
/*      */     
/*      */ 
/*  528 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_RV() {
/*  532 */     if (this.I_pV > this.cursor)
/*      */     {
/*  534 */       return false;
/*      */     }
/*  536 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_R1() {
/*  540 */     if (this.I_p1 > this.cursor)
/*      */     {
/*  542 */       return false;
/*      */     }
/*  544 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_R2() {
/*  548 */     if (this.I_p2 > this.cursor)
/*      */     {
/*  550 */       return false;
/*      */     }
/*  552 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_attached_pronoun()
/*      */   {
/*  559 */     this.ket = this.cursor;
/*      */     
/*  561 */     if (find_among_b(a_1, 13) == 0)
/*      */     {
/*  563 */       return false;
/*      */     }
/*      */     
/*  566 */     this.bra = this.cursor;
/*      */     
/*  568 */     int among_var = find_among_b(a_2, 11);
/*  569 */     if (among_var == 0)
/*      */     {
/*  571 */       return false;
/*      */     }
/*      */     
/*  574 */     if (!r_RV())
/*      */     {
/*  576 */       return false;
/*      */     }
/*  578 */     switch (among_var) {
/*      */     case 0: 
/*  580 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  584 */       this.bra = this.cursor;
/*      */       
/*  586 */       slice_from("iendo");
/*  587 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  591 */       this.bra = this.cursor;
/*      */       
/*  593 */       slice_from("ando");
/*  594 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  598 */       this.bra = this.cursor;
/*      */       
/*  600 */       slice_from("ar");
/*  601 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  605 */       this.bra = this.cursor;
/*      */       
/*  607 */       slice_from("er");
/*  608 */       break;
/*      */     
/*      */ 
/*      */     case 5: 
/*  612 */       this.bra = this.cursor;
/*      */       
/*  614 */       slice_from("ir");
/*  615 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/*  619 */       slice_del();
/*  620 */       break;
/*      */     
/*      */ 
/*      */     case 7: 
/*  624 */       if (!eq_s_b(1, "u"))
/*      */       {
/*  626 */         return false;
/*      */       }
/*      */       
/*  629 */       slice_del();
/*      */     }
/*      */     
/*  632 */     return true;
/*      */   }
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
/*  644 */     this.ket = this.cursor;
/*      */     
/*  646 */     int among_var = find_among_b(a_6, 46);
/*  647 */     if (among_var == 0)
/*      */     {
/*  649 */       return false;
/*      */     }
/*      */     
/*  652 */     this.bra = this.cursor;
/*  653 */     switch (among_var) {
/*      */     case 0: 
/*  655 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  659 */       if (!r_R2())
/*      */       {
/*  661 */         return false;
/*      */       }
/*      */       
/*  664 */       slice_del();
/*  665 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  669 */       if (!r_R2())
/*      */       {
/*  671 */         return false;
/*      */       }
/*      */       
/*  674 */       slice_del();
/*      */       
/*  676 */       int v_1 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  680 */       this.ket = this.cursor;
/*      */       
/*  682 */       if (!eq_s_b(2, "ic"))
/*      */       {
/*  684 */         this.cursor = (this.limit - v_1);
/*      */       }
/*      */       else
/*      */       {
/*  688 */         this.bra = this.cursor;
/*      */         
/*  690 */         if (!r_R2())
/*      */         {
/*  692 */           this.cursor = (this.limit - v_1);
/*      */         }
/*      */         else
/*      */         {
/*  696 */           slice_del(); }
/*      */       }
/*  698 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  702 */       if (!r_R2())
/*      */       {
/*  704 */         return false;
/*      */       }
/*      */       
/*  707 */       slice_from("log");
/*  708 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  712 */       if (!r_R2())
/*      */       {
/*  714 */         return false;
/*      */       }
/*      */       
/*  717 */       slice_from("u");
/*  718 */       break;
/*      */     
/*      */ 
/*      */     case 5: 
/*  722 */       if (!r_R2())
/*      */       {
/*  724 */         return false;
/*      */       }
/*      */       
/*  727 */       slice_from("ente");
/*  728 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/*  732 */       if (!r_R1())
/*      */       {
/*  734 */         return false;
/*      */       }
/*      */       
/*  737 */       slice_del();
/*      */       
/*  739 */       int v_2 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  743 */       this.ket = this.cursor;
/*      */       
/*  745 */       among_var = find_among_b(a_3, 4);
/*  746 */       if (among_var == 0)
/*      */       {
/*  748 */         this.cursor = (this.limit - v_2);
/*      */       }
/*      */       else
/*      */       {
/*  752 */         this.bra = this.cursor;
/*      */         
/*  754 */         if (!r_R2())
/*      */         {
/*  756 */           this.cursor = (this.limit - v_2);
/*      */         }
/*      */         else
/*      */         {
/*  760 */           slice_del();
/*  761 */           switch (among_var) {
/*      */           case 0: 
/*  763 */             this.cursor = (this.limit - v_2);
/*  764 */             break;
/*      */           
/*      */ 
/*      */           case 1: 
/*  768 */             this.ket = this.cursor;
/*      */             
/*  770 */             if (!eq_s_b(2, "at"))
/*      */             {
/*  772 */               this.cursor = (this.limit - v_2);
/*      */             }
/*      */             else
/*      */             {
/*  776 */               this.bra = this.cursor;
/*      */               
/*  778 */               if (!r_R2())
/*      */               {
/*  780 */                 this.cursor = (this.limit - v_2);
/*      */               }
/*      */               else
/*      */               {
/*  784 */                 slice_del(); }
/*      */             }
/*      */             break; }
/*      */         } }
/*  788 */       break;
/*      */     
/*      */ 
/*      */     case 7: 
/*  792 */       if (!r_R2())
/*      */       {
/*  794 */         return false;
/*      */       }
/*      */       
/*  797 */       slice_del();
/*      */       
/*  799 */       int v_3 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  803 */       this.ket = this.cursor;
/*      */       
/*  805 */       among_var = find_among_b(a_4, 3);
/*  806 */       if (among_var == 0)
/*      */       {
/*  808 */         this.cursor = (this.limit - v_3);
/*      */       }
/*      */       else
/*      */       {
/*  812 */         this.bra = this.cursor;
/*  813 */         switch (among_var) {
/*      */         case 0: 
/*  815 */           this.cursor = (this.limit - v_3);
/*  816 */           break;
/*      */         
/*      */ 
/*      */         case 1: 
/*  820 */           if (!r_R2())
/*      */           {
/*  822 */             this.cursor = (this.limit - v_3);
/*      */           }
/*      */           else
/*      */           {
/*  826 */             slice_del(); }
/*      */           break;
/*      */         }
/*      */       }
/*  830 */       break;
/*      */     
/*      */ 
/*      */     case 8: 
/*  834 */       if (!r_R2())
/*      */       {
/*  836 */         return false;
/*      */       }
/*      */       
/*  839 */       slice_del();
/*      */       
/*  841 */       int v_4 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  845 */       this.ket = this.cursor;
/*      */       
/*  847 */       among_var = find_among_b(a_5, 3);
/*  848 */       if (among_var == 0)
/*      */       {
/*  850 */         this.cursor = (this.limit - v_4);
/*      */       }
/*      */       else
/*      */       {
/*  854 */         this.bra = this.cursor;
/*  855 */         switch (among_var) {
/*      */         case 0: 
/*  857 */           this.cursor = (this.limit - v_4);
/*  858 */           break;
/*      */         
/*      */ 
/*      */         case 1: 
/*  862 */           if (!r_R2())
/*      */           {
/*  864 */             this.cursor = (this.limit - v_4);
/*      */           }
/*      */           else
/*      */           {
/*  868 */             slice_del(); }
/*      */           break;
/*      */         }
/*      */       }
/*  872 */       break;
/*      */     
/*      */ 
/*      */     case 9: 
/*  876 */       if (!r_R2())
/*      */       {
/*  878 */         return false;
/*      */       }
/*      */       
/*  881 */       slice_del();
/*      */       
/*  883 */       int v_5 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  887 */       this.ket = this.cursor;
/*      */       
/*  889 */       if (!eq_s_b(2, "at"))
/*      */       {
/*  891 */         this.cursor = (this.limit - v_5);
/*      */       }
/*      */       else
/*      */       {
/*  895 */         this.bra = this.cursor;
/*      */         
/*  897 */         if (!r_R2())
/*      */         {
/*  899 */           this.cursor = (this.limit - v_5);
/*      */         }
/*      */         else
/*      */         {
/*  903 */           slice_del(); }
/*      */       }
/*      */       break;
/*      */     }
/*  907 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_y_verb_suffix()
/*      */   {
/*  916 */     int v_1 = this.limit - this.cursor;
/*      */     
/*  918 */     if (this.cursor < this.I_pV)
/*      */     {
/*  920 */       return false;
/*      */     }
/*  922 */     this.cursor = this.I_pV;
/*  923 */     int v_2 = this.limit_backward;
/*  924 */     this.limit_backward = this.cursor;
/*  925 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*  928 */     this.ket = this.cursor;
/*      */     
/*  930 */     int among_var = find_among_b(a_7, 12);
/*  931 */     if (among_var == 0)
/*      */     {
/*  933 */       this.limit_backward = v_2;
/*  934 */       return false;
/*      */     }
/*      */     
/*  937 */     this.bra = this.cursor;
/*  938 */     this.limit_backward = v_2;
/*  939 */     switch (among_var) {
/*      */     case 0: 
/*  941 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  945 */       if (!eq_s_b(1, "u"))
/*      */       {
/*  947 */         return false;
/*      */       }
/*      */       
/*  950 */       slice_del();
/*      */     }
/*      */     
/*  953 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_verb_suffix()
/*      */   {
/*  964 */     int v_1 = this.limit - this.cursor;
/*      */     
/*  966 */     if (this.cursor < this.I_pV)
/*      */     {
/*  968 */       return false;
/*      */     }
/*  970 */     this.cursor = this.I_pV;
/*  971 */     int v_2 = this.limit_backward;
/*  972 */     this.limit_backward = this.cursor;
/*  973 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*  976 */     this.ket = this.cursor;
/*      */     
/*  978 */     int among_var = find_among_b(a_8, 96);
/*  979 */     if (among_var == 0)
/*      */     {
/*  981 */       this.limit_backward = v_2;
/*  982 */       return false;
/*      */     }
/*      */     
/*  985 */     this.bra = this.cursor;
/*  986 */     this.limit_backward = v_2;
/*  987 */     switch (among_var) {
/*      */     case 0: 
/*  989 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  993 */       int v_3 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  997 */       if (!eq_s_b(1, "u"))
/*      */       {
/*  999 */         this.cursor = (this.limit - v_3);
/*      */       }
/*      */       else
/*      */       {
/* 1003 */         int v_4 = this.limit - this.cursor;
/*      */         
/* 1005 */         if (!eq_s_b(1, "g"))
/*      */         {
/* 1007 */           this.cursor = (this.limit - v_3);
/*      */         }
/*      */         else {
/* 1010 */           this.cursor = (this.limit - v_4);
/*      */         }
/*      */       }
/* 1013 */       this.bra = this.cursor;
/*      */       
/* 1015 */       slice_del();
/* 1016 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/* 1020 */       slice_del();
/*      */     }
/*      */     
/* 1023 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_residual_suffix()
/*      */   {
/* 1032 */     this.ket = this.cursor;
/*      */     
/* 1034 */     int among_var = find_among_b(a_9, 8);
/* 1035 */     if (among_var == 0)
/*      */     {
/* 1037 */       return false;
/*      */     }
/*      */     
/* 1040 */     this.bra = this.cursor;
/* 1041 */     switch (among_var) {
/*      */     case 0: 
/* 1043 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/* 1047 */       if (!r_RV())
/*      */       {
/* 1049 */         return false;
/*      */       }
/*      */       
/* 1052 */       slice_del();
/* 1053 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/* 1057 */       if (!r_RV())
/*      */       {
/* 1059 */         return false;
/*      */       }
/*      */       
/* 1062 */       slice_del();
/*      */       
/* 1064 */       int v_1 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/* 1068 */       this.ket = this.cursor;
/*      */       
/* 1070 */       if (!eq_s_b(1, "u"))
/*      */       {
/* 1072 */         this.cursor = (this.limit - v_1);
/*      */       }
/*      */       else
/*      */       {
/* 1076 */         this.bra = this.cursor;
/*      */         
/* 1078 */         int v_2 = this.limit - this.cursor;
/*      */         
/* 1080 */         if (!eq_s_b(1, "g"))
/*      */         {
/* 1082 */           this.cursor = (this.limit - v_1);
/*      */         }
/*      */         else {
/* 1085 */           this.cursor = (this.limit - v_2);
/*      */           
/* 1087 */           if (!r_RV())
/*      */           {
/* 1089 */             this.cursor = (this.limit - v_1);
/*      */           }
/*      */           else
/*      */           {
/* 1093 */             slice_del(); }
/*      */         }
/*      */       }
/*      */       break; }
/* 1097 */     return true;
/*      */   }
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
/* 1109 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/* 1112 */     if (!r_mark_regions()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1117 */     this.cursor = v_1;
/*      */     
/* 1119 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*      */     
/*      */ 
/* 1122 */     int v_2 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1125 */     if (!r_attached_pronoun()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1130 */     this.cursor = (this.limit - v_2);
/*      */     
/* 1132 */     int v_3 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1137 */     int v_4 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1140 */     if (!r_standard_suffix())
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1146 */       this.cursor = (this.limit - v_4);
/*      */       
/*      */ 
/* 1149 */       if (!r_y_verb_suffix())
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1155 */         this.cursor = (this.limit - v_4);
/*      */         
/* 1157 */         if (r_verb_suffix()) {}
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1163 */     this.cursor = (this.limit - v_3);
/*      */     
/* 1165 */     int v_5 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1168 */     if (!r_residual_suffix()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1173 */     this.cursor = (this.limit - v_5);
/* 1174 */     this.cursor = this.limit_backward;
/* 1175 */     int v_6 = this.cursor;
/*      */     
/*      */ 
/* 1178 */     if (!r_postlude()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1183 */     this.cursor = v_6;
/* 1184 */     return true;
/*      */   }
/*      */   
/*      */   public boolean equals(Object o) {
/* 1188 */     return o instanceof spanishStemmer;
/*      */   }
/*      */   
/*      */   public int hashCode() {
/* 1192 */     return spanishStemmer.class.getName().hashCode();
/*      */   }
/*      */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\spanishStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */