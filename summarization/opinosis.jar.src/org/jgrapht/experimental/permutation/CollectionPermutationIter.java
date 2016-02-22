/*     */ package org.jgrapht.experimental.permutation;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CollectionPermutationIter<E>
/*     */ {
/*     */   private ArrayPermutationsIter permOrder;
/*     */   private List<E> sourceArray;
/*     */   private int[] currPermutationArray;
/*     */   
/*     */   public CollectionPermutationIter(Set<E> objectsSet)
/*     */   {
/*  81 */     this(new ArrayList(objectsSet), new IntegerPermutationIter(objectsSet.size()));
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
/*     */   public CollectionPermutationIter(List<E> objectsArray)
/*     */   {
/*  96 */     this(objectsArray, new IntegerPermutationIter(objectsArray.size()));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CollectionPermutationIter(List<E> objectsArray, ArrayPermutationsIter permuter)
/*     */   {
/* 103 */     this.permOrder = permuter;
/* 104 */     this.sourceArray = objectsArray;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean hasNext()
/*     */   {
/* 111 */     return this.permOrder.hasNextPermutaions();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<E> getNextArray()
/*     */   {
/*     */     List<E> permutationResult;
/*     */     
/*     */ 
/*     */     List<E> permutationResult;
/*     */     
/* 123 */     if (this.permOrder.hasNextPermutaions()) {
/* 124 */       this.currPermutationArray = this.permOrder.nextPermutation();
/* 125 */       permutationResult = applyPermutation();
/*     */     } else {
/* 127 */       permutationResult = null;
/*     */     }
/*     */     
/* 130 */     return permutationResult;
/*     */   }
/*     */   
/*     */   private List<E> applyPermutation()
/*     */   {
/* 135 */     ArrayList<E> output = new ArrayList(this.sourceArray);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 140 */     for (int i = 0; i < output.size(); i++) {
/* 141 */       output.set(
/* 142 */         i, 
/* 143 */         this.sourceArray.get(this.currPermutationArray[i]));
/*     */     }
/* 145 */     return output;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> getNextSet()
/*     */   {
/* 155 */     List<E> result = getNextArray();
/* 156 */     if (result == null) {
/* 157 */       return null;
/*     */     }
/*     */     
/* 160 */     Set<E> resultSet = new LinkedHashSet(result);
/* 161 */     return resultSet;
/*     */   }
/*     */   
/*     */ 
/*     */   public int[] getCurrentPermutationArray()
/*     */   {
/* 167 */     return this.currPermutationArray;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 173 */     StringBuffer sb = new StringBuffer();
/* 174 */     sb.append("Permutation int[]=");
/* 175 */     sb.append(Arrays.toString(getCurrentPermutationArray()));
/*     */     
/* 177 */     List<E> permutationResult = applyPermutation();
/* 178 */     sb.append("\nPermutationSet Source Object[]=");
/* 179 */     sb.append(this.sourceArray.toString());
/* 180 */     sb.append("\nPermutationSet Result Object[]=");
/* 181 */     sb.append(permutationResult.toString());
/* 182 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\permutation\CollectionPermutationIter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */