/*    */ package com.opinosis;
/*    */ 
/*    */ public class OpinosisSettings
/*    */ {
/*  5 */   public static final String FILE_SEP = System.getProperty("file.separator");
/*    */   
/*    */   static final String FILE_KAVITA = "E:\\Projects\\MyTopiq\\data\\evaluation\\txt.data.parsed";
/*  8 */   public static int GAIN_REDUNDANCY_ONLY = 1;
/*  9 */   public static int GAIN_WEIGHTED_REDUNDANCY_BY_LEVEL = 2;
/* 10 */   public static int GAIN_WEIGHTED_REDUNDANCY_BY_LOG_LEVEL = 3;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   static final String CURRENT_FILE = "E:\\Projects\\MyTopiq\\data\\evaluation\\txt.data.parsed";
/*    */   
/*    */ 
/*    */ 
/* 19 */   public double P_TOPIC_THRESHOLD = 0.1D;
/*    */   
/* 21 */   public double P_SENTENCE_THRESHOLD = 0.05D;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 28 */   public int P_MAX_SENT_LENGTH = 18;
/*    */   
/*    */ 
/* 31 */   public int P_MIN_SENT_LENGTH = 2;
/*    */   
/*    */ 
/*    */   @Deprecated
/* 35 */   public int P_MIN_TOPIC_OVERLAP = 1;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/* 40 */   public static boolean CONFIG_TURN_ON_COLLAPSE = false;
/*    */   
/* 42 */   public static boolean CONFIG_TURN_ON_DUP_ELIM = false;
/*    */   
/* 44 */   public static boolean CONFIG_NORMALIZE_OVERALLGAIN = true;
/*    */   
/* 46 */   public static int CONFIG_MIN_REDUNDANCY = 2;
/*    */   
/* 48 */   public static int CONFIG_PERMISSABLE_GAP = 4;
/*    */   
/* 50 */   public static int CONFIG_ATTACHMENT_AFTER = 2;
/*    */   
/* 52 */   public static boolean CONFIG_USE_POS_GAIN = false;
/*    */   
/* 54 */   public static double CONFIG_MAX_SUMMARIES = 5.0D;
/*    */   
/* 56 */   public static double CONFIG_DUPLICATE_THRESHOLD = 0.35D;
/*    */   
/* 58 */   public static int CONFIG_SCORING_FUNCTION = GAIN_WEIGHTED_REDUNDANCY_BY_LOG_LEVEL;
/*    */   
/* 60 */   public static double CONFIG_DUPLICATE_COLLAPSE_THRESHOLD = 0.5D;
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\com\opinosis\OpinosisSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */