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
/*    */ public class Pseudograph<V, E>
/*    */   extends AbstractBaseGraph<V, E>
/*    */   implements UndirectedGraph<V, E>
/*    */ {
/*    */   private static final long serialVersionUID = 3833183614484755253L;
/*    */   
/*    */   public Pseudograph(Class<? extends E> edgeClass)
/*    */   {
/* 70 */     this(new ClassBasedEdgeFactory(edgeClass));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Pseudograph(EdgeFactory<V, E> ef)
/*    */   {
/* 80 */     super(ef, true, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\Pseudograph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */