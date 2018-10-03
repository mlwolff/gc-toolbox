package com.lupus.geocaching.bruteforce.test;

import java.util.Arrays;
import java.util.List;

import com.lupus.geocaching.bruteforce.Variable;
import com.lupus.geocaching.bruteforce.VariableCombinator;
import com.lupus.geocaching.bruteforce.digit.DigitVariable;

public class VarTest {

	public static void main(String[] args) {
		List<com.lupus.geocaching.bruteforce.api.Variable<Integer>> vList = Arrays.asList(new DigitVariable("A"), new DigitVariable("B"));

		vList.get(0).setValue(0);
		vList.get(1).setValue(3);

		
		VariableCombinator<Integer> vc = new VariableCombinator<Integer>(vList);

		vc.printVariables();
	}
}
