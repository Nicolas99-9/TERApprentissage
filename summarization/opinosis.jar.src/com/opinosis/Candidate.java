/*    */ package com.opinosis;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class Candidate
/*    */   implements Comparable<Candidate>
/*    */ {
/*  8 */   public boolean discard = false;
/*    */   public double gain;
/* 10 */   int level = 0;
/*    */   
/*    */   public double localgain;
/*    */   public double overlap;
/*    */   public double rawscore;
/*    */   public String sent;
/*    */   public List<int[]> sentList;
/*    */   public List<Node> theNodeList;
/*    */   
/*    */   public Candidate(double ogain, String sentence, List<int[]> sentList, int level)
/*    */   {
/* 21 */     this.gain = ogain;
/* 22 */     this.sent = sentence;
/* 23 */     this.sentList = sentList;
/* 24 */     this.level = level;
/*    */   }
/*    */   
/*    */   public Candidate(double overallGain, String str, List<int[]> overlapList, int level, double score, double gain)
/*    */   {
/* 29 */     this.gain = overallGain;
/* 30 */     this.sent = str;
/* 31 */     this.sentList = overlapList;
/* 32 */     this.level = level;
/* 33 */     this.rawscore = score;
/* 34 */     this.localgain = gain;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean equals(Object b)
/*    */   {
/* 40 */     Candidate infob = (Candidate)b;
/*    */     
/* 42 */     if (this.sent.equals(infob.sent)) return true;
/* 43 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 48 */     return this.sent.hashCode();
/*    */   }
/*    */   
/*    */ 
/*    */   public int compareTo(Candidate info)
/*    */   {
/* 54 */     List<int[]> sentList2 = info.sentList;
/*    */     
/* 56 */     double overlap = Node.getSetenceJaccardOverlap(this.sentList, sentList2);
/*    */     
/* 58 */     if (((int[])sentList2.get(0))[0] == ((int[])this.sentList.get(0))[0]) {
/* 59 */       if (this.sentList.size() > sentList2.size()) {
/* 60 */         return 1;
/*    */       }
/*    */       
/* 63 */       if (this.sentList.size() < sentList2.size()) {
/* 64 */         return -1;
/*    */       }
/* 66 */       return 0;
/*    */     }
/*    */     
/* 69 */     if (((int[])sentList2.get(0))[0] > ((int[])this.sentList.get(0))[0]) {
/* 70 */       return 1;
/*    */     }
/*    */     
/* 73 */     return -1;
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\com\opinosis\Candidate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */