/*     */ package org.jgrapht.graph;
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
/*     */ public class DefaultWeightedEdge
/*     */   extends DefaultEdge
/*     */   implements Comparable
/*     */ {
/*     */   private static final long serialVersionUID = 229708706467350994L;
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
/*  61 */   double weight = 1.0D;
/*     */   
/*  63 */   long clusterID = -1L;
/*     */   
/*     */ 
/*     */   protected boolean isClassified()
/*     */   {
/*  68 */     if (this.clusterID == -1L) {
/*  69 */       return false;
/*     */     }
/*  71 */     return true;
/*     */   }
/*     */   
/*     */   protected void setClassified(long clusterID) {
/*  75 */     this.clusterID = clusterID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected double getWeight()
/*     */   {
/*  86 */     return this.weight;
/*     */   }
/*     */   
/*     */ 
/*     */   public int compareTo(Object o)
/*     */   {
/*  92 */     DefaultWeightedEdge e = (DefaultWeightedEdge)o;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  97 */     if (this.weight > e.getWeight()) {
/*  98 */       return -1;
/*     */     }
/*     */     
/*     */ 
/* 102 */     if (this.weight == e.getWeight()) {
/* 103 */       return 0;
/*     */     }
/*     */     
/* 106 */     return 1;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\DefaultWeightedEdge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */