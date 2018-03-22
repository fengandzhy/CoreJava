package com.citi.hz41382.java.model.factory.abstractfactory;

public class IntelMainboard implements Mainboard {

	private int holes;
	
	public IntelMainboard(int holes){
		this.holes=holes;
	}
	
	@Override
	public void installCPU() {
		 System.out.println("Intel主板的CPU插槽孔数是：" + holes);
	}
}
