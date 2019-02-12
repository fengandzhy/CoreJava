package com.citi.hz41382.java.model.factory.factorymethod.demo02.factories;

import com.citi.hz41382.java.model.factory.factorymethod.demo02.IFruit;
import com.citi.hz41382.java.model.factory.factorymethod.demo02.IFruitFactory;
import com.citi.hz41382.java.model.factory.factorymethod.demo02.products.Grape;

/**
* <p>className: GrapeFactory</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class GrapeFactory implements IFruitFactory {
	private boolean seedless;
	
	public GrapeFactory(boolean seedless){
		this.seedless = seedless;
	}
	
	@Override
	public IFruit createFruit() {
		Grape grape = new Grape();
		grape.setSeedless(seedless);
		return grape;
	}

}
