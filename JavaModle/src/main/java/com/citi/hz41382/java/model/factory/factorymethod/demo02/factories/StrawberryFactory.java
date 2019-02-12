package com.citi.hz41382.java.model.factory.factorymethod.demo02.factories;

import com.citi.hz41382.java.model.factory.factorymethod.demo02.IFruit;
import com.citi.hz41382.java.model.factory.factorymethod.demo02.IFruitFactory;
import com.citi.hz41382.java.model.factory.factorymethod.demo02.products.Strawberry;

/**
* <p>className: StrawberryFactory</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class StrawberryFactory implements IFruitFactory{
	private String variety;
	
	public StrawberryFactory(String variety){
		this.variety = variety;
	}

	@Override
	public IFruit createFruit() {
		Strawberry strawberry = new Strawberry();
		strawberry.setVariety(variety);
		return strawberry;
	}
	
	
}
