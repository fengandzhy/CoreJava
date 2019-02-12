package com.citi.hz41382.java.thread.sh.md04;

public class SharedResource {
	private int a = 0;
	private int b = 0;
	public synchronized void setA(int a){ 
    	this.a = a; 
    }

    public synchronized void setB(int b){ 
    	this.b = b; 
    }
    public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}
	public static void main(String args[]){
		SharedResource resource = new SharedResource();
    	Thread1 th1=new Thread1(resource);
    	Thread2 th2=new Thread2(resource);
    	Thread t1=new Thread(th1,"thread21");
    	Thread t2=new Thread(th2,"thread22");
    	Thread t3=new Thread(th1,"thread11");
    	Thread t4=new Thread(th2,"thread12");
//    	System.out.println(t1.equals(t2a));
//    	System.out.println(t3.equals(t4));
    	t1.start();
    	t2.start();
    	t3.start();
    	t4.start();
    	
    }
}
