package com.citi.hz41382.java.model.factory.abstractfactory;

public class IntelFactory implements AbstractFactory {

	@Override
	public Cpu createCpu() {		
		return new IntelCpu(755);
	}

	@Override
	public Mainboard createMainboard() {		
		return new IntelMainboard(755);
	}

}
