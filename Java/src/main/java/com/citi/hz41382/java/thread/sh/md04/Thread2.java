package com.citi.hz41382.java.thread.sh.md04;

public class Thread2 implements Runnable{
	private SharedResource resource;
	public Thread2(){
		
	}
	public Thread2(SharedResource resource){
		this.resource = resource;
	}
	public void run() {
//		SharedResource re=new SharedResource();
		resource.setA(1);
		resource.setB(2);
		System.out.println(Thread.currentThread().getName()+" "+resource.getA()+" "+resource.getB());		
	}

}
