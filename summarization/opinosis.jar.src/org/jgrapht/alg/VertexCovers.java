/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.UndirectedGraph;
/*     */ import org.jgrapht.alg.util.VertexDegreeComparator;
/*     */ import org.jgrapht.graph.Subgraph;
/*     */ import org.jgrapht.graph.UndirectedSubgraph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class VertexCovers
/*     */ {
/*     */   public static <V, E> Set<V> find2ApproximationCover(Graph<V, E> g)
/*     */   {
/*  86 */     Set<V> cover = new HashSet();
/*     */     
/*     */ 
/*  89 */     Subgraph<V, E, Graph<V, E>> sg = 
/*  90 */       new Subgraph(
/*  91 */       g, 
/*  92 */       null, 
/*  93 */       null);
/*     */     
/*     */ 
/*  96 */     while (sg.edgeSet().size() > 0)
/*     */     {
/*  98 */       E e = sg.edgeSet().iterator().next();
/*     */       
/*     */ 
/* 101 */       V u = g.getEdgeSource(e);
/* 102 */       V v = g.getEdgeTarget(e);
/* 103 */       cover.add(u);
/* 104 */       cover.add(v);
/*     */       
/*     */ 
/* 107 */       sg.removeVertex(u);
/* 108 */       sg.removeVertex(v);
/*     */     }
/*     */     
/* 111 */     return cover;
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
/*     */   public static <V, E> Set<V> findGreedyCover(UndirectedGraph<V, E> g)
/*     */   {
/* 132 */     Set<V> cover = new HashSet();
/*     */     
/*     */ 
/* 135 */     UndirectedGraph<V, E> sg = new UndirectedSubgraph(g, null, null);
/*     */     
/*     */ 
/* 138 */     VertexDegreeComparator<V, E> comp = 
/* 139 */       new VertexDegreeComparator(sg);
/*     */     
/*     */ 
/* 142 */     while (sg.edgeSet().size() > 0)
/*     */     {
/* 144 */       V v = Collections.max(sg.vertexSet(), comp);
/*     */       
/*     */ 
/* 147 */       cover.add(v);
/*     */       
/*     */ 
/* 150 */       sg.removeVertex(v);
/*     */     }
/*     */     
/* 153 */     return cover;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\VertexCovers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */