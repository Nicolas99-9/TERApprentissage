/*     */ package org.jgrapht.graph;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UndirectedSubgraph<V, E>
/*     */   extends Subgraph<V, E, UndirectedGraph<V, E>>
/*     */   implements UndirectedGraph<V, E>
/*     */ {
/*     */   private static final long serialVersionUID = 3256728359772631350L;
/*     */   
/*     */   public UndirectedSubgraph(UndirectedGraph<V, E> base, Set<V> vertexSubset, Set<E> edgeSubset)
/*     */   {
/*  78 */     super(base, vertexSubset, edgeSubset);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int degreeOf(V vertex)
/*     */   {
/*  88 */     assertVertexExist(vertex);
/*     */     
/*  90 */     int degree = 0;
/*     */     
/*  92 */     for (E e : ((UndirectedGraph)getBase()).edgesOf(vertex)) {
/*  93 */       if (containsEdge(e)) {
/*  94 */         degree++;
/*     */         
/*  96 */         if (getEdgeSource(e).equals(getEdgeTarget(e))) {
/*  97 */           degree++;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 102 */     return degree;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\UndirectedSubgraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */