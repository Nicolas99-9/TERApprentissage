/*    */ package org.textbug.apps;
/*    */ 
/*    */ import java.io.FileInputStream;
/*    */ import java.io.LineNumberReader;
/*    */ import java.io.PrintStream;
/*    */ import org.textbug.lucene.html.HTMLParser;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HTMLToText
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/*    */     try
/*    */     {
/* 21 */       FileInputStream is = new FileInputStream("E:\\crawled\\yelp\\reviews\\1.BombayIndianGrill.html");
/* 22 */       HTMLParser htmlparse = new HTMLParser(is);
/* 23 */       LineNumberReader reader = new LineNumberReader(htmlparse.getReader());
/*    */       
/* 25 */       for (String l = reader.readLine(); l != null; l = reader.readLine()) {
/* 26 */         System.out.println(l);
/*    */       }
/*    */     }
/*    */     catch (Exception exception)
/*    */     {
/* 31 */       exception.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\apps\HTMLToText.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */