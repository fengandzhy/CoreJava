package com.citi.hz41382.java.thread.sh.md10;

public class Test {	
	public static void main(String[] args) {
		Restore re=new Restore();
		Producter pro=new Producter(re);
		Customer cus=new Customer(re);
		//pro.start();
		cus.start();
		pro.start();
	}

}
