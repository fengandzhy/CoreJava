package com.citi.hz41382.java.thread.sh.md09;

public class ThreadB extends Thread {
	private Resource resource;	
	public ThreadB(Resource resource){
		this.resource = resource;
	}
	
	public void run(){
		synchronized(resource){
			while(true){							
				while(resource.getSign()%3==2){
					int sign = resource.getSign();
					System.out.print("B");
					sign++;
					resource.setSign(sign);
					try {
						sleep(1000);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}
				resource.notify();
				labelB:
				while(resource.getSign()%3!=2){
					try {						
						resource.wait();
						if(resource.getSign()%3!=2){							
							resource.notify();
							break labelB;
						}
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}					
				}
			}
		}
	}
}
