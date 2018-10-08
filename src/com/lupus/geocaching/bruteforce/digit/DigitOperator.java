package com.lupus.geocaching.bruteforce.digit;

import com.lupus.geocaching.bruteforce.api.VariableOperator;

public class DigitOperator implements VariableOperator<Integer> {
    boolean maxValueExceeded = false;

    @Override
    public Integer increment(Integer oldValue) {
        Integer newValue = oldValue + 1;
        if (newValue >= 10) {
            newValue = 0;
            maxValueExceeded = true;
        } else {
            maxValueExceeded = false;
        }

        return newValue;
    }

    @Override
    public boolean hasMaxvalExceeded() {
        return maxValueExceeded;
    }

}
