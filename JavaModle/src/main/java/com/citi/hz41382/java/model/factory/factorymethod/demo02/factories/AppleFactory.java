package com.citi.hz41382.java.model.factory.factorymethod.demo02.factories;

import com.citi.hz41382.java.model.factory.factorymethod.demo02.IFruit;
import com.citi.hz41382.java.model.factory.factorymethod.demo02.IFruitFactory;
import com.citi.hz41382.java.model.factory.factorymethod.demo02.products.Apple;

/**
* <p>className: AppleFactory</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class AppleFactory implements IFruitFactory {
	
	private int treeAge;
	
	public AppleFactory(int treeAge){
		this.treeAge = treeAge;
	}
	
	@Override
	public IFruit createFruit() {
		Apple apple = new Apple();
		apple.setTreeAge(treeAge);
		return apple;
	}

}
