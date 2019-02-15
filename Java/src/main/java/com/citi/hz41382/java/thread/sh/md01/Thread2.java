package com.citi.hz41382.java.thread.sh.md01;

public class Thread2 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 100; ++i){
            System.out.println("Welcome: " + i);
        }
	}	
}
