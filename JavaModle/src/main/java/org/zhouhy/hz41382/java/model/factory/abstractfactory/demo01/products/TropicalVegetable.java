package org.zhouhy.hz41382.java.model.factory.abstractfactory.demo01.products;

import org.apache.log4j.Logger;

import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo01.IVegetable;

/**
* <p>className: TropicalVegetable</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class TropicalVegetable implements IVegetable {
	private String name;
	private static Logger logger = Logger.getLogger(TropicalVegetable.class);
	public TropicalVegetable(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void plant(){
		logger.info("planting TropicalVegetable name is "+name);
	}
}
