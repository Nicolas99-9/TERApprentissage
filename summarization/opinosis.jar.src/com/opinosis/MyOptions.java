/*    */ package com.opinosis;
/*    */ 
/*    */ import java.io.File;
/*    */ import org.kohsuke.args4j.Option;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MyOptions
/*    */ {
/*    */   @Option(name="-b", usage="Base directory where input and output directories are found.\nThis directory should contain the following subdirectories:\n\tinput/  - All the text to be summarized. One file per document.\n\toutput/ - Summarization Results (opinosis summaries)\n\tetc/  - Other resources like Opinosis.properties will be stored here.")
/* 13 */   private File dirBase = null;
/*    */   
/*    */   public File getDirBase() {
/* 16 */     return this.dirBase;
/*    */   }
/*    */   
/*    */   public void setDirBase(File dirBase) {
/* 20 */     this.dirBase = dirBase;
/*    */   }
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\com\opinosis\MyOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */