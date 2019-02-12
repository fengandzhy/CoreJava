package com.citi.hz41382.java.thread.nz.md01;

import org.junit.Test;

public class TestThread {

	private TestThread(){
		
	}
	
	@Test
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
