package org.zhouhy.hz41382.java.thread.sh.md02;

public class HelloThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 HelloThread r = new HelloThread();
		 Thread t1 = new Thread(r);
	     Thread t2 = new Thread(r);
	     t1.start();
	     t2.start();
	}
}
