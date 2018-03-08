package com.citi.hz41382.java.model.sigleton;

/**
 * 懒汉式，线程安全 
 * author: zhy 
 * date : 20171128
 * target: studing singleton model
 * */
public class Singleton2 {
	private static Singleton2 singleton2;
	
	private Singleton2(){
		
	}
	
	public static Singleton2 getInstance(){
		if(singleton2==null){
			synchronized(Singleton2.class){
				if(singleton2==null){ //check second time 
					singleton2 = new Singleton2();
				}
			}
		}		
		return singleton2;
	}
}
