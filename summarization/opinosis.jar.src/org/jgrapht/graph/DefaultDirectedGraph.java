/*    */ package org.jgrapht.graph;
/*    */ 
/*    */ import org.jgrapht.DirectedGraph;
/*    */ import org.jgrapht.EdgeFactory;
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
/*    */ public class DefaultDirectedGraph<V, E>
/*    */   extends AbstractBaseGraph<V, E>
/*    */   implements DirectedGraph<V, E>
/*    */ {
/*    */   private static final long serialVersionUID = 3544953246956466230L;
/*    */   
/*    */   public DefaultDirectedGraph(Class<? extends E> edgeClass)
/*    */   {
/* 72 */     this(new ClassBasedEdgeFactory(edgeClass));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public DefaultDirectedGraph(EdgeFactory<V, E> ef)
/*    */   {
/* 82 */     super(ef, false, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\DefaultDirectedGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */