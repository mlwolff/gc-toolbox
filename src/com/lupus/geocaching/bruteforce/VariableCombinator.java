package com.lupus.geocaching.bruteforce;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import com.lupus.geocaching.bruteforce.api.Variable;

/**
 * 
 * @author mlwolff
 *
 * @param <T>
 */
public class VariableCombinator<T extends Object> implements Iterable<VariableCombination<T>> {
    private final List<Variable<T>> variables;

    /**
     * 
     * @param variables
     */
    public VariableCombinator(Collection<Variable<T>> variables) {
        Objects.requireNonNull(variables);

        this.variables = new ArrayList<>(variables);
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
        private boolean allResetted = false;
        private boolean firstCall = true;
        
        /**
         * Private constructor.
         * <p>
         * Only for usage from {@link VariableCombinator}.
         * </p>
         * 
         * @param initialVariableCombination
         */
        @SuppressWarnings("unchecked")
        private VariablesIterator(List<Variable<T>> initialVariableCombination) {
            Objects.requireNonNull(initialVariableCombination);
            
            currentCombination = new VariableCombination<>(initialVariableCombination);
        }
        
        /*
         * (non-Javadoc)
         * @see java.util.Iterator#hasNext()
         */
        @Override
        public boolean hasNext() {
            return !allResetted;
        }

        /*
         * (non-Javadoc)
         * @see java.util.Iterator#next()
         */
        @Override
        public VariableCombination<T> next() {
            if (!firstCall) {
                calculateNextIteration();
            }
            
            firstCall = false;
            
            return currentCombination;
        }

        /**
         * Internel helper for calculation of the next iteration.
         */
        private void calculateNextIteration() {
            int resetCnt = 0;
            boolean resetted = false;
            
            do {
                resetted = currentCombination.get(resetCnt).increment();
            } while (resetted && ++resetCnt < currentCombination.size());
            
            allResetted = (resetCnt == currentCombination.size());
        }
        
    }
}
