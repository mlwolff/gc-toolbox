/**
 * 
 */
package com.lupus.geocaching.bruteforce;

import java.awt.datatransfer.Clipboard;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.lupus.geocaching.bruteforce.api.Variable;

/**
 * @author mlwolff
 *
 */
public class VariableCombination<T> implements Cloneable {
    final private Map<String, Variable<T>> varMap;
    final private LinkedList<Variable<T>> varList;
    
    /**
     * 
     * @param variables
     */
    public VariableCombination (List<Variable<T>> variables) {
        Objects.requireNonNull(variables, "Parameter variable must not be null.");
        
        this.varMap = new LinkedHashMap<>(variables.size());
        this.varList = new LinkedList<>();
        
        try {
	        for (Variable<T> variable : variables) {
	            Variable<T> clonedVar = variable.clone();
	            varMap.put(variable.getName(), clonedVar);
	            varList.add(clonedVar);
	        }
        } catch (CloneNotSupportedException e) {
        	throw new RuntimeException(e);
        }
    }
    
    /**
     * 
     * @return
     */
    public List<Variable<T>> getVariables() {
        return Collections.unmodifiableList(varList);
    }
    
    /**
     * Returns the {@link Variable} at the specified index.
     * 
     * @param index
     *      The index.
     * @return
     *      Variable at specified index.
     */
    public Variable<T> get(int index) {
        return varList.get(index);
    }

    /**
     * Returns the number of {@link Variable Variables}
     * @return
     *      The number of variables.
     */
    public int size() {
        return varList.size();
    }
    
    /**
     * Return the {@link Variable} by its name.
     * 
     * @param name
     *      Name of the variable.
     * @return
     *      The {@code Variable} or <code>null</code>.
     */
    public Variable<T> get(String name) {
        return varMap.get(name);
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return varList.toString();
    }
    
    @Override
    protected VariableCombination<T> clone()  {
    	return new VariableCombination<>(varList); 
    }
}
