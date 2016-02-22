/*     */ package org.jgrapht.experimental.equivalence;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EquivalenceSet<E, C>
/*     */ {
/*     */   protected EquivalenceComparator<? super E, ? super C> eqComparator;
/*     */   protected C comparatorContext;
/*     */   protected Set<E> elementsSet;
/*     */   
/*     */   private EquivalenceSet() {}
/*     */   
/*     */   public EquivalenceSet(E aElement, EquivalenceComparator<? super E, ? super C> aEqComparator, C aComparatorContext)
/*     */   {
/*  95 */     this.eqComparator = aEqComparator;
/*  96 */     this.comparatorContext = aComparatorContext;
/*     */     
/*  98 */     this.elementsSet = new HashSet();
/*  99 */     this.elementsSet.add(aElement);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public E getRepresentative()
/*     */   {
/* 111 */     return (E)this.elementsSet.iterator().next();
/*     */   }
/*     */   
/*     */   public C getContext()
/*     */   {
/* 116 */     return (C)this.comparatorContext;
/*     */   }
/*     */   
/*     */   public int size()
/*     */   {
/* 121 */     return this.elementsSet.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void add(E element)
/*     */   {
/* 130 */     this.elementsSet.add(element);
/*     */   }
/*     */   
/*     */   public boolean equivalentTo(E aOther, C aOtherContext)
/*     */   {
/* 135 */     boolean result = 
/* 136 */       this.eqComparator.equivalenceCompare(
/* 137 */       getRepresentative(), 
/* 138 */       aOther, 
/* 139 */       this.comparatorContext, 
/* 140 */       aOtherContext);
/* 141 */     return result;
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
/*     */   public boolean equals(Object other)
/*     */   {
/* 165 */     E otherRepresentative = null;
/* 166 */     C otherContext = null;
/* 167 */     if ((other instanceof EquivalenceSet)) {
/* 168 */       otherRepresentative = 
/* 169 */         ((EquivalenceSet)other).getRepresentative();
/* 170 */       otherContext = ((EquivalenceSet)other).getContext();
/*     */     } else {
/* 172 */       throw new ClassCastException(
/* 173 */         "can check equal() only of EqualityGroup");
/*     */     }
/*     */     
/* 176 */     boolean result = 
/* 177 */       this.eqComparator.equivalenceCompare(
/* 178 */       getRepresentative(), 
/* 179 */       otherRepresentative, 
/* 180 */       this.comparatorContext, 
/* 181 */       otherContext);
/* 182 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 194 */     int result = 
/* 195 */       this.eqComparator.equivalenceHashcode(
/* 196 */       getRepresentative(), 
/* 197 */       this.comparatorContext);
/* 198 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 204 */     return "Eq.Group=" + this.elementsSet.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Object[] toArray()
/*     */   {
/* 214 */     return this.elementsSet.toArray();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\equivalence\EquivalenceSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */