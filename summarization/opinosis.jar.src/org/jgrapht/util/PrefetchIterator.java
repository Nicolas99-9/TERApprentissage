/*     */ package org.jgrapht.util;
/*     */ 
/*     */ import java.util.Enumeration;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PrefetchIterator<E>
/*     */   implements Iterator<E>, Enumeration<E>
/*     */ {
/*     */   private NextElementFunctor<E> innerEnum;
/*     */   private E getNextLastResult;
/*  98 */   private boolean isGetNextLastResultUpToDate = false;
/*  99 */   private boolean endOfEnumerationReached = false;
/* 100 */   private boolean flagIsEnumerationStartedEmpty = true;
/* 101 */   private int innerFunctorUsageCounter = 0;
/*     */   
/*     */ 
/*     */ 
/*     */   public PrefetchIterator(NextElementFunctor<E> aEnum)
/*     */   {
/* 107 */     this.innerEnum = aEnum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private E getNextElementFromInnerFunctor()
/*     */   {
/* 118 */     this.innerFunctorUsageCounter += 1;
/* 119 */     E result = this.innerEnum.nextElement();
/*     */     
/*     */ 
/*     */ 
/* 123 */     this.flagIsEnumerationStartedEmpty = false;
/* 124 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public E nextElement()
/*     */   {
/* 134 */     E result = null;
/* 135 */     if (this.isGetNextLastResultUpToDate) {
/* 136 */       result = this.getNextLastResult;
/*     */     } else {
/* 138 */       result = getNextElementFromInnerFunctor();
/*     */     }
/*     */     
/* 141 */     this.isGetNextLastResultUpToDate = false;
/* 142 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasMoreElements()
/*     */   {
/* 151 */     if (this.endOfEnumerationReached) {
/* 152 */       return false;
/*     */     }
/*     */     
/* 155 */     if (this.isGetNextLastResultUpToDate) {
/* 156 */       return true;
/*     */     }
/*     */     try {
/* 159 */       this.getNextLastResult = getNextElementFromInnerFunctor();
/* 160 */       this.isGetNextLastResultUpToDate = true;
/* 161 */       return true;
/*     */     } catch (NoSuchElementException noSuchE) {
/* 163 */       this.endOfEnumerationReached = true; }
/* 164 */     return false;
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
/*     */   public boolean isEnumerationStartedEmpty()
/*     */   {
/* 177 */     if (this.innerFunctorUsageCounter == 0) {
/* 178 */       if (hasMoreElements()) {
/* 179 */         return false;
/*     */       }
/* 181 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 187 */     return this.flagIsEnumerationStartedEmpty;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean hasNext()
/*     */   {
/* 193 */     return hasMoreElements();
/*     */   }
/*     */   
/*     */   public E next()
/*     */   {
/* 198 */     return (E)nextElement();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void remove()
/*     */     throws UnsupportedOperationException
/*     */   {
/* 207 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */   public static abstract interface NextElementFunctor<EE>
/*     */   {
/*     */     public abstract EE nextElement()
/*     */       throws NoSuchElementException;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\util\PrefetchIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */