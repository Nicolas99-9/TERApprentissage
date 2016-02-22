/*    */ package org.textbug.utility.tests;
/*    */ 
/*    */ import org.junit.Test;
/*    */ import org.textbug.utility.TextCleaner;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TextCleanerTest
/*    */ {
/*    */   @Test
/*    */   public void testChunkClean()
/*    */   {
/* 13 */     String txt = "This, is a very   wrong approach!.\n  I will have to deal with this";
/*    */     
/* 15 */     TextCleaner tc = TextCleaner.getInstance();
/* 16 */     tc.chunkClean(txt);
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\tests\TextCleanerTest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */