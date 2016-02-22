/*    */ package org.textbug.apps.html.tests;
/*    */ 
/*    */ import java.io.FileInputStream;
/*    */ import java.io.LineNumberReader;
/*    */ import java.io.PrintStream;
/*    */ import org.junit.Before;
/*    */ import org.junit.BeforeClass;
/*    */ import org.junit.Test;
/*    */ import org.textbug.lucene.html.HTMLParser;
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
/*    */ public class HTMLParserTest
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
/*    */   public void testHTMLParser()
/*    */   {
/*    */     try
/*    */     {
/* 44 */       FileInputStream is = new FileInputStream("E:\\crawled\\yelp\\reviews\\1.BombayIndianGrill.html");
/* 45 */       HTMLParser htmlparse = new HTMLParser(is);
/* 46 */       LineNumberReader reader = new LineNumberReader(htmlparse.getReader());
/*    */       
/* 48 */       for (String l = reader.readLine(); l != null; l = reader.readLine())
/*    */       {
/* 50 */         System.out.println(l);
/*    */       }
/*    */     }
/*    */     catch (Exception exception) {
/* 54 */       exception.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\apps\html\tests\HTMLParserTest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */