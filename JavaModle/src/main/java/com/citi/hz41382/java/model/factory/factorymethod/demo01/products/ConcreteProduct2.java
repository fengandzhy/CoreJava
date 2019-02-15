package com.citi.hz41382.java.model.factory.factorymethod.demo01.products;

import com.citi.hz41382.java.model.factory.factorymethod.demo01.IProduct;
import org.apache.log4j.Logger;

public class ConcreteProduct2 implements IProduct{
	private Logger logger = Logger.getLogger(ConcreteProduct2.class);
	@Override
	public void print() {
		logger.info("This is product2");		
	}
}
