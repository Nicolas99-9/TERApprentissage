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
/*      */ public class romanianStemmer
/*      */   extends SnowballStemmer
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*   16 */   private static final romanianStemmer methodObject = new romanianStemmer();
/*      */   
/*   18 */   private static final Among[] a_0 = {
/*   19 */     new Among("", -1, 3, "", methodObject), 
/*   20 */     new Among("I", 0, 1, "", methodObject), 
/*   21 */     new Among("U", 0, 2, "", methodObject) };
/*      */   
/*      */ 
/*   24 */   private static final Among[] a_1 = {
/*   25 */     new Among("ea", -1, 3, "", methodObject), 
/*   26 */     new Among("aţia", -1, 7, "", methodObject), 
/*   27 */     new Among("aua", -1, 2, "", methodObject), 
/*   28 */     new Among("iua", -1, 4, "", methodObject), 
/*   29 */     new Among("aţie", -1, 7, "", methodObject), 
/*   30 */     new Among("ele", -1, 3, "", methodObject), 
/*   31 */     new Among("ile", -1, 5, "", methodObject), 
/*   32 */     new Among("iile", 6, 4, "", methodObject), 
/*   33 */     new Among("iei", -1, 4, "", methodObject), 
/*   34 */     new Among("atei", -1, 6, "", methodObject), 
/*   35 */     new Among("ii", -1, 4, "", methodObject), 
/*   36 */     new Among("ului", -1, 1, "", methodObject), 
/*   37 */     new Among("ul", -1, 1, "", methodObject), 
/*   38 */     new Among("elor", -1, 3, "", methodObject), 
/*   39 */     new Among("ilor", -1, 4, "", methodObject), 
/*   40 */     new Among("iilor", 14, 4, "", methodObject) };
/*      */   
/*      */ 
/*   43 */   private static final Among[] a_2 = {
/*   44 */     new Among("icala", -1, 4, "", methodObject), 
/*   45 */     new Among("iciva", -1, 4, "", methodObject), 
/*   46 */     new Among("ativa", -1, 5, "", methodObject), 
/*   47 */     new Among("itiva", -1, 6, "", methodObject), 
/*   48 */     new Among("icale", -1, 4, "", methodObject), 
/*   49 */     new Among("aţiune", -1, 5, "", methodObject), 
/*   50 */     new Among("iţiune", -1, 6, "", methodObject), 
/*   51 */     new Among("atoare", -1, 5, "", methodObject), 
/*   52 */     new Among("itoare", -1, 6, "", methodObject), 
/*   53 */     new Among("ătoare", -1, 5, "", methodObject), 
/*   54 */     new Among("icitate", -1, 4, "", methodObject), 
/*   55 */     new Among("abilitate", -1, 1, "", methodObject), 
/*   56 */     new Among("ibilitate", -1, 2, "", methodObject), 
/*   57 */     new Among("ivitate", -1, 3, "", methodObject), 
/*   58 */     new Among("icive", -1, 4, "", methodObject), 
/*   59 */     new Among("ative", -1, 5, "", methodObject), 
/*   60 */     new Among("itive", -1, 6, "", methodObject), 
/*   61 */     new Among("icali", -1, 4, "", methodObject), 
/*   62 */     new Among("atori", -1, 5, "", methodObject), 
/*   63 */     new Among("icatori", 18, 4, "", methodObject), 
/*   64 */     new Among("itori", -1, 6, "", methodObject), 
/*   65 */     new Among("ători", -1, 5, "", methodObject), 
/*   66 */     new Among("icitati", -1, 4, "", methodObject), 
/*   67 */     new Among("abilitati", -1, 1, "", methodObject), 
/*   68 */     new Among("ivitati", -1, 3, "", methodObject), 
/*   69 */     new Among("icivi", -1, 4, "", methodObject), 
/*   70 */     new Among("ativi", -1, 5, "", methodObject), 
/*   71 */     new Among("itivi", -1, 6, "", methodObject), 
/*   72 */     new Among("icităi", -1, 4, "", methodObject), 
/*   73 */     new Among("abilităi", -1, 1, "", methodObject), 
/*   74 */     new Among("ivităi", -1, 3, "", methodObject), 
/*   75 */     new Among("icităţi", -1, 4, "", methodObject), 
/*   76 */     new Among("abilităţi", -1, 1, "", methodObject), 
/*   77 */     new Among("ivităţi", -1, 3, "", methodObject), 
/*   78 */     new Among("ical", -1, 4, "", methodObject), 
/*   79 */     new Among("ator", -1, 5, "", methodObject), 
/*   80 */     new Among("icator", 35, 4, "", methodObject), 
/*   81 */     new Among("itor", -1, 6, "", methodObject), 
/*   82 */     new Among("ător", -1, 5, "", methodObject), 
/*   83 */     new Among("iciv", -1, 4, "", methodObject), 
/*   84 */     new Among("ativ", -1, 5, "", methodObject), 
/*   85 */     new Among("itiv", -1, 6, "", methodObject), 
/*   86 */     new Among("icală", -1, 4, "", methodObject), 
/*   87 */     new Among("icivă", -1, 4, "", methodObject), 
/*   88 */     new Among("ativă", -1, 5, "", methodObject), 
/*   89 */     new Among("itivă", -1, 6, "", methodObject) };
/*      */   
/*      */ 
/*   92 */   private static final Among[] a_3 = {
/*   93 */     new Among("ica", -1, 1, "", methodObject), 
/*   94 */     new Among("abila", -1, 1, "", methodObject), 
/*   95 */     new Among("ibila", -1, 1, "", methodObject), 
/*   96 */     new Among("oasa", -1, 1, "", methodObject), 
/*   97 */     new Among("ata", -1, 1, "", methodObject), 
/*   98 */     new Among("ita", -1, 1, "", methodObject), 
/*   99 */     new Among("anta", -1, 1, "", methodObject), 
/*  100 */     new Among("ista", -1, 3, "", methodObject), 
/*  101 */     new Among("uta", -1, 1, "", methodObject), 
/*  102 */     new Among("iva", -1, 1, "", methodObject), 
/*  103 */     new Among("ic", -1, 1, "", methodObject), 
/*  104 */     new Among("ice", -1, 1, "", methodObject), 
/*  105 */     new Among("abile", -1, 1, "", methodObject), 
/*  106 */     new Among("ibile", -1, 1, "", methodObject), 
/*  107 */     new Among("isme", -1, 3, "", methodObject), 
/*  108 */     new Among("iune", -1, 2, "", methodObject), 
/*  109 */     new Among("oase", -1, 1, "", methodObject), 
/*  110 */     new Among("ate", -1, 1, "", methodObject), 
/*  111 */     new Among("itate", 17, 1, "", methodObject), 
/*  112 */     new Among("ite", -1, 1, "", methodObject), 
/*  113 */     new Among("ante", -1, 1, "", methodObject), 
/*  114 */     new Among("iste", -1, 3, "", methodObject), 
/*  115 */     new Among("ute", -1, 1, "", methodObject), 
/*  116 */     new Among("ive", -1, 1, "", methodObject), 
/*  117 */     new Among("ici", -1, 1, "", methodObject), 
/*  118 */     new Among("abili", -1, 1, "", methodObject), 
/*  119 */     new Among("ibili", -1, 1, "", methodObject), 
/*  120 */     new Among("iuni", -1, 2, "", methodObject), 
/*  121 */     new Among("atori", -1, 1, "", methodObject), 
/*  122 */     new Among("osi", -1, 1, "", methodObject), 
/*  123 */     new Among("ati", -1, 1, "", methodObject), 
/*  124 */     new Among("itati", 30, 1, "", methodObject), 
/*  125 */     new Among("iti", -1, 1, "", methodObject), 
/*  126 */     new Among("anti", -1, 1, "", methodObject), 
/*  127 */     new Among("isti", -1, 3, "", methodObject), 
/*  128 */     new Among("uti", -1, 1, "", methodObject), 
/*  129 */     new Among("işti", -1, 3, "", methodObject), 
/*  130 */     new Among("ivi", -1, 1, "", methodObject), 
/*  131 */     new Among("ităi", -1, 1, "", methodObject), 
/*  132 */     new Among("oşi", -1, 1, "", methodObject), 
/*  133 */     new Among("ităţi", -1, 1, "", methodObject), 
/*  134 */     new Among("abil", -1, 1, "", methodObject), 
/*  135 */     new Among("ibil", -1, 1, "", methodObject), 
/*  136 */     new Among("ism", -1, 3, "", methodObject), 
/*  137 */     new Among("ator", -1, 1, "", methodObject), 
/*  138 */     new Among("os", -1, 1, "", methodObject), 
/*  139 */     new Among("at", -1, 1, "", methodObject), 
/*  140 */     new Among("it", -1, 1, "", methodObject), 
/*  141 */     new Among("ant", -1, 1, "", methodObject), 
/*  142 */     new Among("ist", -1, 3, "", methodObject), 
/*  143 */     new Among("ut", -1, 1, "", methodObject), 
/*  144 */     new Among("iv", -1, 1, "", methodObject), 
/*  145 */     new Among("ică", -1, 1, "", methodObject), 
/*  146 */     new Among("abilă", -1, 1, "", methodObject), 
/*  147 */     new Among("ibilă", -1, 1, "", methodObject), 
/*  148 */     new Among("oasă", -1, 1, "", methodObject), 
/*  149 */     new Among("ată", -1, 1, "", methodObject), 
/*  150 */     new Among("ită", -1, 1, "", methodObject), 
/*  151 */     new Among("antă", -1, 1, "", methodObject), 
/*  152 */     new Among("istă", -1, 3, "", methodObject), 
/*  153 */     new Among("ută", -1, 1, "", methodObject), 
/*  154 */     new Among("ivă", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*  157 */   private static final Among[] a_4 = {
/*  158 */     new Among("ea", -1, 1, "", methodObject), 
/*  159 */     new Among("ia", -1, 1, "", methodObject), 
/*  160 */     new Among("esc", -1, 1, "", methodObject), 
/*  161 */     new Among("ăsc", -1, 1, "", methodObject), 
/*  162 */     new Among("ind", -1, 1, "", methodObject), 
/*  163 */     new Among("ând", -1, 1, "", methodObject), 
/*  164 */     new Among("are", -1, 1, "", methodObject), 
/*  165 */     new Among("ere", -1, 1, "", methodObject), 
/*  166 */     new Among("ire", -1, 1, "", methodObject), 
/*  167 */     new Among("âre", -1, 1, "", methodObject), 
/*  168 */     new Among("se", -1, 2, "", methodObject), 
/*  169 */     new Among("ase", 10, 1, "", methodObject), 
/*  170 */     new Among("sese", 10, 2, "", methodObject), 
/*  171 */     new Among("ise", 10, 1, "", methodObject), 
/*  172 */     new Among("use", 10, 1, "", methodObject), 
/*  173 */     new Among("âse", 10, 1, "", methodObject), 
/*  174 */     new Among("eşte", -1, 1, "", methodObject), 
/*  175 */     new Among("ăşte", -1, 1, "", methodObject), 
/*  176 */     new Among("eze", -1, 1, "", methodObject), 
/*  177 */     new Among("ai", -1, 1, "", methodObject), 
/*  178 */     new Among("eai", 19, 1, "", methodObject), 
/*  179 */     new Among("iai", 19, 1, "", methodObject), 
/*  180 */     new Among("sei", -1, 2, "", methodObject), 
/*  181 */     new Among("eşti", -1, 1, "", methodObject), 
/*  182 */     new Among("ăşti", -1, 1, "", methodObject), 
/*  183 */     new Among("ui", -1, 1, "", methodObject), 
/*  184 */     new Among("ezi", -1, 1, "", methodObject), 
/*  185 */     new Among("âi", -1, 1, "", methodObject), 
/*  186 */     new Among("aşi", -1, 1, "", methodObject), 
/*  187 */     new Among("seşi", -1, 2, "", methodObject), 
/*  188 */     new Among("aseşi", 29, 1, "", methodObject), 
/*  189 */     new Among("seseşi", 29, 2, "", methodObject), 
/*  190 */     new Among("iseşi", 29, 1, "", methodObject), 
/*  191 */     new Among("useşi", 29, 1, "", methodObject), 
/*  192 */     new Among("âseşi", 29, 1, "", methodObject), 
/*  193 */     new Among("işi", -1, 1, "", methodObject), 
/*  194 */     new Among("uşi", -1, 1, "", methodObject), 
/*  195 */     new Among("âşi", -1, 1, "", methodObject), 
/*  196 */     new Among("aţi", -1, 2, "", methodObject), 
/*  197 */     new Among("eaţi", 38, 1, "", methodObject), 
/*  198 */     new Among("iaţi", 38, 1, "", methodObject), 
/*  199 */     new Among("eţi", -1, 2, "", methodObject), 
/*  200 */     new Among("iţi", -1, 2, "", methodObject), 
/*  201 */     new Among("âţi", -1, 2, "", methodObject), 
/*  202 */     new Among("arăţi", -1, 1, "", methodObject), 
/*  203 */     new Among("serăţi", -1, 2, "", methodObject), 
/*  204 */     new Among("aserăţi", 45, 1, "", methodObject), 
/*  205 */     new Among("seserăţi", 45, 2, "", methodObject), 
/*  206 */     new Among("iserăţi", 45, 1, "", methodObject), 
/*  207 */     new Among("userăţi", 45, 1, "", methodObject), 
/*  208 */     new Among("âserăţi", 45, 1, "", methodObject), 
/*  209 */     new Among("irăţi", -1, 1, "", methodObject), 
/*  210 */     new Among("urăţi", -1, 1, "", methodObject), 
/*  211 */     new Among("ârăţi", -1, 1, "", methodObject), 
/*  212 */     new Among("am", -1, 1, "", methodObject), 
/*  213 */     new Among("eam", 54, 1, "", methodObject), 
/*  214 */     new Among("iam", 54, 1, "", methodObject), 
/*  215 */     new Among("em", -1, 2, "", methodObject), 
/*  216 */     new Among("asem", 57, 1, "", methodObject), 
/*  217 */     new Among("sesem", 57, 2, "", methodObject), 
/*  218 */     new Among("isem", 57, 1, "", methodObject), 
/*  219 */     new Among("usem", 57, 1, "", methodObject), 
/*  220 */     new Among("âsem", 57, 1, "", methodObject), 
/*  221 */     new Among("im", -1, 2, "", methodObject), 
/*  222 */     new Among("âm", -1, 2, "", methodObject), 
/*  223 */     new Among("ăm", -1, 2, "", methodObject), 
/*  224 */     new Among("arăm", 65, 1, "", methodObject), 
/*  225 */     new Among("serăm", 65, 2, "", methodObject), 
/*  226 */     new Among("aserăm", 67, 1, "", methodObject), 
/*  227 */     new Among("seserăm", 67, 2, "", methodObject), 
/*  228 */     new Among("iserăm", 67, 1, "", methodObject), 
/*  229 */     new Among("userăm", 67, 1, "", methodObject), 
/*  230 */     new Among("âserăm", 67, 1, "", methodObject), 
/*  231 */     new Among("irăm", 65, 1, "", methodObject), 
/*  232 */     new Among("urăm", 65, 1, "", methodObject), 
/*  233 */     new Among("ârăm", 65, 1, "", methodObject), 
/*  234 */     new Among("au", -1, 1, "", methodObject), 
/*  235 */     new Among("eau", 76, 1, "", methodObject), 
/*  236 */     new Among("iau", 76, 1, "", methodObject), 
/*  237 */     new Among("indu", -1, 1, "", methodObject), 
/*  238 */     new Among("ându", -1, 1, "", methodObject), 
/*  239 */     new Among("ez", -1, 1, "", methodObject), 
/*  240 */     new Among("ească", -1, 1, "", methodObject), 
/*  241 */     new Among("ară", -1, 1, "", methodObject), 
/*  242 */     new Among("seră", -1, 2, "", methodObject), 
/*  243 */     new Among("aseră", 84, 1, "", methodObject), 
/*  244 */     new Among("seseră", 84, 2, "", methodObject), 
/*  245 */     new Among("iseră", 84, 1, "", methodObject), 
/*  246 */     new Among("useră", 84, 1, "", methodObject), 
/*  247 */     new Among("âseră", 84, 1, "", methodObject), 
/*  248 */     new Among("iră", -1, 1, "", methodObject), 
/*  249 */     new Among("ură", -1, 1, "", methodObject), 
/*  250 */     new Among("âră", -1, 1, "", methodObject), 
/*  251 */     new Among("ează", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*  254 */   private static final Among[] a_5 = {
/*  255 */     new Among("a", -1, 1, "", methodObject), 
/*  256 */     new Among("e", -1, 1, "", methodObject), 
/*  257 */     new Among("ie", 1, 1, "", methodObject), 
/*  258 */     new Among("i", -1, 1, "", methodObject), 
/*  259 */     new Among("ă", -1, 1, "", methodObject) };
/*      */   
/*      */ 
/*  262 */   private static final char[] g_v = { '\021', 'A', '\020', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\000', '\002', ' ', '\000''\000''\004' };
/*      */   private boolean B_standard_suffix_removed;
/*      */   private int I_p2;
/*      */   private int I_p1;
/*      */   private int I_pV;
/*      */   
/*      */   private void copy_from(romanianStemmer other)
/*      */   {
/*  270 */     this.B_standard_suffix_removed = other.B_standard_suffix_removed;
/*  271 */     this.I_p2 = other.I_p2;
/*  272 */     this.I_p1 = other.I_p1;
/*  273 */     this.I_pV = other.I_pV;
/*  274 */     super.copy_from(other);
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
/*  285 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/*      */     for (;;)
/*      */     {
/*  290 */       int v_2 = this.cursor;
/*      */       
/*      */ 
/*  293 */       if (in_grouping(g_v, 97, 259))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  298 */         this.bra = this.cursor;
/*      */         
/*      */ 
/*  301 */         int v_3 = this.cursor;
/*      */         
/*      */ 
/*      */ 
/*  305 */         if (eq_s(1, "u"))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  310 */           this.ket = this.cursor;
/*  311 */           if (in_grouping(g_v, 97, 259))
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*  316 */             slice_from("U");
/*      */             break label141;
/*      */           } }
/*  319 */         this.cursor = v_3;
/*      */         
/*      */ 
/*  322 */         if (eq_s(1, "i"))
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  327 */           this.ket = this.cursor;
/*  328 */           if (in_grouping(g_v, 97, 259))
/*      */           {
/*      */ 
/*      */ 
/*      */ 
/*  333 */             slice_from("I");
/*      */             label141:
/*  335 */             this.cursor = v_2;
/*  336 */             break;
/*      */           } } }
/*  338 */       this.cursor = v_2;
/*  339 */       if (this.cursor >= this.limit) {
/*      */         break label181;
/*      */       }
/*      */       
/*  343 */       this.cursor += 1;
/*      */     }
/*      */     label181:
/*      */     int v_2;
/*  347 */     this.cursor = v_1;
/*      */     
/*      */ 
/*  350 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_mark_regions()
/*      */   {
/*  360 */     this.I_pV = this.limit;
/*  361 */     this.I_p1 = this.limit;
/*  362 */     this.I_p2 = this.limit;
/*      */     
/*  364 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  369 */     int v_2 = this.cursor;
/*      */     
/*      */ 
/*  372 */     if (in_grouping(g_v, 97, 259))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  378 */       int v_3 = this.cursor;
/*      */       
/*      */ 
/*  381 */       if (out_grouping(g_v, 97, 259))
/*      */       {
/*      */ 
/*      */ 
/*      */         for (;;)
/*      */         {
/*      */ 
/*      */ 
/*  389 */           if (in_grouping(g_v, 97, 259)) {
/*      */             break label319;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*  395 */           if (this.cursor >= this.limit) {
/*      */             break;
/*      */           }
/*      */           
/*  399 */           this.cursor += 1;
/*      */         }
/*      */       }
/*      */       
/*  403 */       this.cursor = v_3;
/*      */       
/*  405 */       if (in_grouping(g_v, 97, 259))
/*      */       {
/*      */ 
/*      */ 
/*      */         for (;;)
/*      */         {
/*      */ 
/*      */ 
/*  413 */           if (out_grouping(g_v, 97, 259)) {
/*      */             break label319;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*  419 */           if (this.cursor >= this.limit) {
/*      */             break;
/*      */           }
/*      */           
/*  423 */           this.cursor += 1;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  428 */     this.cursor = v_2;
/*      */     
/*  430 */     if (out_grouping(g_v, 97, 259))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  436 */       int v_6 = this.cursor;
/*      */       
/*      */ 
/*  439 */       if (out_grouping(g_v, 97, 259))
/*      */       {
/*      */ 
/*      */ 
/*      */         for (;;)
/*      */         {
/*      */ 
/*      */ 
/*  447 */           if (in_grouping(g_v, 97, 259)) {
/*      */             break label319;
/*      */           }
/*      */           
/*      */ 
/*      */ 
/*  453 */           if (this.cursor >= this.limit) {
/*      */             break;
/*      */           }
/*      */           
/*  457 */           this.cursor += 1;
/*      */         }
/*      */       }
/*      */       
/*  461 */       this.cursor = v_6;
/*      */       
/*  463 */       if (in_grouping(g_v, 97, 259))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  468 */         if (this.cursor < this.limit)
/*      */         {
/*      */ 
/*      */ 
/*  472 */           this.cursor += 1;
/*      */           
/*      */           label319:
/*      */           
/*  476 */           this.I_pV = this.cursor;
/*      */         } } }
/*  478 */     this.cursor = v_1;
/*      */     
/*  480 */     int v_8 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  487 */     while (!in_grouping(g_v, 97, 259))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  493 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  497 */       this.cursor += 1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  503 */     while (!out_grouping(g_v, 97, 259))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  509 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  513 */       this.cursor += 1;
/*      */     }
/*      */     
/*  516 */     this.I_p1 = this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  521 */     while (!in_grouping(g_v, 97, 259))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  527 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  531 */       this.cursor += 1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  537 */     while (!out_grouping(g_v, 97, 259))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  543 */       if (this.cursor >= this.limit) {
/*      */         break label522;
/*      */       }
/*      */       
/*  547 */       this.cursor += 1;
/*      */     }
/*      */     
/*  550 */     this.I_p2 = this.cursor;
/*      */     label522:
/*  552 */     this.cursor = v_8;
/*  553 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private boolean r_postlude()
/*      */   {
/*      */     int v_1;
/*      */     for (;;)
/*      */     {
/*  562 */       v_1 = this.cursor;
/*      */       
/*      */ 
/*      */ 
/*  566 */       this.bra = this.cursor;
/*      */       
/*  568 */       int among_var = find_among(a_0, 3);
/*  569 */       if (among_var == 0) {
/*      */         break;
/*      */       }
/*      */       
/*      */ 
/*  574 */       this.ket = this.cursor;
/*  575 */       switch (among_var)
/*      */       {
/*      */       case 0: 
/*      */         break;
/*      */       
/*      */       case 1: 
/*  581 */         slice_from("i");
/*  582 */         break;
/*      */       
/*      */ 
/*      */       case 2: 
/*  586 */         slice_from("u");
/*  587 */         break;
/*      */       
/*      */ 
/*      */       case 3: 
/*  591 */         if (this.cursor >= this.limit) {
/*      */           break label118;
/*      */         }
/*      */         
/*  595 */         this.cursor += 1;
/*      */       }
/*      */       
/*      */     }
/*      */     label118:
/*  600 */     this.cursor = v_1;
/*      */     
/*      */ 
/*  603 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_RV() {
/*  607 */     if (this.I_pV > this.cursor)
/*      */     {
/*  609 */       return false;
/*      */     }
/*  611 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_R1() {
/*  615 */     if (this.I_p1 > this.cursor)
/*      */     {
/*  617 */       return false;
/*      */     }
/*  619 */     return true;
/*      */   }
/*      */   
/*      */   private boolean r_R2() {
/*  623 */     if (this.I_p2 > this.cursor)
/*      */     {
/*  625 */       return false;
/*      */     }
/*  627 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_step_0()
/*      */   {
/*  635 */     this.ket = this.cursor;
/*      */     
/*  637 */     int among_var = find_among_b(a_1, 16);
/*  638 */     if (among_var == 0)
/*      */     {
/*  640 */       return false;
/*      */     }
/*      */     
/*  643 */     this.bra = this.cursor;
/*      */     
/*  645 */     if (!r_R1())
/*      */     {
/*  647 */       return false;
/*      */     }
/*  649 */     switch (among_var) {
/*      */     case 0: 
/*  651 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  655 */       slice_del();
/*  656 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  660 */       slice_from("a");
/*  661 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  665 */       slice_from("e");
/*  666 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  670 */       slice_from("i");
/*  671 */       break;
/*      */     
/*      */ 
/*      */ 
/*      */     case 5: 
/*  676 */       int v_1 = this.limit - this.cursor;
/*      */       
/*      */ 
/*  679 */       if (eq_s_b(2, "ab"))
/*      */       {
/*      */ 
/*      */ 
/*  683 */         return false;
/*      */       }
/*  685 */       this.cursor = (this.limit - v_1);
/*      */       
/*      */ 
/*  688 */       slice_from("i");
/*  689 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/*  693 */       slice_from("at");
/*  694 */       break;
/*      */     
/*      */ 
/*      */     case 7: 
/*  698 */       slice_from("aţi");
/*      */     }
/*      */     
/*  701 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_combo_suffix()
/*      */   {
/*  708 */     int v_1 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  711 */     this.ket = this.cursor;
/*      */     
/*  713 */     int among_var = find_among_b(a_2, 46);
/*  714 */     if (among_var == 0)
/*      */     {
/*  716 */       return false;
/*      */     }
/*      */     
/*  719 */     this.bra = this.cursor;
/*      */     
/*  721 */     if (!r_R1())
/*      */     {
/*  723 */       return false;
/*      */     }
/*      */     
/*  726 */     switch (among_var) {
/*      */     case 0: 
/*  728 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  732 */       slice_from("abil");
/*  733 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  737 */       slice_from("ibil");
/*  738 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  742 */       slice_from("iv");
/*  743 */       break;
/*      */     
/*      */ 
/*      */     case 4: 
/*  747 */       slice_from("ic");
/*  748 */       break;
/*      */     
/*      */ 
/*      */     case 5: 
/*  752 */       slice_from("at");
/*  753 */       break;
/*      */     
/*      */ 
/*      */     case 6: 
/*  757 */       slice_from("it");
/*      */     }
/*      */     
/*      */     
/*  761 */     this.B_standard_suffix_removed = true;
/*  762 */     this.cursor = (this.limit - v_1);
/*  763 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_standard_suffix()
/*      */   {
/*  771 */     this.B_standard_suffix_removed = false;
/*      */     int v_1;
/*      */     do
/*      */     {
/*  775 */       v_1 = this.limit - this.cursor;
/*      */ 
/*      */     }
/*  778 */     while (r_combo_suffix());
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  784 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*      */ 
/*  788 */     this.ket = this.cursor;
/*      */     
/*  790 */     int among_var = find_among_b(a_3, 62);
/*  791 */     if (among_var == 0)
/*      */     {
/*  793 */       return false;
/*      */     }
/*      */     
/*  796 */     this.bra = this.cursor;
/*      */     
/*  798 */     if (!r_R2())
/*      */     {
/*  800 */       return false;
/*      */     }
/*      */     
/*  803 */     switch (among_var) {
/*      */     case 0: 
/*  805 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  809 */       slice_del();
/*  810 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  814 */       if (!eq_s_b(1, "ţ"))
/*      */       {
/*  816 */         return false;
/*      */       }
/*      */       
/*  819 */       this.bra = this.cursor;
/*      */       
/*  821 */       slice_from("t");
/*  822 */       break;
/*      */     
/*      */ 
/*      */     case 3: 
/*  826 */       slice_from("ist");
/*      */     }
/*      */     
/*      */     
/*  830 */     this.B_standard_suffix_removed = true;
/*  831 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private boolean r_verb_suffix()
/*      */   {
/*  840 */     int v_1 = this.limit - this.cursor;
/*      */     
/*  842 */     if (this.cursor < this.I_pV)
/*      */     {
/*  844 */       return false;
/*      */     }
/*  846 */     this.cursor = this.I_pV;
/*  847 */     int v_2 = this.limit_backward;
/*  848 */     this.limit_backward = this.cursor;
/*  849 */     this.cursor = (this.limit - v_1);
/*      */     
/*      */ 
/*  852 */     this.ket = this.cursor;
/*      */     
/*  854 */     int among_var = find_among_b(a_4, 94);
/*  855 */     if (among_var == 0)
/*      */     {
/*  857 */       this.limit_backward = v_2;
/*  858 */       return false;
/*      */     }
/*      */     
/*  861 */     this.bra = this.cursor;
/*  862 */     switch (among_var) {
/*      */     case 0: 
/*  864 */       this.limit_backward = v_2;
/*  865 */       return false;
/*      */     
/*      */ 
/*      */ 
/*      */     case 1: 
/*  870 */       int v_3 = this.limit - this.cursor;
/*      */       
/*  872 */       if (!out_grouping_b(g_v, 97, 259))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  878 */         this.cursor = (this.limit - v_3);
/*      */         
/*  880 */         if (!eq_s_b(1, "u"))
/*      */         {
/*  882 */           this.limit_backward = v_2;
/*  883 */           return false;
/*      */         }
/*      */       }
/*      */       
/*  887 */       slice_del();
/*  888 */       break;
/*      */     
/*      */ 
/*      */     case 2: 
/*  892 */       slice_del();
/*      */     }
/*      */     
/*  895 */     this.limit_backward = v_2;
/*  896 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private boolean r_vowel_suffix()
/*      */   {
/*  903 */     this.ket = this.cursor;
/*      */     
/*  905 */     int among_var = find_among_b(a_5, 5);
/*  906 */     if (among_var == 0)
/*      */     {
/*  908 */       return false;
/*      */     }
/*      */     
/*  911 */     this.bra = this.cursor;
/*      */     
/*  913 */     if (!r_RV())
/*      */     {
/*  915 */       return false;
/*      */     }
/*  917 */     switch (among_var) {
/*      */     case 0: 
/*  919 */       return false;
/*      */     
/*      */ 
/*      */     case 1: 
/*  923 */       slice_del();
/*      */     }
/*      */     
/*  926 */     return true;
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
/*      */   public boolean stem()
/*      */   {
/*  940 */     int v_1 = this.cursor;
/*      */     
/*      */ 
/*  943 */     if (!r_prelude()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  948 */     this.cursor = v_1;
/*      */     
/*  950 */     int v_2 = this.cursor;
/*      */     
/*      */ 
/*  953 */     if (!r_mark_regions()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  958 */     this.cursor = v_2;
/*      */     
/*  960 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*      */     
/*      */ 
/*  963 */     int v_3 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  966 */     if (!r_step_0()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  971 */     this.cursor = (this.limit - v_3);
/*      */     
/*  973 */     int v_4 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  976 */     if (!r_standard_suffix()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  981 */     this.cursor = (this.limit - v_4);
/*      */     
/*  983 */     int v_5 = this.limit - this.cursor;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  988 */     int v_6 = this.limit - this.cursor;
/*      */     
/*      */ 
/*  991 */     if (!this.B_standard_suffix_removed)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  997 */       this.cursor = (this.limit - v_6);
/*      */       
/*  999 */       if (r_verb_suffix()) {}
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1005 */     this.cursor = (this.limit - v_5);
/*      */     
/* 1007 */     int v_7 = this.limit - this.cursor;
/*      */     
/*      */ 
/* 1010 */     if (!r_vowel_suffix()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1015 */     this.cursor = (this.limit - v_7);
/* 1016 */     this.cursor = this.limit_backward;
/* 1017 */     int v_8 = this.cursor;
/*      */     
/*      */ 
/* 1020 */     if (!r_postlude()) {}
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1025 */     this.cursor = v_8;
/* 1026 */     return true;
/*      */   }
/*      */   
/*      */   public boolean equals(Object o) {
/* 1030 */     return o instanceof romanianStemmer;
/*      */   }
/*      */   
/*      */   public int hashCode() {
/* 1034 */     return romanianStemmer.class.getName().hashCode();
/*      */   }
/*      */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\romanianStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */