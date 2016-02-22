/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.Graph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BellmanFordShortestPath<V, E>
/*     */ {
/*     */   private static final double DEFAULT_EPSILON = 1.0E-9D;
/*     */   protected Graph<V, E> graph;
/*     */   protected V startVertex;
/*     */   private BellmanFordIterator<V, E> iter;
/*     */   private int nMaxHops;
/*     */   private int passNumber;
/*     */   private double epsilon;
/*     */   
/*     */   public BellmanFordShortestPath(Graph<V, E> graph, V startVertex)
/*     */   {
/*  93 */     this(graph, startVertex, graph.vertexSet().size() - 1);
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
/*     */   public BellmanFordShortestPath(Graph<V, E> graph, V startVertex, int nMaxHops)
/*     */   {
/* 109 */     this(graph, startVertex, nMaxHops, 1.0E-9D);
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
/*     */   public BellmanFordShortestPath(Graph<V, E> graph, V startVertex, int nMaxHops, double epsilon)
/*     */   {
/* 127 */     this.startVertex = startVertex;
/* 128 */     this.nMaxHops = nMaxHops;
/* 129 */     this.graph = graph;
/* 130 */     this.passNumber = 1;
/* 131 */     this.epsilon = epsilon;
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
/*     */   public double getCost(V endVertex)
/*     */   {
/* 144 */     assertGetPath(endVertex);
/*     */     
/* 146 */     lazyCalculate();
/*     */     
/* 148 */     BellmanFordPathElement<V, E> pathElement = 
/* 149 */       this.iter.getPathElement(endVertex);
/*     */     
/* 151 */     if (pathElement == null) {
/* 152 */       return Double.POSITIVE_INFINITY;
/*     */     }
/*     */     
/* 155 */     return pathElement.getCost();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<E> getPathEdgeList(V endVertex)
/*     */   {
/* 166 */     assertGetPath(endVertex);
/*     */     
/* 168 */     lazyCalculate();
/*     */     
/* 170 */     BellmanFordPathElement<V, E> pathElement = 
/* 171 */       this.iter.getPathElement(endVertex);
/*     */     
/* 173 */     if (pathElement == null) {
/* 174 */       return null;
/*     */     }
/*     */     
/* 177 */     return pathElement.createEdgeListPath();
/*     */   }
/*     */   
/*     */   private void assertGetPath(V endVertex)
/*     */   {
/* 182 */     if (endVertex.equals(this.startVertex)) {
/* 183 */       throw new IllegalArgumentException(
/* 184 */         "The end vertex is the same as the start vertex!");
/*     */     }
/*     */     
/* 187 */     if (!this.graph.containsVertex(endVertex)) {
/* 188 */       throw new IllegalArgumentException(
/* 189 */         "Graph must contain the end vertex!");
/*     */     }
/*     */   }
/*     */   
/*     */   private void lazyCalculate()
/*     */   {
/* 195 */     if (this.iter == null) {
/* 196 */       this.iter = 
/* 197 */         new BellmanFordIterator(
/* 198 */         this.graph, 
/* 199 */         this.startVertex, 
/* 200 */         this.epsilon);
/*     */     }
/* 207 */     for (; 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 207 */         (this.passNumber <= this.nMaxHops) && (this.iter.hasNext()); 
/* 208 */         this.passNumber += 1)
/*     */     {
/* 210 */       this.iter.next();
/*     */     }
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
/*     */   public static <V, E> List<E> findPathBetween(Graph<V, E> graph, V startVertex, V endVertex)
/*     */   {
/* 230 */     BellmanFordShortestPath<V, E> alg = 
/* 231 */       new BellmanFordShortestPath(
/* 232 */       graph, 
/* 233 */       startVertex);
/*     */     
/* 235 */     return alg.getPathEdgeList(endVertex);
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\BellmanFordShortestPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */