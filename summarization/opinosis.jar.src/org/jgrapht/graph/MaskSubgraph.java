/*     */ package org.jgrapht.graph;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
/*     */ import org.jgrapht.EdgeFactory;
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
/*     */ public class MaskSubgraph<V, E>
/*     */   extends AbstractGraph<V, E>
/*     */ {
/*     */   private static final String UNMODIFIABLE = "this graph is unmodifiable";
/*     */   private Graph<V, E> base;
/*     */   private Set<E> edges;
/*     */   private MaskFunctor<V, E> mask;
/*     */   private Set<V> vertices;
/*     */   
/*     */   public MaskSubgraph(Graph<V, E> base, MaskFunctor<V, E> mask)
/*     */   {
/*  86 */     this.base = base;
/*  87 */     this.mask = mask;
/*     */     
/*  89 */     this.vertices = new MaskVertexSet(base.vertexSet(), mask);
/*  90 */     this.edges = new MaskEdgeSet(base, base.edgeSet(), mask);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public E addEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 100 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */   public boolean addEdge(V sourceVertex, V targetVertex, E edge)
/*     */   {
/* 105 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addVertex(V v)
/*     */   {
/* 113 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */   public boolean containsEdge(E e)
/*     */   {
/* 118 */     return edgeSet().contains(e);
/*     */   }
/*     */   
/*     */   public boolean containsVertex(V v)
/*     */   {
/* 123 */     return (!this.mask.isVertexMasked(v)) && (this.base.containsVertex(v));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int degreeOf(V vertex)
/*     */   {
/* 131 */     return edgesOf(vertex).size();
/*     */   }
/*     */   
/*     */   public Set<E> edgeSet()
/*     */   {
/* 136 */     return this.edges;
/*     */   }
/*     */   
/*     */   public Set<E> edgesOf(V vertex)
/*     */   {
/* 141 */     assertVertexExist(vertex);
/*     */     
/* 143 */     return new MaskEdgeSet(
/* 144 */       this.base, 
/* 145 */       this.base.edgesOf(vertex), 
/* 146 */       this.mask);
/*     */   }
/*     */   
/*     */   public Set<E> getAllEdges(V sourceVertex, V targetVertex)
/*     */   {
/* 151 */     Set<E> edges = null;
/*     */     
/* 153 */     if ((containsVertex(sourceVertex)) && (containsVertex(targetVertex))) {
/* 154 */       return new MaskEdgeSet(
/* 155 */         this.base, 
/* 156 */         this.base.getAllEdges(
/* 157 */         sourceVertex, 
/* 158 */         targetVertex), 
/* 159 */         this.mask);
/*     */     }
/*     */     
/* 162 */     return edges;
/*     */   }
/*     */   
/*     */   public E getEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 167 */     Set<E> edges = getAllEdges(sourceVertex, targetVertex);
/*     */     
/* 169 */     if ((edges == null) || (edges.isEmpty())) {
/* 170 */       return null;
/*     */     }
/* 172 */     return (E)edges.iterator().next();
/*     */   }
/*     */   
/*     */ 
/*     */   public EdgeFactory<V, E> getEdgeFactory()
/*     */   {
/* 178 */     return this.base.getEdgeFactory();
/*     */   }
/*     */   
/*     */   public V getEdgeSource(E edge)
/*     */   {
/* 183 */     assert (edgeSet().contains(edge));
/*     */     
/* 185 */     return (V)this.base.getEdgeSource(edge);
/*     */   }
/*     */   
/*     */   public V getEdgeTarget(E edge)
/*     */   {
/* 190 */     assert (edgeSet().contains(edge));
/*     */     
/* 192 */     return (V)this.base.getEdgeTarget(edge);
/*     */   }
/*     */   
/*     */   public double getEdgeWeight(E edge)
/*     */   {
/* 197 */     assert (edgeSet().contains(edge));
/*     */     
/* 199 */     return this.base.getEdgeWeight(edge);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> incomingEdgesOf(V vertex)
/*     */   {
/* 207 */     assertVertexExist(vertex);
/*     */     
/* 209 */     return new MaskEdgeSet(
/* 210 */       this.base, 
/* 211 */       ((DirectedGraph)this.base).incomingEdgesOf(vertex), 
/* 212 */       this.mask);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int inDegreeOf(V vertex)
/*     */   {
/* 220 */     return incomingEdgesOf(vertex).size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int outDegreeOf(V vertex)
/*     */   {
/* 228 */     return outgoingEdgesOf(vertex).size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> outgoingEdgesOf(V vertex)
/*     */   {
/* 236 */     assertVertexExist(vertex);
/*     */     
/* 238 */     return new MaskEdgeSet(
/* 239 */       this.base, 
/* 240 */       ((DirectedGraph)this.base).outgoingEdgesOf(vertex), 
/* 241 */       this.mask);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeAllEdges(Collection<? extends E> edges)
/*     */   {
/* 250 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> removeAllEdges(V sourceVertex, V targetVertex)
/*     */   {
/* 259 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeAllVertices(Collection<? extends V> vertices)
/*     */   {
/* 268 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeEdge(E e)
/*     */   {
/* 276 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public E removeEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 284 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeVertex(V v)
/*     */   {
/* 292 */     throw new UnsupportedOperationException("this graph is unmodifiable");
/*     */   }
/*     */   
/*     */   public Set<V> vertexSet()
/*     */   {
/* 297 */     return this.vertices;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\MaskSubgraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */