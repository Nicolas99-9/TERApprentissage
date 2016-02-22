/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.graph.SimpleWeightedGraph;
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
/*     */ public class HamiltonianCycle
/*     */ {
/*     */   public static <V, E> List<V> getApproximateOptimalForCompleteGraph(SimpleWeightedGraph<V, E> g)
/*     */   {
/*  78 */     List<V> vertices = new LinkedList(g.vertexSet());
/*     */     
/*     */ 
/*     */ 
/*  82 */     if (vertices.size() * (vertices.size() - 1) / 2 != 
/*  83 */       g.edgeSet().size())
/*     */     {
/*  85 */       return null;
/*     */     }
/*     */     
/*  88 */     List<V> tour = new LinkedList();
/*     */     
/*     */ 
/*     */ 
/*  92 */     while (tour.size() != g.vertexSet().size()) {
/*  93 */       boolean firstEdge = true;
/*  94 */       double minEdgeValue = 0.0D;
/*  95 */       int minVertexFound = 0;
/*  96 */       int vertexConnectedTo = 0;
/*     */       
/*     */ 
/*     */ 
/* 100 */       for (int i = 0; i < tour.size(); i++) {
/* 101 */         V v = tour.get(i);
/* 102 */         for (int j = 0; j < vertices.size(); j++) {
/* 103 */           double weight = 
/* 104 */             g.getEdgeWeight(g.getEdge(v, vertices.get(j)));
/* 105 */           if ((firstEdge) || (weight < minEdgeValue)) {
/* 106 */             firstEdge = false;
/* 107 */             minEdgeValue = weight;
/* 108 */             minVertexFound = j;
/* 109 */             vertexConnectedTo = i;
/*     */           }
/*     */         }
/*     */       }
/* 113 */       tour.add(vertexConnectedTo, vertices.get(minVertexFound));
/* 114 */       vertices.remove(minVertexFound);
/*     */     }
/* 116 */     return tour;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\HamiltonianCycle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */