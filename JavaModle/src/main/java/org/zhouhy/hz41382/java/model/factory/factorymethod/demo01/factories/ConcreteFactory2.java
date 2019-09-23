package org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.factories;

import org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.IFactory;
import org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.IProduct;
import org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.products.ConcreteProduct2;

public class ConcreteFactory2 implements IFactory {

	@Override
	public IProduct createProduct() {
		
		return new ConcreteProduct2();
	}

}
