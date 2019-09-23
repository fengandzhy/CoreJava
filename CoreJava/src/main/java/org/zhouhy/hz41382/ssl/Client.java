package org.zhouhy.hz41382.ssl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost", 8088);        
		PrintWriter writer = new PrintWriter(s.getOutputStream()); 
		BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));         
		writer.println("hello");         
		writer.flush();        
		System.out.println(reader.readLine());         
		s.close(); 
	}

}
