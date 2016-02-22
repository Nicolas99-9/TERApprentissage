/*    */ package com.opinosis;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SummarySorter
/*    */   implements Comparator<Candidate>
/*    */ {
/*    */   public int compare(Candidate s1, Candidate s2)
/*    */   {
/* 12 */     if (s1.gain > s2.gain) {
/* 13 */       return -1;
/*    */     }
/*    */     
/* 16 */     if (s1.gain < s2.gain) {
/* 17 */       return 1;
/*    */     }
/*    */     
/* 20 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\com\opinosis\SummarySorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */