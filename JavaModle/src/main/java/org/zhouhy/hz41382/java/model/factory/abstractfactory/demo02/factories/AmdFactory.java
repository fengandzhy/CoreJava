package org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.factories;

import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.AbstractFactory;
import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.Cpu;
import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.Mainboard;
import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.products.AmdCpu;
import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.products.AmdMainboard;

public class AmdFactory implements AbstractFactory {

	@Override
	public Cpu createCpu() {		
		return new AmdCpu(985);
	}

	@Override
	public Mainboard createMainboard() {
		return new AmdMainboard(985);
	}

}
