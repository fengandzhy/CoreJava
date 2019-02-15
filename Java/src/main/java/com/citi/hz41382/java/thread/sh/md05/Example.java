package com.citi.hz41382.java.thread.sh.md05;

public class Example {
	/**
	 *��������������synchronizedʱ,�����̲߳�������,
	 *�������synchronizedʱ,������һ���̵߳�0-9�������һ���� ��
	 * */
	public synchronized void execute(){
		for (int i = 0; i < 10; ++i){
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Hello: " + i);
		}
	}
}
