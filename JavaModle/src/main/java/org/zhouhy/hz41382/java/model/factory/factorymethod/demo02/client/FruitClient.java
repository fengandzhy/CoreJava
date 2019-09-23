package org.zhouhy.hz41382.java.model.factory.factorymethod.demo02.client;

import org.junit.Test;

import org.zhouhy.hz41382.java.model.factory.factorymethod.demo02.IFruit;
import org.zhouhy.hz41382.java.model.factory.factorymethod.demo02.IFruitFactory;
import org.zhouhy.hz41382.java.model.factory.factorymethod.demo02.factories.AppleFactory;


/**
* <p>className: FruitClient</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class FruitClient {

	private FruitClient(){
		
	}
	
	@Test
	public static void main(String[] args) {
		IFruitFactory appleFactory = new AppleFactory(10);
		IFruit apple = appleFactory.createFruit();
		apple.plant();
	}

}
