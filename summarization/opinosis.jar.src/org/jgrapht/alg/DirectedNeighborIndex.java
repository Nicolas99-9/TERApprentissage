/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
/*     */ import org.jgrapht.Graphs;
/*     */ import org.jgrapht.event.GraphEdgeChangeEvent;
/*     */ import org.jgrapht.event.GraphListener;
/*     */ import org.jgrapht.event.GraphVertexChangeEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DirectedNeighborIndex<V, E>
/*     */   implements GraphListener<V, E>
/*     */ {
/*  67 */   Map<V, NeighborIndex.Neighbors<V, E>> predecessorMap = new HashMap();
/*  68 */   Map<V, NeighborIndex.Neighbors<V, E>> successorMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private DirectedGraph<V, E> graph;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public DirectedNeighborIndex(DirectedGraph<V, E> g)
/*     */   {
/*  80 */     this.graph = g;
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
/*     */   public Set<V> predecessorsOf(V v)
/*     */   {
/*  97 */     return getPredecessors(v).getNeighbors();
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
/*     */   public List<V> predecessorListOf(V v)
/*     */   {
/* 114 */     return getPredecessors(v).getNeighborList();
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
/*     */   public Set<V> successorsOf(V v)
/*     */   {
/* 129 */     return getSuccessors(v).getNeighbors();
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
/*     */   public List<V> successorListOf(V v)
/*     */   {
/* 146 */     return getSuccessors(v).getNeighborList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void edgeAdded(GraphEdgeChangeEvent<V, E> e)
/*     */   {
/* 154 */     E edge = e.getEdge();
/* 155 */     V source = this.graph.getEdgeSource(edge);
/* 156 */     V target = this.graph.getEdgeTarget(edge);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 163 */     if (this.successorMap.containsKey(source)) {
/* 164 */       getSuccessors(source).addNeighbor(target);
/*     */     } else {
/* 166 */       getSuccessors(source);
/*     */     }
/* 168 */     if (this.predecessorMap.containsKey(target)) {
/* 169 */       getPredecessors(target).addNeighbor(source);
/*     */     } else {
/* 171 */       getPredecessors(target);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void edgeRemoved(GraphEdgeChangeEvent<V, E> e)
/*     */   {
/* 180 */     E edge = e.getEdge();
/* 181 */     V source = this.graph.getEdgeSource(edge);
/* 182 */     V target = this.graph.getEdgeTarget(edge);
/* 183 */     if (this.successorMap.containsKey(source)) {
/* 184 */       ((NeighborIndex.Neighbors)this.successorMap.get(source)).removeNeighbor(target);
/*     */     }
/* 186 */     if (this.predecessorMap.containsKey(target)) {
/* 187 */       ((NeighborIndex.Neighbors)this.predecessorMap.get(target)).removeNeighbor(source);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void vertexAdded(GraphVertexChangeEvent<V> e) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void vertexRemoved(GraphVertexChangeEvent<V> e)
/*     */   {
/* 204 */     this.predecessorMap.remove(e.getVertex());
/* 205 */     this.successorMap.remove(e.getVertex());
/*     */   }
/*     */   
/*     */   private NeighborIndex.Neighbors<V, E> getPredecessors(V v)
/*     */   {
/* 210 */     NeighborIndex.Neighbors<V, E> neighbors = (NeighborIndex.Neighbors)this.predecessorMap.get(v);
/* 211 */     if (neighbors == null) {
/* 212 */       neighbors = 
/* 213 */         new NeighborIndex.Neighbors(v, 
/* 214 */         Graphs.predecessorListOf(this.graph, v));
/* 215 */       this.predecessorMap.put(v, neighbors);
/*     */     }
/* 217 */     return neighbors;
/*     */   }
/*     */   
/*     */   private NeighborIndex.Neighbors<V, E> getSuccessors(V v)
/*     */   {
/* 222 */     NeighborIndex.Neighbors<V, E> neighbors = (NeighborIndex.Neighbors)this.successorMap.get(v);
/* 223 */     if (neighbors == null) {
/* 224 */       neighbors = 
/* 225 */         new NeighborIndex.Neighbors(v, 
/* 226 */         Graphs.successorListOf(this.graph, v));
/* 227 */       this.successorMap.put(v, neighbors);
/*     */     }
/* 229 */     return neighbors;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\DirectedNeighborIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */