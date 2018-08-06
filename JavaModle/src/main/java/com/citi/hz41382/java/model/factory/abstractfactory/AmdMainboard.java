package com.citi.hz41382.java.model.factory.abstractfactory;

import org.apache.log4j.Logger;

public class AmdMainboard implements Mainboard{
	private Logger logger = Logger.getLogger(IntelCpu.class);
	private int holes;
	
	public AmdMainboard(int holes){
		this.holes = holes;
	}
	
	@Override
	public void installCPU() {
		logger.info("Intel CPUµÄÕë½ÅÊý£º" + holes);
	}
}
