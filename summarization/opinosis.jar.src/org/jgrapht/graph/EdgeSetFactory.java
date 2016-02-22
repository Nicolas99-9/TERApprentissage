package org.jgrapht.graph;

import java.util.Set;

public abstract interface EdgeSetFactory<V, E>
{
  public abstract Set<E> createEdgeSet(V paramV);
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\EdgeSetFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */