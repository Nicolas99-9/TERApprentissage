/*     */ package org.jgrapht;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.graph.AsUndirectedGraph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Graphs
/*     */ {
/*     */   public static <V, E> E addEdge(Graph<V, E> g, V sourceVertex, V targetVertex, double weight)
/*     */   {
/*  82 */     EdgeFactory<V, E> ef = g.getEdgeFactory();
/*  83 */     E e = ef.createEdge(sourceVertex, targetVertex);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  88 */     assert ((g instanceof WeightedGraph)) : g.getClass();
/*  89 */     ((WeightedGraph)g).setEdgeWeight(e, weight);
/*     */     
/*  91 */     return g.addEdge(sourceVertex, targetVertex, e) ? e : null;
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
/*     */   public static <V, E> E addEdgeWithVertices(Graph<V, E> g, V sourceVertex, V targetVertex)
/*     */   {
/* 111 */     g.addVertex(sourceVertex);
/* 112 */     g.addVertex(targetVertex);
/*     */     
/* 114 */     return (E)g.addEdge(sourceVertex, targetVertex);
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
/*     */   public static <V, E> boolean addEdgeWithVertices(Graph<V, E> targetGraph, Graph<V, E> sourceGraph, E edge)
/*     */   {
/* 134 */     V sourceVertex = sourceGraph.getEdgeSource(edge);
/* 135 */     V targetVertex = sourceGraph.getEdgeTarget(edge);
/*     */     
/* 137 */     targetGraph.addVertex(sourceVertex);
/* 138 */     targetGraph.addVertex(targetVertex);
/*     */     
/* 140 */     return targetGraph.addEdge(sourceVertex, targetVertex, edge);
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
/*     */   public static <V, E> E addEdgeWithVertices(Graph<V, E> g, V sourceVertex, V targetVertex, double weight)
/*     */   {
/* 163 */     g.addVertex(sourceVertex);
/* 164 */     g.addVertex(targetVertex);
/*     */     
/* 166 */     return (E)addEdge(g, sourceVertex, targetVertex, weight);
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
/*     */   public static <V, E> boolean addGraph(Graph<? super V, ? super E> destination, Graph<V, E> source)
/*     */   {
/* 190 */     boolean modified = addAllVertices(destination, source.vertexSet());
/* 191 */     modified |= addAllEdges(destination, source, source.edgeSet());
/*     */     
/* 193 */     return modified;
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
/*     */   public static <V, E> void addGraphReversed(DirectedGraph<? super V, ? super E> destination, DirectedGraph<V, E> source)
/*     */   {
/* 214 */     addAllVertices(destination, source.vertexSet());
/*     */     
/* 216 */     for (E edge : source.edgeSet()) {
/* 217 */       destination.addEdge(
/* 218 */         source.getEdgeTarget(edge), 
/* 219 */         source.getEdgeSource(edge));
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
/*     */ 
/*     */ 
/*     */   public static <V, E> boolean addAllEdges(Graph<? super V, ? super E> destination, Graph<V, E> source, Collection<? extends E> edges)
/*     */   {
/* 241 */     boolean modified = false;
/*     */     
/* 243 */     for (E e : edges) {
/* 244 */       V s = source.getEdgeSource(e);
/* 245 */       V t = source.getEdgeTarget(e);
/* 246 */       destination.addVertex(s);
/* 247 */       destination.addVertex(t);
/* 248 */       modified |= destination.addEdge(s, t, e);
/*     */     }
/*     */     
/* 251 */     return modified;
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
/*     */   public static <V, E> boolean addAllVertices(Graph<? super V, ? super E> destination, Collection<? extends V> vertices)
/*     */   {
/* 275 */     boolean modified = false;
/*     */     
/* 277 */     for (V v : vertices) {
/* 278 */       modified |= destination.addVertex(v);
/*     */     }
/*     */     
/* 281 */     return modified;
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
/*     */   public static <V, E> List<V> neighborListOf(Graph<V, E> g, V vertex)
/*     */   {
/* 298 */     List<V> neighbors = new ArrayList();
/*     */     
/* 300 */     for (E e : g.edgesOf(vertex)) {
/* 301 */       neighbors.add(getOppositeVertex(g, e, vertex));
/*     */     }
/*     */     
/* 304 */     return neighbors;
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
/*     */   public static <V, E> List<V> predecessorListOf(DirectedGraph<V, E> g, V vertex)
/*     */   {
/* 322 */     List<V> predecessors = new ArrayList();
/* 323 */     Set<? extends E> edges = g.incomingEdgesOf(vertex);
/*     */     
/* 325 */     for (E e : edges) {
/* 326 */       predecessors.add(getOppositeVertex(g, e, vertex));
/*     */     }
/*     */     
/* 329 */     return predecessors;
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
/*     */   public static <V, E> List<V> successorListOf(DirectedGraph<V, E> g, V vertex)
/*     */   {
/* 347 */     List<V> successors = new ArrayList();
/* 348 */     Set<? extends E> edges = g.outgoingEdgesOf(vertex);
/*     */     
/* 350 */     for (E e : edges) {
/* 351 */       successors.add(getOppositeVertex(g, e, vertex));
/*     */     }
/*     */     
/* 354 */     return successors;
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
/*     */   public static <V, E> UndirectedGraph<V, E> undirectedGraph(Graph<V, E> g)
/*     */   {
/* 374 */     if ((g instanceof DirectedGraph))
/* 375 */       return new AsUndirectedGraph((DirectedGraph)g);
/* 376 */     if ((g instanceof UndirectedGraph)) {
/* 377 */       return (UndirectedGraph)g;
/*     */     }
/* 379 */     throw new IllegalArgumentException(
/* 380 */       "Graph must be either DirectedGraph or UndirectedGraph");
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
/*     */   public static <V, E> boolean testIncidence(Graph<V, E> g, E e, V v)
/*     */   {
/* 396 */     return (g.getEdgeSource(e).equals(v)) || (g.getEdgeTarget(e).equals(v));
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
/*     */   public static <V, E> V getOppositeVertex(Graph<V, E> g, E e, V v)
/*     */   {
/* 410 */     V source = g.getEdgeSource(e);
/* 411 */     V target = g.getEdgeTarget(e);
/* 412 */     if (v.equals(source))
/* 413 */       return target;
/* 414 */     if (v.equals(target)) {
/* 415 */       return source;
/*     */     }
/* 417 */     throw new IllegalArgumentException("no such vertex");
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
/*     */   public static <V, E> List<V> getPathVertexList(GraphPath<V, E> path)
/*     */   {
/* 430 */     Graph<V, E> g = path.getGraph();
/* 431 */     List<V> list = new ArrayList();
/* 432 */     V v = path.getStartVertex();
/* 433 */     list.add(v);
/* 434 */     for (E e : path.getEdgeList()) {
/* 435 */       v = getOppositeVertex(g, e, v);
/* 436 */       list.add(v);
/*     */     }
/* 438 */     return list;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\Graphs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */