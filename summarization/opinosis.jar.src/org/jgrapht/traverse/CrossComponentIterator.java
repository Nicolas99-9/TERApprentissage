/*     */ package org.jgrapht.traverse;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.Graphs;
/*     */ import org.jgrapht.event.ConnectedComponentTraversalEvent;
/*     */ import org.jgrapht.event.EdgeTraversalEvent;
/*     */ import org.jgrapht.event.VertexTraversalEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class CrossComponentIterator<V, E, D>
/*     */   extends AbstractGraphIterator<V, E>
/*     */ {
/*     */   private static final int CCS_BEFORE_COMPONENT = 1;
/*     */   private static final int CCS_WITHIN_COMPONENT = 2;
/*     */   private static final int CCS_AFTER_COMPONENT = 3;
/*     */   
/*     */   protected static enum VisitColor
/*     */   {
/*  83 */     WHITE, 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  89 */     GRAY, 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  95 */     BLACK;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 102 */   private final ConnectedComponentTraversalEvent ccFinishedEvent = new ConnectedComponentTraversalEvent(
/* 103 */     this, 
/* 104 */     32);
/*     */   
/* 106 */   private final ConnectedComponentTraversalEvent ccStartedEvent = new ConnectedComponentTraversalEvent(
/* 107 */     this, 
/* 108 */     31);
/*     */   
/*     */   private FlyweightEdgeEvent<V, E> reusableEdgeEvent;
/*     */   
/*     */   private FlyweightVertexEvent<V> reusableVertexEvent;
/*     */   
/* 114 */   private Iterator<V> vertexIterator = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 120 */   private Map<V, D> seen = new HashMap();
/*     */   
/*     */ 
/*     */   private V startVertex;
/*     */   
/*     */   private Specifics<V, E> specifics;
/*     */   
/*     */   private final Graph<V, E> graph;
/*     */   
/* 129 */   private int state = 1;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CrossComponentIterator(Graph<V, E> g, V startVertex)
/*     */   {
/* 148 */     if (g == null) {
/* 149 */       throw new IllegalArgumentException("graph must not be null");
/*     */     }
/* 151 */     this.graph = g;
/*     */     
/* 153 */     this.specifics = createGraphSpecifics(g);
/* 154 */     this.vertexIterator = g.vertexSet().iterator();
/* 155 */     setCrossComponentTraversal(startVertex == null);
/*     */     
/* 157 */     this.reusableEdgeEvent = new FlyweightEdgeEvent(this, null);
/* 158 */     this.reusableVertexEvent = new FlyweightVertexEvent(this, null);
/*     */     
/* 160 */     if (startVertex == null)
/*     */     {
/* 162 */       if (this.vertexIterator.hasNext()) {
/* 163 */         this.startVertex = this.vertexIterator.next();
/*     */       } else {
/* 165 */         this.startVertex = null;
/*     */       }
/* 167 */     } else if (g.containsVertex(startVertex)) {
/* 168 */       this.startVertex = startVertex;
/*     */     } else {
/* 170 */       throw new IllegalArgumentException(
/* 171 */         "graph must contain the start vertex");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Graph<V, E> getGraph()
/*     */   {
/* 182 */     return this.graph;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasNext()
/*     */   {
/* 190 */     if (this.startVertex != null) {
/* 191 */       encounterStartVertex();
/*     */     }
/*     */     
/* 194 */     if (isConnectedComponentExhausted()) {
/* 195 */       if (this.state == 2) {
/* 196 */         this.state = 3;
/* 197 */         if (this.nListeners != 0) {
/* 198 */           fireConnectedComponentFinished(this.ccFinishedEvent);
/*     */         }
/*     */       }
/*     */       
/* 202 */       if (isCrossComponentTraversal()) {
/* 203 */         while (this.vertexIterator.hasNext()) {
/* 204 */           V v = this.vertexIterator.next();
/*     */           
/* 206 */           if (!isSeenVertex(v)) {
/* 207 */             encounterVertex(v, null);
/* 208 */             this.state = 1;
/*     */             
/* 210 */             return true;
/*     */           }
/*     */         }
/*     */         
/* 214 */         return false;
/*     */       }
/* 216 */       return false;
/*     */     }
/*     */     
/* 219 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public V next()
/*     */   {
/* 228 */     if (this.startVertex != null) {
/* 229 */       encounterStartVertex();
/*     */     }
/*     */     
/* 232 */     if (hasNext()) {
/* 233 */       if (this.state == 1) {
/* 234 */         this.state = 2;
/* 235 */         if (this.nListeners != 0) {
/* 236 */           fireConnectedComponentStarted(this.ccStartedEvent);
/*     */         }
/*     */       }
/*     */       
/* 240 */       V nextVertex = provideNextVertex();
/* 241 */       if (this.nListeners != 0) {
/* 242 */         fireVertexTraversed(createVertexTraversalEvent(nextVertex));
/*     */       }
/*     */       
/* 245 */       addUnseenChildrenOf(nextVertex);
/*     */       
/* 247 */       return nextVertex;
/*     */     }
/* 249 */     throw new NoSuchElementException();
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
/*     */   protected abstract boolean isConnectedComponentExhausted();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected abstract void encounterVertex(V paramV, E paramE);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected abstract V provideNextVertex();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected D getSeenData(V vertex)
/*     */   {
/* 291 */     return (D)this.seen.get(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean isSeenVertex(Object vertex)
/*     */   {
/* 303 */     return this.seen.containsKey(vertex);
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
/*     */   protected abstract void encounterVertexAgain(V paramV, E paramE);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected D putSeenData(V vertex, D data)
/*     */   {
/* 328 */     return (D)this.seen.put(vertex, data);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void finishVertex(V vertex)
/*     */   {
/* 339 */     if (this.nListeners != 0) {
/* 340 */       fireVertexFinished(createVertexTraversalEvent(vertex));
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
/*     */   static <V, E> Specifics<V, E> createGraphSpecifics(Graph<V, E> g)
/*     */   {
/* 354 */     if ((g instanceof DirectedGraph)) {
/* 355 */       return new DirectedSpecifics((DirectedGraph)g);
/*     */     }
/* 357 */     return new UndirectedSpecifics(g);
/*     */   }
/*     */   
/*     */ 
/*     */   private void addUnseenChildrenOf(V vertex)
/*     */   {
/* 363 */     for (E edge : this.specifics.edgesOf(vertex)) {
/* 364 */       if (this.nListeners != 0) {
/* 365 */         fireEdgeTraversed(createEdgeTraversalEvent(edge));
/*     */       }
/*     */       
/* 368 */       V oppositeV = Graphs.getOppositeVertex(this.graph, edge, vertex);
/*     */       
/* 370 */       if (isSeenVertex(oppositeV)) {
/* 371 */         encounterVertexAgain(oppositeV, edge);
/*     */       } else {
/* 373 */         encounterVertex(oppositeV, edge);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private EdgeTraversalEvent<V, E> createEdgeTraversalEvent(E edge)
/*     */   {
/* 380 */     if (isReuseEvents()) {
/* 381 */       this.reusableEdgeEvent.setEdge(edge);
/*     */       
/* 383 */       return this.reusableEdgeEvent;
/*     */     }
/* 385 */     return new EdgeTraversalEvent(this, edge);
/*     */   }
/*     */   
/*     */ 
/*     */   private VertexTraversalEvent<V> createVertexTraversalEvent(V vertex)
/*     */   {
/* 391 */     if (isReuseEvents()) {
/* 392 */       this.reusableVertexEvent.setVertex(vertex);
/*     */       
/* 394 */       return this.reusableVertexEvent;
/*     */     }
/* 396 */     return new VertexTraversalEvent(this, vertex);
/*     */   }
/*     */   
/*     */ 
/*     */   private void encounterStartVertex()
/*     */   {
/* 402 */     encounterVertex(this.startVertex, null);
/* 403 */     this.startVertex = null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static class FlyweightEdgeEvent<VV, localE>
/*     */     extends EdgeTraversalEvent<VV, localE>
/*     */   {
/*     */     private static final long serialVersionUID = 4051327833765000755L;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public FlyweightEdgeEvent(Object eventSource, localE edge)
/*     */     {
/* 470 */       super(edge);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     protected void setEdge(localE edge)
/*     */     {
/* 480 */       this.edge = edge;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static class FlyweightVertexEvent<VV>
/*     */     extends VertexTraversalEvent<VV>
/*     */   {
/*     */     private static final long serialVersionUID = 3834024753848399924L;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public FlyweightVertexEvent(Object eventSource, VV vertex)
/*     */     {
/* 500 */       super(vertex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     protected void setVertex(VV vertex)
/*     */     {
/* 510 */       this.vertex = vertex;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class DirectedSpecifics<VV, EE>
/*     */     extends CrossComponentIterator.Specifics<VV, EE>
/*     */   {
/*     */     private DirectedGraph<VV, EE> graph;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public DirectedSpecifics(DirectedGraph<VV, EE> g)
/*     */     {
/* 529 */       this.graph = g;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Set<? extends EE> edgesOf(VV vertex)
/*     */     {
/* 538 */       return this.graph.outgoingEdgesOf(vertex);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class UndirectedSpecifics<VV, EE>
/*     */     extends CrossComponentIterator.Specifics<VV, EE>
/*     */   {
/*     */     private Graph<VV, EE> graph;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public UndirectedSpecifics(Graph<VV, EE> g)
/*     */     {
/* 558 */       this.graph = g;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public Set<EE> edgesOf(VV vertex)
/*     */     {
/* 567 */       return this.graph.edgesOf(vertex);
/*     */     }
/*     */   }
/*     */   
/*     */   static abstract interface SimpleContainer<T>
/*     */   {
/*     */     public abstract boolean isEmpty();
/*     */     
/*     */     public abstract void add(T paramT);
/*     */     
/*     */     public abstract T remove();
/*     */   }
/*     */   
/*     */   static abstract class Specifics<VV, EE>
/*     */   {
/*     */     public abstract Set<? extends EE> edgesOf(VV paramVV);
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\traverse\CrossComponentIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */