/*     */ package org.jgrapht.graph;
/*     */ 
/*     */ import java.util.Set;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ParanoidGraph<V, E>
/*     */   extends GraphDelegator<V, E>
/*     */ {
/*     */   private static final long serialVersionUID = 5075284167422166539L;
/*     */   
/*     */   public ParanoidGraph(Graph<V, E> g)
/*     */   {
/*  69 */     super(g);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addEdge(V sourceVertex, V targetVertex, E e)
/*     */   {
/*  80 */     verifyAdd(edgeSet(), e);
/*  81 */     return super.addEdge(sourceVertex, targetVertex, e);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addVertex(V v)
/*     */   {
/*  90 */     verifyAdd(vertexSet(), v);
/*  91 */     return super.addVertex(v);
/*     */   }
/*     */   
/*     */   private static <T> void verifyAdd(Set<T> set, T t)
/*     */   {
/*  96 */     for (T o : set) {
/*  97 */       if (o != t)
/*     */       {
/*     */ 
/* 100 */         if ((o.equals(t)) && (o.hashCode() != t.hashCode())) {
/* 101 */           throw new IllegalArgumentException(
/* 102 */             "ParanoidGraph detected objects o1 (hashCode=" + 
/* 103 */             o.hashCode() + 
/* 104 */             ") and o2 (hashCode=" + t.hashCode() + 
/* 105 */             ") where o1.equals(o2) " + 
/* 106 */             "but o1.hashCode() != o2.hashCode()");
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\ParanoidGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */