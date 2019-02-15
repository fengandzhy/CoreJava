package com.citi.hz41382.java.model.factory.abstractfactory.demo02.client;

import com.citi.hz41382.java.model.factory.abstractfactory.demo02.AbstractFactory;
import com.citi.hz41382.java.model.factory.abstractfactory.demo02.Cpu;
import com.citi.hz41382.java.model.factory.abstractfactory.demo02.Mainboard;

public class ComputerEngineer {
	private Cpu cpu;
	private Mainboard mainboard;
	
	public void makeComputer(AbstractFactory factory){
		this.cpu = factory.createCpu();
		this.mainboard = factory.createMainboard();
		
		this.cpu.calculate();
		this.mainboard.installCPU();
	}	 
}
