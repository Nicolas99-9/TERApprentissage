package org.jgrapht.event;

import java.util.EventListener;

public abstract interface VertexSetListener<V>
  extends EventListener
{
  public abstract void vertexAdded(GraphVertexChangeEvent<V> paramGraphVertexChangeEvent);
  
  public abstract void vertexRemoved(GraphVertexChangeEvent<V> paramGraphVertexChangeEvent);
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\event\VertexSetListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */