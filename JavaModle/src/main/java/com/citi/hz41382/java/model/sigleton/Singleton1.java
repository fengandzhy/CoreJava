package com.citi.hz41382.java.model.sigleton;

/**
 * 懒汉式单例模式
 * Lazy Singleton, It is not thread safe
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
