/*     */ package org.jgrapht.graph;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
/*     */ import org.jgrapht.UndirectedGraph;
/*     */ import org.jgrapht.util.ArrayUnenforcedSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AsUndirectedGraph<V, E>
/*     */   extends GraphDelegator<V, E>
/*     */   implements Serializable, UndirectedGraph<V, E>
/*     */ {
/*     */   private static final long serialVersionUID = 3257845485078065462L;
/*     */   private static final String NO_EDGE_ADD = "this graph does not support edge addition";
/*     */   private static final String UNDIRECTED = "this graph only supports undirected operations";
/*     */   
/*     */   public AsUndirectedGraph(DirectedGraph<V, E> g)
/*     */   {
/* 101 */     super(g);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> getAllEdges(V sourceVertex, V targetVertex)
/*     */   {
/* 112 */     Set<E> forwardList = super.getAllEdges(sourceVertex, targetVertex);
/*     */     
/* 114 */     if (sourceVertex.equals(targetVertex))
/*     */     {
/* 116 */       return forwardList;
/*     */     }
/*     */     
/* 119 */     Set<E> reverseList = super.getAllEdges(targetVertex, sourceVertex);
/* 120 */     Set<E> list = 
/* 121 */       new ArrayUnenforcedSet(
/* 122 */       forwardList.size() + reverseList.size());
/* 123 */     list.addAll(forwardList);
/* 124 */     list.addAll(reverseList);
/*     */     
/* 126 */     return list;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public E getEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 135 */     E edge = super.getEdge(sourceVertex, targetVertex);
/*     */     
/* 137 */     if (edge != null) {
/* 138 */       return edge;
/*     */     }
/*     */     
/*     */ 
/* 142 */     return (E)super.getEdge(targetVertex, sourceVertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public E addEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 151 */     throw new UnsupportedOperationException("this graph does not support edge addition");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addEdge(V sourceVertex, V targetVertex, E e)
/*     */   {
/* 160 */     throw new UnsupportedOperationException("this graph does not support edge addition");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int degreeOf(V vertex)
/*     */   {
/* 170 */     return super.inDegreeOf(vertex) + super.outDegreeOf(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int inDegreeOf(V vertex)
/*     */   {
/* 179 */     throw new UnsupportedOperationException("this graph only supports undirected operations");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> incomingEdgesOf(V vertex)
/*     */   {
/* 188 */     throw new UnsupportedOperationException("this graph only supports undirected operations");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int outDegreeOf(V vertex)
/*     */   {
/* 197 */     throw new UnsupportedOperationException("this graph only supports undirected operations");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> outgoingEdgesOf(V vertex)
/*     */   {
/* 206 */     throw new UnsupportedOperationException("this graph only supports undirected operations");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 215 */     return super.toStringFromSets(vertexSet(), edgeSet(), false);
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\AsUndirectedGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */