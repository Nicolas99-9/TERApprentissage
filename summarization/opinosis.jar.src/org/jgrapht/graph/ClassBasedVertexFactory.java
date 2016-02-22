/*    */ package org.jgrapht.graph;
/*    */ 
/*    */ import org.jgrapht.VertexFactory;
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
/*    */ public class ClassBasedVertexFactory<V>
/*    */   implements VertexFactory<V>
/*    */ {
/*    */   private final Class<? extends V> vertexClass;
/*    */   
/*    */   public ClassBasedVertexFactory(Class<? extends V> vertexClass)
/*    */   {
/* 61 */     this.vertexClass = vertexClass;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public V createVertex()
/*    */   {
/*    */     try
/*    */     {
/* 72 */       return (V)this.vertexClass.newInstance();
/*    */     } catch (Exception e) {
/* 74 */       throw new RuntimeException("Vertex factory failed", e);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\ClassBasedVertexFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */