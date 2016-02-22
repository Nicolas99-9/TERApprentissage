/*    */ package org.textbug.lucene.html;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
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
/*    */ class ParserThread
/*    */   extends Thread
/*    */ {
/*    */   HTMLParser parser;
/*    */   
/*    */   ParserThread(HTMLParser p)
/*    */   {
/* 26 */     this.parser = p;
/*    */   }
/*    */   
/*    */   public void run() {
/*    */     try {
/*    */       try {
/* 32 */         this.parser.HTMLDocument();
/*    */ 
/*    */       }
/*    */       catch (ParseException localParseException) {}catch (TokenMgrError localTokenMgrError) {}finally
/*    */       {
/*    */ 
/* 38 */         this.parser.pipeOut.close();
/* 39 */         synchronized (this.parser) {
/* 40 */           this.parser.summary.setLength(HTMLParser.SUMMARY_LENGTH);
/* 41 */           this.parser.titleComplete = true;
/* 42 */           this.parser.notifyAll();
/*    */         }
/*    */       }
/* 38 */       this.parser.pipeOut.close();
/* 39 */       synchronized (this.parser) {
/* 40 */         this.parser.summary.setLength(HTMLParser.SUMMARY_LENGTH);
/* 41 */         this.parser.titleComplete = true;
/* 42 */         this.parser.notifyAll();
/*    */       }
/*    */     }
/*    */     catch (IOException e) {
/* 46 */       e.printStackTrace();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\lucene\html\ParserThread.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */