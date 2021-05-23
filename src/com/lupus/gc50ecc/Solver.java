package com.lupus.gc50ecc;

import java.util.ArrayList;
import java.util.List;

import com.lupus.geocaching.bruteforce.VariableCombination;
import com.lupus.geocaching.bruteforce.VariableCombinator;
import com.lupus.geocaching.bruteforce.api.SolutionChecker;
import com.lupus.geocaching.bruteforce.api.Variable;
import com.lupus.geocaching.bruteforce.digit.DigitVariable;

public class Solver {
	public static final String BLUE_SUN = "Blue Sun";
	public static final String HALF_MOON = "Half Moon";
	public static final String FULL_MOON = "Full Moon";
	public static final String STAR = "Star";
	public static final String CIRCLE = "Circle";
	public static final String TRIANGLE = "Triangle";
	public static final String ARROW = "Arrow";
	public static final String RING = "Ring";
	public static final String HEART = "Heart";
	public static final String X = "X";
	
	public static void main(String[] args) {
		List<Variable<Integer>> symbols = new ArrayList<>();
		
		symbols.add(new DigitVariable(BLUE_SUN, 0));
		symbols.add(new DigitVariable(HALF_MOON, 0));
		symbols.add(new DigitVariable(FULL_MOON, 0));
		symbols.add(new DigitVariable(STAR, 0));
		symbols.add(new DigitVariable(CIRCLE, 0));
		symbols.add(new DigitVariable(TRIANGLE, 0));
		symbols.add(new DigitVariable(ARROW, 0));
		symbols.add(new DigitVariable(RING, 0));
		symbols.add(new DigitVariable(HEART, 0));
		symbols.add(new DigitVariable(X, 0));
		
		VariableCombinator<Integer> vc = new VariableCombinator<>(new VariableCombination<>(symbols));
		SolutionChecker<Integer> checker = new Checker();

		long x = 0;
        for (VariableCombination<Integer> combination : vc) {
        	x++;
        	if (x % 1000000 == 0) {
        		
        		System.err.print(String.format("%d/10000000000", x));
            	System.err.println(" - Checking: " + combination);
        	}
        	
            if (checker.checkSolution(combination)) {
                System.out.println(combination);
                break;
            }
        }
		
		
	}

}
