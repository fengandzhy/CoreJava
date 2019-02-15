package com.citi.hz41382.java.thread.sh.md06;

public class Thread1 extends Thread{
	private Example example;
	
	public Thread1(Example example){
		this.example = example;
	}
	
	public void run(){
		example.execute();
	}
}
