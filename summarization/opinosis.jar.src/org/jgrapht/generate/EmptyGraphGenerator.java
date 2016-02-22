/*    */ package org.jgrapht.generate;
/*    */ 
/*    */ import java.util.Map;
/*    */ import org.jgrapht.Graph;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EmptyGraphGenerator<V, E>
/*    */   implements GraphGenerator<V, E, V>
/*    */ {
/*    */   private int size;
/*    */   
/*    */   public EmptyGraphGenerator(int size)
/*    */   {
/* 72 */     if (size < 0) {
/* 73 */       throw new IllegalArgumentException("must be non-negative");
/*    */     }
/*    */     
/* 76 */     this.size = size;
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
/*    */   public void generateGraph(Graph<V, E> target, VertexFactory<V> vertexFactory, Map<String, V> resultMap)
/*    */   {
/* 89 */     for (int i = 0; i < this.size; i++) {
/* 90 */       target.addVertex(vertexFactory.createVertex());
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\generate\EmptyGraphGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */