/*     */ package org.jgrapht.experimental.permutation;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IntegerPermutationIter
/*     */   implements Iterator, ArrayPermutationsIter
/*     */ {
/*     */   private int[] Value;
/*     */   private int N;
/*     */   private long permutationCounter;
/*  64 */   private boolean endWasReached = false;
/*  65 */   private boolean wasNextValueCalculatedAlready = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int[] currentValueBackup;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public IntegerPermutationIter(int N)
/*     */   {
/*  83 */     int[] newArray = new int[N];
/*     */     
/*     */ 
/*  86 */     for (int i = 0; i < newArray.length; i++) {
/*  87 */       newArray[i] = i;
/*     */     }
/*  89 */     init(newArray);
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
/*     */   public IntegerPermutationIter(int[] array)
/*     */   {
/* 102 */     int[] newArray = new int[array.length];
/* 103 */     System.arraycopy(array, 0, newArray, 0, array.length);
/* 104 */     Arrays.sort(newArray);
/* 105 */     init(newArray);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void init(int[] array)
/*     */   {
/* 112 */     this.N = array.length;
/* 113 */     this.Value = array;
/* 114 */     this.currentValueBackup = this.Value;
/* 115 */     this.permutationCounter = 0L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void swap(int i, int j)
/*     */   {
/* 126 */     int temp = this.Value[i];
/* 127 */     this.Value[i] = this.Value[j];
/* 128 */     this.Value[j] = temp;
/*     */   }
/*     */   
/*     */   private int[] arrayClone(int[] sourceArray)
/*     */   {
/* 133 */     int[] destArray = new int[sourceArray.length];
/* 134 */     System.arraycopy(sourceArray, 0, destArray, 0, sourceArray.length);
/* 135 */     return destArray;
/*     */   }
/*     */   
/*     */   private int[] getNextStartingWith2()
/*     */   {
/* 140 */     this.permutationCounter += 1L;
/* 141 */     int i = this.N - 1;
/*     */     
/* 143 */     if (i <= 0)
/*     */     {
/*     */ 
/* 146 */       this.endWasReached = true;
/* 147 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 154 */     while (this.Value[(i - 1)] >= this.Value[i]) {
/* 155 */       i--;
/* 156 */       if (i == 0) {
/* 157 */         this.endWasReached = true;
/* 158 */         return null;
/*     */       }
/*     */     }
/*     */     
/* 162 */     int j = this.N;
/*     */     
/* 164 */     while (this.Value[(j - 1)] <= this.Value[(i - 1)]) {
/* 165 */       j--;
/*     */     }
/*     */     
/* 168 */     swap(i - 1, j - 1);
/*     */     
/* 170 */     i++;
/* 171 */     j = this.N;
/*     */     
/* 173 */     while (i < j) {
/* 174 */       swap(i - 1, j - 1);
/* 175 */       i++;
/* 176 */       j--;
/*     */     }
/* 178 */     return this.Value;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasNext()
/*     */   {
/* 186 */     if ((this.permutationCounter == 0L) || 
/* 187 */       (this.wasNextValueCalculatedAlready))
/*     */     {
/* 189 */       return true; }
/* 190 */     if (this.endWasReached) {
/* 191 */       return false;
/*     */     }
/*     */     
/* 194 */     boolean result = true;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 209 */     getNextStartingWith2();
/* 210 */     this.wasNextValueCalculatedAlready = true;
/* 211 */     if (this.endWasReached) {
/* 212 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 216 */     return result;
/*     */   }
/*     */   
/*     */   public Object next()
/*     */   {
/* 221 */     return getNext();
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
/* 232 */     if (!hasNext()) {
/* 233 */       throw new RuntimeException(
/* 234 */         "IntegerPermutationIter exceeds the total number of permutaions. Suggestion: do a check with hasNext() , or count till getTotalNumberOfPermutations before using getNext()");
/*     */     }
/*     */     
/*     */     int[] internalArray;
/*     */     
/*     */     int[] internalArray;
/*     */     
/* 241 */     if (this.permutationCounter == 0L) {
/* 242 */       this.permutationCounter += 1L;
/* 243 */       internalArray = this.Value;
/*     */ 
/*     */     }
/* 246 */     else if (this.wasNextValueCalculatedAlready) {
/* 247 */       int[] internalArray = this.Value;
/* 248 */       this.wasNextValueCalculatedAlready = false;
/*     */     } else {
/* 250 */       internalArray = getNextStartingWith2();
/* 251 */       if (this.endWasReached) {
/* 252 */         return null;
/*     */       }
/*     */     }
/*     */     
/* 256 */     this.currentValueBackup = arrayClone(internalArray);
/* 257 */     return arrayClone(internalArray);
/*     */   }
/*     */   
/*     */   public int[] getCurrent()
/*     */   {
/* 262 */     return arrayClone(this.currentValueBackup);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString(int[] array)
/*     */   {
/* 273 */     if (array.length <= 0) {
/* 274 */       return "[]";
/*     */     }
/* 276 */     StringBuffer stBuffer = new StringBuffer("[");
/* 277 */     for (int i = 0; i < array.length - 1; i++) {
/* 278 */       stBuffer.append(array[i]).append(",");
/*     */     }
/* 280 */     stBuffer.append(array[(array.length - 1)]).append("]");
/* 281 */     return stBuffer.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void remove()
/*     */   {
/* 291 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int[] nextPermutation()
/*     */   {
/* 299 */     return (int[])next();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasNextPermutaions()
/*     */   {
/* 307 */     return hasNext();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\permutation\IntegerPermutationIter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */