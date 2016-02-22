/*    */ package org.textbug.utility.tests;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import org.junit.Before;
/*    */ import org.junit.BeforeClass;
/*    */ import org.junit.Test;
/*    */ import org.textbug.utility.SentenceSplitter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SentenceSplitterTest
/*    */ {
/* 17 */   SentenceSplitter mSplitter = SentenceSplitter.getInstance();
/*    */   
/* 19 */   String STR1 = "Indian food is a very important aspect of our dining life. Suffice to say we take our restaurants seriously, this one is real good! We like the spice and Indian Grill is one of the few places when us white folks say we want our dish spicy that actually make that way the first time.The staff is relatively friendly, which is all you can except from my experience dining at Indian food here in Chitown. The owner, however, is great. Extremely friendly and he remembered us pretty much after the first time we came in ;It is BYOB, which is cool.They have a great Shrimp appetizer, I forget the name but I think it is the only one. I like the Malahi salad too, but I would recommend it. It is pretty plain. All their food is fresh, I have tried several different things and they were all great. Delivery is hit or miss. Definitely worth checking out and a much better choice then Hema's Kitchen if you want Indian food in that area. U.S.A is the best place to live in. Mrs. Johnson mentioned to me that this is thebest thing to do. Dr. Yoges als mentioned that to me. I would be thinking that....this was ridiculous.This was the first um. thing.  ";
/*    */   
/*    */ 
/*    */ 
/*    */   @BeforeClass
/*    */   public static void setUpBeforeClass()
/*    */     throws Exception
/*    */   {}
/*    */   
/*    */ 
/*    */ 
/*    */   @Before
/*    */   public void setUp()
/*    */     throws Exception
/*    */   {}
/*    */   
/*    */ 
/*    */ 
/*    */   @Test
/*    */   public final void testFileToSentence()
/*    */   {
/*    */     try
/*    */     {
/* 42 */       SentenceSplitter.splitFile("E:\\Projects\\MyTopiq\\data\\raw\\usa_nevada_las-vegas_four_seasons_hotel_las_vegas.txt");
/*    */     }
/*    */     catch (IOException exception) {
/* 45 */       exception.printStackTrace();
/*    */     }
/*    */   }
/*    */   
/*    */   @Test
/*    */   public final void testSplitAndClean()
/*    */   {
/* 52 */     String str = SentenceSplitter.split(this.STR1);
/* 53 */     System.out.println(str);
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\utility\tests\SentenceSplitterTest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */