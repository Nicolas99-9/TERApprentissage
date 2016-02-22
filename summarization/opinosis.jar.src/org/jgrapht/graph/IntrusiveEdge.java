/*    */ package org.jgrapht.graph;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class IntrusiveEdge
/*    */   implements Cloneable, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 3258408452177932855L;
/*    */   Object source;
/*    */   Object target;
/*    */   
/*    */   public Object clone()
/*    */   {
/*    */     try
/*    */     {
/* 75 */       return super.clone();
/*    */     }
/*    */     catch (CloneNotSupportedException e) {
/* 78 */       throw new InternalError();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\IntrusiveEdge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */