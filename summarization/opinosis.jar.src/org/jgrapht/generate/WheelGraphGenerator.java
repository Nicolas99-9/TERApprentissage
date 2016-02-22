/*     */ package org.jgrapht.generate;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WheelGraphGenerator<V, E>
/*     */   implements GraphGenerator<V, E, V>
/*     */ {
/*     */   public static final String HUB_VERTEX = "Hub Vertex";
/*     */   private boolean inwardSpokes;
/*     */   private int size;
/*     */   
/*     */   public WheelGraphGenerator(int size)
/*     */   {
/*  83 */     this(size, true);
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
/*     */   public WheelGraphGenerator(int size, boolean inwardSpokes)
/*     */   {
/*  97 */     if (size < 0) {
/*  98 */       throw new IllegalArgumentException("must be non-negative");
/*     */     }
/*     */     
/* 101 */     this.size = size;
/* 102 */     this.inwardSpokes = inwardSpokes;
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
/*     */   public void generateGraph(Graph<V, E> target, final VertexFactory<V> vertexFactory, Map<String, V> resultMap)
/*     */   {
/* 115 */     if (this.size < 1) {
/* 116 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 122 */     final Collection<V> rim = new ArrayList();
/* 123 */     VertexFactory<V> rimVertexFactory = 
/* 124 */       new VertexFactory()
/*     */       {
/*     */         public V createVertex() {
/* 127 */           V vertex = vertexFactory.createVertex();
/* 128 */           rim.add(vertex);
/*     */           
/* 130 */           return vertex;
/*     */         }
/*     */         
/* 133 */       };
/* 134 */       RingGraphGenerator<V, E> ringGenerator = 
/* 135 */         new RingGraphGenerator(this.size - 1);
/* 136 */       ringGenerator.generateGraph(target, rimVertexFactory, resultMap);
/*     */       
/* 138 */       V hubVertex = vertexFactory.createVertex();
/* 139 */       target.addVertex(hubVertex);
/*     */       
/* 141 */       if (resultMap != null) {
/* 142 */         resultMap.put("Hub Vertex", hubVertex);
/*     */       }
/*     */       
/* 145 */       for (V rimVertex : rim) {
/* 146 */         if (this.inwardSpokes) {
/* 147 */           target.addEdge(rimVertex, hubVertex);
/*     */         } else {
/* 149 */           target.addEdge(hubVertex, rimVertex);
/*     */         }
/*     */       }
/*     */     }
/*     */   }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\generate\WheelGraphGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */