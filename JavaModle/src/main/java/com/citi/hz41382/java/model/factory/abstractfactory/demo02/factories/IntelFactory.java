package com.citi.hz41382.java.model.factory.abstractfactory.demo02.factories;

import com.citi.hz41382.java.model.factory.abstractfactory.demo02.AbstractFactory;
import com.citi.hz41382.java.model.factory.abstractfactory.demo02.Cpu;
import com.citi.hz41382.java.model.factory.abstractfactory.demo02.Mainboard;
import com.citi.hz41382.java.model.factory.abstractfactory.demo02.products.IntelCpu;
import com.citi.hz41382.java.model.factory.abstractfactory.demo02.products.IntelMainboard;

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
