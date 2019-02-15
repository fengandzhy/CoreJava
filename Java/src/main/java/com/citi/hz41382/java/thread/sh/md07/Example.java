package com.citi.hz41382.java.thread.sh.md07;

public class Example {
	/**
	 * ���ĳ��synchronized������static�ģ���ô���̷߳��ʸ÷���ʱ��
	 * �����Ĳ�����synchronized�������ڵĶ���
	 * ����synchronized�������ڵ�������Ӧ��Class����
	 * Java�У�����һ�����ж��ٸ�������Щ������ӦΨһһ��Class����
	 * ��˵��̷ֱ߳����ͬһ������������������static��synchronized����ʱ��
	 * ���ǵ�ִ��˳��Ҳ��˳��ģ�Ҳ����˵һ���߳���ȥִ�з�����ִ����Ϻ���һ���̲߳ſ�ʼ��
	 * 
	 * */
	public synchronized static void execute(){
		for (int i = 0; i < 10; ++i){
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Hello: " + i);
		}
	}
	
	public synchronized static void execute2(){
		for (int i = 0; i < 20; ++i){
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("World: " + i);
		}
	}
}
