/*     */ package org.jgrapht.experimental.isomorphism;
/*     */ 
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.experimental.equivalence.EquivalenceComparator;
/*     */ import org.jgrapht.experimental.equivalence.EquivalenceComparatorChain;
/*     */ import org.jgrapht.experimental.equivalence.EquivalenceComparatorChainBase;
/*     */ import org.jgrapht.graph.DirectedMultigraph;
/*     */ import org.jgrapht.graph.Multigraph;
/*     */ import org.jgrapht.graph.Pseudograph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AdaptiveIsomorphismInspectorFactory
/*     */ {
/*     */   public static final int GRAPH_TYPE_ARBITRARY = 0;
/*     */   public static final int GRAPH_TYPE_PLANAR = 1;
/*     */   public static final int GRAPH_TYPE_TREE = 2;
/*     */   public static final int GRAPH_TYPE_MULTIGRAPH = 3;
/*     */   
/*     */   public static <V, E> GraphIsomorphismInspector createIsomorphismInspector(Graph<V, E> graph1, Graph<V, E> graph2, EquivalenceComparator<? super V, ? super Graph<V, E>> vertexChecker, EquivalenceComparator<? super E, ? super Graph<V, E>> edgeChecker)
/*     */   {
/*  90 */     int graphType = checkGraphsType(graph1, graph2);
/*  91 */     return createAppropriateConcreteInspector(
/*  92 */       graphType, 
/*  93 */       graph1, 
/*  94 */       graph2, 
/*  95 */       vertexChecker, 
/*  96 */       edgeChecker);
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
/*     */   public static <V, E> GraphIsomorphismInspector createIsomorphismInspector(Graph<V, E> graph1, Graph<V, E> graph2)
/*     */   {
/* 112 */     return createIsomorphismInspector(graph1, graph2, null, null);
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
/*     */   public static <V, E> GraphIsomorphismInspector createIsomorphismInspectorByType(int type, Graph<V, E> graph1, Graph<V, E> graph2, EquivalenceComparator<? super V, ? super Graph<V, E>> vertexChecker, EquivalenceComparator<? super E, ? super Graph<V, E>> edgeChecker)
/*     */   {
/* 133 */     return createAppropriateConcreteInspector(
/* 134 */       type, 
/* 135 */       graph1, 
/* 136 */       graph2, 
/* 137 */       vertexChecker, 
/* 138 */       edgeChecker);
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
/*     */   public static <V, E> GraphIsomorphismInspector createIsomorphismInspectorByType(int type, Graph<V, E> graph1, Graph<V, E> graph2)
/*     */   {
/* 158 */     return createAppropriateConcreteInspector(
/* 159 */       type, 
/* 160 */       graph1, 
/* 161 */       graph2, 
/* 162 */       null, 
/* 163 */       null);
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
/*     */   protected static <V, E> GraphIsomorphismInspector createAppropriateConcreteInspector(int graphType, Graph<V, E> graph1, Graph<V, E> graph2, EquivalenceComparator<? super V, ? super Graph<V, E>> vertexChecker, EquivalenceComparator<? super E, ? super Graph<V, E>> edgeChecker)
/*     */   {
/* 185 */     assertUnsupportedGraphTypes(graph1);
/* 186 */     assertUnsupportedGraphTypes(graph2);
/* 187 */     GraphIsomorphismInspector currentInspector = null;
/*     */     
/* 189 */     switch (graphType) {
/*     */     case 0: 
/*     */     case 1: 
/*     */     case 2: 
/* 193 */       currentInspector = 
/* 194 */         createTopologicalExhaustiveInspector(
/* 195 */         graph1, 
/* 196 */         graph2, 
/* 197 */         vertexChecker, 
/* 198 */         edgeChecker);
/* 199 */       break;
/*     */     
/*     */ 
/*     */     default: 
/* 203 */       throw new IllegalArgumentException(
/* 204 */         "The type was not one of the supported types.");
/*     */     }
/* 206 */     return currentInspector;
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
/*     */   protected static void assertUnsupportedGraphTypes(Graph g)
/*     */     throws IllegalArgumentException
/*     */   {
/* 222 */     if (((g instanceof Multigraph)) || 
/* 223 */       ((g instanceof DirectedMultigraph)) || 
/* 224 */       ((g instanceof Pseudograph)))
/*     */     {
/* 226 */       throw new IllegalArgumentException(
/* 227 */         "graph type not supported for the graph" + g);
/*     */     }
/*     */   }
/*     */   
/*     */   protected static int checkGraphsType(Graph graph1, Graph graph2)
/*     */   {
/* 233 */     return 0;
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
/*     */   protected static <V, E> GraphIsomorphismInspector createTopologicalExhaustiveInspector(Graph<V, E> graph1, Graph<V, E> graph2, EquivalenceComparator<? super V, ? super Graph<V, E>> vertexChecker, EquivalenceComparator<? super E, ? super Graph<V, E>> edgeChecker)
/*     */   {
/* 249 */     VertexDegreeEquivalenceComparator<V, E> degreeComparator = 
/* 250 */       new VertexDegreeEquivalenceComparator();
/* 251 */     EquivalenceComparatorChain<V, Graph<V, E>> vertexChainedChecker = 
/* 252 */       new EquivalenceComparatorChainBase(
/* 253 */       degreeComparator);
/* 254 */     vertexChainedChecker.appendComparator(vertexChecker);
/*     */     
/* 256 */     GraphIsomorphismInspector inspector = 
/*     */     
/*     */ 
/* 259 */       new EquivalenceIsomorphismInspector(
/* 260 */       graph1, 
/* 261 */       graph2, 
/* 262 */       vertexChainedChecker, 
/* 263 */       edgeChecker);
/* 264 */     return inspector;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\isomorphism\AdaptiveIsomorphismInspectorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */