package com.lupus.gc89j36.cube.solver;

import com.lupus.geocaching.bruteforce.api.VariableOperator;

public class CubeDataOperator implements VariableOperator<CubeData> {
    boolean maxValueExceeded = false;
    
    @Override
    public CubeData increment(CubeData oldValue) {
        CubeData newValue = new CubeData(oldValue);
        
        int edgeNo = newValue.getEdgeNo();
        int faceNo = newValue.getFaceNo();
        
        maxValueExceeded = false;
        
        if (++edgeNo > 3) {
            edgeNo = 0;
            
            if (++faceNo > 5) {
                faceNo = 0;
                maxValueExceeded = true;
            }
            newValue.setFaceNo(faceNo);
        }
        
        newValue.setEdgeNo(edgeNo);
        
        return newValue;
    }

    @Override
    public boolean hasMaxvalExceeded() {
        return maxValueExceeded;
    }

}
