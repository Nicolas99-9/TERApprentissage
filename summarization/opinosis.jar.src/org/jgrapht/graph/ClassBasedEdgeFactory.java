/*    */ package org.jgrapht.graph;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ import org.jgrapht.EdgeFactory;
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
/*    */ public class ClassBasedEdgeFactory<V, E>
/*    */   implements EdgeFactory<V, E>, Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 3618135658586388792L;
/*    */   private final Class<? extends E> edgeClass;
/*    */   
/*    */   public ClassBasedEdgeFactory(Class<? extends E> edgeClass)
/*    */   {
/* 73 */     this.edgeClass = edgeClass;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public E createEdge(V source, V target)
/*    */   {
/*    */     try
/*    */     {
/* 84 */       return (E)this.edgeClass.newInstance();
/*    */     } catch (Exception ex) {
/* 86 */       throw new RuntimeException("Edge factory failed", ex);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\ClassBasedEdgeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */