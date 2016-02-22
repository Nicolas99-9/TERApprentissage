/*    */ package org.jgrapht.graph;
/*    */ 
/*    */ import java.io.Serializable;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AsUnweightedDirectedGraph<V, E>
/*    */   extends GraphDelegator<V, E>
/*    */   implements Serializable, DirectedGraph<V, E>
/*    */ {
/*    */   private static final long serialVersionUID = -4320818446777715312L;
/*    */   
/*    */   public AsUnweightedDirectedGraph(DirectedGraph<V, E> g)
/*    */   {
/* 86 */     super(g);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public double getEdgeWeight(E e)
/*    */   {
/* 97 */     return 1.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\AsUnweightedDirectedGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */