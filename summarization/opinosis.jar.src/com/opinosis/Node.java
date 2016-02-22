/*     */ package com.opinosis;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Node
/*     */ {
/*  18 */   private List<Integer> docIds = new ArrayList();
/*     */   
/*     */ 
/*  21 */   private String nodeName = "-1";
/*  22 */   private List<int[]> sentenceIds = new ArrayList();
/*  23 */   static HashSet<Integer> sentences = new HashSet();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  29 */   public int getTotalSentences() { return sentences.size(); }
/*     */   
/*  31 */   private static int TOTAL_TOKENS = 0;
/*  32 */   private int nodeCount = 0;
/*     */   
/*  34 */   private int minPos = -1;
/*     */   
/*  36 */   private int avgPos = 0;
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getDocIds()
/*     */   {
/*  42 */     return this.docIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<int[]> getSentenceIds()
/*     */   {
/*  49 */     return this.sentenceIds;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getNodeName()
/*     */   {
/*  56 */     return this.nodeName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void addDocId(int docId)
/*     */   {
/*  63 */     this.docIds.add(Integer.valueOf(docId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void addSentenceId(int sentenceId, int pos)
/*     */   {
/*  70 */     TOTAL_TOKENS += 1;
/*  71 */     this.nodeCount += 1;
/*  72 */     int[] k = new int[2];
/*  73 */     k[0] = sentenceId;
/*  74 */     k[1] = pos;
/*     */     
/*  76 */     sentences.add(Integer.valueOf(sentenceId));
/*  77 */     this.sentenceIds.add(k);
/*     */     
/*     */ 
/*  80 */     if (pos < this.minPos) {
/*  81 */       this.minPos = pos;
/*     */     }
/*  83 */     this.avgPos += pos;
/*     */   }
/*     */   
/*     */   public double getMinPos() {
/*  87 */     return this.minPos;
/*     */   }
/*     */   
/*     */   public double getAveragePos() {
/*  91 */     return this.avgPos / this.sentenceIds.size();
/*     */   }
/*     */   
/*     */   public double getNodeCount() {
/*  95 */     return this.nodeCount + 0.01D;
/*     */   }
/*     */   
/*     */   public static double getTotalNodeCount() {
/*  99 */     return TOTAL_TOKENS + 0.01D;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNodeName(String nodeName)
/*     */   {
/* 106 */     this.nodeName = nodeName;
/*     */   }
/*     */   
/*     */   public List<Integer> getSetenceOverlap(Node n1, Node n2)
/*     */   {
/* 111 */     List<Integer> l1 = n1.getDocIds();
/* 112 */     List<Integer> l2 = n2.getDocIds();
/*     */     
/* 114 */     List<Integer> l3 = new ArrayList();
/*     */     
/* 116 */     l3.addAll(l1);
/* 117 */     l3.retainAll(l2);
/*     */     
/* 119 */     return l3;
/*     */   }
/*     */   
/*     */   public List<int[]> getSetenceOverlapRight(List<int[]> left)
/*     */   {
/* 124 */     List<int[]> right = getSentenceIds();
/* 125 */     List<int[]> l3 = new ArrayList();
/*     */     
/* 127 */     int pointer = 0;
/*     */     
/* 129 */     for (int i = 0; i < left.size(); i++) {
/* 130 */       int[] eleft = (int[])left.get(i);
/*     */       
/* 132 */       if (pointer > right.size()) {
/*     */         break;
/*     */       }
/*     */       
/* 136 */       for (int j = pointer; j < right.size(); j++)
/*     */       {
/* 138 */         int[] eright = (int[])right.get(j);
/*     */         
/* 140 */         if (eright[0] == eleft[0])
/*     */         {
/*     */ 
/*     */ 
/* 144 */           if ((eright[1] > eleft[1]) && (Math.abs(eright[1] - eleft[1]) <= OpinosisSettings.CONFIG_PERMISSABLE_GAP))
/*     */           {
/* 146 */             l3.add(eright);
/* 147 */             pointer = j + 1;
/* 148 */             break;
/*     */           }
/*     */           
/* 151 */           eright[1];eleft[1];
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 158 */           if (eright[0] > eleft[0]) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 165 */     return l3;
/*     */   }
/*     */   
/*     */   public List<int[]> getSetenceOverlap(List<int[]> l1)
/*     */   {
/* 170 */     List<int[]> l2 = getSentenceIds();
/* 171 */     List<int[]> l3 = new ArrayList();
/*     */     
/* 173 */     int pointer = 0;
/*     */     
/* 175 */     for (int i = 0; i < l1.size(); i++) {
/* 176 */       int[] elem1 = (int[])l1.get(i);
/*     */       
/* 178 */       if (pointer > l2.size()) {
/*     */         break;
/*     */       }
/*     */       
/* 182 */       for (int j = pointer; j < l2.size(); j++)
/*     */       {
/* 184 */         int[] elem2 = (int[])l2.get(j);
/*     */         
/* 186 */         if (elem2[0] == elem1[0])
/*     */         {
/* 188 */           l3.add(elem2);
/* 189 */           pointer = j + 1;
/*     */         }
/*     */         else
/*     */         {
/* 193 */           if (elem2[0] > elem1[0]) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 200 */     return l3;
/*     */   }
/*     */   
/*     */   public static double getSetenceJaccardOverlap(List<int[]> l1, List<int[]> l2)
/*     */   {
/* 205 */     int last = 0;
/* 206 */     int intersect = 0;
/* 207 */     HashSet<Integer> union = new HashSet();
/* 208 */     for (int i = 0; i < l1.size(); i++)
/*     */     {
/* 210 */       int elem1 = ((int[])l1.get(i))[0];
/* 211 */       union.add(Integer.valueOf(elem1));
/*     */       
/* 213 */       for (int j = last; j < l2.size(); j++) {
/* 214 */         int elem2 = ((int[])l2.get(j))[0];
/*     */         
/* 216 */         union.add(Integer.valueOf(elem2));
/*     */         
/* 218 */         if (elem2 == elem1) {
/* 219 */           intersect++;
/* 220 */           last = j + 1;
/*     */         }
/*     */         else
/*     */         {
/* 224 */           if (elem2 > elem1) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 235 */     double overlap = intersect / union.size();
/*     */     
/* 237 */     return overlap;
/*     */   }
/*     */   
/*     */   public double getSetencePathProb(double prevProb, List<int[]> l1)
/*     */   {
/* 242 */     List l2 = getSetenceOverlapRight(l1);
/* 243 */     List l3 = getSetenceUnion(l1);
/*     */     
/*     */ 
/*     */ 
/* 247 */     double currProb = l2.size() / l3.size();
/*     */     
/* 249 */     return currProb;
/*     */   }
/*     */   
/*     */   public double getSetencePathProb2(double prevProb, List<int[]> l1, double prior)
/*     */   {
/* 254 */     List l2 = getSetenceOverlapRight(l1);
/*     */     
/* 256 */     double currProb = (l2.size() + 0.01D) / (TOTAL_TOKENS + 0.01D);
/*     */     
/*     */ 
/*     */ 
/* 260 */     double prob = currProb / prevProb * prior;
/*     */     
/* 262 */     return prob;
/*     */   }
/*     */   
/*     */   private List getSetenceUnion(List<int[]> l1)
/*     */   {
/* 267 */     List<int[]> l2 = getSentenceIds();
/*     */     
/*     */     List<int[]> longer;
/*     */     List<int[]> shorter;
/*     */     List<int[]> longer;
/* 272 */     if (l1.size() < l2.size()) {
/* 273 */       List<int[]> shorter = l1;
/* 274 */       longer = l2;
/*     */     } else {
/* 276 */       shorter = l2;
/* 277 */       longer = l1;
/*     */     }
/*     */     
/* 280 */     List<int[]> l3 = new ArrayList();
/*     */     
/*     */ 
/*     */ 
/* 284 */     int pointer = 0;
/*     */     
/* 286 */     for (int i = 0; i < longer.size(); i++)
/*     */     {
/* 288 */       int[] elem1 = (int[])longer.get(i);
/*     */       
/* 290 */       if (pointer >= shorter.size()) {
/* 291 */         l3.add(elem1);
/*     */       }
/*     */       
/* 294 */       for (int j = pointer; j < shorter.size(); j++)
/*     */       {
/*     */ 
/* 297 */         int[] elem2 = (int[])shorter.get(j);
/*     */         
/*     */ 
/* 300 */         if (elem2[0] == elem1[0])
/*     */         {
/*     */ 
/* 303 */           l3.add(elem2);
/* 304 */           pointer = j + 1;
/* 305 */           break;
/*     */         }
/*     */         
/*     */ 
/* 309 */         if (elem2[0] > elem1[0])
/*     */         {
/* 311 */           l3.add(elem1);
/* 312 */           break;
/*     */         }
/*     */         
/* 315 */         l3.add(elem2);
/* 316 */         pointer = j + 1;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 324 */     return l3;
/*     */   }
/*     */   
/*     */ 
/*     */   private List getSetenceUnion(List<int[]> l1, List<int[]> l2)
/*     */   {
/*     */     List<int[]> longer;
/*     */     
/*     */     List<int[]> shorter;
/*     */     
/*     */     List<int[]> longer;
/* 335 */     if (l1.size() < l2.size()) {
/* 336 */       List<int[]> shorter = l1;
/* 337 */       longer = l2;
/*     */     } else {
/* 339 */       shorter = l2;
/* 340 */       longer = l1;
/*     */     }
/*     */     
/* 343 */     List<int[]> l3 = new ArrayList();
/*     */     
/*     */ 
/*     */ 
/* 347 */     int pointer = 0;
/*     */     
/* 349 */     for (int i = 0; i < longer.size(); i++)
/*     */     {
/* 351 */       int[] elem1 = (int[])longer.get(i);
/*     */       
/* 353 */       if (pointer >= shorter.size()) {
/* 354 */         l3.add(elem1);
/*     */       }
/*     */       
/* 357 */       for (int j = pointer; j < shorter.size(); j++)
/*     */       {
/*     */ 
/* 360 */         int[] elem2 = (int[])shorter.get(j);
/*     */         
/*     */ 
/* 363 */         if (elem2[0] == elem1[0])
/*     */         {
/*     */ 
/* 366 */           l3.add(elem2);
/* 367 */           pointer = j + 1;
/* 368 */           break;
/*     */         }
/*     */         
/*     */ 
/* 372 */         if (elem2[0] > elem1[0])
/*     */         {
/* 374 */           l3.add(elem1);
/* 375 */           break;
/*     */         }
/*     */         
/* 378 */         l3.add(elem2);
/* 379 */         pointer = j + 1;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 387 */     return l3;
/*     */   }
/*     */   
/*     */   public double getNodeProb()
/*     */   {
/* 392 */     double currProb = (this.nodeCount + 0.01D) / (TOTAL_TOKENS + 0.01D);
/* 393 */     return currProb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSentenceOverlapCount(Node n1, Node n2)
/*     */   {
/* 400 */     return getSetenceOverlap(n1, n2).size();
/*     */   }
/*     */   
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 406 */     return this.nodeName.hashCode();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean equals(Object o)
/*     */   {
/* 412 */     Node n = (Node)o;
/*     */     
/* 414 */     if (n.nodeName.equals(this.nodeName)) {
/* 415 */       return true;
/*     */     }
/*     */     
/* 418 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\com\opinosis\Node.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */