/*    */ package org.jgrapht.experimental.permutation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PermutationFactory
/*    */ {
/*    */   public static ArrayPermutationsIter createRegular(int[] permSourceArray)
/*    */   {
/* 78 */     IntegerPermutationIter regularPerm = 
/* 79 */       new IntegerPermutationIter(permSourceArray);
/* 80 */     return regularPerm;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static ArrayPermutationsIter createByGroups(int[] groupSizesArray)
/*    */   {
/* 92 */     CompoundPermutationIter complexPerm = 
/* 93 */       new CompoundPermutationIter(groupSizesArray);
/* 94 */     return complexPerm;
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\permutation\PermutationFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */