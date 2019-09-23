package org.zhouhy.hz41382.java.model.factory.factorymethod.demo02.products;

import org.apache.log4j.Logger;
import org.zhouhy.hz41382.java.model.factory.factorymethod.demo02.IFruit;

/**
* <p>className: Strawberry</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class Strawberry  implements IFruit {
	private static Logger logger = Logger.getLogger(Strawberry.class);
	private String variety;

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}
	
	@Override
	public void plant(){
		logger.info("The Strawberry is   "+variety);
	}
}
