package com.lupus.geocaching.bruteforce.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.lupus.geocaching.bruteforce.VariableCombination;
import com.lupus.geocaching.bruteforce.VariableCombinator;
import com.lupus.geocaching.bruteforce.api.SolutionChecker;
import com.lupus.geocaching.bruteforce.api.Variable;
import com.lupus.geocaching.bruteforce.digit.DigitVariable;

public class CrossSumTest {

	public static void main(String[] args) throws IOException {
		int divider, varnum;
		
		try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in));) {
		
			System.out.print("Divider: ");
			System.out.flush();
			
			divider = Integer.parseInt(r.readLine());
			
			System.out.print("Number of digits/vars: ");
			System.out.flush();
			varnum = Integer.parseInt(r.readLine());
		}
		
		List<Variable<Integer>> varList = new ArrayList<Variable<Integer>>();
		
		for (char c = 'A'; c < 'A' + varnum; c++) {
			varList.add(new DigitVariable(String.valueOf(c)));
		}
		
        VariableCombinator<Integer> combinator = new VariableCombinator<Integer>(new VariableCombination<>(varList));
		SolutionChecker<Integer> checker = new CrossSumChecker(divider);
		
		for (VariableCombination<Integer> combination : combinator) {
			if (checker.checkSolution(combination)) {
				System.out.println(combination);
			}
		}
		
		System.out.println("Finished.");
	}

}
