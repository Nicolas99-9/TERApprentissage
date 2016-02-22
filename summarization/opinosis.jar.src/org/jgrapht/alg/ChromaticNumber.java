/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.UndirectedGraph;
/*     */ import org.jgrapht.alg.util.VertexDegreeComparator;
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
/*     */ 
/*     */ public abstract class ChromaticNumber
/*     */ {
/*     */   public static <V, E> int findGreedyChromaticNumber(UndirectedGraph<V, E> g)
/*     */   {
/*  76 */     UndirectedGraph<V, E> sg = new UndirectedSubgraph(g, null, null);
/*     */     
/*     */ 
/*     */ 
/*  80 */     VertexDegreeComparator<V, E> comp = 
/*  81 */       new VertexDegreeComparator(sg);
/*  82 */     List<V> sortedVertices = new LinkedList(sg.vertexSet());
/*  83 */     Collections.sort(sortedVertices, comp);
/*  84 */     Collections.reverse(sortedVertices);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  91 */     for (int color = 0; sg.vertexSet().size() > 0; color++)
/*     */     {
/*     */ 
/*  94 */       Set<V> currentColor = new HashSet();
/*     */       
/*  96 */       Iterator<V> iter = sortedVertices.iterator();
/*  95 */       while (
/*     */       
/*  97 */         iter.hasNext())
/*     */       {
/*  99 */         V v = iter.next();
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 104 */         boolean flag = true;
/*     */         
/* 106 */         Iterator<V> innerIter = currentColor.iterator();
/* 105 */         while (
/*     */         
/* 107 */           innerIter.hasNext())
/*     */         {
/* 109 */           V temp = innerIter.next();
/* 110 */           if (sg.containsEdge(temp, v)) {
/* 111 */             flag = false;
/* 112 */             break;
/*     */           }
/*     */         }
/* 115 */         if (flag) {
/* 116 */           currentColor.add(v);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 122 */       sg.removeAllVertices(currentColor);
/*     */     }
/* 124 */     return color;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\ChromaticNumber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */