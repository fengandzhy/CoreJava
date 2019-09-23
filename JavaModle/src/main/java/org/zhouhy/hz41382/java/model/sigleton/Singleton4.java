package org.zhouhy.hz41382.java.model.sigleton;

/**
 * Static inner class modle, 
 * package the instance which need to be created as a single instance into a 
 * constant in a inner class. 
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
