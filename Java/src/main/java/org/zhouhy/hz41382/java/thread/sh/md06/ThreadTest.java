package org.zhouhy.hz41382.java.thread.sh.md06;

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
		Example example = new Example();
		
		Thread t1 = new Thread1(example);
        Thread t2 = new Thread2(example);

        t1.start();
        t2.start();
	}

}
