/*     */ package org.jgrapht.alg;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.jgrapht.Graph;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BronKerboschCliqueFinder<V, E>
/*     */ {
/*     */   private final Graph<V, E> graph;
/*     */   private Collection<Set<V>> cliques;
/*     */   
/*     */   public BronKerboschCliqueFinder(Graph<V, E> graph)
/*     */   {
/*  74 */     this.graph = graph;
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
/*     */   public Collection<Set<V>> getAllMaximalCliques()
/*     */   {
/*  91 */     this.cliques = new ArrayList();
/*  92 */     List<V> potential_clique = new ArrayList();
/*  93 */     List<V> candidates = new ArrayList();
/*  94 */     List<V> already_found = new ArrayList();
/*  95 */     candidates.addAll(this.graph.vertexSet());
/*  96 */     findCliques(potential_clique, candidates, already_found);
/*  97 */     return this.cliques;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Collection<Set<V>> getBiggestMaximalCliques()
/*     */   {
/* 109 */     getAllMaximalCliques();
/*     */     
/* 111 */     int maximum = 0;
/* 112 */     Collection<Set<V>> biggest_cliques = new ArrayList();
/* 113 */     for (Set<V> clique : this.cliques) {
/* 114 */       if (maximum < clique.size()) {
/* 115 */         maximum = clique.size();
/*     */       }
/*     */     }
/* 118 */     for (Set<V> clique : this.cliques) {
/* 119 */       if (maximum == clique.size()) {
/* 120 */         biggest_cliques.add(clique);
/*     */       }
/*     */     }
/* 123 */     return biggest_cliques;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void findCliques(List<V> potential_clique, List<V> candidates, List<V> already_found)
/*     */   {
/* 131 */     List<V> candidates_array = new ArrayList(candidates);
/* 132 */     if (!end(candidates, already_found))
/*     */     {
/* 134 */       for (V candidate : candidates_array) {
/* 135 */         List<V> new_candidates = new ArrayList();
/* 136 */         List<V> new_already_found = new ArrayList();
/*     */         
/*     */ 
/* 139 */         potential_clique.add(candidate);
/* 140 */         candidates.remove(candidate);
/*     */         
/*     */ 
/*     */ 
/* 144 */         for (V new_candidate : candidates) {
/* 145 */           if (this.graph.containsEdge(candidate, new_candidate)) {
/* 146 */             new_candidates.add(new_candidate);
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 152 */         for (V new_found : already_found) {
/* 153 */           if (this.graph.containsEdge(candidate, new_found)) {
/* 154 */             new_already_found.add(new_found);
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 159 */         if ((new_candidates.isEmpty()) && (new_already_found.isEmpty()))
/*     */         {
/* 161 */           this.cliques.add(new HashSet(potential_clique));
/*     */         }
/*     */         else
/*     */         {
/* 165 */           findCliques(
/* 166 */             potential_clique, 
/* 167 */             new_candidates, 
/* 168 */             new_already_found);
/*     */         }
/*     */         
/*     */ 
/* 172 */         already_found.add(candidate);
/* 173 */         potential_clique.remove(candidate);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean end(List<V> candidates, List<V> already_found)
/*     */   {
/* 181 */     boolean end = false;
/*     */     
/* 183 */     for (V found : already_found) {
/* 184 */       int edgecounter = 0;
/* 185 */       for (V candidate : candidates) {
/* 186 */         if (this.graph.containsEdge(found, candidate)) {
/* 187 */           edgecounter++;
/*     */         }
/*     */       }
/* 190 */       if (edgecounter == candidates.size()) {
/* 191 */         end = true;
/*     */       }
/*     */     }
/* 194 */     return end;
/*     */   }
/*     */ }


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\alg\BronKerboschCliqueFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */