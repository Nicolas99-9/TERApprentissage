/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.UndirectedGraph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BiconnectivityInspector<V, E>
/*     */ {
/*     */   private BlockCutpointGraph<V, E> blockCutpointGraph;
/*     */   
/*     */   public BiconnectivityInspector(UndirectedGraph<V, E> graph)
/*     */   {
/*  70 */     this.blockCutpointGraph = new BlockCutpointGraph(graph);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<Set<V>> getBiconnectedVertexComponents()
/*     */   {
/*  80 */     Set<Set<V>> biconnectedVertexComponents = new HashSet();
/*     */     
/*  82 */     Iterator<UndirectedGraph<V, E>> iter = 
/*  83 */       this.blockCutpointGraph.vertexSet().iterator();
/*  81 */     while (
/*     */     
/*     */ 
/*  84 */       iter.hasNext())
/*     */     {
/*  86 */       UndirectedGraph<V, E> subgraph = (UndirectedGraph)iter.next();
/*  87 */       if (!subgraph.edgeSet().isEmpty()) {
/*  88 */         biconnectedVertexComponents.add(subgraph.vertexSet());
/*     */       }
/*     */     }
/*     */     
/*  92 */     return biconnectedVertexComponents;
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
/*     */   public Set<Set<V>> getBiconnectedVertexComponents(V vertex)
/*     */   {
/* 107 */     Set<Set<V>> vertexComponents = new HashSet();
/*     */     
/* 109 */     Iterator<Set<V>> iter = getBiconnectedVertexComponents().iterator();
/* 108 */     while (
/*     */     
/* 110 */       iter.hasNext())
/*     */     {
/* 112 */       Set<V> vertexComponent = (Set)iter.next();
/* 113 */       if (vertexComponent.contains(vertex)) {
/* 114 */         vertexComponents.add(vertexComponent);
/*     */       }
/*     */     }
/* 117 */     return vertexComponents;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<V> getCutpoints()
/*     */   {
/* 125 */     return this.blockCutpointGraph.getCutpoints();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isBiconnected()
/*     */   {
/* 134 */     return this.blockCutpointGraph.vertexSet().size() == 1;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\BiconnectivityInspector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */