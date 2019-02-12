package com.citi.hz41382.java.model.factory.abstractfactory.demo01.factories;

import com.citi.hz41382.java.model.factory.abstractfactory.demo01.IFruit;
import com.citi.hz41382.java.model.factory.abstractfactory.demo01.IGenerator;
import com.citi.hz41382.java.model.factory.abstractfactory.demo01.IVegetable;
import com.citi.hz41382.java.model.factory.abstractfactory.demo01.products.NorthenFruit;
import com.citi.hz41382.java.model.factory.abstractfactory.demo01.products.NorthenVegetable;

/**
* <p>className: NorthenGarden</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class NorthenGarden implements IGenerator {

	@Override
	public IFruit plantFruit(String name) {		
		return new NorthenFruit(name);
	}

	@Override
	public IVegetable plantVegetable(String name) {
		return new NorthenVegetable(name);
	}

}
