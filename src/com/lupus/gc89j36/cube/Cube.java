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

    /**
     * 
     * @param faces
     */
    public Cube(CubeFace[] faces) {
        checkFaces(faces);
        this.faces = faces;
    }

    /**
     * @return the faces
     */
    public CubeFace[] getFaces() {
        return faces;
    }

    @Override
    public String toString() {
        return "Cube [faces=" + Arrays.toString(faces) + "]";
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
