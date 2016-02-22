/*    */ package org.jgrapht.graph;
/*    */ 
/*    */ import java.util.Set;
/*    */ import org.jgrapht.DirectedGraph;
/*    */ import org.jgrapht.WeightedGraph;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DirectedWeightedSubgraph<V, E>
/*    */   extends DirectedSubgraph<V, E>
/*    */   implements WeightedGraph<V, E>
/*    */ {
/*    */   private static final long serialVersionUID = 3905799799168250680L;
/*    */   
/*    */   public DirectedWeightedSubgraph(WeightedGraph<V, E> base, Set<V> vertexSubset, Set<E> edgeSubset)
/*    */   {
/* 79 */     super((DirectedGraph)base, vertexSubset, edgeSubset);
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\DirectedWeightedSubgraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */