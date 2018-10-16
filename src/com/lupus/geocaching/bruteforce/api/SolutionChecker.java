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
     * 
     * @param combination
     * @return
     */
    boolean checkSolution(VariableCombination<T> combination);
}
