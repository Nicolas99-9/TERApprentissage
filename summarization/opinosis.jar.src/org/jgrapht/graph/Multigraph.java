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
/*    */ public class Multigraph<V, E>
/*    */   extends AbstractBaseGraph<V, E>
/*    */   implements UndirectedGraph<V, E>
/*    */ {
/*    */   private static final long serialVersionUID = 3257001055819871795L;
/*    */   
/*    */   public Multigraph(Class<? extends E> edgeClass)
/*    */   {
/* 71 */     this(new ClassBasedEdgeFactory(edgeClass));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public Multigraph(EdgeFactory<V, E> ef)
/*    */   {
/* 81 */     super(ef, true, false);
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\Multigraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */