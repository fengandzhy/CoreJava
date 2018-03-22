package com.citi.hz41382.java.model.factory.abstractfactory;

public class AmdFactory implements AbstractFactory {

	@Override
	public Cpu createCpu() {		
		return new AmdCpu(985);
	}

	@Override
	public Mainboard createMainboard() {
		// TODO Auto-generated method stub
		return new AmdMainboard(985);
	}

}
