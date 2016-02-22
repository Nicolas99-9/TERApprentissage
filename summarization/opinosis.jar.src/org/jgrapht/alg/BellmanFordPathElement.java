/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import org.jgrapht.Graph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class BellmanFordPathElement<V, E>
/*     */   extends AbstractPathElement<V, E>
/*     */ {
/*  55 */   private double cost = 0.0D;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private double epsilon;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected BellmanFordPathElement(Graph<V, E> graph, BellmanFordPathElement<V, E> pathElement, E edge, double cost, double epsilon)
/*     */   {
/*  75 */     super(graph, pathElement, edge);
/*     */     
/*  77 */     this.cost = cost;
/*  78 */     this.epsilon = epsilon;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   BellmanFordPathElement(BellmanFordPathElement<V, E> original)
/*     */   {
/*  88 */     super(original);
/*  89 */     this.cost = original.cost;
/*  90 */     this.epsilon = original.epsilon;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected BellmanFordPathElement(V vertex, double epsilon)
/*     */   {
/* 101 */     super(vertex);
/*     */     
/* 103 */     this.cost = 0.0D;
/* 104 */     this.epsilon = epsilon;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getCost()
/*     */   {
/* 116 */     return this.cost;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean improve(BellmanFordPathElement<V, E> candidatePrevPathElement, E candidateEdge, double candidateCost)
/*     */   {
/* 137 */     if (candidateCost < getCost() - this.epsilon) {
/* 138 */       this.prevPathElement = candidatePrevPathElement;
/* 139 */       this.prevEdge = candidateEdge;
/* 140 */       this.cost = candidateCost;
/* 141 */       this.nHops = (candidatePrevPathElement.getHopCount() + 1);
/*     */       
/* 143 */       return true;
/*     */     }
/* 145 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\BellmanFordPathElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */