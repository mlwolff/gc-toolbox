package com.lupus.gc89j36.cube.solver;

import com.lupus.gc89j36.cube.Cube;

public class CubeData {
    /** The Cube. */
    private Cube cube;
    private int faceNo = 0;
    private int edgeNo = 0;
    
    public CubeData(Cube cube) {
        this.cube = cube;
    }
    
    public Cube getCube() {
        return cube;
    }
    
    public int getFaceNo() {
        return faceNo;
    }
    
    public int getEdgeNo() {
        return edgeNo;
    }
    
    public void setFaceNo(int faceNo) {
        this.faceNo = faceNo;
    }
    
    public void setEdgeNo(int edgeNo) {
        this.edgeNo = edgeNo;
    }
    
    public String getCurrentData() {
        return cube.getFaces()[faceNo].getEdges()[edgeNo].getData();
    }
    
    public String getCounterData() {
        int counterFaceNo = 5 - faceNo;
        
        return cube.getFaces()[counterFaceNo].getEdges()[edgeNo].getData();
    }
}
