package org.zhouhy.hz41382.java.thread.sh.md02;

public class HelloThread implements Runnable{
	int i;

	@Override
	public void run() {
		while (true){
            System.out.println("Hello number: " + i++);
            try{
                Thread.sleep((long) Math.random() * 1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            if (50 == i){
                break;
            }
        }
	}	
}
