package com.rama.queue;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class DistributedProcessQueue<InputQueue, OutputQueue> {
	int MAX_BUFFERED_INPUTS = 100;
	private final BlockingQueue<InputQueue> inputQueue = new LinkedBlockingQueue<InputQueue>(MAX_BUFFERED_INPUTS);
	private final BlockingQueue<OutputQueue> outputQueue = new LinkedBlockingQueue<OutputQueue>();
	private final ClientProxyProcess<InputQueue, OutputQueue> workerProcess;
	private final ServerSocketRunnable serverSocketRunnable;
	
	public DistributedProcessQueue(ClientProxyProcess<InputQueue, OutputQueue> workerProcess, int serverPortNumber) {
		this.workerProcess = workerProcess;
		serverSocketRunnable = new ServerSocketRunnable(serverPortNumber);
	}
	
	public void start() {
		System.out.println("Starting DistributedProcessQueue");
		new Thread(serverSocketRunnable).start();
	}
	
	
	public void put(InputQueue e) throws InterruptedException {
		
		inputQueue.put(e);
	}
	
	/**
	 * Equivalent of {@link BlockingQueue#take()}
	 */
	public OutputQueue take() throws InterruptedException {
		return outputQueue.take();
	}
	
	class ServerSocketRunnable implements Runnable {
		private final int serverPortNumber;
		
		public ServerSocketRunnable(int serverPortNumber) {
			this.serverPortNumber = serverPortNumber;
		}

		public void run() {
			ServerSocket serverSocket = null;
			Socket socket = null;
			try {
				serverSocket = new ServerSocket(serverPortNumber);
				while (true) {
					socket = serverSocket.accept();
					new Thread(new ClientProxy<InputQueue, OutputQueue>(socket, workerProcess, inputQueue, outputQueue)).start();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				System.out.println("Closing DistributedProcessQueue");
				try {
					if (serverSocket != null) serverSocket.close();
				} catch (IOException e) {
					System.out.println("Exception when closing ServerSocket");
				}
			}
		}
	}
}
