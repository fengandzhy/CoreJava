package com.citi.hz41382.java.model.factory.abstractfactory;

import org.apache.log4j.Logger;

public class IntelCpu implements Cpu{

	private Logger logger = Logger.getLogger(IntelCpu.class);
	
	private int pins;
	
	public IntelCpu(int pins){
		this.pins=pins;
	}
	
	@Override
	public void calculate() {
		logger.info("Intel CPUµÄÕë½ÅÊý£º" + pins);
	}
}
