/*     */ package org.jgrapht.generate;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.VertexFactory;
/*     */ import org.jgrapht.graph.DefaultDirectedGraph;
/*     */ import org.jgrapht.graph.SimpleDirectedGraph;
/*     */ import org.jgrapht.graph.SimpleGraph;
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
/*     */ public class RandomGraphGenerator<V, E>
/*     */   implements GraphGenerator<V, E, V>
/*     */ {
/*  65 */   private static long seedUniquifier = 8682522807148012L;
/*     */   
/*     */   protected int numOfVertexes;
/*     */   
/*     */   protected int numOfEdges;
/*     */   
/*     */   protected Random randomizer;
/*     */   
/*     */   private long randomizerSeed;
/*     */   
/*     */ 
/*     */   public RandomGraphGenerator(int aNumOfVertexes, int aNumOfEdges)
/*     */   {
/*  78 */     if ((aNumOfVertexes < 0) || (aNumOfEdges < 0)) {
/*  79 */       throw new IllegalArgumentException("must be non-negative");
/*     */     }
/*  81 */     this.numOfVertexes = aNumOfVertexes;
/*  82 */     this.numOfEdges = aNumOfEdges;
/*     */     
/*  84 */     this.randomizerSeed = chooseRandomSeedOnce();
/*  85 */     this.randomizer = new Random(this.randomizerSeed);
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
/*     */   private static synchronized long chooseRandomSeedOnce()
/*     */   {
/* 101 */     return ++seedUniquifier + System.nanoTime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void resetRandomSeed()
/*     */   {
/* 109 */     this.randomizer.setSeed(this.randomizerSeed);
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
/*     */   public void generateGraph(Graph<V, E> target, VertexFactory<V> vertexFactory, Map<String, V> resultMap)
/*     */   {
/* 128 */     resetRandomSeed();
/*     */     
/*     */ 
/*     */ 
/* 132 */     Map<Integer, V> orderToVertexMap = 
/* 133 */       new HashMap(this.numOfVertexes);
/*     */     
/* 135 */     for (int i = 0; i < this.numOfVertexes; i++) {
/* 136 */       V currVertex = vertexFactory.createVertex();
/* 137 */       target.addVertex(currVertex);
/* 138 */       orderToVertexMap.put(Integer.valueOf(i), currVertex);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 143 */     EdgeTopologyFactory<V, E> edgesFactory = 
/* 144 */       edgeTopologyFactoryChooser(target, this.numOfEdges);
/* 145 */     if (!edgesFactory.isNumberOfEdgesValid(target, this.numOfEdges)) {
/* 146 */       throw new IllegalArgumentException(
/* 147 */         "numOfEdges is not valid for the graph type \n-> Invalid number Of Edges=" + 
/* 148 */         this.numOfEdges + " for:" + 
/* 149 */         " graph type=" + target.getClass() + 
/* 150 */         " ,number Of Vertexes=" + this.numOfVertexes + 
/* 151 */         "\n-> Advice: For the Max value , check the javadoc for" + 
/* 152 */         " org.jgrapht.generate.RandomGraphGenerator.DefaultEdgeTopologyFactory");
/*     */     }
/*     */     
/* 155 */     edgesFactory.createEdges(
/* 156 */       target, 
/* 157 */       orderToVertexMap, 
/* 158 */       this.numOfEdges, 
/* 159 */       this.randomizer);
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
/*     */   private EdgeTopologyFactory<V, E> edgeTopologyFactoryChooser(Graph<V, E> target, int numOfEdges)
/*     */   {
/* 174 */     return new DefaultEdgeTopologyFactory();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public class DefaultEdgeTopologyFactory<VV, EE>
/*     */     implements RandomGraphGenerator.EdgeTopologyFactory<VV, EE>
/*     */   {
/*     */     public DefaultEdgeTopologyFactory() {}
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
/*     */ 
/*     */ 
/*     */ 
/*     */     public void createEdges(Graph<VV, EE> targetGraph, Map<Integer, VV> orderToVertexMap, int numberOfEdges, Random randomizer)
/*     */     {
/* 246 */       int iterationsCounter = 0;
/* 247 */       int edgesCounter = 0;
/* 248 */       while (edgesCounter < numberOfEdges)
/*     */       {
/*     */ 
/* 251 */         VV startVertex = 
/* 252 */           orderToVertexMap.get(
/* 253 */           Integer.valueOf(randomizer.nextInt(RandomGraphGenerator.this.numOfVertexes)));
/* 254 */         VV endVertex = 
/* 255 */           orderToVertexMap.get(
/* 256 */           Integer.valueOf(randomizer.nextInt(RandomGraphGenerator.this.numOfVertexes)));
/*     */         try {
/* 258 */           EE resultEdge = targetGraph.addEdge(startVertex, endVertex);
/* 259 */           if (resultEdge != null) {
/* 260 */             edgesCounter++;
/*     */           }
/*     */         }
/*     */         catch (Exception localException) {}
/*     */         
/*     */ 
/* 266 */         iterationsCounter++;
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public boolean isNumberOfEdgesValid(Graph<VV, EE> targetGraph, int numberOfEdges)
/*     */     {
/* 336 */       boolean infinite = false;
/* 337 */       int maxAllowedEdges = getMaxEdgesForVertexNum(targetGraph);
/* 338 */       if (maxAllowedEdges == -1)
/* 339 */         infinite = true;
/*     */       boolean result;
/*     */       boolean result;
/* 342 */       if (infinite) {
/* 343 */         result = true; } else { boolean result;
/* 344 */         if (numberOfEdges <= maxAllowedEdges) {
/* 345 */           result = true;
/*     */         } else
/* 347 */           result = false;
/*     */       }
/* 349 */       return result;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getMaxEdgesForVertexNum(Graph<VV, EE> targetGraph)
/*     */     {
/* 357 */       int maxAllowedEdges = 0;
/* 358 */       if ((targetGraph instanceof SimpleGraph)) {
/* 359 */         maxAllowedEdges = RandomGraphGenerator.this.numOfVertexes * (RandomGraphGenerator.this.numOfVertexes - 1) / 2;
/* 360 */       } else if ((targetGraph instanceof SimpleDirectedGraph)) {
/* 361 */         maxAllowedEdges = RandomGraphGenerator.this.numOfVertexes * (RandomGraphGenerator.this.numOfVertexes - 1);
/* 362 */       } else if ((targetGraph instanceof DefaultDirectedGraph)) {
/* 363 */         maxAllowedEdges = RandomGraphGenerator.this.numOfVertexes * RandomGraphGenerator.this.numOfVertexes;
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 368 */         maxAllowedEdges = -1;
/*     */       }
/* 370 */       return maxAllowedEdges;
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract interface EdgeTopologyFactory<VV, EE>
/*     */   {
/*     */     public abstract void createEdges(Graph<VV, EE> paramGraph, Map<Integer, VV> paramMap, int paramInt, Random paramRandom);
/*     */     
/*     */     public abstract boolean isNumberOfEdgesValid(Graph<VV, EE> paramGraph, int paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\generate\RandomGraphGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */