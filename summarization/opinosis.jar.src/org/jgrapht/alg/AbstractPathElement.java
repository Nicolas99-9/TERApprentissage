/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.Graphs;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class AbstractPathElement<V, E>
/*     */ {
/*     */   protected int nHops;
/*     */   protected E prevEdge;
/*     */   protected AbstractPathElement<V, E> prevPathElement;
/*     */   private V vertex;
/*     */   
/*     */   protected AbstractPathElement(Graph<V, E> graph, AbstractPathElement<V, E> pathElement, E edge)
/*     */   {
/*  99 */     this.vertex = 
/* 100 */       Graphs.getOppositeVertex(
/* 101 */       graph, 
/* 102 */       edge, 
/* 103 */       pathElement.getVertex());
/* 104 */     this.prevEdge = edge;
/* 105 */     this.prevPathElement = pathElement;
/*     */     
/* 107 */     this.nHops = (pathElement.getHopCount() + 1);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected AbstractPathElement(AbstractPathElement<V, E> original)
/*     */   {
/* 117 */     this.nHops = original.nHops;
/* 118 */     this.prevEdge = original.prevEdge;
/* 119 */     this.prevPathElement = original.prevPathElement;
/* 120 */     this.vertex = original.vertex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected AbstractPathElement(V vertex)
/*     */   {
/* 130 */     this.vertex = vertex;
/* 131 */     this.prevEdge = null;
/* 132 */     this.prevPathElement = null;
/*     */     
/* 134 */     this.nHops = 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<E> createEdgeListPath()
/*     */   {
/* 146 */     List<E> path = new ArrayList();
/* 147 */     AbstractPathElement<V, E> pathElement = this;
/*     */     
/*     */ 
/* 150 */     while (pathElement.getPrevEdge() != null) {
/* 151 */       path.add(pathElement.getPrevEdge());
/*     */       
/* 153 */       pathElement = pathElement.getPrevPathElement();
/*     */     }
/*     */     
/* 156 */     Collections.reverse(path);
/*     */     
/* 158 */     return path;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getHopCount()
/*     */   {
/* 168 */     return this.nHops;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public E getPrevEdge()
/*     */   {
/* 178 */     return (E)this.prevEdge;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public AbstractPathElement<V, E> getPrevPathElement()
/*     */   {
/* 188 */     return this.prevPathElement;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public V getVertex()
/*     */   {
/* 198 */     return (V)this.vertex;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\AbstractPathElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */