/*      */ package org.textbug.lucene.html;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.PrintStream;
/*      */ 
/*      */ public class HTMLParserTokenManager implements HTMLParserConstants
/*      */ {
/*    8 */   public PrintStream debugStream = System.out;
/*    9 */   public void setDebugStream(PrintStream ds) { this.debugStream = ds; }
/*      */   
/*      */   private final int jjStopStringLiteralDfa_0(int pos, long active0) {
/*   12 */     switch (pos)
/*      */     {
/*      */     case 0: 
/*   15 */       if ((active0 & 0x32) != 0L)
/*   16 */         return 20;
/*   17 */       return -1;
/*      */     case 1: 
/*   19 */       if ((active0 & 0x2) != 0L)
/*      */       {
/*   21 */         if (this.jjmatchedPos != 1)
/*      */         {
/*   23 */           this.jjmatchedKind = 2;
/*   24 */           this.jjmatchedPos = 1;
/*      */         }
/*   26 */         return 22;
/*      */       }
/*   28 */       if ((active0 & 0x30) != 0L)
/*   29 */         return 25;
/*   30 */       return -1;
/*      */     case 2: 
/*   32 */       if ((active0 & 0x2) != 0L)
/*      */       {
/*   34 */         this.jjmatchedKind = 2;
/*   35 */         this.jjmatchedPos = 2;
/*   36 */         return 23;
/*      */       }
/*   38 */       return -1;
/*      */     case 3: 
/*   40 */       if ((active0 & 0x2) != 0L)
/*      */       {
/*   42 */         this.jjmatchedKind = 2;
/*   43 */         this.jjmatchedPos = 3;
/*   44 */         return 23;
/*      */       }
/*   46 */       return -1;
/*      */     case 4: 
/*   48 */       if ((active0 & 0x2) != 0L)
/*      */       {
/*   50 */         this.jjmatchedKind = 2;
/*   51 */         this.jjmatchedPos = 4;
/*   52 */         return 23;
/*      */       }
/*   54 */       return -1;
/*      */     case 5: 
/*   56 */       if ((active0 & 0x2) != 0L)
/*      */       {
/*   58 */         this.jjmatchedKind = 2;
/*   59 */         this.jjmatchedPos = 5;
/*   60 */         return 23;
/*      */       }
/*   62 */       return -1;
/*      */     }
/*   64 */     return -1;
/*      */   }
/*      */   
/*      */   private final int jjStartNfa_0(int pos, long active0)
/*      */   {
/*   69 */     return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
/*      */   }
/*      */   
/*      */   private final int jjStopAtPos(int pos, int kind) {
/*   73 */     this.jjmatchedKind = kind;
/*   74 */     this.jjmatchedPos = pos;
/*   75 */     return pos + 1;
/*      */   }
/*      */   
/*      */   private final int jjStartNfaWithStates_0(int pos, int kind, int state) {
/*   79 */     this.jjmatchedKind = kind;
/*   80 */     this.jjmatchedPos = pos;
/*   81 */     try { this.curChar = this.input_stream.readChar();
/*   82 */     } catch (IOException e) { return pos + 1; }
/*   83 */     return jjMoveNfa_0(state, pos + 1);
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa0_0() {
/*   87 */     switch (this.curChar)
/*      */     {
/*      */     case '<': 
/*   90 */       return jjMoveStringLiteralDfa1_0(50L);
/*      */     }
/*   92 */     return jjMoveNfa_0(11, 0);
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa1_0(long active0) {
/*      */     try {
/*   97 */       this.curChar = this.input_stream.readChar();
/*      */     } catch (IOException e) {
/*   99 */       jjStopStringLiteralDfa_0(0, active0);
/*  100 */       return 1;
/*      */     }
/*  102 */     switch (this.curChar)
/*      */     {
/*      */     case '!': 
/*  105 */       if ((active0 & 0x20) != 0L)
/*      */       {
/*  107 */         this.jjmatchedKind = 5;
/*  108 */         this.jjmatchedPos = 1;
/*      */       }
/*  110 */       return jjMoveStringLiteralDfa2_0(active0, 16L);
/*      */     case 's': 
/*  112 */       return jjMoveStringLiteralDfa2_0(active0, 2L);
/*      */     }
/*      */     
/*      */     
/*  116 */     return jjStartNfa_0(0, active0);
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa2_0(long old0, long active0) {
/*  120 */     if ((active0 &= old0) == 0L)
/*  121 */       return jjStartNfa_0(0, old0);
/*  122 */     try { this.curChar = this.input_stream.readChar();
/*      */     } catch (IOException e) {
/*  124 */       jjStopStringLiteralDfa_0(1, active0);
/*  125 */       return 2;
/*      */     }
/*  127 */     switch (this.curChar)
/*      */     {
/*      */     case '-': 
/*  130 */       return jjMoveStringLiteralDfa3_0(active0, 16L);
/*      */     case 'c': 
/*  132 */       return jjMoveStringLiteralDfa3_0(active0, 2L);
/*      */     }
/*      */     
/*      */     
/*  136 */     return jjStartNfa_0(1, active0);
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa3_0(long old0, long active0) {
/*  140 */     if ((active0 &= old0) == 0L)
/*  141 */       return jjStartNfa_0(1, old0);
/*  142 */     try { this.curChar = this.input_stream.readChar();
/*      */     } catch (IOException e) {
/*  144 */       jjStopStringLiteralDfa_0(2, active0);
/*  145 */       return 3;
/*      */     }
/*  147 */     switch (this.curChar)
/*      */     {
/*      */     case '-': 
/*  150 */       if ((active0 & 0x10) != 0L)
/*  151 */         return jjStopAtPos(3, 4);
/*      */       break;
/*      */     case 'r': 
/*  154 */       return jjMoveStringLiteralDfa4_0(active0, 2L);
/*      */     }
/*      */     
/*      */     
/*  158 */     return jjStartNfa_0(2, active0);
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa4_0(long old0, long active0) {
/*  162 */     if ((active0 &= old0) == 0L)
/*  163 */       return jjStartNfa_0(2, old0);
/*  164 */     try { this.curChar = this.input_stream.readChar();
/*      */     } catch (IOException e) {
/*  166 */       jjStopStringLiteralDfa_0(3, active0);
/*  167 */       return 4;
/*      */     }
/*  169 */     switch (this.curChar)
/*      */     {
/*      */     case 'i': 
/*  172 */       return jjMoveStringLiteralDfa5_0(active0, 2L);
/*      */     }
/*      */     
/*      */     
/*  176 */     return jjStartNfa_0(3, active0);
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa5_0(long old0, long active0) {
/*  180 */     if ((active0 &= old0) == 0L)
/*  181 */       return jjStartNfa_0(3, old0);
/*  182 */     try { this.curChar = this.input_stream.readChar();
/*      */     } catch (IOException e) {
/*  184 */       jjStopStringLiteralDfa_0(4, active0);
/*  185 */       return 5;
/*      */     }
/*  187 */     switch (this.curChar)
/*      */     {
/*      */     case 'p': 
/*  190 */       return jjMoveStringLiteralDfa6_0(active0, 2L);
/*      */     }
/*      */     
/*      */     
/*  194 */     return jjStartNfa_0(4, active0);
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa6_0(long old0, long active0) {
/*  198 */     if ((active0 &= old0) == 0L)
/*  199 */       return jjStartNfa_0(4, old0);
/*  200 */     try { this.curChar = this.input_stream.readChar();
/*      */     } catch (IOException e) {
/*  202 */       jjStopStringLiteralDfa_0(5, active0);
/*  203 */       return 6;
/*      */     }
/*  205 */     switch (this.curChar)
/*      */     {
/*      */     case 't': 
/*  208 */       if ((active0 & 0x2) != 0L) {
/*  209 */         return jjStartNfaWithStates_0(6, 1, 23);
/*      */       }
/*      */       break;
/*      */     }
/*      */     
/*  214 */     return jjStartNfa_0(5, active0);
/*      */   }
/*      */   
/*      */   private final void jjCheckNAdd(int state) {
/*  218 */     if (this.jjrounds[state] != this.jjround)
/*      */     {
/*  220 */       this.jjstateSet[(this.jjnewStateCnt++)] = state;
/*  221 */       this.jjrounds[state] = this.jjround;
/*      */     }
/*      */   }
/*      */   
/*      */   private final void jjAddStates(int start, int end) {
/*      */     do {
/*  227 */       this.jjstateSet[(this.jjnewStateCnt++)] = jjnextStates[start];
/*  228 */     } while (start++ != end);
/*      */   }
/*      */   
/*      */   private final void jjCheckNAddTwoStates(int state1, int state2) {
/*  232 */     jjCheckNAdd(state1);
/*  233 */     jjCheckNAdd(state2);
/*      */   }
/*      */   
/*      */   private final void jjCheckNAddStates(int start, int end) {
/*      */     do {
/*  238 */       jjCheckNAdd(jjnextStates[start]);
/*  239 */     } while (start++ != end);
/*      */   }
/*      */   
/*      */   private final void jjCheckNAddStates(int start) {
/*  243 */     jjCheckNAdd(jjnextStates[start]);
/*  244 */     jjCheckNAdd(jjnextStates[(start + 1)]); }
/*      */   
/*  246 */   static final long[] jjbitVec0 = {
/*  247 */     0, 0, -1L, -1L };
/*      */   
/*      */ 
/*      */   private final int jjMoveNfa_0(int startState, int curPos)
/*      */   {
/*  252 */     int startsAt = 0;
/*  253 */     this.jjnewStateCnt = 28;
/*  254 */     int i = 1;
/*  255 */     this.jjstateSet[0] = startState;
/*  256 */     int kind = Integer.MAX_VALUE;
/*      */     for (;;)
/*      */     {
/*  259 */       if (++this.jjround == Integer.MAX_VALUE)
/*  260 */         ReInitRounds();
/*  261 */       if (this.curChar < '@')
/*      */       {
/*  263 */         long l = 1L << this.curChar;
/*      */         do
/*      */         {
/*  266 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 20: 
/*  269 */             if (this.curChar == '!') {
/*  270 */               this.jjstateSet[(this.jjnewStateCnt++)] = 25;
/*  271 */             } else if (this.curChar == '/')
/*  272 */               jjCheckNAdd(21);
/*  273 */             break;
/*      */           case 11: 
/*  275 */             if ((0x3FF000000000000 & l) != 0L) {
/*  276 */               jjCheckNAddTwoStates(7, 2);
/*  277 */             } else if ((0x100002600 & l) != 0L)
/*      */             {
/*  279 */               if (kind > 11)
/*  280 */                 kind = 11;
/*  281 */               jjCheckNAdd(10);
/*      */             }
/*  283 */             else if (this.curChar == '<') {
/*  284 */               jjCheckNAddStates(0, 2);
/*  285 */             } else if (this.curChar == '&') {
/*  286 */               jjAddStates(3, 5);
/*  287 */             } else if (this.curChar == '$') {
/*  288 */               this.jjstateSet[(this.jjnewStateCnt++)] = 1; }
/*  289 */             if ((0x3FF000000000000 & l) != 0L)
/*      */             {
/*  291 */               if (kind > 6)
/*  292 */                 kind = 6;
/*  293 */               jjCheckNAddStates(6, 10);
/*      */             }
/*  295 */             break;
/*      */           case 0: 
/*  297 */             if (this.curChar == '$')
/*  298 */               this.jjstateSet[(this.jjnewStateCnt++)] = 1;
/*  299 */             break;
/*      */           case 1: 
/*  301 */             if ((0x3FF000000000000 & l) != 0L)
/*  302 */               jjCheckNAdd(2);
/*  303 */             break;
/*      */           case 2: 
/*  305 */             if ((0x500000000000 & l) != 0L)
/*  306 */               this.jjstateSet[(this.jjnewStateCnt++)] = 3;
/*  307 */             break;
/*      */           case 3: 
/*      */           case 9: 
/*  310 */             if ((0x3FF000000000000 & l) != 0L)
/*      */             {
/*  312 */               if (kind > 6)
/*  313 */                 kind = 6;
/*  314 */               jjCheckNAddStates(11, 13); }
/*  315 */             break;
/*      */           case 4: 
/*  317 */             if ((0x3FF000000000000 & l) != 0L)
/*      */             {
/*  319 */               if (kind > 6)
/*  320 */                 kind = 6;
/*  321 */               jjCheckNAddStates(6, 10); }
/*  322 */             break;
/*      */           case 5: 
/*  324 */             if ((0x880000000000 & l) != 0L)
/*      */             {
/*  326 */               if (kind > 6)
/*  327 */                 kind = 6;
/*  328 */               jjCheckNAddStates(14, 17); }
/*  329 */             break;
/*      */           case 6: 
/*  331 */             if ((0x3FF000000000000 & l) != 0L)
/*  332 */               jjCheckNAddTwoStates(7, 2);
/*  333 */             break;
/*      */           case 7: 
/*  335 */             if (this.curChar == '"')
/*      */             {
/*  337 */               if (kind > 6)
/*  338 */                 kind = 6;
/*  339 */               jjCheckNAddStates(11, 13); }
/*  340 */             break;
/*      */           case 8: 
/*  342 */             if ((0x208000000000 & l) != 0L)
/*  343 */               this.jjstateSet[(this.jjnewStateCnt++)] = 9;
/*  344 */             break;
/*      */           case 10: 
/*  346 */             if ((0x100002600 & l) != 0L)
/*      */             {
/*  348 */               kind = 11;
/*  349 */               jjCheckNAdd(10); }
/*  350 */             break;
/*      */           case 13: 
/*  352 */             if ((this.curChar == ';') && (kind > 10))
/*  353 */               kind = 10;
/*  354 */             break;
/*      */           case 14: 
/*  356 */             if (this.curChar == '#')
/*  357 */               jjCheckNAdd(15);
/*  358 */             break;
/*      */           case 15: 
/*  360 */             if ((0x3FF000000000000 & l) != 0L)
/*      */             {
/*  362 */               if (kind > 10)
/*  363 */                 kind = 10;
/*  364 */               jjCheckNAddTwoStates(15, 13); }
/*  365 */             break;
/*      */           case 16: 
/*  367 */             if (this.curChar == '#')
/*  368 */               this.jjstateSet[(this.jjnewStateCnt++)] = 17;
/*  369 */             break;
/*      */           case 18: 
/*  371 */             if ((0x3FF000000000000 & l) != 0L)
/*      */             {
/*  373 */               if (kind > 10)
/*  374 */                 kind = 10;
/*  375 */               jjCheckNAddTwoStates(18, 13); }
/*  376 */             break;
/*      */           case 19: 
/*  378 */             if (this.curChar == '<')
/*  379 */               jjCheckNAddStates(0, 2);
/*  380 */             break;
/*      */           case 22: 
/*  382 */             if ((0x9FFFFF7AFFFFD9FF & l) != 0L)
/*      */             {
/*  384 */               if (kind > 2)
/*  385 */                 kind = 2;
/*  386 */               jjCheckNAdd(23); }
/*  387 */             break;
/*      */           case 23: 
/*  389 */             if ((0x9FFFFFFEFFFFD9FF & l) != 0L)
/*      */             {
/*  391 */               if (kind > 2)
/*  392 */                 kind = 2;
/*  393 */               jjCheckNAdd(23); }
/*  394 */             break;
/*      */           case 24: 
/*  396 */             if (this.curChar == '!')
/*  397 */               this.jjstateSet[(this.jjnewStateCnt++)] = 25;
/*  398 */             break;
/*      */           case 26: 
/*  400 */             if ((0x9FFFFF7AFFFFD9FF & l) != 0L)
/*      */             {
/*  402 */               if (kind > 3)
/*  403 */                 kind = 3;
/*  404 */               jjCheckNAdd(27); }
/*  405 */             break;
/*      */           case 27: 
/*  407 */             if ((0x9FFFFFFEFFFFD9FF & l) != 0L)
/*      */             {
/*  409 */               if (kind > 3)
/*  410 */                 kind = 3;
/*  411 */               jjCheckNAdd(27);
/*      */             }
/*      */             break;
/*      */           }
/*  415 */         } while (i != startsAt);
/*      */       }
/*  417 */       else if (this.curChar < '')
/*      */       {
/*  419 */         long l = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/*  422 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 20: 
/*      */           case 21: 
/*  426 */             if ((0x7FFFFFE07FFFFFE & l) != 0L)
/*      */             {
/*  428 */               if (kind > 2)
/*  429 */                 kind = 2;
/*  430 */               this.jjstateSet[(this.jjnewStateCnt++)] = 22; }
/*  431 */             break;
/*      */           case 4: 
/*      */           case 11: 
/*  434 */             if ((0x7FFFFFE07FFFFFE & l) != 0L)
/*      */             {
/*  436 */               if (kind > 6)
/*  437 */                 kind = 6;
/*  438 */               jjCheckNAddStates(6, 10); }
/*  439 */             break;
/*      */           case 9: 
/*  441 */             if ((0x7FFFFFE07FFFFFE & l) != 0L)
/*      */             {
/*  443 */               if (kind > 6)
/*  444 */                 kind = 6;
/*  445 */               jjCheckNAddStates(11, 13); }
/*  446 */             break;
/*      */           case 12: 
/*  448 */             if ((0x7FFFFFE07FFFFFE & l) != 0L)
/*      */             {
/*  450 */               if (kind > 10)
/*  451 */                 kind = 10;
/*  452 */               jjCheckNAddTwoStates(12, 13); }
/*  453 */             break;
/*      */           case 17: 
/*  455 */             if ((0x100000001000000 & l) != 0L)
/*  456 */               jjCheckNAdd(18);
/*  457 */             break;
/*      */           case 18: 
/*  459 */             if ((0x7E0000007E & l) != 0L)
/*      */             {
/*  461 */               if (kind > 10)
/*  462 */                 kind = 10;
/*  463 */               jjCheckNAddTwoStates(18, 13); }
/*  464 */             break;
/*      */           case 22: 
/*      */           case 23: 
/*  467 */             if (kind > 2)
/*  468 */               kind = 2;
/*  469 */             jjCheckNAdd(23);
/*  470 */             break;
/*      */           case 25: 
/*  472 */             if ((0x7FFFFFE07FFFFFE & l) != 0L)
/*      */             {
/*  474 */               if (kind > 3)
/*  475 */                 kind = 3;
/*  476 */               this.jjstateSet[(this.jjnewStateCnt++)] = 26; }
/*  477 */             break;
/*      */           case 26: 
/*      */           case 27: 
/*  480 */             if (kind > 3)
/*  481 */               kind = 3;
/*  482 */             jjCheckNAdd(27);
/*      */           
/*      */           }
/*      */           
/*  486 */         } while (i != startsAt);
/*      */       }
/*      */       else
/*      */       {
/*  490 */         int i2 = (this.curChar & 0xFF) >> '\006';
/*  491 */         long l2 = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/*  494 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 22: 
/*      */           case 23: 
/*  498 */             if ((jjbitVec0[i2] & l2) != 0L)
/*      */             {
/*  500 */               if (kind > 2)
/*  501 */                 kind = 2;
/*  502 */               jjCheckNAdd(23); }
/*  503 */             break;
/*      */           case 26: 
/*      */           case 27: 
/*  506 */             if ((jjbitVec0[i2] & l2) != 0L)
/*      */             {
/*  508 */               if (kind > 3)
/*  509 */                 kind = 3;
/*  510 */               jjCheckNAdd(27);
/*      */             }
/*      */             break;
/*      */           }
/*  514 */         } while (i != startsAt);
/*      */       }
/*  516 */       if (kind != Integer.MAX_VALUE)
/*      */       {
/*  518 */         this.jjmatchedKind = kind;
/*  519 */         this.jjmatchedPos = curPos;
/*  520 */         kind = Integer.MAX_VALUE;
/*      */       }
/*  522 */       curPos++;
/*  523 */       if ((i = this.jjnewStateCnt) == (startsAt = 28 - (this.jjnewStateCnt = startsAt)))
/*  524 */         return curPos;
/*  525 */       try { this.curChar = this.input_stream.readChar(); } catch (IOException e) {} }
/*  526 */     return curPos;
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa0_5()
/*      */   {
/*  531 */     return jjMoveNfa_5(1, 0);
/*      */   }
/*      */   
/*      */   private final int jjMoveNfa_5(int startState, int curPos)
/*      */   {
/*  536 */     int startsAt = 0;
/*  537 */     this.jjnewStateCnt = 2;
/*  538 */     int i = 1;
/*  539 */     this.jjstateSet[0] = startState;
/*  540 */     int kind = Integer.MAX_VALUE;
/*      */     for (;;)
/*      */     {
/*  543 */       if (++this.jjround == Integer.MAX_VALUE)
/*  544 */         ReInitRounds();
/*  545 */       if (this.curChar < '@')
/*      */       {
/*  547 */         long l = 1L << this.curChar;
/*      */         do
/*      */         {
/*  550 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 1: 
/*  553 */             if ((0xFFFFFFFBFFFFFFFF & l) != 0L)
/*      */             {
/*  555 */               if (kind > 25)
/*  556 */                 kind = 25;
/*  557 */               jjCheckNAdd(0);
/*      */             }
/*  559 */             else if (this.curChar == '"')
/*      */             {
/*  561 */               if (kind > 26)
/*  562 */                 kind = 26;
/*      */             }
/*  564 */             break;
/*      */           case 0: 
/*  566 */             if ((0xFFFFFFFBFFFFFFFF & l) != 0L)
/*      */             {
/*  568 */               kind = 25;
/*  569 */               jjCheckNAdd(0);
/*      */             }
/*      */             break;
/*      */           }
/*  573 */         } while (i != startsAt);
/*      */       }
/*  575 */       else if (this.curChar < '')
/*      */       {
/*  577 */         long l = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/*  580 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*      */           case 1: 
/*  584 */             kind = 25;
/*  585 */             jjCheckNAdd(0);
/*      */           
/*      */           }
/*      */           
/*  589 */         } while (i != startsAt);
/*      */       }
/*      */       else
/*      */       {
/*  593 */         int i2 = (this.curChar & 0xFF) >> '\006';
/*  594 */         long l2 = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/*  597 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*      */           case 1: 
/*  601 */             if ((jjbitVec0[i2] & l2) != 0L)
/*      */             {
/*  603 */               if (kind > 25)
/*  604 */                 kind = 25;
/*  605 */               jjCheckNAdd(0);
/*      */             }
/*      */             break;
/*      */           }
/*  609 */         } while (i != startsAt);
/*      */       }
/*  611 */       if (kind != Integer.MAX_VALUE)
/*      */       {
/*  613 */         this.jjmatchedKind = kind;
/*  614 */         this.jjmatchedPos = curPos;
/*  615 */         kind = Integer.MAX_VALUE;
/*      */       }
/*  617 */       curPos++;
/*  618 */       if ((i = this.jjnewStateCnt) == (startsAt = 2 - (this.jjnewStateCnt = startsAt)))
/*  619 */         return curPos;
/*  620 */       try { this.curChar = this.input_stream.readChar(); } catch (IOException e) {} }
/*  621 */     return curPos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private final int jjStopStringLiteralDfa_7(int pos, long active0)
/*      */   {
/*  629 */     return -1;
/*      */   }
/*      */   
/*      */   private final int jjStartNfa_7(int pos, long active0)
/*      */   {
/*  634 */     return jjMoveNfa_7(jjStopStringLiteralDfa_7(pos, active0), pos + 1);
/*      */   }
/*      */   
/*      */   private final int jjStartNfaWithStates_7(int pos, int kind, int state) {
/*  638 */     this.jjmatchedKind = kind;
/*  639 */     this.jjmatchedPos = pos;
/*  640 */     try { this.curChar = this.input_stream.readChar();
/*  641 */     } catch (IOException e) { return pos + 1; }
/*  642 */     return jjMoveNfa_7(state, pos + 1);
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa0_7() {
/*  646 */     switch (this.curChar)
/*      */     {
/*      */     case '>': 
/*  649 */       return jjStopAtPos(0, 30);
/*      */     }
/*  651 */     return jjMoveNfa_7(0, 0);
/*      */   }
/*      */   
/*      */ 
/*      */   private final int jjMoveNfa_7(int startState, int curPos)
/*      */   {
/*  657 */     int startsAt = 0;
/*  658 */     this.jjnewStateCnt = 1;
/*  659 */     int i = 1;
/*  660 */     this.jjstateSet[0] = startState;
/*  661 */     int kind = Integer.MAX_VALUE;
/*      */     for (;;)
/*      */     {
/*  664 */       if (++this.jjround == Integer.MAX_VALUE)
/*  665 */         ReInitRounds();
/*  666 */       if (this.curChar < '@')
/*      */       {
/*  668 */         long l = 1L << this.curChar;
/*      */         do
/*      */         {
/*  671 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*  674 */             if ((0xBFFFFFFFFFFFFFFF & l) != 0L)
/*      */             {
/*  676 */               kind = 29;
/*  677 */               this.jjstateSet[(this.jjnewStateCnt++)] = 0;
/*      */             }
/*      */             break;
/*      */           }
/*  681 */         } while (i != startsAt);
/*      */       }
/*  683 */       else if (this.curChar < '')
/*      */       {
/*  685 */         long l = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/*  688 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*  691 */             kind = 29;
/*  692 */             this.jjstateSet[(this.jjnewStateCnt++)] = 0;
/*      */           
/*      */           }
/*      */           
/*  696 */         } while (i != startsAt);
/*      */       }
/*      */       else
/*      */       {
/*  700 */         int i2 = (this.curChar & 0xFF) >> '\006';
/*  701 */         long l2 = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/*  704 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*  707 */             if ((jjbitVec0[i2] & l2) != 0L)
/*      */             {
/*  709 */               if (kind > 29)
/*  710 */                 kind = 29;
/*  711 */               this.jjstateSet[(this.jjnewStateCnt++)] = 0;
/*      */             }
/*      */             break;
/*      */           }
/*  715 */         } while (i != startsAt);
/*      */       }
/*  717 */       if (kind != Integer.MAX_VALUE)
/*      */       {
/*  719 */         this.jjmatchedKind = kind;
/*  720 */         this.jjmatchedPos = curPos;
/*  721 */         kind = Integer.MAX_VALUE;
/*      */       }
/*  723 */       curPos++;
/*  724 */       if ((i = this.jjnewStateCnt) == (startsAt = 1 - (this.jjnewStateCnt = startsAt)))
/*  725 */         return curPos;
/*  726 */       try { this.curChar = this.input_stream.readChar(); } catch (IOException e) {} }
/*  727 */     return curPos;
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa0_4()
/*      */   {
/*  732 */     return jjMoveNfa_4(1, 0);
/*      */   }
/*      */   
/*      */   private final int jjMoveNfa_4(int startState, int curPos)
/*      */   {
/*  737 */     int startsAt = 0;
/*  738 */     this.jjnewStateCnt = 2;
/*  739 */     int i = 1;
/*  740 */     this.jjstateSet[0] = startState;
/*  741 */     int kind = Integer.MAX_VALUE;
/*      */     for (;;)
/*      */     {
/*  744 */       if (++this.jjround == Integer.MAX_VALUE)
/*  745 */         ReInitRounds();
/*  746 */       if (this.curChar < '@')
/*      */       {
/*  748 */         long l = 1L << this.curChar;
/*      */         do
/*      */         {
/*  751 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 1: 
/*  754 */             if ((0xFFFFFF7FFFFFFFFF & l) != 0L)
/*      */             {
/*  756 */               if (kind > 23)
/*  757 */                 kind = 23;
/*  758 */               jjCheckNAdd(0);
/*      */             }
/*  760 */             else if (this.curChar == '\'')
/*      */             {
/*  762 */               if (kind > 24)
/*  763 */                 kind = 24;
/*      */             }
/*  765 */             break;
/*      */           case 0: 
/*  767 */             if ((0xFFFFFF7FFFFFFFFF & l) != 0L)
/*      */             {
/*  769 */               kind = 23;
/*  770 */               jjCheckNAdd(0);
/*      */             }
/*      */             break;
/*      */           }
/*  774 */         } while (i != startsAt);
/*      */       }
/*  776 */       else if (this.curChar < '')
/*      */       {
/*  778 */         long l = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/*  781 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*      */           case 1: 
/*  785 */             kind = 23;
/*  786 */             jjCheckNAdd(0);
/*      */           
/*      */           }
/*      */           
/*  790 */         } while (i != startsAt);
/*      */       }
/*      */       else
/*      */       {
/*  794 */         int i2 = (this.curChar & 0xFF) >> '\006';
/*  795 */         long l2 = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/*  798 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*      */           case 1: 
/*  802 */             if ((jjbitVec0[i2] & l2) != 0L)
/*      */             {
/*  804 */               if (kind > 23)
/*  805 */                 kind = 23;
/*  806 */               jjCheckNAdd(0);
/*      */             }
/*      */             break;
/*      */           }
/*  810 */         } while (i != startsAt);
/*      */       }
/*  812 */       if (kind != Integer.MAX_VALUE)
/*      */       {
/*  814 */         this.jjmatchedKind = kind;
/*  815 */         this.jjmatchedPos = curPos;
/*  816 */         kind = Integer.MAX_VALUE;
/*      */       }
/*  818 */       curPos++;
/*  819 */       if ((i = this.jjnewStateCnt) == (startsAt = 2 - (this.jjnewStateCnt = startsAt)))
/*  820 */         return curPos;
/*  821 */       try { this.curChar = this.input_stream.readChar(); } catch (IOException e) {} }
/*  822 */     return curPos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private final int jjStopStringLiteralDfa_3(int pos, long active0)
/*      */   {
/*  830 */     return -1;
/*      */   }
/*      */   
/*      */   private final int jjStartNfa_3(int pos, long active0)
/*      */   {
/*  835 */     return jjMoveNfa_3(jjStopStringLiteralDfa_3(pos, active0), pos + 1);
/*      */   }
/*      */   
/*      */   private final int jjStartNfaWithStates_3(int pos, int kind, int state) {
/*  839 */     this.jjmatchedKind = kind;
/*  840 */     this.jjmatchedPos = pos;
/*  841 */     try { this.curChar = this.input_stream.readChar();
/*  842 */     } catch (IOException e) { return pos + 1; }
/*  843 */     return jjMoveNfa_3(state, pos + 1);
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa0_3() {
/*  847 */     switch (this.curChar)
/*      */     {
/*      */     case '"': 
/*  850 */       return jjStopAtPos(0, 21);
/*      */     case '\'': 
/*  852 */       return jjStopAtPos(0, 20);
/*      */     }
/*  854 */     return jjMoveNfa_3(0, 0);
/*      */   }
/*      */   
/*      */ 
/*      */   private final int jjMoveNfa_3(int startState, int curPos)
/*      */   {
/*  860 */     int startsAt = 0;
/*  861 */     this.jjnewStateCnt = 3;
/*  862 */     int i = 1;
/*  863 */     this.jjstateSet[0] = startState;
/*  864 */     int kind = Integer.MAX_VALUE;
/*      */     for (;;)
/*      */     {
/*  867 */       if (++this.jjround == Integer.MAX_VALUE)
/*  868 */         ReInitRounds();
/*  869 */       if (this.curChar < '@')
/*      */       {
/*  871 */         long l = 1L << this.curChar;
/*      */         do
/*      */         {
/*  874 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*  877 */             if ((0x9FFFFF7AFFFFD9FF & l) != 0L)
/*      */             {
/*  879 */               if (kind > 19)
/*  880 */                 kind = 19;
/*  881 */               jjCheckNAdd(1);
/*      */             }
/*  883 */             else if ((0x100002600 & l) != 0L)
/*      */             {
/*  885 */               if (kind > 22)
/*  886 */                 kind = 22;
/*  887 */               jjCheckNAdd(2);
/*      */             }
/*  889 */             break;
/*      */           case 1: 
/*  891 */             if ((0xBFFFFFFEFFFFD9FF & l) != 0L)
/*      */             {
/*  893 */               if (kind > 19)
/*  894 */                 kind = 19;
/*  895 */               jjCheckNAdd(1); }
/*  896 */             break;
/*      */           case 2: 
/*  898 */             if ((0x100002600 & l) != 0L)
/*      */             {
/*  900 */               kind = 22;
/*  901 */               jjCheckNAdd(2);
/*      */             }
/*      */             break;
/*      */           }
/*  905 */         } while (i != startsAt);
/*      */       }
/*  907 */       else if (this.curChar < '')
/*      */       {
/*  909 */         long l = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/*  912 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*      */           case 1: 
/*  916 */             if (kind > 19)
/*  917 */               kind = 19;
/*  918 */             jjCheckNAdd(1);
/*      */           
/*      */           }
/*      */           
/*  922 */         } while (i != startsAt);
/*      */       }
/*      */       else
/*      */       {
/*  926 */         int i2 = (this.curChar & 0xFF) >> '\006';
/*  927 */         long l2 = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/*  930 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*      */           case 1: 
/*  934 */             if ((jjbitVec0[i2] & l2) != 0L)
/*      */             {
/*  936 */               if (kind > 19)
/*  937 */                 kind = 19;
/*  938 */               jjCheckNAdd(1);
/*      */             }
/*      */             break;
/*      */           }
/*  942 */         } while (i != startsAt);
/*      */       }
/*  944 */       if (kind != Integer.MAX_VALUE)
/*      */       {
/*  946 */         this.jjmatchedKind = kind;
/*  947 */         this.jjmatchedPos = curPos;
/*  948 */         kind = Integer.MAX_VALUE;
/*      */       }
/*  950 */       curPos++;
/*  951 */       if ((i = this.jjnewStateCnt) == (startsAt = 3 - (this.jjnewStateCnt = startsAt)))
/*  952 */         return curPos;
/*  953 */       try { this.curChar = this.input_stream.readChar(); } catch (IOException e) {} }
/*  954 */     return curPos;
/*      */   }
/*      */   
/*      */   private final int jjStopStringLiteralDfa_6(int pos, long active0)
/*      */   {
/*  959 */     switch (pos)
/*      */     {
/*      */     case 0: 
/*  962 */       if ((active0 & 0x10000000) != 0L)
/*      */       {
/*  964 */         this.jjmatchedKind = 27;
/*  965 */         return -1;
/*      */       }
/*  967 */       return -1;
/*      */     case 1: 
/*  969 */       if ((active0 & 0x10000000) != 0L)
/*      */       {
/*  971 */         if (this.jjmatchedPos == 0)
/*      */         {
/*  973 */           this.jjmatchedKind = 27;
/*  974 */           this.jjmatchedPos = 0;
/*      */         }
/*  976 */         return -1;
/*      */       }
/*  978 */       return -1;
/*      */     }
/*  980 */     return -1;
/*      */   }
/*      */   
/*      */   private final int jjStartNfa_6(int pos, long active0)
/*      */   {
/*  985 */     return jjMoveNfa_6(jjStopStringLiteralDfa_6(pos, active0), pos + 1);
/*      */   }
/*      */   
/*      */   private final int jjStartNfaWithStates_6(int pos, int kind, int state) {
/*  989 */     this.jjmatchedKind = kind;
/*  990 */     this.jjmatchedPos = pos;
/*  991 */     try { this.curChar = this.input_stream.readChar();
/*  992 */     } catch (IOException e) { return pos + 1; }
/*  993 */     return jjMoveNfa_6(state, pos + 1);
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa0_6() {
/*  997 */     switch (this.curChar)
/*      */     {
/*      */     case '-': 
/* 1000 */       return jjMoveStringLiteralDfa1_6(268435456L);
/*      */     }
/* 1002 */     return jjMoveNfa_6(1, 0);
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa1_6(long active0) {
/*      */     try {
/* 1007 */       this.curChar = this.input_stream.readChar();
/*      */     } catch (IOException e) {
/* 1009 */       jjStopStringLiteralDfa_6(0, active0);
/* 1010 */       return 1;
/*      */     }
/* 1012 */     switch (this.curChar)
/*      */     {
/*      */     case '-': 
/* 1015 */       return jjMoveStringLiteralDfa2_6(active0, 268435456L);
/*      */     }
/*      */     
/*      */     
/* 1019 */     return jjStartNfa_6(0, active0);
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa2_6(long old0, long active0) {
/* 1023 */     if ((active0 &= old0) == 0L)
/* 1024 */       return jjStartNfa_6(0, old0);
/* 1025 */     try { this.curChar = this.input_stream.readChar();
/*      */     } catch (IOException e) {
/* 1027 */       jjStopStringLiteralDfa_6(1, active0);
/* 1028 */       return 2;
/*      */     }
/* 1030 */     switch (this.curChar)
/*      */     {
/*      */     case '>': 
/* 1033 */       if ((active0 & 0x10000000) != 0L) {
/* 1034 */         return jjStopAtPos(2, 28);
/*      */       }
/*      */       break;
/*      */     }
/*      */     
/* 1039 */     return jjStartNfa_6(1, active0);
/*      */   }
/*      */   
/*      */   private final int jjMoveNfa_6(int startState, int curPos)
/*      */   {
/* 1044 */     int startsAt = 0;
/* 1045 */     this.jjnewStateCnt = 2;
/* 1046 */     int i = 1;
/* 1047 */     this.jjstateSet[0] = startState;
/* 1048 */     int kind = Integer.MAX_VALUE;
/*      */     for (;;)
/*      */     {
/* 1051 */       if (++this.jjround == Integer.MAX_VALUE)
/* 1052 */         ReInitRounds();
/* 1053 */       if (this.curChar < '@')
/*      */       {
/* 1055 */         long l = 1L << this.curChar;
/*      */         do
/*      */         {
/* 1058 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 1: 
/* 1061 */             if ((0xFFFFDFFFFFFFFFFF & l) != 0L)
/*      */             {
/* 1063 */               if (kind > 27)
/* 1064 */                 kind = 27;
/* 1065 */               jjCheckNAdd(0);
/*      */             }
/* 1067 */             else if (this.curChar == '-')
/*      */             {
/* 1069 */               if (kind > 27)
/* 1070 */                 kind = 27;
/*      */             }
/* 1072 */             break;
/*      */           case 0: 
/* 1074 */             if ((0xFFFFDFFFFFFFFFFF & l) != 0L)
/*      */             {
/* 1076 */               kind = 27;
/* 1077 */               jjCheckNAdd(0);
/*      */             }
/*      */             break;
/*      */           }
/* 1081 */         } while (i != startsAt);
/*      */       }
/* 1083 */       else if (this.curChar < '')
/*      */       {
/* 1085 */         long l = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/* 1088 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*      */           case 1: 
/* 1092 */             kind = 27;
/* 1093 */             jjCheckNAdd(0);
/*      */           
/*      */           }
/*      */           
/* 1097 */         } while (i != startsAt);
/*      */       }
/*      */       else
/*      */       {
/* 1101 */         int i2 = (this.curChar & 0xFF) >> '\006';
/* 1102 */         long l2 = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/* 1105 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*      */           case 1: 
/* 1109 */             if ((jjbitVec0[i2] & l2) != 0L)
/*      */             {
/* 1111 */               if (kind > 27)
/* 1112 */                 kind = 27;
/* 1113 */               jjCheckNAdd(0);
/*      */             }
/*      */             break;
/*      */           }
/* 1117 */         } while (i != startsAt);
/*      */       }
/* 1119 */       if (kind != Integer.MAX_VALUE)
/*      */       {
/* 1121 */         this.jjmatchedKind = kind;
/* 1122 */         this.jjmatchedPos = curPos;
/* 1123 */         kind = Integer.MAX_VALUE;
/*      */       }
/* 1125 */       curPos++;
/* 1126 */       if ((i = this.jjnewStateCnt) == (startsAt = 2 - (this.jjnewStateCnt = startsAt)))
/* 1127 */         return curPos;
/* 1128 */       try { this.curChar = this.input_stream.readChar(); } catch (IOException e) {} }
/* 1129 */     return curPos;
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa0_1()
/*      */   {
/* 1134 */     return jjMoveNfa_1(1, 0);
/*      */   }
/*      */   
/*      */   private final int jjMoveNfa_1(int startState, int curPos)
/*      */   {
/* 1139 */     int startsAt = 0;
/* 1140 */     this.jjnewStateCnt = 12;
/* 1141 */     int i = 1;
/* 1142 */     this.jjstateSet[0] = startState;
/* 1143 */     int kind = Integer.MAX_VALUE;
/*      */     for (;;)
/*      */     {
/* 1146 */       if (++this.jjround == Integer.MAX_VALUE)
/* 1147 */         ReInitRounds();
/* 1148 */       if (this.curChar < '@')
/*      */       {
/* 1150 */         long l = 1L << this.curChar;
/*      */         do
/*      */         {
/* 1153 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 1: 
/* 1156 */             if ((0xAFFFFFFFFFFFFFFF & l) != 0L)
/*      */             {
/* 1158 */               if (kind > 14)
/* 1159 */                 kind = 14;
/* 1160 */               jjCheckNAdd(0);
/*      */             }
/* 1162 */             else if ((0x5000000000000000 & l) != 0L)
/*      */             {
/* 1164 */               if (kind > 14)
/* 1165 */                 kind = 14;
/*      */             }
/* 1167 */             if (this.curChar == '<')
/* 1168 */               this.jjstateSet[(this.jjnewStateCnt++)] = 10;
/* 1169 */             break;
/*      */           case 0: 
/* 1171 */             if ((0xAFFFFFFFFFFFFFFF & l) != 0L)
/*      */             {
/* 1173 */               if (kind > 14)
/* 1174 */                 kind = 14;
/* 1175 */               jjCheckNAdd(0); }
/* 1176 */             break;
/*      */           case 3: 
/* 1178 */             if ((0xAFFFFFFFFFFFFFFF & l) != 0L)
/* 1179 */               jjAddStates(18, 19);
/* 1180 */             break;
/*      */           case 4: 
/* 1182 */             if ((this.curChar == '>') && (kind > 15))
/* 1183 */               kind = 15;
/* 1184 */             break;
/*      */           case 10: 
/* 1186 */             if (this.curChar == '/')
/* 1187 */               this.jjstateSet[(this.jjnewStateCnt++)] = 9;
/* 1188 */             break;
/*      */           case 11: 
/* 1190 */             if (this.curChar == '<') {
/* 1191 */               this.jjstateSet[(this.jjnewStateCnt++)] = 10;
/*      */             }
/*      */             break;
/*      */           }
/* 1195 */         } while (i != startsAt);
/*      */       }
/* 1197 */       else if (this.curChar < '')
/*      */       {
/* 1199 */         long l = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/* 1202 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*      */           case 1: 
/* 1206 */             if (kind > 14)
/* 1207 */               kind = 14;
/* 1208 */             jjCheckNAdd(0);
/* 1209 */             break;
/*      */           case 2: 
/* 1211 */             if (this.curChar == 't')
/* 1212 */               jjCheckNAddTwoStates(3, 4);
/* 1213 */             break;
/*      */           case 3: 
/* 1215 */             jjCheckNAddTwoStates(3, 4);
/* 1216 */             break;
/*      */           case 5: 
/* 1218 */             if (this.curChar == 'p')
/* 1219 */               this.jjstateSet[(this.jjnewStateCnt++)] = 2;
/* 1220 */             break;
/*      */           case 6: 
/* 1222 */             if (this.curChar == 'i')
/* 1223 */               this.jjstateSet[(this.jjnewStateCnt++)] = 5;
/* 1224 */             break;
/*      */           case 7: 
/* 1226 */             if (this.curChar == 'r')
/* 1227 */               this.jjstateSet[(this.jjnewStateCnt++)] = 6;
/* 1228 */             break;
/*      */           case 8: 
/* 1230 */             if (this.curChar == 'c')
/* 1231 */               this.jjstateSet[(this.jjnewStateCnt++)] = 7;
/* 1232 */             break;
/*      */           case 9: 
/* 1234 */             if (this.curChar == 's') {
/* 1235 */               this.jjstateSet[(this.jjnewStateCnt++)] = 8;
/*      */             }
/*      */             break;
/*      */           }
/* 1239 */         } while (i != startsAt);
/*      */       }
/*      */       else
/*      */       {
/* 1243 */         int i2 = (this.curChar & 0xFF) >> '\006';
/* 1244 */         long l2 = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/* 1247 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*      */           case 1: 
/* 1251 */             if ((jjbitVec0[i2] & l2) != 0L)
/*      */             {
/* 1253 */               if (kind > 14)
/* 1254 */                 kind = 14;
/* 1255 */               jjCheckNAdd(0); }
/* 1256 */             break;
/*      */           case 3: 
/* 1258 */             if ((jjbitVec0[i2] & l2) != 0L) {
/* 1259 */               jjAddStates(18, 19);
/*      */             }
/*      */             break;
/*      */           }
/* 1263 */         } while (i != startsAt);
/*      */       }
/* 1265 */       if (kind != Integer.MAX_VALUE)
/*      */       {
/* 1267 */         this.jjmatchedKind = kind;
/* 1268 */         this.jjmatchedPos = curPos;
/* 1269 */         kind = Integer.MAX_VALUE;
/*      */       }
/* 1271 */       curPos++;
/* 1272 */       if ((i = this.jjnewStateCnt) == (startsAt = 12 - (this.jjnewStateCnt = startsAt)))
/* 1273 */         return curPos;
/* 1274 */       try { this.curChar = this.input_stream.readChar(); } catch (IOException e) {} }
/* 1275 */     return curPos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private final int jjStopStringLiteralDfa_2(int pos, long active0)
/*      */   {
/* 1283 */     return -1;
/*      */   }
/*      */   
/*      */   private final int jjStartNfa_2(int pos, long active0)
/*      */   {
/* 1288 */     return jjMoveNfa_2(jjStopStringLiteralDfa_2(pos, active0), pos + 1);
/*      */   }
/*      */   
/*      */   private final int jjStartNfaWithStates_2(int pos, int kind, int state) {
/* 1292 */     this.jjmatchedKind = kind;
/* 1293 */     this.jjmatchedPos = pos;
/* 1294 */     try { this.curChar = this.input_stream.readChar();
/* 1295 */     } catch (IOException e) { return pos + 1; }
/* 1296 */     return jjMoveNfa_2(state, pos + 1);
/*      */   }
/*      */   
/*      */   private final int jjMoveStringLiteralDfa0_2() {
/* 1300 */     switch (this.curChar)
/*      */     {
/*      */     case '"': 
/* 1303 */       return jjStopAtPos(0, 21);
/*      */     case '\'': 
/* 1305 */       return jjStopAtPos(0, 20);
/*      */     case '=': 
/* 1307 */       return jjStartNfaWithStates_2(0, 17, 3);
/*      */     }
/* 1309 */     return jjMoveNfa_2(0, 0);
/*      */   }
/*      */   
/*      */ 
/*      */   private final int jjMoveNfa_2(int startState, int curPos)
/*      */   {
/* 1315 */     int startsAt = 0;
/* 1316 */     this.jjnewStateCnt = 6;
/* 1317 */     int i = 1;
/* 1318 */     this.jjstateSet[0] = startState;
/* 1319 */     int kind = Integer.MAX_VALUE;
/*      */     for (;;)
/*      */     {
/* 1322 */       if (++this.jjround == Integer.MAX_VALUE)
/* 1323 */         ReInitRounds();
/* 1324 */       if (this.curChar < '@')
/*      */       {
/* 1326 */         long l = 1L << this.curChar;
/*      */         do
/*      */         {
/* 1329 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/* 1332 */             if ((0x9FFFFF7AFFFFD9FF & l) != 0L)
/*      */             {
/* 1334 */               if (kind > 16)
/* 1335 */                 kind = 16;
/* 1336 */               jjCheckNAdd(1);
/*      */             }
/* 1338 */             else if ((0x100002600 & l) != 0L)
/*      */             {
/* 1340 */               if (kind > 22)
/* 1341 */                 kind = 22;
/* 1342 */               jjCheckNAdd(5);
/*      */             }
/* 1344 */             else if (this.curChar == '=') {
/* 1345 */               this.jjstateSet[(this.jjnewStateCnt++)] = 3;
/* 1346 */             } else if (this.curChar == '>')
/*      */             {
/* 1348 */               if (kind > 18)
/* 1349 */                 kind = 18;
/*      */             }
/* 1351 */             break;
/*      */           case 1: 
/* 1353 */             if ((0x9FFFFFFEFFFFD9FF & l) != 0L)
/*      */             {
/* 1355 */               if (kind > 16)
/* 1356 */                 kind = 16;
/* 1357 */               jjCheckNAdd(1); }
/* 1358 */             break;
/*      */           case 2: 
/*      */           case 3: 
/* 1361 */             if ((this.curChar == '>') && (kind > 18))
/* 1362 */               kind = 18;
/* 1363 */             break;
/*      */           case 4: 
/* 1365 */             if (this.curChar == '=')
/* 1366 */               this.jjstateSet[(this.jjnewStateCnt++)] = 3;
/* 1367 */             break;
/*      */           case 5: 
/* 1369 */             if ((0x100002600 & l) != 0L)
/*      */             {
/* 1371 */               kind = 22;
/* 1372 */               jjCheckNAdd(5);
/*      */             }
/*      */             break;
/*      */           }
/* 1376 */         } while (i != startsAt);
/*      */       }
/* 1378 */       else if (this.curChar < '')
/*      */       {
/* 1380 */         long l = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/* 1383 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*      */           case 1: 
/* 1387 */             if (kind > 16)
/* 1388 */               kind = 16;
/* 1389 */             jjCheckNAdd(1);
/*      */           
/*      */           }
/*      */           
/* 1393 */         } while (i != startsAt);
/*      */       }
/*      */       else
/*      */       {
/* 1397 */         int i2 = (this.curChar & 0xFF) >> '\006';
/* 1398 */         long l2 = 1L << (this.curChar & 0x3F);
/*      */         do
/*      */         {
/* 1401 */           switch (this.jjstateSet[(--i)])
/*      */           {
/*      */           case 0: 
/*      */           case 1: 
/* 1405 */             if ((jjbitVec0[i2] & l2) != 0L)
/*      */             {
/* 1407 */               if (kind > 16)
/* 1408 */                 kind = 16;
/* 1409 */               jjCheckNAdd(1);
/*      */             }
/*      */             break;
/*      */           }
/* 1413 */         } while (i != startsAt);
/*      */       }
/* 1415 */       if (kind != Integer.MAX_VALUE)
/*      */       {
/* 1417 */         this.jjmatchedKind = kind;
/* 1418 */         this.jjmatchedPos = curPos;
/* 1419 */         kind = Integer.MAX_VALUE;
/*      */       }
/* 1421 */       curPos++;
/* 1422 */       if ((i = this.jjnewStateCnt) == (startsAt = 6 - (this.jjnewStateCnt = startsAt)))
/* 1423 */         return curPos;
/* 1424 */       try { this.curChar = this.input_stream.readChar(); } catch (IOException e) {} }
/* 1425 */     return curPos;
/*      */   }
/*      */   
/* 1428 */   static final int[] jjnextStates = {
/* 1429 */     20, 21, 24, 12, 14, 16, 5, 8, 0, 4, 6, 0, 4, 6, 5, 
/* 1430 */     0, 4, 6, 3, 4 };
/*      */   
/* 1432 */   public static final String[] jjstrLiteralImages = {
/* 1433 */     "", "<script", 0, 0, "<!--", "<!", 
/* 1434 */     0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "=", 
/* 1435 */     0, 0, "'", "\"", 0, 0, 0, 0, 0, 0, "-->", 0">" };
/* 1436 */   public static final String[] lexStateNames = {
/* 1437 */     "DEFAULT", 
/* 1438 */     "WithinScript", 
/* 1439 */     "WithinTag", 
/* 1440 */     "AfterEquals", 
/* 1441 */     "WithinQuote1", 
/* 1442 */     "WithinQuote2", 
/* 1443 */     "WithinComment1", 
/* 1444 */     "WithinComment2" };
/*      */   
/* 1446 */   public static final int[] jjnewLexState = {
/* 1447 */     -1, 1, 2, 2, 6, 7, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, 3, 0, 2, 4, 5, -1, -1, 2, 
/* 1448 */     -1, 2, -1, 0-1 };
/*      */   
/* 1450 */   static final long[] jjtoToken = {
/* 1451 */     2143284351L };
/*      */   
/* 1453 */   static final long[] jjtoSkip = {
/* 1454 */     4194304L };
/*      */   
/*      */   protected SimpleCharStream input_stream;
/* 1457 */   private final int[] jjrounds = new int[28];
/* 1458 */   private final int[] jjstateSet = new int[56];
/*      */   
/*      */   protected char curChar;
/*      */   
/*      */ 
/* 1463 */   public HTMLParserTokenManager(SimpleCharStream stream) { this.input_stream = stream; }
/*      */   
/*      */   public HTMLParserTokenManager(SimpleCharStream stream, int lexState) {
/* 1466 */     this(stream);
/* 1467 */     SwitchTo(lexState);
/*      */   }
/*      */   
/*      */   public void ReInit(SimpleCharStream stream) {
/* 1471 */     this.jjmatchedPos = (this.jjnewStateCnt = 0);
/* 1472 */     this.curLexState = this.defaultLexState;
/* 1473 */     this.input_stream = stream;
/* 1474 */     ReInitRounds();
/*      */   }
/*      */   
/*      */   private final void ReInitRounds()
/*      */   {
/* 1479 */     this.jjround = -2147483647;
/* 1480 */     for (int i = 28; i-- > 0;)
/* 1481 */       this.jjrounds[i] = Integer.MIN_VALUE;
/*      */   }
/*      */   
/*      */   public void ReInit(SimpleCharStream stream, int lexState) {
/* 1485 */     ReInit(stream);
/* 1486 */     SwitchTo(lexState);
/*      */   }
/*      */   
/*      */   public void SwitchTo(int lexState) {
/* 1490 */     if ((lexState >= 8) || (lexState < 0)) {
/* 1491 */       throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", 2);
/*      */     }
/* 1493 */     this.curLexState = lexState;
/*      */   }
/*      */   
/*      */   protected Token jjFillToken()
/*      */   {
/* 1498 */     Token t = Token.newToken(this.jjmatchedKind);
/* 1499 */     t.kind = this.jjmatchedKind;
/* 1500 */     String im = jjstrLiteralImages[this.jjmatchedKind];
/* 1501 */     t.image = (im == null ? this.input_stream.GetImage() : im);
/* 1502 */     t.beginLine = this.input_stream.getBeginLine();
/* 1503 */     t.beginColumn = this.input_stream.getBeginColumn();
/* 1504 */     t.endLine = this.input_stream.getEndLine();
/* 1505 */     t.endColumn = this.input_stream.getEndColumn();
/* 1506 */     return t;
/*      */   }
/*      */   
/* 1509 */   int curLexState = 0;
/* 1510 */   int defaultLexState = 0;
/*      */   
/*      */   int jjnewStateCnt;
/*      */   int jjround;
/*      */   int jjmatchedPos;
/*      */   int jjmatchedKind;
/*      */   
/*      */   public Token getNextToken()
/*      */   {
/* 1519 */     Token specialToken = null;
/*      */     
/* 1521 */     int curPos = 0;
/*      */     
/*      */ 
/*      */     for (;;)
/*      */     {
/*      */       try
/*      */       {
/* 1528 */         this.curChar = this.input_stream.BeginToken();
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1532 */         this.jjmatchedKind = 0;
/* 1533 */         return jjFillToken();
/*      */       }
/*      */       
/*      */ 
/* 1537 */       switch (this.curLexState)
/*      */       {
/*      */       case 0: 
/* 1540 */         this.jjmatchedKind = Integer.MAX_VALUE;
/* 1541 */         this.jjmatchedPos = 0;
/* 1542 */         curPos = jjMoveStringLiteralDfa0_0();
/* 1543 */         if ((this.jjmatchedPos == 0) && (this.jjmatchedKind > 13))
/*      */         {
/* 1545 */           this.jjmatchedKind = 13;
/*      */         }
/* 1547 */         break;
/*      */       case 1: 
/* 1549 */         this.jjmatchedKind = Integer.MAX_VALUE;
/* 1550 */         this.jjmatchedPos = 0;
/* 1551 */         curPos = jjMoveStringLiteralDfa0_1();
/* 1552 */         break;
/*      */       case 2: 
/* 1554 */         this.jjmatchedKind = Integer.MAX_VALUE;
/* 1555 */         this.jjmatchedPos = 0;
/* 1556 */         curPos = jjMoveStringLiteralDfa0_2();
/* 1557 */         break;
/*      */       case 3: 
/* 1559 */         this.jjmatchedKind = Integer.MAX_VALUE;
/* 1560 */         this.jjmatchedPos = 0;
/* 1561 */         curPos = jjMoveStringLiteralDfa0_3();
/* 1562 */         break;
/*      */       case 4: 
/* 1564 */         this.jjmatchedKind = Integer.MAX_VALUE;
/* 1565 */         this.jjmatchedPos = 0;
/* 1566 */         curPos = jjMoveStringLiteralDfa0_4();
/* 1567 */         break;
/*      */       case 5: 
/* 1569 */         this.jjmatchedKind = Integer.MAX_VALUE;
/* 1570 */         this.jjmatchedPos = 0;
/* 1571 */         curPos = jjMoveStringLiteralDfa0_5();
/* 1572 */         break;
/*      */       case 6: 
/* 1574 */         this.jjmatchedKind = Integer.MAX_VALUE;
/* 1575 */         this.jjmatchedPos = 0;
/* 1576 */         curPos = jjMoveStringLiteralDfa0_6();
/* 1577 */         break;
/*      */       case 7: 
/* 1579 */         this.jjmatchedKind = Integer.MAX_VALUE;
/* 1580 */         this.jjmatchedPos = 0;
/* 1581 */         curPos = jjMoveStringLiteralDfa0_7();
/*      */       }
/*      */       
/* 1584 */       if (this.jjmatchedKind == Integer.MAX_VALUE)
/*      */         break;
/* 1586 */       if (this.jjmatchedPos + 1 < curPos)
/* 1587 */         this.input_stream.backup(curPos - this.jjmatchedPos - 1);
/* 1588 */       if ((jjtoToken[(this.jjmatchedKind >> 6)] & 1L << (this.jjmatchedKind & 0x3F)) != 0L)
/*      */       {
/* 1590 */         Token matchedToken = jjFillToken();
/* 1591 */         if (jjnewLexState[this.jjmatchedKind] != -1)
/* 1592 */           this.curLexState = jjnewLexState[this.jjmatchedKind];
/* 1593 */         return matchedToken;
/*      */       }
/*      */       
/*      */ 
/* 1597 */       if (jjnewLexState[this.jjmatchedKind] != -1) {
/* 1598 */         this.curLexState = jjnewLexState[this.jjmatchedKind];
/*      */       }
/*      */     }
/*      */     
/* 1602 */     int error_line = this.input_stream.getEndLine();
/* 1603 */     int error_column = this.input_stream.getEndColumn();
/* 1604 */     String error_after = null;
/* 1605 */     boolean EOFSeen = false;
/* 1606 */     try { this.input_stream.readChar();this.input_stream.backup(1);
/*      */     } catch (IOException e1) {
/* 1608 */       EOFSeen = true;
/* 1609 */       error_after = curPos <= 1 ? "" : this.input_stream.GetImage();
/* 1610 */       if ((this.curChar == '\n') || (this.curChar == '\r')) {
/* 1611 */         error_line++;
/* 1612 */         error_column = 0;
/*      */       }
/*      */       else {
/* 1615 */         error_column++;
/*      */       } }
/* 1617 */     if (!EOFSeen) {
/* 1618 */       this.input_stream.backup(1);
/* 1619 */       error_after = curPos <= 1 ? "" : this.input_stream.GetImage();
/*      */     }
/* 1621 */     throw new TokenMgrError(EOFSeen, this.curLexState, error_line, error_column, error_after, this.curChar, 0);
/*      */   }
/*      */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\lucene\html\HTMLParserTokenManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */