/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class KShortestPathsIterator<V, E>
/*     */   implements Iterator<Set<V>>
/*     */ {
/*     */   private V endVertex;
/*     */   private Graph<V, E> graph;
/*     */   private int k;
/*     */   private Set<V> prevImprovedVertices;
/*     */   private Map<V, RankingPathElementList<V, E>> prevSeenDataContainer;
/*     */   private Map<V, RankingPathElementList<V, E>> seenDataContainer;
/*     */   private V startVertex;
/*     */   private boolean startVertexEncountered;
/*     */   
/*     */   public KShortestPathsIterator(Graph<V, E> graph, V startVertex, V endVertex, int maxSize)
/*     */   {
/* 119 */     assertKShortestPathsIterator(graph, startVertex);
/*     */     
/* 121 */     this.graph = graph;
/* 122 */     this.startVertex = startVertex;
/* 123 */     this.endVertex = endVertex;
/*     */     
/* 125 */     this.k = maxSize;
/*     */     
/* 127 */     this.seenDataContainer = new HashMap();
/* 128 */     this.prevSeenDataContainer = 
/* 129 */       new HashMap();
/*     */     
/* 131 */     this.prevImprovedVertices = new HashSet();
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
/*     */   public boolean hasNext()
/*     */   {
/* 145 */     if (!this.startVertexEncountered) {
/* 146 */       encounterStartVertex();
/*     */     }
/*     */     
/* 149 */     return !this.prevImprovedVertices.isEmpty();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<V> next()
/*     */   {
/* 160 */     if (!this.startVertexEncountered) {
/* 161 */       encounterStartVertex();
/*     */     }
/*     */     
/* 164 */     if (hasNext()) {
/* 165 */       Set<V> improvedVertices = new HashSet();
/*     */       
/*     */ 
/* 168 */       Iterator<V> iter = this.prevImprovedVertices.iterator();
/* 167 */       while (
/*     */       
/* 169 */         iter.hasNext())
/*     */       {
/* 171 */         V vertex = iter.next();
/* 172 */         if (!vertex.equals(this.endVertex))
/*     */         {
/* 174 */           updateOutgoingVertices(vertex, improvedVertices);
/*     */         }
/*     */       }
/*     */       
/* 178 */       savePassData(improvedVertices);
/*     */       
/* 180 */       return improvedVertices;
/*     */     }
/* 182 */     throw new NoSuchElementException();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void remove()
/*     */   {
/* 192 */     throw new UnsupportedOperationException();
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
/*     */   RankingPathElementList<V, E> getPathElements(V endVertex)
/*     */   {
/* 206 */     return (RankingPathElementList)this.seenDataContainer.get(endVertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void addFirstPath(V vertex, E edge)
/*     */   {
/* 218 */     RankingPathElementList<V, E> data = createSeenData(vertex, edge);
/* 219 */     this.seenDataContainer.put(vertex, data);
/*     */   }
/*     */   
/*     */   private void assertKShortestPathsIterator(Graph<V, E> graph, V startVertex)
/*     */   {
/* 224 */     if (graph == null) {
/* 225 */       throw new NullPointerException("graph is null");
/*     */     }
/* 227 */     if (startVertex == null) {
/* 228 */       throw new NullPointerException("startVertex is null");
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
/*     */   private RankingPathElementList<V, E> createSeenData(V vertex, E edge)
/*     */   {
/* 242 */     V oppositeVertex = Graphs.getOppositeVertex(this.graph, edge, vertex);
/*     */     
/* 244 */     RankingPathElementList<V, E> oppositeData = 
/* 245 */       (RankingPathElementList)this.prevSeenDataContainer.get(oppositeVertex);
/*     */     
/* 247 */     RankingPathElementList<V, E> data = 
/* 248 */       new RankingPathElementList(
/* 249 */       this.graph, 
/* 250 */       this.k, 
/* 251 */       oppositeData, 
/* 252 */       edge);
/*     */     
/* 254 */     return data;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private Set<E> edgesOf(V vertex)
/*     */   {
/* 262 */     if ((this.graph instanceof DirectedGraph)) {
/* 263 */       return ((DirectedGraph)this.graph).outgoingEdgesOf(vertex);
/*     */     }
/* 265 */     return this.graph.edgesOf(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void encounterStartVertex()
/*     */   {
/* 274 */     RankingPathElementList<V, E> data = 
/* 275 */       new RankingPathElementList(
/* 276 */       this.graph, 
/* 277 */       this.k, 
/* 278 */       new RankingPathElement(
/* 279 */       this.startVertex));
/*     */     
/* 281 */     this.seenDataContainer.put(this.startVertex, data);
/* 282 */     this.prevSeenDataContainer.put(this.startVertex, data);
/*     */     
/*     */ 
/*     */ 
/* 286 */     this.prevImprovedVertices.add(this.startVertex);
/*     */     
/* 288 */     this.startVertexEncountered = true;
/*     */   }
/*     */   
/*     */   private void savePassData(Set<V> improvedVertices)
/*     */   {
/* 293 */     for (Iterator<V> iter = improvedVertices.iterator(); iter.hasNext();) {
/* 294 */       V vertex = iter.next();
/*     */       
/* 296 */       RankingPathElementList<V, E> clonedData = 
/* 297 */         new RankingPathElementList(
/* 298 */         (RankingPathElementList)this.seenDataContainer.get(vertex));
/* 299 */       this.prevSeenDataContainer.put(vertex, clonedData);
/*     */     }
/*     */     
/* 302 */     this.prevImprovedVertices = improvedVertices;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean tryToAddNewPaths(V vertex, E edge)
/*     */   {
/* 314 */     RankingPathElementList<V, E> data = (RankingPathElementList)this.seenDataContainer.get(vertex);
/*     */     
/* 316 */     V oppositeVertex = Graphs.getOppositeVertex(this.graph, edge, vertex);
/* 317 */     RankingPathElementList<V, E> oppositeData = 
/* 318 */       (RankingPathElementList)this.prevSeenDataContainer.get(oppositeVertex);
/*     */     
/* 320 */     return data.addPathElements(oppositeData, edge);
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
/*     */   private void updateOutgoingVertices(V vertex, Set<V> improvedVertices)
/*     */   {
/* 338 */     for (Iterator<E> iter = edgesOf(vertex).iterator(); iter.hasNext();) {
/* 339 */       E edge = iter.next();
/* 340 */       V vertexReachedByEdge = 
/* 341 */         Graphs.getOppositeVertex(this.graph, edge, 
/* 342 */         vertex);
/*     */       
/*     */ 
/* 345 */       if (vertexReachedByEdge != this.startVertex) {
/* 346 */         if (this.seenDataContainer.containsKey(vertexReachedByEdge)) {
/* 347 */           boolean relaxed = 
/* 348 */             tryToAddNewPaths(vertexReachedByEdge, 
/* 349 */             edge);
/* 350 */           if (relaxed) {
/* 351 */             improvedVertices.add(vertexReachedByEdge);
/*     */           }
/*     */         } else {
/* 354 */           addFirstPath(vertexReachedByEdge, edge);
/* 355 */           improvedVertices.add(vertexReachedByEdge);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\KShortestPathsIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */