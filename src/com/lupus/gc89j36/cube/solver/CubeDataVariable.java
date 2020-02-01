package com.lupus.gc89j36.cube.solver;

import com.lupus.geocaching.bruteforce.AbstractVariable;
import com.lupus.geocaching.bruteforce.api.Variable;

public class CubeDataVariable extends AbstractVariable<CubeData> {
    private static CubeDataOperator operator = new CubeDataOperator();
    
    public CubeDataVariable(String name, CubeData data) {
        super(operator, name, data);
    }
    
    @Override
    public Variable<CubeData> clone() throws CloneNotSupportedException {
        return new CubeDataVariable(getName(), getValue());
    }
}
