/*     */ package org.jgrapht.experimental.isomorphism;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.experimental.equivalence.EquivalenceComparator;
/*     */ import org.jgrapht.experimental.equivalence.EquivalenceSet;
/*     */ import org.jgrapht.experimental.equivalence.EquivalenceSetCreator;
/*     */ import org.jgrapht.experimental.permutation.ArrayPermutationsIter;
/*     */ import org.jgrapht.experimental.permutation.CollectionPermutationIter;
/*     */ import org.jgrapht.experimental.permutation.PermutationFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class EquivalenceIsomorphismInspector<V, E>
/*     */   extends AbstractExhaustiveIsomorphismInspector<V, E>
/*     */ {
/*     */   public EquivalenceIsomorphismInspector(Graph<V, E> graph1, Graph<V, E> graph2, EquivalenceComparator<? super V, ? super Graph<? super V, ? super E>> vertexChecker, EquivalenceComparator<? super E, ? super Graph<? super V, ? super E>> edgeChecker)
/*     */   {
/*  79 */     super(graph1, graph2, vertexChecker, edgeChecker);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public EquivalenceIsomorphismInspector(Graph<V, E> graph1, Graph<V, E> graph2)
/*     */   {
/*  91 */     super(graph1, graph2);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 137 */     if (vertexSet1.size() != vertexSet2.size())
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 142 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 146 */     EquivalenceSet[] eqGroupArray1 = 
/* 147 */       EquivalenceSetCreator.createEqualityGroupOrderedArray(
/* 148 */       vertexSet1, 
/* 149 */       this.vertexComparator, 
/* 150 */       this.graph1);
/*     */     
/*     */ 
/* 153 */     EquivalenceSet[] eqGroupArray2 = 
/* 154 */       EquivalenceSetCreator.createEqualityGroupOrderedArray(
/* 155 */       vertexSet2, 
/* 156 */       this.vertexComparator, 
/* 157 */       this.graph2);
/*     */     
/*     */ 
/* 160 */     boolean reorderSuccess = 
/* 161 */       reorderTargetArrayToMatchSourceOrder(eqGroupArray1, eqGroupArray2);
/* 162 */     if (!reorderSuccess)
/*     */     {
/* 164 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 172 */     Object[] reorderingVertexSet1Temp = new Object[vertexSet1.size()];
/* 173 */     fillElementsflatArray(eqGroupArray1, reorderingVertexSet1Temp);
/* 174 */     vertexSet1.clear();
/* 175 */     vertexSet1.addAll(Arrays.asList(reorderingVertexSet1Temp));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 184 */     Object[] flatVertexArray = new Object[vertexSet2.size()];
/* 185 */     fillElementsflatArray(eqGroupArray2, flatVertexArray);
/*     */     
/*     */ 
/* 188 */     int[] groupSizesArray = new int[eqGroupArray1.length];
/*     */     
/*     */ 
/*     */ 
/* 192 */     for (int eqGroupCounter = 0; 
/* 193 */         eqGroupCounter < eqGroupArray2.length; 
/* 194 */         eqGroupCounter++)
/*     */     {
/*     */ 
/* 197 */       groupSizesArray[eqGroupCounter] = 
/* 198 */         eqGroupArray2[eqGroupCounter].size();
/*     */     }
/*     */     
/* 201 */     ArrayPermutationsIter arrayPermIter = 
/* 202 */       PermutationFactory.createByGroups(groupSizesArray);
/* 203 */     CollectionPermutationIter<V> vertexPermIter = 
/* 204 */       new CollectionPermutationIter(
/* 205 */       Arrays.asList(flatVertexArray), 
/* 206 */       arrayPermIter);
/*     */     
/* 208 */     return vertexPermIter;
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
/*     */   private boolean reorderTargetArrayToMatchSourceOrder(EquivalenceSet[] sourceArray, EquivalenceSet[] targetArray)
/*     */   {
/* 235 */     boolean result = true;
/*     */     
/* 237 */     for (int sourceIndex = 0; 
/* 238 */         sourceIndex < sourceArray.length; 
/* 239 */         sourceIndex++)
/*     */     {
/* 241 */       int currTargetIndex = sourceIndex;
/*     */       
/*     */ 
/* 244 */       EquivalenceSet sourceEqGroup = sourceArray[sourceIndex];
/* 245 */       EquivalenceSet targetEqGroup = targetArray[currTargetIndex];
/* 246 */       if (!sourceEqGroup.equals(targetEqGroup))
/*     */       {
/*     */ 
/* 249 */         boolean foundMatch = false;
/* 250 */         int sourceSize = sourceEqGroup.size();
/* 251 */         int sourceHashCode = sourceEqGroup.hashCode();
/*     */         
/* 253 */         while ((targetEqGroup.size() == sourceSize) && 
/* 254 */           (targetEqGroup.hashCode() == sourceHashCode) && 
/* 255 */           (currTargetIndex < targetArray.length))
/*     */         {
/* 257 */           currTargetIndex++;
/* 258 */           targetEqGroup = targetArray[currTargetIndex];
/* 259 */           if (targetEqGroup.equals(sourceEqGroup)) {
/* 260 */             foundMatch = true;
/*     */             
/*     */ 
/*     */ 
/* 264 */             targetArray[currTargetIndex] = targetArray[sourceIndex];
/* 265 */             targetArray[sourceIndex] = targetEqGroup;
/*     */           }
/*     */         }
/* 268 */         if (!foundMatch)
/*     */         {
/*     */ 
/*     */ 
/* 272 */           result = false;
/* 273 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 277 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void fillElementsflatArray(EquivalenceSet[] eqGroupArray, Object[] flatVertexArray)
/*     */   {
/* 288 */     int flatVertexArrayNextFree = 0;
/*     */     
/*     */ 
/*     */ 
/* 292 */     for (int eqGroupCounter = 0; 
/* 293 */         eqGroupCounter < eqGroupArray.length; 
/* 294 */         eqGroupCounter++)
/*     */     {
/* 296 */       Object[] currGroupArray = eqGroupArray[eqGroupCounter].toArray();
/*     */       
/*     */ 
/*     */ 
/* 300 */       System.arraycopy(
/* 301 */         currGroupArray, 
/* 302 */         0, 
/* 303 */         flatVertexArray, 
/* 304 */         flatVertexArrayNextFree, 
/* 305 */         currGroupArray.length);
/*     */       
/* 307 */       flatVertexArrayNextFree += currGroupArray.length;
/*     */     }
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
/*     */   protected boolean areVertexSetsOfTheSameEqualityGroup(Set vertexSet1, Set vertexSet2)
/*     */   {
/* 323 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\isomorphism\EquivalenceIsomorphismInspector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */