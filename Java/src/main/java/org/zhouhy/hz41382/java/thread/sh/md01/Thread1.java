package org.zhouhy.hz41382.java.thread.sh.md01;

public class Thread1 extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 100; ++i){
            System.out.println("Hello World: " + i);
        }
	}	
}
