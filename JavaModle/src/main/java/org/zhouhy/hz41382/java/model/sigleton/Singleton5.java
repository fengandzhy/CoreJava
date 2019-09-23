package org.zhouhy.hz41382.java.model.sigleton;

import org.apache.log4j.Logger;


/**
 * enumeration model. 
 * author: zhy 
 * date : 20171128
 * target: studing singleton model
 * */

public enum Singleton5 {
	
	INSTANCE; 
	private static Logger logger = Logger.getLogger(Singleton5.class);
	
	public void doSomething(){
		logger.info("singleton has been created!");
	}
}
