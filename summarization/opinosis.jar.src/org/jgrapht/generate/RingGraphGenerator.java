/*     */ package org.jgrapht.generate;
/*     */ 
/*     */ import java.util.HashMap;
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
/*     */ public class RingGraphGenerator<V, E>
/*     */   implements GraphGenerator<V, E, V>
/*     */ {
/*     */   private int size;
/*     */   
/*     */   public RingGraphGenerator(int size)
/*     */   {
/*  74 */     if (size < 0) {
/*  75 */       throw new IllegalArgumentException("must be non-negative");
/*     */     }
/*     */     
/*  78 */     this.size = size;
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
/*  91 */     if (this.size < 1) {
/*  92 */       return;
/*     */     }
/*     */     
/*  95 */     LinearGraphGenerator<V, E> linearGenerator = 
/*  96 */       new LinearGraphGenerator(this.size);
/*  97 */     Map<String, V> privateMap = new HashMap();
/*  98 */     linearGenerator.generateGraph(target, vertexFactory, privateMap);
/*     */     
/* 100 */     V startVertex = privateMap.get("Start Vertex");
/* 101 */     V endVertex = privateMap.get("End Vertex");
/* 102 */     target.addEdge(endVertex, startVertex);
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\generate\RingGraphGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */