package com.rama.queue;

import java.io.DataInputStream;
import java.io.DataOutputStream;


public interface ClientProxyProcess<Input, Output> {


	Output process(
			DataOutputStream out,
			DataInputStream in,
			Input input);
}