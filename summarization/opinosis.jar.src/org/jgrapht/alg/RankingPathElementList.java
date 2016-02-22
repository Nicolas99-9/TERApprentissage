/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.jgrapht.Graph;
/*     */ import org.jgrapht.Graphs;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class RankingPathElementList<V, E>
/*     */   extends AbstractPathElementList<V, E, RankingPathElement<V, E>>
/*     */ {
/*     */   RankingPathElementList(Graph<V, E> graph, int maxSize, RankingPathElement<V, E> pathElement)
/*     */   {
/*  70 */     super(graph, maxSize, pathElement);
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
/*     */   RankingPathElementList(Graph<V, E> graph, int maxSize, RankingPathElementList<V, E> elementList, E edge)
/*     */   {
/*  88 */     super(graph, maxSize, elementList, edge);
/*     */     
/*     */ 
/*  91 */     for (int i = 0; i < elementList.size(); i++) {
/*  92 */       RankingPathElement<V, E> prevPathElement = (RankingPathElement)elementList.get(i);
/*  93 */       if (this.pathElements.size() <= this.maxSize - 1) {
/*  94 */         double weight = calculatePathWeight(prevPathElement, edge);
/*  95 */         RankingPathElement<V, E> newPathElement = 
/*  96 */           new RankingPathElement(
/*  97 */           this.graph, 
/*  98 */           prevPathElement, 
/*  99 */           edge, 
/* 100 */           weight);
/*     */         
/*     */ 
/* 103 */         this.pathElements.add(newPathElement);
/*     */       }
/*     */     }
/*     */     
/* 107 */     assert (!this.pathElements.isEmpty());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected RankingPathElementList(RankingPathElementList<V, E> original)
/*     */   {
/* 117 */     super(original);
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
/*     */   public boolean addPathElements(RankingPathElementList<V, E> elementList, E edge)
/*     */   {
/* 137 */     assert (this.vertex
/* 138 */       .equals(Graphs.getOppositeVertex(
/* 139 */       this.graph, 
/* 140 */       edge, 
/* 141 */       elementList.getVertex())));
/*     */     
/* 143 */     boolean pathAdded = false;
/*     */     
/*     */ 
/*     */ 
/* 147 */     int vIndex = 0;int yIndex = 0;
/* 148 */     for (; vIndex < elementList.size(); 
/* 149 */         vIndex++)
/*     */     {
/* 151 */       RankingPathElement<V, E> prevPathElement = (RankingPathElement)elementList.get(vIndex);
/* 152 */       if ((!isAlreadyImprovedByThisEdge(edge, prevPathElement)) && 
/* 153 */         (!containsTargetPreviously(prevPathElement)))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/* 158 */         double weight = calculatePathWeight(prevPathElement, edge);
/* 162 */         for (; 
/*     */             
/*     */ 
/* 162 */             yIndex < size(); yIndex++) {
/* 163 */           RankingPathElement<V, E> yPathElement = (RankingPathElement)get(yIndex);
/* 164 */           RankingPathElement<V, E> newPathElement = 
/* 165 */             new RankingPathElement(
/* 166 */             this.graph, 
/* 167 */             prevPathElement, 
/* 168 */             edge, 
/* 169 */             weight);
/*     */           
/* 171 */           if (weight < yPathElement.getWeight()) {
/* 172 */             this.pathElements.add(yIndex, newPathElement);
/* 173 */             if (size() > this.maxSize) {
/* 174 */               this.pathElements.remove(this.maxSize);
/*     */             }
/* 176 */             pathAdded = true;
/* 177 */             break;
/*     */           }
/* 179 */           if (weight == yPathElement.getWeight())
/*     */           {
/* 181 */             if (isAlreadyAdded(newPathElement)) {
/*     */               break;
/*     */             }
/*     */             
/* 185 */             if (size() <= this.maxSize - 1) {
/* 186 */               this.pathElements.add(yIndex + 1, newPathElement);
/* 187 */               if (size() > this.maxSize) {
/* 188 */                 this.pathElements.remove(this.maxSize);
/*     */               }
/* 190 */               pathAdded = true;
/* 191 */               break;
/*     */             }
/*     */           }
/*     */           
/* 195 */           if ((weight > yPathElement.getWeight()) && 
/* 196 */             (yIndex == size() - 1))
/*     */           {
/* 198 */             if (size() <= this.maxSize - 1) {
/* 199 */               this.pathElements.add(newPathElement);
/* 200 */               pathAdded = true;
/* 201 */               break;
/*     */             } }
/*     */         }
/*     */       }
/*     */     }
/* 206 */     return pathAdded;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   List<RankingPathElement<V, E>> getPathElements()
/*     */   {
/* 214 */     return this.pathElements;
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
/*     */   private double calculatePathWeight(RankingPathElement<V, E> pathElement, E edge)
/*     */   {
/* 232 */     double pathWeight = this.graph.getEdgeWeight(edge);
/*     */     
/*     */ 
/* 235 */     if (pathElement.getPrevEdge() != null) {
/* 236 */       pathWeight += pathElement.getWeight();
/*     */     }
/*     */     
/* 239 */     return pathWeight;
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
/*     */   private boolean containsTargetPreviously(RankingPathElement<V, E> pathElement)
/*     */   {
/* 253 */     RankingPathElement<V, E> tempPathElement = pathElement;
/* 254 */     while (tempPathElement.getPrevEdge() != null) {
/* 255 */       if (tempPathElement.getVertex() == this.vertex) {
/* 256 */         return true;
/*     */       }
/* 258 */       tempPathElement = tempPathElement.getPrevPathElement();
/*     */     }
/*     */     
/* 261 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isAlreadyAdded(RankingPathElement<V, E> pathElement)
/*     */   {
/* 266 */     for (int i = 0; i <= size() - 1; i++) {
/* 267 */       RankingPathElement<V, E> yPathElement = (RankingPathElement)get(i);
/* 268 */       RankingPathElement<V, E> pathElementToTest = pathElement;
/* 269 */       if (!isDifferent(yPathElement, pathElementToTest)) {
/* 270 */         return true;
/*     */       }
/*     */     }
/* 273 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean isAlreadyImprovedByThisEdge(E edge, RankingPathElement<V, E> prevPathElement)
/*     */   {
/* 280 */     RankingPathElement<V, E> pathElementToTest = prevPathElement;
/* 281 */     while (pathElementToTest.getPrevEdge() != null) {
/* 282 */       if (pathElementToTest.getPrevEdge() == edge) {
/* 283 */         return true;
/*     */       }
/* 285 */       pathElementToTest = pathElementToTest.getPrevPathElement();
/*     */     }
/* 287 */     return false;
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
/*     */   private boolean isDifferent(RankingPathElement<V, E> yPathElement, RankingPathElement<V, E> pathElementToTest)
/*     */   {
/* 302 */     while ((yPathElement.getPrevEdge() != null) || 
/* 303 */       (pathElementToTest.getPrevEdge() != null))
/*     */     {
/* 305 */       if (yPathElement.getPrevEdge() != pathElementToTest.getPrevEdge()) {
/* 306 */         return true;
/*     */       }
/* 308 */       yPathElement = yPathElement.getPrevPathElement();
/* 309 */       pathElementToTest = pathElementToTest.getPrevPathElement();
/*     */     }
/*     */     
/* 312 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\RankingPathElementList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */