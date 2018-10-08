package com.lupus.geocaching.bruteforce;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class VariableCombinator<T extends Object> {
    private final List<com.lupus.geocaching.bruteforce.api.Variable<T>> variables;

    public VariableCombinator(Collection<com.lupus.geocaching.bruteforce.api.Variable<T>> variables) {
        Objects.requireNonNull(variables);

        this.variables = new ArrayList<>(variables);
    }

    public void printVariables() {
        variables.forEach(System.out::println);
    }

}
