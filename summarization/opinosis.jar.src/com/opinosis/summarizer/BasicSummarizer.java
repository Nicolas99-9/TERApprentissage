/*     */ package com.opinosis.summarizer;
/*     */ 
/*     */ import com.opinosis.Candidate;
/*     */ import com.opinosis.Node;
/*     */ import com.opinosis.OpinosisCore;
/*     */ import com.opinosis.OpinosisSettings;
/*     */ import java.io.Writer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import org.jgrapht.graph.DefaultWeightedEdge;
/*     */ import org.jgrapht.graph.SimpleDirectedGraph;
/*     */ import org.jgrapht.graph.SimpleDirectedWeightedGraph;
/*     */ import org.textbug.utility.MathUtil;
/*     */ 
/*     */ 
/*     */ public class BasicSummarizer
/*     */   extends OpinosisCore
/*     */ {
/*     */   public BasicSummarizer(SimpleDirectedWeightedGraph<Node, DefaultWeightedEdge> g, HashMap<String, Node> wordNodeMap, Writer printer)
/*     */   {
/*  23 */     super(g, wordNodeMap, printer);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isValidCandidate(String str)
/*     */   {
/*  32 */     boolean isGood = false;
/*     */     
/*  34 */     if (str.matches(".*(/jj)*.*(/nn)+.*(/vb)+.*(/jj)+.*")) {
/*  35 */       isGood = true;
/*     */ 
/*     */     }
/*  38 */     else if ((!str.matches(".*(/dt).*")) && (str.matches(".*(/rb)*.*(/jj)+.*(/nn)+.*"))) {
/*  39 */       isGood = true;
/*     */ 
/*     */     }
/*  42 */     else if (str.matches(".*(/prp|/dt)+.*(/vb)+.*(/rb|/jj)+.*(/nn)+.*")) {
/*  43 */       isGood = true;
/*     */ 
/*     */     }
/*  46 */     else if (str.matches(".*(/jj)+.*(/to)+.*(/vb).*")) {
/*  47 */       isGood = true;
/*     */ 
/*     */     }
/*  50 */     else if (str.matches(".*(/rb)+.*(/in)+.*(/nn)+.*")) {
/*  51 */       isGood = true;
/*     */     }
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
/*  82 */     String last = str.substring(str.lastIndexOf(' '), str.length());
/*  83 */     if (last.matches(".*(/to|/vbz|/in|/cc|wdt|/prp|/dt|/,)")) {
/*  84 */       isGood = false;
/*     */     }
/*     */     
/*  87 */     return isGood;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<int[]> getNodeOverlap(List<int[]> left, List<int[]> right)
/*     */   {
/* 115 */     List<int[]> l3 = new ArrayList();
/*     */     
/* 117 */     int pointer = 0;
/*     */     
/* 119 */     for (int i = 0; i < left.size(); i++) {
/* 120 */       int[] eleft = (int[])left.get(i);
/*     */       
/* 122 */       if (pointer > right.size()) {
/*     */         break;
/*     */       }
/*     */       
/* 126 */       for (int j = pointer; j < right.size(); j++)
/*     */       {
/* 128 */         int[] eright = (int[])right.get(j);
/*     */         
/* 130 */         if (eright[0] == eleft[0])
/*     */         {
/*     */ 
/*     */ 
/* 134 */           if ((eright[1] > eleft[1]) && (Math.abs(eright[1] - eleft[1]) <= OpinosisSettings.CONFIG_PERMISSABLE_GAP))
/*     */           {
/* 136 */             l3.add(eright);
/* 137 */             pointer = j + 1;
/* 138 */             break;
/*     */           }
/*     */           
/* 141 */           eright[1];eleft[1];
/*     */ 
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 148 */           if (eright[0] > eleft[0]) {
/*     */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 155 */     return l3;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isVSN(Node x)
/*     */   {
/* 161 */     String nname = x.getNodeName();
/*     */     
/* 163 */     if (x.getAveragePos() <= 15.0D)
/*     */     {
/* 165 */       if ((nname.contains("/jj")) || 
/* 166 */         (nname.contains("/rb")) || 
/* 167 */         (nname.contains("/prp$")) || 
/* 168 */         (nname.contains("/vbg")) || 
/* 169 */         (nname.contains("/nn")) || 
/* 170 */         (nname.contains("/dt")) || 
/* 171 */         (nname.matches("^(its/|the/|when/|a/|an/|this/|the/|they/|it/|i/|we/|our/).*")) || 
/* 172 */         (nname.contains("it/prp")) || 
/* 173 */         (nname.contains("if/")) || 
/* 174 */         (nname.contains("for/")))
/* 175 */         return true; }
/* 176 */     return false;
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
/*     */   public boolean isVEN(Node x, int pathLength, boolean isCollapsedCandidate)
/*     */   {
/* 190 */     if (isEndToken(x)) {
/* 191 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 195 */     if (getGraph().outDegreeOf(x) <= 0) {
/* 196 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 200 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isEndToken(Node x)
/*     */   {
/* 212 */     String token = x.getNodeName();
/*     */     
/* 214 */     if (token.matches(".*(/\\.|/,)")) {
/* 215 */       return true;
/*     */     }
/*     */     
/* 218 */     return false;
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
/*     */   public double computeCandidateSimScore(Candidate s1, Candidate s2)
/*     */   {
/* 236 */     List<Node> l1 = s1.theNodeList;
/* 237 */     List<Node> l2 = s2.theNodeList;
/*     */     
/* 239 */     HashSet union = new HashSet(l1);
/* 240 */     HashSet intersect = new HashSet(l1);
/*     */     
/* 242 */     union.addAll(l2);
/* 243 */     intersect.retainAll(l2);
/*     */     
/* 245 */     double overlap = intersect.size() / union.size();
/*     */     
/*     */ 
/* 248 */     return overlap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public double computeScore(double currentScore, List<int[]> currOverlapList, int pathLength)
/*     */   {
/* 257 */     double theGain = 0.0D;
/* 258 */     int overlapSize = currOverlapList.size();
/*     */     
/* 260 */     if (CONFIG_SCORING_FUNCTION == GAIN_REDUNDANCY_ONLY) {
/* 261 */       theGain = currentScore + overlapSize;
/*     */     }
/*     */     
/* 264 */     if (CONFIG_SCORING_FUNCTION == GAIN_WEIGHTED_REDUNDANCY_BY_LEVEL) {
/* 265 */       theGain = currentScore + overlapSize * pathLength;
/*     */     }
/*     */     
/* 268 */     if (CONFIG_SCORING_FUNCTION == GAIN_WEIGHTED_REDUNDANCY_BY_LOG_LEVEL) {
/* 269 */       if (pathLength > 1) {
/* 270 */         theGain = currentScore + overlapSize * MathUtil.getLog2(pathLength);
/*     */       }
/*     */       else {
/* 273 */         theGain = currentScore + overlapSize;
/*     */       }
/*     */     }
/* 276 */     return theGain;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public double computeAdjustedScore(double score, int level)
/*     */   {
/* 283 */     double oGain = score;
/*     */     
/* 285 */     if (CONFIG_NORMALIZE_OVERALLGAIN) {
/* 286 */       oGain /= level;
/*     */     }
/*     */     
/* 289 */     return oGain;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean shouldContinueTraverse(Node x, List<int[]> overlapSoFar, int pathLength, double score)
/*     */   {
/* 297 */     if (pathLength >= this.P_MAX_SENT_LENGTH) {
/* 298 */       return false;
/*     */     }
/*     */     
/* 301 */     if (score == Double.NEGATIVE_INFINITY) {
/* 302 */       return false;
/*     */     }
/*     */     
/* 305 */     if ((overlapSoFar.size() < CONFIG_MIN_REDUNDANCY) && 
/* 306 */       (!isEndToken(x))) {
/* 307 */       return false;
/*     */     }
/*     */     
/* 310 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\com\opinosis\summarizer\BasicSummarizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */