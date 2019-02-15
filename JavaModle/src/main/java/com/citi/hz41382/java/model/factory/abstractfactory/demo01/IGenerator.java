package com.citi.hz41382.java.model.factory.abstractfactory.demo01;
/**
* <p>className: Generator</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public interface IGenerator {
	
	public IFruit plantFruit(String name);
	
	public IVegetable plantVegetable(String name);
}
