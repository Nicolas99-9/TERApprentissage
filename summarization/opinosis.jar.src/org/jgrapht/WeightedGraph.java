package org.jgrapht;

public abstract interface WeightedGraph<V, E>
  extends Graph<V, E>
{
  public static final double DEFAULT_EDGE_WEIGHT = 1.0D;
  
  public abstract void setEdgeWeight(E paramE, double paramDouble);
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\WeightedGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */