/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Deque;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.Vector;
/*     */ import org.jgrapht.DirectedGraph;
/*     */ import org.jgrapht.graph.DirectedSubgraph;
/*     */ import org.jgrapht.graph.EdgeReversedGraph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StrongConnectivityInspector<V, E>
/*     */ {
/*     */   private final DirectedGraph<V, E> graph;
/*     */   private LinkedList<VertexData<V>> orderedVertices;
/*     */   private List<Set<V>> stronglyConnectedSets;
/*     */   private List<DirectedSubgraph<V, E>> stronglyConnectedSubgraphs;
/*     */   private Map<V, VertexData<V>> vertexToVertexData;
/*     */   
/*     */   public StrongConnectivityInspector(DirectedGraph<V, E> directedGraph)
/*     */   {
/*  94 */     if (directedGraph == null) {
/*  95 */       throw new IllegalArgumentException("null not allowed for graph!");
/*     */     }
/*     */     
/*  98 */     this.graph = directedGraph;
/*  99 */     this.vertexToVertexData = null;
/* 100 */     this.orderedVertices = null;
/* 101 */     this.stronglyConnectedSets = null;
/* 102 */     this.stronglyConnectedSubgraphs = null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DirectedGraph<V, E> getGraph()
/*     */   {
/* 114 */     return this.graph;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isStronglyConnected()
/*     */   {
/* 125 */     return stronglyConnectedSets().size() == 1;
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
/*     */   public List<Set<V>> stronglyConnectedSets()
/*     */   {
/* 138 */     if (this.stronglyConnectedSets == null) {
/* 139 */       this.orderedVertices = new LinkedList();
/* 140 */       this.stronglyConnectedSets = new Vector();
/*     */       
/*     */ 
/* 143 */       createVertexData();
/*     */       
/*     */ 
/*     */ 
/* 147 */       for (VertexData<V> data : this.vertexToVertexData.values()) {
/* 148 */         if (!data.isDiscovered()) {
/* 149 */           dfsVisit(this.graph, data, null);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 154 */       DirectedGraph<V, E> inverseGraph = 
/* 155 */         new EdgeReversedGraph(this.graph);
/*     */       
/*     */ 
/* 158 */       resetVertexData();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 163 */       for (Object data : this.orderedVertices) {
/* 164 */         if (!((VertexData)data).isDiscovered())
/*     */         {
/* 166 */           Set<V> set = new HashSet();
/* 167 */           this.stronglyConnectedSets.add(set);
/* 168 */           dfsVisit(inverseGraph, (VertexData)data, set);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 173 */       this.orderedVertices = null;
/* 174 */       this.vertexToVertexData = null;
/*     */     }
/*     */     
/* 177 */     return this.stronglyConnectedSets;
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
/*     */   public List<DirectedSubgraph<V, E>> stronglyConnectedSubgraphs()
/*     */   {
/* 195 */     if (this.stronglyConnectedSubgraphs == null) {
/* 196 */       List<Set<V>> sets = stronglyConnectedSets();
/* 197 */       this.stronglyConnectedSubgraphs = 
/* 198 */         new Vector(sets.size());
/*     */       
/* 200 */       for (Set<V> set : sets) {
/* 201 */         this.stronglyConnectedSubgraphs.add(
/* 202 */           new DirectedSubgraph(
/* 203 */           this.graph, 
/* 204 */           set, 
/* 205 */           null));
/*     */       }
/*     */     }
/*     */     
/* 209 */     return this.stronglyConnectedSubgraphs;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void createVertexData()
/*     */   {
/* 219 */     this.vertexToVertexData = 
/* 220 */       new HashMap(this.graph.vertexSet().size());
/*     */     
/* 222 */     for (V vertex : this.graph.vertexSet()) {
/* 223 */       this.vertexToVertexData.put(
/* 224 */         vertex, 
/* 225 */         new VertexData2(vertex, false, false, null));
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
/*     */   private void dfsVisit(DirectedGraph<V, E> visitedGraph, VertexData<V> vertexData, Set<V> vertices)
/*     */   {
/* 240 */     Deque<VertexData<V>> stack = new ArrayDeque();
/* 241 */     stack.add(vertexData);
/*     */     
/* 243 */     while (!stack.isEmpty()) {
/* 244 */       VertexData<V> data = (VertexData)stack.removeLast();
/*     */       
/* 246 */       if (!data.isDiscovered()) {
/* 247 */         data.setDiscovered(true);
/*     */         
/* 249 */         if (vertices != null) {
/* 250 */           vertices.add(data.getVertex());
/*     */         }
/*     */         
/* 253 */         stack.add(new VertexData1(data, true, true, null));
/*     */         
/*     */ 
/* 256 */         for (E edge : visitedGraph.outgoingEdgesOf(data.getVertex())) {
/* 257 */           VertexData<V> targetData = 
/* 258 */             (VertexData)this.vertexToVertexData.get(
/* 259 */             visitedGraph.getEdgeTarget(edge));
/*     */           
/* 261 */           if (!targetData.isDiscovered())
/*     */           {
/* 263 */             stack.add(targetData);
/*     */           }
/*     */         }
/* 266 */       } else if ((data.isFinished()) && 
/* 267 */         (vertices == null)) {
/* 268 */         this.orderedVertices.addFirst(data.getFinishedData());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void resetVertexData()
/*     */   {
/* 279 */     for (VertexData<V> data : this.vertexToVertexData.values()) {
/* 280 */       data.setDiscovered(false);
/* 281 */       data.setFinished(false);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static abstract class VertexData<V>
/*     */   {
/*     */     private byte bitfield;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private VertexData(boolean discovered, boolean finished)
/*     */     {
/* 298 */       this.bitfield = 0;
/* 299 */       setDiscovered(discovered);
/* 300 */       setFinished(finished);
/*     */     }
/*     */     
/*     */     private boolean isDiscovered()
/*     */     {
/* 305 */       if ((this.bitfield & 0x1) == 1) {
/* 306 */         return true;
/*     */       }
/* 308 */       return false;
/*     */     }
/*     */     
/*     */     private boolean isFinished()
/*     */     {
/* 313 */       if ((this.bitfield & 0x2) == 2) {
/* 314 */         return true;
/*     */       }
/* 316 */       return false;
/*     */     }
/*     */     
/*     */     private void setDiscovered(boolean discovered)
/*     */     {
/* 321 */       if (discovered) {
/* 322 */         this.bitfield = ((byte)(this.bitfield | 0x1));
/*     */       } else {
/* 324 */         this.bitfield = ((byte)(this.bitfield & 0xFFFFFFFE));
/*     */       }
/*     */     }
/*     */     
/*     */     private void setFinished(boolean finished)
/*     */     {
/* 330 */       if (finished) {
/* 331 */         this.bitfield = ((byte)(this.bitfield | 0x2));
/*     */       } else {
/* 333 */         this.bitfield = ((byte)(this.bitfield & 0xFFFFFFFD));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     abstract VertexData<V> getFinishedData();
/*     */     
/*     */ 
/*     */     abstract V getVertex();
/*     */   }
/*     */   
/*     */ 
/*     */   private static final class VertexData1<V>
/*     */     extends StrongConnectivityInspector.VertexData<V>
/*     */   {
/*     */     private final StrongConnectivityInspector.VertexData<V> finishedData;
/*     */     
/*     */     private VertexData1(StrongConnectivityInspector.VertexData<V> finishedData, boolean discovered, boolean finished)
/*     */     {
/* 352 */       super(finished, null);
/* 353 */       this.finishedData = finishedData;
/*     */     }
/*     */     
/*     */ 
/*     */     StrongConnectivityInspector.VertexData<V> getFinishedData()
/*     */     {
/* 359 */       return this.finishedData;
/*     */     }
/*     */     
/*     */ 
/*     */     V getVertex()
/*     */     {
/* 365 */       return null;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static final class VertexData2<V>
/*     */     extends StrongConnectivityInspector.VertexData<V>
/*     */   {
/*     */     private final V vertex;
/*     */     
/*     */ 
/*     */     private VertexData2(V vertex, boolean discovered, boolean finished)
/*     */     {
/* 379 */       super(finished, null);
/* 380 */       this.vertex = vertex;
/*     */     }
/*     */     
/*     */ 
/*     */     StrongConnectivityInspector.VertexData<V> getFinishedData()
/*     */     {
/* 386 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     V getVertex()
/*     */     {
/* 392 */       return (V)this.vertex;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\StrongConnectivityInspector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */