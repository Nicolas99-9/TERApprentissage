/*    */ package org.tartarus.snowball;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.OutputStream;
/*    */ import java.io.OutputStreamWriter;
/*    */ import java.io.PrintStream;
/*    */ import java.io.Reader;
/*    */ import java.io.Writer;
/*    */ 
/*    */ public class TestApp
/*    */ {
/*    */   private static void usage()
/*    */   {
/* 17 */     System.err.println("Usage: TestApp <algorithm> <input file> [-o <output file>]");
/*    */   }
/*    */   
/*    */   public static void main(String[] args) throws Throwable {
/* 21 */     if (args.length < 2) {
/* 22 */       usage();
/* 23 */       return;
/*    */     }
/*    */     
/* 26 */     Class stemClass = Class.forName("org.tartarus.snowball.ext." + 
/* 27 */       args[0] + "Stemmer");
/* 28 */     SnowballStemmer stemmer = (SnowballStemmer)stemClass.newInstance();
/*    */     
/*    */ 
/* 31 */     Reader reader = new InputStreamReader(new FileInputStream(args[1]));
/* 32 */     reader = new BufferedReader(reader);
/*    */     
/* 34 */     StringBuffer input = new StringBuffer();
/*    */     
/*    */     OutputStream outstream;
/*    */     
/* 38 */     if (args.length > 2) { OutputStream outstream;
/* 39 */       if ((args.length >= 4) && (args[2].equals("-o"))) {
/* 40 */         outstream = new FileOutputStream(args[3]);
/*    */       } else {
/* 42 */         usage();
/*    */       }
/*    */     }
/*    */     else {
/* 46 */       outstream = System.out;
/*    */     }
/* 48 */     Writer output = new OutputStreamWriter(outstream);
/* 49 */     output = new java.io.BufferedWriter(output);
/*    */     
/* 51 */     int repeat = 1;
/* 52 */     if (args.length > 4) {
/* 53 */       repeat = Integer.parseInt(args[4]);
/*    */     }
/*    */     
/* 56 */     Object[] emptyArgs = new Object[0];
/*    */     int character;
/* 58 */     while ((character = reader.read()) != -1) { int character;
/* 59 */       char ch = (char)character;
/* 60 */       if (Character.isWhitespace(ch)) {
/* 61 */         if (input.length() > 0) {
/* 62 */           stemmer.setCurrent(input.toString());
/* 63 */           for (int i = repeat; i != 0; i--) {
/* 64 */             stemmer.stem();
/*    */           }
/* 66 */           output.write(stemmer.getCurrent());
/* 67 */           output.write(10);
/* 68 */           input.delete(0, input.length());
/*    */         }
/*    */       } else {
/* 71 */         input.append(Character.toLowerCase(ch));
/*    */       }
/*    */     }
/* 74 */     output.flush();
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\TestApp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */