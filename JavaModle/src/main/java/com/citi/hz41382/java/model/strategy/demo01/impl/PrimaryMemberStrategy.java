package com.citi.hz41382.java.model.strategy.demo01.impl;

import com.citi.hz41382.java.model.strategy.demo01.IMemberStrategy;

/**
* <p>className: PrimaryMemberStrategy</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月17日
*/
public class PrimaryMemberStrategy implements IMemberStrategy{

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("对于初级会员的没有折扣");
        return booksPrice;
	}
	
}
