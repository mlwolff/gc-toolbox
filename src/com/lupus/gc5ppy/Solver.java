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

		System.out.println(intList);
		
		int count = 1;
		
		
		while (intList.size() > 15) {
			for (int i = 0; i < intList.size(); i++) {
				if (count % 7 == 0) {
					intList.remove(i--);
					if (intList.size() == 15) break;
				}
				count++;
			}
		}
		
		System.out.println(intList);
	}

}
