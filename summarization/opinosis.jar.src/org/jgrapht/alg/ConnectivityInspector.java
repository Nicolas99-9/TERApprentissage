/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.UndirectedGraph;
/*     */ import org.jgrapht.event.ConnectedComponentTraversalEvent;
/*     */ import org.jgrapht.event.GraphEdgeChangeEvent;
/*     */ import org.jgrapht.event.GraphListener;
/*     */ import org.jgrapht.event.GraphVertexChangeEvent;
/*     */ import org.jgrapht.event.TraversalListenerAdapter;
/*     */ import org.jgrapht.event.VertexTraversalEvent;
/*     */ import org.jgrapht.graph.AsUndirectedGraph;
/*     */ import org.jgrapht.traverse.BreadthFirstIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ConnectivityInspector<V, E>
/*     */   implements GraphListener<V, E>
/*     */ {
/*     */   List<Set<V>> connectedSets;
/*     */   Map<V, Set<V>> vertexToConnectedSet;
/*     */   private Graph<V, E> graph;
/*     */   
/*     */   public ConnectivityInspector(UndirectedGraph<V, E> g)
/*     */   {
/*  94 */     init();
/*  95 */     this.graph = g;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public ConnectivityInspector(DirectedGraph<V, E> g)
/*     */   {
/* 105 */     init();
/* 106 */     this.graph = new AsUndirectedGraph(g);
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
/*     */   public boolean isGraphConnected()
/*     */   {
/* 119 */     return lazyFindConnectedSets().size() == 1;
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
/*     */   public Set<V> connectedSetOf(V vertex)
/*     */   {
/* 136 */     Set<V> connectedSet = (Set)this.vertexToConnectedSet.get(vertex);
/*     */     
/* 138 */     if (connectedSet == null) {
/* 139 */       connectedSet = new HashSet();
/*     */       
/* 141 */       BreadthFirstIterator<V, E> i = 
/* 142 */         new BreadthFirstIterator(this.graph, vertex);
/*     */       
/* 144 */       while (i.hasNext()) {
/* 145 */         connectedSet.add(i.next());
/*     */       }
/*     */       
/* 148 */       this.vertexToConnectedSet.put(vertex, connectedSet);
/*     */     }
/*     */     
/* 151 */     return connectedSet;
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
/*     */   public List<Set<V>> connectedSets()
/*     */   {
/* 167 */     return lazyFindConnectedSets();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void edgeAdded(GraphEdgeChangeEvent<V, E> e)
/*     */   {
/* 175 */     init();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void edgeRemoved(GraphEdgeChangeEvent<V, E> e)
/*     */   {
/* 184 */     init();
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
/*     */   public boolean pathExists(V sourceVertex, V targetVertex)
/*     */   {
/* 208 */     Set<V> sourceSet = connectedSetOf(sourceVertex);
/*     */     
/* 210 */     return sourceSet.contains(targetVertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void vertexAdded(GraphVertexChangeEvent<V> e)
/*     */   {
/* 218 */     init();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void vertexRemoved(GraphVertexChangeEvent<V> e)
/*     */   {
/* 227 */     init();
/*     */   }
/*     */   
/*     */ 
/*     */   private void init()
/*     */   {
/* 233 */     this.connectedSets = null;
/* 234 */     this.vertexToConnectedSet = new HashMap();
/*     */   }
/*     */   
/*     */   private List<Set<V>> lazyFindConnectedSets()
/*     */   {
/* 239 */     if (this.connectedSets == null) {
/* 240 */       this.connectedSets = new ArrayList();
/*     */       
/* 242 */       Set<V> vertexSet = this.graph.vertexSet();
/*     */       
/* 244 */       if (vertexSet.size() > 0) {
/* 245 */         BreadthFirstIterator<V, E> i = 
/* 246 */           new BreadthFirstIterator(this.graph, null);
/* 247 */         i.addTraversalListener(new MyTraversalListener(null));
/*     */         
/* 249 */         while (i.hasNext()) {
/* 250 */           i.next();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 255 */     return this.connectedSets;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private class MyTraversalListener
/*     */     extends TraversalListenerAdapter<V, E>
/*     */   {
/*     */     private Set<V> currentConnectedSet;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private MyTraversalListener() {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void connectedComponentFinished(ConnectedComponentTraversalEvent e)
/*     */     {
/* 279 */       ConnectivityInspector.this.connectedSets.add(this.currentConnectedSet);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void connectedComponentStarted(ConnectedComponentTraversalEvent e)
/*     */     {
/* 289 */       this.currentConnectedSet = new HashSet();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void vertexTraversed(VertexTraversalEvent<V> e)
/*     */     {
/* 298 */       V v = e.getVertex();
/* 299 */       this.currentConnectedSet.add(v);
/* 300 */       ConnectivityInspector.this.vertexToConnectedSet.put(v, this.currentConnectedSet);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\ConnectivityInspector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */