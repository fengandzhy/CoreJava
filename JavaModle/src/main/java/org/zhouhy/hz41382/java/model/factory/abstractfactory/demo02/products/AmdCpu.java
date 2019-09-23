package org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.products;

import org.apache.log4j.Logger;

import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.Cpu;

public class AmdCpu implements Cpu {

	private Logger logger = Logger.getLogger(AmdCpu.class);
	private int pins;
	
	public AmdCpu(int pins){
		this.pins=pins;
	}
	
	@Override
	public void calculate() {		
		logger.info("AMD CPU的针脚数" + pins);
	}

}
