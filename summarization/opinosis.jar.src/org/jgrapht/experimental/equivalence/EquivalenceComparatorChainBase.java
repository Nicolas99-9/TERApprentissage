/*     */ package org.jgrapht.experimental.equivalence;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EquivalenceComparatorChainBase<E, C>
/*     */   implements EquivalenceComparatorChain<E, C>
/*     */ {
/*     */   private List<EquivalenceComparator<? super E, ? super C>> chain;
/*     */   
/*     */   public EquivalenceComparatorChainBase(EquivalenceComparator<E, C> firstComaparator)
/*     */   {
/*  85 */     this.chain = 
/*  86 */       new LinkedList();
/*  87 */     this.chain.add(firstComaparator);
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
/*     */   public void appendComparator(EquivalenceComparator comparatorAfter)
/*     */   {
/* 104 */     if (comparatorAfter != null) {
/* 105 */       this.chain.add(comparatorAfter);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean equivalenceCompare(E arg1, E arg2, C context1, C context2)
/*     */   {
/* 125 */     Iterator localIterator = this.chain.iterator();
/* 124 */     while (localIterator.hasNext()) {
/* 125 */       EquivalenceComparator<? super E, ? super C> currentComparator = (EquivalenceComparator)localIterator.next();
/*     */       
/* 127 */       if (!currentComparator.equivalenceCompare(
/* 128 */         arg1, 
/* 129 */         arg2, 
/* 130 */         context1, 
/* 131 */         context2))
/*     */       {
/* 133 */         return false;
/*     */       }
/*     */     }
/* 136 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int equivalenceHashcode(E arg1, C context)
/*     */   {
/* 146 */     StringBuffer hashStringBuffer = new StringBuffer();
/*     */     
/* 148 */     ListIterator<EquivalenceComparator<? super E, ? super C>> iter = 
/* 149 */       this.chain.listIterator();
/* 147 */     while (
/*     */     
/*     */ 
/* 150 */       iter.hasNext())
/*     */     {
/* 152 */       EquivalenceComparator<? super E, ? super C> currentComparator = 
/* 153 */         (EquivalenceComparator)iter.next();
/* 154 */       int currentHashCode = 
/* 155 */         currentComparator.equivalenceHashcode(arg1, context);
/* 156 */       hashStringBuffer.append(currentHashCode);
/*     */       
/*     */ 
/* 159 */       if (iter.hasNext()) {
/* 160 */         hashStringBuffer.append('+');
/*     */       }
/*     */     }
/* 163 */     return hashStringBuffer.toString().hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\equivalence\EquivalenceComparatorChainBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */