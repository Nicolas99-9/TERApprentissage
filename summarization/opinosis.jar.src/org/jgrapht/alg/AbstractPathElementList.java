/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.AbstractList;
/*     */ import java.util.ArrayList;
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
/*     */ abstract class AbstractPathElementList<V, E, T extends AbstractPathElement<V, E>>
/*     */   extends AbstractList<T>
/*     */   implements Cloneable
/*     */ {
/*     */   protected Graph<V, E> graph;
/*     */   protected int maxSize;
/*  71 */   protected ArrayList<T> pathElements = new ArrayList();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected V vertex;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected AbstractPathElementList(Graph<V, E> graph, int maxSize, T pathElement)
/*     */   {
/*  95 */     if (maxSize <= 0) {
/*  96 */       throw new IllegalArgumentException("maxSize is negative or 0");
/*     */     }
/*  98 */     if (pathElement == null) {
/*  99 */       throw new NullPointerException("pathElement is null");
/*     */     }
/*     */     
/* 102 */     this.graph = graph;
/* 103 */     this.maxSize = maxSize;
/* 104 */     this.vertex = pathElement.getVertex();
/*     */     
/* 106 */     this.pathElements.add(pathElement);
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
/*     */   protected AbstractPathElementList(Graph<V, E> graph, int maxSize, AbstractPathElementList<V, E, T> elementList, E edge)
/*     */   {
/* 128 */     if (maxSize <= 0) {
/* 129 */       throw new IllegalArgumentException("maxSize is negative or 0");
/*     */     }
/* 131 */     if (elementList == null) {
/* 132 */       throw new NullPointerException("elementList is null");
/*     */     }
/* 134 */     if (edge == null) {
/* 135 */       throw new NullPointerException("edge is null");
/*     */     }
/*     */     
/* 138 */     this.graph = graph;
/* 139 */     this.maxSize = maxSize;
/* 140 */     this.vertex = 
/* 141 */       Graphs.getOppositeVertex(graph, edge, elementList.getVertex());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected AbstractPathElementList(AbstractPathElementList<V, E, T> original)
/*     */   {
/* 151 */     this.graph = original.graph;
/* 152 */     this.maxSize = original.maxSize;
/* 153 */     this.pathElements.addAll(original.pathElements);
/* 154 */     this.vertex = original.vertex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public T get(int index)
/*     */   {
/* 166 */     return (AbstractPathElement)this.pathElements.get(index);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public V getVertex()
/*     */   {
/* 174 */     return (V)this.vertex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int size()
/*     */   {
/* 183 */     return this.pathElements.size();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\AbstractPathElementList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */