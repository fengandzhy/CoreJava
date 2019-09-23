package org.zhouhy.hz41382.java.thread.sh.md08;

public class ExampleB {
	public synchronized void methodB(){
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+" B:"+i);
		}
	}
}
