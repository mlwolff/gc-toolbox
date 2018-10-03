package com.lupus.geocaching.bruteforce.digit;

import com.lupus.geocaching.bruteforce.Variable;

/**
 * 
 * @author mlwolff
 *
 */
public class DigitVariable extends Variable<Integer> implements com.lupus.geocaching.bruteforce.api.Variable<Integer> {
	public DigitVariable(String name) {
		super(new DigitOperator(), name, 0);
	}
	
	public DigitVariable(String name, Integer value) {
		super(new DigitOperator(), name, value);
	}
}
