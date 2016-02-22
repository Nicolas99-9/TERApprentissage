/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.GraphPath;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KShortestPaths<V, E>
/*     */ {
/*     */   private Graph<V, E> graph;
/*     */   private int nMaxHops;
/*     */   private int nPaths;
/*     */   private V startVertex;
/*     */   
/*     */   public KShortestPaths(Graph<V, E> graph, V startVertex, int k)
/*     */   {
/*  94 */     this(graph, startVertex, k, graph.vertexSet().size() - 1);
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
/*     */   public KShortestPaths(Graph<V, E> graph, V startVertex, int nPaths, int nMaxHops)
/*     */   {
/* 118 */     assertKShortestPathsFinder(graph, startVertex, nPaths, nMaxHops);
/*     */     
/* 120 */     this.graph = graph;
/* 121 */     this.startVertex = startVertex;
/* 122 */     this.nPaths = nPaths;
/* 123 */     this.nMaxHops = nMaxHops;
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
/*     */   public List<GraphPath<V, E>> getPaths(V endVertex)
/*     */   {
/* 141 */     assertGetPaths(endVertex);
/*     */     
/* 143 */     KShortestPathsIterator<V, E> iter = 
/* 144 */       new KShortestPathsIterator(
/* 145 */       this.graph, 
/* 146 */       this.startVertex, 
/* 147 */       endVertex, 
/* 148 */       this.nPaths);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 153 */     for (int passNumber = 1; 
/* 154 */         (passNumber <= this.nMaxHops) && (
/* 155 */           iter.hasNext()); 
/* 156 */         passNumber++)
/*     */     {
/* 158 */       iter.next();
/*     */     }
/*     */     
/* 161 */     List<RankingPathElement<V, E>> list = iter.getPathElements(endVertex);
/*     */     
/* 163 */     if (list == null) {
/* 164 */       return null;
/*     */     }
/*     */     
/* 167 */     List<GraphPath<V, E>> pathList = new ArrayList();
/*     */     
/* 169 */     for (RankingPathElement<V, E> element : list) {
/* 170 */       pathList.add(new PathWrapper(element));
/*     */     }
/*     */     
/* 173 */     return pathList;
/*     */   }
/*     */   
/*     */   private void assertGetPaths(V endVertex)
/*     */   {
/* 178 */     if (endVertex == null) {
/* 179 */       throw new NullPointerException("endVertex is null");
/*     */     }
/* 181 */     if (endVertex.equals(this.startVertex)) {
/* 182 */       throw new IllegalArgumentException(
/* 183 */         "The end vertex is the same as the start vertex!");
/*     */     }
/* 185 */     if (!this.graph.vertexSet().contains(endVertex)) {
/* 186 */       throw new IllegalArgumentException(
/* 187 */         "Graph must contain the end vertex!");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void assertKShortestPathsFinder(Graph<V, E> graph, V startVertex, int nPaths, int nMaxHops)
/*     */   {
/* 197 */     if (graph == null) {
/* 198 */       throw new NullPointerException("graph is null");
/*     */     }
/* 200 */     if (startVertex == null) {
/* 201 */       throw new NullPointerException("startVertex is null");
/*     */     }
/* 203 */     if (nPaths <= 0) {
/* 204 */       throw new NullPointerException("nPaths is negative or 0");
/*     */     }
/* 206 */     if (nMaxHops <= 0) {
/* 207 */       throw new NullPointerException("nMaxHops is negative or 0");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private class PathWrapper
/*     */     implements GraphPath<V, E>
/*     */   {
/*     */     private RankingPathElement<V, E> rankingPathElement;
/*     */     
/*     */     private List<E> edgeList;
/*     */     
/*     */ 
/*     */     PathWrapper()
/*     */     {
/* 222 */       this.rankingPathElement = rankingPathElement;
/*     */     }
/*     */     
/*     */ 
/*     */     public Graph<V, E> getGraph()
/*     */     {
/* 228 */       return KShortestPaths.this.graph;
/*     */     }
/*     */     
/*     */ 
/*     */     public V getStartVertex()
/*     */     {
/* 234 */       return (V)KShortestPaths.this.startVertex;
/*     */     }
/*     */     
/*     */ 
/*     */     public V getEndVertex()
/*     */     {
/* 240 */       return (V)this.rankingPathElement.getVertex();
/*     */     }
/*     */     
/*     */ 
/*     */     public List<E> getEdgeList()
/*     */     {
/* 246 */       if (this.edgeList == null) {
/* 247 */         this.edgeList = this.rankingPathElement.createEdgeListPath();
/*     */       }
/* 249 */       return this.edgeList;
/*     */     }
/*     */     
/*     */ 
/*     */     public double getWeight()
/*     */     {
/* 255 */       return this.rankingPathElement.getWeight();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String toString()
/*     */     {
/* 262 */       return getEdgeList().toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\KShortestPaths.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */