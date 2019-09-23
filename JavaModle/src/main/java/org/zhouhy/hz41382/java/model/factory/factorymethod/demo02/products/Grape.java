package org.zhouhy.hz41382.java.model.factory.factorymethod.demo02.products;

import org.apache.log4j.Logger;

import org.zhouhy.hz41382.java.model.common.CommonUtil;
import org.zhouhy.hz41382.java.model.factory.factorymethod.demo02.IFruit;

/**
* <p>className: Grape</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月18日
*/
public class Grape  implements IFruit {
	private static Logger logger = Logger.getLogger(Grape.class);
	private boolean seedless;

	public boolean isSeedless() {
		return seedless;
	}

	public void setSeedless(boolean seedless) {
		this.seedless = seedless;
	}
	
	@Override
	public void plant(){
		logger.info("The Grape is   "+CommonUtil.transferBoolean(seedless)+"seedless");
	}
}
