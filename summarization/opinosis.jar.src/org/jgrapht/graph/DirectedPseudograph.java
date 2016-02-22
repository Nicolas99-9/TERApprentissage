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
/*    */ public class DirectedPseudograph<V, E>
/*    */   extends AbstractBaseGraph<V, E>
/*    */   implements DirectedGraph<V, E>
/*    */ {
/*    */   private static final long serialVersionUID = -8300409752893486415L;
/*    */   
/*    */   public DirectedPseudograph(Class<? extends E> edgeClass)
/*    */   {
/* 68 */     this(new ClassBasedEdgeFactory(edgeClass));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public DirectedPseudograph(EdgeFactory<V, E> ef)
/*    */   {
/* 76 */     super(ef, true, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\DirectedPseudograph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */