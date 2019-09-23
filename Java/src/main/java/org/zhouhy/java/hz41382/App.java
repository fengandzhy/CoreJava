package org.zhouhy.java.hz41382;

import java.math.BigDecimal;

public class App {

	public static void main(String[] args) {
		BigDecimal aBigDecimal = new BigDecimal("10.21");
		BigDecimal bBigDecimal = new BigDecimal(10.21);
		
		System.out.println(aBigDecimal.compareTo(bBigDecimal));
	}

}
