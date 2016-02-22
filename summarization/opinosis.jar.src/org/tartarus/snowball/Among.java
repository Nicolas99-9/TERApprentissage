/*    */ package org.tartarus.snowball;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public class Among {
/*    */   public final int s_size;
/*    */   
/*  8 */   public Among(String s, int substring_i, int result, String methodname, SnowballProgram methodobject) { this.s_size = s.length();
/*  9 */     this.s = s.toCharArray();
/* 10 */     this.substring_i = substring_i;
/* 11 */     this.result = result;
/* 12 */     this.methodobject = methodobject;
/* 13 */     if (methodname.length() == 0) {
/* 14 */       this.method = null;
/*    */     } else {
/*    */       try {
/* 17 */         this.method = methodobject.getClass()
/* 18 */           .getDeclaredMethod(methodname, new Class[0]);
/*    */       } catch (NoSuchMethodException e) {
/* 20 */         throw new RuntimeException(e);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public final char[] s;
/*    */   public final int substring_i;
/*    */   public final int result;
/*    */   public final Method method;
/*    */   public final SnowballProgram methodobject;
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\tartarus\snowball\Among.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */