package com.lupus.geocaching.bruteforce.api;

import com.lupus.geocaching.bruteforce.VariableCombination;

/**
 * 
 * @author mlwolff
 *
 * @param <T>
 */
public interface SolutionChecker<T> {
    
    /**
     * Checks if the passed {@link VariableCombination} matches the solution requirements
     * @param combination
     *      {@code VariableCombination} to check.
     * @return
     *      <code>true</code>, if combination matches solution requirements.
     */
    boolean checkSolution(VariableCombination<T> combination);
}
