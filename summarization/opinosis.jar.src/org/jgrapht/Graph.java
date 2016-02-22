package org.jgrapht;

import java.util.Collection;
import java.util.Set;

public abstract interface Graph<V, E>
{
  public abstract Set<E> getAllEdges(V paramV1, V paramV2);
  
  public abstract E getEdge(V paramV1, V paramV2);
  
  public abstract EdgeFactory<V, E> getEdgeFactory();
  
  public abstract E addEdge(V paramV1, V paramV2);
  
  public abstract boolean addEdge(V paramV1, V paramV2, E paramE);
  
  public abstract boolean addVertex(V paramV);
  
  public abstract boolean containsEdge(V paramV1, V paramV2);
  
  public abstract boolean containsEdge(E paramE);
  
  public abstract boolean containsVertex(V paramV);
  
  public abstract Set<E> edgeSet();
  
  public abstract Set<E> edgesOf(V paramV);
  
  public abstract boolean removeAllEdges(Collection<? extends E> paramCollection);
  
  public abstract Set<E> removeAllEdges(V paramV1, V paramV2);
  
  public abstract boolean removeAllVertices(Collection<? extends V> paramCollection);
  
  public abstract E removeEdge(V paramV1, V paramV2);
  
  public abstract boolean removeEdge(E paramE);
  
  public abstract boolean removeVertex(V paramV);
  
  public abstract Set<V> vertexSet();
  
  public abstract V getEdgeSource(E paramE);
  
  public abstract V getEdgeTarget(E paramE);
  
  public abstract double getEdgeWeight(E paramE);
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\Graph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */