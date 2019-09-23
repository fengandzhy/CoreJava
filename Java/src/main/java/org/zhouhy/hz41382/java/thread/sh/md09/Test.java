package org.zhouhy.hz41382.java.thread.sh.md09;

public class Test {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Resource resource = new Resource();
		ThreadA ta = new ThreadA(resource);
		ThreadB tb = new ThreadB(resource);
		ThreadC tc = new ThreadC(resource);
		
		ta.start();
		
		tb.start();
		
		tc.start();

	}

}
