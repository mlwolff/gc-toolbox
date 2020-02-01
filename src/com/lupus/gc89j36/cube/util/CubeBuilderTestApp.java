package com.lupus.gc89j36.cube.util;

import com.lupus.gc89j36.cube.Cube;

public class CubeBuilderTestApp {

    public static void main(String[] args) {
        CubeBuilder builder = new CubeBuilder();
        
        Cube cube = builder.beginCube(1)
                   .beginFace()
                       .addEdge("N#")
                       .addEdge("55")
                       .addEdge("77")
                       .addEdge("#E")
                   .endFace()
                   .beginFace()
                       .addEdge("N#")
                       .addEdge("55")
                       .addEdge("77")
                       .addEdge("#E")
                   .endFace()
                   .beginFace()
                       .addEdge("N#")
                       .addEdge("55")
                       .addEdge("77")
                       .addEdge("#E")
                   .endFace()
                   .beginFace()
                       .addEdge("N#")
                       .addEdge("55")
                       .addEdge("77")
                       .addEdge("#E")
                   .endFace()
                   .beginFace()
                       .addEdge("N#")
                       .addEdge("55")
                       .addEdge("77")
                       .addEdge("#E")
                   .endFace()
                   .beginFace()
                       .addEdge("N#")
                       .addEdge("55")
                       .addEdge("77")
                       .addEdge("#E")
                   .endFace()
               .endCube();
        
        System.out.println(cube);
    }

}
