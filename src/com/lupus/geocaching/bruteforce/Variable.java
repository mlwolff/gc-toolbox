package com.lupus.geocaching.bruteforce;

import com.lupus.geocaching.bruteforce.api.VariableOperator;

/**
 * 
 * @author mlwolff
 *
 * @param <T>
 */
public abstract class Variable<T extends Object> implements com.lupus.geocaching.bruteforce.api.Variable<T> {
	private final VariableOperator<T> operator;
	private final String name;
	private T value;
	
	/**
	 * 
	 * @param name
	 */
	public Variable(VariableOperator<T> operator, String name, T value) {
		this.name = name;
		this.value = value;
		this.operator = operator;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lupus.geocaching.bruteforce.api.Variable#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lupus.geocaching.bruteforce.api.Variable#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(T value) {
		this.value = value;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.lupus.geocaching.bruteforce.api.Variable#getValue()
	 */
	@Override
	public T getValue() {
		return value;
	}

	/*
	 * (non-Javadoc)
	 * @see com.lupus.geocaching.bruteforce.api.Variable#increment()
	 */
	@Override
	public boolean increment() {
		T newValue = operator.increment(value);
		
		
		return operator.hasMaxvalExceeded();
	}

	@Override
	public String toString() {
		return String.format("%s=%s", name, String.valueOf(value));
	}
}
