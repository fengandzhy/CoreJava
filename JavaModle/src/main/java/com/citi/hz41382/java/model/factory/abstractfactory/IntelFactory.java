package com.citi.hz41382.java.model.factory.abstractfactory;

public class IntelFactory implements AbstractFactory {

	@Override
	public Cpu createCpu() {
		// TODO Auto-generated method stub
		return new IntelCpu(755);
	}

	@Override
	public Mainboard createMainboard() {
		// TODO Auto-generated method stub
		return new IntelMainboard(755);
	}

}
