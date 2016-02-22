/*     */ package com.opinosis;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.io.Writer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.graph.DefaultWeightedEdge;
/*     */ import org.jgrapht.graph.SimpleDirectedGraph;
/*     */ import org.jgrapht.graph.SimpleDirectedWeightedGraph;
/*     */ import org.textbug.utility.MathUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OpinosisSummarizer
/*     */   extends OpinosisSettings
/*     */   implements OpinosisFramework
/*     */ {
/*     */   protected SimpleDirectedGraph<Node, DefaultWeightedEdge> mGraph2;
/*     */   protected static final boolean DEBUG = false;
/*  29 */   static int clusterID = 0;
/*     */   
/*  31 */   static int oldClusterID = -1;
/*     */   
/*     */ 
/*  34 */   String beforeAttach = "";
/*  35 */   double beforeAttachGain = 0.0D;
/*  36 */   double beforeAttachScore = 0.0D;
/*     */   
/*  38 */   private int originalLevel = 0;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   Writer writer;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  57 */   HashSet<SentenceInfo> shortlisted = new HashSet();
/*     */   
/*     */ 
/*     */ 
/*  61 */   HashMap<String, SentenceInfo> tempCollapsed = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  71 */   HashMap<String, Node> wordNodeMap = null;
/*     */   
/*     */   class Topic implements Comparable<Topic> {
/*  74 */     String name = "";
/*     */     
/*  76 */     List<int[]> sids = null;
/*     */     
/*  78 */     public Topic(List<int[]> str) { this.name = str;
/*  79 */       this.sids = overlapList;
/*     */     }
/*     */     
/*     */     public int compareTo(Topic t)
/*     */     {
/*  84 */       if (t.sids.size() > this.sids.size()) {
/*  85 */         return 1;
/*     */       }
/*     */       
/*  88 */       if (t.sids.size() < this.sids.size()) {
/*  89 */         return -1;
/*     */       }
/*  91 */       return 0;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public OpinosisSummarizer(SimpleDirectedWeightedGraph<Node, DefaultWeightedEdge> g, HashMap<String, Node> wordNodeMap, Writer printer)
/*     */   {
/* 101 */     this.mGraph2 = g;
/* 102 */     this.writer = printer;
/* 103 */     this.wordNodeMap = wordNodeMap;
/*     */   }
/*     */   
/*     */ 
/*     */   private double computeAdjustedScore(boolean concatOn, int level, double pathProb, int intersect)
/*     */   {
/* 109 */     double ixt = intersect;
/*     */     
/* 111 */     if (intersect > 0) {
/* 112 */       ixt = Math.log(ixt);
/*     */     }
/*     */     
/* 115 */     return ixt + pathProb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean doCheck(int level, boolean concatOn)
/*     */   {
/* 124 */     boolean valid = false;
/* 125 */     if (level >= this.P_MIN_SENT_LENGTH)
/*     */     {
/* 127 */       if (concatOn) {
/* 128 */         if (level - this.originalLevel > 0) {
/* 129 */           valid = true;
/*     */         }
/*     */       }
/*     */       else {
/* 133 */         valid = true;
/*     */       }
/*     */     } else {
/* 136 */       valid = false;
/*     */     }
/*     */     
/* 139 */     return valid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean doCollapse(Node x, List<int[]> YintersectX, double pathscore, double prevPathScore, String str, List<int[]> overlapList, int level, boolean concatOn)
/*     */   {
/* 147 */     this.beforeAttach = str;
/* 148 */     this.beforeAttachScore = prevPathScore;
/* 149 */     this.beforeAttachGain = 0.0D;
/* 150 */     this.originalLevel = level;
/*     */     
/* 152 */     Set<DefaultWeightedEdge> edges = this.mGraph2.outgoingEdgesOf(x);
/* 153 */     if ((edges != null) && (edges.size() > 1))
/*     */     {
/* 155 */       Iterator<DefaultWeightedEdge> cIter = edges.iterator();
/* 156 */       while (cIter.hasNext())
/*     */       {
/* 158 */         DefaultWeightedEdge cEdgeOfX = (DefaultWeightedEdge)cIter.next();
/* 159 */         Node cY = (Node)this.mGraph2.getEdgeTarget(cEdgeOfX);
/* 160 */         String cYNodeName = cY.getNodeName();
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 165 */         List<int[]> cYintersectX = cY.getSetenceOverlapRight(overlapList);
/*     */         
/*     */ 
/* 168 */         int newLevel = level + 1;
/* 169 */         double newPathScore = getCurrentGain(pathscore, cYintersectX.size(), newLevel);
/*     */         
/*     */ 
/* 172 */         if (cYintersectX.size() >= CONFIG_MIN_REDUNDANCY)
/* 173 */           traverse(cY, cYintersectX, "xx " + cYNodeName, newPathScore, newLevel, true, false);
/*     */       }
/*     */     }
/* 176 */     concatOn = false;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 181 */     return processFound();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void doSummary()
/*     */     throws IOException
/*     */   {
/* 192 */     long startTime = 0L;
/* 193 */     long endTime = 0L;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 198 */     Set<Node> vertexSet = this.mGraph2.vertexSet();
/*     */     
/*     */ 
/* 201 */     Iterator<Node> vertexSetIterator = vertexSet.iterator();
/* 202 */     while (vertexSetIterator.hasNext())
/*     */     {
/*     */ 
/* 205 */       Node x = (Node)vertexSetIterator.next();
/*     */       
/* 207 */       if (isVSN(x))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 212 */         double score = 0.0D;
/* 213 */         traverse(x, x.getSentenceIds(), x.getNodeName(), score, 1, false, false);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 220 */     List<SentenceInfo> theSentenceInfos = getFinalSentences();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 227 */     for (SentenceInfo info : theSentenceInfos) {
/* 228 */       info.sent = info.sent.replaceAll("(/[a-z,.;$]+(\\s+|$))", " ");
/* 229 */       info.sent = info.sent.replaceAll("xx", "");
/* 230 */       info.sent += " .";
/* 231 */       info.sent = info.sent.replaceAll("\\s+", " ");
/* 232 */       this.writer.append(info.sent);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 240 */       this.writer.append("\n");
/*     */     }
/*     */     
/* 243 */     this.writer.close();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isVSN(Node x)
/*     */   {
/* 249 */     String nname = x.getNodeName();
/*     */     
/* 251 */     if (x.getAveragePos() <= 15.0D)
/*     */     {
/* 253 */       if ((nname.contains("/jj")) || 
/* 254 */         (nname.contains("/rb")) || 
/* 255 */         (nname.contains("/prp$")) || 
/* 256 */         (nname.contains("/vbg")) || 
/* 257 */         (nname.contains("/nn")) || 
/* 258 */         (nname.contains("/dt")) || 
/* 259 */         (nname.matches("^(its/|the/|when/|a/|an/|this/|the/|they/|it/|i/|we/|our/).*")) || 
/* 260 */         (nname.contains("it/prp")) || 
/* 261 */         (nname.contains("if/")) || 
/* 262 */         (nname.contains("for/")))
/* 263 */         return true; }
/* 264 */     return false;
/*     */   }
/*     */   
/*     */   private double getCurrentGain(double gain, double r, int level)
/*     */   {
/* 269 */     double theGain = 0.0D;
/*     */     
/* 271 */     if (CONFIG_SCORING_FUNCTION == GAIN_REDUNDANCY_ONLY) {
/* 272 */       theGain = gain + r;
/*     */     }
/*     */     
/* 275 */     if (CONFIG_SCORING_FUNCTION == GAIN_WEIGHTED_REDUNDANCY_BY_LEVEL) {
/* 276 */       theGain = gain + r * level;
/*     */     }
/*     */     
/* 279 */     if (CONFIG_SCORING_FUNCTION == GAIN_WEIGHTED_REDUNDANCY_BY_LOG_LEVEL) {
/* 280 */       if (level > 1) {
/* 281 */         theGain = gain + r * MathUtil.getLog2(level);
/*     */       }
/*     */       else {
/* 284 */         theGain = gain + r;
/*     */       }
/*     */     }
/* 287 */     return theGain;
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
/*     */   private List<SentenceInfo> getFinalSentences()
/*     */   {
/* 305 */     throw new Error("Unresolved compilation problem: \n\tThe method sort(List<T>, Comparator<? super T>) in the type Collections is not applicable for the arguments (List<SentenceInfo>, SummarySorter)\n");
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
/*     */ 
/*     */ 
/*     */   private double getGreedyWeight(Node y)
/*     */   {
/* 337 */     double theScore = 1.0D;
/*     */     
/* 339 */     if ((y.getNodeName().contains("/nn")) || (y.getNodeName().matches(".*/vb[dng]"))) {
/* 340 */       theScore = 2.0D;
/*     */ 
/*     */     }
/* 343 */     else if (y.getNodeName().matches("(this|that|the)/dt")) {
/* 344 */       theScore = 1.5D;
/*     */ 
/*     */     }
/* 347 */     else if (y.getNodeName().matches("(i|it|we|our)/prp")) {
/* 348 */       theScore = 1.5D;
/*     */ 
/*     */     }
/* 351 */     else if (y.getNodeName().contains("/jj")) {
/* 352 */       theScore = 1.8D;
/*     */ 
/*     */     }
/* 355 */     else if ((y.getNodeName().contains("not/rb")) || (y.getNodeName().contains("ont/")) || (y.getNodeName().contains("cant/")) || (y.getNodeName().contains("nt/rb"))) {
/* 356 */       theScore = 2.0D;
/*     */ 
/*     */     }
/* 359 */     else if ((y.getNodeName().contains("/?")) || (y.getNodeName().contains("/!"))) {
/* 360 */       theScore = 0.5D;
/*     */ 
/*     */     }
/* 363 */     else if (y.getNodeName().contains("/.")) {
/* 364 */       theScore = 1.5D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     }
/* 372 */     else if ((y.getNodeName().contains("/dt")) || (y.getNodeName().contains("/wdt")) || (y.getNodeName().contains("/rb")) || (y.getNodeName().contains("/in")) || (y.getNodeName().contains("/cc")) || (y.getNodeName().contains("/cd")))
/*     */     {
/* 374 */       theScore = 0.1D;
/*     */     }
/*     */     
/* 377 */     return theScore;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<Node> getNodeList(String sent)
/*     */   {
/* 385 */     String[] tokens = sent.split("\\s+");
/* 386 */     ArrayList<Node> l = new ArrayList();
/*     */     String[] arrayOfString1;
/* 388 */     int j = (arrayOfString1 = tokens).length; for (int i = 0; i < j; i++) { String token = arrayOfString1[i];
/*     */       
/* 390 */       if (token.matches(".*(/nn|/jj|/vb[a-s]).*"))
/*     */       {
/* 392 */         Node n = (Node)this.wordNodeMap.get(token);
/*     */         
/* 394 */         if (n != null) {
/* 395 */           l.add(n);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 401 */     return l;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private double getOverallGain(double score, int level)
/*     */   {
/* 411 */     double oGain = score;
/*     */     
/* 413 */     if (CONFIG_NORMALIZE_OVERALLGAIN) {
/* 414 */       oGain /= level;
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
/* 425 */     return oGain;
/*     */   }
/*     */   
/*     */   private double getPathProb(Node x, Node y, double score, List l) {
/* 429 */     double pathProb = y.getSetencePathProb2(x.getNodeProb(), x.getSentenceIds(), 1.0D);
/* 430 */     double currOverlap = l.size();
/*     */     
/* 432 */     pathProb = currOverlap + score;
/*     */     
/* 434 */     return pathProb;
/*     */   }
/*     */   
/*     */   public double getSentenceJaccardOverlap(SentenceInfo s1, SentenceInfo s2) {
/* 438 */     List<Node> l1 = s1.theNodeList;
/* 439 */     List<Node> l2 = s2.theNodeList;
/*     */     
/* 441 */     HashSet union = new HashSet(l1);
/* 442 */     HashSet intersect = new HashSet(l1);
/*     */     
/* 444 */     union.addAll(l2);
/* 445 */     intersect.retainAll(l2);
/*     */     
/* 447 */     double overlap = intersect.size() / union.size();
/*     */     
/*     */ 
/* 450 */     return overlap;
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
/*     */   private boolean isValidEnd(Node x, int level, boolean concatOn)
/*     */   {
/* 473 */     boolean valid = false;
/*     */     
/*     */ 
/* 476 */     if (matchesEndPattern(x.getNodeName())) {
/* 477 */       return doCheck(level - 1, concatOn);
/*     */     }
/*     */     
/*     */ 
/* 481 */     if (this.mGraph2.outDegreeOf(x) <= 0) {
/* 482 */       return doCheck(level, concatOn);
/*     */     }
/*     */     
/*     */ 
/* 486 */     return valid;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean isValidSentence(Node x, List<int[]> overlapList, int level, double totalgain, String str)
/*     */   {
/* 492 */     boolean isGood = false;
/*     */     
/* 494 */     if (str.matches(".*(/jj)*.*(/nn)+.*(/vb)+.*(/jj)+.*")) {
/* 495 */       isGood = true;
/*     */ 
/*     */     }
/* 498 */     else if ((!str.matches(".*(/dt).*")) && (str.matches(".*(/rb)*.*(/jj)+.*(/nn)+.*"))) {
/* 499 */       isGood = true;
/*     */ 
/*     */     }
/* 502 */     else if (str.matches(".*(/prp|/dt)+.*(/vb)+.*(/rb|/jj)+.*(/nn)+.*")) {
/* 503 */       isGood = true;
/*     */ 
/*     */     }
/* 506 */     else if (str.matches(".*(/jj)+.*(/to)+.*(/vb).*")) {
/* 507 */       isGood = true;
/*     */ 
/*     */     }
/* 510 */     else if (str.matches(".*(/rb)+.*(/in)+.*(/nn)+.*")) {
/* 511 */       isGood = true;
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
/* 542 */     String last = str.substring(str.lastIndexOf(' '), str.length());
/* 543 */     if (last.matches(".*(/to|/vbz|/in|/cc|wdt|/prp|/dt|/,)")) {
/* 544 */       isGood = false;
/*     */     }
/*     */     
/* 547 */     return isGood;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean matchesEndPattern(String str)
/*     */   {
/* 559 */     if (str.matches(".*(/\\.|/,)")) {
/* 560 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 564 */     return false;
/*     */   }
/*     */   
/*     */   private void print() {
/* 568 */     System.out.print("");
/*     */   }
/*     */   
/*     */   private void print(String str)
/*     */   {
/* 573 */     System.out.print(str + " ");
/*     */   }
/*     */   
/*     */   private void println(String str) {
/* 577 */     System.out.println(str + " ");
/*     */   }
/*     */   
/*     */   private boolean processFound() {
/* 581 */     boolean success = false;
/* 582 */     Collection<SentenceInfo> temp = this.tempCollapsed.values();
/* 583 */     HashSet<SentenceInfo> collapsed = new HashSet(temp);
/*     */     
/* 585 */     collapsed = removeDuplicates(collapsed, true);
/*     */     
/* 587 */     int i = 0;
/* 588 */     if (collapsed.size() > 1)
/*     */     {
/* 590 */       double overallgains = 0.0D;
/* 591 */       double allscores = this.beforeAttachScore;
/* 592 */       double allgains = this.beforeAttachGain;
/* 593 */       int alllevels = this.originalLevel;
/*     */       
/* 595 */       StringBuffer buffer = new StringBuffer(this.beforeAttach);
/* 596 */       List<int[]> sentList = new ArrayList();
/*     */       
/* 598 */       for (SentenceInfo theInfo : collapsed)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 603 */         overallgains += theInfo.gain;
/* 604 */         allgains += theInfo.localgain;
/* 605 */         allscores += theInfo.rawscore;
/* 606 */         alllevels += theInfo.level;
/* 607 */         sentList.addAll(theInfo.sentList);
/* 608 */         if ((i > 0) && (i == collapsed.size() - 1)) {
/* 609 */           buffer.append(" and ");
/*     */         }
/* 611 */         else if (i > 0) {
/* 612 */           buffer.append(" , ");
/*     */         }
/*     */         else {
/* 615 */           buffer.append(" ");
/*     */         }
/* 617 */         buffer.append(theInfo.sent);
/* 618 */         i++;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 623 */       if (this.beforeAttach.contains("service was")) {
/* 624 */         print();
/*     */       }
/* 626 */       if (this.tempCollapsed.size() > 1)
/*     */       {
/* 628 */         double overallGain = overallgains / this.tempCollapsed.size();
/*     */         
/*     */ 
/* 631 */         this.shortlisted.add(new SentenceInfo(overallGain, buffer.toString(), sentList, alllevels));
/*     */         
/* 633 */         success = true;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 640 */     this.tempCollapsed.clear();
/* 641 */     this.beforeAttach = "";
/* 642 */     this.beforeAttachGain = 0.0D;
/* 643 */     this.beforeAttachScore = 0.0D;
/* 644 */     this.originalLevel = 0;
/*     */     
/* 646 */     return success;
/*     */   }
/*     */   
/*     */   private void processNext(Node x, String str, Set<DefaultWeightedEdge> outgoing, List<int[]> overlapList, double pathscore, int level, boolean concatOn) {
/* 650 */     Iterator<DefaultWeightedEdge> iter = outgoing.iterator();
/* 651 */     boolean doMore = true;
/* 652 */     while ((iter.hasNext()) && (doMore))
/*     */     {
/* 654 */       DefaultWeightedEdge edgeOfX = (DefaultWeightedEdge)iter.next();
/*     */       
/* 656 */       Node y = (Node)this.mGraph2.getEdgeTarget(edgeOfX);
/* 657 */       String yNodeName = y.getNodeName();
/* 658 */       List<int[]> YintersectX = y.getSetenceOverlapRight(overlapList);
/*     */       
/*     */ 
/* 661 */       double wt = getGreedyWeight(y);
/*     */       
/*     */ 
/*     */ 
/* 665 */       if (YintersectX.size() > 0) {
/* 666 */         int newLevel = level + 1;
/* 667 */         double newPathScore = getCurrentGain(pathscore, YintersectX.size(), newLevel);
/*     */         
/*     */ 
/* 670 */         if ((CONFIG_TURN_ON_COLLAPSE) && (level >= CONFIG_ATTACHMENT_AFTER) && (!concatOn) && (YintersectX.size() <= overlapList.size()) && (x.getNodeName().matches(".*(/vb[a-z]|/in)")))
/*     */         {
/*     */ 
/* 673 */           boolean success = doCollapse(x, YintersectX, newPathScore, pathscore, str, overlapList, level, concatOn);
/*     */           
/* 675 */           if (!success)
/*     */           {
/* 677 */             String strTemp = str + " " + y.getNodeName();
/* 678 */             doMore = traverse(y, YintersectX, strTemp, newPathScore, newLevel, concatOn, false);
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 685 */           String strTemp = str + " " + yNodeName;
/* 686 */           doMore = traverse(y, YintersectX, strTemp, newPathScore, level + 1, concatOn, false);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private SentenceInfo remove(SentenceInfo currSentence, SentenceInfo best) {
/* 693 */     double temp = currSentence.gain;
/*     */     
/* 695 */     if ((best.gain < currSentence.gain) && (best.level <= currSentence.level))
/*     */     {
/* 697 */       best.discard = true;
/* 698 */       best = currSentence;
/*     */     }
/*     */     else
/*     */     {
/* 702 */       currSentence.discard = true;
/*     */     }
/*     */     
/* 705 */     return best;
/*     */   }
/*     */   
/*     */   private HashSet<SentenceInfo> removeDuplicates(HashSet<SentenceInfo> set, boolean isIntermediate)
/*     */   {
/* 710 */     HashSet<SentenceInfo> finalSentences = new HashSet();
/* 711 */     if (CONFIG_TURN_ON_DUP_ELIM)
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
/* 731 */       List<SentenceInfo> list = new ArrayList(set);
/*     */       
/* 733 */       for (int i = 0; i < list.size(); i++)
/*     */       {
/* 735 */         SentenceInfo info = (SentenceInfo)list.get(i);
/* 736 */         info.discard = false;
/* 737 */         List<Node> nl = getNodeList(info.sent);
/* 738 */         info.theNodeList = nl;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 749 */       int startFrom = 0;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 754 */       for (int a = 0; a < list.size(); a++)
/*     */       {
/*     */ 
/* 757 */         if (!((SentenceInfo)list.get(a)).discard)
/*     */         {
/* 759 */           SentenceInfo prevSentence = (SentenceInfo)list.get(a);
/* 760 */           SentenceInfo best = (SentenceInfo)list.get(a);
/*     */           
/*     */ 
/* 763 */           for (int b = 0; b < list.size(); b++)
/*     */           {
/*     */ 
/* 766 */             if ((!((SentenceInfo)list.get(b)).discard) && (a != b))
/*     */             {
/* 768 */               SentenceInfo currSentence = (SentenceInfo)list.get(b);
/* 769 */               double overlap = getSentenceJaccardOverlap(currSentence, best);
/*     */               
/*     */ 
/*     */ 
/* 773 */               if (isIntermediate)
/*     */               {
/* 775 */                 if (overlap > CONFIG_DUPLICATE_COLLAPSE_THRESHOLD)
/*     */                 {
/* 777 */                   best = remove(currSentence, best);
/*     */ 
/*     */                 }
/*     */                 
/*     */ 
/*     */               }
/* 783 */               else if (overlap > CONFIG_DUPLICATE_THRESHOLD)
/*     */               {
/* 785 */                 best = remove(currSentence, best);
/*     */               }
/*     */             }
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/* 793 */           finalSentences.add(best);
/* 794 */           best.discard = true;
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
/* 815 */       finalSentences = set;
/*     */     }
/* 817 */     return finalSentences;
/*     */   }
/*     */   
/*     */   private SentenceInfo removeFinal(SentenceInfo currSentence, SentenceInfo best) {
/* 821 */     double temp = currSentence.gain;
/*     */     
/* 823 */     if ((best.gain < currSentence.gain) && (best.level <= currSentence.level))
/*     */     {
/* 825 */       best.discard = true;
/* 826 */       best = currSentence;
/*     */     }
/*     */     else
/*     */     {
/* 830 */       currSentence.discard = true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 837 */     return best;
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
/*     */   private boolean shouldContinue(Node x, List<int[]> overlapList, int level, double score, String str)
/*     */   {
/* 850 */     if (level >= this.P_MAX_SENT_LENGTH) {
/* 851 */       return false;
/*     */     }
/*     */     
/* 854 */     if (score == Double.NEGATIVE_INFINITY) {
/* 855 */       return false;
/*     */     }
/*     */     
/* 858 */     if ((overlapList.size() < CONFIG_MIN_REDUNDANCY) && (!matchesEndPattern(x.getNodeName())))
/*     */     {
/* 860 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 869 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean traverse(Node x, List<int[]> overlapList, String str, double pathscore, int level, boolean concatOn, boolean overlapSame)
/*     */   {
/* 881 */     if (!shouldContinue(x, overlapList, level, pathscore, str))
/*     */     {
/*     */ 
/* 884 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 888 */     if (isValidEnd(x, level, concatOn)) {
/* 889 */       String tempStr = str;
/* 890 */       int tempLevel = level;
/* 891 */       double tempScore = pathscore;
/*     */       
/* 893 */       if (matchesEndPattern(x.getNodeName())) {
/* 894 */         tempStr = tempStr.substring(0, tempStr.lastIndexOf(" "));
/* 895 */         tempLevel = level - 1;
/*     */       }
/*     */       
/*     */ 
/* 899 */       double overallGain = getOverallGain(tempScore, tempLevel);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 904 */       if (isValidSentence(x, overlapList, tempLevel, overallGain, 
/* 905 */         this.beforeAttach + " " + tempStr))
/*     */       {
/*     */ 
/* 908 */         if (!concatOn) {
/* 909 */           this.shortlisted.add(new SentenceInfo(overallGain, tempStr, overlapList, tempLevel));
/*     */         }
/*     */         else {
/* 912 */           SentenceInfo sinfo = (SentenceInfo)this.tempCollapsed.get(tempStr);
/* 913 */           if (sinfo != null) {
/* 914 */             sinfo.gain = Math.max(sinfo.gain, overallGain);
/*     */           } else {
/* 916 */             sinfo = new SentenceInfo(overallGain, tempStr, overlapList, tempLevel - this.originalLevel, pathscore - this.beforeAttachScore, 0.0D - this.beforeAttachGain);
/* 917 */             this.tempCollapsed.put(tempStr, sinfo);
/*     */           }
/* 919 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 925 */     Set<DefaultWeightedEdge> outgoing = this.mGraph2.outgoingEdgesOf(x);
/* 926 */     if ((outgoing != null) && 
/* 927 */       (outgoing.size() > 0)) {
/* 928 */       processNext(x, str, outgoing, overlapList, pathscore, 
/* 929 */         level, concatOn);
/*     */     }
/*     */     
/*     */ 
/* 933 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isVEN(Node x)
/*     */   {
/* 940 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isValidPath(Node x)
/*     */   {
/* 946 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\com\opinosis\OpinosisSummarizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */