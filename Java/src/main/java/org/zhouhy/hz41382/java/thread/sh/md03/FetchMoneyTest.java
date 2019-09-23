package org.zhouhy.hz41382.java.thread.sh.md03;

public class FetchMoneyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bank bank = new Bank();

        Thread t1 = new MoneyThread(bank);// ������ȡǮ
        Thread t2 = new MoneyThread(bank);// ��ȡ���ȡǮ

        t1.start();
        t2.start();
	}

}
