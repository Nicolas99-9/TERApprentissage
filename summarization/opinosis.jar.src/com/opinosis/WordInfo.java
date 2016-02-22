/*     */ package com.opinosis;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ public class WordInfo
/*     */ {
/*  10 */   HashMap<String, Node> hm = new HashMap();
/*     */   
/*  12 */   int totalWords = 0;
/*  13 */   int mMaxOccurence = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getTotalWordCount()
/*     */   {
/*  21 */     return this.totalWords;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getWordCount(String str)
/*     */   {
/*  33 */     throw new Error("Unresolved compilation problem: \n\tType mismatch: cannot convert from double to int\n");
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
/*     */   public List<Integer> getSentences(String str)
/*     */   {
/*  46 */     throw new Error("Unresolved compilation problem: \n\tType mismatch: cannot convert from HashSet<Integer> to List<Integer>\n");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getWordPos(String word, int sid)
/*     */   {
/*  54 */     throw new Error("Unresolved compilation problem: \n\tThe method getPosition(int) is undefined for the type Node\n");
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSentencesCount(String str)
/*     */   {
/*  60 */     Node node = (Node)this.hm.get(str);
/*  61 */     if (node != null)
/*     */     {
/*  63 */       return Node.sentences.size();
/*     */     }
/*     */     
/*  66 */     return -1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void incrementCount(String str, int sid, int pos)
/*     */   {
/*  77 */     throw new Error("Unresolved compilation problems: \n\tThe method updateNodeCount(int, int) is undefined for the type Node\n\tThe method updateNodeCount(int, int) is undefined for the type Node\n\tThe method setMaxOccurence(int) in the type WordInfo is not applicable for the arguments (double)\n\tE cannot be resolved to a type\n");
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
/*     */   public int getMaxOccurence()
/*     */   {
/*  95 */     return this.mMaxOccurence;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setMaxOccurence(int maxOccurence)
/*     */   {
/* 105 */     if (this.mMaxOccurence < maxOccurence) {
/* 106 */       this.mMaxOccurence = maxOccurence;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setInvalidNode(String str)
/*     */   {
/* 115 */     throw new Error("Unresolved compilation problem: \n\tThe method setValidNode(boolean) is undefined for the type Node\n");
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
/*     */   public boolean isNodeValid(String str)
/*     */   {
/* 134 */     throw new Error("Unresolved compilation problem: \n\tThe method isValidNode() is undefined for the type Node\n");
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\com\opinosis\WordInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */