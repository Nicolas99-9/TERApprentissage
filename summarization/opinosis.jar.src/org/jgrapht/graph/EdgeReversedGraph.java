/*     */ package org.jgrapht.graph;
/*     */ 
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EdgeReversedGraph<V, E>
/*     */   extends GraphDelegator<V, E>
/*     */   implements DirectedGraph<V, E>
/*     */ {
/*     */   private static final long serialVersionUID = 9091361782455418631L;
/*     */   
/*     */   public EdgeReversedGraph(DirectedGraph<V, E> g)
/*     */   {
/*  82 */     super(g);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public E getEdge(V sourceVertex, V targetVertex)
/*     */   {
/*  93 */     return (E)super.getEdge(targetVertex, sourceVertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> getAllEdges(V sourceVertex, V targetVertex)
/*     */   {
/* 102 */     return super.getAllEdges(targetVertex, sourceVertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public E addEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 111 */     return (E)super.addEdge(targetVertex, sourceVertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addEdge(V sourceVertex, V targetVertex, E e)
/*     */   {
/* 120 */     return super.addEdge(targetVertex, sourceVertex, e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int inDegreeOf(V vertex)
/*     */   {
/* 129 */     return super.outDegreeOf(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int outDegreeOf(V vertex)
/*     */   {
/* 138 */     return super.inDegreeOf(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> incomingEdgesOf(V vertex)
/*     */   {
/* 147 */     return super.outgoingEdgesOf(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> outgoingEdgesOf(V vertex)
/*     */   {
/* 156 */     return super.incomingEdgesOf(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public E removeEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 165 */     return (E)super.removeEdge(targetVertex, sourceVertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public V getEdgeSource(E e)
/*     */   {
/* 174 */     return (V)super.getEdgeTarget(e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public V getEdgeTarget(E e)
/*     */   {
/* 183 */     return (V)super.getEdgeSource(e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 192 */     return toStringFromSets(
/* 193 */       vertexSet(), 
/* 194 */       edgeSet(), 
/* 195 */       true);
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\EdgeReversedGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */