/*     */ package org.jgrapht.graph;
/*     */ 
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.util.PrefetchIterator;
/*     */ import org.jgrapht.util.PrefetchIterator.NextElementFunctor;
/*     */ import org.jgrapht.util.TypeUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class MaskVertexSet<V, E>
/*     */   extends AbstractSet<V>
/*     */ {
/*     */   private MaskFunctor<V, E> mask;
/*     */   private int size;
/*     */   private Set<V> vertexSet;
/*  64 */   private transient TypeUtil<V> vertexTypeDecl = null;
/*     */   
/*     */ 
/*     */ 
/*     */   public MaskVertexSet(Set<V> vertexSet, MaskFunctor<V, E> mask)
/*     */   {
/*  70 */     this.vertexSet = vertexSet;
/*  71 */     this.mask = mask;
/*  72 */     this.size = -1;
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
/*     */   public boolean contains(Object o)
/*     */   {
/*  85 */     return (!this.mask.isVertexMasked(TypeUtil.uncheckedCast(o, this.vertexTypeDecl))) && (this.vertexSet.contains(o));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Iterator<V> iterator()
/*     */   {
/*  94 */     return new PrefetchIterator(new MaskVertexSetNextElementFunctor());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int size()
/*     */   {
/* 103 */     if (this.size == -1) {
/* 104 */       this.size = 0;
/* 105 */       for (Iterator<V> iter = iterator(); iter.hasNext();) {
/* 106 */         iter.next();
/* 107 */         this.size += 1;
/*     */       }
/*     */     }
/* 110 */     return this.size;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private class MaskVertexSetNextElementFunctor
/*     */     implements PrefetchIterator.NextElementFunctor<V>
/*     */   {
/* 122 */     private Iterator<V> iter = MaskVertexSet.this.vertexSet.iterator();
/*     */     
/*     */     public MaskVertexSetNextElementFunctor() {}
/*     */     
/*     */     public V nextElement() throws NoSuchElementException
/*     */     {
/* 128 */       V element = this.iter.next();
/* 129 */       while (MaskVertexSet.this.mask.isVertexMasked(element)) {
/* 130 */         element = this.iter.next();
/*     */       }
/* 132 */       return element;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\MaskVertexSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */