package org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.products;

import org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.IProduct;

public class ConcreteProduct1 implements IProduct {

	
	@Override
	public void print() {
		System.out.println("This is product1");

	}

}
