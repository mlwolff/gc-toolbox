package com.lupus.geocaching.bruteforce.api;

public interface Variable<T> extends Cloneable {

    /**
     * Clones a {@link Variable} object.
     * 
     * @return A clone of the current object.
     * 
     * @throws CloneNotSupportedException, if cloning not supported.
     */
    public Object clone() throws CloneNotSupportedException;
    
    /**
	 * 
	 * @return The name of the variable.
	 */
	public String getName();

	/**
	 * Sets a new value.
	 * 
	 * @param value
	 * 		The new value.
	 */
	public void setValue(T value);

	/**
	 * 
	 * @return The current value
	 */
	public T getValue();
	
	/**
	 * Increments the variable by one.
	 * <p>
	 * If the value exeeds the range of allowed value,
	 * the value will resetted to the first/lowest value.
	 * 
	 * @return <code>true</code> if an overflow happened.
	 */
	public boolean increment();
	

}