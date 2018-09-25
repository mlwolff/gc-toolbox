package com.lupus.geocaching.bruteforce;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class VariableCombinator<T extends Object> {
	private final List<Variable<T>> variables;
	
	public VariableCombinator(Collection<Variable<T>> variables, ValueSwitcher<T> switcher) {
		Objects.requireNonNull(variables);
		
		this.variables = new ArrayList<>(variables);
	}
	
	public void printVariables() {
		variables.forEach(System.out::println);
	}

}