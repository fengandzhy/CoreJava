package org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.client;

import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.AbstractFactory;
import org.zhouhy.hz41382.java.model.factory.abstractfactory.demo02.factories.IntelFactory;

public class Client {
	private Client(){
		
	}
	
	public static void main(String[] args) {
		ComputerEngineer engineer = new ComputerEngineer();
		AbstractFactory factory = new IntelFactory();		
		engineer.makeComputer(factory);
	}
}
