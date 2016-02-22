/*     */ package org.jgrapht.experimental.isomorphism;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.experimental.equivalence.EquivalenceComparator;
/*     */ import org.jgrapht.experimental.equivalence.UniformEquivalenceComparator;
/*     */ import org.jgrapht.experimental.permutation.CollectionPermutationIter;
/*     */ import org.jgrapht.util.PrefetchIterator;
/*     */ import org.jgrapht.util.PrefetchIterator.NextElementFunctor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class AbstractExhaustiveIsomorphismInspector<V, E>
/*     */   implements GraphIsomorphismInspector<IsomorphismRelation>
/*     */ {
/*  65 */   public static EquivalenceComparator<Object, Object> edgeDefaultIsomorphismComparator = new UniformEquivalenceComparator();
/*     */   
/*     */ 
/*  68 */   public static EquivalenceComparator<Object, Object> vertexDefaultIsomorphismComparator = new UniformEquivalenceComparator();
/*     */   
/*     */ 
/*     */ 
/*     */   protected EquivalenceComparator<? super E, ? super Graph<V, ? super E>> edgeComparator;
/*     */   
/*     */ 
/*     */ 
/*     */   protected EquivalenceComparator<? super V, ? super Graph<? super V, E>> vertexComparator;
/*     */   
/*     */ 
/*     */ 
/*     */   protected Graph<V, E> graph1;
/*     */   
/*     */ 
/*     */ 
/*     */   protected Graph<V, E> graph2;
/*     */   
/*     */ 
/*     */ 
/*     */   private PrefetchIterator<IsomorphismRelation> nextSupplier;
/*     */   
/*     */ 
/*     */ 
/*     */   private GraphOrdering lableGraph1;
/*     */   
/*     */ 
/*     */   private LinkedHashSet<V> graph1VertexSet;
/*     */   
/*     */ 
/*     */   private LinkedHashSet<E> graph2EdgeSet;
/*     */   
/*     */ 
/*     */   private CollectionPermutationIter<V> vertexPermuteIter;
/*     */   
/*     */ 
/*     */   private Set<V> currVertexPermutation;
/*     */   
/*     */ 
/*     */ 
/*     */   public AbstractExhaustiveIsomorphismInspector(Graph<V, E> graph1, Graph<V, E> graph2, EquivalenceComparator<? super V, ? super Graph<? super V, ? super E>> vertexChecker, EquivalenceComparator<? super E, ? super Graph<? super V, ? super E>> edgeChecker)
/*     */   {
/* 110 */     this.graph1 = graph1;
/* 111 */     this.graph2 = graph2;
/*     */     
/* 113 */     if (vertexChecker != null) {
/* 114 */       this.vertexComparator = vertexChecker;
/*     */     } else {
/* 116 */       this.vertexComparator = vertexDefaultIsomorphismComparator;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 123 */     if (edgeChecker != null) {
/* 124 */       this.edgeComparator = edgeChecker;
/*     */     }
/*     */     
/* 127 */     init();
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
/*     */   public AbstractExhaustiveIsomorphismInspector(Graph<V, E> graph1, Graph<V, E> graph2)
/*     */   {
/* 146 */     this(graph1, graph2, edgeDefaultIsomorphismComparator, vertexDefaultIsomorphismComparator);
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
/*     */   private void init()
/*     */   {
/* 167 */     this.nextSupplier = 
/* 168 */       new PrefetchIterator(
/*     */       
/* 170 */       new NextFunctor(null));
/*     */     
/* 172 */     this.graph1VertexSet = new LinkedHashSet(this.graph1.vertexSet());
/*     */     
/*     */ 
/* 175 */     this.vertexPermuteIter = 
/* 176 */       createPermutationIterator(
/* 177 */       this.graph1VertexSet, 
/* 178 */       this.graph2.vertexSet());
/*     */     
/* 180 */     this.lableGraph1 = 
/* 181 */       new GraphOrdering(
/* 182 */       this.graph1, 
/* 183 */       this.graph1VertexSet, 
/* 184 */       this.graph1.edgeSet());
/*     */     
/* 186 */     this.graph2EdgeSet = new LinkedHashSet(this.graph2.edgeSet());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected abstract CollectionPermutationIter<V> createPermutationIterator(Set<V> paramSet1, Set<V> paramSet2);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private IsomorphismRelation<V, E> findNextIsomorphicGraph()
/*     */   {
/* 245 */     boolean result = false;
/* 246 */     IsomorphismRelation<V, E> resultRelation = null;
/* 247 */     if (this.vertexPermuteIter != null)
/*     */     {
/* 249 */       while (this.vertexPermuteIter.hasNext()) {
/* 250 */         this.currVertexPermutation = this.vertexPermuteIter.getNextSet();
/*     */         
/*     */ 
/* 253 */         if (areVertexSetsOfTheSameEqualityGroup(
/* 254 */           this.graph1VertexSet, 
/* 255 */           this.currVertexPermutation))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 261 */           GraphOrdering<V, E> currPermuteGraph = 
/* 262 */             new GraphOrdering(
/* 263 */             this.graph2, 
/* 264 */             this.currVertexPermutation, 
/* 265 */             this.graph2EdgeSet);
/*     */           
/*     */ 
/* 268 */           if (this.lableGraph1.equalsByEdgeOrder(currPermuteGraph))
/*     */           {
/* 270 */             resultRelation = 
/* 271 */               new IsomorphismRelation(
/* 272 */               new ArrayList(this.graph1VertexSet), 
/* 273 */               new ArrayList(this.currVertexPermutation), 
/* 274 */               this.graph1, 
/* 275 */               this.graph2);
/*     */             
/*     */ 
/* 278 */             boolean edgeEq = 
/* 279 */               areAllEdgesEquivalent(
/* 280 */               resultRelation, 
/* 281 */               this.edgeComparator);
/* 282 */             if (edgeEq)
/*     */             {
/*     */ 
/* 285 */               result = true;
/* 286 */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 292 */     if (result) {
/* 293 */       return resultRelation;
/*     */     }
/* 295 */     return null;
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
/*     */   protected abstract boolean areVertexSetsOfTheSameEqualityGroup(Set<V> paramSet1, Set<V> paramSet2);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean areAllEdgesEquivalent(IsomorphismRelation<V, E> resultRelation, EquivalenceComparator<? super E, ? super Graph<V, E>> edgeComparator)
/*     */   {
/* 323 */     boolean checkResult = true;
/*     */     
/* 325 */     if (edgeComparator == null)
/*     */     {
/* 327 */       return true;
/*     */     }
/*     */     try
/*     */     {
/* 331 */       Set<E> edgeSet = this.graph1.edgeSet();
/*     */       
/* 333 */       for (E currEdge : edgeSet) {
/* 334 */         E correspondingEdge = 
/* 335 */           resultRelation.getEdgeCorrespondence(currEdge, true);
/*     */         
/*     */ 
/* 338 */         if (!edgeComparator.equivalenceCompare(
/* 339 */           currEdge, 
/* 340 */           correspondingEdge, 
/* 341 */           this.graph1, 
/* 342 */           this.graph2))
/*     */         {
/* 344 */           checkResult = false;
/* 345 */           break;
/*     */         }
/*     */       }
/*     */     } catch (IllegalArgumentException illegal) {
/* 349 */       checkResult = false;
/*     */     }
/*     */     
/* 352 */     return checkResult;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public IsomorphismRelation nextIsoRelation()
/*     */   {
/* 360 */     return next();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isIsomorphic()
/*     */   {
/* 372 */     return !this.nextSupplier.isEnumerationStartedEmpty();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasNext()
/*     */   {
/* 380 */     boolean result = this.nextSupplier.hasMoreElements();
/*     */     
/* 382 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public IsomorphismRelation next()
/*     */   {
/* 390 */     return (IsomorphismRelation)this.nextSupplier.nextElement();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void remove()
/*     */   {
/* 398 */     throw new UnsupportedOperationException(
/* 399 */       "remove() method is not supported in AdaptiveIsomorphismInspectorFactory. There is no meaning to removing an isomorphism result.");
/*     */   }
/*     */   
/*     */ 
/*     */   private class NextFunctor
/*     */     implements PrefetchIterator.NextElementFunctor<IsomorphismRelation>
/*     */   {
/*     */     private NextFunctor() {}
/*     */     
/*     */     public IsomorphismRelation nextElement()
/*     */       throws NoSuchElementException
/*     */     {
/* 411 */       IsomorphismRelation resultRelation = AbstractExhaustiveIsomorphismInspector.this.findNextIsomorphicGraph();
/* 412 */       if (resultRelation != null) {
/* 413 */         return resultRelation;
/*     */       }
/* 415 */       throw new NoSuchElementException(
/* 416 */         "IsomorphismInspector does not have any more elements");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\isomorphism\AbstractExhaustiveIsomorphismInspector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */