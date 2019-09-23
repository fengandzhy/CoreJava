package org.zhouhy.hz41382.java.thread.nz.md01;

public class ThreadB extends Thread {
	
	private Resource resource;
	
	public ThreadB(Resource resource){
		this.resource = resource;
	}
	
	@Override
	public void run() {
		synchronized(resource){
			while(true){
				if(resource.getSign()%3==2){
					int sign = resource.getSign();
					System.out.print("B");
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
						if(resource.getSign()%3!=2){
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
