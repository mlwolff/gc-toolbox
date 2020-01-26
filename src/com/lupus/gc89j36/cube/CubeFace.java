package com.lupus.gc89j36.cube;

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
    private final Edge[] edges;

    /**
     * Creates the face of a cube.
     * 
     * @param edges
     *      Array of 4 {@link Edge edges}
     */
    public CubeFace(Edge[] edges) {
        checkEdges(edges);
        this.edges = edges;
    }

    /**
     * @return the edges
     */
    public Edge[] getEdges() {
        return edges;
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
