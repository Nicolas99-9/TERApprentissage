/*     */ package org.jgrapht.graph;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.EdgeFactory;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.ListenableGraph;
/*     */ import org.jgrapht.WeightedGraph;
/*     */ import org.jgrapht.event.GraphEdgeChangeEvent;
/*     */ import org.jgrapht.event.GraphListener;
/*     */ import org.jgrapht.event.GraphVertexChangeEvent;
/*     */ import org.jgrapht.util.ArrayUnenforcedSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Subgraph<V, E, G extends Graph<V, E>>
/*     */   extends AbstractGraph<V, E>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3208313055169665387L;
/*     */   private static final String NO_SUCH_EDGE_IN_BASE = "no such edge in base graph";
/*     */   private static final String NO_SUCH_VERTEX_IN_BASE = "no such vertex in base graph";
/* 123 */   Set<E> edgeSet = new LinkedHashSet();
/* 124 */   Set<V> vertexSet = new LinkedHashSet();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 129 */   private transient Set<E> unmodifiableEdgeSet = null;
/* 130 */   private transient Set<V> unmodifiableVertexSet = null;
/*     */   private G base;
/* 132 */   private boolean isInduced = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Subgraph(G base, Set<V> vertexSubset, Set<E> edgeSubset)
/*     */   {
/* 150 */     this.base = base;
/*     */     
/* 152 */     if (edgeSubset == null) {
/* 153 */       this.isInduced = true;
/*     */     }
/*     */     
/* 156 */     if ((base instanceof ListenableGraph)) {
/* 157 */       ((ListenableGraph)base).addGraphListener(
/* 158 */         new BaseGraphListener(null));
/*     */     }
/*     */     
/* 161 */     addVerticesUsingFilter(base.vertexSet(), vertexSubset);
/* 162 */     addEdgesUsingFilter(base.edgeSet(), edgeSubset);
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
/*     */   public Subgraph(G base, Set<V> vertexSubset)
/*     */   {
/* 177 */     this(base, vertexSubset, null);
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
/*     */   public V getRandomVertex()
/*     */   {
/* 190 */     V vertex = null;
/* 191 */     if (this.vertexSet != null)
/* 192 */       vertex = this.vertexSet.iterator().next();
/* 193 */     return vertex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> getAllEdges(V sourceVertex, V targetVertex)
/*     */   {
/* 203 */     Set<E> edges = null;
/*     */     
/* 205 */     if ((containsVertex(sourceVertex)) && (containsVertex(targetVertex))) {
/* 206 */       edges = new ArrayUnenforcedSet();
/*     */       
/* 208 */       Set<E> baseEdges = this.base.getAllEdges(sourceVertex, targetVertex);
/*     */       
/* 210 */       for (Iterator<E> iter = baseEdges.iterator(); iter.hasNext();) {
/* 211 */         E e = iter.next();
/*     */         
/* 213 */         if (this.edgeSet.contains(e))
/*     */         {
/* 215 */           edges.add(e);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 220 */     return edges;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public E getEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 228 */     Set<E> edges = getAllEdges(sourceVertex, targetVertex);
/*     */     
/* 230 */     if ((edges == null) || (edges.isEmpty())) {
/* 231 */       return null;
/*     */     }
/* 233 */     return (E)edges.iterator().next();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public EdgeFactory<V, E> getEdgeFactory()
/*     */   {
/* 242 */     return this.base.getEdgeFactory();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public E addEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 250 */     assertVertexExist(sourceVertex);
/* 251 */     assertVertexExist(targetVertex);
/*     */     
/* 253 */     if (!this.base.containsEdge(sourceVertex, targetVertex)) {
/* 254 */       throw new IllegalArgumentException("no such edge in base graph");
/*     */     }
/*     */     
/* 257 */     Set<E> edges = this.base.getAllEdges(sourceVertex, targetVertex);
/*     */     
/* 259 */     for (Iterator<E> iter = edges.iterator(); iter.hasNext();) {
/* 260 */       E e = iter.next();
/*     */       
/* 262 */       if (!containsEdge(e)) {
/* 263 */         this.edgeSet.add(e);
/*     */         
/* 265 */         return e;
/*     */       }
/*     */     }
/*     */     
/* 269 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addEdge(V sourceVertex, V targetVertex, E e)
/*     */   {
/* 277 */     if (e == null) {
/* 278 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 281 */     if (!this.base.containsEdge(e)) {
/* 282 */       throw new IllegalArgumentException("no such edge in base graph");
/*     */     }
/*     */     
/* 285 */     assertVertexExist(sourceVertex);
/* 286 */     assertVertexExist(targetVertex);
/*     */     
/* 288 */     assert (this.base.getEdgeSource(e) == sourceVertex);
/* 289 */     assert (this.base.getEdgeTarget(e) == targetVertex);
/*     */     
/* 291 */     if (containsEdge(e)) {
/* 292 */       return false;
/*     */     }
/* 294 */     this.edgeSet.add(e);
/*     */     
/* 296 */     return true;
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
/*     */   public boolean addVertex(V v)
/*     */   {
/* 316 */     if (v == null) {
/* 317 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 320 */     if (!this.base.containsVertex(v)) {
/* 321 */       throw new IllegalArgumentException("no such vertex in base graph");
/*     */     }
/*     */     
/* 324 */     if (containsVertex(v)) {
/* 325 */       return false;
/*     */     }
/* 327 */     this.vertexSet.add(v);
/*     */     
/* 329 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean containsEdge(E e)
/*     */   {
/* 338 */     return this.edgeSet.contains(e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean containsVertex(V v)
/*     */   {
/* 346 */     return this.vertexSet.contains(v);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> edgeSet()
/*     */   {
/* 354 */     if (this.unmodifiableEdgeSet == null) {
/* 355 */       this.unmodifiableEdgeSet = Collections.unmodifiableSet(this.edgeSet);
/*     */     }
/*     */     
/* 358 */     return this.unmodifiableEdgeSet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> edgesOf(V vertex)
/*     */   {
/* 366 */     assertVertexExist(vertex);
/*     */     
/* 368 */     Set<E> edges = new ArrayUnenforcedSet();
/* 369 */     Set<E> baseEdges = this.base.edgesOf(vertex);
/*     */     
/* 371 */     for (E e : baseEdges) {
/* 372 */       if (containsEdge(e)) {
/* 373 */         edges.add(e);
/*     */       }
/*     */     }
/*     */     
/* 377 */     return edges;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeEdge(E e)
/*     */   {
/* 385 */     return this.edgeSet.remove(e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public E removeEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 393 */     E e = getEdge(sourceVertex, targetVertex);
/*     */     
/* 395 */     return this.edgeSet.remove(e) ? e : null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeVertex(V v)
/*     */   {
/* 406 */     if ((containsVertex(v)) && (this.base.containsVertex(v))) {
/* 407 */       removeAllEdges(edgesOf(v));
/*     */     }
/*     */     
/* 410 */     return this.vertexSet.remove(v);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<V> vertexSet()
/*     */   {
/* 418 */     if (this.unmodifiableVertexSet == null) {
/* 419 */       this.unmodifiableVertexSet = Collections.unmodifiableSet(this.vertexSet);
/*     */     }
/*     */     
/* 422 */     return this.unmodifiableVertexSet;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public V getEdgeSource(E e)
/*     */   {
/* 430 */     return (V)this.base.getEdgeSource(e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public V getEdgeTarget(E e)
/*     */   {
/* 438 */     return (V)this.base.getEdgeTarget(e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addEdgesUsingFilter(Set<E> edgeSet, Set<E> filter)
/*     */   {
/* 447 */     for (Iterator<E> iter = edgeSet.iterator(); iter.hasNext();) {
/* 448 */       E e = iter.next();
/*     */       
/* 450 */       V sourceVertex = this.base.getEdgeSource(e);
/* 451 */       V targetVertex = this.base.getEdgeTarget(e);
/* 452 */       boolean containsVertices = 
/* 453 */         (containsVertex(sourceVertex)) && 
/* 454 */         (containsVertex(targetVertex));
/*     */       
/*     */ 
/* 457 */       boolean edgeIncluded = (filter == null) || (filter.contains(e));
/*     */       
/* 459 */       if ((containsVertices) && (edgeIncluded)) {
/* 460 */         addEdge(sourceVertex, targetVertex, e);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void addVerticesUsingFilter(Set<V> vertexSet, Set<V> filter)
/*     */   {
/* 469 */     for (Iterator<V> iter = vertexSet.iterator(); iter.hasNext();) {
/* 470 */       V v = iter.next();
/*     */       
/*     */ 
/* 473 */       if ((filter == null) || (filter.contains(v))) {
/* 474 */         addVertex(v);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public G getBase()
/*     */   {
/* 481 */     return this.base;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getEdgeWeight(E e)
/*     */   {
/* 489 */     return this.base.getEdgeWeight(e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEdgeWeight(E e, double weight)
/*     */   {
/* 497 */     ((WeightedGraph)this.base).setEdgeWeight(e, weight);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private class BaseGraphListener
/*     */     implements GraphListener<V, E>, Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 4343535244243546391L;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private BaseGraphListener() {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void edgeAdded(GraphEdgeChangeEvent<V, E> e)
/*     */     {
/* 519 */       if (Subgraph.this.isInduced) {
/* 520 */         E edge = e.getEdge();
/* 521 */         Subgraph.this.addEdge(
/* 522 */           Subgraph.this.base.getEdgeSource(edge), 
/* 523 */           Subgraph.this.base.getEdgeTarget(edge), 
/* 524 */           edge);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void edgeRemoved(GraphEdgeChangeEvent<V, E> e)
/*     */     {
/* 533 */       E edge = e.getEdge();
/*     */       
/* 535 */       Subgraph.this.removeEdge(edge);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void vertexAdded(GraphVertexChangeEvent<V> e) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void vertexRemoved(GraphVertexChangeEvent<V> e)
/*     */     {
/* 551 */       V vertex = e.getVertex();
/*     */       
/* 553 */       Subgraph.this.removeVertex(vertex);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\Subgraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */