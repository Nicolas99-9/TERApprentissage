/*     */ package org.jgrapht.util;
/*     */ 
/*     */ import java.util.AbstractSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
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
/*     */ public class ArrayUnenforcedSet<E>
/*     */   extends ArrayList<E>
/*     */   implements Set<E>
/*     */ {
/*     */   private static final long serialVersionUID = -7413250161201811238L;
/*     */   
/*     */   public ArrayUnenforcedSet() {}
/*     */   
/*     */   public ArrayUnenforcedSet(Collection<? extends E> c)
/*     */   {
/*  72 */     super(c);
/*     */   }
/*     */   
/*     */   public ArrayUnenforcedSet(int n)
/*     */   {
/*  77 */     super(n);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean equals(Object o)
/*     */   {
/*  85 */     return new SetForEquality(null).equals(o);
/*     */   }
/*     */   
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  91 */     return new SetForEquality(null).hashCode();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private class SetForEquality
/*     */     extends AbstractSet<E>
/*     */   {
/*     */     private SetForEquality() {}
/*     */     
/*     */ 
/*     */ 
/*     */     public Iterator<E> iterator()
/*     */     {
/* 105 */       return ArrayUnenforcedSet.this.iterator();
/*     */     }
/*     */     
/*     */ 
/*     */     public int size()
/*     */     {
/* 111 */       return ArrayUnenforcedSet.this.size();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\util\ArrayUnenforcedSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */