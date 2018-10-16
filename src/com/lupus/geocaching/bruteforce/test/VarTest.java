package com.lupus.geocaching.bruteforce.test;

import java.util.Arrays;
import java.util.List;

import com.lupus.geocaching.bruteforce.VariableCombination;
import com.lupus.geocaching.bruteforce.VariableCombinator;
import com.lupus.geocaching.bruteforce.api.SolutionChecker;
import com.lupus.geocaching.bruteforce.api.Variable;
import com.lupus.geocaching.bruteforce.digit.DigitVariable;

public class VarTest {

    public static void main(String[] args) {
        final DigitVariable varA = new DigitVariable("A", 0);
        final DigitVariable varB = new DigitVariable("B", 0);
        List<Variable<Integer>> vList = Arrays.asList(varA, varB);
        VariableCombination<Integer> initialCombination = new VariableCombination<>(vList);

        VariableCombinator<Integer> vc = new VariableCombinator<Integer>(initialCombination);
        SolutionChecker<Integer> checker = new SevenEightChecker();

        for (VariableCombination<Integer> combination : vc) {
            if (checker.checkSolution(combination)) {
                System.out.println(combination);
            }
        }
    }
}
