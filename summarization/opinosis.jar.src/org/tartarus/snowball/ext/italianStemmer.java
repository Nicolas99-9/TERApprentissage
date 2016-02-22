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
/*      */ public class italianStemmer
/*      */   extends SnowballStemmer
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*   16 */   private static final italianStemmer methodObject = new italianStemmer();
/*      */   
/*   18 */   private static final Among[] a_0 = {
/*   19 */     new Among("", -1, 7, "", methodObject), 
/*   20 */     new Among("qu", 0, 6, "", methodObject), 
/*   21 */     new Among("á", 0, 1, "", methodObject), 
/*   22 */     new Among("é", 0, 2, "", methodObject), 
/*   23 */     new Among("í", 0, 3, "", methodObject), 
/*   24 */     new Among("ó", 0, 4, "", methodObject), 
/*   25 */     new Among("ú", 0, 5, "", methodObject) };
/*      */   
/*      */ 
/*   28 */   private static final Among[] a_1 = {
/*   29 */     new Among("", -1, 3, "", methodObject), 
/*   30 */     new Among("I", 0, 1, "", methodObject), 
/*   31 */     new Among("U", 0, 2, "", methodObject) };
/*      */   
/*      */ 
/*   34 */   private static final Among[] a_2 = {
/*   35 */     new Among("la", -1, -1, "", methodObject), 
/*   36 */     new Among("cela", 0, -1, "", methodObject), 
/*   37 */     new Among("gliela", 0, -1, "", methodObject), 
/*   38 */     new Among("mela", 0, -1, "", methodObject), 
/*   39 */     new Among("tela", 0, -1, "", methodObject), 
/*   40 */     new Among("vela", 0, -1, "", methodObject), 
/*   41 */     new Among("le", -1, -1, "", methodObject), 
/*   42 */     new Among("cele", 6, -1, "", methodObject), 
/*   43 */     new Among("gliele", 6, -1, "", methodObject), 
/*   44 */     new Among("mele", 6, -1, "", methodObject), 
/*   45 */     new Among("tele", 6, -1, "", methodObject), 
/*   46 */     new Among("vele", 6, -1, "", methodObject), 
/*   47 */     new Among("ne", -1, -1, "", methodObject), 
/*   48 */     new Among("cene", 12, -1, "", methodObject), 
/*   49 */     new Among("gliene", 12, -1, "", methodObject), 
/*   50 */     new Among("mene", 12, -1, "", methodObject), 
/*   51 */     new Among("sene", 12, -1, "", methodObject), 
/*   52 */     new Among("tene", 12, -1, "", methodObject), 
/*   53 */     new Among("vene", 12, -1, "", methodObject), 
/*   54 */     new Among("ci", -1, -1, "", methodObject), 
/*   55 */     new Among("li", -1, -1, "", methodObject), 
/*   56 */     new Among("celi", 20, -1, "", methodObject), 
/*   57 */     new Among("glieli", 20, -1, "", methodObject), 
/*   58 */     new Among("meli", 20, -1, "", methodObject), 
/*   59 */     new Among("teli", 20, -1, "", methodObject), 
/*   60 */     new Among("veli", 20, -1, "", methodObject), 
/*   61 */     new Among("gli", 20, -1, "", methodObject), 
/*   62 */     new Among("mi", -1, -1, "", methodObject), 
/*   63 */     new Among("si", -1, -1, "", methodObject), 
/*   64 */     new Among("ti", -1, -1, "", methodObject), 
/*   65 */     new Among("vi", -1, -1, "", methodObject), 
/*   66 */     new Among("lo", -1, -1, "", methodObject), 
/*   67 */     new Among("celo", 31, -1, "", methodObject), 
/*   68 */     new Among("glielo", 31, -1, "", methodObject), 
/*   69 */     new Among("melo", 31, -1, "", methodObject), 
/*   70 */     new Among("telo", 31, -1, "", methodObject), 
/*   71 */     new Among("velo", 31, -1, "", methodObject) };
/*      */   
/*      */ 
/*   74 */   private static final Among[] a_3 = {
/*   75 */     new Among("ando", -1, 1, "", methodObject), 
/*   76 */     new Among("endo", -1, 1, "", methodObject), 
/*   77 */     new Among("ar", -1, 2, "", methodObject), 
/*   78 */     new Among("er", -1, 2, "", methodObject), 
/*   79 */     new Among("ir", -1, 2, "", methodObject) };
/*      */   
/*      */ 
/*   82 */   private static final Among[] a_4 = {
/*   83 */     new Among("ic", -1, -1, "", methodObject), 
/*   84 */     new Among("abil", -1, -1, "", methodObject), 
/*   85 */     new Among("os", -1, -1, "", methodObject), 
/*   86 */     new Among("iv", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*   89 */   private static final Among[] a_5 = {
/*   90 */     new Among("ic", -1, 1, "", methodObject), 
/*   91 */     new Among("abil", -1, 1, "", methodObject), 
/*   92 */     new Among("iv", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*   95 */   private static final Among[] a_6 = {
/*   96 */     new Among("ica", -1, 1, "", methodObject), 
/*   97 */     new Among("logia", -1, 3, "", methodObject), 
/*   98 */     new Among("osa", -1, 1, "", methodObject), 
/*   99 */     new Among("ista", -1, 1, "", methodObject), 
/*  100 */     new Among("iva", -1, 9, "", methodObject), 
/*  101 */     new Among("anza", -1, 1, "", methodObject), 
/*  102 */     new Among("enza", -1, 5, "", methodObject), 
/*  103 */     new Among("ice", -1, 1, "", methodObject), 
/*  104 */     new Among("atrice", 7, 1, "", methodObject), 
/*  105 */     new Among("iche", -1, 1, "", methodObject), 
/*  106 */     new Among("logie", -1, 3, "", methodObject), 
/*  107 */     new Among("abile", -1, 1, "", methodObject), 
/*  108 */     new Among("ibile", -1, 1, "", methodObject), 
/*  109 */     new Among("usione", -1, 4, "", methodObject), 
/*  110 */     new Among("azione", -1, 2, "", methodObject), 
/*  111 */     new Among("uzione", -1, 4, "", methodObject), 
/*  112 */     new Among("atore", -1, 2, "", methodObject), 
/*  113 */     new Among("ose", -1, 1, "", methodObject), 
/*  114 */     new Among("ante", -1, 1, "", methodObject), 
/*  115 */     new Among("mente", -1, 1, "", methodObject), 
/*  116 */     new Among("amente", 19, 7, "", methodObject), 
/*  117 */     new Among("iste", -1, 1, "", methodObject), 
/*  118 */     new Among("ive", -1, 9, "", methodObject), 
/*  119 */     new Among("anze", -1, 1, "", methodObject), 
/*  120 */     new Among("enze", -1, 5, "", methodObject), 
/*  121 */     new Among("ici", -1, 1, "", methodObject), 
/*  122 */     new Among("atrici", 25, 1, "", methodObject), 
/*  123 */     new Among("ichi", -1, 1, "", methodObject), 
/*  124 */     new Among("abili", -1, 1, "", methodObject), 
/*  125 */     new Among("ibili", -1, 1, "", methodObject), 
/*  126 */     new Among("ismi", -1, 1, "", methodObject), 
/*  127 */     new Among("usioni", -1, 4, "", methodObject), 
/*  128 */     new Among("azioni", -1, 2, "", methodObject), 
/*  129 */     new Among("uzioni", -1, 4, "", methodObject), 
/*  130 */     new Among("atori", -1, 2, "", methodObject), 
/*  131 */     new Among("osi", -1, 1, "", methodObject), 
/*  132 */     new Among("anti", -1, 1, "", methodObject), 
/*  133 */     new Among("amenti", -1, 6, "", methodObject), 
/*  134 */     new Among("imenti", -1, 6, "", methodObject), 
/*  135 */     new Among("isti", -1, 1, "", methodObject), 
/*  136 */     new Among("ivi", -1, 9, "", methodObject), 
/*  137 */     new Among("ico", -1, 1, "", methodObject), 
/*  138 */     new Among("ismo", -1, 1, "", methodObject), 
/*  139 */     new Among("oso", -1, 1, "", methodObject), 
/*  140 */     new Among("amento", -1, 6, "", methodObject), 
/*  141 */     new Among("imento", -1, 6, "", methodObject), 
/*  142 */     new Among("ivo", -1, 9, "", methodObject), 
/*  143 */     new Among("ità", -1, 8, "", methodObject), 
/*  144 */     new Among("istà", -1, 1, "", methodObject), 
/*  145 */     new Among("istè", -1, 1, "", methodObject), 
/*  146 */     new Among("istì", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*  149 */   private static final Among[] a_7 = {
/*  150 */     new Among("isca", -1, 1, "", methodObject), 
/*  151 */     new Among("enda", -1, 1, "", methodObject), 
/*  152 */     new Among("ata", -1, 1, "", methodObject), 
/*  153 */     new Among("ita", -1, 1, "", methodObject), 
/*  154 */     new Among("uta", -1, 1, "", methodObject), 
/*  155 */     new Among("ava", -1, 1, "", methodObject), 
/*  156 */     new Among("eva", -1, 1, "", methodObject), 
/*  157 */     new Among("iva", -1, 1, "", methodObject), 
/*  158 */     new Among("erebbe", -1, 1, "", methodObject), 
/*  159 */     new Among("irebbe", -1, 1, "", methodObject), 
/*  160 */     new Among("isce", -1, 1, "", methodObject), 
/*  161 */     new Among("ende", -1, 1, "", methodObject), 
/*  162 */     new Among("are", -1, 1, "", methodObject), 
/*  163 */     new Among("ere", -1, 1, "", methodObject), 
/*  164 */     new Among("ire", -1, 1, "", methodObject), 
/*  165 */     new Among("asse", -1, 1, "", methodObject), 
/*  166 */     new Among("ate", -1, 1, "", methodObject), 
/*  167 */     new Among("avate", 16, 1, "", methodObject), 
/*  168 */     new Among("evate", 16, 1, "", methodObject), 
/*  169 */     new Among("ivate", 16, 1, "", methodObject), 
/*  170 */     new Among("ete", -1, 1, "", methodObject), 
/*  171 */     new Among("erete", 20, 1, "", methodObject), 
/*  172 */     new Among("irete", 20, 1, "", methodObject), 
/*  173 */     new Among("ite", -1, 1, "", methodObject), 
/*  174 */     new Among("ereste", -1, 1, "", methodObject), 
/*  175 */     new Among("ireste", -1, 1, "", methodObject), 
/*  176 */     new Among("ute", -1, 1, "", methodObject), 
/*  177 */     new Among("erai", -1, 1, "", methodObject), 
/*  178 */     new Among("irai", -1, 1, "", methodObject), 
/*  179 */     new Among("isci", -1, 1, "", methodObject), 
/*  180 */     new Among("endi", -1, 1, "", methodObject), 
/*  181 */     new Among("erei", -1, 1, "", methodObject), 
/*  182 */     new Among("irei", -1, 1, "", methodObject), 
/*  183 */     new Among("assi", -1, 1, "", methodObject), 
/*  184 */     new Among("ati", -1, 1, "", methodObject), 
/*  185 */     new Among("iti", -1, 1, "", methodObject), 
/*  186 */     new Among("eresti", -1, 1, "", methodObject), 
/*  187 */     new Among("iresti", -1, 1, "", methodObject), 
/*  188 */     new Among("uti", -1, 1, "", methodObject), 
/*  189 */     new Among("avi", -1, 1, "", methodObject), 
/*  190 */     new Among("evi", -1, 1, "", methodObject), 
/*  191 */     new Among("ivi", -1, 1, "", methodObject), 
/*  192 */     new Among("isco", -1, 1, "", methodObject), 
/*  193 */     new Among("ando", -1, 1, "", methodObject), 
/*  194 */     new Among("endo", -1, 1, "", methodObject), 
/*  195 */     new Among("Yamo", -1, 1, "", methodObject), 
/*  196 */     new Among("iamo", -1, 1, "", methodObject), 
/*  197 */     new Among("avamo", -1, 1, "", methodObject), 
/*  198 */     new Among("evamo", -1, 1, "", methodObject), 
/*  199 */     new Among("ivamo", -1, 1, "", methodObject), 
/*  200 */     new Among("eremo", -1, 1, "", methodObject), 
/*  201 */     new Among("iremo", -1, 1, "", methodObject), 
/*  202 */     new Among("assimo", -1, 1, "", methodObject), 
/*  203 */     new Among("ammo", -1, 1, "", methodObject), 
/*  204 */     new Among("emmo", -1, 1, "", methodObject), 
/*  205 */     new Among("eremmo", 54, 1, "", methodObject), 
/*  206 */     new Among("iremmo", 54, 1, "", methodObject), 
/*  207 */     new Among("immo", -1, 1, "", methodObject), 
/*  208 */     new Among("ano", -1, 1, "", methodObject), 
/*  209 */     new Among("iscano", 58, 1, "", methodObject), 
/*  210 */     new Among("avano", 58, 1, "", methodObject), 
/*  211 */     new Among("evano", 58, 1, "", methodObject), 
/*  212 */     new Among("ivano", 58, 1, "", methodObject), 
/*  213 */     new Among("eranno", -1, 1, "", methodObject), 
/*  214 */     new Among("iranno", -1, 1, "", methodObject), 
/*  215 */     new Among("ono", -1, 1, "", methodObject), 
/*  216 */     new Among("iscono", 65, 1, "", methodObject), 
/*  217 */     new Among("arono", 65, 1, "", methodObject), 
/*  218 */     new Among("erono", 65, 1, "", methodObject), 
/*  219 */     new Among("irono", 65, 1, "", methodObject), 
/*  220 */     new Among("erebbero", -1, 1, "", methodObject), 
/*  221 */     new Among("irebbero", -1, 1, "", methodObject), 
/*  222 */     new Among("assero", -1, 1, "", methodObject), 
/*  223 */     new Among("essero", -1, 1, "", methodObject), 
/*  224 */     new Among("issero", -1, 1, "", methodObject), 
/*  225 */     new Among("ato", -1, 1, "", methodObject), 
/*  226 */     new Among("ito", -1, 1, "", methodObject), 
/*  227 */     new Among("uto", -1, 1, "", methodObject), 
/*  228 */     new Among("avo", -1, 1, "", methodObject), 
/*  229 */     new Among("evo", -1, 1, "", methodObject), 
/*  230 */     new Among("ivo", -1, 1, "", methodObject), 
/*  231 */     new Among("ar", -1, 1, "", methodObject), 
/*  232 */     new Among("ir", -1, 1, "", methodObject), 
/*  233 */     new Among("erà", -1, 1, "", methodObject), 
/*  234 */     new Among("irà", -1, 1, "", methodObject), 
/*  235 */     new Among("erò", -1, 1, "", methodObject), 
/*  236 */     new Among("irò", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*  239 */   private static final char[] g_v = { '\021', 'A', '\020', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '', '', '\b', '\002', '\001' };
/*      */   
/*  241 */   private static final char[] g_AEIO = { '\021', 'A', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '', '', '\b', '\002' };
/*      */   
/*  243 */   private static final char[] g_CG = { '\021' };
/*      */   private int I_p2;
/*      */   private int I_p1;
/*      */   private int I_pV;
/*      */   
/*      */   private void copy_from(italianStemmer other)
/*      */   {
/*  250 */     this.I_p2 = other.I_p2;
/*  251 */     this.I_p1 = other.I_p1;
/*  252 */     this.I_pV = other.I_pV;
/*  253 */     super.copy_from(other);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_prelude()
/*      */   {
/*  265 */     int v_1 = this.cursor;
/*      */     int v_2;
/*      */     for (;;)
/*      */     {
/*  269 */       v_2 = this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  273 */       this.bra = this.cursor;
/*      */       
/*  275 */       int among_var = find_among(a_0, 7);
/*  276 */       if (among_var == 0) {
/*      */         break;
/*      */       }
/*      */       
/*      */ 
/*  281 */       this.ket = this.cursor;
/*  282 */       switch (among_var)
/*      */       {
/*      */       case 0: 
/*      */         break;
/*      */       
/*      */       case 1: 
/*  288 */         slice_from("à");
/*  289 */         break;
/*      */       
/*      */ 
/*      */       case 2: 
/*  293 */         slice_from("è");
/*  294 */         break;
/*      */       
/*      */ 
/*      */       case 3: 
/*  298 */         slice_from("ì");
/*  299 */         break;
/*      */       
/*      */ 
/*      */       case 4: 
/*  303 */         slice_from("ò");
/*  304 */         break;
/*      */       
/*      */ 
/*      */       case 5: 
/*  308 */         slice_from("ù");
/*  309 */         break;
/*      */       
/*      */ 
/*      */       case 6: 
/*  313 */         slice_from("qU");
/*  314 */         break;
/*      */       
/*      */ 
/*      */       case 7: 
/*  318 */         if (this.cursor >= this.limit) {
/*      */           break label182;
/*      */         }
/*      */         
/*  322 */         this.cursor += 1;
/*      */       }
/*      */       
/*      */     }
/*      */     label182:
/*  327 */     this.cursor = v_2;
/*      */     
/*      */ 
/*  330 */     this.cursor = v_1;
/*      */     
/*      */ 
/*      */ 
/*  334 */     int v_3 = this.cursor;
/*      */     
/*      */ 
/*      */     for (;;)
/*      */     {
/*  339 */       int v_4 = this.cursor;
/*      */       
/*      */ 
/*  342 */       if (in_grouping(g_v, 97, 249))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  347 */         this.bra = this.cursor;
/*      */         
/*      */ 
/*  350 */         int v_5 = this.cursor;
/*      */         
/*      */ 
/*      */ 
/*  354 */         if (eq_s(1, "u"))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  359 */           this.ket = this.cursor;
/*  360 */           if (in_grouping(g_v, 97, 249))
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*  365 */             slice_from("U");
/*      */             break label337;
/*      */           } }
/*  368 */         this.cursor = v_5;
/*      */         
/*      */ 
/*  371 */         if (eq_s(1, "i"))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  376 */           this.ket = this.cursor;
/*  377 */           if (in_grouping(g_v, 97, 249))
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*  382 */             slice_from("I");
/*      */             label337:
/*  384 */             this.cursor = v_4;
/*  385 */             break;
/*      */           } } }
/*  387 */       this.cursor = v_4;
/*  388 */       if (this.cursor >= this.limit) {
/*      */         break label379;
/*      */       }
/*      */       
/*  392 */       this.cursor += 1;
/*      */     }
/*      */     label379:
/*      */     int v_4;
/*  396 */     this.cursor = v_3;
/*      */     
/*      */ 
/*  399 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_mark_regions()
/*      */   {
/*  409 */     this.I_pV = this.limit;
/*  410 */     this.I_p1 = this.limit;
/*  411 */     this.I_p2 = this.limit;
/*      */     
/*  413 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  418 */     int v_2 = this.cursor;
/*      */     
/*      */ 
/*  421 */     if (in_grouping(g_v, 97, 249))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  427 */       int v_3 = this.cursor;
/*      */       
/*      */ 
/*  430 */       if (out_grouping(g_v, 97, 249))
/*      */       {
/*      */ 
/*      */ 
/*      */         for (;;)
/*      */         {
/*      */ 
/*      */ 
/*  438 */           if (in_grouping(g_v, 97, 249)) {
/*      */             break label319;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*  444 */           if (this.cursor >= this.limit) {
/*      */             break;
/*      */           }
/*      */           
/*  448 */           this.cursor += 1;
/*      */         }
/*      */       }
/*      */       
/*  452 */       this.cursor = v_3;
/*      */       
/*  454 */       if (in_grouping(g_v, 97, 249))
/*      */       {
/*      */ 
/*      */ 
/*      */         for (;;)
/*      */         {
/*      */ 
/*      */ 
/*  462 */           if (out_grouping(g_v, 97, 249)) {
/*      */             break label319;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*  468 */           if (this.cursor >= this.limit) {
/*      */             break;
/*      */           }
/*      */           
/*  472 */           this.cursor += 1;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  477 */     this.cursor = v_2;
/*      */     
/*  479 */     if (out_grouping(g_v, 97, 249))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  485 */       int v_6 = this.cursor;
/*      */       
/*      */ 
/*  488 */       if (out_grouping(g_v, 97, 249))
/*      */       {
/*      */ 
/*      */ 
/*      */         for (;;)
/*      */         {
/*      */ 
/*      */ 
/*  496 */           if (in_grouping(g_v, 97, 249)) {
/*      */             break label319;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*  502 */           if (this.cursor >= this.limit) {
/*      */             break;
/*      */           }
/*      */           
/*  506 */           this.cursor += 1;
/*      */         }
/*      */       }
/*      */       
/*  510 */       this.cursor = v_6;
/*      */       
/*  512 */       if (in_grouping(g_v, 97, 249))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  517 */         if (this.cursor < this.limit)
/*      */         {
/*      */ 
/*      */ 
/*  521 */           this.cursor += 1;
/*      */           
/*      */           label319:
/*      */           
/*  525 */           this.I_pV = this.cursor;
/*      */         } } }
/*  527 */     this.cursor = v_1;
/*      */     
/*  529 */     int v_8 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  536 */     while (!in_grouping(g_v, 97, 249))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  542 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  546 */       this.cursor += 1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  552 */     while (!out_grouping(g_v, 97, 249))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  558 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  562 */       this.cursor += 1;
/*      */     }
/*      */     
/*  565 */     this.I_p1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  570 */     while (!in_grouping(g_v, 97, 249))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  576 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  580 */       this.cursor += 1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  586 */     while (!out_grouping(g_v, 97, 249))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  592 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  596 */       this.cursor += 1;
/*      */     }
/*      */     
/*  599 */     this.I_p2 = this.cursor;
/*      */     label522:
/*  601 */     this.cursor = v_8;
/*  602 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_postlude()
/*      */   {
/*      */     int v_1;
/*      */     for (;;)
/*      */     {
/*  611 */       v_1 = this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  615 */       this.bra = this.cursor;
/*      */       
/*  617 */       int among_var = find_among(a_1, 3);
/*  618 */       if (among_var == 0) {
/*      */         break;
/*      */       }
/*      */       
/*      */ 
/*  623 */       this.ket = this.cursor;
/*  624 */       switch (among_var)
/*      */       {
/*      */       case 0: 
/*      */         break;
/*      */       
/*      */       case 1: 
/*  630 */         slice_from("i");
/*  631 */         break;
/*      */       
/*      */ 
/*      */       case 2: 
/*  635 */         slice_from("u");
/*  636 */         break;
/*      */       
/*      */ 
/*      */       case 3: 
/*  640 */         if (this.cursor >= this.limit) {
/*      */           break label118;
/*      */         }
/*      */         
/*  644 */         this.cursor += 1;
/*      */       }
/*      */       
/*      */     }
/*      */     label118:
/*  649 */     this.cursor = v_1;
/*      */     
/*      */ 
/*  652 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_RV() {
/*  656 */     if (this.I_pV > this.cursor)
/*      */     {
/*  658 */       return false;
/*      */     }
/*  660 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_R1() {
/*  664 */     if (this.I_p1 > this.cursor)
/*      */     {
/*  666 */       return false;
/*      */     }
/*  668 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_R2() {
/*  672 */     if (this.I_p2 > this.cursor)
/*      */     {
/*  674 */       return false;
/*      */     }
/*  676 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_attached_pronoun()
/*      */   {
/*  683 */     this.ket = this.cursor;
/*      */     
/*  685 */     if (find_among_b(a_2, 37) == 0)
/*      */     {
/*  687 */       return false;
/*      */     }
/*      */     
/*  690 */     this.bra = this.cursor;
/*      */     
/*  692 */     int among_var = find_among_b(a_3, 5);
/*  693 */     if (among_var == 0)
/*      */     {
/*  695 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  699 */     if (!r_RV())
/*      */     {
/*  701 */       return false;
/*      */     }
/*  703 */     switch (among_var) {
/*      */     case 0: 
/*  705 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  709 */       slice_del();
/*  710 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  714 */       slice_from("e");
/*      */     }
/*      */     
/*  717 */     return true;
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
/*  728 */     this.ket = this.cursor;
/*      */     
/*  730 */     int among_var = find_among_b(a_6, 51);
/*  731 */     if (among_var == 0)
/*      */     {
/*  733 */       return false;
/*      */     }
/*      */     
/*  736 */     this.bra = this.cursor;
/*  737 */     switch (among_var) {
/*      */     case 0: 
/*  739 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  743 */       if (!r_R2())
/*      */       {
/*  745 */         return false;
/*      */       }
/*      */       
/*  748 */       slice_del();
/*  749 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  753 */       if (!r_R2())
/*      */       {
/*  755 */         return false;
/*      */       }
/*      */       
/*  758 */       slice_del();
/*      */       
/*  760 */       int v_1 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  764 */       this.ket = this.cursor;
/*      */       
/*  766 */       if (!eq_s_b(2, "ic"))
/*      */       {
/*  768 */         this.cursor = (this.limit - v_1);
/*      */       }
/*      */       else
/*      */       {
/*  772 */         this.bra = this.cursor;
/*      */         
/*  774 */         if (!r_R2())
/*      */         {
/*  776 */           this.cursor = (this.limit - v_1);
/*      */         }
/*      */         else
/*      */         {
/*  780 */           slice_del(); }
/*      */       }
/*  782 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  786 */       if (!r_R2())
/*      */       {
/*  788 */         return false;
/*      */       }
/*      */       
/*  791 */       slice_from("log");
/*  792 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  796 */       if (!r_R2())
/*      */       {
/*  798 */         return false;
/*      */       }
/*      */       
/*  801 */       slice_from("u");
/*  802 */       break;
/*      */     
/*      */ 
/*      */     case 5: 
/*  806 */       if (!r_R2())
/*      */       {
/*  808 */         return false;
/*      */       }
/*      */       
/*  811 */       slice_from("ente");
/*  812 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/*  816 */       if (!r_RV())
/*      */       {
/*  818 */         return false;
/*      */       }
/*      */       
/*  821 */       slice_del();
/*  822 */       break;
/*      */     
/*      */ 
/*      */     case 7: 
/*  826 */       if (!r_R1())
/*      */       {
/*  828 */         return false;
/*      */       }
/*      */       
/*  831 */       slice_del();
/*      */       
/*  833 */       int v_2 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  837 */       this.ket = this.cursor;
/*      */       
/*  839 */       among_var = find_among_b(a_4, 4);
/*  840 */       if (among_var == 0)
/*      */       {
/*  842 */         this.cursor = (this.limit - v_2);
/*      */       }
/*      */       else
/*      */       {
/*  846 */         this.bra = this.cursor;
/*      */         
/*  848 */         if (!r_R2())
/*      */         {
/*  850 */           this.cursor = (this.limit - v_2);
/*      */         }
/*      */         else
/*      */         {
/*  854 */           slice_del();
/*  855 */           switch (among_var) {
/*      */           case 0: 
/*  857 */             this.cursor = (this.limit - v_2);
/*  858 */             break;
/*      */           
/*      */ 
/*      */           case 1: 
/*  862 */             this.ket = this.cursor;
/*      */             
/*  864 */             if (!eq_s_b(2, "at"))
/*      */             {
/*  866 */               this.cursor = (this.limit - v_2);
/*      */             }
/*      */             else
/*      */             {
/*  870 */               this.bra = this.cursor;
/*      */               
/*  872 */               if (!r_R2())
/*      */               {
/*  874 */                 this.cursor = (this.limit - v_2);
/*      */               }
/*      */               else
/*      */               {
/*  878 */                 slice_del(); }
/*      */             }
/*      */             break; }
/*      */         } }
/*  882 */       break;
/*      */     
/*      */ 
/*      */     case 8: 
/*  886 */       if (!r_R2())
/*      */       {
/*  888 */         return false;
/*      */       }
/*      */       
/*  891 */       slice_del();
/*      */       
/*  893 */       int v_3 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  897 */       this.ket = this.cursor;
/*      */       
/*  899 */       among_var = find_among_b(a_5, 3);
/*  900 */       if (among_var == 0)
/*      */       {
/*  902 */         this.cursor = (this.limit - v_3);
/*      */       }
/*      */       else
/*      */       {
/*  906 */         this.bra = this.cursor;
/*  907 */         switch (among_var) {
/*      */         case 0: 
/*  909 */           this.cursor = (this.limit - v_3);
/*  910 */           break;
/*      */         
/*      */ 
/*      */         case 1: 
/*  914 */           if (!r_R2())
/*      */           {
/*  916 */             this.cursor = (this.limit - v_3);
/*      */           }
/*      */           else
/*      */           {
/*  920 */             slice_del(); }
/*      */           break;
/*      */         }
/*      */       }
/*  924 */       break;
/*      */     
/*      */ 
/*      */     case 9: 
/*  928 */       if (!r_R2())
/*      */       {
/*  930 */         return false;
/*      */       }
/*      */       
/*  933 */       slice_del();
/*      */       
/*  935 */       int v_4 = this.limit - this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  939 */       this.ket = this.cursor;
/*      */       
/*  941 */       if (!eq_s_b(2, "at"))
/*      */       {
/*  943 */         this.cursor = (this.limit - v_4);
/*      */       }
/*      */       else
/*      */       {
/*  947 */         this.bra = this.cursor;
/*      */         
/*  949 */         if (!r_R2())
/*      */         {
/*  951 */           this.cursor = (this.limit - v_4);
/*      */         }
/*      */         else
/*      */         {
/*  955 */           slice_del();
/*      */           
/*  957 */           this.ket = this.cursor;
/*      */           
/*  959 */           if (!eq_s_b(2, "ic"))
/*      */           {
/*  961 */             this.cursor = (this.limit - v_4);
/*      */           }
/*      */           else
/*      */           {
/*  965 */             this.bra = this.cursor;
/*      */             
/*  967 */             if (!r_R2())
/*      */             {
/*  969 */               this.cursor = (this.limit - v_4);
/*      */             }
/*      */             else
/*      */             {
/*  973 */               slice_del(); }
/*      */           }
/*      */         } }
/*      */       break; }
/*  977 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_verb_suffix()
/*      */   {
/*  985 */     int v_1 = this.limit - this.cursor;
/*      */     
/*  987 */     if (this.cursor < this.I_pV)
/*      */     {
/*  989 */       return false;
/*      */     }
/*  991 */     this.cursor = this.I_pV;
/*  992 */     int v_2 = this.limit_backward;
/*  993 */     this.limit_backward = this.cursor;
/*  994 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*  997 */     this.ket = this.cursor;
/*      */     
/*  999 */     int among_var = find_among_b(a_7, 87);
/* 1000 */     if (among_var == 0)
/*      */     {
/* 1002 */       this.limit_backward = v_2;
/* 1003 */       return false;
/*      */     }
/*      */     
/* 1006 */     this.bra = this.cursor;
/* 1007 */     switch (among_var) {
/*      */     case 0: 
/* 1009 */       this.limit_backward = v_2;
/* 1010 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/* 1014 */       slice_del();
/*      */     }
/*      */     
/* 1017 */     this.limit_backward = v_2;
/* 1018 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_vowel_suffix()
/*      */   {
/* 1026 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 1030 */     this.ket = this.cursor;
/* 1031 */     if (!in_grouping_b(g_AEIO, 97, 242))
/*      */     {
/* 1033 */       this.cursor = (this.limit - v_1);
/*      */     }
/*      */     else
/*      */     {
/* 1037 */       this.bra = this.cursor;
/*      */       
/* 1039 */       if (!r_RV())
/*      */       {
/* 1041 */         this.cursor = (this.limit - v_1);
/*      */       }
/*      */       else
/*      */       {
/* 1045 */         slice_del();
/*      */         
/* 1047 */         this.ket = this.cursor;
/*      */         
/* 1049 */         if (!eq_s_b(1, "i"))
/*      */         {
/* 1051 */           this.cursor = (this.limit - v_1);
/*      */         }
/*      */         else
/*      */         {
/* 1055 */           this.bra = this.cursor;
/*      */           
/* 1057 */           if (!r_RV())
/*      */           {
/* 1059 */             this.cursor = (this.limit - v_1);
/*      */           }
/*      */           else
/*      */           {
/* 1063 */             slice_del(); }
/*      */         }
/*      */       } }
/* 1066 */     int v_2 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/* 1070 */     this.ket = this.cursor;
/*      */     
/* 1072 */     if (!eq_s_b(1, "h"))
/*      */     {
/* 1074 */       this.cursor = (this.limit - v_2);
/*      */     }
/*      */     else
/*      */     {
/* 1078 */       this.bra = this.cursor;
/* 1079 */       if (!in_grouping_b(g_CG, 99, 103))
/*      */       {
/* 1081 */         this.cursor = (this.limit - v_2);
/*      */ 
/*      */ 
/*      */       }
/* 1085 */       else if (!r_RV())
/*      */       {
/* 1087 */         this.cursor = (this.limit - v_2);
/*      */       }
/*      */       else
/*      */       {
/* 1091 */         slice_del(); }
/*      */     }
/* 1093 */     return true;
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
/*      */   public boolean stem()
/*      */   {
/* 1106 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/* 1109 */     if (!r_prelude()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1114 */     this.cursor = v_1;
/*      */     
/* 1116 */     int v_2 = this.cursor;
/*      */     
/*      */ 
/* 1119 */     if (!r_mark_regions()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1124 */     this.cursor = v_2;
/*      */     
/* 1126 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*      */     
/*      */ 
/* 1129 */     int v_3 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1132 */     if (!r_attached_pronoun()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1137 */     this.cursor = (this.limit - v_3);
/*      */     
/* 1139 */     int v_4 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1144 */     int v_5 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1147 */     if (!r_standard_suffix())
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1153 */       this.cursor = (this.limit - v_5);
/*      */       
/* 1155 */       if (r_verb_suffix()) {}
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1161 */     this.cursor = (this.limit - v_4);
/*      */     
/* 1163 */     int v_6 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1166 */     if (!r_vowel_suffix()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1171 */     this.cursor = (this.limit - v_6);
/* 1172 */     this.cursor = this.limit_backward;
/* 1173 */     int v_7 = this.cursor;
/*      */     
/*      */ 
/* 1176 */     if (!r_postlude()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1181 */     this.cursor = v_7;
/* 1182 */     return true;
/*      */   }
/*      */   
/*      */   public boolean equals(Object o) {
/* 1186 */     return o instanceof italianStemmer;
/*      */   }
/*      */   
/*      */   public int hashCode() {
/* 1190 */     return italianStemmer.class.getName().hashCode();
/*      */   }
/*      */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\italianStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */