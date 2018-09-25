package com.lupus.geocaching.bruteforce.test;

import java.util.Arrays;
import java.util.List;

import com.lupus.geocaching.bruteforce.Variable;
import com.lupus.geocaching.bruteforce.VariableCombinator;

public class VarTest {

	public static void main(String[] args) {
		List<Variable<Integer>> vList = Arrays.asList(new Variable<>("A"), new Variable<>("B"));

		 VariableCombinator<Integer> vc = new VariableCombinator<Integer>(vList);
		 
		 vc.printVariables();
	}

}
