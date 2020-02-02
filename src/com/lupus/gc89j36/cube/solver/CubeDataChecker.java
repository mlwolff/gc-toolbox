package com.lupus.gc89j36.cube.solver;

import com.lupus.gc89j36.cube.util.CubesUtil;
import com.lupus.geocaching.bruteforce.VariableCombination;
import com.lupus.geocaching.bruteforce.api.SolutionChecker;

public class CubeDataChecker implements SolutionChecker<CubeData> {
	private static String[] validCombis = {
	};

    @Override
    public boolean checkSolution(VariableCombination<CubeData> combination) {
        String upper = CubesUtil.getStringValue(combination, false);
        String lower = CubesUtil.getStringValue(combination, true);
        int numOfUpperColours = CubesUtil.getNumberOfColors(combination, false);
        int numOfLowerColours = CubesUtil.getNumberOfColors(combination, true);
        
        String validUpper = upper.replace("#", "");
        String validLower = lower.replace("#", "");
        
        return (validUpper.length() == 6 &&  validLower.length() == 6 && 
               numOfUpperColours == 4 && numOfLowerColours == 4 &&
               validUpper.charAt(0) == 'N' &&  validLower.charAt(0) == 'E') ||
        		checkCombi(validUpper, validLower)
               ;
    }
    
    private boolean checkCombi(String upper, String lower) {
    	for (int i = 0; i < validCombis.length - 1; i += 2) {
    		if (validCombis[i].equals(upper) && validCombis[i+1].equals(lower)) {
    			return true;
    		}
    	}
    	
    	return false;
    }

}
