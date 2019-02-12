package com.citi.hz41382.java.proxy.md01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* <p>className: DynamicProxy</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月28日
*/
public class DynamicProxy implements InvocationHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RealSubject.class);
	private Subject subject;	
	
	public DynamicProxy(Subject subject){
		this.subject=subject;
	}
	
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		LOGGER.info("before rent house");
		LOGGER.info("Method:"+method);
		method.invoke(subject, args);
		LOGGER.info("after rent house");
		return null;
	}

}
