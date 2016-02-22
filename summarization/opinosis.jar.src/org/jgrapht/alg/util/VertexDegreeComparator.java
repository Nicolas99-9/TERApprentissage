/*     */ package org.jgrapht.alg.util;
/*     */ 
/*     */ import java.util.Comparator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VertexDegreeComparator<V, E>
/*     */   implements Comparator<V>
/*     */ {
/*     */   private UndirectedGraph<V, E> graph;
/*     */   private boolean ascendingOrder;
/*     */   
/*     */   public VertexDegreeComparator(UndirectedGraph<V, E> g)
/*     */   {
/*  82 */     this(g, true);
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
/*     */   public VertexDegreeComparator(UndirectedGraph<V, E> g, boolean ascendingOrder)
/*     */   {
/*  98 */     this.graph = g;
/*  99 */     this.ascendingOrder = ascendingOrder;
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
/*     */   public int compare(V v1, V v2)
/*     */   {
/* 116 */     int degree1 = this.graph.degreeOf(v1);
/* 117 */     int degree2 = this.graph.degreeOf(v2);
/*     */     
/* 119 */     if (((degree1 < degree2) && (this.ascendingOrder)) || (
/* 120 */       (degree1 > degree2) && (!this.ascendingOrder)))
/*     */     {
/* 122 */       return -1;
/*     */     }
/* 124 */     if (((degree1 > degree2) && (this.ascendingOrder)) || (
/* 125 */       (degree1 < degree2) && (!this.ascendingOrder)))
/*     */     {
/* 127 */       return 1;
/*     */     }
/* 129 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\util\VertexDegreeComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */