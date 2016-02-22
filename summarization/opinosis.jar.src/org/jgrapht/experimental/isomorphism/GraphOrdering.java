/*     */ package org.jgrapht.experimental.isomorphism;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.UndirectedGraph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GraphOrdering<V, E>
/*     */ {
/*     */   private Map<V, Integer> mapVertexToOrder;
/*     */   private Set<GraphOrdering<V, E>.LabelsEdge> labelsEdgesSet;
/*     */   
/*     */   public GraphOrdering(Graph<V, E> regularGraph)
/*     */   {
/*  83 */     this(regularGraph, regularGraph.vertexSet(), regularGraph.edgeSet());
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
/*     */   public GraphOrdering(Graph<V, E> regularGraph, Set<V> vertexSet, Set<E> edgeSet)
/*     */   {
/* 100 */     init(regularGraph, vertexSet, edgeSet);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void init(Graph<V, E> g, Set<V> vertexSet, Set<E> edgeSet)
/*     */   {
/* 110 */     this.mapVertexToOrder = new HashMap(vertexSet.size());
/*     */     
/* 112 */     int counter = 0;
/* 113 */     for (V vertex : vertexSet) {
/* 114 */       this.mapVertexToOrder.put(vertex, new Integer(counter));
/* 115 */       counter++;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 124 */     this.labelsEdgesSet = new HashSet(edgeSet.size());
/* 125 */     for (E edge : edgeSet) {
/* 126 */       V sourceVertex = g.getEdgeSource(edge);
/* 127 */       Integer sourceOrder = (Integer)this.mapVertexToOrder.get(sourceVertex);
/* 128 */       int sourceLabel = sourceOrder.intValue();
/* 129 */       int targetLabel = 
/* 130 */         ((Integer)this.mapVertexToOrder.get(g.getEdgeTarget(edge))).intValue();
/*     */       
/* 132 */       GraphOrdering<V, E>.LabelsEdge lablesEdge = new LabelsEdge(sourceLabel, targetLabel);
/* 133 */       this.labelsEdgesSet.add(lablesEdge);
/*     */       
/* 135 */       if ((g instanceof UndirectedGraph)) {
/* 136 */         GraphOrdering<V, E>.LabelsEdge oppositeEdge = 
/* 137 */           new LabelsEdge(targetLabel, sourceLabel);
/* 138 */         this.labelsEdgesSet.add(oppositeEdge);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean equalsByEdgeOrder(GraphOrdering otherGraph)
/*     */   {
/* 148 */     boolean result = 
/* 149 */       getLabelsEdgesSet().equals(otherGraph.getLabelsEdgesSet());
/*     */     
/* 151 */     return result;
/*     */   }
/*     */   
/*     */   public Set<GraphOrdering<V, E>.LabelsEdge> getLabelsEdgesSet()
/*     */   {
/* 156 */     return this.labelsEdgesSet;
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
/*     */   public String toString()
/*     */   {
/* 169 */     StringBuffer sb = new StringBuffer();
/* 170 */     sb.append("mapVertexToOrder=");
/*     */     
/*     */ 
/* 173 */     Object[] vertexArray = new Object[this.mapVertexToOrder.size()];
/* 174 */     Set<V> keySet = this.mapVertexToOrder.keySet();
/* 175 */     for (V currVertex : keySet) {
/* 176 */       Integer index = (Integer)this.mapVertexToOrder.get(currVertex);
/* 177 */       vertexArray[index.intValue()] = currVertex;
/*     */     }
/* 179 */     sb.append(Arrays.toString(vertexArray));
/* 180 */     sb.append("labelsOrder=").append(this.labelsEdgesSet.toString());
/* 181 */     return sb.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   private class LabelsEdge
/*     */   {
/*     */     private int source;
/*     */     
/*     */     private int target;
/*     */     private int hashCode;
/*     */     
/*     */     public LabelsEdge(int aSource, int aTarget)
/*     */     {
/* 194 */       this.source = aSource;
/* 195 */       this.target = aTarget;
/* 196 */       this.hashCode = 
/* 197 */         new String(this.source + this.target).hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 209 */       GraphOrdering<V, E>.LabelsEdge otherEdge = (LabelsEdge)obj;
/* 210 */       if ((this.source == otherEdge.source) && 
/* 211 */         (this.target == otherEdge.target))
/*     */       {
/* 213 */         return true;
/*     */       }
/* 215 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 225 */       return this.hashCode;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 231 */       return this.source + "->" + this.target;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\isomorphism\GraphOrdering.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */