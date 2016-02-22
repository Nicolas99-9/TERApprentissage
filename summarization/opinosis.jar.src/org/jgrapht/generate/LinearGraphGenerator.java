/*     */ package org.jgrapht.generate;
/*     */ 
/*     */ import java.util.Map;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.VertexFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LinearGraphGenerator<V, E>
/*     */   implements GraphGenerator<V, E, V>
/*     */ {
/*     */   public static final String START_VERTEX = "Start Vertex";
/*     */   public static final String END_VERTEX = "End Vertex";
/*     */   private int size;
/*     */   
/*     */   public LinearGraphGenerator(int size)
/*     */   {
/*  84 */     if (size < 0) {
/*  85 */       throw new IllegalArgumentException("must be non-negative");
/*     */     }
/*     */     
/*  88 */     this.size = size;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void generateGraph(Graph<V, E> target, VertexFactory<V> vertexFactory, Map<String, V> resultMap)
/*     */   {
/* 101 */     V lastVertex = null;
/*     */     
/* 103 */     for (int i = 0; i < this.size; i++) {
/* 104 */       V newVertex = vertexFactory.createVertex();
/* 105 */       target.addVertex(newVertex);
/*     */       
/* 107 */       if (lastVertex == null) {
/* 108 */         if (resultMap != null) {
/* 109 */           resultMap.put("Start Vertex", newVertex);
/*     */         }
/*     */       } else {
/* 112 */         target.addEdge(lastVertex, newVertex);
/*     */       }
/*     */       
/* 115 */       lastVertex = newVertex;
/*     */     }
/*     */     
/* 118 */     if ((resultMap != null) && (lastVertex != null)) {
/* 119 */       resultMap.put("End Vertex", lastVertex);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\generate\LinearGraphGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */