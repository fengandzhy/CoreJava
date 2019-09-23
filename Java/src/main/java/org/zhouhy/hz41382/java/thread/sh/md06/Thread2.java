package org.zhouhy.hz41382.java.thread.sh.md06;

public class Thread2 extends Thread{
private Example example;
	
	public Thread2(Example example){
		this.example = example;
	}
	
	public void run(){
		example.execute2();
	}
}
