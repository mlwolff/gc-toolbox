package com.lupus.gc89j36.cube;

import java.util.Arrays;
import java.util.Objects;

/**
 * 
 * @author mlwolff
 *
 */
public class Cube {
    final CubeFace[] faces;
    final int num;

    /**
     * 
     * @param faces
     */
    public Cube(CubeFace[] faces, int num) {
        checkFaces(faces);
        this.faces = faces;
        this.num = num;
    }

    /**
     * @return the faces
     */
    public CubeFace[] getFaces() {
        return faces;
    }
    
    public int getNum() {
        return num;
    }

    
    @Override
    public String toString() {
        return "Cube [faces=" + Arrays.toString(faces) + ", num=" + num + "]";
    }

    /**
     * 
     * @param faces
     */
    private void checkFaces(CubeFace[] faces) {
        Objects.requireNonNull(faces, "Array of faces mustn't be null");
        
        if (faces.length != 6) {
            throw new IllegalArgumentException("Array of faces must have 6 elements, but has " + 
                                                faces.length + " elements.");
        }
    }

    
}
