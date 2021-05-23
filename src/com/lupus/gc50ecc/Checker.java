package com.lupus.gc50ecc;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import com.lupus.geocaching.bruteforce.VariableCombination;
import com.lupus.geocaching.bruteforce.api.SolutionChecker;
import com.lupus.geocaching.bruteforce.api.Variable;

public class Checker implements SolutionChecker<Integer> {

	@Override
	public boolean checkSolution(VariableCombination<Integer> combination) {
		if (isUniqDigits(combination)) {
//			System.out.println("Calculating: " + combination);
			int n1 = calculateNumber(combination, Solver.BLUE_SUN, Solver.HALF_MOON, Solver.STAR);
			int n2 = calculateNumber(combination, Solver.HALF_MOON, Solver.CIRCLE, Solver.FULL_MOON);
			int n3 = calculateNumber(combination, Solver.TRIANGLE, Solver.ARROW, Solver.RING);
			int n4 = calculateNumber(combination, Solver.BLUE_SUN, Solver.CIRCLE, Solver.HALF_MOON);
			int n5 = calculateNumber(combination, Solver.FULL_MOON, Solver.STAR, Solver.HALF_MOON);
			int n6 = calculateNumber(combination, Solver.HEART, Solver.X);
			int n7 = calculateNumber(combination, Solver.ARROW, Solver.STAR, Solver.FULL_MOON);
			int n8 = calculateNumber(combination, Solver.FULL_MOON, Solver.BLUE_SUN, Solver.STAR);
			int n9 = calculateNumber(combination, Solver.RING, Solver.X, Solver.RING);
			
			return n1 + n2 == n3 &&
				   n4 - n5 == n6 &&
				   n7 + n8 == n9 &&
				   n1 + n4 == n7 &&
				   n2 - n5 == n8 &&
				   n3 + n6 == n9;
		}
		
		return false;
		
	}
	
	private boolean isUniqDigits(VariableCombination<Integer> combi) {
		Set<Integer> iSet = new HashSet<>();
		
		for (Variable<Integer> var : combi.getVariables()) {
			iSet.add(var.getValue());
		}
		
		return iSet.size() == combi.getVariables().size();
	}
	
	private int calculateNumber(VariableCombination<Integer> combi, String...names) {
		int size = names.length;
		int rc = 0;
		
		for(int i = 0; i < size; i++) {
			rc += getNumber(combi, names[size-1-i]) * (int)Math.pow(10, i);
		}
		
//		System.out.println("Number=" + rc + " " + combi);
		return rc;
	}
	
	private int getNumber(VariableCombination<Integer> combi, String name) {
		List<Variable<Integer>> variables = combi.getVariables();
		
		for (Variable<Integer> var : variables) {
			if (name.equals(var.getName())) {
				return var.getValue();
			}
		}
		
		throw new NoSuchElementException("Variable " + name + " not found.");
		
	}

}
