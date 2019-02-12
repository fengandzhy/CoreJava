package com.citi.hz41382.java.model.factory.abstractfactory.demo01.products;

import org.apache.log4j.Logger;

import com.citi.hz41382.java.model.factory.abstractfactory.demo01.IFruit;

/**
* <p>className: TropicalFruit</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class TropicalFruit implements IFruit{
	
	private String name;
	private static Logger logger = Logger.getLogger(TropicalFruit.class);
	public TropicalFruit(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void plant(){
		logger.info("planting TropicalFruit name is "+name);
	}
}
