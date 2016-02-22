/*    */ package org.jgrapht.graph;
/*    */ 
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
/*    */ public class ListenableDirectedWeightedGraph<V, E>
/*    */   extends ListenableDirectedGraph<V, E>
/*    */   implements WeightedGraph<V, E>
/*    */ {
/*    */   private static final long serialVersionUID = 3977582476627621938L;
/*    */   
/*    */   public ListenableDirectedWeightedGraph(Class<? extends E> edgeClass)
/*    */   {
/* 70 */     this(new DefaultDirectedWeightedGraph(edgeClass));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ListenableDirectedWeightedGraph(WeightedGraph<V, E> base)
/*    */   {
/* 80 */     super((DirectedGraph)base);
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\ListenableDirectedWeightedGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */