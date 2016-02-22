package org.jgrapht.event;

public abstract interface TraversalListener<V, E>
{
  public abstract void connectedComponentFinished(ConnectedComponentTraversalEvent paramConnectedComponentTraversalEvent);
  
  public abstract void connectedComponentStarted(ConnectedComponentTraversalEvent paramConnectedComponentTraversalEvent);
  
  public abstract void edgeTraversed(EdgeTraversalEvent<V, E> paramEdgeTraversalEvent);
  
  public abstract void vertexTraversed(VertexTraversalEvent<V> paramVertexTraversalEvent);
  
  public abstract void vertexFinished(VertexTraversalEvent<V> paramVertexTraversalEvent);
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\event\TraversalListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */