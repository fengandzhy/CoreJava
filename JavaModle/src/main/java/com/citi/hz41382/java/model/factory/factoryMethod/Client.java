package com.citi.hz41382.java.model.factory.factoryMethod;

public class Client {

	public static void main(String[] args) {
		
		Factory factory1 = new ConcreteFactory1();
		Product product1 = factory1.createProduct();
		product1.print();
		
		Factory factory2 = new ConcreteFactory2();
		Product product2 = factory2.createProduct();
		product2.print();

	}

}
