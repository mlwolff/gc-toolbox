package com.lupus.geo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class freq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter text: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	       
        String line = null;

        try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("Entered text:");
        System.out.println(line);

        Map<Character, Integer> countMap = new HashMap<>();
        
        line.chars()
            .mapToObj(i -> (Character)((char) i))
            .forEach(c -> { 
            	Integer count = countMap.get(c);
            	if (count != null) {
            		countMap.put(c, ++count);
            	} else {
            		countMap.put(c, 1);
            	}
            
            });
        System.out.println(countMap);
        
        
        for (int i = 2; i < line.length(); i++) {
        	System.out.print("Jeder " + i + ". Buchstabe: ");
        	
        	for (int j = 0; j < line.length(); j++) {
        		if (j % i == 0) {
        			System.out.print(line.substring(j, j+1));
        		}
        	}
        	
    		System.out.println();
        }
	}

}
