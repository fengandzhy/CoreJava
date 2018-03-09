package com.citi.hz41382.java.model.factory.factoryMethod;

public class ConcreteFactory2 implements Factory {

	@Override
	public Product createProduct() {
		
		return new ConcreteProduct2();
	}

}
