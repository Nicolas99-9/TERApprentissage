/*    */ package org.jgrapht.graph;
/*    */ 
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
/*    */ public class UndirectedMaskSubgraph<V, E>
/*    */   extends MaskSubgraph<V, E>
/*    */   implements UndirectedGraph<V, E>
/*    */ {
/*    */   public UndirectedMaskSubgraph(UndirectedGraph<V, E> base, MaskFunctor<V, E> mask)
/*    */   {
/* 60 */     super(base, mask);
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\UndirectedMaskSubgraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */