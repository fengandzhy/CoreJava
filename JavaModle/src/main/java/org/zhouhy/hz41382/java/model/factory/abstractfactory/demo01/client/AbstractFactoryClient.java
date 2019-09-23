package org.zhouhy.hz41382.java.model.factory.abstractfactory.demo01.client;

import org.junit.Test;

import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo01.IFruit;
import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo01.IGenerator;
import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo01.IVegetable;
import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo01.factories.TropicalGarden;

/**
* <p>className: AbstractFactoryClient</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class AbstractFactoryClient {

	private AbstractFactoryClient(){
		
	}
	
	@Test
	public static void main(String[] args) {
		IGenerator generator = new TropicalGarden();
		IFruit banana = generator.plantFruit("banana");
		IVegetable loofah = generator.plantVegetable("loofah");
		banana.plant();
		loofah.plant();
		
	}

}
