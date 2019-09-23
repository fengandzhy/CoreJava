package org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.factories;

import org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.IFactory;
import org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.IProduct;
import org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.products.ConcreteProduct1;

public class ConcreteFactory1 implements IFactory{

	@Override
	public IProduct createProduct() {		
		return new ConcreteProduct1();
	}

	
}
