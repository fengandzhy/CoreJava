package org.zhouhy.hz41382.java.thread.sh.md13;

public class MyTask implements Runnable{
	private int taskNum;
	
	public MyTask(int taskNum){
		this.taskNum = taskNum;
	}
	@Override
	public void run() {
		System.out.println("����ִ��task "+taskNum); 
		try {
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task "+taskNum+"ִ�����"); 
	}

}
