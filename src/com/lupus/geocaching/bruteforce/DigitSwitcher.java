package com.lupus.geocaching.bruteforce;

import com.lupus.geocaching.bruteforce.api.Variable;

public class DigitSwitcher implements ValueSwitcher<Integer> {

	@Override
	public boolean nextVal(Variable<Integer> var) {
		boolean rc = false;
		Integer value = var.getValue();
		Integer newValue = value++;
		
		if (newValue > 9) {
			newValue = 0;
			rc = true;
		}
		
		var.setValue(newValue);
		
		
		return rc;
	}
}
