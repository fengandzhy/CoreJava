package com.citi.hz41382.java.model.factory.factorymethod;

import org.apache.log4j.Logger;

public class ConcreteProduct2 implements Product{
	private Logger logger = Logger.getLogger(ConcreteProduct2.class);
	@Override
	public void print() {
		logger.info("This is product2");		
	}
}
