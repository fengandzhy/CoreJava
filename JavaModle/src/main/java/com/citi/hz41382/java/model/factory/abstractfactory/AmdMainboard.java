package com.citi.hz41382.java.model.factory.abstractfactory;

public class AmdMainboard implements Mainboard{

	private int holes;
	
	public AmdMainboard(int holes){
		this.holes = holes;
	}
	
	@Override
	public void installCPU() {
		System.out.println("AMD主板的CPU插槽孔数是：" + holes);		
	}
}
