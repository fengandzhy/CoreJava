package com.citi.hz41382.java.proxy.md02;

import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


/**
* <p>className: CglibProxy</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月28日
*/
public class CglibProxy implements MethodInterceptor{

	private static final Logger LOGGER = LoggerFactory.getLogger(CglibProxy.class);
	private Object target;
	public CglibProxy(Object target){
		this.target=target;
	}	
	public CglibProxy(){
		//empty
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		LOGGER.info("&&&&&&&");
		PerformanceMonitor.begin(obj.getClass().getName()+"."+method.getName());
		Object result=proxy.invokeSuper(obj, args);
		PerformanceMonitor.end();
		return result;		
	}	
}
