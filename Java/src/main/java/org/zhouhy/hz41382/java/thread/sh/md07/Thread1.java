package org.zhouhy.hz41382.java.thread.sh.md07;

public class Thread1 extends Thread{
	private Example example;
	
	public Thread1(Example example){
		this.example = example;
	}
	
	public void run(){
		Example.execute();
	}
}
