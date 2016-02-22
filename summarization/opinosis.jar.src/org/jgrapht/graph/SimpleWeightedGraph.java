/*    */ package org.jgrapht.graph;
/*    */ 
/*    */ import org.jgrapht.EdgeFactory;
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
/*    */ public class SimpleWeightedGraph<V, E>
/*    */   extends SimpleGraph<V, E>
/*    */   implements WeightedGraph<V, E>
/*    */ {
/*    */   private static final long serialVersionUID = 3906088949100655922L;
/*    */   
/*    */   public SimpleWeightedGraph(EdgeFactory<V, E> ef)
/*    */   {
/* 68 */     super(ef);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SimpleWeightedGraph(Class<? extends E> edgeClass)
/*    */   {
/* 78 */     this(new ClassBasedEdgeFactory(edgeClass));
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\SimpleWeightedGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */