package com.citi.hz41382.java.model.sigleton;

/**
 * 静态内部类方式
 * author: zhy 
 * date : 20171128
 * target: studing singleton model
 * */
public class Singleton4 {
	
	private static class SingletonHolder{
		private static final Singleton4 INSTANCE = new Singleton4();
	}
	
	private Singleton4(){}
	
	public static final Singleton4 getInstance() {  
        return SingletonHolder.INSTANCE; 
    }  
}
