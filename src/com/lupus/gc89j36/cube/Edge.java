package com.lupus.gc89j36.cube;

import java.util.Objects;

/**
 * Represents an edge of a {@link CubeFace face} of a {@link Cube}.
 * @author mlwolff
 *
 */
public class Edge {
    final String data;

    /**
     * Creates an {@link Edge}.
     * 
     * @param data
     *      Data representation.
     */
    public Edge(String data) {
        checkData(data);
        
        this.data = data;
    }
   
    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Edge [data=" + data + "]";
    }


    /**
     * Check validity of passed data string.
     * <p>
     * Validate data has a lenth of 2 and contains only 'N','E', digits or '#'. 
     * </p>
     * 
     * @param data
     *      Data to check.
     */
    private void checkData(String data) {
        Objects.requireNonNull(data, "Data must not be null");
        
        // Check required length
        if (data.length() != 2) {
            throw new IllegalArgumentException("Passed data length has to be 2, but is " + data.length());
        }
        
        for (int pos = 0; pos < data.length(); pos++) {
            char c = data.charAt(pos);
            
            if (c != 'N' && c != 'E' && c != '#' && (c < '0' || c > '9')) {
                throw new IllegalArgumentException("Data contains invalid character: " + c);
            }
        }
    }
}