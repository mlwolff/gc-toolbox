package com.lupus.geocaching.bruteforce.test;

import com.lupus.geocaching.bruteforce.VariableCombination;
import com.lupus.geocaching.bruteforce.api.SolutionChecker;
import com.lupus.geocaching.bruteforce.api.Variable;

public class CrossSumChecker implements SolutionChecker<Integer> {
	final int divider;

	/**
	 * 
	 * @param divider
	 */
	public CrossSumChecker(int divider) {
		this.divider = divider;
	}
	
	@Override
	public boolean checkSolution(VariableCombination<Integer> combination) {
		int crossSum = crossSum(combination);
        return crossSum % divider == 0 && crossSum != 0;
	}
	
	/**
	 * Internal helper for calculating the crosssum. 
	 * @param combination
	 * 		Reference to a {@link VariableCombination}.
	 * @return
	 * 		The cross sum.
	 */
	private int crossSum(VariableCombination<Integer> combination) {
		int rc = 0;
		
		for (Variable<Integer> v : combination.getVariables()) {
			rc += v.getValue();
		}
		
		return rc;
	}

}
