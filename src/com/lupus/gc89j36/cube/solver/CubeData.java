package com.lupus.gc89j36.cube.solver;

import com.lupus.gc89j36.cube.Cube;

public class CubeData {
    /** The Cube. */
    private final Cube cube;
    private int faceNo = 0;
    private int edgeNo = 0;
    
    public CubeData(Cube cube) {
        this.cube = cube;
    }
    
    /**
     * Copy constructor.
     * 
     * @param data
     */
    public CubeData(CubeData data) {
        this.cube = data.cube;
        this.faceNo = data.faceNo;
        this.edgeNo = data.edgeNo;
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
    
    public String getUpperData() {
        return cube.getFaces()[faceNo].getEdges()[edgeNo].getData();
    }
    
    public String getLowerData() {
    	int lowerEdgeNo = (edgeNo + 2) % 4;
    	
        return cube.getFaces()[5 - faceNo].getEdges()[lowerEdgeNo].getData();
    }
}
