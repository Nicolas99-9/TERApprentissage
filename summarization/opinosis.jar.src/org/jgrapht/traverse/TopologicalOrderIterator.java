/*     */ package org.jgrapht.traverse;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import java.util.Queue;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.DirectedGraph;
/*     */ import org.jgrapht.util.ModifiableInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TopologicalOrderIterator<V, E>
/*     */   extends CrossComponentIterator<V, E, Object>
/*     */ {
/*     */   private Queue<V> queue;
/*     */   private Map<V, ModifiableInteger> inDegreeMap;
/*     */   
/*     */   public TopologicalOrderIterator(DirectedGraph<V, E> dg)
/*     */   {
/*  97 */     this(dg, new LinkedListQueue(null));
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
/*     */   public TopologicalOrderIterator(DirectedGraph<V, E> dg, Queue<V> queue)
/*     */   {
/* 115 */     this(dg, queue, new HashMap());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private TopologicalOrderIterator(DirectedGraph<V, E> dg, Queue<V> queue, Map<V, ModifiableInteger> inDegreeMap)
/*     */   {
/* 125 */     this(dg, initialize(dg, queue, inDegreeMap));
/* 126 */     this.queue = queue;
/* 127 */     this.inDegreeMap = inDegreeMap;
/*     */     
/* 129 */     if (!dg.vertexSet().isEmpty())
/*     */     {
/*     */ 
/* 132 */       assert (!queue.isEmpty());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private TopologicalOrderIterator(DirectedGraph<V, E> dg, V start)
/*     */   {
/* 140 */     super(dg, start);
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
/*     */   protected boolean isConnectedComponentExhausted()
/*     */   {
/* 155 */     return this.queue.isEmpty();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void encounterVertex(V vertex, E edge)
/*     */   {
/* 164 */     putSeenData(vertex, null);
/* 165 */     decrementInDegree(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void encounterVertexAgain(V vertex, E edge)
/*     */   {
/* 174 */     decrementInDegree(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected V provideNextVertex()
/*     */   {
/* 183 */     return (V)this.queue.remove();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void decrementInDegree(V vertex)
/*     */   {
/* 193 */     ModifiableInteger inDegree = (ModifiableInteger)this.inDegreeMap.get(vertex);
/*     */     
/* 195 */     if (inDegree.value > 0) {
/* 196 */       inDegree.value -= 1;
/*     */       
/* 198 */       if (inDegree.value == 0) {
/* 199 */         this.queue.offer(vertex);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   private static <V, E> V initialize(DirectedGraph<V, E> dg, Queue<V> queue, Map<V, ModifiableInteger> inDegreeMap)
/*     */   {
/* 220 */     for (Iterator<V> i = dg.vertexSet().iterator(); i.hasNext();) {
/* 221 */       V vertex = i.next();
/*     */       
/* 223 */       int inDegree = dg.inDegreeOf(vertex);
/* 224 */       inDegreeMap.put(vertex, new ModifiableInteger(inDegree));
/*     */       
/* 226 */       if (inDegree == 0) {
/* 227 */         queue.offer(vertex);
/*     */       }
/*     */     }
/*     */     
/* 231 */     if (queue.isEmpty()) {
/* 232 */       return null;
/*     */     }
/* 234 */     return (V)queue.peek();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static class LinkedListQueue<T>
/*     */     extends LinkedList<T>
/*     */     implements Queue<T>
/*     */   {
/*     */     private static final long serialVersionUID = 4217659843476891334L;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public T element()
/*     */     {
/* 253 */       return (T)getFirst();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean offer(T o)
/*     */     {
/* 259 */       return add(o);
/*     */     }
/*     */     
/*     */ 
/*     */     public T peek()
/*     */     {
/* 265 */       if (isEmpty()) {
/* 266 */         return null;
/*     */       }
/* 268 */       return (T)getFirst();
/*     */     }
/*     */     
/*     */ 
/*     */     public T poll()
/*     */     {
/* 274 */       if (isEmpty()) {
/* 275 */         return null;
/*     */       }
/* 277 */       return (T)removeFirst();
/*     */     }
/*     */     
/*     */ 
/*     */     public T remove()
/*     */     {
/* 283 */       return (T)removeFirst();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\traverse\TopologicalOrderIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */