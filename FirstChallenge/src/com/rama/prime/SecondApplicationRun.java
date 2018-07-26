package com.rama.prime;

public class SecondApplicationRun {
	private static final int SERVER_PORT = 12345;

	public static void main(String[] args) {
		System.out.println("Starting Prime client connecting to port " + SERVER_PORT);
		new PrimeApplication(SERVER_PORT).run();
	}
}
