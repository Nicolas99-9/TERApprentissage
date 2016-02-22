package org.jgrapht;

import org.jgrapht.event.GraphListener;
import org.jgrapht.event.VertexSetListener;

public abstract interface ListenableGraph<V, E>
  extends Graph<V, E>
{
  public abstract void addGraphListener(GraphListener<V, E> paramGraphListener);
  
  public abstract void addVertexSetListener(VertexSetListener<V> paramVertexSetListener);
  
  public abstract void removeGraphListener(GraphListener<V, E> paramGraphListener);
  
  public abstract void removeVertexSetListener(VertexSetListener<V> paramVertexSetListener);
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\ListenableGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */