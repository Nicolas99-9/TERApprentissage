/*     */ package org.jgrapht.generate;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
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
/*     */ public class CompleteGraphGenerator<V, E>
/*     */   implements GraphGenerator<V, E, V>
/*     */ {
/*     */   private int size;
/*     */   
/*     */   public CompleteGraphGenerator(int size)
/*     */   {
/*  79 */     if (size < 0) {
/*  80 */       throw new IllegalArgumentException("must be non-negative");
/*     */     }
/*     */     
/*  83 */     this.size = size;
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
/*  96 */     if (this.size < 1) {
/*  97 */       return;
/*     */     }
/*     */     
/*     */ 
/* 101 */     for (int i = 0; i < this.size; i++) {
/* 102 */       V newVertex = vertexFactory.createVertex();
/* 103 */       target.addVertex(newVertex);
/*     */     }
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
/* 115 */     Iterator<V> slowI = target.vertexSet().iterator();
/*     */     Iterator<V> fastI;
/* 118 */     for (; 
/* 118 */         slowI.hasNext(); 
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
/* 130 */         fastI.hasNext())
/*     */     {
/* 120 */       V latestVertex = slowI.next();
/* 121 */       fastI = target.vertexSet().iterator();
/*     */       
/*     */ 
/* 124 */       while (fastI.next() != latestVertex) {}
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 130 */       continue;
/* 131 */       V temp = fastI.next();
/* 132 */       target.addEdge(latestVertex, temp);
/* 133 */       target.addEdge(temp, latestVertex);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\generate\CompleteGraphGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */