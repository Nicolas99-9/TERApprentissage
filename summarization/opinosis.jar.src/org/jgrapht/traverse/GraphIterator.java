package org.jgrapht.traverse;

import java.util.Iterator;
import org.jgrapht.event.TraversalListener;

public abstract interface GraphIterator<V, E>
  extends Iterator<V>
{
  public abstract boolean isCrossComponentTraversal();
  
  public abstract void setReuseEvents(boolean paramBoolean);
  
  public abstract boolean isReuseEvents();
  
  public abstract void addTraversalListener(TraversalListener<V, E> paramTraversalListener);
  
  public abstract void remove();
  
  public abstract void removeTraversalListener(TraversalListener<V, E> paramTraversalListener);
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\traverse\GraphIterator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */