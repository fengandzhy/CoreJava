package com.citi.hz41382.java.model.factory.factoryMethod;

public class ConcreteFactory1 implements Factory{

	@Override
	public Product createProduct() {
		// TODO Auto-generated method stub
		return new ConcreteProduct1();
	}

	
}
