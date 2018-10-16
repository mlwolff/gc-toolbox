package com.lupus.geocaching.bruteforce.test;

import java.util.List;

import com.lupus.geocaching.bruteforce.VariableCombination;
import com.lupus.geocaching.bruteforce.api.SolutionChecker;
import com.lupus.geocaching.bruteforce.api.Variable;

public class SevenEightChecker implements SolutionChecker<Integer> {

    /*
     * (non-Javadoc)
     * @see com.lupus.geocaching.bruteforce.api.SolutionChecker#checkSolution(com.lupus.geocaching.bruteforce.VariableCombination)
     */
    @Override
    public boolean checkSolution(VariableCombination<Integer> combination) {
        List<Variable<Integer>> variables = combination.getVariables();
        
        return !variables.stream().anyMatch(v -> v.getValue() != 7 && v.getValue() != 8);
    }

}
