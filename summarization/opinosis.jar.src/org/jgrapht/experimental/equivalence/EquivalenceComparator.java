package org.jgrapht.experimental.equivalence;

public abstract interface EquivalenceComparator<E, C>
{
  public abstract boolean equivalenceCompare(E paramE1, E paramE2, C paramC1, C paramC2);
  
  public abstract int equivalenceHashcode(E paramE, C paramC);
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\equivalence\EquivalenceComparator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */