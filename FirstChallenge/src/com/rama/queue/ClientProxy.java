package com.rama.queue;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;


class ClientProxy<IT, OT> implements Runnable {
	private final Socket socket;
	private final DataInputStream in;
	private final DataOutputStream out;
	private final ClientProxyProcess<IT, OT> clientProxyProcess;

	private final BlockingQueue<IT> inputQueue;
	private final BlockingQueue<OT> outputQueue;

	public ClientProxy(
			Socket socket, 
			ClientProxyProcess<IT, OT> workerProcess,
			BlockingQueue<IT> inputQueue,
			BlockingQueue<OT> outputQueue
			) {
		this.socket = socket;
		try {
			this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		this.inputQueue = inputQueue;
		this.outputQueue = outputQueue;
		this.clientProxyProcess = workerProcess;
	}


	public void run() {
		try {
			while (true) {
				try {
					IT input = inputQueue.take();
					OT result = clientProxyProcess.process(out, in, input);
					outputQueue.put(result);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return;
				}
			}
		} finally {
			close();
		}
	}

	private void close() {
		try {
			socket.close();
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}