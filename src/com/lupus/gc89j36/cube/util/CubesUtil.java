package com.lupus.gc89j36.cube.util;

import java.util.ArrayList;
import java.util.List;

import com.lupus.gc89j36.cube.Cube;
import com.lupus.gc89j36.cube.solver.CubeData;
import com.lupus.geocaching.bruteforce.VariableCombination;
import com.lupus.geocaching.bruteforce.api.Variable;

public class CubesUtil {
    /**
     * 
     * @return
     */
    public static List<Cube> createCubes() {
        List<Cube> cubes = new ArrayList<>(4);
                
                
        CubeBuilder builder = new CubeBuilder();
        
        Cube cube = builder.beginCube(1)
               .beginFace()
               .addEdge("##").addEdge("E#").addEdge("##").addEdge("4#")
               .endFace()
               .beginFace()
               .addEdge("2#").addEdge("7#").addEdge("##").addEdge("0N")
               .endFace()
               .beginFace()
               .addEdge("6#").addEdge("E#").addEdge("2#").addEdge("1#")
               .endFace()
               .beginFace()
               .addEdge("##").addEdge("34").addEdge("##").addEdge("#2")
               .endFace()
               .beginFace()
               .addEdge("##").addEdge("3#").addEdge("##").addEdge("##")
               .endFace()
               .beginFace()
               .addEdge("2#").addEdge("4#").addEdge("##").addEdge("E2")
               .endFace()
               .endCube();
        
        cubes.add(cube);
        
        cube = builder.beginCube(2)
                .beginFace()
                .addEdge("#3").addEdge("##").addEdge("##").addEdge("#6")
                .endFace()
                .beginFace()
                .addEdge("94").addEdge("##").addEdge("N#").addEdge("##")
                .endFace()
                .beginFace()
                .addEdge("2#").addEdge("1#").addEdge("7#").addEdge("##")
                .endFace()
                .beginFace()
                .addEdge("4#").addEdge("##").addEdge("#5").addEdge("76")
                .endFace()
                .beginFace()
                .addEdge("##").addEdge("##").addEdge("#2").addEdge("#3")
                .endFace()
                .beginFace()
                .addEdge("##").addEdge("##").addEdge("##").addEdge("12")
                .endFace()
                .endCube();
         
         cubes.add(cube);
        
         cube = builder.beginCube(3)
                 .beginFace()
                 .addEdge("N2").addEdge("##").addEdge("#6").addEdge("##")
                 .endFace()
                 .beginFace()
                 .addEdge("N2").addEdge("##").addEdge("#2").addEdge("##")
                 .endFace()
                 .beginFace()
                 .addEdge("##").addEdge("54").addEdge("##").addEdge("4#")
                 .endFace()
                 .beginFace()
                 .addEdge("##").addEdge("0#").addEdge("##").addEdge("#N")
                 .endFace()
                 .beginFace()
                 .addEdge("#7").addEdge("##").addEdge("N#").addEdge("9#")
                 .endFace()
                 .beginFace()
                 .addEdge("##").addEdge("##").addEdge("4#").addEdge("1#")
                 .endFace()
                 .endCube();
          
          cubes.add(cube);
         
          cube = builder.beginCube(4)
                  .beginFace()
                  .addEdge("##").addEdge("##").addEdge("##").addEdge("##")
                  .endFace()
                  .beginFace()
                  .addEdge("#1").addEdge("##").addEdge("#E").addEdge("##")
                  .endFace()
                  .beginFace()
                  .addEdge("2#").addEdge("67").addEdge("##").addEdge("##")
                  .endFace()
                  .beginFace()
                  .addEdge("##").addEdge("4#").addEdge("##").addEdge("29")
                  .endFace()
                  .beginFace()
                  .addEdge("##").addEdge("3#").addEdge("N#").addEdge("2#")
                  .endFace()
                  .beginFace()
                  .addEdge("#4").addEdge("#7").addEdge("0#").addEdge("##")
                  .endFace()
                  .endCube();
           
           cubes.add(cube);
          
        return cubes;
    }
    
    public static String getStringValue(VariableCombination<CubeData> combination, boolean opposite) {
        StringBuilder builder = new StringBuilder();
        List<Variable<CubeData>> variables = combination.getVariables();
        
        for (Variable<CubeData> variable : variables) {
            CubeData value = variable.getValue();
            String part = opposite ? value.getCounterData() : value.getCurrentData();
            
            builder.append(part);
        }
        
        return builder.toString();
        
    }
}
