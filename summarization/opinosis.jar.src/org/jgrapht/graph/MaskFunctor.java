package org.jgrapht.graph;

public abstract interface MaskFunctor<V, E>
{
  public abstract boolean isEdgeMasked(E paramE);
  
  public abstract boolean isVertexMasked(V paramV);
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\graph\MaskFunctor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */