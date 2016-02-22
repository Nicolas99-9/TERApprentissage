package org.jgrapht.experimental.equivalence;

public abstract interface EquivalenceComparatorChain<E, C>
  extends EquivalenceComparator<E, C>
{
  public abstract void appendComparator(EquivalenceComparator paramEquivalenceComparator);
}


/* Location:              C:\Users\nicol_000\Downloads\opinosis-summarizer\OpinosisSummarizer-1.0\opinosis.jar!\org\jgrapht\experimental\equivalence\EquivalenceComparatorChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */