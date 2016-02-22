package org.jgrapht.experimental.isomorphism;

import java.util.Iterator;

public abstract interface GraphIsomorphismInspector<E>
  extends Iterator<E>
{
  public abstract boolean isIsomorphic();
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\isomorphism\GraphIsomorphismInspector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */