/**
 * 
 */
package com.lupus.gc29yc8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.lupus.geocaching.bruteforce.VariableCombination;
import com.lupus.geocaching.bruteforce.VariableCombinator;
import com.lupus.geocaching.bruteforce.api.SolutionChecker;
import com.lupus.geocaching.bruteforce.api.Variable;

/**
 * @author mwolff
 *
 */
public class Solver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Variable<GeoCoin>> vList = Arrays.asList(
				new GeoCoinVariable("GC_01", new GeoCoin(1, 2)),
				new GeoCoinVariable("GC_02", new GeoCoin(1, 1)),
				new GeoCoinVariable("GC_03", new GeoCoin(5, 3)),
				new GeoCoinVariable("GC_04", new GeoCoin(5, 2)),
				new GeoCoinVariable("GC_05", new GeoCoin(6, 3)),
				new GeoCoinVariable("GC_06", new GeoCoin(10, 6)),
				new GeoCoinVariable("GC_07", new GeoCoin(8, 5)),
				new GeoCoinVariable("GC_08", new GeoCoin(10, 6)),
				new GeoCoinVariable("GC_09", new GeoCoin(10, 7)),
				new GeoCoinVariable("GC_10", new GeoCoin(11, 8)),
				new GeoCoinVariable("GC_11", new GeoCoin(12, 8)),
				new GeoCoinVariable("GC_12", new GeoCoin(14, 11)),
				new GeoCoinVariable("GC_13", new GeoCoin(14, 8)),
				new GeoCoinVariable("GC_14", new GeoCoin(15, 12)),
				new GeoCoinVariable("GC_15", new GeoCoin(16, 13)),
				new GeoCoinVariable("GC_16", new GeoCoin(17, 16))
				);
		
        VariableCombination<GeoCoin> initialCombination = new VariableCombination<>(vList);

        VariableCombinator<GeoCoin> vc = new VariableCombinator<GeoCoin>(initialCombination);
        SolutionChecker<GeoCoin> checker = new MaxWeightChecker(36);

        VariableCombination<GeoCoin> solution = null;
        
        int maxValue = 0;
        
        for (VariableCombination<GeoCoin> combination : vc) {
            if (checker.checkSolution(combination)) {
            	
            	int combinationValue = getValue(combination);
            	
				if (maxValue < combinationValue) {
            		maxValue = combinationValue;
            		solution = combination;
//            		System.out.println("New solution found, value: " + combinationValue);
            	}
            }
        }
        
        if (solution != null) {
        	System.out.println("Solution is");
        	System.out.println("===========");
        	System.out.println("");
        	printCombination(solution);
        } else {
        	System.err.println("No solution found.");
        }
	}
	
	static int getValue(VariableCombination<GeoCoin> combination) {
		return combination.getVariables().stream()
		                          .map(Variable::getValue)
		                          .filter(GeoCoin::isInBag)
		                          .map(GeoCoin::getValue)
		                          .collect(Collectors.summingInt(Integer::intValue));
	}
	
	static int getWeight(VariableCombination<GeoCoin> combination) {
		return combination.getVariables().stream()
		                          .map(Variable::getValue)
		                          .filter(GeoCoin::isInBag)
		                          .map(GeoCoin::getWeight)
		                          .collect(Collectors.summingInt(Integer::intValue));
	}
	
	static void printCombination(VariableCombination<GeoCoin> combination) {
		List<Variable<GeoCoin>> variables = combination.getVariables();
		int value = getValue(combination);
		int weight = getWeight(combination);
		
		System.out.println("Value: " + value + ", Weight: " + weight);
		for (Variable<GeoCoin> variable : variables) {
			System.out.print(variable.getValue().isInBag() ? "1" : "0");
		}
		System.out.println();
		
		for (Variable<GeoCoin> variable : variables) {
			System.out.print(variable.getValue().isInBag() ? variable.getName() + " " : "");
		}
		
		System.out.println();
		
	}
}
