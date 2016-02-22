package org.jgrapht;

import java.util.Set;

public abstract interface DirectedGraph<V, E>
  extends Graph<V, E>
{
  public abstract int inDegreeOf(V paramV);
  
  public abstract Set<E> incomingEdgesOf(V paramV);
  
  public abstract int outDegreeOf(V paramV);
  
  public abstract Set<E> outgoingEdgesOf(V paramV);
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\DirectedGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */