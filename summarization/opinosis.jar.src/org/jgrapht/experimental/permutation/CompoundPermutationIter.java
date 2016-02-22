/*     */ package org.jgrapht.experimental.permutation;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import org.jgrapht.util.MathUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CompoundPermutationIter
/*     */   implements ArrayPermutationsIter, Iterator
/*     */ {
/*     */   IntegerPermutationIter[] permArray;
/*     */   private int totalPermArraySize;
/*     */   private int max;
/* 119 */   private int iterCounter = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CompoundPermutationIter(int[] equalityGroupsSizesArray)
/*     */   {
/* 130 */     init(equalityGroupsSizesArray);
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
/*     */   private void init(int[] equalityGroupsSizesArray)
/*     */   {
/* 143 */     this.permArray = 
/* 144 */       new IntegerPermutationIter[equalityGroupsSizesArray.length];
/*     */     
/* 146 */     int counter = 0;
/* 147 */     this.max = 1;
/*     */     
/* 149 */     for (int eqGroup = 0; 
/* 150 */         eqGroup < equalityGroupsSizesArray.length; 
/* 151 */         eqGroup++)
/*     */     {
/*     */ 
/*     */ 
/* 155 */       int currGroupSize = equalityGroupsSizesArray[eqGroup];
/* 156 */       int[] currArray = new int[currGroupSize];
/* 157 */       for (int i = 0; i < currGroupSize; i++) {
/* 158 */         currArray[i] = counter;
/* 159 */         counter++;
/*     */       }
/* 161 */       this.permArray[eqGroup] = new IntegerPermutationIter(currArray);
/* 162 */       this.permArray[eqGroup].getNext();
/*     */       
/*     */ 
/*     */ 
/* 166 */       this.max = ((int)(this.max * MathUtil.factorial(currGroupSize)));
/*     */     }
/* 168 */     this.totalPermArraySize = counter;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Object next()
/*     */   {
/* 175 */     return getNext();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int[] getNext()
/*     */   {
/* 186 */     if (this.iterCounter == 0)
/*     */     {
/* 188 */       this.iterCounter += 1;
/* 189 */       return getPermAsArray();
/*     */     }
/*     */     
/* 192 */     int firstGroupCapableOfAdvancing = -1;
/* 193 */     int currGroupIndex = 0;
/* 194 */     while (firstGroupCapableOfAdvancing == -1) {
/* 195 */       IntegerPermutationIter currGroup = this.permArray[currGroupIndex];
/*     */       
/* 197 */       if (currGroup.hasNext()) {
/* 198 */         currGroup.getNext();
/*     */         
/*     */ 
/* 201 */         for (int i = 0; i < currGroupIndex; i++) {
/* 202 */           restartPermutationGroup(i);
/*     */         }
/* 204 */         firstGroupCapableOfAdvancing = currGroupIndex;
/*     */       }
/*     */       
/* 207 */       currGroupIndex++;
/* 208 */       if (currGroupIndex >= this.permArray.length) {
/*     */         break;
/*     */       }
/*     */     }
/*     */     
/* 213 */     this.iterCounter += 1;
/*     */     
/* 215 */     if (firstGroupCapableOfAdvancing == -1)
/*     */     {
/* 217 */       return null;
/*     */     }
/* 219 */     int[] tempArray = getPermAsArray();
/* 220 */     return tempArray;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int[] getPermAsArray()
/*     */   {
/* 232 */     int[] resultArray = new int[this.totalPermArraySize];
/* 233 */     int counter = 0;
/*     */     
/* 235 */     for (int groupIndex = 0; 
/* 236 */         groupIndex < this.permArray.length; 
/* 237 */         groupIndex++)
/*     */     {
/* 239 */       int[] currPermArray = this.permArray[groupIndex].getCurrent();
/* 240 */       System.arraycopy(
/* 241 */         currPermArray, 
/* 242 */         0, 
/* 243 */         resultArray, 
/* 244 */         counter, 
/* 245 */         currPermArray.length);
/* 246 */       counter += currPermArray.length;
/*     */     }
/* 248 */     return resultArray;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void restartPermutationGroup(int groupIndex)
/*     */   {
/* 258 */     int[] oldPermArray = this.permArray[groupIndex].getCurrent();
/* 259 */     Arrays.sort(oldPermArray);
/* 260 */     this.permArray[groupIndex] = new IntegerPermutationIter(oldPermArray);
/* 261 */     this.permArray[groupIndex].getNext();
/*     */   }
/*     */   
/*     */   public boolean hasNext() {
/*     */     boolean result;
/*     */     boolean result;
/* 267 */     if (this.iterCounter < this.max) {
/* 268 */       result = true;
/*     */     } else {
/* 270 */       result = false;
/*     */     }
/* 272 */     return result;
/*     */   }
/*     */   
/*     */   public int getMax()
/*     */   {
/* 277 */     return this.max;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int[] nextPermutation()
/*     */   {
/* 285 */     return (int[])next();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasNextPermutaions()
/*     */   {
/* 293 */     return hasNext();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void remove()
/*     */   {
/* 303 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\permutation\CompoundPermutationIter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */