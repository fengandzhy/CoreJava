package com.citi.hz41382.java.thread.sh.md07;

public class ThreadTest {

	/**
	 * ���һ�������ж��synchronized���������籾���е�example
	 * ĳһʱ��ĳ���߳��Ѿ����뵽��ĳ��synchronized������
	 * ��ô�ڸ÷���û��ִ�����ǰ�������߳����޷����ʸö�����κ�synchronized�����ġ�
	 * 
	 * 
	 * Java�е�ÿ��������һ������lock�������߽�����������monitor����
	 * ��һ���̷߳���ĳ�������synchronized����ʱ�����ö���������
	 * �����κ��̶߳��޷���ȥ���ʸö����synchronized�����ˣ�������ָ���е�ͬ������������������ͬһ����������
	 * ֱ��֮ǰ���Ǹ��߳�ִ�з�����Ϻ󣨻������׳����쳣�����Ž��ö�������ͷŵ���
	 * �����̲߳��п�����ȥ���ʸö����synchronized����
	 */
	public static void main(String[] args) {
		Example example1 = new Example();
		Example example2 = new Example();
		
		Thread t1 = new Thread1(example1);
        Thread t2 = new Thread2(example2);
        
        t2.start();
        t1.start();
	}

}
