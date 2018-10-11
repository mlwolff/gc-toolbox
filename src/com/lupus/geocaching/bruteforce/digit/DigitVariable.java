package com.lupus.geocaching.bruteforce.digit;

import com.lupus.geocaching.bruteforce.AbstractVariable;

/**
 * 
 * @author mlwolff
 *
 */
public class DigitVariable extends AbstractVariable<Integer> {
    private static final DigitOperator operator = new DigitOperator();
    
    public DigitVariable(String name) {
        super(operator, name, 0);
    }

    public DigitVariable(String name, Integer value) {
        super(operator, name, value);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    public Object clone() {
        DigitVariable rc = new DigitVariable(getName(), getValue());
        return rc;
    }
 
    
 }
