package com.rama.randomizer;


//First application which puts the message to input queue and reads from output queue
public class FirstApplicationRun {
	private static final int SERVER_PORT = 12345;

	public static void main(String[] args) {
		System.out.println("Starting Randomizer on port " + SERVER_PORT);
		new RandomGenPrimeReceive(SERVER_PORT).run();
	}
}
