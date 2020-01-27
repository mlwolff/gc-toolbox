package com.lupus.gc89j36.cube.util;

import java.util.ArrayList;
import java.util.List;

import com.lupus.gc89j36.cube.Cube;
import com.lupus.gc89j36.cube.CubeFace;
import com.lupus.gc89j36.cube.Edge;

public class CubeBuilder {
    private boolean inCube = false;
    private boolean inFace = false;
    private List<CubeFace> faces = null;
    private List<Edge> edges = null;
    
    
    /**
     * Starts cube building.
     * 
     * @return
     *      this
     */
    public CubeBuilder beginCube() {
        if (inCube) {
            throw new IllegalStateException("Cube building already started.");
        }
        
        inCube = true;
        
        return this;
    }
    
    /**
     * 
     * @return
     */
    public Cube endCube() {
        if (!inCube) {
            throw new IllegalStateException("Cube building still not started.");
        }
        
        if (faces == null || faces.size() != 6) {
            throw new IllegalArgumentException("Not enough faces available");
        }
        
        CubeFace[] facesArr = faces.toArray(new CubeFace[faces.size()]);
        
        inCube = false;
        return new Cube(facesArr);
    }
    
    /**
     * 
     * @return
     */
    public CubeBuilder beginFace() {
        if (!inCube) {
            throw new IllegalStateException("Cube building still not started.");
        }
        
        if (inFace) {
            throw new IllegalStateException("Face building already started.");
        }
        if (faces == null) {
            faces = new ArrayList<>(6);
        }
        
        if (faces.size() == 6) {
            throw new IllegalStateException("Having already 6 faces");
        }
       
        inFace = true;
        
        return this;
    }
    
    /**
     * 
     * @return
     */
    public CubeBuilder endFace() {
        if (!inFace) {
            throw new IllegalStateException("beginFace() not called.");
        }
        
        if (edges == null || edges.size() != 4) {
            throw new IllegalArgumentException("Not enough edges available");
        }
        
        CubeFace cubeFace = new CubeFace(edges.toArray(new Edge[edges.size()]));
        
        edges.clear();
        faces.add(cubeFace);
        inFace = false;
        
        return this;
    }
    
    /**
     * 
     * @param data
     * @return
     */
    public CubeBuilder addEdge(String data) {
        if (!inFace) {
            throw new IllegalStateException("beginFace() not called.");
        }
        
        if (edges == null) {
            edges = new ArrayList<>(4);
        }
        
        if (edges.size() == 4) {
            throw new IllegalStateException("Having already 4 edges.");
        }
        
        edges.add(new Edge(data));
        
        return this;
    }

}
