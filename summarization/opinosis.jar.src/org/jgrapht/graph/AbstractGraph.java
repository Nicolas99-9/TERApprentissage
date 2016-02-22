/*     */ package org.jgrapht.graph;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AbstractGraph<V, E>
/*     */   implements Graph<V, E>
/*     */ {
/*     */   public boolean containsEdge(V sourceVertex, V targetVertex)
/*     */   {
/*  79 */     return getEdge(sourceVertex, targetVertex) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeAllEdges(Collection<? extends E> edges)
/*     */   {
/*  87 */     boolean modified = false;
/*     */     
/*  89 */     for (E e : edges) {
/*  90 */       modified |= removeEdge(e);
/*     */     }
/*     */     
/*  93 */     return modified;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Set<E> removeAllEdges(V sourceVertex, V targetVertex)
/*     */   {
/* 101 */     Set<E> removed = getAllEdges(sourceVertex, targetVertex);
/* 102 */     removeAllEdges(removed);
/*     */     
/* 104 */     return removed;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean removeAllVertices(Collection<? extends V> vertices)
/*     */   {
/* 112 */     boolean modified = false;
/*     */     
/* 114 */     for (V v : vertices) {
/* 115 */       modified |= removeVertex(v);
/*     */     }
/*     */     
/* 118 */     return modified;
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
/* 131 */     return toStringFromSets(
/* 132 */       vertexSet(), 
/* 133 */       edgeSet(), 
/* 134 */       this instanceof DirectedGraph);
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
/*     */   protected boolean assertVertexExist(V v)
/*     */   {
/* 151 */     if (containsVertex(v))
/* 152 */       return true;
/* 153 */     if (v == null) {
/* 154 */       throw new NullPointerException();
/*     */     }
/* 156 */     throw new IllegalArgumentException("no such vertex in graph");
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
/*     */   protected boolean removeAllEdges(E[] edges)
/*     */   {
/* 175 */     boolean modified = false;
/*     */     
/* 177 */     for (int i = 0; i < edges.length; i++) {
/* 178 */       modified |= removeEdge(edges[i]);
/*     */     }
/*     */     
/* 181 */     return modified;
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
/*     */   protected String toStringFromSets(Collection<? extends V> vertexSet, Collection<? extends E> edgeSet, boolean directed)
/*     */   {
/* 199 */     List<String> renderedEdges = new ArrayList();
/*     */     
/* 201 */     StringBuffer sb = new StringBuffer();
/* 202 */     for (E e : edgeSet) {
/* 203 */       if ((e.getClass() != DefaultEdge.class) && 
/* 204 */         (e.getClass() != DefaultWeightedEdge.class))
/*     */       {
/* 206 */         sb.append(e.toString());
/* 207 */         sb.append("=");
/*     */       }
/* 209 */       if (directed) {
/* 210 */         sb.append("(");
/*     */       } else {
/* 212 */         sb.append("{");
/*     */       }
/* 214 */       sb.append(getEdgeSource(e));
/* 215 */       sb.append(",");
/* 216 */       sb.append(getEdgeTarget(e));
/* 217 */       if (directed) {
/* 218 */         sb.append(")");
/*     */       } else {
/* 220 */         sb.append("}");
/*     */       }
/*     */       
/*     */ 
/* 224 */       renderedEdges.add(sb.toString());
/* 225 */       sb.setLength(0);
/*     */     }
/*     */     
/* 228 */     return "(" + vertexSet + ", " + renderedEdges + ")";
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\AbstractGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */