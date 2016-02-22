/*     */ package org.jgrapht.experimental.equivalence;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EquivalenceSetCreator<E, C>
/*     */ {
/*  59 */   private static final EqGroupSizeComparator groupSizeComparator = new EqGroupSizeComparator(null);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Deprecated
/*     */   public static <EE, CC> EquivalenceSet[] createEqualityGroupOrderedArray(EE[] aElementsArray, EquivalenceComparator<? super EE, ? super CC> aEqComparator, CC aContext)
/*     */   {
/*  80 */     return createEqualityGroupOrderedArray(
/*  81 */       Arrays.asList(aElementsArray), 
/*  82 */       aEqComparator, 
/*  83 */       aContext);
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
/*     */   public static <EE, CC> EquivalenceSet[] createEqualityGroupOrderedArray(Collection<EE> elements, EquivalenceComparator<? super EE, ? super CC> aEqComparator, CC aContext)
/*     */   {
/* 118 */     ArrayList<EquivalenceSet<? super EE, ? super CC>> arrayList = 
/* 119 */       new ArrayList();
/*     */     
/* 121 */     HashMap<Integer, List<EquivalenceSet<? super EE, ? super CC>>> map = 
/* 122 */       createEqualityGroupMap(elements, aEqComparator, aContext);
/*     */     
/*     */ 
/*     */ 
/*     */     Iterator localIterator2;
/*     */     
/*     */ 
/* 129 */     for (Iterator localIterator1 = map.values().iterator(); localIterator1.hasNext(); 
/* 130 */         localIterator2.hasNext())
/*     */     {
/* 129 */       List<EquivalenceSet<? super EE, ? super CC>> list = (List)localIterator1.next();
/* 130 */       localIterator2 = list.iterator(); continue;EquivalenceSet<? super EE, ? super CC> eSet = (EquivalenceSet)localIterator2.next();
/* 131 */       arrayList.add(eSet);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 137 */     EquivalenceSet[] resultArray = new EquivalenceSet[arrayList.size()];
/* 138 */     arrayList.toArray(resultArray);
/* 139 */     Arrays.sort(resultArray, groupSizeComparator);
/* 140 */     return resultArray;
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
/*     */   private static <EE, CC> HashMap<Integer, List<EquivalenceSet<? super EE, ? super CC>>> createEqualityGroupMap(Collection<EE> elements, EquivalenceComparator<? super EE, ? super CC> aEqComparator, CC aComparatorContext)
/*     */   {
/* 161 */     HashMap<Integer, List<EquivalenceSet<? super EE, ? super CC>>> equalityGroupMap = 
/* 162 */       new HashMap(
/* 163 */       elements.size());
/*     */     
/* 165 */     for (EE curentElement : elements) {
/* 166 */       int hashcode = 
/* 167 */         aEqComparator.equivalenceHashcode(
/* 168 */         curentElement, 
/* 169 */         aComparatorContext);
/* 170 */       List<EquivalenceSet<? super EE, ? super CC>> list = 
/* 171 */         (List)equalityGroupMap.get(Integer.valueOf(hashcode));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 176 */       if (list == null)
/*     */       {
/* 178 */         list = new LinkedList();
/* 179 */         list.add(
/* 180 */           new EquivalenceSet(
/* 181 */           curentElement, 
/* 182 */           aEqComparator, 
/* 183 */           aComparatorContext));
/*     */         
/*     */ 
/* 186 */         equalityGroupMap.put(Integer.valueOf(hashcode), list);
/*     */       } else {
/* 188 */         boolean eqWasFound = false;
/*     */         
/*     */ 
/*     */ 
/* 192 */         for (EquivalenceSet<? super EE, ? super CC> eqGroup : list) {
/* 193 */           if (eqGroup.equivalentTo(
/* 194 */             curentElement, 
/* 195 */             aComparatorContext))
/*     */           {
/*     */ 
/* 198 */             eqGroup.add(curentElement);
/* 199 */             eqWasFound = true;
/* 200 */             break;
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 205 */         if (!eqWasFound) {
/* 206 */           list.add(
/* 207 */             new EquivalenceSet(
/* 208 */             curentElement, 
/* 209 */             aEqComparator, 
/* 210 */             aComparatorContext));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 215 */     return equalityGroupMap;
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
/*     */   private static class EqGroupSizeComparator
/*     */     implements Comparator<EquivalenceSet>
/*     */   {
/*     */     public int compare(EquivalenceSet arg1, EquivalenceSet arg2)
/*     */     {
/* 240 */       int eqGroupSize1 = arg1.size();
/* 241 */       int eqGroupSize2 = arg2.size();
/* 242 */       if (eqGroupSize1 > eqGroupSize2)
/* 243 */         return 1;
/* 244 */       if (eqGroupSize1 < eqGroupSize2) {
/* 245 */         return -1;
/*     */       }
/* 247 */       int eqGroupHash1 = arg1.hashCode();
/* 248 */       int eqGroupHash2 = arg2.hashCode();
/* 249 */       if (eqGroupHash1 > eqGroupHash2)
/* 250 */         return 1;
/* 251 */       if (eqGroupHash1 < eqGroupHash2) {
/* 252 */         return -1;
/*     */       }
/* 254 */       return 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\equivalence\EquivalenceSetCreator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */