package com.lupus.coin;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CoinCombinationIterator implements Iterator<CoinCombination> {
	private CoinCombination combination;
	private final int maxCoinCount;
	private final int amount;
	private boolean nextCalculated = false;
	
	/**
	 * 
	 * @param maxCoinCount
	 * @param amount
	 */
	public CoinCombinationIterator(int maxCoinCount, int amount) {
		this.combination = new CoinCombination();
		this.maxCoinCount = maxCoinCount;
		this.amount = amount;
	}

	@Override
	public boolean hasNext() {
		if (!nextCalculated) {
			combination = calculateNextCombination();
		}
		
		return combination != null;
	}

	/*
	 * (non-Javadoc)
	 * @see java.util.Iterator#next()
	 */
	@Override
	public CoinCombination next() {
		if (!nextCalculated) {
			combination = calculateNextCombination();
		}
		
		nextCalculated = false;
		
		if (combination == null) {
			throw new NoSuchElementException("No more combinations available.");
		}
		
		return combination;
	}
	
	/**
	 * 
	 * @return
	 */
	private CoinCombination calculateNextCombination() {
		List<Coin> coins = combination.getCoins();
		int currentCoinIdx = 0;
		
		do {
			Coin coin = coins.get(currentCoinIdx);
			combination.incrementAmount(coin);
			
			if (combination.getCoinCount() > maxCoinCount ||
			    combination.getAmount() > amount) { // We have an overflow
				for (int lowerCoinIdx = 0; lowerCoinIdx <= currentCoinIdx; lowerCoinIdx++) {
					combination.resetAmount(coins.get(lowerCoinIdx));
				}
				currentCoinIdx++;
			} else {
				if (combination.getAmount() == amount) break;
				currentCoinIdx = 0;
			}
		} while (currentCoinIdx < coins.size()); 
		
		nextCalculated = true;
		
		if (combination.getAmount() == amount && combination.getCoinCount() <= maxCoinCount) {
			return combination;
		} else {
			return null;
		}
	}
	
}
