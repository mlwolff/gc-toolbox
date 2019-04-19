package com.lupus.gc29yc8;

import java.util.stream.Collectors;

import com.lupus.geocaching.bruteforce.VariableCombination;
import com.lupus.geocaching.bruteforce.api.SolutionChecker;
import com.lupus.geocaching.bruteforce.api.Variable;

/**
 * 
 * @author mwolff
 *
 */
public class MaxWeightChecker implements SolutionChecker<GeoCoin> {
	final int maxWeight;
	
	
	public MaxWeightChecker(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	@Override
	public boolean checkSolution(VariableCombination<GeoCoin> combination) {
		return getWeightSum(combination) <= maxWeight;
	}
	
	private int getWeightSum(VariableCombination<GeoCoin> combination) {
		return combination.getVariables().stream()
								  .map(Variable::getValue)
								  .filter(GeoCoin::isInBag)
								  .map(GeoCoin::getWeight)
								  .collect(Collectors.summingInt(Integer::intValue));
	}

}
