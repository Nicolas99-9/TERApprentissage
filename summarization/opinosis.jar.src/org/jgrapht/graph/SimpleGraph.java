/*    */ package org.jgrapht.graph;
/*    */ 
/*    */ import org.jgrapht.EdgeFactory;
/*    */ import org.jgrapht.UndirectedGraph;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SimpleGraph<V, E>
/*    */   extends AbstractBaseGraph<V, E>
/*    */   implements UndirectedGraph<V, E>
/*    */ {
/*    */   private static final long serialVersionUID = 3545796589454112304L;
/*    */   
/*    */   public SimpleGraph(EdgeFactory<V, E> ef)
/*    */   {
/* 71 */     super(ef, false, false);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SimpleGraph(Class<? extends E> edgeClass)
/*    */   {
/* 81 */     this(new ClassBasedEdgeFactory(edgeClass));
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\SimpleGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */