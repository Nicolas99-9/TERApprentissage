/*     */ package org.jgrapht.graph;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
/*     */ import org.jgrapht.EdgeFactory;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.UndirectedGraph;
/*     */ import org.jgrapht.WeightedGraph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GraphDelegator<V, E>
/*     */   extends AbstractGraph<V, E>
/*     */   implements Graph<V, E>, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3257005445226181425L;
/*     */   private Graph<V, E> delegate;
/*     */   
/*     */   public GraphDelegator(Graph<V, E> g)
/*     */   {
/*  96 */     if (g == null) {
/*  97 */       throw new IllegalArgumentException("g must not be null.");
/*     */     }
/*     */     
/* 100 */     this.delegate = g;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> getAllEdges(V sourceVertex, V targetVertex)
/*     */   {
/* 110 */     return this.delegate.getAllEdges(sourceVertex, targetVertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public E getEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 118 */     return (E)this.delegate.getEdge(sourceVertex, targetVertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public EdgeFactory<V, E> getEdgeFactory()
/*     */   {
/* 126 */     return this.delegate.getEdgeFactory();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public E addEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 134 */     return (E)this.delegate.addEdge(sourceVertex, targetVertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addEdge(V sourceVertex, V targetVertex, E e)
/*     */   {
/* 142 */     return this.delegate.addEdge(sourceVertex, targetVertex, e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addVertex(V v)
/*     */   {
/* 150 */     return this.delegate.addVertex(v);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean containsEdge(E e)
/*     */   {
/* 158 */     return this.delegate.containsEdge(e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean containsVertex(V v)
/*     */   {
/* 166 */     return this.delegate.containsVertex(v);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int degreeOf(V vertex)
/*     */   {
/* 174 */     return ((UndirectedGraph)this.delegate).degreeOf(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> edgeSet()
/*     */   {
/* 182 */     return this.delegate.edgeSet();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> edgesOf(V vertex)
/*     */   {
/* 190 */     return this.delegate.edgesOf(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int inDegreeOf(V vertex)
/*     */   {
/* 198 */     return ((DirectedGraph)this.delegate).inDegreeOf(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> incomingEdgesOf(V vertex)
/*     */   {
/* 206 */     return ((DirectedGraph)this.delegate).incomingEdgesOf(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int outDegreeOf(V vertex)
/*     */   {
/* 214 */     return ((DirectedGraph)this.delegate).outDegreeOf(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> outgoingEdgesOf(V vertex)
/*     */   {
/* 222 */     return ((DirectedGraph)this.delegate).outgoingEdgesOf(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeEdge(E e)
/*     */   {
/* 230 */     return this.delegate.removeEdge(e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public E removeEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 238 */     return (E)this.delegate.removeEdge(sourceVertex, targetVertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeVertex(V v)
/*     */   {
/* 246 */     return this.delegate.removeVertex(v);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/* 255 */     return this.delegate.toString();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<V> vertexSet()
/*     */   {
/* 263 */     return this.delegate.vertexSet();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public V getEdgeSource(E e)
/*     */   {
/* 271 */     return (V)this.delegate.getEdgeSource(e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public V getEdgeTarget(E e)
/*     */   {
/* 279 */     return (V)this.delegate.getEdgeTarget(e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getEdgeWeight(E e)
/*     */   {
/* 287 */     return this.delegate.getEdgeWeight(e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEdgeWeight(E e, double weight)
/*     */   {
/* 295 */     ((WeightedGraph)this.delegate).setEdgeWeight(e, weight);
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\GraphDelegator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */