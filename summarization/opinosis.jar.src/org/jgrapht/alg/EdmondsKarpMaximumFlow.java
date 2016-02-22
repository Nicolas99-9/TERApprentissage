/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Queue;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EdmondsKarpMaximumFlow<V, E>
/*     */ {
/*     */   public static final double DEFAULT_EPSILON = 1.0E-9D;
/*     */   private DirectedGraph<V, E> network;
/*     */   private double epsilon;
/*     */   private int currentSource;
/*     */   private int currentSink;
/*     */   private Map<E, Double> maximumFlow;
/*     */   private Double maximumFlowValue;
/*     */   private int numNodes;
/*     */   private Map<V, Integer> indexer;
/*     */   private List<EdmondsKarpMaximumFlow<V, E>.Node> nodes;
/*     */   
/*     */   public EdmondsKarpMaximumFlow(DirectedGraph<V, E> network)
/*     */   {
/*  98 */     this(network, 1.0E-9D);
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
/*     */   public EdmondsKarpMaximumFlow(DirectedGraph<V, E> network, double epsilon)
/*     */   {
/* 113 */     if (network == null) {
/* 114 */       throw new NullPointerException("network is null");
/*     */     }
/* 116 */     if (epsilon <= 0.0D) {
/* 117 */       throw new IllegalArgumentException(
/* 118 */         "invalid epsilon (must be positive)");
/*     */     }
/* 120 */     for (E e : network.edgeSet()) {
/* 121 */       if (network.getEdgeWeight(e) < -epsilon) {
/* 122 */         throw new IllegalArgumentException(
/* 123 */           "invalid capacity (must be non-negative)");
/*     */       }
/*     */     }
/*     */     
/* 127 */     this.network = network;
/* 128 */     this.epsilon = epsilon;
/*     */     
/* 130 */     this.currentSource = -1;
/* 131 */     this.currentSink = -1;
/* 132 */     this.maximumFlow = null;
/* 133 */     this.maximumFlowValue = null;
/*     */     
/* 135 */     buildInternalNetwork();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void buildInternalNetwork()
/*     */   {
/* 143 */     this.numNodes = this.network.vertexSet().size();
/* 144 */     this.nodes = new ArrayList();
/* 145 */     Iterator<V> it = this.network.vertexSet().iterator();
/* 146 */     this.indexer = new HashMap();
/* 147 */     for (int i = 0; i < this.numNodes; i++) {
/* 148 */       V currentNode = it.next();
/* 149 */       this.nodes.add(new Node(currentNode));
/* 150 */       this.indexer.put(currentNode, Integer.valueOf(i));
/*     */     }
/* 152 */     for (int i = 0; i < this.numNodes; i++) {
/* 153 */       V we = ((Node)this.nodes.get(i)).prototype;
/* 154 */       for (E e : this.network.outgoingEdgesOf(we)) {
/* 155 */         V he = this.network.getEdgeTarget(e);
/* 156 */         int j = ((Integer)this.indexer.get(he)).intValue();
/* 157 */         EdmondsKarpMaximumFlow<V, E>.Arc e1 = new Arc(i, j, this.network.getEdgeWeight(e), e);
/* 158 */         EdmondsKarpMaximumFlow<V, E>.Arc e2 = new Arc(j, i, 0.0D, null);
/* 159 */         e1.reversed = e2;
/* 160 */         e2.reversed = e1;
/* 161 */         ((Node)this.nodes.get(i)).outgoingArcs.add(e1);
/* 162 */         ((Node)this.nodes.get(j)).outgoingArcs.add(e2);
/*     */       }
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
/*     */   public void calculateMaximumFlow(V source, V sink)
/*     */   {
/* 180 */     if (!this.network.containsVertex(source)) {
/* 181 */       throw new IllegalArgumentException(
/* 182 */         "invalid source (null or not from this network)");
/*     */     }
/* 184 */     if (!this.network.containsVertex(sink)) {
/* 185 */       throw new IllegalArgumentException(
/* 186 */         "invalid sink (null or not from this network)");
/*     */     }
/*     */     
/* 189 */     if (source.equals(sink)) {
/* 190 */       throw new IllegalArgumentException("source is equal to sink");
/*     */     }
/*     */     
/* 193 */     this.currentSource = ((Integer)this.indexer.get(source)).intValue();
/* 194 */     this.currentSink = ((Integer)this.indexer.get(sink)).intValue();
/*     */     
/* 196 */     for (int i = 0; i < this.numNodes; i++) {
/* 197 */       for (EdmondsKarpMaximumFlow<V, E>.Arc currentArc : ((Node)this.nodes.get(i)).outgoingArcs) {
/* 198 */         currentArc.flow = 0.0D;
/*     */       }
/*     */     }
/* 201 */     this.maximumFlowValue = Double.valueOf(0.0D);
/*     */     for (;;) {
/* 203 */       breadthFirstSearch();
/* 204 */       if (!((Node)this.nodes.get(this.currentSink)).visited) {
/* 205 */         this.maximumFlow = new HashMap();
/* 206 */         for (int i = 0; i < this.numNodes; i++) {
/* 207 */           for (EdmondsKarpMaximumFlow<V, E>.Arc currentArc : ((Node)this.nodes.get(i)).outgoingArcs) {
/* 208 */             if (currentArc.prototype != null) {
/* 209 */               this.maximumFlow.put(
/* 210 */                 currentArc.prototype, 
/* 211 */                 Double.valueOf(currentArc.flow));
/*     */             }
/*     */           }
/*     */         }
/* 215 */         return;
/*     */       }
/* 217 */       augmentFlow();
/*     */     }
/*     */   }
/*     */   
/*     */   private void breadthFirstSearch()
/*     */   {
/* 223 */     for (int i = 0; i < this.numNodes; i++) {
/* 224 */       ((Node)this.nodes.get(i)).visited = false;
/*     */     }
/* 226 */     Queue<Integer> queue = new LinkedList();
/* 227 */     queue.offer(Integer.valueOf(this.currentSource));
/* 228 */     ((Node)this.nodes.get(this.currentSource)).visited = true;
/* 229 */     ((Node)this.nodes.get(this.currentSource)).flowAmount = Double.POSITIVE_INFINITY;
/* 230 */     Iterator localIterator; for (; queue.size() != 0; 
/*     */         
/* 232 */         localIterator.hasNext())
/*     */     {
/* 231 */       int currentNode = ((Integer)queue.poll()).intValue();
/* 232 */       localIterator = ((Node)this.nodes.get(currentNode)).outgoingArcs.iterator(); continue;EdmondsKarpMaximumFlow<V, E>.Arc currentArc = (Arc)localIterator.next();
/* 233 */       if ((currentArc.flow + this.epsilon < currentArc.capacity) && 
/* 234 */         (!((Node)this.nodes.get(currentArc.head)).visited)) {
/* 235 */         ((Node)this.nodes.get(currentArc.head)).visited = true;
/* 236 */         ((Node)this.nodes.get(currentArc.head)).flowAmount = 
/* 237 */           Math.min(
/* 238 */           ((Node)this.nodes.get(currentNode)).flowAmount, 
/* 239 */           currentArc.capacity - currentArc.flow);
/* 240 */         ((Node)this.nodes.get(currentArc.head)).lastArc = currentArc;
/* 241 */         queue.add(Integer.valueOf(currentArc.head));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void augmentFlow()
/*     */   {
/* 250 */     double deltaFlow = ((Node)this.nodes.get(this.currentSink)).flowAmount;
/* 251 */     this.maximumFlowValue = Double.valueOf(this.maximumFlowValue.doubleValue() + deltaFlow);
/* 252 */     int currentNode = this.currentSink;
/* 253 */     while (currentNode != this.currentSource) {
/* 254 */       ((Node)this.nodes.get(currentNode)).lastArc.flow += deltaFlow;
/* 255 */       ((Node)this.nodes.get(currentNode)).lastArc.reversed.flow -= deltaFlow;
/* 256 */       currentNode = ((Node)this.nodes.get(currentNode)).lastArc.tail;
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
/*     */   public Double getMaximumFlowValue()
/*     */   {
/* 269 */     return this.maximumFlowValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<E, Double> getMaximumFlow()
/*     */   {
/* 281 */     if (this.maximumFlow == null) {
/* 282 */       return null;
/*     */     }
/* 284 */     return Collections.unmodifiableMap(this.maximumFlow);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public V getCurrentSource()
/*     */   {
/* 295 */     if (this.currentSource == -1) {
/* 296 */       return null;
/*     */     }
/* 298 */     return (V)((Node)this.nodes.get(this.currentSource)).prototype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public V getCurrentSink()
/*     */   {
/* 309 */     if (this.currentSink == -1) {
/* 310 */       return null;
/*     */     }
/* 312 */     return (V)((Node)this.nodes.get(this.currentSink)).prototype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   class Node
/*     */   {
/*     */     V prototype;
/*     */     
/* 321 */     List<EdmondsKarpMaximumFlow<V, E>.Arc> outgoingArcs = new ArrayList();
/*     */     
/*     */     boolean visited;
/*     */     
/*     */     EdmondsKarpMaximumFlow<V, E>.Arc lastArc;
/*     */     
/*     */     double flowAmount;
/*     */     
/*     */     Node()
/*     */     {
/* 331 */       this.prototype = prototype;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   class Arc
/*     */   {
/*     */     int tail;
/*     */     
/*     */     int head;
/*     */     
/*     */     double capacity;
/*     */     
/*     */     double flow;
/*     */     
/*     */     EdmondsKarpMaximumFlow<V, E>.Arc reversed;
/*     */     
/*     */     E prototype;
/*     */     
/*     */ 
/*     */     Arc(int tail, double head, E arg5)
/*     */     {
/* 353 */       this.tail = tail;
/* 354 */       this.head = head;
/* 355 */       this.capacity = capacity;
/* 356 */       this.prototype = prototype;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\EdmondsKarpMaximumFlow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */