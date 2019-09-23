package org.zhouhy.hz41382.java.thread.sh.md07;

public class Thread2 extends Thread{
private Example example;
	
	public Thread2(Example example){
		this.example = example;
	}
	
	public void run(){
		Example.execute2();
	}
}
