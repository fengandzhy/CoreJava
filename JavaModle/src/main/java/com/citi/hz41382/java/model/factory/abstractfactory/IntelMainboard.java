package com.citi.hz41382.java.model.factory.abstractfactory;

import org.apache.log4j.Logger;

public class IntelMainboard implements Mainboard {

	private Logger logger = Logger.getLogger(IntelMainboard.class);
	private int holes;
	
	public IntelMainboard(int holes){
		this.holes=holes;
	}
	
	@Override
	public void installCPU() {
		logger.info("Intel主板的CPU插槽孔数是：" + holes);
	}
}
