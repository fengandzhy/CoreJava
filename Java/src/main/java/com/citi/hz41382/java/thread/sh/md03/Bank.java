package com.citi.hz41382.java.thread.sh.md03;

public class Bank {
	private int money = 1000;
	public int getMoney(int number){
		if(number<0){
			return -1;
		}
		if(number>money){
			return -2;
		}
		if(money<0){
			return -3;
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		money -= number;
		return money;
	}
}
