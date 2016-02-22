/*     */ package org.tartarus.snowball;
/*     */ 
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ 
/*     */ public class SnowballProgram {
/*     */   protected StringBuffer current;
/*     */   
/*   8 */   protected SnowballProgram() { this.current = new StringBuffer();
/*   9 */     setCurrent("");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCurrent(String value)
/*     */   {
/*  17 */     this.current.replace(0, this.current.length(), value);
/*  18 */     this.cursor = 0;
/*  19 */     this.limit = this.current.length();
/*  20 */     this.limit_backward = 0;
/*  21 */     this.bra = this.cursor;
/*  22 */     this.ket = this.limit;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getCurrent()
/*     */   {
/*  30 */     String result = this.current.toString();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  37 */     this.current = new StringBuffer();
/*  38 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   protected int cursor;
/*     */   
/*     */   protected int limit;
/*     */   
/*     */   protected int limit_backward;
/*     */   
/*     */   protected int bra;
/*     */   protected int ket;
/*     */   protected void copy_from(SnowballProgram other)
/*     */   {
/*  52 */     this.current = other.current;
/*  53 */     this.cursor = other.cursor;
/*  54 */     this.limit = other.limit;
/*  55 */     this.limit_backward = other.limit_backward;
/*  56 */     this.bra = other.bra;
/*  57 */     this.ket = other.ket;
/*     */   }
/*     */   
/*     */   protected boolean in_grouping(char[] s, int min, int max)
/*     */   {
/*  62 */     if (this.cursor >= this.limit) return false;
/*  63 */     char ch = this.current.charAt(this.cursor);
/*  64 */     if ((ch > max) || (ch < min)) return false;
/*  65 */     ch = (char)(ch - min);
/*  66 */     if ((s[(ch >> '\003')] & '\001' << (ch & 0x7)) == 0) return false;
/*  67 */     this.cursor += 1;
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean in_grouping_b(char[] s, int min, int max)
/*     */   {
/*  73 */     if (this.cursor <= this.limit_backward) return false;
/*  74 */     char ch = this.current.charAt(this.cursor - 1);
/*  75 */     if ((ch > max) || (ch < min)) return false;
/*  76 */     ch = (char)(ch - min);
/*  77 */     if ((s[(ch >> '\003')] & '\001' << (ch & 0x7)) == 0) return false;
/*  78 */     this.cursor -= 1;
/*  79 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean out_grouping(char[] s, int min, int max)
/*     */   {
/*  84 */     if (this.cursor >= this.limit) return false;
/*  85 */     char ch = this.current.charAt(this.cursor);
/*  86 */     if ((ch > max) || (ch < min)) {
/*  87 */       this.cursor += 1;
/*  88 */       return true;
/*     */     }
/*  90 */     ch = (char)(ch - min);
/*  91 */     if ((s[(ch >> '\003')] & '\001' << (ch & 0x7)) == 0) {
/*  92 */       this.cursor += 1;
/*  93 */       return true;
/*     */     }
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean out_grouping_b(char[] s, int min, int max)
/*     */   {
/* 100 */     if (this.cursor <= this.limit_backward) return false;
/* 101 */     char ch = this.current.charAt(this.cursor - 1);
/* 102 */     if ((ch > max) || (ch < min)) {
/* 103 */       this.cursor -= 1;
/* 104 */       return true;
/*     */     }
/* 106 */     ch = (char)(ch - min);
/* 107 */     if ((s[(ch >> '\003')] & '\001' << (ch & 0x7)) == 0) {
/* 108 */       this.cursor -= 1;
/* 109 */       return true;
/*     */     }
/* 111 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean in_range(int min, int max)
/*     */   {
/* 116 */     if (this.cursor >= this.limit) return false;
/* 117 */     char ch = this.current.charAt(this.cursor);
/* 118 */     if ((ch > max) || (ch < min)) return false;
/* 119 */     this.cursor += 1;
/* 120 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean in_range_b(int min, int max)
/*     */   {
/* 125 */     if (this.cursor <= this.limit_backward) return false;
/* 126 */     char ch = this.current.charAt(this.cursor - 1);
/* 127 */     if ((ch > max) || (ch < min)) return false;
/* 128 */     this.cursor -= 1;
/* 129 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean out_range(int min, int max)
/*     */   {
/* 134 */     if (this.cursor >= this.limit) return false;
/* 135 */     char ch = this.current.charAt(this.cursor);
/* 136 */     if ((ch <= max) && (ch >= min)) return false;
/* 137 */     this.cursor += 1;
/* 138 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean out_range_b(int min, int max)
/*     */   {
/* 143 */     if (this.cursor <= this.limit_backward) return false;
/* 144 */     char ch = this.current.charAt(this.cursor - 1);
/* 145 */     if ((ch <= max) && (ch >= min)) return false;
/* 146 */     this.cursor -= 1;
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean eq_s(int s_size, String s)
/*     */   {
/* 152 */     if (this.limit - this.cursor < s_size) { return false;
/*     */     }
/* 154 */     for (int i = 0; i != s_size; i++) {
/* 155 */       if (this.current.charAt(this.cursor + i) != s.charAt(i)) return false;
/*     */     }
/* 157 */     this.cursor += s_size;
/* 158 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean eq_s_b(int s_size, String s)
/*     */   {
/* 163 */     if (this.cursor - this.limit_backward < s_size) { return false;
/*     */     }
/* 165 */     for (int i = 0; i != s_size; i++) {
/* 166 */       if (this.current.charAt(this.cursor - s_size + i) != s.charAt(i)) return false;
/*     */     }
/* 168 */     this.cursor -= s_size;
/* 169 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean eq_v(CharSequence s)
/*     */   {
/* 174 */     return eq_s(s.length(), s.toString());
/*     */   }
/*     */   
/*     */   protected boolean eq_v_b(CharSequence s) {
/* 178 */     return eq_s_b(s.length(), s.toString());
/*     */   }
/*     */   
/*     */   protected int find_among(Among[] v, int v_size)
/*     */   {
/* 183 */     int i = 0;
/* 184 */     int j = v_size;
/*     */     
/* 186 */     int c = this.cursor;
/* 187 */     int l = this.limit;
/*     */     
/* 189 */     int common_i = 0;
/* 190 */     int common_j = 0;
/*     */     
/* 192 */     boolean first_key_inspected = false;
/*     */     for (;;)
/*     */     {
/* 195 */       int k = i + (j - i >> 1);
/* 196 */       int diff = 0;
/* 197 */       int common = common_i < common_j ? common_i : common_j;
/* 198 */       Among w = v[k];
/*     */       
/* 200 */       for (int i2 = common; i2 < w.s_size; i2++) {
/* 201 */         if (c + common == l) {
/* 202 */           diff = -1;
/* 203 */           break;
/*     */         }
/* 205 */         diff = this.current.charAt(c + common) - w.s[i2];
/* 206 */         if (diff != 0) break;
/* 207 */         common++;
/*     */       }
/* 209 */       if (diff < 0) {
/* 210 */         j = k;
/* 211 */         common_j = common;
/*     */       } else {
/* 213 */         i = k;
/* 214 */         common_i = common;
/*     */       }
/* 216 */       if (j - i <= 1) {
/* 217 */         if ((i > 0) || 
/* 218 */           (j == i)) {
/*     */           break;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 224 */         if (first_key_inspected) break;
/* 225 */         first_key_inspected = true;
/*     */       }
/*     */     }
/*     */     do {
/* 229 */       Among w = v[i];
/* 230 */       if (common_i >= w.s_size) {
/* 231 */         this.cursor = (c + w.s_size);
/* 232 */         if (w.method == null) return w.result;
/*     */         boolean res;
/*     */         try {
/* 235 */           Object resobj = w.method.invoke(w.methodobject, 
/* 236 */             new Object[0]);
/* 237 */           res = resobj.toString().equals("true");
/*     */         } catch (InvocationTargetException e) { boolean res;
/* 239 */           res = false;
/*     */         } catch (IllegalAccessException e) {
/*     */           boolean res;
/* 242 */           res = false;
/*     */         }
/*     */         
/* 245 */         this.cursor = (c + w.s_size);
/* 246 */         if (res) return w.result;
/*     */       }
/* 248 */       i = w.substring_i;
/* 249 */     } while (i >= 0); return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected int find_among_b(Among[] v, int v_size)
/*     */   {
/* 256 */     int i = 0;
/* 257 */     int j = v_size;
/*     */     
/* 259 */     int c = this.cursor;
/* 260 */     int lb = this.limit_backward;
/*     */     
/* 262 */     int common_i = 0;
/* 263 */     int common_j = 0;
/*     */     
/* 265 */     boolean first_key_inspected = false;
/*     */     for (;;)
/*     */     {
/* 268 */       int k = i + (j - i >> 1);
/* 269 */       int diff = 0;
/* 270 */       int common = common_i < common_j ? common_i : common_j;
/* 271 */       Among w = v[k];
/*     */       
/* 273 */       for (int i2 = w.s_size - 1 - common; i2 >= 0; i2--) {
/* 274 */         if (c - common == lb) {
/* 275 */           diff = -1;
/* 276 */           break;
/*     */         }
/* 278 */         diff = this.current.charAt(c - 1 - common) - w.s[i2];
/* 279 */         if (diff != 0) break;
/* 280 */         common++;
/*     */       }
/* 282 */       if (diff < 0) {
/* 283 */         j = k;
/* 284 */         common_j = common;
/*     */       } else {
/* 286 */         i = k;
/* 287 */         common_i = common;
/*     */       }
/* 289 */       if (j - i <= 1) {
/* 290 */         if ((i > 0) || 
/* 291 */           (j == i) || 
/* 292 */           (first_key_inspected)) break;
/* 293 */         first_key_inspected = true;
/*     */       }
/*     */     }
/*     */     do {
/* 297 */       Among w = v[i];
/* 298 */       if (common_i >= w.s_size) {
/* 299 */         this.cursor = (c - w.s_size);
/* 300 */         if (w.method == null) return w.result;
/*     */         boolean res;
/*     */         try
/*     */         {
/* 304 */           Object resobj = w.method.invoke(w.methodobject, 
/* 305 */             new Object[0]);
/* 306 */           res = resobj.toString().equals("true");
/*     */         } catch (InvocationTargetException e) { boolean res;
/* 308 */           res = false;
/*     */         } catch (IllegalAccessException e) {
/*     */           boolean res;
/* 311 */           res = false;
/*     */         }
/*     */         
/* 314 */         this.cursor = (c - w.s_size);
/* 315 */         if (res) return w.result;
/*     */       }
/* 317 */       i = w.substring_i;
/* 318 */     } while (i >= 0); return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected int replace_s(int c_bra, int c_ket, String s)
/*     */   {
/* 327 */     int adjustment = s.length() - (c_ket - c_bra);
/* 328 */     this.current.replace(c_bra, c_ket, s);
/* 329 */     this.limit += adjustment;
/* 330 */     if (this.cursor >= c_ket) { this.cursor += adjustment;
/* 331 */     } else if (this.cursor > c_bra) this.cursor = c_bra;
/* 332 */     return adjustment;
/*     */   }
/*     */   
/*     */   protected void slice_check()
/*     */   {
/* 337 */     if ((this.bra < 0) || 
/* 338 */       (this.bra > this.ket) || 
/* 339 */       (this.ket > this.limit) || 
/* 340 */       (this.limit > this.current.length()))
/*     */     {
/* 342 */       System.err.println("faulty slice operation");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void slice_from(String s)
/*     */   {
/* 354 */     slice_check();
/* 355 */     replace_s(this.bra, this.ket, s);
/*     */   }
/*     */   
/*     */   protected void slice_from(CharSequence s)
/*     */   {
/* 360 */     slice_from(s.toString());
/*     */   }
/*     */   
/*     */   protected void slice_del()
/*     */   {
/* 365 */     slice_from("");
/*     */   }
/*     */   
/*     */   protected void insert(int c_bra, int c_ket, String s)
/*     */   {
/* 370 */     int adjustment = replace_s(c_bra, c_ket, s);
/* 371 */     if (c_bra <= this.bra) this.bra += adjustment;
/* 372 */     if (c_bra <= this.ket) this.ket += adjustment;
/*     */   }
/*     */   
/*     */   protected void insert(int c_bra, int c_ket, CharSequence s)
/*     */   {
/* 377 */     insert(c_bra, c_ket, s.toString());
/*     */   }
/*     */   
/*     */ 
/*     */   protected StringBuffer slice_to(StringBuffer s)
/*     */   {
/* 383 */     slice_check();
/* 384 */     int len = this.ket - this.bra;
/* 385 */     s.replace(0, s.length(), this.current.substring(this.bra, this.ket));
/* 386 */     return s;
/*     */   }
/*     */   
/*     */ 
/*     */   protected StringBuilder slice_to(StringBuilder s)
/*     */   {
/* 392 */     slice_check();
/* 393 */     int len = this.ket - this.bra;
/* 394 */     s.replace(0, s.length(), this.current.substring(this.bra, this.ket));
/* 395 */     return s;
/*     */   }
/*     */   
/*     */   protected StringBuffer assign_to(StringBuffer s)
/*     */   {
/* 400 */     s.replace(0, s.length(), this.current.substring(0, this.limit));
/* 401 */     return s;
/*     */   }
/*     */   
/*     */   protected StringBuilder assign_to(StringBuilder s)
/*     */   {
/* 406 */     s.replace(0, s.length(), this.current.substring(0, this.limit));
/* 407 */     return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\SnowballProgram.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */