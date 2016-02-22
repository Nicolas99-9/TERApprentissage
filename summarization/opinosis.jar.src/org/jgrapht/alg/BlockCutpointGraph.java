/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Deque;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
/*     */ import org.jgrapht.Graphs;
/*     */ import org.jgrapht.UndirectedGraph;
/*     */ import org.jgrapht.graph.DefaultEdge;
/*     */ import org.jgrapht.graph.MaskFunctor;
/*     */ import org.jgrapht.graph.SimpleDirectedGraph;
/*     */ import org.jgrapht.graph.SimpleGraph;
/*     */ import org.jgrapht.graph.UndirectedMaskSubgraph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BlockCutpointGraph<V, E>
/*     */   extends SimpleGraph<UndirectedGraph<V, E>, DefaultEdge>
/*     */ {
/*     */   private static final long serialVersionUID = -9101341117013163934L;
/*  83 */   private Set<V> cutpoints = new HashSet();
/*     */   
/*     */ 
/*     */   private DirectedGraph<V, DefaultEdge> dfsTree;
/*     */   
/*     */ 
/*     */   private UndirectedGraph<V, E> graph;
/*     */   
/*     */ 
/*     */   private int numOrder;
/*     */   
/*  94 */   private Deque<BlockCutpointGraph<V, E>.BCGEdge> stack = new ArrayDeque();
/*     */   
/*     */ 
/*  97 */   private Map<V, Set<UndirectedGraph<V, E>>> vertex2biconnectedSubgraphs = new HashMap();
/*     */   
/*     */ 
/* 100 */   private Map<V, UndirectedGraph<V, E>> vertex2block = new HashMap();
/*     */   
/* 102 */   private Map<V, Integer> vertex2numOrder = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public BlockCutpointGraph(UndirectedGraph<V, E> graph)
/*     */   {
/* 111 */     super(DefaultEdge.class);
/* 112 */     this.graph = graph;
/*     */     
/* 114 */     this.dfsTree = 
/* 115 */       new SimpleDirectedGraph(
/* 116 */       DefaultEdge.class);
/* 117 */     V s = graph.vertexSet().iterator().next();
/* 118 */     this.dfsTree.addVertex(s);
/* 119 */     dfsVisit(s, s);
/*     */     
/* 121 */     if (this.dfsTree.edgesOf(s).size() > 1) {
/* 122 */       this.cutpoints.add(s);
/*     */     } else {
/* 124 */       this.cutpoints.remove(s);
/*     */     }
/*     */     Iterator<UndirectedGraph<V, E>> iterator;
/* 127 */     for (Iterator<V> iter = this.cutpoints.iterator(); iter.hasNext(); 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 136 */         
/*     */         
/*     */ 
/* 139 */           iterator.hasNext())
/*     */     {
/* 128 */       V cutpoint = iter.next();
/* 129 */       UndirectedGraph<V, E> subgraph = 
/* 130 */         new SimpleGraph(this.graph.getEdgeFactory());
/* 131 */       subgraph.addVertex(cutpoint);
/* 132 */       this.vertex2block.put(cutpoint, subgraph);
/* 133 */       addVertex(subgraph);
/* 134 */       Set<UndirectedGraph<V, E>> biconnectedSubgraphs = 
/* 135 */         getBiconnectedSubgraphs(cutpoint);
/*     */       
/* 137 */       iterator = 
/* 138 */         biconnectedSubgraphs.iterator();
/* 139 */       continue;
/*     */       
/* 141 */       UndirectedGraph<V, E> biconnectedSubgraph = (UndirectedGraph)iterator.next();
/* 142 */       assert (vertexSet().contains(biconnectedSubgraph));
/* 143 */       addEdge(subgraph, biconnectedSubgraph);
/*     */     }
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
/*     */   public UndirectedGraph<V, E> getBlock(V vertex)
/*     */   {
/* 158 */     if (!this.graph.vertexSet().contains(vertex)) {
/* 159 */       throw new IllegalArgumentException("No such vertex in the graph!");
/*     */     }
/*     */     
/* 162 */     return (UndirectedGraph)this.vertex2block.get(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<V> getCutpoints()
/*     */   {
/* 170 */     return this.cutpoints;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isCutpoint(V vertex)
/*     */   {
/* 181 */     if (!this.graph.vertexSet().contains(vertex)) {
/* 182 */       throw new IllegalArgumentException("No such vertex in the graph!");
/*     */     }
/*     */     
/* 185 */     return this.cutpoints.contains(vertex);
/*     */   }
/*     */   
/*     */   private void biconnectedComponentFinished(V s, V n)
/*     */   {
/* 190 */     this.cutpoints.add(s);
/*     */     
/* 192 */     Set<V> vertexComponent = new HashSet();
/* 193 */     Set<BlockCutpointGraph<V, E>.BCGEdge> edgeComponent = new HashSet();
/* 194 */     BlockCutpointGraph<V, E>.BCGEdge edge = (BCGEdge)this.stack.removeLast();
/*     */     
/* 196 */     while ((getNumOrder(edge.getSource()) >= getNumOrder(n)) && (!
/* 197 */       this.stack.isEmpty()))
/*     */     {
/* 199 */       edgeComponent.add(edge);
/*     */       
/* 201 */       vertexComponent.add(edge.getSource());
/* 202 */       vertexComponent.add(edge.getTarget());
/*     */       
/* 204 */       edge = (BCGEdge)this.stack.removeLast();
/*     */     }
/* 206 */     edgeComponent.add(edge);
/*     */     
/*     */ 
/* 209 */     vertexComponent.add(edge.getSource());
/* 210 */     vertexComponent.add(edge.getTarget());
/*     */     
/* 212 */     BlockCutpointGraph<V, E>.VertexComponentForbiddenFunction mask = 
/* 213 */       new VertexComponentForbiddenFunction(
/* 214 */       vertexComponent);
/* 215 */     UndirectedGraph<V, E> biconnectedSubgraph = 
/* 216 */       new UndirectedMaskSubgraph(
/* 217 */       this.graph, 
/* 218 */       mask);
/* 219 */     for (Iterator<V> iter = vertexComponent.iterator(); iter.hasNext();) {
/* 220 */       V vertex = iter.next();
/* 221 */       this.vertex2block.put(vertex, biconnectedSubgraph);
/* 222 */       getBiconnectedSubgraphs(vertex).add(biconnectedSubgraph);
/*     */     }
/* 224 */     addVertex(biconnectedSubgraph);
/*     */   }
/*     */   
/*     */   private int dfsVisit(V s, V father)
/*     */   {
/* 229 */     this.numOrder += 1;
/* 230 */     int minS = this.numOrder;
/* 231 */     setNumOrder(s, this.numOrder);
/*     */     
/*     */ 
/* 234 */     Iterator<E> iter = this.graph.edgesOf(s).iterator();
/* 233 */     while (
/*     */     
/* 235 */       iter.hasNext())
/*     */     {
/* 237 */       E edge = iter.next();
/* 238 */       V n = Graphs.getOppositeVertex(this.graph, edge, s);
/* 239 */       if (getNumOrder(n) == 0) {
/* 240 */         this.dfsTree.addVertex(n);
/* 241 */         BlockCutpointGraph<V, E>.BCGEdge dfsEdge = new BCGEdge(s, n);
/* 242 */         this.dfsTree.addEdge(s, n, dfsEdge);
/*     */         
/* 244 */         this.stack.add(dfsEdge);
/*     */         
/*     */ 
/*     */ 
/* 248 */         int minN = dfsVisit(n, s);
/* 249 */         minS = Math.min(minN, minS);
/* 250 */         if (minN >= getNumOrder(s))
/*     */         {
/*     */ 
/* 253 */           biconnectedComponentFinished(s, n);
/*     */         }
/* 255 */       } else if ((getNumOrder(n) < getNumOrder(s)) && (!n.equals(father))) {
/* 256 */         BlockCutpointGraph<V, E>.BCGEdge backwardEdge = new BCGEdge(s, n);
/* 257 */         this.stack.add(backwardEdge);
/*     */         
/*     */ 
/* 260 */         minS = Math.min(getNumOrder(n), minS);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 266 */     return minS;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Set<UndirectedGraph<V, E>> getBiconnectedSubgraphs(V vertex)
/*     */   {
/* 278 */     Set<UndirectedGraph<V, E>> biconnectedSubgraphs = 
/* 279 */       (Set)this.vertex2biconnectedSubgraphs.get(vertex);
/* 280 */     if (biconnectedSubgraphs == null) {
/* 281 */       biconnectedSubgraphs = new HashSet();
/* 282 */       this.vertex2biconnectedSubgraphs.put(vertex, biconnectedSubgraphs);
/*     */     }
/* 284 */     return biconnectedSubgraphs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getNumOrder(V vertex)
/*     */   {
/* 292 */     assert (vertex != null);
/*     */     
/* 294 */     Integer numOrder = (Integer)this.vertex2numOrder.get(vertex);
/* 295 */     if (numOrder == null) {
/* 296 */       return 0;
/*     */     }
/* 298 */     return numOrder.intValue();
/*     */   }
/*     */   
/*     */ 
/*     */   private void setNumOrder(V vertex, int numOrder)
/*     */   {
/* 304 */     this.vertex2numOrder.put(vertex, Integer.valueOf(numOrder));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private class BCGEdge
/*     */     extends DefaultEdge
/*     */   {
/*     */     private static final long serialVersionUID = -5115006161815760059L;
/*     */     
/*     */ 
/*     */     private V source;
/*     */     
/*     */ 
/*     */     private V target;
/*     */     
/*     */ 
/*     */     public BCGEdge(V source)
/*     */     {
/* 323 */       this.source = source;
/* 324 */       this.target = target;
/*     */     }
/*     */     
/*     */ 
/*     */     public V getSource()
/*     */     {
/* 330 */       return (V)this.source;
/*     */     }
/*     */     
/*     */ 
/*     */     public V getTarget()
/*     */     {
/* 336 */       return (V)this.target;
/*     */     }
/*     */   }
/*     */   
/*     */   private class VertexComponentForbiddenFunction
/*     */     implements MaskFunctor<V, E>
/*     */   {
/*     */     private Set<V> vertexComponent;
/*     */     
/*     */     public VertexComponentForbiddenFunction()
/*     */     {
/* 347 */       this.vertexComponent = vertexComponent;
/*     */     }
/*     */     
/*     */     public boolean isEdgeMasked(E edge)
/*     */     {
/* 352 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isVertexMasked(V vertex)
/*     */     {
/* 357 */       if (this.vertexComponent.contains(vertex))
/*     */       {
/* 359 */         return false;
/*     */       }
/* 361 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\BlockCutpointGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */