/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.Graphs;
/*     */ import org.jgrapht.UndirectedGraph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class BellmanFordIterator<V, E>
/*     */   implements Iterator<List<V>>
/*     */ {
/*     */   protected static final String NEGATIVE_UNDIRECTED_EDGE = "Negativeedge-weights are not allowed in an unidrected graph!";
/*     */   protected Graph<V, E> graph;
/*     */   protected V startVertex;
/*  80 */   private List<V> prevImprovedVertices = new ArrayList();
/*     */   
/*     */   private Map<V, BellmanFordPathElement<V, E>> prevVertexData;
/*     */   
/*  84 */   private boolean startVertexEncountered = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<V, BellmanFordPathElement<V, E>> vertexData;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private double epsilon;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected BellmanFordIterator(Graph<V, E> graph, V startVertex, double epsilon)
/*     */   {
/* 106 */     assertBellmanFordIterator(graph, startVertex);
/*     */     
/* 108 */     this.graph = graph;
/* 109 */     this.startVertex = startVertex;
/* 110 */     this.epsilon = epsilon;
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
/*     */   public BellmanFordPathElement<V, E> getPathElement(V endVertex)
/*     */   {
/* 125 */     return getSeenData(endVertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasNext()
/*     */   {
/* 134 */     if (!this.startVertexEncountered) {
/* 135 */       encounterStartVertex();
/*     */     }
/*     */     
/* 138 */     return !this.prevImprovedVertices.isEmpty();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<V> next()
/*     */   {
/* 149 */     if (!this.startVertexEncountered) {
/* 150 */       encounterStartVertex();
/*     */     }
/*     */     
/* 153 */     if (hasNext()) {
/* 154 */       List<V> improvedVertices = new ArrayList();
/* 155 */       for (int i = this.prevImprovedVertices.size() - 1; i >= 0; i--) {
/* 156 */         V vertex = this.prevImprovedVertices.get(i);
/*     */         
/* 158 */         Iterator<? extends E> iter = edgesOfIterator(vertex);
/* 157 */         while (
/*     */         
/* 159 */           iter.hasNext())
/*     */         {
/* 161 */           E edge = iter.next();
/* 162 */           V oppositeVertex = 
/* 163 */             Graphs.getOppositeVertex(
/* 164 */             this.graph, 
/* 165 */             edge, 
/* 166 */             vertex);
/* 167 */           if (getPathElement(oppositeVertex) != null) {
/* 168 */             boolean relaxed = 
/* 169 */               relaxVertexAgain(oppositeVertex, edge);
/* 170 */             if (relaxed) {
/* 171 */               improvedVertices.add(oppositeVertex);
/*     */             }
/*     */           } else {
/* 174 */             relaxVertex(oppositeVertex, edge);
/* 175 */             improvedVertices.add(oppositeVertex);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 180 */       savePassData(improvedVertices);
/*     */       
/* 182 */       return improvedVertices;
/*     */     }
/*     */     
/* 185 */     throw new NoSuchElementException();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void remove()
/*     */   {
/* 195 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void assertValidEdge(E edge)
/*     */   {
/* 206 */     if (((this.graph instanceof UndirectedGraph)) && 
/* 207 */       (this.graph.getEdgeWeight(edge) < 0.0D)) {
/* 208 */       throw new IllegalArgumentException("Negativeedge-weights are not allowed in an unidrected graph!");
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
/*     */ 
/*     */ 
/*     */ 
/*     */   protected double calculatePathCost(V vertex, E edge)
/*     */   {
/* 226 */     V oppositeVertex = Graphs.getOppositeVertex(this.graph, edge, vertex);
/*     */     
/*     */ 
/* 229 */     BellmanFordPathElement<V, E> oppositePrevData = 
/* 230 */       getPrevSeenData(oppositeVertex);
/*     */     
/* 232 */     double pathCost = this.graph.getEdgeWeight(edge);
/*     */     
/* 234 */     if (!oppositePrevData.getVertex().equals(this.startVertex))
/*     */     {
/*     */ 
/* 237 */       pathCost += oppositePrevData.getCost();
/*     */     }
/*     */     
/* 240 */     return pathCost;
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
/*     */   protected Iterator<E> edgesOfIterator(V vertex)
/*     */   {
/* 253 */     if ((this.graph instanceof DirectedGraph)) {
/* 254 */       return 
/* 255 */         ((DirectedGraph)this.graph).outgoingEdgesOf(vertex).iterator();
/*     */     }
/* 257 */     return this.graph.edgesOf(vertex).iterator();
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
/*     */   protected BellmanFordPathElement<V, E> getPrevSeenData(V vertex)
/*     */   {
/* 271 */     return (BellmanFordPathElement)this.prevVertexData.get(vertex);
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
/*     */   protected BellmanFordPathElement<V, E> getSeenData(V vertex)
/*     */   {
/* 284 */     return (BellmanFordPathElement)this.vertexData.get(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean isSeenVertex(V vertex)
/*     */   {
/* 296 */     return this.vertexData.containsKey(vertex);
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
/*     */   protected BellmanFordPathElement<V, E> putPrevSeenData(V vertex, BellmanFordPathElement<V, E> data)
/*     */   {
/* 309 */     if (this.prevVertexData == null) {
/* 310 */       this.prevVertexData = 
/* 311 */         new HashMap();
/*     */     }
/*     */     
/* 314 */     return (BellmanFordPathElement)this.prevVertexData.put(vertex, data);
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
/*     */   protected BellmanFordPathElement<V, E> putSeenData(V vertex, BellmanFordPathElement<V, E> data)
/*     */   {
/* 331 */     if (this.vertexData == null) {
/* 332 */       this.vertexData = new HashMap();
/*     */     }
/*     */     
/* 335 */     return (BellmanFordPathElement)this.vertexData.put(vertex, data);
/*     */   }
/*     */   
/*     */   private void assertBellmanFordIterator(Graph<V, E> graph, V startVertex)
/*     */   {
/* 340 */     if (!graph.containsVertex(startVertex)) {
/* 341 */       throw new IllegalArgumentException(
/* 342 */         "Graph must contain the start vertex!");
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
/*     */ 
/*     */ 
/*     */ 
/*     */   private BellmanFordPathElement<V, E> createSeenData(V vertex, E edge, double cost)
/*     */   {
/* 360 */     BellmanFordPathElement<V, E> prevPathElement = 
/* 361 */       getPrevSeenData(
/* 362 */       Graphs.getOppositeVertex(this.graph, edge, vertex));
/*     */     
/* 364 */     BellmanFordPathElement<V, E> data = 
/* 365 */       new BellmanFordPathElement(
/* 366 */       this.graph, 
/* 367 */       prevPathElement, 
/* 368 */       edge, 
/* 369 */       cost, 
/* 370 */       this.epsilon);
/*     */     
/* 372 */     return data;
/*     */   }
/*     */   
/*     */   private void encounterStartVertex()
/*     */   {
/* 377 */     BellmanFordPathElement<V, E> data = 
/* 378 */       new BellmanFordPathElement(
/* 379 */       this.startVertex, 
/* 380 */       this.epsilon);
/*     */     
/*     */ 
/* 383 */     this.prevImprovedVertices.add(this.startVertex);
/*     */     
/* 385 */     putSeenData(this.startVertex, data);
/* 386 */     putPrevSeenData(this.startVertex, data);
/*     */     
/* 388 */     this.startVertexEncountered = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void relaxVertex(V vertex, E edge)
/*     */   {
/* 399 */     assertValidEdge(edge);
/*     */     
/* 401 */     double shortestPathCost = calculatePathCost(vertex, edge);
/*     */     
/* 403 */     BellmanFordPathElement<V, E> data = 
/* 404 */       createSeenData(vertex, edge, 
/* 405 */       shortestPathCost);
/*     */     
/* 407 */     putSeenData(vertex, data);
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
/*     */   private boolean relaxVertexAgain(V vertex, E edge)
/*     */   {
/* 422 */     assertValidEdge(edge);
/*     */     
/* 424 */     double candidateCost = calculatePathCost(vertex, edge);
/*     */     
/*     */ 
/* 427 */     BellmanFordPathElement<V, E> oppositePrevData = 
/* 428 */       getPrevSeenData(
/* 429 */       Graphs.getOppositeVertex(this.graph, edge, vertex));
/*     */     
/* 431 */     BellmanFordPathElement<V, E> pathElement = getSeenData(vertex);
/* 432 */     return pathElement.improve(oppositePrevData, edge, candidateCost);
/*     */   }
/*     */   
/*     */   private void savePassData(List<V> improvedVertices)
/*     */   {
/* 437 */     for (V vertex : improvedVertices) {
/* 438 */       BellmanFordPathElement<V, E> orig = getSeenData(vertex);
/* 439 */       BellmanFordPathElement<V, E> clonedData = 
/* 440 */         new BellmanFordPathElement(orig);
/* 441 */       putPrevSeenData(vertex, clonedData);
/*     */     }
/*     */     
/* 444 */     this.prevImprovedVertices = improvedVertices;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\BellmanFordIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */