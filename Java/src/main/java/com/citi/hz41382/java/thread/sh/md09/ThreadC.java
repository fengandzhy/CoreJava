package com.citi.hz41382.java.thread.sh.md09;

public class ThreadC extends Thread {
	private Resource resource;
	public ThreadC(Resource resource){
		this.resource = resource;
	}
	
	public void run(){
		synchronized (resource) {
			while(true){				
				while(resource.getSign()%3==0){
					int sign = resource.getSign();
					System.out.print("C ");
					sign++;
					resource.setSign(sign);
					try {
						sleep(1000);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}
				resource.notify();
				labelC:
				while(resource.getSign()%3!=0){
					try {						
						resource.wait();
						if(resource.getSign()%3!=0){							
							resource.notify();
							break labelC;
						}
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}					
				}
			}
		}
	}
}
