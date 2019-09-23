package org.zhouhy.hz41382.ssl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
	private Socket socket;
	
	public Server(Socket socket){
		this.socket = socket;
	}
	
	@Override
	public void run(){
		BufferedReader reader;
		PrintWriter writer;
		String data;
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream());
			data = reader.readLine();
			writer.println(data);
			writer.close(); 
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}     
	}
	
	public static void main(String args[]) throws IOException{		
		new Server((new ServerSocket(8088)).accept()).start();			
	}
}
