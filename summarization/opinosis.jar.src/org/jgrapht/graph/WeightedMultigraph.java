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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WeightedMultigraph<V, E>
/*    */   extends Multigraph<V, E>
/*    */   implements WeightedGraph<V, E>
/*    */ {
/*    */   private static final long serialVersionUID = 3544671793370640696L;
/*    */   
/*    */   public WeightedMultigraph(EdgeFactory<V, E> ef)
/*    */   {
/* 71 */     super(ef);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public WeightedMultigraph(Class<? extends E> edgeClass)
/*    */   {
/* 81 */     this(new ClassBasedEdgeFactory(edgeClass));
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\WeightedMultigraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */