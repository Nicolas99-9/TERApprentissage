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
/*      */ public class portugueseStemmer
/*      */   extends SnowballStemmer
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*   16 */   private static final portugueseStemmer methodObject = new portugueseStemmer();
/*      */   
/*   18 */   private static final Among[] a_0 = {
/*   19 */     new Among("", -1, 3, "", methodObject), 
/*   20 */     new Among("ã", 0, 1, "", methodObject), 
/*   21 */     new Among("õ", 0, 2, "", methodObject) };
/*      */   
/*      */ 
/*   24 */   private static final Among[] a_1 = {
/*   25 */     new Among("", -1, 3, "", methodObject), 
/*   26 */     new Among("a~", 0, 1, "", methodObject), 
/*   27 */     new Among("o~", 0, 2, "", methodObject) };
/*      */   
/*      */ 
/*   30 */   private static final Among[] a_2 = {
/*   31 */     new Among("ic", -1, -1, "", methodObject), 
/*   32 */     new Among("ad", -1, -1, "", methodObject), 
/*   33 */     new Among("os", -1, -1, "", methodObject), 
/*   34 */     new Among("iv", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*   37 */   private static final Among[] a_3 = {
/*   38 */     new Among("ante", -1, 1, "", methodObject), 
/*   39 */     new Among("avel", -1, 1, "", methodObject), 
/*   40 */     new Among("ível", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*   43 */   private static final Among[] a_4 = {
/*   44 */     new Among("ic", -1, 1, "", methodObject), 
/*   45 */     new Among("abil", -1, 1, "", methodObject), 
/*   46 */     new Among("iv", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*   49 */   private static final Among[] a_5 = {
/*   50 */     new Among("ica", -1, 1, "", methodObject), 
/*   51 */     new Among("ância", -1, 1, "", methodObject), 
/*   52 */     new Among("ência", -1, 4, "", methodObject), 
/*   53 */     new Among("ira", -1, 9, "", methodObject), 
/*   54 */     new Among("adora", -1, 1, "", methodObject), 
/*   55 */     new Among("osa", -1, 1, "", methodObject), 
/*   56 */     new Among("ista", -1, 1, "", methodObject), 
/*   57 */     new Among("iva", -1, 8, "", methodObject), 
/*   58 */     new Among("eza", -1, 1, "", methodObject), 
/*   59 */     new Among("logía", -1, 2, "", methodObject), 
/*   60 */     new Among("idade", -1, 7, "", methodObject), 
/*   61 */     new Among("ante", -1, 1, "", methodObject), 
/*   62 */     new Among("mente", -1, 6, "", methodObject), 
/*   63 */     new Among("amente", 12, 5, "", methodObject), 
/*   64 */     new Among("ável", -1, 1, "", methodObject), 
/*   65 */     new Among("ível", -1, 1, "", methodObject), 
/*   66 */     new Among("ución", -1, 3, "", methodObject), 
/*   67 */     new Among("ico", -1, 1, "", methodObject), 
/*   68 */     new Among("ismo", -1, 1, "", methodObject), 
/*   69 */     new Among("oso", -1, 1, "", methodObject), 
/*   70 */     new Among("amento", -1, 1, "", methodObject), 
/*   71 */     new Among("imento", -1, 1, "", methodObject), 
/*   72 */     new Among("ivo", -1, 8, "", methodObject), 
/*   73 */     new Among("aça~o", -1, 1, "", methodObject), 
/*   74 */     new Among("ador", -1, 1, "", methodObject), 
/*   75 */     new Among("icas", -1, 1, "", methodObject), 
/*   76 */     new Among("ências", -1, 4, "", methodObject), 
/*   77 */     new Among("iras", -1, 9, "", methodObject), 
/*   78 */     new Among("adoras", -1, 1, "", methodObject), 
/*   79 */     new Among("osas", -1, 1, "", methodObject), 
/*   80 */     new Among("istas", -1, 1, "", methodObject), 
/*   81 */     new Among("ivas", -1, 8, "", methodObject), 
/*   82 */     new Among("ezas", -1, 1, "", methodObject), 
/*   83 */     new Among("logías", -1, 2, "", methodObject), 
/*   84 */     new Among("idades", -1, 7, "", methodObject), 
/*   85 */     new Among("uciones", -1, 3, "", methodObject), 
/*   86 */     new Among("adores", -1, 1, "", methodObject), 
/*   87 */     new Among("antes", -1, 1, "", methodObject), 
/*   88 */     new Among("aço~es", -1, 1, "", methodObject), 
/*   89 */     new Among("icos", -1, 1, "", methodObject), 
/*   90 */     new Among("ismos", -1, 1, "", methodObject), 
/*   91 */     new Among("osos", -1, 1, "", methodObject), 
/*   92 */     new Among("amentos", -1, 1, "", methodObject), 
/*   93 */     new Among("imentos", -1, 1, "", methodObject), 
/*   94 */     new Among("ivos", -1, 8, "", methodObject) };
/*      */   
/*      */ 
/*   97 */   private static final Among[] a_6 = {
/*   98 */     new Among("ada", -1, 1, "", methodObject), 
/*   99 */     new Among("ida", -1, 1, "", methodObject), 
/*  100 */     new Among("ia", -1, 1, "", methodObject), 
/*  101 */     new Among("aria", 2, 1, "", methodObject), 
/*  102 */     new Among("eria", 2, 1, "", methodObject), 
/*  103 */     new Among("iria", 2, 1, "", methodObject), 
/*  104 */     new Among("ara", -1, 1, "", methodObject), 
/*  105 */     new Among("era", -1, 1, "", methodObject), 
/*  106 */     new Among("ira", -1, 1, "", methodObject), 
/*  107 */     new Among("ava", -1, 1, "", methodObject), 
/*  108 */     new Among("asse", -1, 1, "", methodObject), 
/*  109 */     new Among("esse", -1, 1, "", methodObject), 
/*  110 */     new Among("isse", -1, 1, "", methodObject), 
/*  111 */     new Among("aste", -1, 1, "", methodObject), 
/*  112 */     new Among("este", -1, 1, "", methodObject), 
/*  113 */     new Among("iste", -1, 1, "", methodObject), 
/*  114 */     new Among("ei", -1, 1, "", methodObject), 
/*  115 */     new Among("arei", 16, 1, "", methodObject), 
/*  116 */     new Among("erei", 16, 1, "", methodObject), 
/*  117 */     new Among("irei", 16, 1, "", methodObject), 
/*  118 */     new Among("am", -1, 1, "", methodObject), 
/*  119 */     new Among("iam", 20, 1, "", methodObject), 
/*  120 */     new Among("ariam", 21, 1, "", methodObject), 
/*  121 */     new Among("eriam", 21, 1, "", methodObject), 
/*  122 */     new Among("iriam", 21, 1, "", methodObject), 
/*  123 */     new Among("aram", 20, 1, "", methodObject), 
/*  124 */     new Among("eram", 20, 1, "", methodObject), 
/*  125 */     new Among("iram", 20, 1, "", methodObject), 
/*  126 */     new Among("avam", 20, 1, "", methodObject), 
/*  127 */     new Among("em", -1, 1, "", methodObject), 
/*  128 */     new Among("arem", 29, 1, "", methodObject), 
/*  129 */     new Among("erem", 29, 1, "", methodObject), 
/*  130 */     new Among("irem", 29, 1, "", methodObject), 
/*  131 */     new Among("assem", 29, 1, "", methodObject), 
/*  132 */     new Among("essem", 29, 1, "", methodObject), 
/*  133 */     new Among("issem", 29, 1, "", methodObject), 
/*  134 */     new Among("ado", -1, 1, "", methodObject), 
/*  135 */     new Among("ido", -1, 1, "", methodObject), 
/*  136 */     new Among("ando", -1, 1, "", methodObject), 
/*  137 */     new Among("endo", -1, 1, "", methodObject), 
/*  138 */     new Among("indo", -1, 1, "", methodObject), 
/*  139 */     new Among("ara~o", -1, 1, "", methodObject), 
/*  140 */     new Among("era~o", -1, 1, "", methodObject), 
/*  141 */     new Among("ira~o", -1, 1, "", methodObject), 
/*  142 */     new Among("ar", -1, 1, "", methodObject), 
/*  143 */     new Among("er", -1, 1, "", methodObject), 
/*  144 */     new Among("ir", -1, 1, "", methodObject), 
/*  145 */     new Among("as", -1, 1, "", methodObject), 
/*  146 */     new Among("adas", 47, 1, "", methodObject), 
/*  147 */     new Among("idas", 47, 1, "", methodObject), 
/*  148 */     new Among("ias", 47, 1, "", methodObject), 
/*  149 */     new Among("arias", 50, 1, "", methodObject), 
/*  150 */     new Among("erias", 50, 1, "", methodObject), 
/*  151 */     new Among("irias", 50, 1, "", methodObject), 
/*  152 */     new Among("aras", 47, 1, "", methodObject), 
/*  153 */     new Among("eras", 47, 1, "", methodObject), 
/*  154 */     new Among("iras", 47, 1, "", methodObject), 
/*  155 */     new Among("avas", 47, 1, "", methodObject), 
/*  156 */     new Among("es", -1, 1, "", methodObject), 
/*  157 */     new Among("ardes", 58, 1, "", methodObject), 
/*  158 */     new Among("erdes", 58, 1, "", methodObject), 
/*  159 */     new Among("irdes", 58, 1, "", methodObject), 
/*  160 */     new Among("ares", 58, 1, "", methodObject), 
/*  161 */     new Among("eres", 58, 1, "", methodObject), 
/*  162 */     new Among("ires", 58, 1, "", methodObject), 
/*  163 */     new Among("asses", 58, 1, "", methodObject), 
/*  164 */     new Among("esses", 58, 1, "", methodObject), 
/*  165 */     new Among("isses", 58, 1, "", methodObject), 
/*  166 */     new Among("astes", 58, 1, "", methodObject), 
/*  167 */     new Among("estes", 58, 1, "", methodObject), 
/*  168 */     new Among("istes", 58, 1, "", methodObject), 
/*  169 */     new Among("is", -1, 1, "", methodObject), 
/*  170 */     new Among("ais", 71, 1, "", methodObject), 
/*  171 */     new Among("eis", 71, 1, "", methodObject), 
/*  172 */     new Among("areis", 73, 1, "", methodObject), 
/*  173 */     new Among("ereis", 73, 1, "", methodObject), 
/*  174 */     new Among("ireis", 73, 1, "", methodObject), 
/*  175 */     new Among("áreis", 73, 1, "", methodObject), 
/*  176 */     new Among("éreis", 73, 1, "", methodObject), 
/*  177 */     new Among("íreis", 73, 1, "", methodObject), 
/*  178 */     new Among("ásseis", 73, 1, "", methodObject), 
/*  179 */     new Among("ésseis", 73, 1, "", methodObject), 
/*  180 */     new Among("ísseis", 73, 1, "", methodObject), 
/*  181 */     new Among("áveis", 73, 1, "", methodObject), 
/*  182 */     new Among("íeis", 73, 1, "", methodObject), 
/*  183 */     new Among("aríeis", 84, 1, "", methodObject), 
/*  184 */     new Among("eríeis", 84, 1, "", methodObject), 
/*  185 */     new Among("iríeis", 84, 1, "", methodObject), 
/*  186 */     new Among("ados", -1, 1, "", methodObject), 
/*  187 */     new Among("idos", -1, 1, "", methodObject), 
/*  188 */     new Among("amos", -1, 1, "", methodObject), 
/*  189 */     new Among("áramos", 90, 1, "", methodObject), 
/*  190 */     new Among("éramos", 90, 1, "", methodObject), 
/*  191 */     new Among("íramos", 90, 1, "", methodObject), 
/*  192 */     new Among("ávamos", 90, 1, "", methodObject), 
/*  193 */     new Among("íamos", 90, 1, "", methodObject), 
/*  194 */     new Among("aríamos", 95, 1, "", methodObject), 
/*  195 */     new Among("eríamos", 95, 1, "", methodObject), 
/*  196 */     new Among("iríamos", 95, 1, "", methodObject), 
/*  197 */     new Among("emos", -1, 1, "", methodObject), 
/*  198 */     new Among("aremos", 99, 1, "", methodObject), 
/*  199 */     new Among("eremos", 99, 1, "", methodObject), 
/*  200 */     new Among("iremos", 99, 1, "", methodObject), 
/*  201 */     new Among("ássemos", 99, 1, "", methodObject), 
/*  202 */     new Among("êssemos", 99, 1, "", methodObject), 
/*  203 */     new Among("íssemos", 99, 1, "", methodObject), 
/*  204 */     new Among("imos", -1, 1, "", methodObject), 
/*  205 */     new Among("armos", -1, 1, "", methodObject), 
/*  206 */     new Among("ermos", -1, 1, "", methodObject), 
/*  207 */     new Among("irmos", -1, 1, "", methodObject), 
/*  208 */     new Among("ámos", -1, 1, "", methodObject), 
/*  209 */     new Among("arás", -1, 1, "", methodObject), 
/*  210 */     new Among("erás", -1, 1, "", methodObject), 
/*  211 */     new Among("irás", -1, 1, "", methodObject), 
/*  212 */     new Among("eu", -1, 1, "", methodObject), 
/*  213 */     new Among("iu", -1, 1, "", methodObject), 
/*  214 */     new Among("ou", -1, 1, "", methodObject), 
/*  215 */     new Among("ará", -1, 1, "", methodObject), 
/*  216 */     new Among("erá", -1, 1, "", methodObject), 
/*  217 */     new Among("irá", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*  220 */   private static final Among[] a_7 = {
/*  221 */     new Among("a", -1, 1, "", methodObject), 
/*  222 */     new Among("i", -1, 1, "", methodObject), 
/*  223 */     new Among("o", -1, 1, "", methodObject), 
/*  224 */     new Among("os", -1, 1, "", methodObject), 
/*  225 */     new Among("á", -1, 1, "", methodObject), 
/*  226 */     new Among("í", -1, 1, "", methodObject), 
/*  227 */     new Among("ó", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*  230 */   private static final Among[] a_8 = {
/*  231 */     new Among("e", -1, 1, "", methodObject), 
/*  232 */     new Among("ç", -1, 2, "", methodObject), 
/*  233 */     new Among("é", -1, 1, "", methodObject), 
/*  234 */     new Among("ê", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*  237 */   private static final char[] g_v = { '\021', 'A', '\020', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\003', '\023', '\f', '\002' };
/*      */   private int I_p2;
/*      */   private int I_p1;
/*      */   private int I_pV;
/*      */   
/*      */   private void copy_from(portugueseStemmer other)
/*      */   {
/*  244 */     this.I_p2 = other.I_p2;
/*  245 */     this.I_p1 = other.I_p1;
/*  246 */     this.I_pV = other.I_pV;
/*  247 */     super.copy_from(other);
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_prelude()
/*      */   {
/*      */     int v_1;
/*      */     for (;;)
/*      */     {
/*  256 */       v_1 = this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  260 */       this.bra = this.cursor;
/*      */       
/*  262 */       int among_var = find_among(a_0, 3);
/*  263 */       if (among_var == 0) {
/*      */         break;
/*      */       }
/*      */       
/*      */ 
/*  268 */       this.ket = this.cursor;
/*  269 */       switch (among_var)
/*      */       {
/*      */       case 0: 
/*      */         break;
/*      */       
/*      */       case 1: 
/*  275 */         slice_from("a~");
/*  276 */         break;
/*      */       
/*      */ 
/*      */       case 2: 
/*  280 */         slice_from("o~");
/*  281 */         break;
/*      */       
/*      */ 
/*      */       case 3: 
/*  285 */         if (this.cursor >= this.limit) {
/*      */           break label116;
/*      */         }
/*      */         
/*  289 */         this.cursor += 1;
/*      */       }
/*      */       
/*      */     }
/*      */     label116:
/*  294 */     this.cursor = v_1;
/*      */     
/*      */ 
/*  297 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_mark_regions()
/*      */   {
/*  307 */     this.I_pV = this.limit;
/*  308 */     this.I_p1 = this.limit;
/*  309 */     this.I_p2 = this.limit;
/*      */     
/*  311 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  316 */     int v_2 = this.cursor;
/*      */     
/*      */ 
/*  319 */     if (in_grouping(g_v, 97, 250))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  325 */       int v_3 = this.cursor;
/*      */       
/*      */ 
/*  328 */       if (out_grouping(g_v, 97, 250))
/*      */       {
/*      */ 
/*      */ 
/*      */         for (;;)
/*      */         {
/*      */ 
/*      */ 
/*  336 */           if (in_grouping(g_v, 97, 250)) {
/*      */             break label319;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*  342 */           if (this.cursor >= this.limit) {
/*      */             break;
/*      */           }
/*      */           
/*  346 */           this.cursor += 1;
/*      */         }
/*      */       }
/*      */       
/*  350 */       this.cursor = v_3;
/*      */       
/*  352 */       if (in_grouping(g_v, 97, 250))
/*      */       {
/*      */ 
/*      */ 
/*      */         for (;;)
/*      */         {
/*      */ 
/*      */ 
/*  360 */           if (out_grouping(g_v, 97, 250)) {
/*      */             break label319;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*  366 */           if (this.cursor >= this.limit) {
/*      */             break;
/*      */           }
/*      */           
/*  370 */           this.cursor += 1;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  375 */     this.cursor = v_2;
/*      */     
/*  377 */     if (out_grouping(g_v, 97, 250))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  383 */       int v_6 = this.cursor;
/*      */       
/*      */ 
/*  386 */       if (out_grouping(g_v, 97, 250))
/*      */       {
/*      */ 
/*      */ 
/*      */         for (;;)
/*      */         {
/*      */ 
/*      */ 
/*  394 */           if (in_grouping(g_v, 97, 250)) {
/*      */             break label319;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*  400 */           if (this.cursor >= this.limit) {
/*      */             break;
/*      */           }
/*      */           
/*  404 */           this.cursor += 1;
/*      */         }
/*      */       }
/*      */       
/*  408 */       this.cursor = v_6;
/*      */       
/*  410 */       if (in_grouping(g_v, 97, 250))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  415 */         if (this.cursor < this.limit)
/*      */         {
/*      */ 
/*      */ 
/*  419 */           this.cursor += 1;
/*      */           
/*      */           label319:
/*      */           
/*  423 */           this.I_pV = this.cursor;
/*      */         } } }
/*  425 */     this.cursor = v_1;
/*      */     
/*  427 */     int v_8 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  434 */     while (!in_grouping(g_v, 97, 250))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  440 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  444 */       this.cursor += 1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  450 */     while (!out_grouping(g_v, 97, 250))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  456 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  460 */       this.cursor += 1;
/*      */     }
/*      */     
/*  463 */     this.I_p1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  468 */     while (!in_grouping(g_v, 97, 250))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  474 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  478 */       this.cursor += 1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  484 */     while (!out_grouping(g_v, 97, 250))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  490 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  494 */       this.cursor += 1;
/*      */     }
/*      */     
/*  497 */     this.I_p2 = this.cursor;
/*      */     label522:
/*  499 */     this.cursor = v_8;
/*  500 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_postlude()
/*      */   {
/*      */     int v_1;
/*      */     for (;;)
/*      */     {
/*  509 */       v_1 = this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  513 */       this.bra = this.cursor;
/*      */       
/*  515 */       int among_var = find_among(a_1, 3);
/*  516 */       if (among_var == 0) {
/*      */         break;
/*      */       }
/*      */       
/*      */ 
/*  521 */       this.ket = this.cursor;
/*  522 */       switch (among_var)
/*      */       {
/*      */       case 0: 
/*      */         break;
/*      */       
/*      */       case 1: 
/*  528 */         slice_from("ã");
/*  529 */         break;
/*      */       
/*      */ 
/*      */       case 2: 
/*  533 */         slice_from("õ");
/*  534 */         break;
/*      */       
/*      */ 
/*      */       case 3: 
/*  538 */         if (this.cursor >= this.limit) {
/*      */           break label116;
/*      */         }
/*      */         
/*  542 */         this.cursor += 1;
/*      */       }
/*      */       
/*      */     }
/*      */     label116:
/*  547 */     this.cursor = v_1;
/*      */     
/*      */ 
/*  550 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_RV() {
/*  554 */     if (this.I_pV > this.cursor)
/*      */     {
/*  556 */       return false;
/*      */     }
/*  558 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_R1() {
/*  562 */     if (this.I_p1 > this.cursor)
/*      */     {
/*  564 */       return false;
/*      */     }
/*  566 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_R2() {
/*  570 */     if (this.I_p2 > this.cursor)
/*      */     {
/*  572 */       return false;
/*      */     }
/*  574 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_standard_suffix()
/*      */   {
/*  585 */     this.ket = this.cursor;
/*      */     
/*  587 */     int among_var = find_among_b(a_5, 45);
/*  588 */     if (among_var == 0)
/*      */     {
/*  590 */       return false;
/*      */     }
/*      */     
/*  593 */     this.bra = this.cursor;
/*  594 */     switch (among_var) {
/*      */     case 0: 
/*  596 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  600 */       if (!r_R2())
/*      */       {
/*  602 */         return false;
/*      */       }
/*      */       
/*  605 */       slice_del();
/*  606 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  610 */       if (!r_R2())
/*      */       {
/*  612 */         return false;
/*      */       }
/*      */       
/*  615 */       slice_from("log");
/*  616 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  620 */       if (!r_R2())
/*      */       {
/*  622 */         return false;
/*      */       }
/*      */       
/*  625 */       slice_from("u");
/*  626 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  630 */       if (!r_R2())
/*      */       {
/*  632 */         return false;
/*      */       }
/*      */       
/*  635 */       slice_from("ente");
/*  636 */       break;
/*      */     
/*      */ 
/*      */     case 5: 
/*  640 */       if (!r_R1())
/*      */       {
/*  642 */         return false;
/*      */       }
/*      */       
/*  645 */       slice_del();
/*      */       
/*  647 */       int v_1 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  651 */       this.ket = this.cursor;
/*      */       
/*  653 */       among_var = find_among_b(a_2, 4);
/*  654 */       if (among_var == 0)
/*      */       {
/*  656 */         this.cursor = (this.limit - v_1);
/*      */       }
/*      */       else
/*      */       {
/*  660 */         this.bra = this.cursor;
/*      */         
/*  662 */         if (!r_R2())
/*      */         {
/*  664 */           this.cursor = (this.limit - v_1);
/*      */         }
/*      */         else
/*      */         {
/*  668 */           slice_del();
/*  669 */           switch (among_var) {
/*      */           case 0: 
/*  671 */             this.cursor = (this.limit - v_1);
/*  672 */             break;
/*      */           
/*      */ 
/*      */           case 1: 
/*  676 */             this.ket = this.cursor;
/*      */             
/*  678 */             if (!eq_s_b(2, "at"))
/*      */             {
/*  680 */               this.cursor = (this.limit - v_1);
/*      */             }
/*      */             else
/*      */             {
/*  684 */               this.bra = this.cursor;
/*      */               
/*  686 */               if (!r_R2())
/*      */               {
/*  688 */                 this.cursor = (this.limit - v_1);
/*      */               }
/*      */               else
/*      */               {
/*  692 */                 slice_del(); }
/*      */             }
/*      */             break; }
/*      */         } }
/*  696 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/*  700 */       if (!r_R2())
/*      */       {
/*  702 */         return false;
/*      */       }
/*      */       
/*  705 */       slice_del();
/*      */       
/*  707 */       int v_2 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  711 */       this.ket = this.cursor;
/*      */       
/*  713 */       among_var = find_among_b(a_3, 3);
/*  714 */       if (among_var == 0)
/*      */       {
/*  716 */         this.cursor = (this.limit - v_2);
/*      */       }
/*      */       else
/*      */       {
/*  720 */         this.bra = this.cursor;
/*  721 */         switch (among_var) {
/*      */         case 0: 
/*  723 */           this.cursor = (this.limit - v_2);
/*  724 */           break;
/*      */         
/*      */ 
/*      */         case 1: 
/*  728 */           if (!r_R2())
/*      */           {
/*  730 */             this.cursor = (this.limit - v_2);
/*      */           }
/*      */           else
/*      */           {
/*  734 */             slice_del(); }
/*      */           break;
/*      */         }
/*      */       }
/*  738 */       break;
/*      */     
/*      */ 
/*      */     case 7: 
/*  742 */       if (!r_R2())
/*      */       {
/*  744 */         return false;
/*      */       }
/*      */       
/*  747 */       slice_del();
/*      */       
/*  749 */       int v_3 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  753 */       this.ket = this.cursor;
/*      */       
/*  755 */       among_var = find_among_b(a_4, 3);
/*  756 */       if (among_var == 0)
/*      */       {
/*  758 */         this.cursor = (this.limit - v_3);
/*      */       }
/*      */       else
/*      */       {
/*  762 */         this.bra = this.cursor;
/*  763 */         switch (among_var) {
/*      */         case 0: 
/*  765 */           this.cursor = (this.limit - v_3);
/*  766 */           break;
/*      */         
/*      */ 
/*      */         case 1: 
/*  770 */           if (!r_R2())
/*      */           {
/*  772 */             this.cursor = (this.limit - v_3);
/*      */           }
/*      */           else
/*      */           {
/*  776 */             slice_del(); }
/*      */           break;
/*      */         }
/*      */       }
/*  780 */       break;
/*      */     
/*      */ 
/*      */     case 8: 
/*  784 */       if (!r_R2())
/*      */       {
/*  786 */         return false;
/*      */       }
/*      */       
/*  789 */       slice_del();
/*      */       
/*  791 */       int v_4 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  795 */       this.ket = this.cursor;
/*      */       
/*  797 */       if (!eq_s_b(2, "at"))
/*      */       {
/*  799 */         this.cursor = (this.limit - v_4);
/*      */       }
/*      */       else
/*      */       {
/*  803 */         this.bra = this.cursor;
/*      */         
/*  805 */         if (!r_R2())
/*      */         {
/*  807 */           this.cursor = (this.limit - v_4);
/*      */         }
/*      */         else
/*      */         {
/*  811 */           slice_del(); }
/*      */       }
/*  813 */       break;
/*      */     
/*      */ 
/*      */     case 9: 
/*  817 */       if (!r_RV())
/*      */       {
/*  819 */         return false;
/*      */       }
/*      */       
/*  822 */       if (!eq_s_b(1, "e"))
/*      */       {
/*  824 */         return false;
/*      */       }
/*      */       
/*  827 */       slice_from("ir");
/*      */     }
/*      */     
/*  830 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_verb_suffix()
/*      */   {
/*  838 */     int v_1 = this.limit - this.cursor;
/*      */     
/*  840 */     if (this.cursor < this.I_pV)
/*      */     {
/*  842 */       return false;
/*      */     }
/*  844 */     this.cursor = this.I_pV;
/*  845 */     int v_2 = this.limit_backward;
/*  846 */     this.limit_backward = this.cursor;
/*  847 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*  850 */     this.ket = this.cursor;
/*      */     
/*  852 */     int among_var = find_among_b(a_6, 120);
/*  853 */     if (among_var == 0)
/*      */     {
/*  855 */       this.limit_backward = v_2;
/*  856 */       return false;
/*      */     }
/*      */     
/*  859 */     this.bra = this.cursor;
/*  860 */     switch (among_var) {
/*      */     case 0: 
/*  862 */       this.limit_backward = v_2;
/*  863 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  867 */       slice_del();
/*      */     }
/*      */     
/*  870 */     this.limit_backward = v_2;
/*  871 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_residual_suffix()
/*      */   {
/*  878 */     this.ket = this.cursor;
/*      */     
/*  880 */     int among_var = find_among_b(a_7, 7);
/*  881 */     if (among_var == 0)
/*      */     {
/*  883 */       return false;
/*      */     }
/*      */     
/*  886 */     this.bra = this.cursor;
/*  887 */     switch (among_var) {
/*      */     case 0: 
/*  889 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  893 */       if (!r_RV())
/*      */       {
/*  895 */         return false;
/*      */       }
/*      */       
/*  898 */       slice_del();
/*      */     }
/*      */     
/*  901 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_residual_form()
/*      */   {
/*  911 */     this.ket = this.cursor;
/*      */     
/*  913 */     int among_var = find_among_b(a_8, 4);
/*  914 */     if (among_var == 0)
/*      */     {
/*  916 */       return false;
/*      */     }
/*      */     
/*  919 */     this.bra = this.cursor;
/*  920 */     switch (among_var) {
/*      */     case 0: 
/*  922 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  926 */       if (!r_RV())
/*      */       {
/*  928 */         return false;
/*      */       }
/*      */       
/*  931 */       slice_del();
/*      */       
/*  933 */       this.ket = this.cursor;
/*      */       
/*      */ 
/*  936 */       int v_1 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  940 */       if (eq_s_b(1, "u"))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  945 */         this.bra = this.cursor;
/*      */         
/*  947 */         int v_2 = this.limit - this.cursor;
/*      */         
/*  949 */         if (eq_s_b(1, "g"))
/*      */         {
/*      */ 
/*      */ 
/*  953 */           this.cursor = (this.limit - v_2);
/*      */           break label218;
/*      */         } }
/*  956 */       this.cursor = (this.limit - v_1);
/*      */       
/*      */ 
/*  959 */       if (!eq_s_b(1, "i"))
/*      */       {
/*  961 */         return false;
/*      */       }
/*      */       
/*  964 */       this.bra = this.cursor;
/*      */       
/*  966 */       int v_3 = this.limit - this.cursor;
/*      */       
/*  968 */       if (!eq_s_b(1, "c"))
/*      */       {
/*  970 */         return false;
/*      */       }
/*  972 */       this.cursor = (this.limit - v_3);
/*      */       
/*      */ 
/*  975 */       if (!r_RV())
/*      */       {
/*  977 */         return false;
/*      */       }
/*      */       
/*  980 */       slice_del();
/*  981 */       break;
/*      */     case 2: 
/*      */       label218:
/*      */       
/*  985 */       slice_from("c");
/*      */     }
/*      */     
/*  988 */     return true;
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
/* 1004 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/* 1007 */     if (!r_prelude()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1012 */     this.cursor = v_1;
/*      */     
/* 1014 */     int v_2 = this.cursor;
/*      */     
/*      */ 
/* 1017 */     if (!r_mark_regions()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1022 */     this.cursor = v_2;
/*      */     
/* 1024 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*      */     
/*      */ 
/* 1027 */     int v_3 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1032 */     int v_4 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 1036 */     int v_5 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 1040 */     int v_6 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1043 */     if (!r_standard_suffix())
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1049 */       this.cursor = (this.limit - v_6);
/*      */       
/* 1051 */       if (!r_verb_suffix()) {}
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 1056 */       this.cursor = (this.limit - v_5);
/*      */       
/* 1058 */       int v_7 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/* 1062 */       this.ket = this.cursor;
/*      */       
/* 1064 */       if (eq_s_b(1, "i"))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1069 */         this.bra = this.cursor;
/*      */         
/* 1071 */         int v_8 = this.limit - this.cursor;
/*      */         
/* 1073 */         if (eq_s_b(1, "c"))
/*      */         {
/*      */ 
/*      */ 
/* 1077 */           this.cursor = (this.limit - v_8);
/*      */           
/* 1079 */           if (r_RV())
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/* 1084 */             slice_del(); }
/*      */         } }
/* 1086 */       this.cursor = (this.limit - v_7);
/*      */       break label255;
/*      */     }
/* 1089 */     this.cursor = (this.limit - v_4);
/*      */     
/* 1091 */     if (!r_residual_suffix()) {}
/*      */     
/*      */ 
/*      */     label255:
/*      */     
/*      */ 
/* 1097 */     this.cursor = (this.limit - v_3);
/*      */     
/* 1099 */     int v_9 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1102 */     if (!r_residual_form()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1107 */     this.cursor = (this.limit - v_9);
/* 1108 */     this.cursor = this.limit_backward;
/* 1109 */     int v_10 = this.cursor;
/*      */     
/*      */ 
/* 1112 */     if (!r_postlude()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1117 */     this.cursor = v_10;
/* 1118 */     return true;
/*      */   }
/*      */   
/*      */   public boolean equals(Object o) {
/* 1122 */     return o instanceof portugueseStemmer;
/*      */   }
/*      */   
/*      */   public int hashCode() {
/* 1126 */     return portugueseStemmer.class.getName().hashCode();
/*      */   }
/*      */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\portugueseStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */