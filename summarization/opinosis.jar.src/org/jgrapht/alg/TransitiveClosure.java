/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.graph.SimpleDirectedGraph;
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
/*     */ public class TransitiveClosure
/*     */ {
/*  58 */   public static final TransitiveClosure INSTANCE = new TransitiveClosure();
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
/*     */   public <V, E> void closeSimpleDirectedGraph(SimpleDirectedGraph<V, E> graph)
/*     */   {
/*  78 */     Set<V> vertexSet = graph.vertexSet();
/*     */     
/*  80 */     Set<V> newEdgeTargets = new HashSet();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  87 */     int bound = computeBinaryLog(vertexSet.size());
/*  88 */     boolean done = false;
/*  89 */     for (int i = 0; (!done) && (i < bound); i++) {
/*  90 */       done = true;
/*  91 */       Iterator localIterator2; for (Iterator localIterator1 = vertexSet.iterator(); localIterator1.hasNext(); 
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
/* 114 */           localIterator2.hasNext())
/*     */       {
/*  91 */         V v1 = (Object)localIterator1.next();
/*  92 */         newEdgeTargets.clear();
/*     */         Iterator localIterator3;
/*  94 */         for (localIterator2 = graph.outgoingEdgesOf(v1).iterator(); localIterator2.hasNext(); 
/*     */             
/*  96 */             localIterator3.hasNext())
/*     */         {
/*  94 */           E v1OutEdge = (Object)localIterator2.next();
/*  95 */           V v2 = graph.getEdgeTarget(v1OutEdge);
/*  96 */           localIterator3 = graph.outgoingEdgesOf(v2).iterator(); continue;E v2OutEdge = (Object)localIterator3.next();
/*  97 */           V v3 = graph.getEdgeTarget(v2OutEdge);
/*     */           
/*  99 */           if (!v1.equals(v3))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/* 104 */             if (graph.getEdge(v1, v3) == null)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/* 109 */               newEdgeTargets.add(v3);
/* 110 */               done = false;
/*     */             }
/*     */           }
/*     */         }
/* 114 */         localIterator2 = newEdgeTargets.iterator(); continue;V v3 = (Object)localIterator2.next();
/* 115 */         graph.addEdge(v1, v3);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int computeBinaryLog(int n)
/*     */   {
/* 126 */     assert (n >= 0);
/*     */     
/* 128 */     int result = 0;
/* 129 */     while (n > 0) {
/* 130 */       n >>= 1;
/* 131 */       result++;
/*     */     }
/*     */     
/* 134 */     return result;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\TransitiveClosure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */