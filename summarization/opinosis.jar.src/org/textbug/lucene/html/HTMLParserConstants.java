/*    */ package org.textbug.lucene.html;
/*    */ 
/*    */ 
/*    */ public abstract interface HTMLParserConstants
/*    */ {
/*    */   public static final int EOF = 0;
/*    */   
/*    */   public static final int ScriptStart = 1;
/*    */   
/*    */   public static final int TagName = 2;
/*    */   public static final int DeclName = 3;
/*    */   public static final int Comment1 = 4;
/*    */   public static final int Comment2 = 5;
/*    */   public static final int Word = 6;
/*    */   public static final int LET = 7;
/*    */   public static final int NUM = 8;
/*    */   public static final int HEX = 9;
/*    */   public static final int Entity = 10;
/*    */   public static final int Space = 11;
/*    */   public static final int SP = 12;
/*    */   public static final int Punct = 13;
/*    */   public static final int ScriptText = 14;
/*    */   public static final int ScriptEnd = 15;
/*    */   public static final int ArgName = 16;
/*    */   public static final int ArgEquals = 17;
/*    */   public static final int TagEnd = 18;
/*    */   public static final int ArgValue = 19;
/*    */   public static final int ArgQuote1 = 20;
/*    */   public static final int ArgQuote2 = 21;
/*    */   public static final int Quote1Text = 23;
/*    */   public static final int CloseQuote1 = 24;
/*    */   public static final int Quote2Text = 25;
/*    */   public static final int CloseQuote2 = 26;
/*    */   public static final int CommentText1 = 27;
/*    */   public static final int CommentEnd1 = 28;
/*    */   public static final int CommentText2 = 29;
/*    */   public static final int CommentEnd2 = 30;
/*    */   public static final int DEFAULT = 0;
/*    */   public static final int WithinScript = 1;
/*    */   public static final int WithinTag = 2;
/*    */   public static final int AfterEquals = 3;
/*    */   public static final int WithinQuote1 = 4;
/*    */   public static final int WithinQuote2 = 5;
/*    */   public static final int WithinComment1 = 6;
/*    */   public static final int WithinComment2 = 7;
/* 46 */   public static final String[] tokenImage = {
/* 47 */     "<EOF>", 
/* 48 */     "\"<script\"", 
/* 49 */     "<TagName>", 
/* 50 */     "<DeclName>", 
/* 51 */     "\"<!--\"", 
/* 52 */     "\"<!\"", 
/* 53 */     "<Word>", 
/* 54 */     "<LET>", 
/* 55 */     "<NUM>", 
/* 56 */     "<HEX>", 
/* 57 */     "<Entity>", 
/* 58 */     "<Space>", 
/* 59 */     "<SP>", 
/* 60 */     "<Punct>", 
/* 61 */     "<ScriptText>", 
/* 62 */     "<ScriptEnd>", 
/* 63 */     "<ArgName>", 
/* 64 */     "\"=\"", 
/* 65 */     "<TagEnd>", 
/* 66 */     "<ArgValue>", 
/* 67 */     "\"\\'\"", 
/* 68 */     "\"\\\"\"", 
/* 69 */     "<token of kind 22>", 
/* 70 */     "<Quote1Text>", 
/* 71 */     "<CloseQuote1>", 
/* 72 */     "<Quote2Text>", 
/* 73 */     "<CloseQuote2>", 
/* 74 */     "<CommentText1>", 
/* 75 */     "\"-->\"", 
/* 76 */     "<CommentText2>", 
/* 77 */     "\">\"" };
/*    */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\textbug\lucene\html\HTMLParserConstants.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */