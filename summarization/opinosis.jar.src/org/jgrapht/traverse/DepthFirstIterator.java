/*     */ package org.jgrapht.traverse;
/*     */ 
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Deque;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.util.TypeUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DepthFirstIterator<V, E>
/*     */   extends CrossComponentIterator<V, E, CrossComponentIterator.VisitColor>
/*     */ {
/*  77 */   public static final Object SENTINEL = new Object();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */   private Deque<Object> stack = new ArrayDeque();
/*     */   
/*  86 */   private transient TypeUtil<V> vertexTypeDecl = null;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public DepthFirstIterator(Graph<V, E> g)
/*     */   {
/*  97 */     this(g, null);
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
/*     */   public DepthFirstIterator(Graph<V, E> g, V startVertex)
/*     */   {
/* 112 */     super(g, startVertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean isConnectedComponentExhausted()
/*     */   {
/*     */     for (;;)
/*     */     {
/* 124 */       if (this.stack.isEmpty()) {
/* 125 */         return true;
/*     */       }
/* 127 */       if (this.stack.getLast() != SENTINEL)
/*     */       {
/* 129 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 136 */       this.stack.removeLast();
/*     */       
/*     */ 
/* 139 */       recordFinish();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void encounterVertex(V vertex, E edge)
/*     */   {
/* 149 */     putSeenData(vertex, CrossComponentIterator.VisitColor.WHITE);
/* 150 */     this.stack.addLast(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void encounterVertexAgain(V vertex, E edge)
/*     */   {
/* 159 */     CrossComponentIterator.VisitColor color = (CrossComponentIterator.VisitColor)getSeenData(vertex);
/* 160 */     if (color != CrossComponentIterator.VisitColor.WHITE)
/*     */     {
/*     */ 
/*     */ 
/* 164 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 172 */     boolean found = this.stack.removeLastOccurrence(vertex);
/* 173 */     assert (found);
/* 174 */     this.stack.addLast(vertex);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected V provideNextVertex()
/*     */   {
/*     */     Object o;
/*     */     
/*     */     for (;;)
/*     */     {
/* 185 */       o = this.stack.removeLast();
/* 186 */       if (o != SENTINEL)
/*     */         break;
/* 188 */       recordFinish();
/*     */     }
/*     */     
/*     */ 
/* 192 */     V v = TypeUtil.uncheckedCast(o, this.vertexTypeDecl);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 199 */     this.stack.addLast(v);
/* 200 */     this.stack.addLast(SENTINEL);
/* 201 */     putSeenData(v, CrossComponentIterator.VisitColor.GRAY);
/* 202 */     return v;
/*     */   }
/*     */   
/*     */   private void recordFinish()
/*     */   {
/* 207 */     V v = TypeUtil.uncheckedCast(this.stack.removeLast(), this.vertexTypeDecl);
/* 208 */     putSeenData(v, CrossComponentIterator.VisitColor.BLACK);
/* 209 */     finishVertex(v);
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
/*     */   public Deque<Object> getStack()
/*     */   {
/* 223 */     return this.stack;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\traverse\DepthFirstIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */