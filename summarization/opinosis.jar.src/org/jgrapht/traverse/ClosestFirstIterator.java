/*     */ package org.jgrapht.traverse;
/*     */ 
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.Graphs;
/*     */ import org.jgrapht.util.FibonacciHeap;
/*     */ import org.jgrapht.util.FibonacciHeapNode;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClosestFirstIterator<V, E>
/*     */   extends CrossComponentIterator<V, E, FibonacciHeapNode<QueueEntry<V, E>>>
/*     */ {
/*  73 */   private FibonacciHeap<QueueEntry<V, E>> heap = new FibonacciHeap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  78 */   private double radius = Double.POSITIVE_INFINITY;
/*     */   
/*  80 */   private boolean initialized = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ClosestFirstIterator(Graph<V, E> g)
/*     */   {
/*  91 */     this(g, null);
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
/*     */   public ClosestFirstIterator(Graph<V, E> g, V startVertex)
/*     */   {
/* 106 */     this(g, startVertex, Double.POSITIVE_INFINITY);
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
/*     */   public ClosestFirstIterator(Graph<V, E> g, V startVertex, double radius)
/*     */   {
/* 124 */     super(g, startVertex);
/* 125 */     this.radius = radius;
/* 126 */     checkRadiusTraversal(isCrossComponentTraversal());
/* 127 */     this.initialized = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCrossComponentTraversal(boolean crossComponentTraversal)
/*     */   {
/* 136 */     if (this.initialized) {
/* 137 */       checkRadiusTraversal(crossComponentTraversal);
/*     */     }
/* 139 */     super.setCrossComponentTraversal(crossComponentTraversal);
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
/*     */   public double getShortestPathLength(V vertex)
/*     */   {
/* 154 */     FibonacciHeapNode<QueueEntry<V, E>> node = (FibonacciHeapNode)getSeenData(vertex);
/*     */     
/* 156 */     if (node == null) {
/* 157 */       return Double.POSITIVE_INFINITY;
/*     */     }
/*     */     
/* 160 */     return node.getKey();
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
/*     */   public E getSpanningTreeEdge(V vertex)
/*     */   {
/* 177 */     FibonacciHeapNode<QueueEntry<V, E>> node = (FibonacciHeapNode)getSeenData(vertex);
/*     */     
/* 179 */     if (node == null) {
/* 180 */       return null;
/*     */     }
/*     */     
/* 183 */     return (E)((QueueEntry)node.getData()).spanningTreeEdge;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean isConnectedComponentExhausted()
/*     */   {
/* 192 */     if (this.heap.size() == 0) {
/* 193 */       return true;
/*     */     }
/* 195 */     if (this.heap.min().getKey() > this.radius) {
/* 196 */       this.heap.clear();
/*     */       
/* 198 */       return true;
/*     */     }
/* 200 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void encounterVertex(V vertex, E edge)
/*     */   {
/* 211 */     FibonacciHeapNode<QueueEntry<V, E>> node = createSeenData(vertex, edge);
/* 212 */     putSeenData(vertex, node);
/* 213 */     this.heap.insert(node, node.getKey());
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
/*     */   protected void encounterVertexAgain(V vertex, E edge)
/*     */   {
/* 226 */     FibonacciHeapNode<QueueEntry<V, E>> node = (FibonacciHeapNode)getSeenData(vertex);
/*     */     
/* 228 */     if (((QueueEntry)node.getData()).frozen)
/*     */     {
/* 230 */       return;
/*     */     }
/*     */     
/* 233 */     double candidatePathLength = calculatePathLength(vertex, edge);
/*     */     
/* 235 */     if (candidatePathLength < node.getKey()) {
/* 236 */       ((QueueEntry)node.getData()).spanningTreeEdge = edge;
/* 237 */       this.heap.decreaseKey(node, candidatePathLength);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected V provideNextVertex()
/*     */   {
/* 247 */     FibonacciHeapNode<QueueEntry<V, E>> node = this.heap.removeMin();
/* 248 */     ((QueueEntry)node.getData()).frozen = true;
/*     */     
/* 250 */     return (V)((QueueEntry)node.getData()).vertex;
/*     */   }
/*     */   
/*     */   private void assertNonNegativeEdge(E edge)
/*     */   {
/* 255 */     if (getGraph().getEdgeWeight(edge) < 0.0D) {
/* 256 */       throw new IllegalArgumentException(
/* 257 */         "negative edge weights not allowed");
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
/*     */   private double calculatePathLength(V vertex, E edge)
/*     */   {
/* 272 */     assertNonNegativeEdge(edge);
/*     */     
/* 274 */     V otherVertex = Graphs.getOppositeVertex(getGraph(), edge, vertex);
/* 275 */     FibonacciHeapNode<QueueEntry<V, E>> otherEntry = 
/* 276 */       (FibonacciHeapNode)getSeenData(otherVertex);
/*     */     
/* 278 */     return otherEntry.getKey() + 
/* 279 */       getGraph().getEdgeWeight(edge);
/*     */   }
/*     */   
/*     */   private void checkRadiusTraversal(boolean crossComponentTraversal)
/*     */   {
/* 284 */     if ((crossComponentTraversal) && (this.radius != Double.POSITIVE_INFINITY)) {
/* 285 */       throw new IllegalArgumentException(
/* 286 */         "radius may not be specified for cross-component traversal");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private FibonacciHeapNode<QueueEntry<V, E>> createSeenData(V vertex, E edge)
/*     */   {
/*     */     double shortestPathLength;
/*     */     
/*     */ 
/*     */ 
/*     */     double shortestPathLength;
/*     */     
/*     */ 
/*     */ 
/* 304 */     if (edge == null) {
/* 305 */       shortestPathLength = 0.0D;
/*     */     } else {
/* 307 */       shortestPathLength = calculatePathLength(vertex, edge);
/*     */     }
/*     */     
/* 310 */     QueueEntry<V, E> entry = new QueueEntry();
/* 311 */     entry.vertex = vertex;
/* 312 */     entry.spanningTreeEdge = edge;
/*     */     
/* 314 */     return new FibonacciHeapNode(
/* 315 */       entry, 
/* 316 */       shortestPathLength);
/*     */   }
/*     */   
/*     */   static class QueueEntry<V, E>
/*     */   {
/*     */     E spanningTreeEdge;
/*     */     V vertex;
/*     */     boolean frozen;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\traverse\ClosestFirstIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */