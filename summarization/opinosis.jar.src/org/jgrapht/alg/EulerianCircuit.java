/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.UndirectedGraph;
/*     */ import org.jgrapht.graph.UndirectedSubgraph;
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
/*     */ 
/*     */ 
/*     */ public abstract class EulerianCircuit
/*     */ {
/*     */   public static <V, E> boolean isEulerian(UndirectedGraph<V, E> g)
/*     */   {
/*  72 */     if (!new ConnectivityInspector(g).isGraphConnected()) {
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  78 */     Iterator<V> iter = g.vertexSet().iterator();
/*  79 */     while (iter.hasNext()) {
/*  80 */       V v = iter.next();
/*  81 */       if (g.degreeOf(v) % 2 == 1) {
/*  82 */         return false;
/*     */       }
/*     */     }
/*  85 */     return true;
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
/*     */   public static <V, E> List<V> getEulerianCircuitVertices(UndirectedGraph<V, E> g)
/*     */   {
/* 102 */     if (!isEulerian(g)) {
/* 103 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 107 */     List<V> path = new LinkedList();
/* 108 */     UndirectedGraph<V, E> sg = new UndirectedSubgraph(g, null, null);
/* 109 */     path.add(sg.vertexSet().iterator().next());
/*     */     V v;
/* 114 */     for (; 
/*     */         
/*     */ 
/* 114 */         sg.edgeSet().size() > 0; 
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
/* 129 */         sg.degreeOf(v) > 0)
/*     */     {
/* 115 */       v = null;
/*     */       
/*     */ 
/*     */ 
/* 119 */       int index = 0;
/* 120 */       for (Iterator<V> iter = path.iterator(); iter.hasNext(); index++) {
/* 121 */         v = iter.next();
/* 122 */         if (sg.degreeOf(v) > 0) {
/*     */           break;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 129 */       continue;
/*     */       
/* 131 */       Iterator<V> iter = sg.vertexSet().iterator();
/* 130 */       while (
/*     */       
/* 132 */         iter.hasNext())
/*     */       {
/* 134 */         V temp = iter.next();
/* 135 */         if (sg.containsEdge(v, temp)) {
/* 136 */           path.add(index, temp);
/* 137 */           sg.removeEdge(v, temp);
/* 138 */           v = temp;
/* 139 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 144 */     return path;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\EulerianCircuit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */