package com.citi.hz41382.java.model.factory.abstractfactory;

import org.apache.log4j.Logger;

public class AmdCpu implements Cpu {

	private Logger logger = Logger.getLogger(AmdCpu.class);
	private int pins;
	
	public AmdCpu(int pins){
		this.pins=pins;
	}
	
	@Override
	public void calculate() {		
		logger.info("AMD CPUµÄÕë½ÅÊý£º" + pins);
	}

}
