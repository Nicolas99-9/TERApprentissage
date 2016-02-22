/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
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
/*     */ public class FloydWarshallShortestPaths<V, E>
/*     */ {
/*  57 */   int nextIndex = 0;
/*     */   
/*     */ 
/*     */ 
/*     */   HashMap<V, Integer> indices;
/*     */   
/*     */ 
/*     */   double[][] d;
/*     */   
/*     */ 
/*     */   double diameter;
/*     */   
/*     */ 
/*     */ 
/*     */   public FloydWarshallShortestPaths(Graph<V, E> g)
/*     */   {
/*  73 */     int sz = g.vertexSet().size();
/*  74 */     this.d = new double[sz][sz];
/*  75 */     this.indices = new HashMap();
/*     */     Iterator localIterator2;
/*     */     V v2;
/*     */     E e;
/*  79 */     for (Iterator localIterator1 = g.vertexSet().iterator(); localIterator1.hasNext(); 
/*  80 */         localIterator2.hasNext())
/*     */     {
/*  79 */       V v1 = (Object)localIterator1.next();
/*  80 */       localIterator2 = g.vertexSet().iterator(); continue;v2 = (Object)localIterator2.next();
/*  81 */       if (v1 == v2) {
/*  82 */         this.d[index(v1)][index(v2)] = 0.0D;
/*     */       } else {
/*  84 */         e = g.getEdge(v1, v2);
/*     */         
/*  86 */         if (e == null) {
/*  87 */           this.d[index(v1)][index(v2)] = Double.POSITIVE_INFINITY;
/*     */         } else {
/*  89 */           this.d[index(v1)][index(v2)] = g.getEdgeWeight(e);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  96 */     for (int k = 0; k < sz; k++) {
/*  97 */       for (v2 = g.vertexSet().iterator(); v2.hasNext(); 
/*  98 */           e.hasNext())
/*     */       {
/*  97 */         Object v1 = (Object)v2.next();
/*  98 */         e = g.vertexSet().iterator(); continue;Object v2 = (Object)e.next();
/*  99 */         this.d[index(v1)][index(v2)] = 
/* 100 */           Math.min(
/* 101 */           this.d[index(v1)][index(v2)], 
/* 102 */           this.d[index(v1)][k] + this.d[k][index(v2)]);
/* 103 */         this.diameter = Math.max(this.diameter, this.d[index(v1)][index(v2)]);
/*     */       }
/*     */     }
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
/*     */   public double shortestDistance(V v1, V v2)
/*     */   {
/* 121 */     return this.d[index(v1)][index(v2)];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public double getDiameter()
/*     */   {
/* 129 */     return this.diameter;
/*     */   }
/*     */   
/*     */   private int index(V vertex)
/*     */   {
/* 134 */     Integer index = (Integer)this.indices.get(vertex);
/* 135 */     if (index == null) {
/* 136 */       this.indices.put(vertex, Integer.valueOf(this.nextIndex));
/* 137 */       index = Integer.valueOf(this.nextIndex++);
/*     */     }
/* 139 */     return index.intValue();
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\FloydWarshallShortestPaths.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */