package com.citi.hz41382.java.model.factory.factorymethod.demo01.factories;

import com.citi.hz41382.java.model.factory.factorymethod.demo01.IFactory;
import com.citi.hz41382.java.model.factory.factorymethod.demo01.IProduct;
import com.citi.hz41382.java.model.factory.factorymethod.demo01.products.ConcreteProduct1;

public class ConcreteFactory1 implements IFactory{

	@Override
	public IProduct createProduct() {		
		return new ConcreteProduct1();
	}

	
}
