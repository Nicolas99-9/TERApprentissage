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
/*     */ public class russianStemmer
/*     */   extends SnowballStemmer
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  16 */   private static final russianStemmer methodObject = new russianStemmer();
/*     */   
/*  18 */   private static final Among[] a_0 = {
/*  19 */     new Among("в", -1, 1, "", methodObject), 
/*  20 */     new Among("ив", 0, 2, "", methodObject), 
/*  21 */     new Among("ыв", 0, 2, "", methodObject), 
/*  22 */     new Among("вши", -1, 1, "", methodObject), 
/*  23 */     new Among("ивши", 3, 2, "", methodObject), 
/*  24 */     new Among("ывши", 3, 2, "", methodObject), 
/*  25 */     new Among("вшись", -1, 1, "", methodObject), 
/*  26 */     new Among("ившись", 6, 2, "", methodObject), 
/*  27 */     new Among("ывшись", 6, 2, "", methodObject) };
/*     */   
/*     */ 
/*  30 */   private static final Among[] a_1 = {
/*  31 */     new Among("ее", -1, 1, "", methodObject), 
/*  32 */     new Among("ие", -1, 1, "", methodObject), 
/*  33 */     new Among("ое", -1, 1, "", methodObject), 
/*  34 */     new Among("ые", -1, 1, "", methodObject), 
/*  35 */     new Among("ими", -1, 1, "", methodObject), 
/*  36 */     new Among("ыми", -1, 1, "", methodObject), 
/*  37 */     new Among("ей", -1, 1, "", methodObject), 
/*  38 */     new Among("ий", -1, 1, "", methodObject), 
/*  39 */     new Among("ой", -1, 1, "", methodObject), 
/*  40 */     new Among("ый", -1, 1, "", methodObject), 
/*  41 */     new Among("ем", -1, 1, "", methodObject), 
/*  42 */     new Among("им", -1, 1, "", methodObject), 
/*  43 */     new Among("ом", -1, 1, "", methodObject), 
/*  44 */     new Among("ым", -1, 1, "", methodObject), 
/*  45 */     new Among("его", -1, 1, "", methodObject), 
/*  46 */     new Among("ого", -1, 1, "", methodObject), 
/*  47 */     new Among("ему", -1, 1, "", methodObject), 
/*  48 */     new Among("ому", -1, 1, "", methodObject), 
/*  49 */     new Among("их", -1, 1, "", methodObject), 
/*  50 */     new Among("ых", -1, 1, "", methodObject), 
/*  51 */     new Among("ею", -1, 1, "", methodObject), 
/*  52 */     new Among("ою", -1, 1, "", methodObject), 
/*  53 */     new Among("ую", -1, 1, "", methodObject), 
/*  54 */     new Among("юю", -1, 1, "", methodObject), 
/*  55 */     new Among("ая", -1, 1, "", methodObject), 
/*  56 */     new Among("яя", -1, 1, "", methodObject) };
/*     */   
/*     */ 
/*  59 */   private static final Among[] a_2 = {
/*  60 */     new Among("ем", -1, 1, "", methodObject), 
/*  61 */     new Among("нн", -1, 1, "", methodObject), 
/*  62 */     new Among("вш", -1, 1, "", methodObject), 
/*  63 */     new Among("ивш", 2, 2, "", methodObject), 
/*  64 */     new Among("ывш", 2, 2, "", methodObject), 
/*  65 */     new Among("щ", -1, 1, "", methodObject), 
/*  66 */     new Among("ющ", 5, 1, "", methodObject), 
/*  67 */     new Among("ующ", 6, 2, "", methodObject) };
/*     */   
/*     */ 
/*  70 */   private static final Among[] a_3 = {
/*  71 */     new Among("сь", -1, 1, "", methodObject), 
/*  72 */     new Among("ся", -1, 1, "", methodObject) };
/*     */   
/*     */ 
/*  75 */   private static final Among[] a_4 = {
/*  76 */     new Among("ла", -1, 1, "", methodObject), 
/*  77 */     new Among("ила", 0, 2, "", methodObject), 
/*  78 */     new Among("ыла", 0, 2, "", methodObject), 
/*  79 */     new Among("на", -1, 1, "", methodObject), 
/*  80 */     new Among("ена", 3, 2, "", methodObject), 
/*  81 */     new Among("ете", -1, 1, "", methodObject), 
/*  82 */     new Among("ите", -1, 2, "", methodObject), 
/*  83 */     new Among("йте", -1, 1, "", methodObject), 
/*  84 */     new Among("ейте", 7, 2, "", methodObject), 
/*  85 */     new Among("уйте", 7, 2, "", methodObject), 
/*  86 */     new Among("ли", -1, 1, "", methodObject), 
/*  87 */     new Among("или", 10, 2, "", methodObject), 
/*  88 */     new Among("ыли", 10, 2, "", methodObject), 
/*  89 */     new Among("й", -1, 1, "", methodObject), 
/*  90 */     new Among("ей", 13, 2, "", methodObject), 
/*  91 */     new Among("уй", 13, 2, "", methodObject), 
/*  92 */     new Among("л", -1, 1, "", methodObject), 
/*  93 */     new Among("ил", 16, 2, "", methodObject), 
/*  94 */     new Among("ыл", 16, 2, "", methodObject), 
/*  95 */     new Among("ем", -1, 1, "", methodObject), 
/*  96 */     new Among("им", -1, 2, "", methodObject), 
/*  97 */     new Among("ым", -1, 2, "", methodObject), 
/*  98 */     new Among("н", -1, 1, "", methodObject), 
/*  99 */     new Among("ен", 22, 2, "", methodObject), 
/* 100 */     new Among("ло", -1, 1, "", methodObject), 
/* 101 */     new Among("ило", 24, 2, "", methodObject), 
/* 102 */     new Among("ыло", 24, 2, "", methodObject), 
/* 103 */     new Among("но", -1, 1, "", methodObject), 
/* 104 */     new Among("ено", 27, 2, "", methodObject), 
/* 105 */     new Among("нно", 27, 1, "", methodObject), 
/* 106 */     new Among("ет", -1, 1, "", methodObject), 
/* 107 */     new Among("ует", 30, 2, "", methodObject), 
/* 108 */     new Among("ит", -1, 2, "", methodObject), 
/* 109 */     new Among("ыт", -1, 2, "", methodObject), 
/* 110 */     new Among("ют", -1, 1, "", methodObject), 
/* 111 */     new Among("уют", 34, 2, "", methodObject), 
/* 112 */     new Among("ят", -1, 2, "", methodObject), 
/* 113 */     new Among("ны", -1, 1, "", methodObject), 
/* 114 */     new Among("ены", 37, 2, "", methodObject), 
/* 115 */     new Among("ть", -1, 1, "", methodObject), 
/* 116 */     new Among("ить", 39, 2, "", methodObject), 
/* 117 */     new Among("ыть", 39, 2, "", methodObject), 
/* 118 */     new Among("ешь", -1, 1, "", methodObject), 
/* 119 */     new Among("ишь", -1, 2, "", methodObject), 
/* 120 */     new Among("ю", -1, 2, "", methodObject), 
/* 121 */     new Among("ую", 44, 2, "", methodObject) };
/*     */   
/*     */ 
/* 124 */   private static final Among[] a_5 = {
/* 125 */     new Among("а", -1, 1, "", methodObject), 
/* 126 */     new Among("ев", -1, 1, "", methodObject), 
/* 127 */     new Among("ов", -1, 1, "", methodObject), 
/* 128 */     new Among("е", -1, 1, "", methodObject), 
/* 129 */     new Among("ие", 3, 1, "", methodObject), 
/* 130 */     new Among("ье", 3, 1, "", methodObject), 
/* 131 */     new Among("и", -1, 1, "", methodObject), 
/* 132 */     new Among("еи", 6, 1, "", methodObject), 
/* 133 */     new Among("ии", 6, 1, "", methodObject), 
/* 134 */     new Among("ами", 6, 1, "", methodObject), 
/* 135 */     new Among("ями", 6, 1, "", methodObject), 
/* 136 */     new Among("иями", 10, 1, "", methodObject), 
/* 137 */     new Among("й", -1, 1, "", methodObject), 
/* 138 */     new Among("ей", 12, 1, "", methodObject), 
/* 139 */     new Among("ией", 13, 1, "", methodObject), 
/* 140 */     new Among("ий", 12, 1, "", methodObject), 
/* 141 */     new Among("ой", 12, 1, "", methodObject), 
/* 142 */     new Among("ам", -1, 1, "", methodObject), 
/* 143 */     new Among("ем", -1, 1, "", methodObject), 
/* 144 */     new Among("ием", 18, 1, "", methodObject), 
/* 145 */     new Among("ом", -1, 1, "", methodObject), 
/* 146 */     new Among("ям", -1, 1, "", methodObject), 
/* 147 */     new Among("иям", 21, 1, "", methodObject), 
/* 148 */     new Among("о", -1, 1, "", methodObject), 
/* 149 */     new Among("у", -1, 1, "", methodObject), 
/* 150 */     new Among("ах", -1, 1, "", methodObject), 
/* 151 */     new Among("ях", -1, 1, "", methodObject), 
/* 152 */     new Among("иях", 26, 1, "", methodObject), 
/* 153 */     new Among("ы", -1, 1, "", methodObject), 
/* 154 */     new Among("ь", -1, 1, "", methodObject), 
/* 155 */     new Among("ю", -1, 1, "", methodObject), 
/* 156 */     new Among("ию", 30, 1, "", methodObject), 
/* 157 */     new Among("ью", 30, 1, "", methodObject), 
/* 158 */     new Among("я", -1, 1, "", methodObject), 
/* 159 */     new Among("ия", 33, 1, "", methodObject), 
/* 160 */     new Among("ья", 33, 1, "", methodObject) };
/*     */   
/*     */ 
/* 163 */   private static final Among[] a_6 = {
/* 164 */     new Among("ост", -1, 1, "", methodObject), 
/* 165 */     new Among("ость", -1, 1, "", methodObject) };
/*     */   
/*     */ 
/* 168 */   private static final Among[] a_7 = {
/* 169 */     new Among("ейше", -1, 1, "", methodObject), 
/* 170 */     new Among("н", -1, 2, "", methodObject), 
/* 171 */     new Among("ейш", -1, 1, "", methodObject), 
/* 172 */     new Among("ь", -1, 3, "", methodObject) };
/*     */   
/*     */ 
/* 175 */   private static final char[] g_v = { '!', 'A', '\b', 'è' };
/*     */   private int I_p2;
/*     */   private int I_pV;
/*     */   
/*     */   private void copy_from(russianStemmer other)
/*     */   {
/* 181 */     this.I_p2 = other.I_p2;
/* 182 */     this.I_pV = other.I_pV;
/* 183 */     super.copy_from(other);
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean r_mark_regions()
/*     */   {
/* 189 */     this.I_pV = this.limit;
/* 190 */     this.I_p2 = this.limit;
/*     */     
/* 192 */     int v_1 = this.cursor;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 199 */     while (!in_grouping(g_v, 1072, 1103))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 205 */       if (this.cursor >= this.limit) {
/*     */         break label209;
/*     */       }
/*     */       
/* 209 */       this.cursor += 1;
/*     */     }
/*     */     
/* 212 */     this.I_pV = this.cursor;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 217 */     while (!out_grouping(g_v, 1072, 1103))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 223 */       if (this.cursor >= this.limit) {
/*     */         break label209;
/*     */       }
/*     */       
/* 227 */       this.cursor += 1;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 233 */     while (!in_grouping(g_v, 1072, 1103))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 239 */       if (this.cursor >= this.limit) {
/*     */         break label209;
/*     */       }
/*     */       
/* 243 */       this.cursor += 1;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 249 */     while (!out_grouping(g_v, 1072, 1103))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 255 */       if (this.cursor >= this.limit) {
/*     */         break label209;
/*     */       }
/*     */       
/* 259 */       this.cursor += 1;
/*     */     }
/*     */     
/* 262 */     this.I_p2 = this.cursor;
/*     */     label209:
/* 264 */     this.cursor = v_1;
/* 265 */     return true;
/*     */   }
/*     */   
/*     */   private boolean r_R2() {
/* 269 */     if (this.I_p2 > this.cursor)
/*     */     {
/* 271 */       return false;
/*     */     }
/* 273 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_perfective_gerund()
/*     */   {
/* 281 */     this.ket = this.cursor;
/*     */     
/* 283 */     int among_var = find_among_b(a_0, 9);
/* 284 */     if (among_var == 0)
/*     */     {
/* 286 */       return false;
/*     */     }
/*     */     
/* 289 */     this.bra = this.cursor;
/* 290 */     switch (among_var) {
/*     */     case 0: 
/* 292 */       return false;
/*     */     
/*     */ 
/*     */ 
/*     */     case 1: 
/* 297 */       int v_1 = this.limit - this.cursor;
/*     */       
/*     */ 
/* 300 */       if (!eq_s_b(1, "а"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 306 */         this.cursor = (this.limit - v_1);
/*     */         
/* 308 */         if (!eq_s_b(1, "я"))
/*     */         {
/* 310 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 314 */       slice_del();
/* 315 */       break;
/*     */     
/*     */ 
/*     */     case 2: 
/* 319 */       slice_del();
/*     */     }
/*     */     
/* 322 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean r_adjective()
/*     */   {
/* 329 */     this.ket = this.cursor;
/*     */     
/* 331 */     int among_var = find_among_b(a_1, 26);
/* 332 */     if (among_var == 0)
/*     */     {
/* 334 */       return false;
/*     */     }
/*     */     
/* 337 */     this.bra = this.cursor;
/* 338 */     switch (among_var) {
/*     */     case 0: 
/* 340 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 344 */       slice_del();
/*     */     }
/*     */     
/* 347 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_adjectival()
/*     */   {
/* 356 */     if (!r_adjective())
/*     */     {
/* 358 */       return false;
/*     */     }
/*     */     
/* 361 */     int v_1 = this.limit - this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 365 */     this.ket = this.cursor;
/*     */     
/* 367 */     int among_var = find_among_b(a_2, 8);
/* 368 */     if (among_var == 0)
/*     */     {
/* 370 */       this.cursor = (this.limit - v_1);
/*     */     }
/*     */     else
/*     */     {
/* 374 */       this.bra = this.cursor;
/* 375 */       switch (among_var) {
/*     */       case 0: 
/* 377 */         this.cursor = (this.limit - v_1);
/* 378 */         break;
/*     */       
/*     */ 
/*     */ 
/*     */       case 1: 
/* 383 */         int v_2 = this.limit - this.cursor;
/*     */         
/*     */ 
/* 386 */         if (!eq_s_b(1, "а"))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 392 */           this.cursor = (this.limit - v_2);
/*     */           
/* 394 */           if (!eq_s_b(1, "я"))
/*     */           {
/* 396 */             this.cursor = (this.limit - v_1);
/* 397 */             break;
/*     */           }
/*     */         }
/*     */         
/* 401 */         slice_del();
/* 402 */         break;
/*     */       
/*     */ 
/*     */       case 2: 
/* 406 */         slice_del();
/*     */       }
/*     */       
/*     */     }
/* 410 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean r_reflexive()
/*     */   {
/* 417 */     this.ket = this.cursor;
/*     */     
/* 419 */     int among_var = find_among_b(a_3, 2);
/* 420 */     if (among_var == 0)
/*     */     {
/* 422 */       return false;
/*     */     }
/*     */     
/* 425 */     this.bra = this.cursor;
/* 426 */     switch (among_var) {
/*     */     case 0: 
/* 428 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 432 */       slice_del();
/*     */     }
/*     */     
/* 435 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean r_verb()
/*     */   {
/* 443 */     this.ket = this.cursor;
/*     */     
/* 445 */     int among_var = find_among_b(a_4, 46);
/* 446 */     if (among_var == 0)
/*     */     {
/* 448 */       return false;
/*     */     }
/*     */     
/* 451 */     this.bra = this.cursor;
/* 452 */     switch (among_var) {
/*     */     case 0: 
/* 454 */       return false;
/*     */     
/*     */ 
/*     */ 
/*     */     case 1: 
/* 459 */       int v_1 = this.limit - this.cursor;
/*     */       
/*     */ 
/* 462 */       if (!eq_s_b(1, "а"))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 468 */         this.cursor = (this.limit - v_1);
/*     */         
/* 470 */         if (!eq_s_b(1, "я"))
/*     */         {
/* 472 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 476 */       slice_del();
/* 477 */       break;
/*     */     
/*     */ 
/*     */     case 2: 
/* 481 */       slice_del();
/*     */     }
/*     */     
/* 484 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean r_noun()
/*     */   {
/* 491 */     this.ket = this.cursor;
/*     */     
/* 493 */     int among_var = find_among_b(a_5, 36);
/* 494 */     if (among_var == 0)
/*     */     {
/* 496 */       return false;
/*     */     }
/*     */     
/* 499 */     this.bra = this.cursor;
/* 500 */     switch (among_var) {
/*     */     case 0: 
/* 502 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 506 */       slice_del();
/*     */     }
/*     */     
/* 509 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean r_derivational()
/*     */   {
/* 516 */     this.ket = this.cursor;
/*     */     
/* 518 */     int among_var = find_among_b(a_6, 2);
/* 519 */     if (among_var == 0)
/*     */     {
/* 521 */       return false;
/*     */     }
/*     */     
/* 524 */     this.bra = this.cursor;
/*     */     
/* 526 */     if (!r_R2())
/*     */     {
/* 528 */       return false;
/*     */     }
/* 530 */     switch (among_var) {
/*     */     case 0: 
/* 532 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 536 */       slice_del();
/*     */     }
/*     */     
/* 539 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean r_tidy_up()
/*     */   {
/* 546 */     this.ket = this.cursor;
/*     */     
/* 548 */     int among_var = find_among_b(a_7, 4);
/* 549 */     if (among_var == 0)
/*     */     {
/* 551 */       return false;
/*     */     }
/*     */     
/* 554 */     this.bra = this.cursor;
/* 555 */     switch (among_var) {
/*     */     case 0: 
/* 557 */       return false;
/*     */     
/*     */ 
/*     */     case 1: 
/* 561 */       slice_del();
/*     */       
/* 563 */       this.ket = this.cursor;
/*     */       
/* 565 */       if (!eq_s_b(1, "н"))
/*     */       {
/* 567 */         return false;
/*     */       }
/*     */       
/* 570 */       this.bra = this.cursor;
/*     */       
/* 572 */       if (!eq_s_b(1, "н"))
/*     */       {
/* 574 */         return false;
/*     */       }
/*     */       
/* 577 */       slice_del();
/* 578 */       break;
/*     */     
/*     */ 
/*     */     case 2: 
/* 582 */       if (!eq_s_b(1, "н"))
/*     */       {
/* 584 */         return false;
/*     */       }
/*     */       
/* 587 */       slice_del();
/* 588 */       break;
/*     */     
/*     */ 
/*     */     case 3: 
/* 592 */       slice_del();
/*     */     }
/*     */     
/* 595 */     return true;
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
/*     */   public boolean stem()
/*     */   {
/* 611 */     int v_1 = this.cursor;
/*     */     
/*     */ 
/* 614 */     if (!r_mark_regions()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 619 */     this.cursor = v_1;
/*     */     
/* 621 */     this.limit_backward = this.cursor;this.cursor = this.limit;
/*     */     
/* 623 */     int v_2 = this.limit - this.cursor;
/*     */     
/* 625 */     if (this.cursor < this.I_pV)
/*     */     {
/* 627 */       return false;
/*     */     }
/* 629 */     this.cursor = this.I_pV;
/* 630 */     int v_3 = this.limit_backward;
/* 631 */     this.limit_backward = this.cursor;
/* 632 */     this.cursor = (this.limit - v_2);
/*     */     
/*     */ 
/* 635 */     int v_4 = this.limit - this.cursor;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 640 */     int v_5 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 643 */     if (!r_perfective_gerund())
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 649 */       this.cursor = (this.limit - v_5);
/*     */       
/*     */ 
/* 652 */       int v_6 = this.limit - this.cursor;
/*     */       
/*     */ 
/* 655 */       if (!r_reflexive())
/*     */       {
/* 657 */         this.cursor = (this.limit - v_6);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 663 */       int v_7 = this.limit - this.cursor;
/*     */       
/*     */ 
/* 666 */       if (!r_adjectival())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 672 */         this.cursor = (this.limit - v_7);
/*     */         
/*     */ 
/* 675 */         if (!r_verb())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 681 */           this.cursor = (this.limit - v_7);
/*     */           
/* 683 */           if (r_noun()) {}
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 690 */     this.cursor = (this.limit - v_4);
/*     */     
/* 692 */     int v_8 = this.limit - this.cursor;
/*     */     
/*     */ 
/*     */ 
/* 696 */     this.ket = this.cursor;
/*     */     
/* 698 */     if (!eq_s_b(1, "и"))
/*     */     {
/* 700 */       this.cursor = (this.limit - v_8);
/*     */     }
/*     */     else
/*     */     {
/* 704 */       this.bra = this.cursor;
/*     */       
/* 706 */       slice_del();
/*     */     }
/*     */     
/* 709 */     int v_9 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 712 */     if (!r_derivational()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 717 */     this.cursor = (this.limit - v_9);
/*     */     
/* 719 */     int v_10 = this.limit - this.cursor;
/*     */     
/*     */ 
/* 722 */     if (!r_tidy_up()) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 727 */     this.cursor = (this.limit - v_10);
/* 728 */     this.limit_backward = v_3;
/* 729 */     this.cursor = this.limit_backward;return true;
/*     */   }
/*     */   
/*     */   public boolean equals(Object o) {
/* 733 */     return o instanceof russianStemmer;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 737 */     return russianStemmer.class.getName().hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\ext\russianStemmer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */