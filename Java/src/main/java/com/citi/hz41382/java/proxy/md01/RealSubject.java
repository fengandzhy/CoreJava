package com.citi.hz41382.java.proxy.md01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* <p>className: RealSubject</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月28日
*/
public class RealSubject implements Subject {

	private static final Logger LOGGER = LoggerFactory.getLogger(RealSubject.class);
	@Override
	public void rent() {
		LOGGER.info("I want to rent my house");

	}

	@Override
	public void hello(String str) {
		LOGGER.info("Hello,"+str);
	}

}
