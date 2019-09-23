package org.zhouhy.hz41382.java.thread.sh.md08;

public class Thread2 extends Thread{
	private ExampleA exampleA;
	private ExampleB exampleB;
	
	public Thread2(ExampleA exampleA,ExampleB exampleB){
		this.exampleA = exampleA;
		this.exampleB = exampleB;
	}
	
	public void run(){
		synchronized(exampleB){
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}			
			exampleA.methodA();
		}		
	}
}
