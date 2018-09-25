package com.lupus.geocaching.bruteforce;

public interface ValueSwitcher<T extends Object> {
	
	/**
	 * Sets the value of the passed {@link Variable} to the next value.
	 * <p>
	 * If the next value lies behind the last valid value, the Variable
	 * will be set to the first/lowest value.
	 * </p>
	 * 
	 * @param var
	 * 		Reference to the {@code Variable}
	 * 
	 * @return
	 * 		<code>true</code>, if the last value have been exceeded.
	 */
	boolean nextVal(Variable<T> var);

}
