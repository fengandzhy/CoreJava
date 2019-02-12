package com.citi.hz41382.java.thread.sh.md06;

public class Example {
	
	public synchronized void execute(){
		for (int i = 0; i < 10; ++i){
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Hello: " + i);
		}
	}
	
	public synchronized void execute2(){
		for (int i = 0; i < 20; ++i){
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("World: " + i);
		}
	}
}
