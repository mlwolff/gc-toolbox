package com.lupus.geocaching.bruteforce.test;

import static com.lupus.gc89j36.cube.util.CubesUtil.getStringValue;

import java.util.ArrayList;
import java.util.List;

import com.lupus.gc89j36.cube.Cube;
import com.lupus.gc89j36.cube.solver.CubeData;
import com.lupus.gc89j36.cube.solver.CubeDataChecker;
import com.lupus.gc89j36.cube.solver.CubeDataVariable;
import com.lupus.gc89j36.cube.util.CubesUtil;
import com.lupus.geocaching.bruteforce.VariableCombination;
import com.lupus.geocaching.bruteforce.VariableCombinator;
import com.lupus.geocaching.bruteforce.api.Variable;

public class CubeTest {

    public static void main(String[] args) {
        List<Cube> cubes = CubesUtil.createCubes();
        List<List<Cube>> permutations = generatePerm(cubes);

        for (List<Cube> permutation : permutations) {
            checkCombination(permutation);
        }
    }

    static void checkCombination(List<Cube> cubes) {
        
        for (Cube cube : cubes) {
            System.out.print(String.format("Cube %d #", cube.getNum()));
        }
        System.out.println();;
        System.out.println("--------------------------------------------");
        
        List<Variable<CubeData>> variables = new ArrayList<>();
        
        int cubeNum = 0;
        variables.add(new CubeDataVariable(String.format("Cube %d", cubes.get(cubeNum).getNum()), 
                                                                    new CubeData(cubes.get(cubeNum++))));
        variables.add(new CubeDataVariable(String.format("Cube %d", cubes.get(cubeNum).getNum()), 
                new CubeData(cubes.get(cubeNum++))));
        variables.add(new CubeDataVariable(String.format("Cube %d", cubes.get(cubeNum).getNum()), 
                new CubeData(cubes.get(cubeNum++))));
        variables.add(new CubeDataVariable(String.format("Cube %d", cubes.get(cubeNum).getNum()), 
                new CubeData(cubes.get(cubeNum++))));

        VariableCombination<CubeData> combi = new VariableCombination<>(variables);
        VariableCombinator<CubeData> combinator = new VariableCombinator<>(combi);
        CubeDataChecker checker = new CubeDataChecker();
        
        int i = 0;
        
        for (VariableCombination<CubeData> vc : combinator) {
            if (checker.checkSolution(vc)) {
                System.out.println(String.format("Combination %9d: %s %s", 
                        ++i, getStringValue(vc, false), getStringValue(vc, true)));
            }
        }
                
    }
    
    static public <E> List<List<E>> generatePerm(List<E> original) {
        if (original.isEmpty()) {
          List<List<E>> result = new ArrayList<>(); 
          result.add(new ArrayList<>()); 
          return result; 
        }
        E firstElement = original.remove(0);
        List<List<E>> returnValue = new ArrayList<>();
        List<List<E>> permutations = generatePerm(original);
        for (List<E> smallerPermutated : permutations) {
          for (int index=0; index <= smallerPermutated.size(); index++) {
            List<E> temp = new ArrayList<>(smallerPermutated);
            temp.add(index, firstElement);
            returnValue.add(temp);
          }
        }
        return returnValue;
      }}
