/*     */ package org.jgrapht.experimental.isomorphism;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.GraphMapping;
/*     */ import org.jgrapht.graph.DefaultGraphMapping;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IsomorphismRelation<V, E>
/*     */   implements GraphMapping<V, E>
/*     */ {
/*     */   private List<V> vertexList1;
/*     */   private List<V> vertexList2;
/*  73 */   private GraphMapping<V, E> graphMapping = null;
/*     */   
/*     */ 
/*     */ 
/*     */   private Graph<V, E> graph1;
/*     */   
/*     */ 
/*     */ 
/*     */   private Graph<V, E> graph2;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public IsomorphismRelation(List<V> aGraph1vertexArray, List<V> aGraph2vertexArray, Graph<V, E> g1, Graph<V, E> g2)
/*     */   {
/*  88 */     this.vertexList1 = aGraph1vertexArray;
/*  89 */     this.vertexList2 = aGraph2vertexArray;
/*  90 */     this.graph1 = g1;
/*  91 */     this.graph2 = g2;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String toString()
/*     */   {
/*  99 */     StringBuffer sb = new StringBuffer();
/* 100 */     sb.append("vertexList1: ").append(
/* 101 */       this.vertexList1.toString());
/* 102 */     sb.append("\tvertexList2: ").append(
/* 103 */       this.vertexList2.toString());
/* 104 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public V getVertexCorrespondence(V vertex, boolean forward)
/*     */   {
/* 110 */     if (this.graphMapping == null) {
/* 111 */       initGraphMapping();
/*     */     }
/*     */     
/* 114 */     return (V)this.graphMapping.getVertexCorrespondence(vertex, forward);
/*     */   }
/*     */   
/*     */ 
/*     */   public E getEdgeCorrespondence(E edge, boolean forward)
/*     */   {
/* 120 */     if (this.graphMapping == null) {
/* 121 */       initGraphMapping();
/*     */     }
/*     */     
/* 124 */     return (E)this.graphMapping.getEdgeCorrespondence(edge, forward);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initGraphMapping()
/*     */   {
/* 133 */     int mapSize = this.vertexList1.size();
/* 134 */     Map<V, V> g1ToG2 = new HashMap(mapSize);
/* 135 */     Map<V, V> g2ToG1 = new HashMap(mapSize);
/*     */     
/* 137 */     for (int i = 0; i < mapSize; i++) {
/* 138 */       V source = this.vertexList1.get(i);
/* 139 */       V target = this.vertexList2.get(i);
/* 140 */       g1ToG2.put(source, target);
/* 141 */       g2ToG1.put(target, source);
/*     */     }
/* 143 */     this.graphMapping = 
/* 144 */       new DefaultGraphMapping(
/* 145 */       g1ToG2, 
/* 146 */       g2ToG1, 
/* 147 */       this.graph1, 
/* 148 */       this.graph2);
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\isomorphism\IsomorphismRelation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */