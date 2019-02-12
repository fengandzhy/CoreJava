package com.citi.hz41382.java.thread.sh.md04;

public class Thread1 implements Runnable{
	private SharedResource resource;
	public Thread1(){
		
	}
	public Thread1(SharedResource resource){
		this.resource = resource;
	}
	public void run(){
//		SharedResource re=new SharedResource();
		resource.setA(3);
		resource.setB(4);
//		System.out.println(Thread.currentThread().getName()+" "+resource.getA()+" "+resource.getB());
//		try {
//			Thread.sleep(1000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		System.out.println(Thread.currentThread().getName()+" "+resource.getA()+" "+resource.getB());
	}
}
