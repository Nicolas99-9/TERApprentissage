/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.GraphPath;
/*     */ import org.jgrapht.traverse.ClosestFirstIterator;
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
/*     */ public final class DijkstraShortestPath<V, E>
/*     */ {
/*     */   private GraphPath<V, E> path;
/*     */   
/*     */   public DijkstraShortestPath(Graph<V, E> graph, V startVertex, V endVertex)
/*     */   {
/*  80 */     this(graph, startVertex, endVertex, Double.POSITIVE_INFINITY);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DijkstraShortestPath(Graph<V, E> graph, V startVertex, V endVertex, double radius)
/*     */   {
/* 100 */     if (!graph.containsVertex(endVertex)) {
/* 101 */       throw new IllegalArgumentException(
/* 102 */         "graph must contain the end vertex");
/*     */     }
/*     */     
/* 105 */     ClosestFirstIterator<V, E> iter = 
/* 106 */       new ClosestFirstIterator(graph, startVertex, radius);
/*     */     
/* 108 */     while (iter.hasNext()) {
/* 109 */       V vertex = iter.next();
/*     */       
/* 111 */       if (vertex.equals(endVertex)) {
/* 112 */         createEdgeList(graph, iter, startVertex, endVertex);
/* 113 */         return;
/*     */       }
/*     */     }
/*     */     
/* 117 */     this.path = null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<E> getPathEdgeList()
/*     */   {
/* 129 */     if (this.path == null) {
/* 130 */       return null;
/*     */     }
/* 132 */     return this.path.getEdgeList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public GraphPath<V, E> getPath()
/*     */   {
/* 143 */     return this.path;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getPathLength()
/*     */   {
/* 153 */     if (this.path == null) {
/* 154 */       return Double.POSITIVE_INFINITY;
/*     */     }
/* 156 */     return this.path.getWeight();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static <V, E> List<E> findPathBetween(Graph<V, E> graph, V startVertex, V endVertex)
/*     */   {
/* 176 */     DijkstraShortestPath<V, E> alg = 
/* 177 */       new DijkstraShortestPath(
/* 178 */       graph, 
/* 179 */       startVertex, 
/* 180 */       endVertex);
/*     */     
/* 182 */     return alg.getPathEdgeList();
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
/*     */   private void createEdgeList(Graph<V, E> graph, ClosestFirstIterator<V, E> iter, V startVertex, V endVertex)
/*     */   {
/* 209 */     throw new Error("Unresolved compilation problem: \n\tGraphPathImpl cannot be resolved to a type\n");
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\DijkstraShortestPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */