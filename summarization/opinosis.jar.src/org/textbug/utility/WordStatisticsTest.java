/*    */ package org.textbug.utility;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import org.junit.Before;
/*    */ import org.junit.BeforeClass;
/*    */ import org.junit.Test;
/*    */ 
/*    */ 
/*    */ public class WordStatisticsTest
/*    */ {
/*    */   @BeforeClass
/*    */   public static void setUpBeforeClass()
/*    */     throws Exception
/*    */   {}
/*    */   
/*    */   @Before
/*    */   public void setUp()
/*    */     throws Exception
/*    */   {}
/*    */   
/*    */   @Test
/*    */   public void testGetUnigramStatistics()
/*    */   {
/* 24 */     long start = System.currentTimeMillis();
/* 25 */     WordStatistics wordStats = new WordStatistics();
/*    */     try {
/* 27 */       boolean success = wordStats.computeWordStatistics(2, "E:\\crawled\\yelp\\reviews", FileTypeEnum.FILE_HTML);
/*    */       
/*    */ 
/* 30 */       if (!success) {
/* 31 */         System.out.println(wordStats.getErrorMessage());
/*    */       }
/*    */       
/*    */     }
/*    */     catch (Exception exception)
/*    */     {
/* 37 */       exception.printStackTrace();
/*    */     }
/* 39 */     long end = System.currentTimeMillis();
/*    */     
/* 41 */     System.out.println(end - start + "ms");
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\WordStatisticsTest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */