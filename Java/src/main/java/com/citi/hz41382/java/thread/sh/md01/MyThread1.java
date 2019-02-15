package com.citi.hz41382.java.thread.sh.md01;

public class MyThread1 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 100; ++i){
            System.out.println("Hello: " +Thread.currentThread().getName()+" "+ i);
        }		
	}
}
