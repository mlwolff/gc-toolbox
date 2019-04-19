/**
 * 
 */
package com.lupus.gc29yc8;

import com.lupus.geocaching.bruteforce.AbstractVariable;

/**
 * @author mwolff
 *
 */
public class GeoCoinVariable extends AbstractVariable<GeoCoin> {
	private static final GeoCoinOperator operator = new GeoCoinOperator();

	public GeoCoinVariable(String name, GeoCoin value) {
		super(operator, name, value);
	}

	
	@Override
	public GeoCoinVariable clone() throws CloneNotSupportedException {
		return new GeoCoinVariable(getName(), getValue());
	}
}
