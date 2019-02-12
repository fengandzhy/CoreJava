package com.citi.hz41382.java.thread.sh.md01;

public class MyThreadTest1 {
	public static void main(String args[]) throws InterruptedException{
		Thread currentthread = Thread.currentThread();
		System.out.println(currentthread.getName());
		
		Thread thread1 = new Thread(new MyThread1());
		Thread thread2 = new Thread(new MyThread2());
		
		thread1.start();
//		thread1.join();
		thread2.start();
	}
}
