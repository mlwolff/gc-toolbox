package com.lupus.geocaching.bruteforce;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 
 * @author mlwolff
 *
 * @param <T>
 */
public class VariableCombinator<T extends Object> implements Iterable<VariableCombination<T>> {
    private final VariableCombination<T> variables;

    /**
     * 
     * @param combination
     *      Initial {@link VariableCombination}
     */
    public VariableCombinator(VariableCombination<T> combination) {
        Objects.requireNonNull(combination);

        this.variables = combination;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    @Override
    public Iterator<VariableCombination<T>> iterator() {
        return new VariablesIterator<>(variables);
    }

    /**
     * 
     * @author mlwolff
     *
     */
    public static class VariablesIterator<T extends Object> implements Iterator<VariableCombination<T>> {
        private final VariableCombination<T> currentCombination;
        private boolean hasNext = true;
        private boolean calculated = true;
        
        /**
         * Private constructor.
         * <p>
         * Only for usage from {@link VariableCombinator}.
         * </p>
         * 
         * @param initialVariableCombination
         */
        private VariablesIterator(VariableCombination<T> initialVariableCombination) {
            Objects.requireNonNull(initialVariableCombination);
            
            currentCombination = new VariableCombination<>(initialVariableCombination.getVariables());
        }
        
        /*
         * (non-Javadoc)
         * @see java.util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {
            if (!calculated) {
                hasNext = !calculateNextIteration();
                calculated = true;
            }
            return hasNext;
        }

        /*
         * (non-Javadoc)
         * @see java.util.Iterator#next()
         */
        @Override
        public VariableCombination<T> next() {
            if (hasNext()) {
                calculated = false;
                return currentCombination;
            }
            
            throw new NoSuchElementException("No more combinations available.");
        }

        /**
         * Internal helper for calculation of the next iteration.
         * 
         * @return
         *      <code>true</code>, if all variables has been resetted.
         */
        private boolean calculateNextIteration() {
            int resetCnt = 0;
            boolean resetted = false;
            
            do {
                // Increments variable at pos 'resetCnt'
                resetted = currentCombination.get(resetCnt).increment();
            } while (resetted && ++resetCnt < currentCombination.size());
            
            return (resetCnt == currentCombination.size());
        }
        
    }
}
