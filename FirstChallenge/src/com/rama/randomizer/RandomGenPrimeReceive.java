package com.rama.randomizer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;
import com.rama.queue.DistributedProcessQueue;

public class RandomGenPrimeReceive {
	private DistributedProcessQueue<Integer, PrimeResult> queue;
	public static final int MAX_RANDOM_NUMBER = 1000;
	
	public RandomGenPrimeReceive(int randomizerPortNumber) {
	
		queue = new DistributedProcessQueue<>(this::process, randomizerPortNumber);
	}
	
	public void run() {
		new Thread(new Generator()).start();
		new Thread(new Receiver()).start();
		queue.start();
	}
	
/// which generates random number and puts into input queue
	class Generator implements Runnable {
		private final Random randomGenerator = new Random();
		

		public void run() {
			while (true) {
				int randomInt = randomGenerator.nextInt(MAX_RANDOM_NUMBER);
				try {
					queue.put(randomInt);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return;
				}
			}
		}
	}

	//which receives random number from output queue and prints values 
	class Receiver implements Runnable {
		public void run() {
			while (true) {
				try {
					PrimeResult r = queue.take();
					if (r.isPrime()) {
						System.out.println(String.format("Number %d is a prime number", r.getNumber()));
					} else {
						System.out.println(String.format("Number %d is NOT prime number", r.getNumber()));
					}
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return;
				}
			}
		}
	}

	/* setting inputstream to recieve the data 
	 * outputstream to read data from the result
	 */
	
	public PrimeResult process(
			DataOutputStream out,
			DataInputStream in,
			Integer input) {
		try {
			out.writeInt(input);
			int number = in.readInt();
			boolean isPrime = in.readBoolean();

			return new PrimeResult(number, isPrime);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
