/*     */ package org.jgrapht.experimental.isomorphism;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.experimental.equivalence.EquivalenceComparator;
/*     */ import org.jgrapht.experimental.permutation.CollectionPermutationIter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PermutationIsomorphismInspector<V, E>
/*     */   extends AbstractExhaustiveIsomorphismInspector<V, E>
/*     */ {
/*     */   public PermutationIsomorphismInspector(Graph<V, E> graph1, Graph<V, E> graph2, EquivalenceComparator<? super V, ? super Graph<? super V, ? super E>> vertexChecker, EquivalenceComparator<? super E, ? super Graph<? super V, ? super E>> edgeChecker)
/*     */   {
/*  80 */     super(graph1, graph2, vertexChecker, edgeChecker);
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
/*     */   public PermutationIsomorphismInspector(Graph<V, E> graph1, Graph<V, E> graph2)
/*     */   {
/*  93 */     super(graph1, graph2);
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
/*     */   protected CollectionPermutationIter<V> createPermutationIterator(Set<V> vertexSet1, Set<V> vertexSet2)
/*     */   {
/* 112 */     return new CollectionPermutationIter(vertexSet2);
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
/*     */   protected boolean areVertexSetsOfTheSameEqualityGroup(Set<V> vertexSet1, Set<V> vertexSet2)
/*     */   {
/* 128 */     if (vertexSet1.size() != vertexSet2.size()) {
/* 129 */       return false;
/*     */     }
/* 131 */     Iterator<V> iter2 = vertexSet2.iterator();
/*     */     
/*     */ 
/* 134 */     for (Iterator<V> iter1 = vertexSet1.iterator(); iter1.hasNext();) {
/* 135 */       V vertex1 = iter1.next();
/* 136 */       V vertex2 = iter2.next();
/* 137 */       if (!this.vertexComparator.equivalenceCompare(
/* 138 */         vertex1, 
/* 139 */         vertex2, 
/* 140 */         this.graph1, 
/* 141 */         this.graph2))
/*     */       {
/* 143 */         return false;
/*     */       }
/*     */     }
/* 146 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\isomorphism\PermutationIsomorphismInspector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */