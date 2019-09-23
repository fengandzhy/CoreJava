package org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.client;

import org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.IFactory;
import org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.IProduct;
import org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.factories.ConcreteFactory1;
import org.zhouhy.hz41382.java.model.factory.factorymethod.demo01.factories.ConcreteFactory2;

/**
* <p>className: FactoryMethodClient</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class FactoryMethodClient {
	
	private FactoryMethodClient(){
		
	}	
	public static void main(String[] args) {
		
		IFactory factory1 = new ConcreteFactory1();
		IProduct product1 = factory1.createProduct();
		product1.print();
		
		IFactory factory2 = new ConcreteFactory2();
		IProduct product2 = factory2.createProduct();
		product2.print();
	}

}
