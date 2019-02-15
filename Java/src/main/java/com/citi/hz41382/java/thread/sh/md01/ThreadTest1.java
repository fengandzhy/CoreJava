package com.citi.hz41382.java.thread.sh.md01;

public class ThreadTest1 {

	/**
	 * @param args
	 * simple thread test
	 * zhouhy.sdc
	 * 2015-05-09
	 */
	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		
		thread1.start();
		thread2.start();
	}

}
