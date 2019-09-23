package org.zhouhy.hz41382.java.thread.sh.md03;

public class MoneyThread extends Thread{
	private Bank bank;
	
	public MoneyThread(Bank bank){
		this.bank = bank;
	}
	@Override
	public void run() {
		System.out.println(bank.getMoney(800));
	}
	
}
