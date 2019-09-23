package org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.factories;

import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.AbstractFactory;
import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.Cpu;
import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.Mainboard;
import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.products.IntelCpu;
import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.products.IntelMainboard;

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
