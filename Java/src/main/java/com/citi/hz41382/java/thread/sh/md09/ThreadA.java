package com.citi.hz41382.java.thread.sh.md09;

public class ThreadA extends Thread {
	private Resource resource;
	
	public ThreadA(Resource resource){
		this.resource = resource;
	}
	
	public void run(){
		synchronized(resource){
			while(true){				
				while(resource.getSign()%3==1){
					int sign = resource.getSign();
					System.out.print("A");
					sign++;
					resource.setSign(sign);
					try {
						sleep(1000);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}
				resource.notify();
				labelA:
				while(resource.getSign()%3!=1){
					try {						
						resource.wait();
						if(resource.getSign()%3!=1){
							resource.notify();
							break labelA;
						}
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}					
				}
			}
		}
	}
}
