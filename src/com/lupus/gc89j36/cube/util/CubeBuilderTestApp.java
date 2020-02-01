package com.lupus.gc89j36.cube.util;

import com.lupus.gc89j36.cube.Cube;
import com.lupus.gc89j36.cube.CubeFace.Colour;

public class CubeBuilderTestApp {

    public static void main(String[] args) {
        CubeBuilder builder = new CubeBuilder();
        
        Cube cube = builder.beginCube(1)
                   .beginFace(Colour.GREEN)
                       .addEdge("N#")
                       .addEdge("55")
                       .addEdge("77")
                       .addEdge("#E")
                   .endFace()
                   .beginFace(Colour.YELLOW)
                       .addEdge("N#")
                       .addEdge("55")
                       .addEdge("77")
                       .addEdge("#E")
                   .endFace()
                   .beginFace(Colour.ORANGE)
                       .addEdge("N#")
                       .addEdge("55")
                       .addEdge("77")
                       .addEdge("#E")
                   .endFace()
                   .beginFace(Colour.BLUE)
                       .addEdge("N#")
                       .addEdge("55")
                       .addEdge("77")
                       .addEdge("#E")
                   .endFace()
                   .beginFace(Colour.GREEN)
                       .addEdge("N#")
                       .addEdge("55")
                       .addEdge("77")
                       .addEdge("#E")
                   .endFace()
                   .beginFace(Colour.BLUE)
                       .addEdge("N#")
                       .addEdge("55")
                       .addEdge("77")
                       .addEdge("#E")
                   .endFace()
               .endCube();
        
        System.out.println(cube);
    }

}
