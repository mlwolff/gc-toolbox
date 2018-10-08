package com.lupus.geocaching.bruteforce.digit;

import com.lupus.geocaching.bruteforce.AbstractVariable;

/**
 * 
 * @author mlwolff
 *
 */
public class DigitVariable extends AbstractVariable<Integer> {
    public DigitVariable(String name) {
        super(new DigitOperator(), name, 0);
    }

    public DigitVariable(String name, Integer value) {
        super(new DigitOperator(), name, value);
    }
}
