package com.lupus.coin;

public class Solver {

	public static void main(String[] args) {
		/*
		CoinCombination coinCombination = new CoinCombination();
		Map<Coin, Integer> combination = coinCombination.getCombination();
		
		System.out.println(coinCombination);
		System.out.println(combination);
		
		
		coinCombination.incrementAmount(new Coin(200));
		
		System.out.println(coinCombination);
		System.out.println(combination);
		*/
		
//		CoinCombinationIterator it = new CoinCombinationIterator(22, 77);
		CoinCombinationIterator it = new CoinCombinationIterator(23, 51);
//		CoinCombinationIterator it = new CoinCombinationIterator(7, 12);

		int matches = 0;
		while (it.hasNext()) {
			CoinCombination coinCombination = it.next();
			System.out.println(coinCombination);
			matches++;
		}
		
		System.out.println("Found " + matches + " valid combinations.");
		
	}

}
