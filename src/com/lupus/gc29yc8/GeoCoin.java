package com.lupus.gc29yc8;

public class GeoCoin {
	boolean inBag = false;
	final int value;
	final int weight;
	
	/**
	 * 
	 * @param value
	 * @param weight
	 */
	public GeoCoin(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
	
	
	/**
	 * 
	 * @param geoCoin
	 */
	public GeoCoin(GeoCoin geoCoin) {
		inBag = geoCoin.inBag;
		value = geoCoin.value;
		weight = geoCoin.weight;
	}
	
	/**
	 * @return the inBag
	 */
	public boolean isInBag() {
		return inBag;
	}

	/**
	 * @param inBag the inBag to set
	 */
	public void setInBag(boolean inBag) {
		this.inBag = inBag;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}


	@Override
	public String toString() {
		return "GeoCoin [inBag=" + inBag + ", value=" + value + ", weight=" + weight + "]";
	}
	
}
