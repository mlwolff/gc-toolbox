package com.lupus.geocaching.bruteforce;


/**
 * 
 * @author mlwolff
 *
 * @param <T>
 */
public class Variable<T extends Object> {
	private final String name;
	private T value;
	
	/**
	 * 
	 * @param name
	 */
	public Variable(String name) {
		this.name = name;
		this.value = null;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	
	/**
	 * 
	 * @param value
	 */
	public void setValue(T value) {
		this.value = value;
	}
	
	/**
	 * 
	 * @return
	 */
	public T getValue() {
		return value;
	}
	

}
