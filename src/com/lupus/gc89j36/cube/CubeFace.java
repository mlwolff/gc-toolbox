package com.lupus.gc89j36.cube;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents the face of a {@link Cube}.
 * 
 * A {@code Cube} consists of 6 {@link CubeFace CubeFaces}, whereas each {@code CubeFace}
 * consists of 4 {@link Edge edges}. 
 * 
 * @author mlwolff
 *
 */
public class CubeFace {
	public static enum Colour {ORANGE, YELLOW, GREEN, BLUE};
	
    private final Edge[] edges;
    private final Colour color;

    /**
     * Creates the face of a cube.
     * 
     * @param edges
     *      Array of 4 {@link Edge edges}
     * @param color
     * 		Color of face
     */
    public CubeFace(Edge[] edges, Colour color) {
    	Objects.requireNonNull(color, "Parameter color must not be null");
        checkEdges(edges);
        this.edges = edges;
        this.color = color;
    }

    /**
     * @return the edges
     */
    public Edge[] getEdges() {
        return edges;
    }

    /**
     * 
     * @return
     */
    public Colour getColor() {
		return color;
	}
    
    @Override
	public String toString() {
		return "CubeFace [edges=" + Arrays.toString(edges) + ", color=" + color + "]";
	}

    /**
     * 
     * @param edges
     */
    private void checkEdges(Edge[] edges) {
        Objects.requireNonNull(edges, "Array of edges mustn't be null");
        
        if (edges.length != 4) {
            throw new IllegalArgumentException("Array of edges must have 4 elements, but has " + 
                                                edges.length + " elements.");
        }
    }
    
    
}
