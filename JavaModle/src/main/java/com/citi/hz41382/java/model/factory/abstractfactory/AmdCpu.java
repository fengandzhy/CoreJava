package com.citi.hz41382.java.model.factory.abstractfactory;

public class AmdCpu implements Cpu {

	private int pins;
	
	public AmdCpu(int pins){
		this.pins=pins;
	}
	
	@Override
	public void calculate() {
		
		
		System.out.println("AMD CPUµÄÕë½ÅÊı£º" + pins);

	}

}
