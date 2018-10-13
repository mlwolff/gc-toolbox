package com.lupus.geocaching.bruteforce.api;

import java.util.List;

/**
 * 
 * @author mlwolff
 *
 * @param <T>
 */
public interface SolutionChecker<T> {
    
    /**
     * 
     * @param variables
     * @return
     */
    boolean checkSolution(List<Variable<T>> variables);
}
