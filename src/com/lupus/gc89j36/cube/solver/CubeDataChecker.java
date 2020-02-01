package com.lupus.gc89j36.cube.solver;

import com.lupus.gc89j36.cube.util.CubesUtil;
import com.lupus.geocaching.bruteforce.VariableCombination;
import com.lupus.geocaching.bruteforce.api.SolutionChecker;

public class CubeDataChecker implements SolutionChecker<CubeData> {

    @Override
    public boolean checkSolution(VariableCombination<CubeData> combination) {
        String upper = CubesUtil.getStringValue(combination, false);
        String lower = CubesUtil.getStringValue(combination, true);
        
        String validUpper = upper.replace("#", "");
        String validLower = lower.replace("#", "");
        
        return validLower.length() == 6 && 
               validUpper.length() == 6;
    }

}
