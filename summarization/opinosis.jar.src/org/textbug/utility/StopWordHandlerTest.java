/*    */ package org.textbug.utility;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import org.junit.Assert;
/*    */ import org.junit.Before;
/*    */ 
/*    */ public class StopWordHandlerTest
/*    */ {
/*    */   @Before
/*    */   public void setUp() throws Exception
/*    */   {}
/*    */   
/*    */   @org.junit.Test
/*    */   public void testIsStopWord()
/*    */   {
/* 16 */     ExtWordListWrapper handler = new ExtWordListWrapper();
/* 17 */     handler.loadCommonENStopWords();
/*    */     
/*    */ 
/* 20 */     System.out.println(handler.containsWord("is"));
/* 21 */     System.out.println(handler.containsWord("i"));
/* 22 */     Assert.assertTrue(handler.containsWord("is"));
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\StopWordHandlerTest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */