package com.citi.hz41382.java.thread.sh.md13;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

	/**
	 * @author zhouhy
	 * 
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,  
                new ArrayBlockingQueue<Runnable>(5)); 
		for(int i=0;i<15;i++){
			MyTask myTask = new MyTask(i);
			executor.execute(myTask); 
			System.out.println("�̳߳����߳���Ŀ��"+executor.getPoolSize()+"�������еȴ�ִ�е�������Ŀ��"+ 
		             executor.getQueue().size()+"����ִ������������Ŀ��"+executor.getCompletedTaskCount()); 
		}
		executor.shutdown(); 
	}

}
