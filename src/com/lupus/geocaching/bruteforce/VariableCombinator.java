package com.lupus.geocaching.bruteforce;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import com.lupus.geocaching.bruteforce.api.Variable;

/**
 * 
 * @author mlwolff
 *
 * @param <T>
 */
public class VariableCombinator<T extends Object> implements Iterable<List<Variable<T>>> {
    private final List<Variable<T>> variables;

    public VariableCombinator(Collection<Variable<T>> variables) {
        Objects.requireNonNull(variables);

        this.variables = new ArrayList<>(variables);
    }

    public void printVariables() {
        variables.forEach(System.out::println);
    }

    @Override
    public Iterator<List<Variable<T>>> iterator() {
        return new VariablesIterator<>(variables);
    }

    /**
     * 
     * @author mlwolff
     *
     */
    public static class VariablesIterator<T extends Object> implements Iterator<List<Variable<T>>> {
        final List<Variable<T>> currentCombination;
        
        @SuppressWarnings("unchecked")
        private VariablesIterator(List<Variable<T>> initialVariableCombination) {
            Objects.requireNonNull(initialVariableCombination);
            
            currentCombination = new ArrayList<>(initialVariableCombination.size());

            try {
                for (Variable<T> variable : initialVariableCombination) {
                    currentCombination.add(((Variable<T>)variable.clone()));
                }
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public List<Variable<T>> next() {
            // TODO Auto-generated method stub
            return null;
        }
        
    }
}
