/*     */ package org.jgrapht.graph;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.EventListener;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.ListenableGraph;
/*     */ import org.jgrapht.event.GraphEdgeChangeEvent;
/*     */ import org.jgrapht.event.GraphListener;
/*     */ import org.jgrapht.event.GraphVertexChangeEvent;
/*     */ import org.jgrapht.event.VertexSetListener;
/*     */ import org.jgrapht.util.TypeUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultListenableGraph<V, E>
/*     */   extends GraphDelegator<V, E>
/*     */   implements ListenableGraph<V, E>, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = 3977575900898471984L;
/*  83 */   private ArrayList<GraphListener<V, E>> graphListeners = new ArrayList();
/*     */   
/*  85 */   private ArrayList<VertexSetListener<V>> vertexSetListeners = new ArrayList();
/*     */   
/*     */ 
/*     */   private FlyweightEdgeEvent<V, E> reuseableEdgeEvent;
/*     */   
/*     */ 
/*     */   private FlyweightVertexEvent<V> reuseableVertexEvent;
/*     */   
/*     */ 
/*     */   private boolean reuseEvents;
/*     */   
/*     */ 
/*     */   public DefaultListenableGraph(Graph<V, E> g)
/*     */   {
/*  99 */     this(g, false);
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
/*     */   public DefaultListenableGraph(Graph<V, E> g, boolean reuseEvents)
/*     */   {
/* 118 */     super(g);
/* 119 */     this.reuseEvents = reuseEvents;
/* 120 */     this.reuseableEdgeEvent = new FlyweightEdgeEvent(this, -1, null);
/* 121 */     this.reuseableVertexEvent = new FlyweightVertexEvent(this, -1, null);
/*     */     
/*     */ 
/* 124 */     if ((g instanceof ListenableGraph)) {
/* 125 */       throw new IllegalArgumentException(
/* 126 */         "base graph cannot be listenable");
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
/*     */   public void setReuseEvents(boolean reuseEvents)
/*     */   {
/* 143 */     this.reuseEvents = reuseEvents;
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
/*     */   public boolean isReuseEvents()
/*     */   {
/* 157 */     return this.reuseEvents;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public E addEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 166 */     E e = super.addEdge(sourceVertex, targetVertex);
/*     */     
/* 168 */     if (e != null) {
/* 169 */       fireEdgeAdded(e);
/*     */     }
/*     */     
/* 172 */     return e;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addEdge(V sourceVertex, V targetVertex, E e)
/*     */   {
/* 181 */     boolean added = super.addEdge(sourceVertex, targetVertex, e);
/*     */     
/* 183 */     if (added) {
/* 184 */       fireEdgeAdded(e);
/*     */     }
/*     */     
/* 187 */     return added;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addGraphListener(GraphListener<V, E> l)
/*     */   {
/* 195 */     addToListenerList(this.graphListeners, l);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addVertex(V v)
/*     */   {
/* 204 */     boolean modified = super.addVertex(v);
/*     */     
/* 206 */     if (modified) {
/* 207 */       fireVertexAdded(v);
/*     */     }
/*     */     
/* 210 */     return modified;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addVertexSetListener(VertexSetListener<V> l)
/*     */   {
/* 218 */     addToListenerList(this.vertexSetListeners, l);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Object clone()
/*     */   {
/*     */     try
/*     */     {
/* 228 */       TypeUtil<DefaultListenableGraph<V, E>> typeDecl = null;
/*     */       
/* 230 */       DefaultListenableGraph<V, E> g = 
/* 231 */         (DefaultListenableGraph)TypeUtil.uncheckedCast(super.clone(), typeDecl);
/* 232 */       g.graphListeners = new ArrayList();
/* 233 */       g.vertexSetListeners = new ArrayList();
/*     */       
/* 235 */       return g;
/*     */     }
/*     */     catch (CloneNotSupportedException e) {
/* 238 */       e.printStackTrace();
/* 239 */       throw new RuntimeException("internal error");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public E removeEdge(V sourceVertex, V targetVertex)
/*     */   {
/* 249 */     E e = super.removeEdge(sourceVertex, targetVertex);
/*     */     
/* 251 */     if (e != null) {
/* 252 */       fireEdgeRemoved(e);
/*     */     }
/*     */     
/* 255 */     return e;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeEdge(E e)
/*     */   {
/* 264 */     boolean modified = super.removeEdge(e);
/*     */     
/* 266 */     if (modified) {
/* 267 */       fireEdgeRemoved(e);
/*     */     }
/*     */     
/* 270 */     return modified;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeGraphListener(GraphListener<V, E> l)
/*     */   {
/* 278 */     this.graphListeners.remove(l);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeVertex(V v)
/*     */   {
/* 287 */     if (containsVertex(v)) {
/* 288 */       Set<E> touchingEdgesList = edgesOf(v);
/*     */       
/*     */ 
/* 291 */       removeAllEdges(new ArrayList(touchingEdgesList));
/*     */       
/* 293 */       super.removeVertex(v);
/*     */       
/* 295 */       fireVertexRemoved(v);
/*     */       
/* 297 */       return true;
/*     */     }
/* 299 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeVertexSetListener(VertexSetListener<V> l)
/*     */   {
/* 308 */     this.vertexSetListeners.remove(l);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void fireEdgeAdded(E edge)
/*     */   {
/* 318 */     GraphEdgeChangeEvent<V, E> e = 
/* 319 */       createGraphEdgeChangeEvent(23, edge);
/*     */     
/* 321 */     for (int i = 0; i < this.graphListeners.size(); i++) {
/* 322 */       GraphListener<V, E> l = (GraphListener)this.graphListeners.get(i);
/*     */       
/* 324 */       l.edgeAdded(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void fireEdgeRemoved(E edge)
/*     */   {
/* 335 */     GraphEdgeChangeEvent<V, E> e = 
/* 336 */       createGraphEdgeChangeEvent(
/* 337 */       24, 
/* 338 */       edge);
/*     */     
/* 340 */     for (int i = 0; i < this.graphListeners.size(); i++) {
/* 341 */       GraphListener<V, E> l = (GraphListener)this.graphListeners.get(i);
/*     */       
/* 343 */       l.edgeRemoved(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void fireVertexAdded(V vertex)
/*     */   {
/* 354 */     GraphVertexChangeEvent<V> e = 
/* 355 */       createGraphVertexChangeEvent(
/* 356 */       13, 
/* 357 */       vertex);
/*     */     
/* 359 */     for (int i = 0; i < this.vertexSetListeners.size(); i++) {
/* 360 */       VertexSetListener<V> l = (VertexSetListener)this.vertexSetListeners.get(i);
/*     */       
/* 362 */       l.vertexAdded(e);
/*     */     }
/*     */     
/* 365 */     for (int i = 0; i < this.graphListeners.size(); i++) {
/* 366 */       GraphListener<V, E> l = (GraphListener)this.graphListeners.get(i);
/*     */       
/* 368 */       l.vertexAdded(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void fireVertexRemoved(V vertex)
/*     */   {
/* 379 */     GraphVertexChangeEvent<V> e = 
/* 380 */       createGraphVertexChangeEvent(
/* 381 */       14, 
/* 382 */       vertex);
/*     */     
/* 384 */     for (int i = 0; i < this.vertexSetListeners.size(); i++) {
/* 385 */       VertexSetListener<V> l = (VertexSetListener)this.vertexSetListeners.get(i);
/*     */       
/* 387 */       l.vertexRemoved(e);
/*     */     }
/*     */     
/* 390 */     for (int i = 0; i < this.graphListeners.size(); i++) {
/* 391 */       GraphListener<V, E> l = (GraphListener)this.graphListeners.get(i);
/*     */       
/* 393 */       l.vertexRemoved(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static <L extends EventListener> void addToListenerList(List<L> list, L l)
/*     */   {
/* 401 */     if (!list.contains(l)) {
/* 402 */       list.add(l);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private GraphEdgeChangeEvent<V, E> createGraphEdgeChangeEvent(int eventType, E edge)
/*     */   {
/* 410 */     if (this.reuseEvents) {
/* 411 */       this.reuseableEdgeEvent.setType(eventType);
/* 412 */       this.reuseableEdgeEvent.setEdge(edge);
/*     */       
/* 414 */       return this.reuseableEdgeEvent;
/*     */     }
/* 416 */     return new GraphEdgeChangeEvent(this, eventType, edge);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private GraphVertexChangeEvent<V> createGraphVertexChangeEvent(int eventType, V vertex)
/*     */   {
/* 424 */     if (this.reuseEvents) {
/* 425 */       this.reuseableVertexEvent.setType(eventType);
/* 426 */       this.reuseableVertexEvent.setVertex(vertex);
/*     */       
/* 428 */       return this.reuseableVertexEvent;
/*     */     }
/* 430 */     return new GraphVertexChangeEvent(this, eventType, vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class FlyweightEdgeEvent<VV, EE>
/*     */     extends GraphEdgeChangeEvent<VV, EE>
/*     */   {
/*     */     private static final long serialVersionUID = 3907207152526636089L;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public FlyweightEdgeEvent(Object eventSource, int type, EE e)
/*     */     {
/* 452 */       super(type, e);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     protected void setEdge(EE e)
/*     */     {
/* 462 */       this.edge = e;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     protected void setType(int type)
/*     */     {
/* 472 */       this.type = type;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class FlyweightVertexEvent<VV>
/*     */     extends GraphVertexChangeEvent<VV>
/*     */   {
/*     */     private static final long serialVersionUID = 3257848787857585716L;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public FlyweightVertexEvent(Object eventSource, int type, VV vertex)
/*     */     {
/* 493 */       super(type, vertex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     protected void setType(int type)
/*     */     {
/* 503 */       this.type = type;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     protected void setVertex(VV vertex)
/*     */     {
/* 513 */       this.vertex = vertex;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\DefaultListenableGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */