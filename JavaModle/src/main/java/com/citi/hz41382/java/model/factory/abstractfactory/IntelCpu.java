package com.citi.hz41382.java.model.factory.abstractfactory;

public class IntelCpu implements Cpu{

	private int pins;
	
	public IntelCpu(int pins){
		this.pins=pins;
	}
	
	@Override
	public void calculate() {
		 System.out.println("Intel CPUµÄÕë½ÅÊı£º" + pins);
	}
}
