/*    */ package org.jgrapht.graph;
/*    */ 
/*    */ import java.util.Set;
/*    */ import org.jgrapht.UndirectedGraph;
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
/*    */ public class UndirectedWeightedSubgraph<V, E>
/*    */   extends UndirectedSubgraph<V, E>
/*    */   implements WeightedGraph<V, E>
/*    */ {
/*    */   private static final long serialVersionUID = 3689346615735236409L;
/*    */   
/*    */   public UndirectedWeightedSubgraph(WeightedGraph<V, E> base, Set<V> vertexSubset, Set<E> edgeSubset)
/*    */   {
/* 78 */     super((UndirectedGraph)base, vertexSubset, edgeSubset);
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\UndirectedWeightedSubgraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */