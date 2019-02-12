package com.citi.hz41382.java.model.factory.factorymethod.demo01.products;

import com.citi.hz41382.java.model.factory.factorymethod.demo01.IProduct;

public class ConcreteProduct1 implements IProduct {

	
	@Override
	public void print() {
		System.out.println("This is product1");

	}

}
