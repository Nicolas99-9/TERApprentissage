/*     */ package org.jgrapht.graph;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Collection;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.Graph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UnmodifiableGraph<V, E>
/*     */   extends GraphDelegator<V, E>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3544957670722713913L;
/*     */   private static final String UNMODIFIABLE = "this graph is unmodifiable";
/*     */   
/*     */   public UnmodifiableGraph(Graph<V, E> g)
/*     */   {
/*  86 */     super(g);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public E addEdge(V sourceVertex, V targetVertex)
/*     */   {
/*  97 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addEdge(V sourceVertex, V targetVertex, E e)
/*     */   {
/* 106 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addVertex(V v)
/*     */   {
/* 115 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeAllEdges(Collection<? extends E> edges)
/*     */   {
/* 124 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> removeAllEdges(V sourceVertex, V targetVertex)
/*     */   {
/* 133 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeAllVertices(Collection<? extends V> vertices)
/*     */   {
/* 142 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeEdge(E e)
/*     */   {
/* 151 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public E removeEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 160 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeVertex(V v)
/*     */   {
/* 169 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\UnmodifiableGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */