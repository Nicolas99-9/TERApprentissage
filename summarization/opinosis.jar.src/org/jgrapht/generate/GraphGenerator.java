package org.jgrapht.generate;

import java.util.Map;
import org.jgrapht.Graph;
import org.jgrapht.VertexFactory;

public abstract interface GraphGenerator<V, E, T>
{
  public abstract void generateGraph(Graph<V, E> paramGraph, VertexFactory<V> paramVertexFactory, Map<String, T> paramMap);
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\generate\GraphGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */