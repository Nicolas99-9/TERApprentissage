/*     */ package org.jgrapht.traverse;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.jgrapht.event.ConnectedComponentTraversalEvent;
/*     */ import org.jgrapht.event.EdgeTraversalEvent;
/*     */ import org.jgrapht.event.TraversalListener;
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
/*     */ public abstract class AbstractGraphIterator<V, E>
/*     */   implements GraphIterator<V, E>
/*     */ {
/*  62 */   private List<TraversalListener<V, E>> traversalListeners = new ArrayList();
/*  63 */   private boolean crossComponentTraversal = true;
/*  64 */   private boolean reuseEvents = false;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  69 */   protected int nListeners = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setCrossComponentTraversal(boolean crossComponentTraversal)
/*     */   {
/*  82 */     this.crossComponentTraversal = crossComponentTraversal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isCrossComponentTraversal()
/*     */   {
/*  94 */     return this.crossComponentTraversal;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setReuseEvents(boolean reuseEvents)
/*     */   {
/* 102 */     this.reuseEvents = reuseEvents;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isReuseEvents()
/*     */   {
/* 110 */     return this.reuseEvents;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addTraversalListener(TraversalListener<V, E> l)
/*     */   {
/* 120 */     if (!this.traversalListeners.contains(l)) {
/* 121 */       this.traversalListeners.add(l);
/* 122 */       this.nListeners = this.traversalListeners.size();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void remove()
/*     */   {
/* 133 */     throw new UnsupportedOperationException();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void removeTraversalListener(TraversalListener<V, E> l)
/*     */   {
/* 143 */     this.traversalListeners.remove(l);
/* 144 */     this.nListeners = this.traversalListeners.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void fireConnectedComponentFinished(ConnectedComponentTraversalEvent e)
/*     */   {
/* 156 */     for (int i = 0; i < this.nListeners; i++) {
/* 157 */       TraversalListener<V, E> l = (TraversalListener)this.traversalListeners.get(i);
/* 158 */       l.connectedComponentFinished(e);
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
/*     */   protected void fireConnectedComponentStarted(ConnectedComponentTraversalEvent e)
/*     */   {
/* 171 */     for (int i = 0; i < this.nListeners; i++) {
/* 172 */       TraversalListener<V, E> l = (TraversalListener)this.traversalListeners.get(i);
/* 173 */       l.connectedComponentStarted(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void fireEdgeTraversed(EdgeTraversalEvent<V, E> e)
/*     */   {
/* 184 */     for (int i = 0; i < this.nListeners; i++) {
/* 185 */       TraversalListener<V, E> l = (TraversalListener)this.traversalListeners.get(i);
/* 186 */       l.edgeTraversed(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void fireVertexTraversed(VertexTraversalEvent<V> e)
/*     */   {
/* 197 */     for (int i = 0; i < this.nListeners; i++) {
/* 198 */       TraversalListener<V, E> l = (TraversalListener)this.traversalListeners.get(i);
/* 199 */       l.vertexTraversed(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void fireVertexFinished(VertexTraversalEvent<V> e)
/*     */   {
/* 210 */     for (int i = 0; i < this.nListeners; i++) {
/* 211 */       TraversalListener<V, E> l = (TraversalListener)this.traversalListeners.get(i);
/* 212 */       l.vertexFinished(e);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\traverse\AbstractGraphIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */