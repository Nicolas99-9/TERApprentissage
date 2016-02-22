/*    */ package org.textbug.lucene.html;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Token
/*    */ {
/*    */   public int kind;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int beginLine;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int beginColumn;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int endLine;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int endColumn;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String image;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Token next;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Token specialToken;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String toString()
/*    */   {
/* 58 */     return this.image;
/*    */   }
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
/*    */   public static final Token newToken(int ofKind)
/*    */   {
/* 77 */     return new Token();
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\lucene\html\Token.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */