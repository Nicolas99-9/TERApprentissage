package org.jgrapht.event;

public class TraversalListenerAdapter<V, E>
  implements TraversalListener<V, E>
{
  public void connectedComponentFinished(ConnectedComponentTraversalEvent e) {}
  
  public void connectedComponentStarted(ConnectedComponentTraversalEvent e) {}
  
  public void edgeTraversed(EdgeTraversalEvent<V, E> e) {}
  
  public void vertexTraversed(VertexTraversalEvent<V> e) {}
  
  public void vertexFinished(VertexTraversalEvent<V> e) {}
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\event\TraversalListenerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */