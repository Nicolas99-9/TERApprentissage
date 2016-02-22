/*     */ package org.textbug.lucene.html;
/*     */ 
/*     */ import java.io.IOException;
/*     */ 
/*     */ public class HTMLParser implements HTMLParserConstants { static final class JJCalls { int gen;
/*     */     Token first;
/*     */     int arg; JJCalls next; }
/*   8 */   public static int SUMMARY_LENGTH = 200;
/*     */   
/*  10 */   StringBuffer title = new StringBuffer(SUMMARY_LENGTH);
/*  11 */   StringBuffer summary = new StringBuffer(SUMMARY_LENGTH * 2);
/*  12 */   java.util.Properties metaTags = new java.util.Properties();
/*  13 */   String currentMetaTag = null;
/*  14 */   String currentMetaContent = null;
/*  15 */   int length = 0;
/*  16 */   boolean titleComplete = false;
/*  17 */   boolean inTitle = false;
/*  18 */   boolean inMetaTag = false;
/*  19 */   boolean inStyle = false;
/*  20 */   boolean afterTag = false;
/*  21 */   boolean afterSpace = false;
/*  22 */   String eol = System.getProperty("line.separator");
/*  23 */   java.io.Reader pipeIn = null;
/*     */   java.io.Writer pipeOut;
/*  25 */   private MyPipedInputStream pipeInStream = null;
/*  26 */   private java.io.PipedOutputStream pipeOutStream = null;
/*     */   
/*     */   private static final class LookaheadSuccess extends Error
/*     */   {}
/*     */   
/*     */   private class MyPipedInputStream extends java.io.PipedInputStream {
/*     */     public MyPipedInputStream() {}
/*     */     
/*     */     public MyPipedInputStream(java.io.PipedOutputStream src) throws IOException {
/*  35 */       super();
/*     */     }
/*     */     
/*     */     public boolean full() throws IOException {
/*  39 */       return available() >= 1024;
/*     */     }
/*     */   }
/*     */   
/*     */   /**
/*     */    * @deprecated
/*     */    */
/*     */   public HTMLParser(java.io.File file) throws java.io.FileNotFoundException {
/*  47 */     this(new java.io.FileInputStream(file));
/*     */   }
/*     */   
/*     */   public String getTitle() throws IOException, InterruptedException {
/*  51 */     if (this.pipeIn == null) {
/*  52 */       getReader();
/*     */     }
/*  54 */     synchronized (this) {
/*  55 */       if ((this.titleComplete) || (!this.pipeInStream.full()))
/*     */       {
/*  57 */         wait(10L);
/*     */       }
/*     */     }
/*  60 */     return this.title.toString().trim();
/*     */   }
/*     */   
/*     */   public java.util.Properties getMetaTags() throws IOException, InterruptedException
/*     */   {
/*  65 */     if (this.pipeIn == null) {
/*  66 */       getReader();
/*     */     }
/*  68 */     synchronized (this) {
/*  69 */       if ((this.titleComplete) || (!this.pipeInStream.full()))
/*     */       {
/*  71 */         wait(10L);
/*     */       }
/*     */     }
/*  74 */     return this.metaTags;
/*     */   }
/*     */   
/*     */   public String getSummary() throws IOException, InterruptedException
/*     */   {
/*  79 */     if (this.pipeIn == null) {
/*  80 */       getReader();
/*     */     }
/*  82 */     synchronized (this) {
/*  83 */       if ((this.summary.length() >= SUMMARY_LENGTH) || (!this.pipeInStream.full()))
/*     */       {
/*  85 */         wait(10L);
/*     */       }
/*     */     }
/*  88 */     if (this.summary.length() > SUMMARY_LENGTH) {
/*  89 */       this.summary.setLength(SUMMARY_LENGTH);
/*     */     }
/*  91 */     String sum = this.summary.toString().trim();
/*  92 */     String tit = getTitle();
/*  93 */     if ((sum.startsWith(tit)) || (sum.equals(""))) {
/*  94 */       return tit;
/*     */     }
/*  96 */     return sum;
/*     */   }
/*     */   
/*     */   public java.io.Reader getReader() throws IOException {
/* 100 */     if (this.pipeIn == null) {
/* 101 */       this.pipeInStream = new MyPipedInputStream();
/* 102 */       this.pipeOutStream = new java.io.PipedOutputStream(this.pipeInStream);
/* 103 */       this.pipeIn = new java.io.InputStreamReader(this.pipeInStream, "UTF-16BE");
/* 104 */       this.pipeOut = new java.io.OutputStreamWriter(this.pipeOutStream, "UTF-16BE");
/*     */       
/* 106 */       Thread thread = new ParserThread(this);
/* 107 */       thread.start();
/*     */     }
/*     */     
/* 110 */     return this.pipeIn;
/*     */   }
/*     */   
/*     */   void addToSummary(String text) {
/* 114 */     if (this.summary.length() < SUMMARY_LENGTH) {
/* 115 */       this.summary.append(text);
/* 116 */       if (this.summary.length() >= SUMMARY_LENGTH) {
/* 117 */         synchronized (this) {
/* 118 */           notifyAll();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void addText(String text) throws IOException {
/* 125 */     if (this.inStyle)
/* 126 */       return;
/* 127 */     if (this.inTitle) {
/* 128 */       this.title.append(text);
/*     */     } else {
/* 130 */       addToSummary(text);
/* 131 */       if ((!this.titleComplete) && (!this.title.equals(""))) {
/* 132 */         synchronized (this) {
/* 133 */           this.titleComplete = true;
/* 134 */           notifyAll();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 139 */     this.length += text.length();
/* 140 */     this.pipeOut.write(text);
/*     */     
/* 142 */     this.afterSpace = false;
/*     */   }
/*     */   
/*     */   void addMetaTag() {
/* 146 */     this.metaTags.setProperty(this.currentMetaTag, this.currentMetaContent);
/* 147 */     this.currentMetaTag = null;
/* 148 */     this.currentMetaContent = null;
/*     */   }
/*     */   
/*     */   void addSpace() throws IOException
/*     */   {
/* 153 */     if (!this.afterSpace) {
/* 154 */       if (this.inTitle) {
/* 155 */         this.title.append(" ");
/*     */       } else {
/* 157 */         addToSummary(" ");
/*     */       }
/* 159 */       String space = this.afterTag ? this.eol : " ";
/* 160 */       this.length += space.length();
/* 161 */       this.pipeOut.write(space);
/* 162 */       this.afterSpace = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public final void HTMLDocument() throws ParseException, IOException
/*     */   {
/*     */     for (;;)
/*     */     {
/* 170 */       switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
/*     */       case 1: case 2: 
/*     */       case 3: 
/*     */       case 4: 
/*     */       case 5: 
/*     */       case 6: 
/*     */       case 10: 
/*     */       case 11: 
/*     */       case 13: 
/*     */         break;
/*     */       case 7: case 8: 
/*     */       case 9: case 12: 
/*     */       default: 
/* 183 */         this.jj_la1[0] = this.jj_gen;
/* 184 */         break;
/*     */       }
/* 186 */       switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
/*     */       case 2: 
/* 188 */         Tag();
/* 189 */         this.afterTag = true;
/* 190 */         break;
/*     */       case 3: 
/* 192 */         Token t = Decl();
/* 193 */         this.afterTag = true;
/* 194 */         break;
/*     */       case 4: 
/*     */       case 5: 
/* 197 */         CommentTag();
/* 198 */         this.afterTag = true;
/* 199 */         break;
/*     */       case 1: 
/* 201 */         ScriptTag();
/* 202 */         this.afterTag = true;
/* 203 */         break;
/*     */       case 6: 
/* 205 */         Token t = jj_consume_token(6);
/* 206 */         addText(t.image);this.afterTag = false;
/* 207 */         break;
/*     */       case 10: 
/* 209 */         Token t = jj_consume_token(10);
/* 210 */         addText(Entities.decode(t.image));this.afterTag = false;
/* 211 */         break;
/*     */       case 13: 
/* 213 */         Token t = jj_consume_token(13);
/* 214 */         addText(t.image);this.afterTag = false;
/* 215 */         break;
/*     */       case 11: 
/* 217 */         jj_consume_token(11);
/* 218 */         addSpace();this.afterTag = false;
/*     */       }
/*     */     }
/* 221 */     this.jj_la1[1] = this.jj_gen;
/* 222 */     jj_consume_token(-1);
/* 223 */     throw new ParseException();
/*     */     
/*     */ 
/* 226 */     jj_consume_token(0);
/*     */   }
/*     */   
/*     */   public final void Tag() throws ParseException, IOException
/*     */   {
/* 231 */     boolean inImg = false;
/* 232 */     Token t1 = jj_consume_token(2);
/* 233 */     String tagName = t1.image.toLowerCase();
/* 234 */     if (Tags.WS_ELEMS.contains(tagName)) {
/* 235 */       addSpace();
/*     */     }
/* 237 */     this.inTitle = tagName.equalsIgnoreCase("<title");
/* 238 */     this.inMetaTag = tagName.equalsIgnoreCase("<META");
/* 239 */     this.inStyle = tagName.equalsIgnoreCase("<STYLE");
/* 240 */     inImg = tagName.equalsIgnoreCase("<img");
/*     */     
/*     */     for (;;)
/*     */     {
/* 244 */       switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk)
/*     */       {
/*     */       case 16: 
/*     */         break;
/*     */       default: 
/* 249 */         this.jj_la1[2] = this.jj_gen;
/* 250 */         break;
/*     */       }
/* 252 */       t1 = jj_consume_token(16);
/* 253 */       switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
/*     */       case 17: 
/* 255 */         jj_consume_token(17);
/* 256 */         switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
/*     */         case 19: 
/*     */         case 20: 
/*     */         case 21: 
/* 260 */           Token t2 = ArgValue();
/* 261 */           if ((inImg) && (t1.image.equalsIgnoreCase("alt")) && (t2 != null)) {
/* 262 */             addText("[" + t2.image + "]");
/*     */           }
/* 264 */           if ((this.inMetaTag) && (
/* 265 */             (t1.image.equalsIgnoreCase("name")) || 
/* 266 */             (t1.image.equalsIgnoreCase("HTTP-EQUIV"))))
/*     */           {
/* 268 */             if (t2 != null)
/*     */             {
/* 270 */               this.currentMetaTag = t2.image.toLowerCase();
/* 271 */               if ((this.currentMetaTag != null) && (this.currentMetaContent != null))
/* 272 */                 addMetaTag();
/*     */             }
/*     */           }
/* 275 */           if ((this.inMetaTag) && (t1.image.equalsIgnoreCase("content")) && (t2 != null))
/*     */           {
/*     */ 
/* 278 */             this.currentMetaContent = t2.image.toLowerCase();
/* 279 */             if ((this.currentMetaTag != null) && (this.currentMetaContent != null)) {
/* 280 */               addMetaTag();
/*     */             }
/*     */           }
/* 283 */           break;
/*     */         default: 
/* 285 */           this.jj_la1[3] = this.jj_gen;
/*     */         }
/*     */         
/* 288 */         break;
/*     */       default: 
/* 290 */         this.jj_la1[4] = this.jj_gen;
/*     */       }
/*     */       
/*     */     }
/* 294 */     jj_consume_token(18);
/*     */   }
/*     */   
/*     */   public final Token ArgValue() throws ParseException {
/* 298 */     Token t = null;
/* 299 */     switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
/*     */     case 19: 
/* 301 */       t = jj_consume_token(19);
/* 302 */       return t;
/*     */     }
/*     */     
/* 305 */     this.jj_la1[5] = this.jj_gen;
/* 306 */     if (jj_2_1(2)) {
/* 307 */       jj_consume_token(20);
/* 308 */       jj_consume_token(24);
/* 309 */       return t;
/*     */     }
/* 311 */     switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
/*     */     case 20: 
/* 313 */       jj_consume_token(20);
/* 314 */       t = jj_consume_token(23);
/* 315 */       jj_consume_token(24);
/* 316 */       return t;
/*     */     }
/*     */     
/* 319 */     this.jj_la1[6] = this.jj_gen;
/* 320 */     if (jj_2_2(2)) {
/* 321 */       jj_consume_token(21);
/* 322 */       jj_consume_token(26);
/* 323 */       return t;
/*     */     }
/* 325 */     switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
/*     */     case 21: 
/* 327 */       jj_consume_token(21);
/* 328 */       t = jj_consume_token(25);
/* 329 */       jj_consume_token(26);
/* 330 */       return t;
/*     */     }
/*     */     
/* 333 */     this.jj_la1[7] = this.jj_gen;
/* 334 */     jj_consume_token(-1);
/* 335 */     throw new ParseException();
/*     */   }
/*     */   
/*     */ 
/*     */   public HTMLParserTokenManager token_source;
/*     */   SimpleCharStream jj_input_stream;
/*     */   public Token token;
/*     */   public Token jj_nt;
/*     */   public final Token Decl()
/*     */     throws ParseException
/*     */   {
/* 346 */     Token t = jj_consume_token(3);
/*     */     for (;;)
/*     */     {
/* 349 */       switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
/*     */       case 16: 
/*     */       case 17: 
/*     */       case 19: 
/*     */       case 20: 
/*     */       case 21: 
/*     */         break;
/*     */       case 18: 
/*     */       default: 
/* 358 */         this.jj_la1[8] = this.jj_gen;
/* 359 */         break;
/*     */       }
/* 361 */       switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
/*     */       case 16: 
/* 363 */         jj_consume_token(16);
/* 364 */         break;
/*     */       case 19: 
/*     */       case 20: 
/*     */       case 21: 
/* 368 */         ArgValue();
/* 369 */         break;
/*     */       case 17: 
/* 371 */         jj_consume_token(17);
/*     */       }
/*     */     }
/* 374 */     this.jj_la1[9] = this.jj_gen;
/* 375 */     jj_consume_token(-1);
/* 376 */     throw new ParseException();
/*     */     
/*     */ 
/* 379 */     jj_consume_token(18);
/* 380 */     return t;
/*     */   }
/*     */   
/*     */   public final void CommentTag() throws ParseException
/*     */   {
/* 385 */     switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
/*     */     case 4: 
/* 387 */       jj_consume_token(4);
/*     */       for (;;)
/*     */       {
/* 390 */         switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk)
/*     */         {
/*     */         case 27: 
/*     */           break;
/*     */         default: 
/* 395 */           this.jj_la1[10] = this.jj_gen;
/* 396 */           break;
/*     */         }
/* 398 */         jj_consume_token(27);
/*     */       }
/* 400 */       jj_consume_token(28);
/* 401 */       break;
/*     */     case 5: 
/* 403 */       jj_consume_token(5);
/*     */       for (;;)
/*     */       {
/* 406 */         switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk)
/*     */         {
/*     */         case 29: 
/*     */           break;
/*     */         default: 
/* 411 */           this.jj_la1[11] = this.jj_gen;
/* 412 */           break;
/*     */         }
/* 414 */         jj_consume_token(29);
/*     */       }
/* 416 */       jj_consume_token(30);
/* 417 */       break;
/*     */     default: 
/* 419 */       this.jj_la1[12] = this.jj_gen;
/* 420 */       jj_consume_token(-1);
/* 421 */       throw new ParseException();
/*     */     }
/*     */   }
/*     */   
/*     */   public final void ScriptTag() throws ParseException {
/* 426 */     jj_consume_token(1);
/*     */     for (;;)
/*     */     {
/* 429 */       switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk)
/*     */       {
/*     */       case 14: 
/*     */         break;
/*     */       default: 
/* 434 */         this.jj_la1[13] = this.jj_gen;
/* 435 */         break;
/*     */       }
/* 437 */       jj_consume_token(14);
/*     */     }
/* 439 */     jj_consume_token(15);
/*     */   }
/*     */   
/*     */   private final boolean jj_2_1(int xla) {
/* 443 */     this.jj_la = xla;this.jj_lastpos = (this.jj_scanpos = this.token);
/* 444 */     try { return !jj_3_1();
/* 445 */     } catch (LookaheadSuccess ls) { return true;
/* 446 */     } finally { jj_save(0, xla);
/*     */     }
/*     */   }
/*     */   
/* 450 */   private final boolean jj_2_2(int xla) { this.jj_la = xla;this.jj_lastpos = (this.jj_scanpos = this.token);
/* 451 */     try { return !jj_3_2();
/* 452 */     } catch (LookaheadSuccess ls) { return true;
/* 453 */     } finally { jj_save(1, xla);
/*     */     }
/*     */   }
/*     */   
/* 457 */   private final boolean jj_3_1() { if (jj_scan_token(20)) return true;
/* 458 */     if (jj_scan_token(24)) return true;
/* 459 */     return false;
/*     */   }
/*     */   
/*     */   private final boolean jj_3_2() {
/* 463 */     if (jj_scan_token(21)) return true;
/* 464 */     if (jj_scan_token(26)) return true;
/* 465 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private int jj_ntk;
/*     */   
/*     */   private Token jj_scanpos;
/*     */   private Token jj_lastpos;
/*     */   private int jj_la;
/* 474 */   public boolean lookingAhead = false;
/*     */   private boolean jj_semLA;
/*     */   private int jj_gen;
/* 477 */   private final int[] jj_la1 = new int[14];
/*     */   private static int[] jj_la1_0;
/*     */   
/* 480 */   static { jj_la1_0(); }
/*     */   
/*     */ 
/* 483 */   private static void jj_la1_0() { jj_la1_0 = new int[] { 11390, 11390, 65536, 3670016, 131072, 524288, 1048576, 2097152, 3866624, 3866624, 134217728, 536870912, 48, 16384 }; }
/*     */   
/* 485 */   private final JJCalls[] jj_2_rtns = new JJCalls[2];
/* 486 */   private boolean jj_rescan = false;
/* 487 */   private int jj_gc = 0;
/*     */   
/*     */ 
/* 490 */   public HTMLParser(java.io.InputStream stream) { this(stream, null); }
/*     */   
/*     */   public HTMLParser(java.io.InputStream stream, String encoding) {
/* 493 */     try { this.jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch (java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
/* 494 */     this.token_source = new HTMLParserTokenManager(this.jj_input_stream);
/* 495 */     this.token = new Token();
/* 496 */     this.jj_ntk = -1;
/* 497 */     this.jj_gen = 0;
/* 498 */     for (int i = 0; i < 14; i++) this.jj_la1[i] = -1;
/* 499 */     for (int i = 0; i < this.jj_2_rtns.length; i++) { this.jj_2_rtns[i] = new JJCalls();
/*     */     }
/*     */   }
/*     */   
/* 503 */   public void ReInit(java.io.InputStream stream) { ReInit(stream, null); }
/*     */   
/*     */   public void ReInit(java.io.InputStream stream, String encoding) {
/* 506 */     try { this.jj_input_stream.ReInit(stream, encoding, 1, 1); } catch (java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
/* 507 */     this.token_source.ReInit(this.jj_input_stream);
/* 508 */     this.token = new Token();
/* 509 */     this.jj_ntk = -1;
/* 510 */     this.jj_gen = 0;
/* 511 */     for (int i = 0; i < 14; i++) this.jj_la1[i] = -1;
/* 512 */     for (int i = 0; i < this.jj_2_rtns.length; i++) this.jj_2_rtns[i] = new JJCalls();
/*     */   }
/*     */   
/*     */   public HTMLParser(java.io.Reader stream) {
/* 516 */     this.jj_input_stream = new SimpleCharStream(stream, 1, 1);
/* 517 */     this.token_source = new HTMLParserTokenManager(this.jj_input_stream);
/* 518 */     this.token = new Token();
/* 519 */     this.jj_ntk = -1;
/* 520 */     this.jj_gen = 0;
/* 521 */     for (int i = 0; i < 14; i++) this.jj_la1[i] = -1;
/* 522 */     for (int i = 0; i < this.jj_2_rtns.length; i++) this.jj_2_rtns[i] = new JJCalls();
/*     */   }
/*     */   
/*     */   public void ReInit(java.io.Reader stream) {
/* 526 */     this.jj_input_stream.ReInit(stream, 1, 1);
/* 527 */     this.token_source.ReInit(this.jj_input_stream);
/* 528 */     this.token = new Token();
/* 529 */     this.jj_ntk = -1;
/* 530 */     this.jj_gen = 0;
/* 531 */     for (int i = 0; i < 14; i++) this.jj_la1[i] = -1;
/* 532 */     for (int i = 0; i < this.jj_2_rtns.length; i++) this.jj_2_rtns[i] = new JJCalls();
/*     */   }
/*     */   
/*     */   public HTMLParser(HTMLParserTokenManager tm) {
/* 536 */     this.token_source = tm;
/* 537 */     this.token = new Token();
/* 538 */     this.jj_ntk = -1;
/* 539 */     this.jj_gen = 0;
/* 540 */     for (int i = 0; i < 14; i++) this.jj_la1[i] = -1;
/* 541 */     for (int i = 0; i < this.jj_2_rtns.length; i++) this.jj_2_rtns[i] = new JJCalls();
/*     */   }
/*     */   
/*     */   public void ReInit(HTMLParserTokenManager tm) {
/* 545 */     this.token_source = tm;
/* 546 */     this.token = new Token();
/* 547 */     this.jj_ntk = -1;
/* 548 */     this.jj_gen = 0;
/* 549 */     for (int i = 0; i < 14; i++) this.jj_la1[i] = -1;
/* 550 */     for (int i = 0; i < this.jj_2_rtns.length; i++) this.jj_2_rtns[i] = new JJCalls();
/*     */   }
/*     */   
/*     */   private final Token jj_consume_token(int kind) throws ParseException {
/*     */     Token oldToken;
/* 555 */     if ((oldToken = this.token).next != null) this.token = this.token.next; else
/* 556 */       this.token = (this.token.next = this.token_source.getNextToken());
/* 557 */     this.jj_ntk = -1;
/* 558 */     if (this.token.kind == kind) {
/* 559 */       this.jj_gen += 1;
/* 560 */       if (++this.jj_gc > 100) {
/* 561 */         this.jj_gc = 0;
/* 562 */         for (int i = 0; i < this.jj_2_rtns.length; i++) {
/* 563 */           JJCalls c = this.jj_2_rtns[i];
/* 564 */           while (c != null) {
/* 565 */             if (c.gen < this.jj_gen) c.first = null;
/* 566 */             c = c.next;
/*     */           }
/*     */         }
/*     */       }
/* 570 */       return this.token;
/*     */     }
/* 572 */     this.token = oldToken;
/* 573 */     this.jj_kind = kind;
/* 574 */     throw generateParseException();
/*     */   }
/*     */   
/*     */ 
/* 578 */   private final LookaheadSuccess jj_ls = new LookaheadSuccess(null);
/*     */   
/* 580 */   private final boolean jj_scan_token(int kind) { if (this.jj_scanpos == this.jj_lastpos) {
/* 581 */       this.jj_la -= 1;
/* 582 */       if (this.jj_scanpos.next == null) {
/* 583 */         this.jj_lastpos = (this.jj_scanpos = this.jj_scanpos.next = this.token_source.getNextToken());
/*     */       } else {
/* 585 */         this.jj_lastpos = (this.jj_scanpos = this.jj_scanpos.next);
/*     */       }
/*     */     } else {
/* 588 */       this.jj_scanpos = this.jj_scanpos.next;
/*     */     }
/* 590 */     if (this.jj_rescan) {
/* 591 */       int i = 0; for (Token tok = this.token; 
/* 592 */           (tok != null) && (tok != this.jj_scanpos); tok = tok.next) i++;
/* 593 */       if (tok != null) jj_add_error_token(kind, i);
/*     */     }
/* 595 */     if (this.jj_scanpos.kind != kind) return true;
/* 596 */     if ((this.jj_la == 0) && (this.jj_scanpos == this.jj_lastpos)) throw this.jj_ls;
/* 597 */     return false;
/*     */   }
/*     */   
/*     */   public final Token getNextToken() {
/* 601 */     if (this.token.next != null) this.token = this.token.next; else
/* 602 */       this.token = (this.token.next = this.token_source.getNextToken());
/* 603 */     this.jj_ntk = -1;
/* 604 */     this.jj_gen += 1;
/* 605 */     return this.token;
/*     */   }
/*     */   
/*     */   public final Token getToken(int index) {
/* 609 */     Token t = this.lookingAhead ? this.jj_scanpos : this.token;
/* 610 */     for (int i = 0; i < index; i++) {
/* 611 */       if (t.next != null) t = t.next; else
/* 612 */         t = t.next = this.token_source.getNextToken();
/*     */     }
/* 614 */     return t;
/*     */   }
/*     */   
/*     */   private final int jj_ntk() {
/* 618 */     if ((this.jj_nt = this.token.next) == null) {
/* 619 */       return this.jj_ntk = (this.token.next = this.token_source.getNextToken()).kind;
/*     */     }
/* 621 */     return this.jj_ntk = this.jj_nt.kind;
/*     */   }
/*     */   
/* 624 */   private java.util.Vector jj_expentries = new java.util.Vector();
/*     */   private int[] jj_expentry;
/* 626 */   private int jj_kind = -1;
/* 627 */   private int[] jj_lasttokens = new int[100];
/*     */   private int jj_endpos;
/*     */   
/*     */   private void jj_add_error_token(int kind, int pos) {
/* 631 */     if (pos >= 100) return;
/* 632 */     if (pos == this.jj_endpos + 1) {
/* 633 */       this.jj_lasttokens[(this.jj_endpos++)] = kind;
/* 634 */     } else if (this.jj_endpos != 0) {
/* 635 */       this.jj_expentry = new int[this.jj_endpos];
/* 636 */       for (int i = 0; i < this.jj_endpos; i++) {
/* 637 */         this.jj_expentry[i] = this.jj_lasttokens[i];
/*     */       }
/* 639 */       boolean exists = false;
/* 640 */       for (java.util.Enumeration e = this.jj_expentries.elements(); e.hasMoreElements();) {
/* 641 */         int[] oldentry = (int[])e.nextElement();
/* 642 */         if (oldentry.length == this.jj_expentry.length) {
/* 643 */           exists = true;
/* 644 */           for (int i = 0; i < this.jj_expentry.length; i++) {
/* 645 */             if (oldentry[i] != this.jj_expentry[i]) {
/* 646 */               exists = false;
/* 647 */               break;
/*     */             }
/*     */           }
/* 650 */           if (exists) break;
/*     */         }
/*     */       }
/* 653 */       if (!exists) this.jj_expentries.addElement(this.jj_expentry);
/* 654 */       if (pos != 0) this.jj_lasttokens[((this.jj_endpos = pos) - 1)] = kind;
/*     */     }
/*     */   }
/*     */   
/*     */   public ParseException generateParseException() {
/* 659 */     this.jj_expentries.removeAllElements();
/* 660 */     boolean[] la1tokens = new boolean[31];
/* 661 */     for (int i = 0; i < 31; i++) {
/* 662 */       la1tokens[i] = false;
/*     */     }
/* 664 */     if (this.jj_kind >= 0) {
/* 665 */       la1tokens[this.jj_kind] = true;
/* 666 */       this.jj_kind = -1;
/*     */     }
/* 668 */     for (int i = 0; i < 14; i++) {
/* 669 */       if (this.jj_la1[i] == this.jj_gen) {
/* 670 */         for (int j = 0; j < 32; j++) {
/* 671 */           if ((jj_la1_0[i] & 1 << j) != 0) {
/* 672 */             la1tokens[j] = true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 677 */     for (int i = 0; i < 31; i++) {
/* 678 */       if (la1tokens[i] != 0) {
/* 679 */         this.jj_expentry = new int[1];
/* 680 */         this.jj_expentry[0] = i;
/* 681 */         this.jj_expentries.addElement(this.jj_expentry);
/*     */       }
/*     */     }
/* 684 */     this.jj_endpos = 0;
/* 685 */     jj_rescan_token();
/* 686 */     jj_add_error_token(0, 0);
/* 687 */     int[][] exptokseq = new int[this.jj_expentries.size()][];
/* 688 */     for (int i = 0; i < this.jj_expentries.size(); i++) {
/* 689 */       exptokseq[i] = ((int[])this.jj_expentries.elementAt(i));
/*     */     }
/* 691 */     return new ParseException(this.token, exptokseq, tokenImage);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private final void jj_rescan_token()
/*     */   {
/* 701 */     this.jj_rescan = true;
/* 702 */     for (int i = 0; i < 2; i++) {
/*     */       try {
/* 704 */         JJCalls p = this.jj_2_rtns[i];
/*     */         do {
/* 706 */           if (p.gen > this.jj_gen) {
/* 707 */             this.jj_la = p.arg;this.jj_lastpos = (this.jj_scanpos = p.first);
/* 708 */             switch (i) {
/* 709 */             case 0:  jj_3_1(); break;
/* 710 */             case 1:  jj_3_2();
/*     */             }
/*     */           }
/* 713 */           p = p.next;
/* 714 */         } while (p != null);
/*     */       } catch (LookaheadSuccess localLookaheadSuccess) {}
/*     */     }
/* 717 */     this.jj_rescan = false;
/*     */   }
/*     */   
/*     */   private final void jj_save(int index, int xla) {
/* 721 */     JJCalls p = this.jj_2_rtns[index];
/* 722 */     while (p.gen > this.jj_gen) {
/* 723 */       if (p.next == null) { p = p.next = new JJCalls(); break; }
/* 724 */       p = p.next;
/*     */     }
/* 726 */     p.gen = (this.jj_gen + xla - this.jj_la);p.first = this.token;p.arg = xla;
/*     */   }
/*     */   
/*     */   public final void enable_tracing() {}
/*     */   
/*     */   public final void disable_tracing() {}
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\lucene\html\HTMLParser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */