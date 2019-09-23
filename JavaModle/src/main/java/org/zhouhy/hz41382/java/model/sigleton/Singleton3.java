package org.zhouhy.hz41382.java.model.sigleton;


/**
 * Eager singleton  
 * author: zhy 
 * date : 20171128
 * target: studing singleton model
 * */
public class Singleton3 {
	private static final Singleton3 single= new Singleton3();
	
	private Singleton3(){}
	
	@SuppressWarnings("unused")
	private static Singleton3 getInstance(){
		return single;
	}
}
