package org.jgrapht;

import java.util.List;

public abstract interface GraphPath<V, E>
{
  public abstract Graph<V, E> getGraph();
  
  public abstract V getStartVertex();
  
  public abstract V getEndVertex();
  
  public abstract List<E> getEdgeList();
  
  public abstract double getWeight();
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\GraphPath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */