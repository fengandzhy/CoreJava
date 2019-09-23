package org.zhouhy.hz41382.java.thread.nz.md01;

public class ThreadC extends Thread {
	private Resource resource;
	
	public ThreadC(Resource resource){
		this.resource = resource;
	}
	
	@Override
	public void run() {
		synchronized(resource){
			while(true){
				if(resource.getSign()%3==0){
					int sign = resource.getSign();
					System.out.print("C ");
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
						if(resource.getSign()%3!=0){
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
