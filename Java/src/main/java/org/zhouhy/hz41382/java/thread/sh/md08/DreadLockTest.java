package org.zhouhy.hz41382.java.thread.sh.md08;

public class DreadLockTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExampleA exampleA = new ExampleA();
		ExampleB exampleB = new ExampleB();
		
		Thread1 thread1 = new Thread1(exampleA,exampleB);
		Thread2 thread2 = new Thread2(exampleA,exampleB);
		
		thread1.start();
		thread2.start();
		
	}

}
