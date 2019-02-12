package com.citi.hz41382.java.proxy.md02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class MethodPerformance {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MethodPerformance.class);
	private long begin;
	private long end;
	private String serviceMethod;
	public MethodPerformance(String serviceMethod){
		this.serviceMethod=serviceMethod;
		this.begin=System.currentTimeMillis();
		//在创建的时候记录创建的时间。
	}
	public void printPerformance(){
		end=System.currentTimeMillis();
		long elapse=end-begin;
		LOGGER.info(serviceMethod+" keep "+elapse+" time");
		//在调用这个方法的时候记录下end的时间.
	}
}
