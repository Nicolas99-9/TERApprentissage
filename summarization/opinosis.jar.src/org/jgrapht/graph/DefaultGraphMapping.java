/*     */ package org.jgrapht.graph;
/*     */ 
/*     */ import java.util.Map;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.GraphMapping;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultGraphMapping<V, E>
/*     */   implements GraphMapping<V, E>
/*     */ {
/*     */   private Map<V, V> graphMappingForward;
/*     */   private Map<V, V> graphMappingReverse;
/*     */   private Graph<V, E> graph1;
/*     */   private Graph<V, E> graph2;
/*     */   
/*     */   public DefaultGraphMapping(Map<V, V> g1ToG2, Map<V, V> g2ToG1, Graph<V, E> g1, Graph<V, E> g2)
/*     */   {
/*  83 */     this.graph1 = g1;
/*  84 */     this.graph2 = g2;
/*  85 */     this.graphMappingForward = g1ToG2;
/*  86 */     this.graphMappingReverse = g2ToG1;
/*     */   }
/*     */   
/*     */ 
/*     */   public E getEdgeCorrespondence(E currEdge, boolean forward)
/*     */   {
/*     */     Graph<V, E> targetGraph;
/*     */     Graph<V, E> sourceGraph;
/*     */     Graph<V, E> targetGraph;
/*  95 */     if (forward) {
/*  96 */       Graph<V, E> sourceGraph = this.graph1;
/*  97 */       targetGraph = this.graph2;
/*     */     } else {
/*  99 */       sourceGraph = this.graph2;
/* 100 */       targetGraph = this.graph1;
/*     */     }
/*     */     
/* 103 */     V mappedSourceVertex = 
/* 104 */       getVertexCorrespondence(
/* 105 */       sourceGraph.getEdgeSource(currEdge), 
/* 106 */       forward);
/* 107 */     V mappedTargetVertex = 
/* 108 */       getVertexCorrespondence(
/* 109 */       sourceGraph.getEdgeTarget(currEdge), 
/* 110 */       forward);
/* 111 */     if ((mappedSourceVertex == null) || (mappedTargetVertex == null)) {
/* 112 */       return null;
/*     */     }
/* 114 */     return (E)targetGraph.getEdge(
/* 115 */       mappedSourceVertex, 
/* 116 */       mappedTargetVertex);
/*     */   }
/*     */   
/*     */ 
/*     */   public V getVertexCorrespondence(V keyVertex, boolean forward)
/*     */   {
/*     */     Map<V, V> graphMapping;
/*     */     
/*     */     Map<V, V> graphMapping;
/* 125 */     if (forward) {
/* 126 */       graphMapping = this.graphMappingForward;
/*     */     } else {
/* 128 */       graphMapping = this.graphMappingReverse;
/*     */     }
/*     */     
/* 131 */     return (V)graphMapping.get(keyVertex);
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\DefaultGraphMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */