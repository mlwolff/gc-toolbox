/**
 * 
 */
package com.lupus.geocaching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Utility class, contains only static methods.
 * @author mwolff
 *
 */
public class Utils {
	/**
	 * The class only has static methods.
	 */
	private Utils() {
	}
	
	/**
	 * Reads lines until empty line.
	 * @param is
	 * 		Reference to an {@link InputStream}.
	 * @param consumer
	 * 		{@link Consumer}.
	 */
	public static void readLinesUntilEmpty(InputStream is, Consumer<String> consumer) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			String line;
			
			do {
				line = reader.readLine();
				
				if (line.length() > 0) {
					consumer.accept(line);
				} else {
					break;
				}
			} while (true);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Reads integer values, until no more available.
	 * 
	 * @param is
	 * 		Reference to an {@link InputStream}.
	 * @param consumer
	 * 		{@link Consumer}, consuming the read ints.
	 */
	public static void readInts(InputStream is, Consumer<Integer> consumer) {
		Scanner scanner = new Scanner(is);
		
		while (scanner.hasNextInt()) {
			consumer.accept(scanner.nextInt());
		}
	}
}
