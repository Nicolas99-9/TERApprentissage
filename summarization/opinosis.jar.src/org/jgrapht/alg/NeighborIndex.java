/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.Graphs;
/*     */ import org.jgrapht.event.GraphEdgeChangeEvent;
/*     */ import org.jgrapht.event.GraphListener;
/*     */ import org.jgrapht.event.GraphVertexChangeEvent;
/*     */ import org.jgrapht.util.ModifiableInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NeighborIndex<V, E>
/*     */   implements GraphListener<V, E>
/*     */ {
/*  71 */   Map<V, Neighbors<V, E>> neighborMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private Graph<V, E> graph;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public NeighborIndex(Graph<V, E> g)
/*     */   {
/*  84 */     this.graph = g;
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
/*     */   public Set<V> neighborsOf(V v)
/*     */   {
/* 100 */     return getNeighbors(v).getNeighbors();
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
/*     */   public List<V> neighborListOf(V v)
/*     */   {
/* 117 */     return getNeighbors(v).getNeighborList();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void edgeAdded(GraphEdgeChangeEvent<V, E> e)
/*     */   {
/* 125 */     E edge = e.getEdge();
/* 126 */     V source = this.graph.getEdgeSource(edge);
/* 127 */     V target = this.graph.getEdgeTarget(edge);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 134 */     if (this.neighborMap.containsKey(source)) {
/* 135 */       getNeighbors(source).addNeighbor(target);
/*     */     } else {
/* 137 */       getNeighbors(source);
/*     */     }
/* 139 */     if (this.neighborMap.containsKey(target)) {
/* 140 */       getNeighbors(target).addNeighbor(source);
/*     */     } else {
/* 142 */       getNeighbors(target);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void edgeRemoved(GraphEdgeChangeEvent<V, E> e)
/*     */   {
/* 151 */     E edge = e.getEdge();
/* 152 */     V source = this.graph.getEdgeSource(edge);
/* 153 */     V target = this.graph.getEdgeTarget(edge);
/* 154 */     if (this.neighborMap.containsKey(source)) {
/* 155 */       ((Neighbors)this.neighborMap.get(source)).removeNeighbor(target);
/*     */     }
/* 157 */     if (this.neighborMap.containsKey(target)) {
/* 158 */       ((Neighbors)this.neighborMap.get(target)).removeNeighbor(source);
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
/* 175 */     this.neighborMap.remove(e.getVertex());
/*     */   }
/*     */   
/*     */   private Neighbors<V, E> getNeighbors(V v)
/*     */   {
/* 180 */     Neighbors<V, E> neighbors = (Neighbors)this.neighborMap.get(v);
/* 181 */     if (neighbors == null) {
/* 182 */       neighbors = new Neighbors(v, 
/* 183 */         Graphs.neighborListOf(this.graph, v));
/* 184 */       this.neighborMap.put(v, neighbors);
/*     */     }
/* 186 */     return neighbors;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static class Neighbors<V, E>
/*     */   {
/* 198 */     private Map<V, ModifiableInteger> neighborCounts = new LinkedHashMap();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 203 */     private Set<V> neighborSet = Collections.unmodifiableSet(
/* 204 */       this.neighborCounts.keySet());
/*     */     
/*     */ 
/*     */     public Neighbors(V v, Collection<V> neighbors)
/*     */     {
/* 209 */       for (V neighbor : neighbors) {
/* 210 */         addNeighbor(neighbor);
/*     */       }
/*     */     }
/*     */     
/*     */     public void addNeighbor(V v)
/*     */     {
/* 216 */       ModifiableInteger count = (ModifiableInteger)this.neighborCounts.get(v);
/* 217 */       if (count == null) {
/* 218 */         count = new ModifiableInteger(1);
/* 219 */         this.neighborCounts.put(v, count);
/*     */       } else {
/* 221 */         count.increment();
/*     */       }
/*     */     }
/*     */     
/*     */     public void removeNeighbor(V v)
/*     */     {
/* 227 */       ModifiableInteger count = (ModifiableInteger)this.neighborCounts.get(v);
/* 228 */       if (count == null) {
/* 229 */         throw new IllegalArgumentException(
/* 230 */           "Attempting to remove a neighbor that wasn't present");
/*     */       }
/*     */       
/* 233 */       count.decrement();
/* 234 */       if (count.getValue() == 0) {
/* 235 */         this.neighborCounts.remove(v);
/*     */       }
/*     */     }
/*     */     
/*     */     public Set<V> getNeighbors()
/*     */     {
/* 241 */       return this.neighborSet;
/*     */     }
/*     */     
/*     */     public List<V> getNeighborList()
/*     */     {
/* 246 */       List<V> neighbors = new ArrayList();
/*     */       
/*     */ 
/* 249 */       Iterator localIterator = this.neighborCounts.entrySet().iterator();
/*     */       int count;
/*     */       int i;
/* 248 */       for (; localIterator.hasNext(); 
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 253 */           i < count)
/*     */       {
/* 249 */         Map.Entry<V, ModifiableInteger> entry = (Map.Entry)localIterator.next();
/*     */         
/* 251 */         V v = entry.getKey();
/* 252 */         count = ((ModifiableInteger)entry.getValue()).intValue();
/* 253 */         i = 0; continue;
/* 254 */         neighbors.add(v);i++;
/*     */       }
/*     */       
/*     */ 
/* 257 */       return neighbors;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\NeighborIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */