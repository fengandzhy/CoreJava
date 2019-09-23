package org.zhouhy.hz41382.java.model.factory.factorymethod.demo02.products;

import org.apache.log4j.Logger;
import org.zhouhy.hz41382.java.model.factory.factorymethod.demo02.IFruit;

/**
* <p>className: Apple</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class Apple  implements IFruit{
	private static Logger logger = Logger.getLogger(Apple.class);
	private int treeAge;

	public int getTreeAge() {
		return treeAge;
	}

	public void setTreeAge(int treeAge) {
		this.treeAge = treeAge;
	}
	
	@Override
	public void plant(){
		logger.info("The apple is from a tree with the age of  "+treeAge);
	}
}
