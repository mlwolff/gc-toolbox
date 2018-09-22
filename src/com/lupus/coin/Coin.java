package com.lupus.coin;

/**
 * Represents a coin.
 * <p>
 * The only property of a coin is its value.
 * </p>
 * 
 * @author mwolff
 *
 */
public class Coin {
	private final int value;
	
	public Coin(int value) {
		this.value = value;
	}
	
	/**
	 * @return The value of the coin.
	 */
	public int getValue() {
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coin) {
			Coin o = (Coin) obj;
			return (value == o.value);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return value;
	}

	
	
	@Override
	public String toString() {
		return String.format("Coin [Value: %d]", value);
	}
	
}
