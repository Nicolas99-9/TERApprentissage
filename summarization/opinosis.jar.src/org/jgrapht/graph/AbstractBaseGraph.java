/*      */ package org.jgrapht.graph;
/*      */ 
/*      */ import java.io.Serializable;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.jgrapht.DirectedGraph;
/*      */ import org.jgrapht.EdgeFactory;
/*      */ import org.jgrapht.Graph;
/*      */ import org.jgrapht.Graphs;
/*      */ import org.jgrapht.UndirectedGraph;
/*      */ import org.jgrapht.util.ArrayUnenforcedSet;
/*      */ import org.jgrapht.util.TypeUtil;
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
/*      */ public abstract class AbstractBaseGraph<V, E>
/*      */   extends AbstractGraph<V, E>
/*      */   implements Graph<V, E>, Cloneable, Serializable
/*      */ {
/*      */   private static final long serialVersionUID = -1263088497616142427L;
/*      */   private static final String LOOPS_NOT_ALLOWED = "loops not allowed";
/*      */   boolean allowingLoops;
/*      */   private EdgeFactory<V, E> edgeFactory;
/*      */   private EdgeSetFactory<V, E> edgeSetFactory;
/*      */   private Map<E, IntrusiveEdge> edgeMap;
/*   89 */   private transient Set<E> unmodifiableEdgeSet = null;
/*   90 */   private transient Set<V> unmodifiableVertexSet = null;
/*      */   
/*      */   private AbstractBaseGraph<V, E>.Specifics specifics;
/*      */   private boolean allowingMultipleEdges;
/*   94 */   private transient TypeUtil<V> vertexTypeDecl = null;
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
/*      */   public AbstractBaseGraph(EdgeFactory<V, E> ef, boolean allowMultipleEdges, boolean allowLoops)
/*      */   {
/*  114 */     if (ef == null) {
/*  115 */       throw new NullPointerException();
/*      */     }
/*      */     
/*  118 */     this.edgeMap = new LinkedHashMap();
/*  119 */     this.edgeFactory = ef;
/*  120 */     this.allowingLoops = allowLoops;
/*  121 */     this.allowingMultipleEdges = allowMultipleEdges;
/*      */     
/*  123 */     this.specifics = createSpecifics();
/*      */     
/*  125 */     this.edgeSetFactory = new ArrayListFactory(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<E> getAllEdges(V sourceVertex, V targetVertex)
/*      */   {
/*  135 */     return this.specifics.getAllEdges(sourceVertex, targetVertex);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isAllowingLoops()
/*      */   {
/*  147 */     return this.allowingLoops;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isAllowingMultipleEdges()
/*      */   {
/*  159 */     return this.allowingMultipleEdges;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public E getEdge(V sourceVertex, V targetVertex)
/*      */   {
/*  167 */     return (E)this.specifics.getEdge(sourceVertex, targetVertex);
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
/*      */   public EdgeFactory<V, E> getEdgeFactory()
/*      */   {
/*  188 */     return this.edgeFactory;
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
/*      */   public void setEdgeSetFactory(EdgeSetFactory<V, E> edgeSetFactory)
/*      */   {
/*  201 */     this.edgeSetFactory = edgeSetFactory;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public E addEdge(V sourceVertex, V targetVertex)
/*      */   {
/*  209 */     assertVertexExist(sourceVertex);
/*  210 */     assertVertexExist(targetVertex);
/*      */     
/*  212 */     if ((!this.allowingMultipleEdges) && 
/*  213 */       (containsEdge(sourceVertex, targetVertex)))
/*      */     {
/*  215 */       return null;
/*      */     }
/*      */     
/*  218 */     if ((!this.allowingLoops) && (sourceVertex.equals(targetVertex))) {
/*  219 */       throw new IllegalArgumentException("loops not allowed");
/*      */     }
/*      */     
/*  222 */     E e = this.edgeFactory.createEdge(sourceVertex, targetVertex);
/*      */     
/*  224 */     if (containsEdge(e))
/*      */     {
/*  226 */       return null;
/*      */     }
/*  228 */     IntrusiveEdge intrusiveEdge = 
/*  229 */       createIntrusiveEdge(e, sourceVertex, targetVertex);
/*      */     
/*  231 */     this.edgeMap.put(e, intrusiveEdge);
/*  232 */     this.specifics.addEdgeToTouchingVertices(e);
/*      */     
/*  234 */     return e;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean addEdge(V sourceVertex, V targetVertex, E e)
/*      */   {
/*  243 */     if (e == null)
/*  244 */       throw new NullPointerException();
/*  245 */     if (containsEdge(e)) {
/*  246 */       return false;
/*      */     }
/*      */     
/*  249 */     assertVertexExist(sourceVertex);
/*  250 */     assertVertexExist(targetVertex);
/*      */     
/*  252 */     if ((!this.allowingMultipleEdges) && 
/*  253 */       (containsEdge(sourceVertex, targetVertex)))
/*      */     {
/*  255 */       return false;
/*      */     }
/*      */     
/*  258 */     if ((!this.allowingLoops) && (sourceVertex.equals(targetVertex))) {
/*  259 */       throw new IllegalArgumentException("loops not allowed");
/*      */     }
/*      */     
/*  262 */     IntrusiveEdge intrusiveEdge = 
/*  263 */       createIntrusiveEdge(e, sourceVertex, targetVertex);
/*      */     
/*  265 */     this.edgeMap.put(e, intrusiveEdge);
/*  266 */     this.specifics.addEdgeToTouchingVertices(e);
/*      */     
/*  268 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   private IntrusiveEdge createIntrusiveEdge(E e, V sourceVertex, V targetVertex)
/*      */   {
/*      */     IntrusiveEdge intrusiveEdge;
/*      */     
/*      */     IntrusiveEdge intrusiveEdge;
/*  277 */     if ((e instanceof IntrusiveEdge)) {
/*  278 */       intrusiveEdge = (IntrusiveEdge)e;
/*      */     } else {
/*  280 */       intrusiveEdge = new IntrusiveEdge();
/*      */     }
/*  282 */     intrusiveEdge.source = sourceVertex;
/*  283 */     intrusiveEdge.target = targetVertex;
/*  284 */     return intrusiveEdge;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean addVertex(V v)
/*      */   {
/*  292 */     if (v == null)
/*  293 */       throw new NullPointerException();
/*  294 */     if (containsVertex(v)) {
/*  295 */       return false;
/*      */     }
/*  297 */     this.specifics.addVertex(v);
/*      */     
/*  299 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public V getEdgeSource(E e)
/*      */   {
/*  308 */     return (V)TypeUtil.uncheckedCast(
/*  309 */       getIntrusiveEdge(e).source, 
/*  310 */       this.vertexTypeDecl);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public V getEdgeTarget(E e)
/*      */   {
/*  318 */     return (V)TypeUtil.uncheckedCast(
/*  319 */       getIntrusiveEdge(e).target, 
/*  320 */       this.vertexTypeDecl);
/*      */   }
/*      */   
/*      */   private IntrusiveEdge getIntrusiveEdge(E e)
/*      */   {
/*  325 */     if ((e instanceof IntrusiveEdge)) {
/*  326 */       return (IntrusiveEdge)e;
/*      */     }
/*      */     
/*  329 */     return (IntrusiveEdge)this.edgeMap.get(e);
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
/*      */   public Object clone()
/*      */   {
/*      */     try
/*      */     {
/*  346 */       TypeUtil<AbstractBaseGraph<V, E>> typeDecl = null;
/*      */       
/*  348 */       AbstractBaseGraph<V, E> newGraph = 
/*  349 */         (AbstractBaseGraph)TypeUtil.uncheckedCast(super.clone(), typeDecl);
/*      */       
/*  351 */       newGraph.edgeMap = new LinkedHashMap();
/*      */       
/*  353 */       newGraph.edgeFactory = this.edgeFactory;
/*  354 */       newGraph.unmodifiableEdgeSet = null;
/*  355 */       newGraph.unmodifiableVertexSet = null;
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*  360 */       newGraph.specifics = newGraph.createSpecifics();
/*      */       
/*  362 */       Graphs.addGraph(newGraph, this);
/*      */       
/*  364 */       return newGraph;
/*      */     } catch (CloneNotSupportedException e) {
/*  366 */       e.printStackTrace();
/*  367 */       throw new RuntimeException();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean containsEdge(E e)
/*      */   {
/*  376 */     return this.edgeMap.containsKey(e);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean containsVertex(V v)
/*      */   {
/*  384 */     return this.specifics.getVertexSet().contains(v);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public int degreeOf(V vertex)
/*      */   {
/*  392 */     return this.specifics.degreeOf(vertex);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<E> edgeSet()
/*      */   {
/*  400 */     if (this.unmodifiableEdgeSet == null) {
/*  401 */       this.unmodifiableEdgeSet = Collections.unmodifiableSet(this.edgeMap.keySet());
/*      */     }
/*      */     
/*  404 */     return this.unmodifiableEdgeSet;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<E> edgesOf(V vertex)
/*      */   {
/*  412 */     return this.specifics.edgesOf(vertex);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public int inDegreeOf(V vertex)
/*      */   {
/*  420 */     return this.specifics.inDegreeOf(vertex);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<E> incomingEdgesOf(V vertex)
/*      */   {
/*  428 */     return this.specifics.incomingEdgesOf(vertex);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public int outDegreeOf(V vertex)
/*      */   {
/*  436 */     return this.specifics.outDegreeOf(vertex);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<E> outgoingEdgesOf(V vertex)
/*      */   {
/*  444 */     return this.specifics.outgoingEdgesOf(vertex);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public E removeEdge(V sourceVertex, V targetVertex)
/*      */   {
/*  452 */     E e = getEdge(sourceVertex, targetVertex);
/*      */     
/*  454 */     if (e != null) {
/*  455 */       this.specifics.removeEdgeFromTouchingVertices(e);
/*  456 */       this.edgeMap.remove(e);
/*      */     }
/*      */     
/*  459 */     return e;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean removeEdge(E e)
/*      */   {
/*  467 */     if (containsEdge(e)) {
/*  468 */       this.specifics.removeEdgeFromTouchingVertices(e);
/*  469 */       this.edgeMap.remove(e);
/*      */       
/*  471 */       return true;
/*      */     }
/*  473 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean removeVertex(V v)
/*      */   {
/*  482 */     if (containsVertex(v)) {
/*  483 */       Set<E> touchingEdgesList = edgesOf(v);
/*      */       
/*      */ 
/*      */ 
/*  487 */       removeAllEdges(new ArrayList(touchingEdgesList));
/*      */       
/*  489 */       this.specifics.getVertexSet().remove(v);
/*      */       
/*  491 */       return true;
/*      */     }
/*  493 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<V> vertexSet()
/*      */   {
/*  502 */     if (this.unmodifiableVertexSet == null) {
/*  503 */       this.unmodifiableVertexSet = 
/*  504 */         Collections.unmodifiableSet(this.specifics.getVertexSet());
/*      */     }
/*      */     
/*  507 */     return this.unmodifiableVertexSet;
/*      */   }
/*      */   
/*      */   public void setClassified(E e, long clusterID)
/*      */   {
/*  512 */     if ((e instanceof DefaultWeightedEdge)) {
/*  513 */       ((DefaultWeightedEdge)e).setClassified(clusterID);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isClassified(E e)
/*      */   {
/*  519 */     if ((e instanceof DefaultWeightedEdge)) {
/*  520 */       return ((DefaultWeightedEdge)e).isClassified();
/*      */     }
/*      */     
/*  523 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public double getEdgeWeight(E e)
/*      */   {
/*  531 */     if ((e instanceof DefaultWeightedEdge)) {
/*  532 */       return ((DefaultWeightedEdge)e).weight;
/*      */     }
/*  534 */     return 1.0D;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setEdgeWeight(E e, double weight)
/*      */   {
/*  543 */     assert ((e instanceof DefaultWeightedEdge)) : e.getClass();
/*  544 */     ((DefaultWeightedEdge)e).weight = weight;
/*      */   }
/*      */   
/*      */   private AbstractBaseGraph<V, E>.Specifics createSpecifics()
/*      */   {
/*  549 */     if ((this instanceof DirectedGraph))
/*  550 */       return new DirectedSpecifics(null);
/*  551 */     if ((this instanceof UndirectedGraph)) {
/*  552 */       return new UndirectedSpecifics(null);
/*      */     }
/*  554 */     throw new IllegalArgumentException(
/*  555 */       "must be instance of either DirectedGraph or UndirectedGraph");
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
/*      */   private static class ArrayListFactory<VV, EE>
/*      */     implements EdgeSetFactory<VV, EE>, Serializable
/*      */   {
/*      */     private static final long serialVersionUID = 5936902837403445985L;
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
/*      */     public Set<EE> createEdgeSet(VV vertex)
/*      */     {
/*  680 */       return new ArrayUnenforcedSet(1);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   private static class DirectedEdgeContainer<VV, EE>
/*      */     implements Serializable
/*      */   {
/*      */     private static final long serialVersionUID = 7494242245729767106L;
/*      */     
/*      */ 
/*      */     Set<EE> incoming;
/*      */     
/*      */ 
/*      */     Set<EE> outgoing;
/*      */     
/*      */ 
/*  699 */     private transient Set<EE> unmodifiableIncoming = null;
/*  700 */     private transient Set<EE> unmodifiableOutgoing = null;
/*      */     
/*      */ 
/*      */     DirectedEdgeContainer(EdgeSetFactory<VV, EE> edgeSetFactory, VV vertex)
/*      */     {
/*  705 */       this.incoming = edgeSetFactory.createEdgeSet(vertex);
/*  706 */       this.outgoing = edgeSetFactory.createEdgeSet(vertex);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public Set<EE> getUnmodifiableIncomingEdges()
/*      */     {
/*  716 */       if (this.unmodifiableIncoming == null) {
/*  717 */         this.unmodifiableIncoming = Collections.unmodifiableSet(this.incoming);
/*      */       }
/*      */       
/*  720 */       return this.unmodifiableIncoming;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public Set<EE> getUnmodifiableOutgoingEdges()
/*      */     {
/*  730 */       if (this.unmodifiableOutgoing == null) {
/*  731 */         this.unmodifiableOutgoing = Collections.unmodifiableSet(this.outgoing);
/*      */       }
/*      */       
/*  734 */       return this.unmodifiableOutgoing;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void addIncomingEdge(EE e)
/*      */     {
/*  744 */       this.incoming.add(e);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void addOutgoingEdge(EE e)
/*      */     {
/*  754 */       this.outgoing.add(e);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void removeIncomingEdge(EE e)
/*      */     {
/*  764 */       this.incoming.remove(e);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void removeOutgoingEdge(EE e)
/*      */     {
/*  774 */       this.outgoing.remove(e);
/*      */     }
/*      */   }
/*      */   
/*      */   private class DirectedSpecifics extends AbstractBaseGraph<V, E>.Specifics implements Serializable {
/*      */     private static final long serialVersionUID = 8971725103718958232L;
/*      */     private static final String NOT_IN_DIRECTED_GRAPH = "no such operation in a directed graph";
/*      */     
/*      */     private DirectedSpecifics() {
/*  783 */       super(null);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  792 */     private Map<V, AbstractBaseGraph.DirectedEdgeContainer<V, E>> vertexMapDirected = new LinkedHashMap();
/*      */     
/*      */ 
/*      */ 
/*      */     public void addVertex(V v)
/*      */     {
/*  798 */       this.vertexMapDirected.put(v, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<V> getVertexSet()
/*      */     {
/*  804 */       return this.vertexMapDirected.keySet();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public Set<E> getAllEdges(V sourceVertex, V targetVertex)
/*      */     {
/*  813 */       Set<E> edges = null;
/*      */       
/*  815 */       if ((AbstractBaseGraph.this.containsVertex(sourceVertex)) && 
/*  816 */         (AbstractBaseGraph.this.containsVertex(targetVertex)))
/*      */       {
/*  818 */         edges = new ArrayUnenforcedSet();
/*      */         
/*  820 */         AbstractBaseGraph.DirectedEdgeContainer<V, E> ec = getEdgeContainer(sourceVertex);
/*      */         
/*  822 */         Iterator<E> iter = ec.outgoing.iterator();
/*      */         
/*  824 */         while (iter.hasNext()) {
/*  825 */           E e = iter.next();
/*      */           
/*  827 */           if (AbstractBaseGraph.this.getEdgeTarget(e).equals(targetVertex)) {
/*  828 */             edges.add(e);
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*  833 */       return edges;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public E getEdge(V sourceVertex, V targetVertex)
/*      */     {
/*  842 */       if ((AbstractBaseGraph.this.containsVertex(sourceVertex)) && 
/*  843 */         (AbstractBaseGraph.this.containsVertex(targetVertex)))
/*      */       {
/*  845 */         AbstractBaseGraph.DirectedEdgeContainer<V, E> ec = getEdgeContainer(sourceVertex);
/*      */         
/*  847 */         Iterator<E> iter = ec.outgoing.iterator();
/*      */         
/*  849 */         while (iter.hasNext()) {
/*  850 */           E e = iter.next();
/*      */           
/*  852 */           if (AbstractBaseGraph.this.getEdgeTarget(e).equals(targetVertex)) {
/*  853 */             return e;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*  858 */       return null;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void addEdgeToTouchingVertices(E e)
/*      */     {
/*  867 */       V source = AbstractBaseGraph.this.getEdgeSource(e);
/*  868 */       V target = AbstractBaseGraph.this.getEdgeTarget(e);
/*      */       
/*  870 */       getEdgeContainer(source).addOutgoingEdge(e);
/*  871 */       getEdgeContainer(target).addIncomingEdge(e);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public int degreeOf(V vertex)
/*      */     {
/*  880 */       throw new UnsupportedOperationException("no such operation in a directed graph");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public Set<E> edgesOf(V vertex)
/*      */     {
/*  889 */       ArrayUnenforcedSet<E> inAndOut = 
/*  890 */         new ArrayUnenforcedSet(getEdgeContainer(vertex).incoming);
/*  891 */       inAndOut.addAll(getEdgeContainer(vertex).outgoing);
/*      */       
/*      */ 
/*  894 */       if (AbstractBaseGraph.this.allowingLoops) {
/*  895 */         Set<E> loops = getAllEdges(vertex, vertex);
/*      */         
/*  897 */         for (int i = 0; i < inAndOut.size();) {
/*  898 */           Object e = inAndOut.get(i);
/*      */           
/*  900 */           if (loops.contains(e)) {
/*  901 */             inAndOut.remove(i);
/*  902 */             loops.remove(e);
/*      */           } else {
/*  904 */             i++;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*  909 */       return Collections.unmodifiableSet(inAndOut);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public int inDegreeOf(V vertex)
/*      */     {
/*  918 */       return getEdgeContainer(vertex).incoming.size();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public Set<E> incomingEdgesOf(V vertex)
/*      */     {
/*  927 */       return getEdgeContainer(vertex).getUnmodifiableIncomingEdges();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public int outDegreeOf(V vertex)
/*      */     {
/*  936 */       return getEdgeContainer(vertex).outgoing.size();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public Set<E> outgoingEdgesOf(V vertex)
/*      */     {
/*  945 */       return getEdgeContainer(vertex).getUnmodifiableOutgoingEdges();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void removeEdgeFromTouchingVertices(E e)
/*      */     {
/*  954 */       V source = AbstractBaseGraph.this.getEdgeSource(e);
/*  955 */       V target = AbstractBaseGraph.this.getEdgeTarget(e);
/*      */       
/*  957 */       getEdgeContainer(source).removeOutgoingEdge(e);
/*  958 */       getEdgeContainer(target).removeIncomingEdge(e);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     private AbstractBaseGraph.DirectedEdgeContainer<V, E> getEdgeContainer(V vertex)
/*      */     {
/*  970 */       AbstractBaseGraph.this.assertVertexExist(vertex);
/*      */       
/*  972 */       AbstractBaseGraph.DirectedEdgeContainer<V, E> ec = (AbstractBaseGraph.DirectedEdgeContainer)this.vertexMapDirected.get(vertex);
/*      */       
/*  974 */       if (ec == null) {
/*  975 */         ec = new AbstractBaseGraph.DirectedEdgeContainer(AbstractBaseGraph.this.edgeSetFactory, vertex);
/*  976 */         this.vertexMapDirected.put(vertex, ec);
/*      */       }
/*      */       
/*  979 */       return ec; } }
/*      */   
/*      */   private abstract class Specifics implements Serializable { private static final long serialVersionUID = 785196247314761183L;
/*      */     
/*      */     private Specifics() {}
/*      */     
/*      */     public abstract void addVertex(V paramV);
/*      */     public abstract Set<V> getVertexSet();
/*      */     public abstract Set<E> getAllEdges(V paramV1, V paramV2);
/*      */     public abstract E getEdge(V paramV1, V paramV2);
/*      */     public abstract void addEdgeToTouchingVertices(E paramE);
/*      */     public abstract int degreeOf(V paramV);
/*      */     public abstract Set<E> edgesOf(V paramV);
/*      */     public abstract int inDegreeOf(V paramV);
/*      */     public abstract Set<E> incomingEdgesOf(V paramV);
/*      */     public abstract int outDegreeOf(V paramV);
/*      */     public abstract Set<E> outgoingEdgesOf(V paramV);
/*      */     public abstract void removeEdgeFromTouchingVertices(E paramE); }
/*  997 */   private static class UndirectedEdgeContainer<VV, EE> implements Serializable { private static final long serialVersionUID = -6623207588411170010L; Set<EE> vertexEdges; private transient Set<EE> unmodifiableVertexEdges = null;
/*      */     
/*      */ 
/*      */ 
/*      */     UndirectedEdgeContainer(EdgeSetFactory<VV, EE> edgeSetFactory, VV vertex)
/*      */     {
/* 1003 */       this.vertexEdges = edgeSetFactory.createEdgeSet(vertex);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public Set<EE> getUnmodifiableVertexEdges()
/*      */     {
/* 1013 */       if (this.unmodifiableVertexEdges == null) {
/* 1014 */         this.unmodifiableVertexEdges = 
/* 1015 */           Collections.unmodifiableSet(this.vertexEdges);
/*      */       }
/*      */       
/* 1018 */       return this.unmodifiableVertexEdges;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void addEdge(EE e)
/*      */     {
/* 1028 */       this.vertexEdges.add(e);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public int edgeCount()
/*      */     {
/* 1038 */       return this.vertexEdges.size();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void removeEdge(EE e)
/*      */     {
/* 1048 */       this.vertexEdges.remove(e);
/*      */     }
/*      */   }
/*      */   
/*      */   private class UndirectedSpecifics extends AbstractBaseGraph<V, E>.Specifics implements Serializable {
/*      */     private static final long serialVersionUID = 6494588405178655873L;
/*      */     private static final String NOT_IN_UNDIRECTED_GRAPH = "no such operation in an undirected graph";
/*      */     
/*      */     private UndirectedSpecifics() {
/* 1057 */       super(null);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1066 */     private Map<V, AbstractBaseGraph.UndirectedEdgeContainer<V, E>> vertexMapUndirected = new LinkedHashMap();
/*      */     
/*      */ 
/*      */ 
/*      */     public void addVertex(V v)
/*      */     {
/* 1072 */       this.vertexMapUndirected.put(v, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<V> getVertexSet()
/*      */     {
/* 1078 */       return this.vertexMapUndirected.keySet();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public Set<E> getAllEdges(V sourceVertex, V targetVertex)
/*      */     {
/* 1087 */       Set<E> edges = null;
/*      */       
/* 1089 */       if ((AbstractBaseGraph.this.containsVertex(sourceVertex)) && 
/* 1090 */         (AbstractBaseGraph.this.containsVertex(targetVertex)))
/*      */       {
/* 1092 */         edges = new ArrayUnenforcedSet();
/*      */         
/* 1094 */         Iterator<E> iter = 
/* 1095 */           getEdgeContainer(sourceVertex).vertexEdges.iterator();
/*      */         
/* 1097 */         while (iter.hasNext()) {
/* 1098 */           E e = iter.next();
/*      */           
/* 1100 */           boolean equalStraight = 
/* 1101 */             (sourceVertex.equals(AbstractBaseGraph.this.getEdgeSource(e))) && 
/* 1102 */             (targetVertex.equals(AbstractBaseGraph.this.getEdgeTarget(e)));
/*      */           
/* 1104 */           boolean equalInverted = 
/* 1105 */             (sourceVertex.equals(AbstractBaseGraph.this.getEdgeTarget(e))) && 
/* 1106 */             (targetVertex.equals(AbstractBaseGraph.this.getEdgeSource(e)));
/*      */           
/* 1108 */           if ((equalStraight) || (equalInverted)) {
/* 1109 */             edges.add(e);
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 1114 */       return edges;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public E getEdge(V sourceVertex, V targetVertex)
/*      */     {
/* 1123 */       if ((AbstractBaseGraph.this.containsVertex(sourceVertex)) && 
/* 1124 */         (AbstractBaseGraph.this.containsVertex(targetVertex)))
/*      */       {
/* 1126 */         Iterator<E> iter = 
/* 1127 */           getEdgeContainer(sourceVertex).vertexEdges.iterator();
/*      */         
/* 1129 */         while (iter.hasNext()) {
/* 1130 */           E e = iter.next();
/*      */           
/* 1132 */           boolean equalStraight = 
/* 1133 */             (sourceVertex.equals(AbstractBaseGraph.this.getEdgeSource(e))) && 
/* 1134 */             (targetVertex.equals(AbstractBaseGraph.this.getEdgeTarget(e)));
/*      */           
/* 1136 */           boolean equalInverted = 
/* 1137 */             (sourceVertex.equals(AbstractBaseGraph.this.getEdgeTarget(e))) && 
/* 1138 */             (targetVertex.equals(AbstractBaseGraph.this.getEdgeSource(e)));
/*      */           
/* 1140 */           if ((equalStraight) || (equalInverted)) {
/* 1141 */             return e;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/* 1146 */       return null;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void addEdgeToTouchingVertices(E e)
/*      */     {
/* 1155 */       V source = AbstractBaseGraph.this.getEdgeSource(e);
/* 1156 */       V target = AbstractBaseGraph.this.getEdgeTarget(e);
/*      */       
/* 1158 */       getEdgeContainer(source).addEdge(e);
/*      */       
/* 1160 */       if (source != target) {
/* 1161 */         getEdgeContainer(target).addEdge(e);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public int degreeOf(V vertex)
/*      */     {
/* 1171 */       if (AbstractBaseGraph.this.allowingLoops)
/*      */       {
/* 1173 */         int degree = 0;
/* 1174 */         Set<E> edges = getEdgeContainer(vertex).vertexEdges;
/*      */         
/* 1176 */         for (E e : edges) {
/* 1177 */           if (AbstractBaseGraph.this.getEdgeSource(e).equals(AbstractBaseGraph.this.getEdgeTarget(e))) {
/* 1178 */             degree += 2;
/*      */           } else {
/* 1180 */             degree++;
/*      */           }
/*      */         }
/*      */         
/* 1184 */         return degree;
/*      */       }
/* 1186 */       return getEdgeContainer(vertex).edgeCount();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public Set<E> edgesOf(V vertex)
/*      */     {
/* 1196 */       return getEdgeContainer(vertex).getUnmodifiableVertexEdges();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public int inDegreeOf(V vertex)
/*      */     {
/* 1205 */       throw new UnsupportedOperationException("no such operation in an undirected graph");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public Set<E> incomingEdgesOf(V vertex)
/*      */     {
/* 1214 */       throw new UnsupportedOperationException("no such operation in an undirected graph");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public int outDegreeOf(V vertex)
/*      */     {
/* 1223 */       throw new UnsupportedOperationException("no such operation in an undirected graph");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public Set<E> outgoingEdgesOf(V vertex)
/*      */     {
/* 1232 */       throw new UnsupportedOperationException("no such operation in an undirected graph");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public void removeEdgeFromTouchingVertices(E e)
/*      */     {
/* 1241 */       V source = AbstractBaseGraph.this.getEdgeSource(e);
/* 1242 */       V target = AbstractBaseGraph.this.getEdgeTarget(e);
/*      */       
/* 1244 */       getEdgeContainer(source).removeEdge(e);
/*      */       
/* 1246 */       if (source != target) {
/* 1247 */         getEdgeContainer(target).removeEdge(e);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     private AbstractBaseGraph.UndirectedEdgeContainer<V, E> getEdgeContainer(V vertex)
/*      */     {
/* 1260 */       AbstractBaseGraph.this.assertVertexExist(vertex);
/*      */       
/* 1262 */       AbstractBaseGraph.UndirectedEdgeContainer<V, E> ec = (AbstractBaseGraph.UndirectedEdgeContainer)this.vertexMapUndirected.get(vertex);
/*      */       
/* 1264 */       if (ec == null) {
/* 1265 */         ec = new AbstractBaseGraph.UndirectedEdgeContainer(
/* 1266 */           AbstractBaseGraph.this.edgeSetFactory, 
/* 1267 */           vertex);
/* 1268 */         this.vertexMapUndirected.put(vertex, ec);
/*      */       }
/*      */       
/* 1271 */       return ec;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\AbstractBaseGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */