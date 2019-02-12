package com.citi.hz41382.java.thread.nz.md01;

public class ThreadA extends Thread {
	
	private Resource resource;
	
	public ThreadA(Resource resource){
		this.resource = resource;
	}

	@Override
	public void run() {
		synchronized(resource){
			while(true){
				if(resource.getSign()%3==1){
					int sign = resource.getSign();
					System.out.print("A");
					sign++;
					resource.setSign(sign);
					try {
						sleep(1000);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
					resource.notify();
				}else{
					try {
						resource.wait();
						if(resource.getSign()%3!=1){
							resource.notify();
						}
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
}
