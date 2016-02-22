package org.jgrapht;

public abstract interface GraphMapping<V, E>
{
  public abstract V getVertexCorrespondence(V paramV, boolean paramBoolean);
  
  public abstract E getEdgeCorrespondence(E paramE, boolean paramBoolean);
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\GraphMapping.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */