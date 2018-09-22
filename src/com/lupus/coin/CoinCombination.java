package com.lupus.coin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;

public class CoinCombination {
	/**
	 * Comparator for {@link Coin Coins}
	 */
	private final Comparator<Coin> coinComparator = (c1, c2) ->  {
		if (c1 == c2) return 0;
		if (c1 == null) return -1;
		if (c2 == null) return 1;
		
		int sgn = (int) Math.signum(c1.getValue() - c2.getValue());
		
		return sgn;
	};
	
	private final Map<Coin, Integer> coinMap = new TreeMap<>(coinComparator);
	private final List<Coin> coins = new ArrayList<>();
	
	/**
	 * 
	 */
	public CoinCombination() {
		int[] values = new int[] {1,2,5,10,20,50,100};
		
		for (int value : values) {
			Coin coin = new Coin(value);
			coinMap.put(coin, 0);
		}
		
		coins.addAll(coinMap.keySet());
	}
	
	/**
	 * @return Unmodifiable sorted list of all available coins.
	 */
	public List<Coin> getCoins() {
		return Collections.unmodifiableList(coins);
	}
	
	/**
	 * 
	 * @param coin
	 * @param amount
	 */
	public void setCoinAmount(Coin coin, int amount) {
		Objects.requireNonNull(coin, "Parameter coin must not be null");
		
		if (amount < 0) {
			amount = 0;
		}
		
		coinMap.put(coin, amount);
	}
	
	/**
	 * 
	 * @param coin
	 * @return
	 */
	public int getCoinAmount(Coin coin) {
		Objects.requireNonNull(coin, "Parameter coin must not be null");
		Integer amount = coinMap.get(coin);
		
		if (amount == null) {
			throw new NoSuchElementException("Coin " + coin  + " unknown");
		}
		
		return amount;
	}

	/**
	 * 
	 * @param coin
	 */
	public void resetAmount(Coin coin) {
		if (coinMap.containsKey(coin)) {
			coinMap.put(coin, 0);
		} else {
			throw new IllegalArgumentException("Coin " + coin + " not supported by current combination");
		}
	}
	
	/**
	 * Increments the amount for the passed {@link Coin}.
	 * @param coin
	 * 		Reference to a {@code Coin}
	 * 
	 * @return
	 * 		The new count for the passed {@code Coin}
	 */
	public int incrementAmount(Coin coin) {
		Integer count = coinMap.get(coin);
		
		if (count != null) {
			coinMap.put(coin, ++count);
		} else {
			throw new IllegalArgumentException("Coin " + coin + " not supported by current combination");
		}
		
		return count;
	}
	
	/**
	 * @return The total count of coins.
	 */
	public int getCoinCount() {
		int count = 0;
		
		for (int coinCount : coinMap.values()) {
			count += coinCount;
		}
		
		return count;
	}
	
	/**
	 * @return The sum of all coins considering their count
	 */
	public int getAmount() {
		int amount = 0;
		
		for (Entry<Coin, Integer> entry : coinMap.entrySet()) {
			amount += entry.getKey().getValue() * entry.getValue();
		}
		
		return amount;
	}
	
	/**
     * @return The map of the current combination.
	 */
	public Map<Coin, Integer> getCombination() {
		return Collections.unmodifiableMap(coinMap);
	}
	
	@Override
	public String toString() {
		String s = String.format("CoinCombnination [Count: %d, Amount: %d {Combination: %s}]", getCoinCount(), getAmount(), getCombination());
	    return s;
	}
}
