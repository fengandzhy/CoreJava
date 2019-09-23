package org.zhouhy.hz41382.java.thread.sh.md10;

public class Customer extends Thread{
	private Restore re;
	public Customer(Restore re){
		this.re=re;
	}
	public void run(){
		synchronized (re) {
			while(true){
			
			int a = re.getA();
			while (re.getA() > 0) {								
				re.setA(a);
				a=a-1;
				System.out.println("Customer is running "+re.getA());
				try {
					sleep(1000);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
			}
			re.notify();
			
			while(re.getA()<10){
				try {
					System.out.println("Customer is waiting");
					re.wait();					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}		
		}
	}
}
