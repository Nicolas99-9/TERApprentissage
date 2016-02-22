/*     */ package com.opinosis;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.PrintStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.graph.DefaultWeightedEdge;
/*     */ import org.jgrapht.graph.SimpleDirectedWeightedGraph;
/*     */ import org.textbug.utility.FileUtil;
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
/*     */ public class OpinosisGraphBuilder<T>
/*     */   extends GraphBuilder
/*     */ {
/*     */   SimpleDirectedWeightedGraph<Node, DefaultWeightedEdge> graph;
/*  26 */   HashMap<String, Node> wordNodeMap = new HashMap();
/*     */   
/*     */ 
/*  29 */   private HashSet<String> mStopWords = new HashSet();
/*     */   
/*     */   public OpinosisGraphBuilder()
/*     */   {
/*  33 */     this.graph = new SimpleDirectedWeightedGraph(DefaultWeightedEdge.class);
/*  34 */     loadStopWords();
/*     */   }
/*     */   
/*     */ 
/*     */   public SimpleDirectedWeightedGraph<Node, DefaultWeightedEdge> getGraph()
/*     */   {
/*  40 */     return this.graph;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public HashMap<String, Node> growGraph(String str, int docid, int sid)
/*     */   {
/*  48 */     return growSentenceGraph(str, docid, sid);
/*     */   }
/*     */   
/*     */ 
/*     */   private void loadStopWords()
/*     */   {
/*  54 */     String stopWord = "";
/*     */     try {
/*  56 */       BufferedReader reader = 
/*  57 */         FileUtil.getResourceFromPackage("com/opinosis/resources/stoplist.txt");
/*  58 */       while ((stopWord = reader.readLine()) != null) {
/*  59 */         stopWord = stopWord.trim();
/*  60 */         this.mStopWords.add(stopWord);
/*     */       }
/*     */     }
/*     */     catch (Exception exception) {
/*  64 */       exception.printStackTrace();
/*  65 */       System.exit(-1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private HashMap growSentenceGraph(String str, int docid, int sid)
/*     */   {
/*  72 */     String[] words = str.split(" ");
/*  73 */     Node prevVertex = null;
/*  74 */     Node currVertex = null;
/*     */     
/*  76 */     boolean isPrevVertexNew = true;
/*  77 */     boolean isCurrVertexNew = true;
/*  78 */     int pos = 0;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  83 */     for (int i = 0; i < words.length; i++)
/*     */     {
/*  85 */       String word = words[i].trim();
/*  86 */       if (word.length() != 0)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  91 */         isCurrVertexNew = true;
/*     */         
/*  93 */         if (this.wordNodeMap.containsKey(word))
/*     */         {
/*  95 */           isCurrVertexNew = false;
/*  96 */           currVertex = (Node)this.wordNodeMap.get(word);
/*  97 */           currVertex.addDocId(docid);
/*  98 */           currVertex.addSentenceId(sid, i);
/*     */         }
/*     */         else {
/* 101 */           currVertex = new Node();
/* 102 */           currVertex.setNodeName(word);
/* 103 */           currVertex.addDocId(docid);
/* 104 */           currVertex.addSentenceId(sid, i);
/* 105 */           this.graph.addVertex(currVertex);
/* 106 */           isCurrVertexNew = true;
/* 107 */           this.wordNodeMap.put(word, currVertex);
/*     */         }
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
/* 120 */         if ((isCurrVertexNew) || (isPrevVertexNew)) {
/* 121 */           if (prevVertex != null)
/*     */           {
/*     */ 
/* 124 */             if ((!currVertex.equals(prevVertex)) && (canAdd(prevVertex))) {
/* 125 */               this.graph.addEdge(prevVertex, currVertex);
/*     */             }
/*     */             
/*     */           }
/*     */           
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 134 */           DefaultWeightedEdge e = (DefaultWeightedEdge)this.graph.getEdge(prevVertex, currVertex);
/* 135 */           if (e == null)
/*     */           {
/*     */             try
/*     */             {
/* 139 */               if ((currVertex.equals(prevVertex)) || (!canAdd(prevVertex))) break label328;
/* 140 */               this.graph.addEdge(prevVertex, currVertex);
/*     */             }
/*     */             catch (IllegalArgumentException e1)
/*     */             {
/* 144 */               System.err.println("Problem Linking '" + prevVertex + "'  and '" + currVertex + "'");
/*     */             }
/*     */             
/*     */           }
/*     */           else
/*     */           {
/* 150 */             double wt = 0.0D;
/* 151 */             wt = this.graph.getEdgeWeight(e) + 1.0D;
/* 152 */             this.graph.setEdgeWeight(e, wt);
/*     */           }
/*     */         }
/*     */         
/*     */         label328:
/* 157 */         prevVertex = currVertex;
/* 158 */         isPrevVertexNew = isCurrVertexNew;
/*     */       }
/*     */     }
/* 161 */     return this.wordNodeMap;
/*     */   }
/*     */   
/*     */   private boolean canAdd(Node prevVertex)
/*     */   {
/* 166 */     if (prevVertex.getNodeName().matches("(\\./\\.|!/!|\\?/\\?)")) {
/* 167 */       return false;
/*     */     }
/*     */     
/* 170 */     return true;
/*     */   }
/*     */   
/*     */   public void printGraph()
/*     */   {
/* 175 */     if (this.graph != null) {
/* 176 */       System.out.println(this.graph.toString());
/*     */     }
/* 178 */     Set<Node> vertexSet = this.graph.vertexSet();
/*     */     
/* 180 */     Iterator<Node> vIter = vertexSet.iterator();
/* 181 */     System.out.println("digraph{");
/*     */     Iterator<DefaultWeightedEdge> edgeIterator;
/* 183 */     for (; vIter.hasNext(); 
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 188 */         edgeIterator.hasNext())
/*     */     {
/* 184 */       Node v = (Node)vIter.next();
/* 185 */       Set<DefaultWeightedEdge> edges = this.graph.edgesOf(v);
/* 186 */       edgeIterator = edges.iterator();
/*     */       
/* 188 */       continue;
/*     */       
/* 190 */       DefaultWeightedEdge e = (DefaultWeightedEdge)edgeIterator.next();
/* 191 */       String target = ((Node)this.graph.getEdgeTarget(e)).getNodeName();
/* 192 */       String source = ((Node)this.graph.getEdgeSource(e)).getNodeName();
/* 193 */       if (!target.equals(v.getNodeName())) {
/* 194 */         System.out.println(v.getNodeName() + "->" + target + ";");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 199 */     System.out.println("}");
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\com\opinosis\OpinosisGraphBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */