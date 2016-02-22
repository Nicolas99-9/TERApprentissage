/*    */ package org.jgrapht.graph;
/*    */ 
/*    */ import org.jgrapht.DirectedGraph;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ListenableDirectedGraph<V, E>
/*    */   extends DefaultListenableGraph<V, E>
/*    */   implements DirectedGraph<V, E>
/*    */ {
/*    */   private static final long serialVersionUID = 3257571698126368824L;
/*    */   
/*    */   public ListenableDirectedGraph(Class<? extends E> edgeClass)
/*    */   {
/* 69 */     this(new DefaultDirectedGraph(edgeClass));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public ListenableDirectedGraph(DirectedGraph<V, E> base)
/*    */   {
/* 79 */     super(base);
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\ListenableDirectedGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */