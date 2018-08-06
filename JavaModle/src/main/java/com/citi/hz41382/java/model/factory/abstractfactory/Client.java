package com.citi.hz41382.java.model.factory.abstractfactory;

public class Client {
	private Client(){
		
	}
	
	public static void main(String[] args) {
		ComputerEngineer engineer = new ComputerEngineer();
		AbstractFactory factory = new IntelFactory();		
		engineer.makeComputer(factory);
	}
}
