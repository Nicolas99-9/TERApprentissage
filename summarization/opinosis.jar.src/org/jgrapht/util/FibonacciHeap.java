/*     */ package org.jgrapht.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Stack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FibonacciHeap<T>
/*     */ {
/*  84 */   private static final double oneOverLogPhi = 1.0D / Math.log((1.0D + Math.sqrt(5.0D)) / 2.0D);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private FibonacciHeapNode<T> minNode;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int nNodes;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isEmpty()
/*     */   {
/* 119 */     return this.minNode == null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void clear()
/*     */   {
/* 129 */     this.minNode = null;
/* 130 */     this.nNodes = 0;
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
/*     */   public void decreaseKey(FibonacciHeapNode<T> x, double k)
/*     */   {
/* 149 */     if (k > x.key) {
/* 150 */       throw new IllegalArgumentException(
/* 151 */         "decreaseKey() got larger key value");
/*     */     }
/*     */     
/* 154 */     x.key = k;
/*     */     
/* 156 */     FibonacciHeapNode<T> y = x.parent;
/*     */     
/* 158 */     if ((y != null) && (x.key < y.key)) {
/* 159 */       cut(x, y);
/* 160 */       cascadingCut(y);
/*     */     }
/*     */     
/* 163 */     if (x.key < this.minNode.key) {
/* 164 */       this.minNode = x;
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
/*     */   public void delete(FibonacciHeapNode<T> x)
/*     */   {
/* 183 */     decreaseKey(x, Double.NEGATIVE_INFINITY);
/*     */     
/*     */ 
/* 186 */     removeMin();
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
/*     */   public void insert(FibonacciHeapNode<T> node, double key)
/*     */   {
/* 203 */     node.key = key;
/*     */     
/*     */ 
/* 206 */     if (this.minNode != null) {
/* 207 */       node.left = this.minNode;
/* 208 */       node.right = this.minNode.right;
/* 209 */       this.minNode.right = node;
/* 210 */       node.right.left = node;
/*     */       
/* 212 */       if (key < this.minNode.key) {
/* 213 */         this.minNode = node;
/*     */       }
/*     */     } else {
/* 216 */       this.minNode = node;
/*     */     }
/*     */     
/* 219 */     this.nNodes += 1;
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
/*     */   public FibonacciHeapNode<T> min()
/*     */   {
/* 234 */     return this.minNode;
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
/*     */   public FibonacciHeapNode<T> removeMin()
/*     */   {
/* 249 */     FibonacciHeapNode<T> z = this.minNode;
/*     */     
/* 251 */     if (z != null) {
/* 252 */       int numKids = z.degree;
/* 253 */       FibonacciHeapNode<T> x = z.child;
/*     */       
/*     */ 
/*     */ 
/* 257 */       while (numKids > 0) {
/* 258 */         FibonacciHeapNode<T> tempRight = x.right;
/*     */         
/*     */ 
/* 261 */         x.left.right = x.right;
/* 262 */         x.right.left = x.left;
/*     */         
/*     */ 
/* 265 */         x.left = this.minNode;
/* 266 */         x.right = this.minNode.right;
/* 267 */         this.minNode.right = x;
/* 268 */         x.right.left = x;
/*     */         
/*     */ 
/* 271 */         x.parent = null;
/* 272 */         x = tempRight;
/* 273 */         numKids--;
/*     */       }
/*     */       
/*     */ 
/* 277 */       z.left.right = z.right;
/* 278 */       z.right.left = z.left;
/*     */       
/* 280 */       if (z == z.right) {
/* 281 */         this.minNode = null;
/*     */       } else {
/* 283 */         this.minNode = z.right;
/* 284 */         consolidate();
/*     */       }
/*     */       
/*     */ 
/* 288 */       this.nNodes -= 1;
/*     */     }
/*     */     
/* 291 */     return z;
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
/*     */   public int size()
/*     */   {
/* 306 */     return this.nNodes;
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
/*     */   public static <T> FibonacciHeap<T> union(FibonacciHeap<T> h1, FibonacciHeap<T> h2)
/*     */   {
/* 326 */     FibonacciHeap<T> h = new FibonacciHeap();
/*     */     
/* 328 */     if ((h1 != null) && (h2 != null)) {
/* 329 */       h.minNode = h1.minNode;
/*     */       
/* 331 */       if (h.minNode != null) {
/* 332 */         if (h2.minNode != null) {
/* 333 */           h.minNode.right.left = h2.minNode.left;
/* 334 */           h2.minNode.left.right = h.minNode.right;
/* 335 */           h.minNode.right = h2.minNode;
/* 336 */           h2.minNode.left = h.minNode;
/*     */           
/* 338 */           if (h2.minNode.key < h1.minNode.key) {
/* 339 */             h.minNode = h2.minNode;
/*     */           }
/*     */         }
/*     */       } else {
/* 343 */         h.minNode = h2.minNode;
/*     */       }
/*     */       
/* 346 */       h1.nNodes += h2.nNodes;
/*     */     }
/*     */     
/* 349 */     return h;
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
/* 362 */     if (this.minNode == null) {
/* 363 */       return "FibonacciHeap=[]";
/*     */     }
/*     */     
/*     */ 
/* 367 */     Stack<FibonacciHeapNode<T>> stack = new Stack();
/* 368 */     stack.push(this.minNode);
/*     */     
/* 370 */     StringBuffer buf = new StringBuffer(512);
/* 371 */     buf.append("FibonacciHeap=[");
/*     */     FibonacciHeapNode<T> curr;
/*     */     FibonacciHeapNode<T> start;
/* 374 */     for (; !stack.empty(); 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 386 */         curr != start)
/*     */     {
/* 375 */       curr = (FibonacciHeapNode)stack.pop();
/* 376 */       buf.append(curr);
/* 377 */       buf.append(", ");
/*     */       
/* 379 */       if (curr.child != null) {
/* 380 */         stack.push(curr.child);
/*     */       }
/*     */       
/* 383 */       start = curr;
/* 384 */       curr = curr.right;
/*     */       
/* 386 */       continue;
/* 387 */       buf.append(curr);
/* 388 */       buf.append(", ");
/*     */       
/* 390 */       if (curr.child != null) {
/* 391 */         stack.push(curr.child);
/*     */       }
/*     */       
/* 394 */       curr = curr.right;
/*     */     }
/*     */     
/*     */ 
/* 398 */     buf.append(']');
/*     */     
/* 400 */     return buf.toString();
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
/*     */   protected void cascadingCut(FibonacciHeapNode<T> y)
/*     */   {
/* 415 */     FibonacciHeapNode<T> z = y.parent;
/*     */     
/*     */ 
/* 418 */     if (z != null)
/*     */     {
/* 420 */       if (!y.mark) {
/* 421 */         y.mark = true;
/*     */       }
/*     */       else {
/* 424 */         cut(y, z);
/*     */         
/*     */ 
/* 427 */         cascadingCut(z);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void consolidate()
/*     */   {
/* 436 */     int arraySize = 
/* 437 */       (int)Math.floor(Math.log(this.nNodes) * oneOverLogPhi) + 1;
/*     */     
/* 439 */     List<FibonacciHeapNode<T>> array = 
/* 440 */       new ArrayList(arraySize);
/*     */     
/*     */ 
/* 443 */     for (int i = 0; i < arraySize; i++) {
/* 444 */       array.add(null);
/*     */     }
/*     */     
/*     */ 
/* 448 */     int numRoots = 0;
/* 449 */     FibonacciHeapNode<T> x = this.minNode;
/*     */     
/* 451 */     if (x != null) {
/* 452 */       numRoots++;
/* 453 */       x = x.right;
/*     */       
/* 455 */       while (x != this.minNode) {
/* 456 */         numRoots++;
/* 457 */         x = x.right;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 462 */     while (numRoots > 0)
/*     */     {
/* 464 */       int d = x.degree;
/* 465 */       FibonacciHeapNode<T> next = x.right;
/*     */       
/*     */       for (;;)
/*     */       {
/* 469 */         FibonacciHeapNode<T> y = (FibonacciHeapNode)array.get(d);
/* 470 */         if (y == null) {
/*     */           break;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 477 */         if (x.key > y.key) {
/* 478 */           FibonacciHeapNode<T> temp = y;
/* 479 */           y = x;
/* 480 */           x = temp;
/*     */         }
/*     */         
/*     */ 
/* 484 */         link(y, x);
/*     */         
/*     */ 
/* 487 */         array.set(d, null);
/* 488 */         d++;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 493 */       array.set(d, x);
/*     */       
/*     */ 
/* 496 */       x = next;
/* 497 */       numRoots--;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 502 */     this.minNode = null;
/*     */     
/* 504 */     for (int i = 0; i < arraySize; i++) {
/* 505 */       FibonacciHeapNode<T> y = (FibonacciHeapNode)array.get(i);
/* 506 */       if (y != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 511 */         if (this.minNode != null)
/*     */         {
/* 513 */           y.left.right = y.right;
/* 514 */           y.right.left = y.left;
/*     */           
/*     */ 
/* 517 */           y.left = this.minNode;
/* 518 */           y.right = this.minNode.right;
/* 519 */           this.minNode.right = y;
/* 520 */           y.right.left = y;
/*     */           
/*     */ 
/* 523 */           if (y.key < this.minNode.key) {
/* 524 */             this.minNode = y;
/*     */           }
/*     */         } else {
/* 527 */           this.minNode = y;
/*     */         }
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
/*     */   protected void cut(FibonacciHeapNode<T> x, FibonacciHeapNode<T> y)
/*     */   {
/* 546 */     x.left.right = x.right;
/* 547 */     x.right.left = x.left;
/* 548 */     y.degree -= 1;
/*     */     
/*     */ 
/* 551 */     if (y.child == x) {
/* 552 */       y.child = x.right;
/*     */     }
/*     */     
/* 555 */     if (y.degree == 0) {
/* 556 */       y.child = null;
/*     */     }
/*     */     
/*     */ 
/* 560 */     x.left = this.minNode;
/* 561 */     x.right = this.minNode.right;
/* 562 */     this.minNode.right = x;
/* 563 */     x.right.left = x;
/*     */     
/*     */ 
/* 566 */     x.parent = null;
/*     */     
/*     */ 
/* 569 */     x.mark = false;
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
/*     */   protected void link(FibonacciHeapNode<T> y, FibonacciHeapNode<T> x)
/*     */   {
/* 585 */     y.left.right = y.right;
/* 586 */     y.right.left = y.left;
/*     */     
/*     */ 
/* 589 */     y.parent = x;
/*     */     
/* 591 */     if (x.child == null) {
/* 592 */       x.child = y;
/* 593 */       y.right = y;
/* 594 */       y.left = y;
/*     */     } else {
/* 596 */       y.left = x.child;
/* 597 */       y.right = x.child.right;
/* 598 */       x.child.right = y;
/* 599 */       y.right.left = y;
/*     */     }
/*     */     
/*     */ 
/* 603 */     x.degree += 1;
/*     */     
/*     */ 
/* 606 */     y.mark = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\util\FibonacciHeap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */