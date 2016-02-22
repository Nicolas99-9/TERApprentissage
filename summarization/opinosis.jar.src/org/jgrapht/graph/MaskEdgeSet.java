/*     */ package org.jgrapht.graph;
/*     */ 
/*     */ import java.util.AbstractSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.Graph;
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
/*     */ class MaskEdgeSet<V, E>
/*     */   extends AbstractSet<E>
/*     */ {
/*     */   private Set<E> edgeSet;
/*     */   private Graph<V, E> graph;
/*     */   private MaskFunctor<V, E> mask;
/*  65 */   private transient TypeUtil<E> edgeTypeDecl = null;
/*     */   
/*     */ 
/*     */ 
/*     */   private int size;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public MaskEdgeSet(Graph<V, E> graph, Set<E> edgeSet, MaskFunctor<V, E> mask)
/*     */   {
/*  76 */     this.graph = graph;
/*  77 */     this.edgeSet = edgeSet;
/*  78 */     this.mask = mask;
/*  79 */     this.size = -1;
/*     */   }
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
/*  91 */     return (this.edgeSet.contains(o)) && (!this.mask.isEdgeMasked(TypeUtil.uncheckedCast(o, this.edgeTypeDecl)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Iterator<E> iterator()
/*     */   {
/* 100 */     return new PrefetchIterator(new MaskEdgeSetNextElementFunctor());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int size()
/*     */   {
/* 109 */     if (this.size == -1) {
/* 110 */       this.size = 0;
/* 111 */       for (Iterator<E> iter = iterator(); iter.hasNext();) {
/* 112 */         iter.next();
/* 113 */         this.size += 1;
/*     */       }
/*     */     }
/* 116 */     return this.size;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private class MaskEdgeSetNextElementFunctor
/*     */     implements PrefetchIterator.NextElementFunctor<E>
/*     */   {
/* 128 */     private Iterator<E> iter = MaskEdgeSet.this.edgeSet.iterator();
/*     */     
/*     */     public MaskEdgeSetNextElementFunctor() {}
/*     */     
/*     */     public E nextElement() throws NoSuchElementException
/*     */     {
/* 134 */       E edge = this.iter.next();
/* 135 */       while (isMasked(edge)) {
/* 136 */         edge = this.iter.next();
/*     */       }
/* 138 */       return edge;
/*     */     }
/*     */     
/*     */     private boolean isMasked(E edge)
/*     */     {
/* 143 */       if ((!MaskEdgeSet.this.mask.isEdgeMasked(edge)) && 
/* 144 */         (!MaskEdgeSet.this.mask.isVertexMasked(
/* 145 */         MaskEdgeSet.this.graph.getEdgeSource(edge)))) {
/* 146 */         if (!MaskEdgeSet.this.mask.isVertexMasked(
/* 147 */           MaskEdgeSet.this.graph.getEdgeTarget(edge))) {
/* 146 */           return false;
/*     */         }
/*     */       }
/* 143 */       return 
/*     */       
/*     */ 
/* 146 */         true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\MaskEdgeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */