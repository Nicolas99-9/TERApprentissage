/*     */ package org.jgrapht.generate;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.VertexFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScaleFreeGraphGenerator<V, E>
/*     */   implements GraphGenerator<V, E, V>
/*     */ {
/*     */   private int size;
/*     */   private long seed;
/*     */   private Random random;
/*     */   
/*     */   public ScaleFreeGraphGenerator(int size)
/*     */   {
/*  73 */     if (size < 0) {
/*  74 */       throw new IllegalArgumentException(
/*  75 */         "invalid size: " + size + " (must be non-negative)");
/*     */     }
/*  77 */     this.size = size;
/*  78 */     this.random = new Random();
/*  79 */     this.seed = this.random.nextLong();
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
/*     */   public ScaleFreeGraphGenerator(int size, long seed)
/*     */   {
/*  93 */     if (size < 0) {
/*  94 */       throw new IllegalArgumentException(
/*  95 */         "invalid size: " + size + " (must be non-negative)");
/*     */     }
/*  97 */     this.size = size;
/*  98 */     this.random = new Random();
/*  99 */     this.seed = seed;
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
/*     */ 
/*     */   public void generateGraph(Graph<V, E> target, VertexFactory<V> vertexFactory, Map<String, V> resultMap)
/*     */   {
/* 121 */     this.random.setSeed(this.seed);
/* 122 */     List<V> vertexList = new ArrayList();
/* 123 */     List<Integer> degrees = new ArrayList();
/* 124 */     int degreeSum = 0;
/* 125 */     for (int i = 0; i < this.size; i++) {
/* 126 */       V newVertex = vertexFactory.createVertex();
/* 127 */       target.addVertex(newVertex);
/* 128 */       int newDegree = 0;
/* 129 */       int j; for (; (newDegree == 0) && (i != 0); 
/*     */           
/*     */ 
/*     */ 
/* 133 */           j < vertexList.size()) { j = 0; continue;
/* 134 */         if ((degreeSum == 0) || 
/* 135 */           (this.random.nextInt(degreeSum) < ((Integer)degrees.get(j)).intValue()))
/*     */         {
/* 137 */           degrees.set(j, Integer.valueOf(((Integer)degrees.get(j)).intValue() + 1));
/* 138 */           newDegree++;
/* 139 */           degreeSum += 2;
/* 140 */           if (this.random.nextInt(2) == 0) {
/* 141 */             target.addEdge(vertexList.get(j), newVertex);
/*     */           } else {
/* 143 */             target.addEdge(newVertex, vertexList.get(j));
/*     */           }
/*     */         }
/* 133 */         j++;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 148 */       vertexList.add(newVertex);
/* 149 */       degrees.add(Integer.valueOf(newDegree));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\generate\ScaleFreeGraphGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */