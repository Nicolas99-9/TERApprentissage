/*     */ package com.opinosis;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Writer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.graph.DefaultWeightedEdge;
/*     */ import org.jgrapht.graph.SimpleDirectedGraph;
/*     */ import org.jgrapht.graph.SimpleDirectedWeightedGraph;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class OpinosisCore
/*     */   extends OpinosisSettings
/*     */ {
/*     */   SimpleDirectedGraph<Node, DefaultWeightedEdge> mGraph;
/*     */   Writer mWriter;
/*  25 */   HashMap<String, Node> mWordNodeMap = null;
/*     */   
/*     */ 
/*     */   protected static final boolean DEBUG = false;
/*     */   
/*  30 */   String mAnchor = "";
/*  31 */   double beforeAttachGain = 0.0D;
/*  32 */   double mAnchorPathScore = 0.0D;
/*  33 */   private int mAnchorPathLen = 0;
/*     */   
/*  35 */   HashSet<Candidate> shortlisted = new HashSet();
/*  36 */   HashMap<String, Candidate> ccList = new HashMap();
/*     */   
/*     */   private void print() {
/*  39 */     System.out.print("");
/*     */   }
/*     */   
/*     */   private void print(String str)
/*     */   {
/*  44 */     System.out.print(str + " ");
/*     */   }
/*     */   
/*     */   private void println(String str) {
/*  48 */     System.out.println(str + " ");
/*     */   }
/*     */   
/*     */   public OpinosisCore(SimpleDirectedWeightedGraph<Node, DefaultWeightedEdge> g, HashMap<String, Node> wordNodeMap, Writer printer)
/*     */   {
/*  53 */     this.mGraph = g;
/*  54 */     this.mWriter = printer;
/*  55 */     this.mWordNodeMap = wordNodeMap;
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
/*     */ 
/*     */ 
/*     */   private boolean doCollapse(Node x, List<int[]> YintersectX, double pathscore, double prevPathScore, String str, List<int[]> overlapList, int level, boolean concatOn)
/*     */   {
/*  85 */     this.mAnchor = str;
/*  86 */     this.mAnchorPathScore = prevPathScore;
/*  87 */     this.mAnchorPathLen = level;
/*     */     
/*  89 */     Set<DefaultWeightedEdge> edges = this.mGraph.outgoingEdgesOf(x);
/*  90 */     if ((edges != null) && (edges.size() > 1))
/*     */     {
/*  92 */       Iterator<DefaultWeightedEdge> cIter = edges.iterator();
/*  93 */       while (cIter.hasNext())
/*     */       {
/*  95 */         DefaultWeightedEdge cEdgeOfX = (DefaultWeightedEdge)cIter.next();
/*  96 */         Node cY = (Node)this.mGraph.getEdgeTarget(cEdgeOfX);
/*  97 */         String cYNodeName = cY.getNodeName();
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 102 */         List<int[]> cYintersectX = getNodeOverlap(overlapList, cY.getSentenceIds());
/*     */         
/*     */ 
/* 105 */         int newLevel = level + 1;
/* 106 */         double newPathScore = computeScore(pathscore, cYintersectX, newLevel);
/*     */         
/*     */ 
/* 109 */         if (cYintersectX.size() >= CONFIG_MIN_REDUNDANCY)
/* 110 */           traverse(cY, cYintersectX, "xx " + cYNodeName, newPathScore, newLevel, true, false);
/*     */       }
/*     */     }
/* 113 */     concatOn = false;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 118 */     return processFound();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void start()
/*     */     throws IOException
/*     */   {
/* 129 */     long startTime = 0L;
/* 130 */     long endTime = 0L;
/*     */     
/* 132 */     Set<Node> nodeList = this.mGraph.vertexSet();
/* 133 */     Iterator<Node> nodes = nodeList.iterator();
/* 134 */     while (nodes.hasNext())
/*     */     {
/* 136 */       Node x = (Node)nodes.next();
/* 137 */       double score = 0.0D;
/* 138 */       if (isVSN(x))
/*     */       {
/* 140 */         traverse(x, x.getSentenceIds(), x.getNodeName(), score, 1, false, false);
/*     */       }
/*     */     }
/*     */     
/* 144 */     List<Candidate> theSentenceInfos = getFinalSentences();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 149 */     for (Candidate info : theSentenceInfos) {
/* 150 */       info.sent = info.sent.replaceAll("(/[a-z,.;$]+(\\s+|$))", " ");
/* 151 */       info.sent = info.sent.replaceAll("xx", "");
/* 152 */       info.sent += " .";
/* 153 */       info.sent = info.sent.replaceAll("\\s+", " ");
/* 154 */       this.mWriter.append(info.sent);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 162 */       this.mWriter.append("\n");
/*     */     }
/*     */     
/* 165 */     this.mWriter.close();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<Candidate> getFinalSentences()
/*     */   {
/* 175 */     List<Candidate> temp = new ArrayList();
/* 176 */     List<Candidate> shortlistedFinal = new ArrayList();
/*     */     
/* 178 */     if (this.shortlisted.size() <= 0) {
/* 179 */       return shortlistedFinal;
/*     */     }
/* 181 */     temp.addAll(removeDuplicates(this.shortlisted, false));
/*     */     
/* 183 */     Collections.sort(temp, new SummarySorter());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 193 */     if (temp.size() > CONFIG_MAX_SUMMARIES) {
/* 194 */       shortlistedFinal.add((Candidate)temp.get(0));
/*     */       
/* 196 */       int i = 1;
/* 197 */       do { Candidate a = (Candidate)temp.get(i - 1);
/* 198 */         Candidate b = (Candidate)temp.get(i);
/* 199 */         shortlistedFinal.add(b);i++;
/* 196 */         if (i >= temp.size()) break; } while (shortlistedFinal.size() < CONFIG_MAX_SUMMARIES);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 202 */       shortlistedFinal.addAll(temp);
/*     */     }
/* 204 */     return shortlistedFinal;
/*     */   }
/*     */   
/*     */ 
/*     */   private List<Node> getNodeList(String sent)
/*     */   {
/* 210 */     String[] tokens = sent.split("\\s+");
/* 211 */     ArrayList<Node> l = new ArrayList();
/*     */     String[] arrayOfString1;
/* 213 */     int j = (arrayOfString1 = tokens).length; for (int i = 0; i < j; i++) { String token = arrayOfString1[i];
/*     */       
/* 215 */       if (token.matches(".*(/nn|/jj|/vb[a-s]).*"))
/*     */       {
/* 217 */         Node n = (Node)this.mWordNodeMap.get(token);
/*     */         
/* 219 */         if (n != null) {
/* 220 */           l.add(n);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 226 */     return l;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean processFound()
/*     */   {
/* 233 */     boolean success = false;
/* 234 */     Collection<Candidate> temp = this.ccList.values();
/* 235 */     HashSet<Candidate> collapsed = new HashSet(temp);
/*     */     
/* 237 */     collapsed = removeDuplicates(collapsed, true);
/*     */     
/* 239 */     int i = 0;
/* 240 */     if (collapsed.size() > 1)
/*     */     {
/* 242 */       double overallgains = 0.0D;
/* 243 */       double allscores = this.mAnchorPathScore;
/* 244 */       double allgains = this.beforeAttachGain;
/* 245 */       int alllevels = this.mAnchorPathLen;
/*     */       
/* 247 */       StringBuffer buffer = new StringBuffer(this.mAnchor);
/* 248 */       List<int[]> sentList = new ArrayList();
/*     */       
/* 250 */       for (Candidate theInfo : collapsed)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 255 */         overallgains += theInfo.gain;
/* 256 */         allgains += theInfo.localgain;
/* 257 */         allscores += theInfo.rawscore;
/* 258 */         alllevels += theInfo.level;
/* 259 */         sentList.addAll(theInfo.sentList);
/* 260 */         if ((i > 0) && (i == collapsed.size() - 1)) {
/* 261 */           buffer.append(" and ");
/*     */         }
/* 263 */         else if (i > 0) {
/* 264 */           buffer.append(" , ");
/*     */         }
/*     */         else {
/* 267 */           buffer.append(" ");
/*     */         }
/* 269 */         buffer.append(theInfo.sent);
/* 270 */         i++;
/*     */       }
/*     */       
/* 273 */       if (this.ccList.size() > 1)
/*     */       {
/* 275 */         double overallGain = overallgains / this.ccList.size();
/*     */         
/*     */ 
/* 278 */         this.shortlisted.add(new Candidate(overallGain, buffer.toString(), sentList, alllevels));
/*     */         
/* 280 */         success = true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 287 */     this.ccList.clear();
/* 288 */     this.mAnchor = "";
/* 289 */     this.beforeAttachGain = 0.0D;
/* 290 */     this.mAnchorPathScore = 0.0D;
/* 291 */     this.mAnchorPathLen = 0;
/*     */     
/* 293 */     return success;
/*     */   }
/*     */   
/*     */ 
/*     */   private void processNext(Node x, String str, List<int[]> overlapList, double currentPathScore, int pathLen, boolean isCollapsedPath)
/*     */   {
/* 299 */     Set<DefaultWeightedEdge> outgoing = this.mGraph.outgoingEdgesOf(x);
/* 300 */     if ((outgoing != null) && (outgoing.size() > 0))
/*     */     {
/* 302 */       Iterator<DefaultWeightedEdge> xEdges = outgoing.iterator();
/* 303 */       boolean doMore = true;
/*     */       
/* 305 */       while ((xEdges.hasNext()) && (doMore))
/*     */       {
/* 307 */         DefaultWeightedEdge xEdge = (DefaultWeightedEdge)xEdges.next();
/*     */         
/* 309 */         Node y = (Node)this.mGraph.getEdgeTarget(xEdge);
/* 310 */         String yNodeName = y.getNodeName();
/*     */         
/* 312 */         List<int[]> currOverlapList = getNodeOverlap(overlapList, y.getSentenceIds());
/*     */         
/* 314 */         if (currOverlapList.size() > 0)
/*     */         {
/* 316 */           int newPathLen = pathLen + 1;
/* 317 */           double newPathScore = computeScore(currentPathScore, currOverlapList, newPathLen);
/*     */           
/*     */ 
/* 320 */           if ((CONFIG_TURN_ON_COLLAPSE) && (pathLen >= CONFIG_ATTACHMENT_AFTER) && (!isCollapsedPath) && (currOverlapList.size() <= overlapList.size()) && (x.getNodeName().matches(".*(/vb[a-z]|/in)")))
/*     */           {
/*     */ 
/* 323 */             boolean success = doCollapse(x, currOverlapList, newPathScore, currentPathScore, str, overlapList, pathLen, isCollapsedPath);
/*     */             
/* 325 */             if (!success)
/*     */             {
/* 327 */               String strTemp = str + " " + y.getNodeName();
/* 328 */               doMore = traverse(y, currOverlapList, strTemp, newPathScore, newPathLen, isCollapsedPath, false);
/*     */             }
/*     */             
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/* 335 */             String strTemp = str + " " + yNodeName;
/* 336 */             doMore = traverse(y, currOverlapList, strTemp, newPathScore, pathLen + 1, isCollapsedPath, false);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/* 343 */   private Candidate remove(Candidate currSentence, Candidate best) { double temp = currSentence.gain;
/*     */     
/* 345 */     if ((best.gain < currSentence.gain) && (best.level <= currSentence.level))
/*     */     {
/* 347 */       best.discard = true;
/* 348 */       best = currSentence;
/*     */     }
/*     */     else
/*     */     {
/* 352 */       currSentence.discard = true;
/*     */     }
/*     */     
/* 355 */     return best;
/*     */   }
/*     */   
/*     */   private HashSet<Candidate> removeDuplicates(HashSet<Candidate> set, boolean isIntermediate)
/*     */   {
/* 360 */     HashSet<Candidate> finalSentences = new HashSet();
/* 361 */     if (CONFIG_TURN_ON_DUP_ELIM)
/*     */     {
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
/* 381 */       List<Candidate> list = new ArrayList(set);
/*     */       
/* 383 */       for (int i = 0; i < list.size(); i++)
/*     */       {
/* 385 */         Candidate info = (Candidate)list.get(i);
/* 386 */         info.discard = false;
/* 387 */         List<Node> nl = getNodeList(info.sent);
/* 388 */         info.theNodeList = nl;
/*     */       }
/*     */       
/* 391 */       int startFrom = 0;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 396 */       for (int a = 0; a < list.size(); a++)
/*     */       {
/*     */ 
/* 399 */         if (!((Candidate)list.get(a)).discard)
/*     */         {
/* 401 */           Candidate prevSentence = (Candidate)list.get(a);
/* 402 */           Candidate best = (Candidate)list.get(a);
/*     */           
/*     */ 
/* 405 */           for (int b = 0; b < list.size(); b++)
/*     */           {
/*     */ 
/* 408 */             if ((!((Candidate)list.get(b)).discard) && (a != b))
/*     */             {
/* 410 */               Candidate currSentence = (Candidate)list.get(b);
/* 411 */               double overlap = computeCandidateSimScore(currSentence, best);
/*     */               
/*     */ 
/*     */ 
/* 415 */               if (isIntermediate)
/*     */               {
/* 417 */                 if (overlap > CONFIG_DUPLICATE_COLLAPSE_THRESHOLD)
/*     */                 {
/* 419 */                   best = remove(currSentence, best);
/*     */ 
/*     */                 }
/*     */                 
/*     */ 
/*     */               }
/* 425 */               else if (overlap > CONFIG_DUPLICATE_THRESHOLD)
/*     */               {
/* 427 */                 best = remove(currSentence, best);
/*     */               }
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 435 */           finalSentences.add(best);
/* 436 */           best.discard = true;
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 457 */       finalSentences = set;
/*     */     }
/* 459 */     return finalSentences;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean traverse(Node x, List<int[]> overlapList, String str, double pathScore, int pathLength, boolean isCollapsedCandidate, boolean overlapSame)
/*     */   {
/* 467 */     if (!shouldContinueTraverse(x, overlapList, pathLength, pathScore)) {
/* 468 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 472 */     if (isVEN(x, pathLength, isCollapsedCandidate))
/*     */     {
/* 474 */       if (processVEN(x, pathLength, overlapList, isCollapsedCandidate, str, pathScore)) return true;
/*     */     }
/* 476 */     processNext(x, str, overlapList, pathScore, pathLength, isCollapsedCandidate);
/*     */     
/* 478 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean processVEN(Node x, int pathLength, List<int[]> theNodeList, boolean isCollapsedCandidate, String str, double pathScore)
/*     */   {
/* 486 */     String theCandidateStr = str;
/* 487 */     int thePathLen = pathLength;
/* 488 */     double theScore = pathScore;
/*     */     
/*     */ 
/*     */ 
/* 492 */     if (isEndToken(x)) {
/* 493 */       theCandidateStr = theCandidateStr.substring(0, theCandidateStr.lastIndexOf(" "));
/* 494 */       thePathLen = pathLength - 1;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 499 */     double theAdjustedScore = computeAdjustedScore(theScore, thePathLen);
/*     */     
/*     */ 
/* 502 */     if (isValidCandidate(this.mAnchor + " " + theCandidateStr))
/*     */     {
/*     */ 
/* 505 */       if (!isCollapsedCandidate)
/*     */       {
/*     */ 
/* 508 */         this.shortlisted.add(new Candidate(theAdjustedScore, theCandidateStr, theNodeList, thePathLen));
/*     */       }
/*     */       else
/*     */       {
/* 512 */         Candidate cc = (Candidate)this.ccList.get(theCandidateStr);
/* 513 */         int ccPathLength = thePathLen - this.mAnchorPathLen;
/* 514 */         double ccPathScore = theScore - this.mAnchorPathScore;
/*     */         
/* 516 */         if (cc != null)
/*     */         {
/*     */ 
/* 519 */           cc.gain = Math.max(cc.gain, theAdjustedScore);
/*     */         }
/*     */         else
/*     */         {
/* 523 */           cc = new Candidate(theAdjustedScore, theCandidateStr, theNodeList, ccPathLength, ccPathScore, 0.0D - this.beforeAttachGain);
/* 524 */           this.ccList.put(theCandidateStr, cc);
/*     */         }
/* 526 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 530 */     return false;
/*     */   }
/*     */   
/*     */   public SimpleDirectedGraph<Node, DefaultWeightedEdge> getGraph() {
/* 534 */     return this.mGraph;
/*     */   }
/*     */   
/*     */   public abstract double computeAdjustedScore(double paramDouble, int paramInt);
/*     */   
/*     */   public abstract double computeScore(double paramDouble, List<int[]> paramList, int paramInt);
/*     */   
/*     */   public abstract double computeCandidateSimScore(Candidate paramCandidate1, Candidate paramCandidate2);
/*     */   
/*     */   public abstract boolean isEndToken(Node paramNode);
/*     */   
/*     */   public abstract boolean shouldContinueTraverse(Node paramNode, List<int[]> paramList, int paramInt, double paramDouble);
/*     */   
/*     */   public abstract boolean isValidCandidate(String paramString);
/*     */   
/*     */   public abstract boolean isVSN(Node paramNode);
/*     */   
/*     */   public abstract boolean isVEN(Node paramNode, int paramInt, boolean paramBoolean);
/*     */   
/*     */   public abstract List<int[]> getNodeOverlap(List<int[]> paramList1, List<int[]> paramList2);
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\com\opinosis\OpinosisCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */