/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
/*     */ import org.jgrapht.traverse.DepthFirstIterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CycleDetector<V, E>
/*     */ {
/*     */   DirectedGraph<V, E> graph;
/*     */   
/*     */   public CycleDetector(DirectedGraph<V, E> graph)
/*     */   {
/*  76 */     this.graph = graph;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean detectCycles()
/*     */   {
/*     */     try
/*     */     {
/*  89 */       execute(null, null);
/*     */     } catch (CycleDetectedException ex) {
/*  91 */       return true;
/*     */     }
/*     */     
/*  94 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean detectCyclesContainingVertex(V v)
/*     */   {
/*     */     try
/*     */     {
/* 107 */       execute(null, v);
/*     */     } catch (CycleDetectedException ex) {
/* 109 */       return true;
/*     */     }
/*     */     
/* 112 */     return false;
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
/*     */   public Set<V> findCycles()
/*     */   {
/* 125 */     StrongConnectivityInspector<V, E> inspector = 
/* 126 */       new StrongConnectivityInspector(this.graph);
/* 127 */     List<Set<V>> components = inspector.stronglyConnectedSets();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 133 */     Set<V> set = new HashSet();
/* 134 */     for (Set<V> component : components) {
/* 135 */       if (component.size() > 1)
/*     */       {
/* 137 */         set.addAll(component);
/*     */       } else {
/* 139 */         V v = component.iterator().next();
/* 140 */         if (this.graph.containsEdge(v, v))
/*     */         {
/* 142 */           set.add(v);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 147 */     return set;
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
/*     */   public Set<V> findCyclesContainingVertex(V v)
/*     */   {
/* 166 */     Set<V> set = new HashSet();
/* 167 */     execute(set, v);
/*     */     
/* 169 */     return set;
/*     */   }
/*     */   
/*     */   private void execute(Set<V> s, V v)
/*     */   {
/* 174 */     CycleDetector<V, E>.ProbeIterator iter = new ProbeIterator(s, v);
/*     */     
/* 176 */     while (iter.hasNext()) {
/* 177 */       iter.next();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static class CycleDetectedException
/*     */     extends RuntimeException
/*     */   {
/*     */     private static final long serialVersionUID = 3834305137802950712L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private class ProbeIterator
/*     */     extends DepthFirstIterator<V, E>
/*     */   {
/*     */     private List<V> path;
/*     */     
/*     */ 
/*     */     private Set<V> cycleSet;
/*     */     
/*     */ 
/*     */     private V root;
/*     */     
/*     */ 
/*     */ 
/*     */     ProbeIterator(V cycleSet)
/*     */     {
/* 206 */       super(startVertex);
/* 207 */       this.root = startVertex;
/* 208 */       this.cycleSet = cycleSet;
/* 209 */       this.path = new ArrayList();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     protected void encounterVertexAgain(V vertex, E edge)
/*     */     {
/* 218 */       super.encounterVertexAgain(vertex, edge);
/*     */       
/*     */       int i;
/*     */       
/* 222 */       if (this.root != null)
/*     */       {
/*     */         int i;
/*     */         
/* 226 */         if (vertex == this.root) {
/* 227 */           i = 0; } else { int i;
/* 228 */           if ((this.cycleSet != null) && (this.cycleSet.contains(vertex))) {
/* 229 */             i = 0;
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 234 */         i = this.path.indexOf(vertex);
/*     */       }
/*     */       
/* 237 */       if (i > -1) {
/* 238 */         if (this.cycleSet == null)
/*     */         {
/* 240 */           throw new CycleDetector.CycleDetectedException(null);
/*     */         }
/* 242 */         for (; i < this.path.size(); i++) {
/* 243 */           this.cycleSet.add(this.path.get(i));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     protected V provideNextVertex()
/*     */     {
/* 255 */       V v = super.provideNextVertex();
/*     */       
/*     */ 
/* 258 */       for (int i = this.path.size() - 1; i >= 0; i--) {
/* 259 */         if (CycleDetector.this.graph.containsEdge(this.path.get(i), v)) {
/*     */           break;
/*     */         }
/*     */         
/* 263 */         this.path.remove(i);
/*     */       }
/*     */       
/* 266 */       this.path.add(v);
/*     */       
/* 268 */       return v;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\CycleDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */