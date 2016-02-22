/*     */ package org.jgrapht.experimental.isomorphism;
/*     */ 
/*     */ import org.jgrapht.DirectedGraph;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.UndirectedGraph;
/*     */ import org.jgrapht.experimental.equivalence.EquivalenceComparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VertexDegreeEquivalenceComparator<V, E>
/*     */   implements EquivalenceComparator<V, Graph<V, E>>
/*     */ {
/*     */   public boolean equivalenceCompare(V vertex1, V vertex2, Graph<V, E> context1, Graph<V, E> context2)
/*     */   {
/*  88 */     VertexDegreeEquivalenceComparator<V, E>.InOutDegrees inOut1 = getInOutDegrees(context1, vertex1);
/*  89 */     VertexDegreeEquivalenceComparator<V, E>.InOutDegrees inOut2 = getInOutDegrees(context2, vertex2);
/*  90 */     boolean result = inOut1.equals(inOut2);
/*  91 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int equivalenceHashcode(V vertex, Graph<V, E> context)
/*     */   {
/* 101 */     VertexDegreeEquivalenceComparator<V, E>.InOutDegrees inOut = getInOutDegrees(context, vertex);
/*     */     
/*     */ 
/* 104 */     StringBuffer sb = new StringBuffer();
/* 105 */     sb.append(String.valueOf(inOut.inDegree));
/* 106 */     sb.append("-");
/* 107 */     sb.append(String.valueOf(inOut.outDegree));
/* 108 */     return sb.toString().hashCode();
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
/*     */   protected VertexDegreeEquivalenceComparator<V, E>.InOutDegrees getInOutDegrees(Graph<V, E> aContextGraph, V vertex)
/*     */   {
/* 122 */     int inVertexDegree = 0;
/* 123 */     int outVertexDegree = 0;
/* 124 */     if ((aContextGraph instanceof UndirectedGraph)) {
/* 125 */       UndirectedGraph<V, E> undirectedGraph = 
/* 126 */         (UndirectedGraph)aContextGraph;
/* 127 */       inVertexDegree = undirectedGraph.degreeOf(vertex);
/* 128 */       outVertexDegree = inVertexDegree;
/* 129 */     } else if ((aContextGraph instanceof DirectedGraph)) {
/* 130 */       DirectedGraph<V, E> directedGraph = 
/* 131 */         (DirectedGraph)aContextGraph;
/* 132 */       inVertexDegree = directedGraph.inDegreeOf(vertex);
/* 133 */       outVertexDegree = directedGraph.outDegreeOf(vertex);
/*     */     } else {
/* 135 */       throw new RuntimeException(
/* 136 */         "contextGraph is of unsupported type . It must be one of these two : UndirectedGraph or DirectedGraph");
/*     */     }
/*     */     
/* 139 */     return new InOutDegrees(inVertexDegree, outVertexDegree);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected class InOutDegrees
/*     */   {
/*     */     public int inDegree;
/*     */     
/*     */ 
/*     */ 
/*     */     public int outDegree;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public InOutDegrees(int aInDegree, int aOutDegree)
/*     */     {
/* 159 */       this.inDegree = aInDegree;
/* 160 */       this.outDegree = aOutDegree;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 172 */       VertexDegreeEquivalenceComparator<V, E>.InOutDegrees other = (InOutDegrees)obj;
/*     */       
/* 174 */       return (this.inDegree == other.inDegree) && (this.outDegree == other.outDegree);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\isomorphism\VertexDegreeEquivalenceComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */