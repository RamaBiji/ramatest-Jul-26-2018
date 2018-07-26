package com.rama.randomizer;

public class PrimeResult {
	private final int randomNumber;
	private final boolean isPrime;
	
	public PrimeResult(int number, boolean isPrime) {
		this.randomNumber = number;
		this.isPrime = isPrime;
	}

	public int getNumber() {
		return randomNumber;
	}

	public boolean isPrime() {
		return isPrime;
	}
}
