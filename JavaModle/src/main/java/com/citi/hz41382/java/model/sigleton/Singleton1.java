package com.citi.hz41382.java.model.sigleton;

/*
 * ����ʽ���̲߳���ȫ 
 * author: zhy 
 * date : 20171128s
 * **/

public class Singleton1 {
	
	private static Singleton1 singleton1;
	
	private Singleton1(){
		
	}
	
	public static Singleton1 getInstance(){
		if(singleton1==null){
			singleton1 = new Singleton1();
		}
		
		return singleton1;
	}
}
