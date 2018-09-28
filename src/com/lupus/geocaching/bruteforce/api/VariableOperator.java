package com.lupus.geocaching.bruteforce.api;


/**
 * Performs various operations on {@link Variable Variables}
 * @author mlwolff
 *
 * @param <T>
 */
public interface VariableOperator<T> {
	
	/**
	 * Increments the passed value one.
	 * @param oldValue
	 * 		The oldValue
	 * @return
	 * 		The newValue;
	 */
	T increment(T oldValue);
	
	/**
	 * Returns <code>true</code> if last increment exeeds maximum allowed value.
	 * @return
	 * 		<code>true</code> if last increment exeeded maximum allowed value.
	 */
	boolean hasMaxvalExceeded();
	
}
