package com.citi.hz41382.java.proxy.md01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* <p>className: Client</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月28日
*/
public class Client {

	private static final Logger LOGGER = LoggerFactory.getLogger(Client.class);
	
	private Client(){}
	
	@Test
	public static void main(String[] args) {
		
		Subject realSubject = new RealSubject();
		InvocationHandler handler = new DynamicProxy(realSubject);
		
		Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);
		LOGGER.info(subject.getClass().getName());
		subject.rent();
		subject.hello("world");
	}

}
