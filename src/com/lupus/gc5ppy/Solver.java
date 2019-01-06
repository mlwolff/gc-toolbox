package com.lupus.gc5ppy;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.lupus.geocaching.Utils;

/**
 * Solves Mystery GC5PPY
 * @author mwolff
 *
 */
public class Solver {

	public static void main(String[] args) throws IOException {
		List<Integer> intList = new ArrayList<Integer>();
		try (InputStream is = Solver.class.getClassLoader().getResourceAsStream("com/lupus/gc5ppy/data.txt");) {
			
			Utils.readInts(is, i -> {
				intList.add(i);
			});
		};
		
		int index = 6;
		
		while (intList.size() > 15) {
			intList.remove(index);
			index += 6;
			index %= intList.size();
		}
				
		System.out.println(intList);
	}

}
