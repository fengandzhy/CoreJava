package org.zhouhy.hz41382.java.thread.sh.md05;

public class ThreadTest {

	/**
	 * synchronized����ֻ���ͬһ��ʵ���ģ���ͬ�Ķ���ʵ���� synchronized�����ǲ�����ŵġ�Ҳ����˵��
	 * �����߳���������ͬʱ������ͬ�����һ������ʵ���е�synchronized����; 
	 */
	public static void main(String[] args) {
		Example example = new Example();
		
		Thread t1 = new Thread1(example);
        Thread t2 = new Thread1(example);

        t1.start();
        t2.start();
	}

}
