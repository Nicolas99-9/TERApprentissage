/*      */ package org.jgrapht.experimental.dag;
/*      */ 
/*      */ import java.io.Serializable;
/*      */ import java.util.ArrayList;
/*      */ import java.util.BitSet;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.ConcurrentModificationException;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.NoSuchElementException;
/*      */ import java.util.Set;
/*      */ import java.util.SortedSet;
/*      */ import java.util.TreeSet;
/*      */ import org.jgrapht.graph.SimpleDirectedGraph;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class DirectedAcyclicGraph<V, E>
/*      */   extends SimpleDirectedGraph<V, E>
/*      */ {
/*      */   private static final long serialVersionUID = 4522128427004938150L;
/*      */   private TopoComparator<V> topoComparator;
/*      */   private TopoOrderMapping<V> topoOrderMap;
/*   88 */   private int maxTopoIndex = 0;
/*   89 */   private int minTopoIndex = 0;
/*      */   
/*      */ 
/*   92 */   private long topologyUpdateCount = 0L;
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*   97 */   private VisitedFactory visitedFactory = new VisitedBitSetImpl();
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*  102 */   private TopoOrderMappingFactory<V> topoOrderFactory = new TopoVertexBiMap(null);
/*      */   
/*      */ 
/*      */ 
/*      */   public DirectedAcyclicGraph(Class<? extends E> arg0)
/*      */   {
/*  108 */     super(arg0);
/*  109 */     initialize();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   DirectedAcyclicGraph(Class<? extends E> arg0, VisitedFactory visitedFactory, TopoOrderMappingFactory<V> topoOrderFactory)
/*      */   {
/*  117 */     super(arg0);
/*  118 */     if (visitedFactory != null) {
/*  119 */       this.visitedFactory = visitedFactory;
/*      */     }
/*  121 */     if (topoOrderFactory != null) {
/*  122 */       this.topoOrderFactory = topoOrderFactory;
/*      */     }
/*  124 */     initialize();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void initialize()
/*      */   {
/*  135 */     this.topoOrderMap = this.topoOrderFactory.getTopoOrderMapping();
/*  136 */     this.topoComparator = new TopoComparator(this.topoOrderMap);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Iterator<V> iterator()
/*      */   {
/*  149 */     return new TopoIterator();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean addVertex(V v)
/*      */   {
/*  158 */     boolean added = super.addVertex(v);
/*      */     
/*  160 */     if (added)
/*      */     {
/*  162 */       this.maxTopoIndex += 1;
/*  163 */       this.topoOrderMap.putVertex(Integer.valueOf(this.maxTopoIndex), v);
/*      */       
/*  165 */       this.topologyUpdateCount += 1L;
/*      */     }
/*      */     
/*  168 */     return added;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean addVertex(V v, boolean addToTop)
/*      */   {
/*  184 */     boolean added = super.addVertex(v);
/*      */     
/*  186 */     if (added)
/*      */     {
/*      */       int insertIndex;
/*      */       int insertIndex;
/*  190 */       if (addToTop) {
/*  191 */         insertIndex = ++this.maxTopoIndex;
/*      */       } else {
/*  193 */         insertIndex = --this.minTopoIndex;
/*      */       }
/*  195 */       this.topoOrderMap.putVertex(Integer.valueOf(insertIndex), v);
/*      */       
/*  197 */       this.topologyUpdateCount += 1L;
/*      */     }
/*  199 */     return added;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public E addDagEdge(V fromVertex, V toVertex)
/*      */     throws DirectedAcyclicGraph.CycleFoundException
/*      */   {
/*  224 */     Integer lb = this.topoOrderMap.getTopologicalIndex(toVertex);
/*  225 */     Integer ub = this.topoOrderMap.getTopologicalIndex(fromVertex);
/*      */     
/*  227 */     if ((lb == null) || (ub == null)) {
/*  228 */       throw new IllegalArgumentException(
/*  229 */         "vertices must be in the graph already!");
/*      */     }
/*      */     
/*  232 */     if (lb.intValue() < ub.intValue()) {
/*  233 */       Set<V> df = new HashSet();
/*  234 */       Set<V> db = new HashSet();
/*      */       
/*      */ 
/*  237 */       Region affectedRegion = new Region(lb.intValue(), ub.intValue());
/*  238 */       Visited visited = this.visitedFactory.getInstance(affectedRegion);
/*      */       
/*      */ 
/*  241 */       dfsF(toVertex, df, visited, affectedRegion);
/*      */       
/*  243 */       dfsB(fromVertex, db, visited, affectedRegion);
/*  244 */       reorder(df, db, visited);
/*  245 */       this.topologyUpdateCount += 1L;
/*      */     }
/*      */     
/*      */ 
/*  249 */     return (E)super.addEdge(fromVertex, toVertex);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public E addEdge(V sourceVertex, V targetVertex)
/*      */   {
/*  259 */     E result = null;
/*      */     try {
/*  261 */       result = addDagEdge(sourceVertex, targetVertex);
/*      */     } catch (CycleFoundException e) {
/*  263 */       throw new IllegalArgumentException(e);
/*      */     }
/*  265 */     return result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean addDagEdge(V fromVertex, V toVertex, E e)
/*      */     throws DirectedAcyclicGraph.CycleFoundException
/*      */   {
/*  289 */     if (e == null)
/*  290 */       throw new NullPointerException();
/*  291 */     if (containsEdge(e)) {
/*  292 */       return false;
/*      */     }
/*      */     
/*  295 */     Integer lb = this.topoOrderMap.getTopologicalIndex(toVertex);
/*  296 */     Integer ub = this.topoOrderMap.getTopologicalIndex(fromVertex);
/*      */     
/*  298 */     if ((lb == null) || (ub == null)) {
/*  299 */       throw new IllegalArgumentException(
/*  300 */         "vertices must be in the graph already!");
/*      */     }
/*      */     
/*  303 */     if (lb.intValue() < ub.intValue()) {
/*  304 */       Set<V> df = new HashSet();
/*  305 */       Set<V> db = new HashSet();
/*      */       
/*      */ 
/*  308 */       Region affectedRegion = new Region(lb.intValue(), ub.intValue());
/*  309 */       Visited visited = this.visitedFactory.getInstance(affectedRegion);
/*      */       
/*      */ 
/*  312 */       dfsF(toVertex, df, visited, affectedRegion);
/*      */       
/*  314 */       dfsB(fromVertex, db, visited, affectedRegion);
/*  315 */       reorder(df, db, visited);
/*  316 */       this.topologyUpdateCount += 1L;
/*      */     }
/*      */     
/*      */ 
/*  320 */     return super.addEdge(fromVertex, toVertex, e);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean addEdge(V sourceVertex, V targetVertex, E edge)
/*      */   {
/*      */     try
/*      */     {
/*  332 */       result = addDagEdge(sourceVertex, targetVertex, edge);
/*      */     } catch (CycleFoundException e) { boolean result;
/*  334 */       throw new IllegalArgumentException(e); }
/*      */     boolean result;
/*  336 */     return result;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean removeVertex(V v)
/*      */   {
/*  344 */     boolean removed = super.removeVertex(v);
/*      */     
/*  346 */     if (removed) {
/*  347 */       Integer topoIndex = this.topoOrderMap.removeVertex(v);
/*      */       
/*      */ 
/*  350 */       if (topoIndex.intValue() == this.minTopoIndex)
/*      */       {
/*  352 */         while ((this.minTopoIndex < 0) && 
/*  353 */           (this.topoOrderMap.getVertex(Integer.valueOf(this.minTopoIndex)) == null))
/*      */         {
/*  355 */           this.minTopoIndex += 1;
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*  360 */       if (topoIndex.intValue() == this.maxTopoIndex)
/*      */       {
/*  362 */         while ((this.maxTopoIndex > 0) && 
/*  363 */           (this.topoOrderMap.getVertex(Integer.valueOf(this.maxTopoIndex)) == null))
/*      */         {
/*  365 */           this.maxTopoIndex -= 1;
/*      */         }
/*      */       }
/*      */       
/*  369 */       this.topologyUpdateCount += 1L;
/*      */     }
/*      */     
/*  372 */     return removed;
/*      */   }
/*      */   
/*      */   public boolean removeAllVertices(Collection<? extends V> arg0)
/*      */   {
/*  377 */     boolean removed = super.removeAllVertices(arg0);
/*      */     
/*  379 */     this.topoOrderMap.removeAllVertices();
/*      */     
/*  381 */     this.maxTopoIndex = 0;
/*  382 */     this.minTopoIndex = 0;
/*      */     
/*  384 */     this.topologyUpdateCount += 1L;
/*      */     
/*  386 */     return removed;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void dfsF(V vertex, Set<V> df, Visited visited, Region affectedRegion)
/*      */     throws DirectedAcyclicGraph.CycleFoundException
/*      */   {
/*  412 */     int topoIndex = this.topoOrderMap.getTopologicalIndex(vertex).intValue();
/*      */     
/*      */ 
/*  415 */     visited.setVisited(topoIndex);
/*      */     
/*  417 */     df.add(vertex);
/*      */     
/*  419 */     for (E outEdge : outgoingEdgesOf(vertex)) {
/*  420 */       V nextVertex = getEdgeTarget(outEdge);
/*  421 */       Integer nextVertexTopoIndex = 
/*  422 */         this.topoOrderMap.getTopologicalIndex(nextVertex);
/*      */       
/*  424 */       if (nextVertexTopoIndex.intValue() == affectedRegion.finish)
/*      */       {
/*      */         try {
/*  427 */           for (V visitedVertex : df) {
/*  428 */             visited.clearVisited(
/*  429 */               this.topoOrderMap.getTopologicalIndex(visitedVertex).intValue());
/*      */           }
/*      */         }
/*      */         catch (UnsupportedOperationException localUnsupportedOperationException) {}
/*      */         
/*      */ 
/*  435 */         throw new CycleFoundException();
/*      */       }
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  442 */       if ((affectedRegion.isIn(nextVertexTopoIndex.intValue())) && 
/*  443 */         (!visited.getVisited(nextVertexTopoIndex.intValue())))
/*      */       {
/*  445 */         dfsF(nextVertex, df, visited, affectedRegion);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void dfsB(V vertex, Set<V> db, Visited visited, Region affectedRegion)
/*      */   {
/*  468 */     int topoIndex = this.topoOrderMap.getTopologicalIndex(vertex).intValue();
/*  469 */     visited.setVisited(topoIndex);
/*      */     
/*  471 */     db.add(vertex);
/*      */     
/*  473 */     for (E inEdge : incomingEdgesOf(vertex)) {
/*  474 */       V previousVertex = getEdgeSource(inEdge);
/*  475 */       Integer previousVertexTopoIndex = 
/*  476 */         this.topoOrderMap.getTopologicalIndex(previousVertex);
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  482 */       if ((affectedRegion.isIn(previousVertexTopoIndex.intValue())) && 
/*  483 */         (!visited.getVisited(previousVertexTopoIndex.intValue())))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/*  488 */         dfsB(previousVertex, db, visited, affectedRegion);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void reorder(Set<V> df, Set<V> db, Visited visited)
/*      */   {
/*  496 */     List<V> topoDf = new ArrayList(df);
/*  497 */     List<V> topoDb = new ArrayList(db);
/*      */     
/*  499 */     Collections.sort(topoDf, this.topoComparator);
/*  500 */     Collections.sort(topoDb, this.topoComparator);
/*      */     
/*      */ 
/*      */ 
/*  504 */     SortedSet<Integer> availableTopoIndices = new TreeSet();
/*      */     
/*      */ 
/*      */ 
/*  508 */     Object[] bigL = new Object[df.size() + db.size()];
/*  509 */     int lIndex = 0;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  515 */     boolean clearVisited = true;
/*      */     
/*  517 */     for (V vertex : topoDb) {
/*  518 */       Integer topoIndex = this.topoOrderMap.getTopologicalIndex(vertex);
/*      */       
/*      */ 
/*  521 */       availableTopoIndices.add(topoIndex);
/*      */       
/*  523 */       bigL[(lIndex++)] = vertex;
/*      */       
/*  525 */       if (clearVisited) {
/*      */         try {
/*  527 */           visited.clearVisited(topoIndex.intValue());
/*      */         } catch (UnsupportedOperationException e) {
/*  529 */           clearVisited = false;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  534 */     for (V vertex : topoDf) {
/*  535 */       Integer topoIndex = this.topoOrderMap.getTopologicalIndex(vertex);
/*      */       
/*      */ 
/*  538 */       availableTopoIndices.add(topoIndex);
/*  539 */       bigL[(lIndex++)] = vertex;
/*      */       
/*  541 */       if (clearVisited) {
/*      */         try {
/*  543 */           visited.clearVisited(topoIndex.intValue());
/*      */         } catch (UnsupportedOperationException e) {
/*  545 */           clearVisited = false;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  550 */     lIndex = 0;
/*  551 */     for (Integer topoIndex : availableTopoIndices)
/*      */     {
/*  553 */       V vertex = bigL[(lIndex++)];
/*  554 */       this.topoOrderMap.putVertex(topoIndex, vertex);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static class TopoComparator<V>
/*      */     implements Comparator<V>, Serializable
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     private DirectedAcyclicGraph.TopoOrderMapping<V> topoOrderMap;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public TopoComparator(DirectedAcyclicGraph.TopoOrderMapping<V> topoOrderMap)
/*      */     {
/*  685 */       this.topoOrderMap = topoOrderMap;
/*      */     }
/*      */     
/*      */     public int compare(V o1, V o2)
/*      */     {
/*  690 */       return this.topoOrderMap.getTopologicalIndex(o1).compareTo(
/*  691 */         this.topoOrderMap.getTopologicalIndex(o2));
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private class TopoVertexBiMap
/*      */     implements DirectedAcyclicGraph.TopoOrderMapping<V>, DirectedAcyclicGraph.TopoOrderMappingFactory<V>
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  708 */     private final Map<Integer, V> topoToVertex = new HashMap();
/*  709 */     private final Map<V, Integer> vertexToTopo = new HashMap();
/*      */     
/*      */     private TopoVertexBiMap() {}
/*      */     
/*  713 */     public void putVertex(Integer index, V vertex) { this.topoToVertex.put(index, vertex);
/*  714 */       this.vertexToTopo.put(vertex, index);
/*      */     }
/*      */     
/*      */     public V getVertex(Integer index)
/*      */     {
/*  719 */       return (V)this.topoToVertex.get(index);
/*      */     }
/*      */     
/*      */     public Integer getTopologicalIndex(V vertex)
/*      */     {
/*  724 */       Integer topoIndex = (Integer)this.vertexToTopo.get(vertex);
/*  725 */       return topoIndex;
/*      */     }
/*      */     
/*      */     public Integer removeVertex(V vertex)
/*      */     {
/*  730 */       Integer topoIndex = (Integer)this.vertexToTopo.remove(vertex);
/*  731 */       if (topoIndex != null) {
/*  732 */         this.topoToVertex.remove(topoIndex);
/*      */       }
/*  734 */       return topoIndex;
/*      */     }
/*      */     
/*      */     public void removeAllVertices()
/*      */     {
/*  739 */       this.vertexToTopo.clear();
/*  740 */       this.topoToVertex.clear();
/*      */     }
/*      */     
/*      */     public DirectedAcyclicGraph.TopoOrderMapping<V> getTopoOrderMapping()
/*      */     {
/*  745 */       return this;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public class TopoVertexMap
/*      */     implements DirectedAcyclicGraph.TopoOrderMapping<V>, DirectedAcyclicGraph.TopoOrderMappingFactory<V>
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  763 */     private final List<V> topoToVertex = new ArrayList();
/*  764 */     private final Map<V, Integer> vertexToTopo = new HashMap();
/*      */     
/*      */     public TopoVertexMap() {}
/*      */     
/*  768 */     public void putVertex(Integer index, V vertex) { int translatedIndex = translateIndex(index.intValue());
/*      */       
/*      */ 
/*  771 */       while (translatedIndex + 1 > this.topoToVertex.size()) {
/*  772 */         this.topoToVertex.add(null);
/*      */       }
/*      */       
/*  775 */       this.topoToVertex.set(translatedIndex, vertex);
/*  776 */       this.vertexToTopo.put(vertex, index);
/*      */     }
/*      */     
/*      */     public V getVertex(Integer index)
/*      */     {
/*  781 */       return (V)this.topoToVertex.get(translateIndex(index.intValue()));
/*      */     }
/*      */     
/*      */     public Integer getTopologicalIndex(V vertex)
/*      */     {
/*  786 */       return (Integer)this.vertexToTopo.get(vertex);
/*      */     }
/*      */     
/*      */     public Integer removeVertex(V vertex)
/*      */     {
/*  791 */       Integer topoIndex = (Integer)this.vertexToTopo.remove(vertex);
/*  792 */       if (topoIndex != null) {
/*  793 */         this.topoToVertex.set(translateIndex(topoIndex.intValue()), null);
/*      */       }
/*  795 */       return topoIndex;
/*      */     }
/*      */     
/*      */     public void removeAllVertices()
/*      */     {
/*  800 */       this.vertexToTopo.clear();
/*  801 */       this.topoToVertex.clear();
/*      */     }
/*      */     
/*      */     public DirectedAcyclicGraph.TopoOrderMapping<V> getTopoOrderMapping()
/*      */     {
/*  806 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     private final int translateIndex(int index)
/*      */     {
/*  821 */       if (index >= 0) {
/*  822 */         return 2 * index;
/*      */       }
/*  824 */       return -1 * (index * 2 - 1);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static class Region
/*      */     implements Serializable
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */ 
/*      */     public final int start;
/*      */     
/*      */ 
/*      */     public final int finish;
/*      */     
/*      */ 
/*      */ 
/*      */     public Region(int start, int finish)
/*      */     {
/*  846 */       if (start > finish) {
/*  847 */         throw new IllegalArgumentException(
/*  848 */           "(start > finish): invariant broken");
/*      */       }
/*  850 */       this.start = start;
/*  851 */       this.finish = finish;
/*      */     }
/*      */     
/*      */     public int getSize()
/*      */     {
/*  856 */       return this.finish - this.start + 1;
/*      */     }
/*      */     
/*      */     public boolean isIn(int index)
/*      */     {
/*  861 */       return (index >= this.start) && (index <= this.finish);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static class VisitedBitSetImpl
/*      */     implements DirectedAcyclicGraph.Visited, DirectedAcyclicGraph.VisitedFactory
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  879 */     private final BitSet visited = new BitSet();
/*      */     
/*      */     private DirectedAcyclicGraph.Region affectedRegion;
/*      */     
/*      */     public DirectedAcyclicGraph.Visited getInstance(DirectedAcyclicGraph.Region affectedRegion)
/*      */     {
/*  885 */       this.affectedRegion = affectedRegion;
/*      */       
/*  887 */       return this;
/*      */     }
/*      */     
/*      */     public void setVisited(int index)
/*      */     {
/*  892 */       this.visited.set(translateIndex(index), true);
/*      */     }
/*      */     
/*      */     public boolean getVisited(int index)
/*      */     {
/*  897 */       return this.visited.get(translateIndex(index));
/*      */     }
/*      */     
/*      */     public void clearVisited(int index)
/*      */       throws UnsupportedOperationException
/*      */     {
/*  903 */       this.visited.clear(translateIndex(index));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     private int translateIndex(int index)
/*      */     {
/*  918 */       return index - this.affectedRegion.start;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static class VisitedArrayListImpl
/*      */     implements DirectedAcyclicGraph.Visited, DirectedAcyclicGraph.VisitedFactory
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  939 */     private final List<Boolean> visited = new ArrayList();
/*      */     
/*      */     private DirectedAcyclicGraph.Region affectedRegion;
/*      */     
/*      */ 
/*      */     public DirectedAcyclicGraph.Visited getInstance(DirectedAcyclicGraph.Region affectedRegion)
/*      */     {
/*  946 */       int minSize = affectedRegion.finish - affectedRegion.start + 1;
/*      */       
/*      */ 
/*  949 */       while (this.visited.size() < minSize) {
/*  950 */         this.visited.add(Boolean.FALSE);
/*      */       }
/*      */       
/*  953 */       this.affectedRegion = affectedRegion;
/*      */       
/*  955 */       return this;
/*      */     }
/*      */     
/*      */     public void setVisited(int index)
/*      */     {
/*  960 */       this.visited.set(translateIndex(index), Boolean.TRUE);
/*      */     }
/*      */     
/*      */     public boolean getVisited(int index)
/*      */     {
/*  965 */       Boolean result = null;
/*      */       
/*  967 */       result = (Boolean)this.visited.get(translateIndex(index));
/*      */       
/*  969 */       return result.booleanValue();
/*      */     }
/*      */     
/*      */     public void clearVisited(int index)
/*      */       throws UnsupportedOperationException
/*      */     {
/*  975 */       this.visited.set(translateIndex(index), Boolean.FALSE);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     private int translateIndex(int index)
/*      */     {
/*  990 */       return index - this.affectedRegion.start;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static class VisitedHashSetImpl
/*      */     implements DirectedAcyclicGraph.Visited, DirectedAcyclicGraph.VisitedFactory
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1010 */     private final Set<Integer> visited = new HashSet();
/*      */     
/*      */     public DirectedAcyclicGraph.Visited getInstance(DirectedAcyclicGraph.Region affectedRegion)
/*      */     {
/* 1014 */       this.visited.clear();
/* 1015 */       return this;
/*      */     }
/*      */     
/*      */     public void setVisited(int index)
/*      */     {
/* 1020 */       this.visited.add(Integer.valueOf(index));
/*      */     }
/*      */     
/*      */     public boolean getVisited(int index)
/*      */     {
/* 1025 */       return this.visited.contains(Integer.valueOf(index));
/*      */     }
/*      */     
/*      */     public void clearVisited(int index)
/*      */       throws UnsupportedOperationException
/*      */     {
/* 1031 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public static class VisitedArrayImpl
/*      */     implements DirectedAcyclicGraph.Visited, DirectedAcyclicGraph.VisitedFactory
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     private final boolean[] visited;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     private final DirectedAcyclicGraph.Region region;
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     public VisitedArrayImpl()
/*      */     {
/* 1059 */       this(null);
/*      */     }
/*      */     
/*      */     public VisitedArrayImpl(DirectedAcyclicGraph.Region region)
/*      */     {
/* 1064 */       if (region == null) {
/* 1065 */         this.visited = null;
/* 1066 */         this.region = null;
/*      */       } else {
/* 1068 */         this.region = region;
/*      */         
/*      */ 
/* 1071 */         this.visited = new boolean[region.getSize()];
/*      */       }
/*      */     }
/*      */     
/*      */     public DirectedAcyclicGraph.Visited getInstance(DirectedAcyclicGraph.Region affectedRegion)
/*      */     {
/* 1077 */       return new VisitedArrayImpl(affectedRegion);
/*      */     }
/*      */     
/*      */     public void setVisited(int index)
/*      */     {
/*      */       try {
/* 1083 */         this.visited[(index - this.region.start)] = true;
/*      */ 
/*      */       }
/*      */       catch (ArrayIndexOutOfBoundsException e)
/*      */       {
/* 1088 */         throw e;
/*      */       }
/*      */     }
/*      */     
/*      */     public boolean getVisited(int index)
/*      */     {
/*      */       try {
/* 1095 */         return this.visited[(index - this.region.start)];
/*      */ 
/*      */       }
/*      */       catch (ArrayIndexOutOfBoundsException e)
/*      */       {
/* 1100 */         throw e;
/*      */       }
/*      */     }
/*      */     
/*      */     public void clearVisited(int index)
/*      */       throws UnsupportedOperationException
/*      */     {
/* 1107 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private class TopoIterator
/*      */     implements Iterator<V>
/*      */   {
/* 1132 */     private Integer nextIndex = null;
/*      */     
/*      */ 
/*      */ 
/* 1136 */     private final long updateCountAtCreation = DirectedAcyclicGraph.this.topologyUpdateCount;
/* 1137 */     private int currentTopoIndex = DirectedAcyclicGraph.this.minTopoIndex - 1;
/*      */     
/*      */     public TopoIterator() {}
/*      */     
/*      */     public boolean hasNext() {
/* 1142 */       if (this.updateCountAtCreation != DirectedAcyclicGraph.this.topologyUpdateCount) {
/* 1143 */         throw new ConcurrentModificationException();
/*      */       }
/*      */       
/* 1146 */       this.nextIndex = getNextIndex();
/* 1147 */       return this.nextIndex != null;
/*      */     }
/*      */     
/*      */     public V next()
/*      */     {
/* 1152 */       if (this.updateCountAtCreation != DirectedAcyclicGraph.this.topologyUpdateCount) {
/* 1153 */         throw new ConcurrentModificationException();
/*      */       }
/*      */       
/* 1156 */       if (this.nextIndex == null)
/*      */       {
/* 1158 */         this.nextIndex = getNextIndex();
/*      */       }
/* 1160 */       if (this.nextIndex == null) {
/* 1161 */         throw new NoSuchElementException();
/*      */       }
/* 1163 */       this.currentTopoIndex = this.nextIndex.intValue();
/* 1164 */       this.nextIndex = null;
/* 1165 */       return (V)DirectedAcyclicGraph.this.topoOrderMap.getVertex(Integer.valueOf(this.currentTopoIndex));
/*      */     }
/*      */     
/*      */     public void remove()
/*      */     {
/* 1170 */       if (this.updateCountAtCreation != DirectedAcyclicGraph.this.topologyUpdateCount) {
/* 1171 */         throw new ConcurrentModificationException();
/*      */       }
/*      */       
/* 1174 */       V vertexToRemove = null;
/* 1175 */       if (
/* 1176 */         (vertexToRemove = 
/* 1177 */         DirectedAcyclicGraph.this.topoOrderMap.getVertex(
/* 1178 */         Integer.valueOf(this.currentTopoIndex))) != null)
/*      */       {
/* 1180 */         DirectedAcyclicGraph.this.topoOrderMap.removeVertex(vertexToRemove);
/*      */       }
/*      */       else {
/* 1183 */         throw new IllegalStateException();
/*      */       }
/*      */     }
/*      */     
/*      */     private Integer getNextIndex()
/*      */     {
/* 1189 */       for (int i = this.currentTopoIndex + 1; i <= DirectedAcyclicGraph.this.maxTopoIndex; i++) {
/* 1190 */         if (DirectedAcyclicGraph.this.topoOrderMap.getVertex(Integer.valueOf(i)) != null) {
/* 1191 */           return Integer.valueOf(i);
/*      */         }
/*      */       }
/* 1194 */       return null;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class CycleFoundException
/*      */     extends Exception
/*      */   {
/*      */     private static final long serialVersionUID = 5583471522212552754L;
/*      */   }
/*      */   
/*      */   public static abstract interface TopoOrderMapping<V>
/*      */     extends Serializable
/*      */   {
/*      */     public abstract void putVertex(Integer paramInteger, V paramV);
/*      */     
/*      */     public abstract V getVertex(Integer paramInteger);
/*      */     
/*      */     public abstract Integer getTopologicalIndex(V paramV);
/*      */     
/*      */     public abstract Integer removeVertex(V paramV);
/*      */     
/*      */     public abstract void removeAllVertices();
/*      */   }
/*      */   
/*      */   public static abstract interface TopoOrderMappingFactory<V>
/*      */   {
/*      */     public abstract DirectedAcyclicGraph.TopoOrderMapping<V> getTopoOrderMapping();
/*      */   }
/*      */   
/*      */   public static abstract interface Visited
/*      */   {
/*      */     public abstract void setVisited(int paramInt);
/*      */     
/*      */     public abstract boolean getVisited(int paramInt);
/*      */     
/*      */     public abstract void clearVisited(int paramInt)
/*      */       throws UnsupportedOperationException;
/*      */   }
/*      */   
/*      */   public static abstract interface VisitedFactory
/*      */     extends Serializable
/*      */   {
/*      */     public abstract DirectedAcyclicGraph.Visited getInstance(DirectedAcyclicGraph.Region paramRegion);
/*      */   }
/*      */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\dag\DirectedAcyclicGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */