/*     */ package org.textbug.lucene.html;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Entities
/*     */ {
/*  24 */   static final Map decoder = new HashMap(300);
/*  25 */   static final String[] encoder = new String['Ā'];
/*     */   
/*     */   static final String decode(String entity) {
/*  28 */     if (entity.charAt(entity.length() - 1) == ';')
/*  29 */       entity = entity.substring(0, entity.length() - 1);
/*  30 */     if (entity.charAt(1) == '#') {
/*  31 */       int start = 2;
/*  32 */       int radix = 10;
/*  33 */       if ((entity.charAt(2) == 'X') || (entity.charAt(2) == 'x')) {
/*  34 */         start++;
/*  35 */         radix = 16;
/*     */       }
/*  37 */       Character c = 
/*  38 */         new Character((char)Integer.parseInt(entity.substring(start), radix));
/*  39 */       return c.toString();
/*     */     }
/*  41 */     String s = (String)decoder.get(entity);
/*  42 */     if (s != null)
/*  43 */       return s;
/*  44 */     return "";
/*     */   }
/*     */   
/*     */   public static final String encode(String s)
/*     */   {
/*  49 */     int length = s.length();
/*  50 */     StringBuffer buffer = new StringBuffer(length * 2);
/*  51 */     for (int i = 0; i < length; i++) {
/*  52 */       char c = s.charAt(i);
/*  53 */       int j = c;
/*  54 */       if ((j < 256) && (encoder[j] != null)) {
/*  55 */         buffer.append(encoder[j]);
/*  56 */         buffer.append(';');
/*  57 */       } else if (j < 128) {
/*  58 */         buffer.append(c);
/*     */       } else {
/*  60 */         buffer.append("&#");
/*  61 */         buffer.append(c);
/*  62 */         buffer.append(';');
/*     */       }
/*     */     }
/*  65 */     return buffer.toString();
/*     */   }
/*     */   
/*     */   static final void add(String entity, int value) {
/*  69 */     decoder.put(entity, new Character((char)value).toString());
/*  70 */     if (value < 256)
/*  71 */       encoder[value] = entity;
/*     */   }
/*     */   
/*     */   static {
/*  75 */     add("&nbsp", 160);
/*  76 */     add("&iexcl", 161);
/*  77 */     add("&cent", 162);
/*  78 */     add("&pound", 163);
/*  79 */     add("&curren", 164);
/*  80 */     add("&yen", 165);
/*  81 */     add("&brvbar", 166);
/*  82 */     add("&sect", 167);
/*  83 */     add("&uml", 168);
/*  84 */     add("&copy", 169);
/*  85 */     add("&ordf", 170);
/*  86 */     add("&laquo", 171);
/*  87 */     add("&not", 172);
/*  88 */     add("&shy", 173);
/*  89 */     add("&reg", 174);
/*  90 */     add("&macr", 175);
/*  91 */     add("&deg", 176);
/*  92 */     add("&plusmn", 177);
/*  93 */     add("&sup2", 178);
/*  94 */     add("&sup3", 179);
/*  95 */     add("&acute", 180);
/*  96 */     add("&micro", 181);
/*  97 */     add("&para", 182);
/*  98 */     add("&middot", 183);
/*  99 */     add("&cedil", 184);
/* 100 */     add("&sup1", 185);
/* 101 */     add("&ordm", 186);
/* 102 */     add("&raquo", 187);
/* 103 */     add("&frac14", 188);
/* 104 */     add("&frac12", 189);
/* 105 */     add("&frac34", 190);
/* 106 */     add("&iquest", 191);
/* 107 */     add("&Agrave", 192);
/* 108 */     add("&Aacute", 193);
/* 109 */     add("&Acirc", 194);
/* 110 */     add("&Atilde", 195);
/* 111 */     add("&Auml", 196);
/* 112 */     add("&Aring", 197);
/* 113 */     add("&AElig", 198);
/* 114 */     add("&Ccedil", 199);
/* 115 */     add("&Egrave", 200);
/* 116 */     add("&Eacute", 201);
/* 117 */     add("&Ecirc", 202);
/* 118 */     add("&Euml", 203);
/* 119 */     add("&Igrave", 204);
/* 120 */     add("&Iacute", 205);
/* 121 */     add("&Icirc", 206);
/* 122 */     add("&Iuml", 207);
/* 123 */     add("&ETH", 208);
/* 124 */     add("&Ntilde", 209);
/* 125 */     add("&Ograve", 210);
/* 126 */     add("&Oacute", 211);
/* 127 */     add("&Ocirc", 212);
/* 128 */     add("&Otilde", 213);
/* 129 */     add("&Ouml", 214);
/* 130 */     add("&times", 215);
/* 131 */     add("&Oslash", 216);
/* 132 */     add("&Ugrave", 217);
/* 133 */     add("&Uacute", 218);
/* 134 */     add("&Ucirc", 219);
/* 135 */     add("&Uuml", 220);
/* 136 */     add("&Yacute", 221);
/* 137 */     add("&THORN", 222);
/* 138 */     add("&szlig", 223);
/* 139 */     add("&agrave", 224);
/* 140 */     add("&aacute", 225);
/* 141 */     add("&acirc", 226);
/* 142 */     add("&atilde", 227);
/* 143 */     add("&auml", 228);
/* 144 */     add("&aring", 229);
/* 145 */     add("&aelig", 230);
/* 146 */     add("&ccedil", 231);
/* 147 */     add("&egrave", 232);
/* 148 */     add("&eacute", 233);
/* 149 */     add("&ecirc", 234);
/* 150 */     add("&euml", 235);
/* 151 */     add("&igrave", 236);
/* 152 */     add("&iacute", 237);
/* 153 */     add("&icirc", 238);
/* 154 */     add("&iuml", 239);
/* 155 */     add("&eth", 240);
/* 156 */     add("&ntilde", 241);
/* 157 */     add("&ograve", 242);
/* 158 */     add("&oacute", 243);
/* 159 */     add("&ocirc", 244);
/* 160 */     add("&otilde", 245);
/* 161 */     add("&ouml", 246);
/* 162 */     add("&divide", 247);
/* 163 */     add("&oslash", 248);
/* 164 */     add("&ugrave", 249);
/* 165 */     add("&uacute", 250);
/* 166 */     add("&ucirc", 251);
/* 167 */     add("&uuml", 252);
/* 168 */     add("&yacute", 253);
/* 169 */     add("&thorn", 254);
/* 170 */     add("&yuml", 255);
/* 171 */     add("&fnof", 402);
/* 172 */     add("&Alpha", 913);
/* 173 */     add("&Beta", 914);
/* 174 */     add("&Gamma", 915);
/* 175 */     add("&Delta", 916);
/* 176 */     add("&Epsilon", 917);
/* 177 */     add("&Zeta", 918);
/* 178 */     add("&Eta", 919);
/* 179 */     add("&Theta", 920);
/* 180 */     add("&Iota", 921);
/* 181 */     add("&Kappa", 922);
/* 182 */     add("&Lambda", 923);
/* 183 */     add("&Mu", 924);
/* 184 */     add("&Nu", 925);
/* 185 */     add("&Xi", 926);
/* 186 */     add("&Omicron", 927);
/* 187 */     add("&Pi", 928);
/* 188 */     add("&Rho", 929);
/* 189 */     add("&Sigma", 931);
/* 190 */     add("&Tau", 932);
/* 191 */     add("&Upsilon", 933);
/* 192 */     add("&Phi", 934);
/* 193 */     add("&Chi", 935);
/* 194 */     add("&Psi", 936);
/* 195 */     add("&Omega", 937);
/* 196 */     add("&alpha", 945);
/* 197 */     add("&beta", 946);
/* 198 */     add("&gamma", 947);
/* 199 */     add("&delta", 948);
/* 200 */     add("&epsilon", 949);
/* 201 */     add("&zeta", 950);
/* 202 */     add("&eta", 951);
/* 203 */     add("&theta", 952);
/* 204 */     add("&iota", 953);
/* 205 */     add("&kappa", 954);
/* 206 */     add("&lambda", 955);
/* 207 */     add("&mu", 956);
/* 208 */     add("&nu", 957);
/* 209 */     add("&xi", 958);
/* 210 */     add("&omicron", 959);
/* 211 */     add("&pi", 960);
/* 212 */     add("&rho", 961);
/* 213 */     add("&sigmaf", 962);
/* 214 */     add("&sigma", 963);
/* 215 */     add("&tau", 964);
/* 216 */     add("&upsilon", 965);
/* 217 */     add("&phi", 966);
/* 218 */     add("&chi", 967);
/* 219 */     add("&psi", 968);
/* 220 */     add("&omega", 969);
/* 221 */     add("&thetasym", 977);
/* 222 */     add("&upsih", 978);
/* 223 */     add("&piv", 982);
/* 224 */     add("&bull", 8226);
/* 225 */     add("&hellip", 8230);
/* 226 */     add("&prime", 8242);
/* 227 */     add("&Prime", 8243);
/* 228 */     add("&oline", 8254);
/* 229 */     add("&frasl", 8260);
/* 230 */     add("&weierp", 8472);
/* 231 */     add("&image", 8465);
/* 232 */     add("&real", 8476);
/* 233 */     add("&trade", 8482);
/* 234 */     add("&alefsym", 8501);
/* 235 */     add("&larr", 8592);
/* 236 */     add("&uarr", 8593);
/* 237 */     add("&rarr", 8594);
/* 238 */     add("&darr", 8595);
/* 239 */     add("&harr", 8596);
/* 240 */     add("&crarr", 8629);
/* 241 */     add("&lArr", 8656);
/* 242 */     add("&uArr", 8657);
/* 243 */     add("&rArr", 8658);
/* 244 */     add("&dArr", 8659);
/* 245 */     add("&hArr", 8660);
/* 246 */     add("&forall", 8704);
/* 247 */     add("&part", 8706);
/* 248 */     add("&exist", 8707);
/* 249 */     add("&empty", 8709);
/* 250 */     add("&nabla", 8711);
/* 251 */     add("&isin", 8712);
/* 252 */     add("&notin", 8713);
/* 253 */     add("&ni", 8715);
/* 254 */     add("&prod", 8719);
/* 255 */     add("&sum", 8721);
/* 256 */     add("&minus", 8722);
/* 257 */     add("&lowast", 8727);
/* 258 */     add("&radic", 8730);
/* 259 */     add("&prop", 8733);
/* 260 */     add("&infin", 8734);
/* 261 */     add("&ang", 8736);
/* 262 */     add("&and", 8743);
/* 263 */     add("&or", 8744);
/* 264 */     add("&cap", 8745);
/* 265 */     add("&cup", 8746);
/* 266 */     add("&int", 8747);
/* 267 */     add("&there4", 8756);
/* 268 */     add("&sim", 8764);
/* 269 */     add("&cong", 8773);
/* 270 */     add("&asymp", 8776);
/* 271 */     add("&ne", 8800);
/* 272 */     add("&equiv", 8801);
/* 273 */     add("&le", 8804);
/* 274 */     add("&ge", 8805);
/* 275 */     add("&sub", 8834);
/* 276 */     add("&sup", 8835);
/* 277 */     add("&nsub", 8836);
/* 278 */     add("&sube", 8838);
/* 279 */     add("&supe", 8839);
/* 280 */     add("&oplus", 8853);
/* 281 */     add("&otimes", 8855);
/* 282 */     add("&perp", 8869);
/* 283 */     add("&sdot", 8901);
/* 284 */     add("&lceil", 8968);
/* 285 */     add("&rceil", 8969);
/* 286 */     add("&lfloor", 8970);
/* 287 */     add("&rfloor", 8971);
/* 288 */     add("&lang", 9001);
/* 289 */     add("&rang", 9002);
/* 290 */     add("&loz", 9674);
/* 291 */     add("&spades", 9824);
/* 292 */     add("&clubs", 9827);
/* 293 */     add("&hearts", 9829);
/* 294 */     add("&diams", 9830);
/* 295 */     add("&quot", 34);
/* 296 */     add("&amp", 38);
/* 297 */     add("&lt", 60);
/* 298 */     add("&gt", 62);
/* 299 */     add("&OElig", 338);
/* 300 */     add("&oelig", 339);
/* 301 */     add("&Scaron", 352);
/* 302 */     add("&scaron", 353);
/* 303 */     add("&Yuml", 376);
/* 304 */     add("&circ", 710);
/* 305 */     add("&tilde", 732);
/* 306 */     add("&ensp", 8194);
/* 307 */     add("&emsp", 8195);
/* 308 */     add("&thinsp", 8201);
/* 309 */     add("&zwnj", 8204);
/* 310 */     add("&zwj", 8205);
/* 311 */     add("&lrm", 8206);
/* 312 */     add("&rlm", 8207);
/* 313 */     add("&ndash", 8211);
/* 314 */     add("&mdash", 8212);
/* 315 */     add("&lsquo", 8216);
/* 316 */     add("&rsquo", 8217);
/* 317 */     add("&sbquo", 8218);
/* 318 */     add("&ldquo", 8220);
/* 319 */     add("&rdquo", 8221);
/* 320 */     add("&bdquo", 8222);
/* 321 */     add("&dagger", 8224);
/* 322 */     add("&Dagger", 8225);
/* 323 */     add("&permil", 8240);
/* 324 */     add("&lsaquo", 8249);
/* 325 */     add("&rsaquo", 8250);
/* 326 */     add("&euro", 8364);
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\lucene\html\Entities.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */