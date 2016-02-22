/*    */ package org.textbug.utility.tests;
/*    */ 
/*    */ import org.junit.Assert;
/*    */ import org.junit.Before;
/*    */ import org.junit.BeforeClass;
/*    */ import org.junit.Test;
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
/*    */ public class SimpleLemmatizerTest
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
/*    */   public final void testLemmatize()
/*    */   {
/* 40 */     Assert.fail("Not yet implemented");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   @Test
/*    */   public final void testLemmatizeSentence()
/*    */   {
/* 49 */     String str1 = "this was a horrible restaurant";
/* 50 */     String ans1 = "this is a bad restaurant";
/*    */     
/* 52 */     String str2 = "i absolutely love this place";
/* 53 */     String ans2 = "i like this place";
/*    */     
/* 55 */     String str3 = "it was extremely spicy";
/* 56 */     String ans3 = "it is spicy";
/*    */     
/* 58 */     String str4 = "she was an exceptionally kind doctor";
/* 59 */     String ans4 = "she is an exceptionally polite doctor";
/*    */     
/*    */ 
/* 62 */     SimpleLemmatizer lemmatizer = SimpleLemmatizer.getInstance();
/*    */     
/* 64 */     Assert.assertEquals(lemmatizer.lemmatizeSentence(str1), ans1, lemmatizer.lemmatizeSentence(str1));
/* 65 */     Assert.assertEquals(lemmatizer.lemmatizeSentence(str2), ans2, lemmatizer.lemmatizeSentence(str2));
/* 66 */     Assert.assertEquals(lemmatizer.lemmatizeSentence(str3), ans3, lemmatizer.lemmatizeSentence(str3));
/* 67 */     Assert.assertEquals(lemmatizer.lemmatizeSentence(str4), ans4, lemmatizer.lemmatizeSentence(str4));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @Test
/*    */   public final void testLemmatizeWord()
/*    */   {
/* 77 */     String wrd1 = "lovely";
/* 78 */     String wrd2 = "wonderful";
/* 79 */     String wrd3 = "crappy";
/*    */     
/* 81 */     String ans1 = "good";
/* 82 */     String ans2 = "bad";
/*    */     
/* 84 */     SimpleLemmatizer lemmatizer = SimpleLemmatizer.getInstance();
/*    */     
/* 86 */     Assert.assertEquals(lemmatizer.lemmatizeSentence(wrd1), ans1, lemmatizer.lemmatizeSentence(wrd1));
/* 87 */     Assert.assertEquals(lemmatizer.lemmatizeSentence(wrd2), ans1, lemmatizer.lemmatizeSentence(wrd2));
/* 88 */     Assert.assertEquals(lemmatizer.lemmatizeSentence(wrd3), ans2, lemmatizer.lemmatizeSentence(wrd3));
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\tests\SimpleLemmatizerTest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */