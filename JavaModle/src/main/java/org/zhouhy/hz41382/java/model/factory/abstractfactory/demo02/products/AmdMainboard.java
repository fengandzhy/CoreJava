package org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.products;

import org.apache.log4j.Logger;

import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.Mainboard;

public class AmdMainboard implements Mainboard{
	private Logger logger = Logger.getLogger(IntelCpu.class);
	private int holes;
	
	public AmdMainboard(int holes){
		this.holes = holes;
	}
	
	@Override
	public void installCPU() {
		logger.info("Amd主板的CPU插槽孔数是：" + holes);
	}
}
