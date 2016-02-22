/*     */ package org.jgrapht.graph;
/*     */ 
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
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
/*     */ public class DirectedSubgraph<V, E>
/*     */   extends Subgraph<V, E, DirectedGraph<V, E>>
/*     */   implements DirectedGraph<V, E>
/*     */ {
/*     */   private static final long serialVersionUID = 3616445700507054133L;
/*     */   
/*     */   public DirectedSubgraph(DirectedGraph<V, E> base, Set<V> vertexSubset, Set<E> edgeSubset)
/*     */   {
/*  80 */     super(base, vertexSubset, edgeSubset);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int inDegreeOf(V vertex)
/*     */   {
/*  90 */     assertVertexExist(vertex);
/*     */     
/*  92 */     int degree = 0;
/*     */     
/*  94 */     for (E e : ((DirectedGraph)getBase()).incomingEdgesOf(vertex)) {
/*  95 */       if (containsEdge(e)) {
/*  96 */         degree++;
/*     */       }
/*     */     }
/*     */     
/* 100 */     return degree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> incomingEdgesOf(V vertex)
/*     */   {
/* 108 */     assertVertexExist(vertex);
/*     */     
/* 110 */     Set<E> edges = new ArrayUnenforcedSet();
/*     */     
/* 112 */     for (E e : ((DirectedGraph)getBase()).incomingEdgesOf(vertex)) {
/* 113 */       if (containsEdge(e)) {
/* 114 */         edges.add(e);
/*     */       }
/*     */     }
/*     */     
/* 118 */     return edges;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int outDegreeOf(V vertex)
/*     */   {
/* 126 */     assertVertexExist(vertex);
/*     */     
/* 128 */     int degree = 0;
/*     */     
/* 130 */     for (E e : ((DirectedGraph)getBase()).outgoingEdgesOf(vertex)) {
/* 131 */       if (containsEdge(e)) {
/* 132 */         degree++;
/*     */       }
/*     */     }
/*     */     
/* 136 */     return degree;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> outgoingEdgesOf(V vertex)
/*     */   {
/* 144 */     assertVertexExist(vertex);
/*     */     
/* 146 */     Set<E> edges = new ArrayUnenforcedSet();
/*     */     
/* 148 */     for (E e : ((DirectedGraph)getBase()).outgoingEdgesOf(vertex)) {
/* 149 */       if (containsEdge(e)) {
/* 150 */         edges.add(e);
/*     */       }
/*     */     }
/*     */     
/* 154 */     return edges;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\DirectedSubgraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */