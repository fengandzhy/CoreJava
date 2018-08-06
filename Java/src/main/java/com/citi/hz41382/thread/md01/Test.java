package com.citi.hz41382.thread.md01;

public class Test {

	public static void main(String[] args) {
		Resource resource = new Resource();
		ThreadA ta = new ThreadA(resource);
		ThreadB tb = new ThreadB(resource);
		ThreadC tc = new ThreadC(resource);
		
		ta.start();
		
		tb.start();
		
		tc.start();

	}
}
