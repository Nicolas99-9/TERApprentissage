/*    */ package org.textbug.utility;
/*    */ 
/*    */ import java.io.PrintWriter;
/*    */ import java.io.StringWriter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExceptionUtil
/*    */ {
/*    */   public static String getStackTrace(Exception e)
/*    */   {
/* 21 */     StringWriter out = new StringWriter();
/* 22 */     e.printStackTrace(new PrintWriter(out));
/* 23 */     String stackTrace = out.toString();
/* 24 */     return stackTrace;
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\ExceptionUtil.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */