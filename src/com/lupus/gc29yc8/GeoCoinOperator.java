/**
 * 
 */
package com.lupus.gc29yc8;

import com.lupus.geocaching.bruteforce.api.VariableOperator;

/**
 * @author mwolff
 *
 */
public class GeoCoinOperator implements VariableOperator<GeoCoin> {
	private boolean maxValueExceeded;
	
	@Override
	public GeoCoin increment(GeoCoin oldValue) {
		GeoCoin newValue = new GeoCoin(oldValue);
		
		boolean inBag = newValue.isInBag();
		maxValueExceeded = inBag;
		newValue.setInBag(!inBag);
		
		return newValue;
	}

	@Override
	public boolean hasMaxvalExceeded() {
		return maxValueExceeded;
	}

}
