package com.lupus.gc89j36.cube.util;

import static com.lupus.gc89j36.cube.CubeFace.Colour.BLUE;
import static com.lupus.gc89j36.cube.CubeFace.Colour.GREEN;
import static com.lupus.gc89j36.cube.CubeFace.Colour.ORANGE;
import static com.lupus.gc89j36.cube.CubeFace.Colour.YELLOW;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.lupus.gc89j36.cube.Cube;
import com.lupus.gc89j36.cube.CubeFace.Colour;
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
               .beginFace(GREEN)
               .addEdge("##").addEdge("E#").addEdge("##").addEdge("4#")
               .endFace()
               .beginFace(ORANGE)
               .addEdge("2#").addEdge("7#").addEdge("##").addEdge("0N")
               .endFace()
               .beginFace(ORANGE)
               .addEdge("6#").addEdge("E#").addEdge("2#").addEdge("1#")
               .endFace()
               .beginFace(YELLOW)
               .addEdge("##").addEdge("34").addEdge("##").addEdge("#2")
               .endFace()
               .beginFace(YELLOW)
               .addEdge("##").addEdge("3#").addEdge("##").addEdge("##")
               .endFace()
               .beginFace(BLUE)
               .addEdge("2#").addEdge("4#").addEdge("##").addEdge("E2")
               .endFace()
               .endCube();
        
        cubes.add(cube);
        
        cube = builder.beginCube(2)
                .beginFace(YELLOW)
                .addEdge("#3").addEdge("##").addEdge("##").addEdge("#6")
                .endFace()
                .beginFace(GREEN)
                .addEdge("94").addEdge("##").addEdge("N#").addEdge("##")
                .endFace()
                .beginFace(BLUE)
                .addEdge("2#").addEdge("1#").addEdge("7#").addEdge("##")
                .endFace()
                .beginFace(GREEN)
                .addEdge("4#").addEdge("##").addEdge("#5").addEdge("76")
                .endFace()
                .beginFace(ORANGE)
                .addEdge("##").addEdge("##").addEdge("#2").addEdge("#3")
                .endFace()
                .beginFace(ORANGE)
                .addEdge("##").addEdge("##").addEdge("##").addEdge("12")
                .endFace()
                .endCube();
         
         cubes.add(cube);
        
         cube = builder.beginCube(3)
                 .beginFace(ORANGE)
                 .addEdge("N2").addEdge("##").addEdge("#6").addEdge("##")
                 .endFace()
                 .beginFace(YELLOW)
                 .addEdge("N2").addEdge("##").addEdge("#2").addEdge("##")
                 .endFace()
                 .beginFace(YELLOW)
                 .addEdge("##").addEdge("54").addEdge("##").addEdge("4#")
                 .endFace()
                 .beginFace(BLUE)
                 .addEdge("##").addEdge("0#").addEdge("##").addEdge("#N")
                 .endFace()
                 .beginFace(BLUE)
                 .addEdge("#7").addEdge("##").addEdge("N#").addEdge("9#")
                 .endFace()
                 .beginFace(GREEN)
                 .addEdge("##").addEdge("##").addEdge("4#").addEdge("1#")
                 .endFace()
                 .endCube();
          
          cubes.add(cube);
         
          cube = builder.beginCube(4)
                  .beginFace(BLUE)
                  .addEdge("##").addEdge("##").addEdge("##").addEdge("##")
                  .endFace()
                  .beginFace(BLUE)
                  .addEdge("#1").addEdge("##").addEdge("#E").addEdge("##")
                  .endFace()
                  .beginFace(GREEN)
                  .addEdge("2#").addEdge("67").addEdge("##").addEdge("##")
                  .endFace()
                  .beginFace(ORANGE)
                  .addEdge("##").addEdge("4#").addEdge("##").addEdge("29")
                  .endFace()
                  .beginFace(YELLOW)
                  .addEdge("##").addEdge("3#").addEdge("N#").addEdge("2#")
                  .endFace()
                  .beginFace(YELLOW)
                  .addEdge("#4").addEdge("#7").addEdge("0#").addEdge("##")
                  .endFace()
                  .endCube();
           
           cubes.add(cube);
           
           System.out.println(cubes);
          
        return cubes;
    }
    
    public static String getStringValue(VariableCombination<CubeData> combination, boolean opposite) {
        StringBuilder builder = new StringBuilder();
        List<Variable<CubeData>> variables = combination.getVariables();
        
        for (Variable<CubeData> variable : variables) {
            CubeData value = variable.getValue();
            String part = opposite ? value.getLowerData() : value.getUpperData();
            
            if (opposite) {
            	builder.insert(0, part);
            } else {
            	builder.append(part);
            }
        }
        
        return builder.toString();
        
    }
    
    public static int getNumberOfColors(VariableCombination<CubeData> combination, boolean opposite) {
    	Set<Colour> colours = new HashSet<>();
    	List<Variable<CubeData>> variables = combination.getVariables();
    	
        for (Variable<CubeData> variable : variables) {
            CubeData value = variable.getValue();
        	Cube cube = value.getCube();
        	int faceNo = opposite ? 5 - value.getFaceNo() : value.getFaceNo();
            
        	colours.add(value.getCube().getFaces()[faceNo].getColor());
        	
        }
        
    	return colours.size();
    }
}
