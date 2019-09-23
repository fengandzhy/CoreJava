package org.zhouhy.hz41382.java.thread.sh.md01;

public class MyThread2 implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 100; ++i){
            System.out.println("Welcome: "+Thread.currentThread().getName()+" " + i);
        }		
	}
}
