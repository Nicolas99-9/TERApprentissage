/*    */ package org.textbug.utility.tests;
/*    */ 
/*    */ import org.junit.Assert;
/*    */ import org.junit.Before;
/*    */ import org.junit.BeforeClass;
/*    */ import org.junit.Test;
/*    */ import org.textbug.utility.SentenceNormalizer;
/*    */ import org.textbug.utility.SimpleLemmatizer;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SentenceNormalizerTest
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
/*    */   public final void testConvertIS()
/*    */   {
/* 41 */     String q1 = "on the whole the service was great";
/* 42 */     String ans1 = "good service";
/*    */     
/*    */ 
/* 45 */     String q2 = "the food and service here is awesome";
/* 46 */     String ans2 = "good food and good service here";
/*    */     
/*    */ 
/* 49 */     String q3 = "the quality of the food at this place was simply awesome";
/* 50 */     String ans3 = "good food at this place";
/*    */     
/*    */ 
/* 53 */     String q4 = "the service at this restaurant is really good";
/* 54 */     String ans4 = "good service at this restaurant";
/*    */     
/*    */ 
/* 57 */     String q5 = "the service is very friendly and they do try very hard";
/* 58 */     String ans5 = "the service is friendly and they do try hard";
/*    */     
/* 60 */     SimpleLemmatizer lemmatizer = SimpleLemmatizer.getInstance();
/*    */     
/*    */ 
/* 63 */     q1 = lemmatizer.lemmatizeSentence(q1);
/* 64 */     q2 = lemmatizer.lemmatizeSentence(q2);
/* 65 */     q3 = lemmatizer.lemmatizeSentence(q3);
/* 66 */     q4 = lemmatizer.lemmatizeSentence(q4);
/* 67 */     q5 = lemmatizer.lemmatizeSentence(q5);
/*    */     
/*    */ 
/* 70 */     String res1 = SentenceNormalizer.getInstance().normalizeIS(q1);
/* 71 */     String res2 = SentenceNormalizer.getInstance().normalizeIS(q2);
/* 72 */     String res3 = SentenceNormalizer.getInstance().normalizeIS(q3);
/* 73 */     String res4 = SentenceNormalizer.getInstance().normalizeIS(q4);
/* 74 */     String res5 = SentenceNormalizer.getInstance().normalizeIS(q5);
/*    */     
/* 76 */     Assert.assertEquals(res1, ans1, res1);
/* 77 */     Assert.assertEquals(res2, ans2, res2);
/* 78 */     Assert.assertEquals(res3, ans3, res3);
/* 79 */     Assert.assertEquals(res4, ans4, res4);
/* 80 */     Assert.assertEquals(res5, ans5, res5);
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\tests\SentenceNormalizerTest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */