/*     */ package org.jgrapht.graph;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Map;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.WeightedGraph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AsWeightedGraph<V, E>
/*     */   extends GraphDelegator<V, E>
/*     */   implements Serializable, WeightedGraph<V, E>
/*     */ {
/*     */   private static final long serialVersionUID = -716810639338971372L;
/*     */   protected final Map<E, Double> weightMap;
/*     */   private final boolean isWeightedGraph;
/*     */   
/*     */   public AsWeightedGraph(Graph<V, E> g, Map<E, Double> weightMap)
/*     */   {
/* 103 */     super(g);
/* 104 */     assert (weightMap != null);
/* 105 */     this.weightMap = weightMap;
/*     */     
/*     */ 
/*     */ 
/* 109 */     this.isWeightedGraph = (g instanceof WeightedGraph);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEdgeWeight(E e, double weight)
/*     */   {
/* 120 */     if (this.isWeightedGraph) {
/* 121 */       super.setEdgeWeight(e, weight);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 126 */     this.weightMap.put(e, Double.valueOf(weight));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double getEdgeWeight(E e)
/*     */   {
/*     */     double weight;
/*     */     
/*     */ 
/*     */     double weight;
/*     */     
/*     */ 
/* 139 */     if (this.weightMap.containsKey(e)) {
/* 140 */       weight = ((Double)this.weightMap.get(e)).doubleValue();
/*     */     } else {
/* 142 */       weight = super.getEdgeWeight(e);
/*     */     }
/*     */     
/* 145 */     return weight;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\AsWeightedGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */