package org.jgrapht.event;

public abstract interface GraphListener<V, E>
  extends VertexSetListener<V>
{
  public abstract void edgeAdded(GraphEdgeChangeEvent<V, E> paramGraphEdgeChangeEvent);
  
  public abstract void edgeRemoved(GraphEdgeChangeEvent<V, E> paramGraphEdgeChangeEvent);
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\event\GraphListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */