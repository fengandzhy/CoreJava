package com.citi.hz41382.java.thread.sh.md10;

public class Producter extends Thread{
	private Restore re;
	public Producter(Restore re){
		this.re=re;
	}
	public void run(){
		synchronized (re) {			
			while(true){
			int a = re.getA();			
			while (re.getA() <= 10) {
				a=a+1;
				re.setA(a);
				System.out.println("Producter is running"+re.getA());
				try {
					sleep(1000);
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
			}
			re.notify();
			//���������������ʱ��,�Լ����ڵȴ���״̬�ͷ�����,�����Customer�߳�
			//�õ�������ʼִ����.
			try {
				while(re.getA()>0){
					System.out.println("Producter is waiting");
					re.wait();						
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		//System.out.println("aaaaaaaa");
	}
	
		
	
}
