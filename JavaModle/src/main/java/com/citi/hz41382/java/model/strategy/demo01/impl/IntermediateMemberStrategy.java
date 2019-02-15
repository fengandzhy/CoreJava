package com.citi.hz41382.java.model.strategy.demo01.impl;

import com.citi.hz41382.java.model.strategy.demo01.IMemberStrategy;

/**
* <p>className: IntermediateMemberStrategy</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月17日
*/
public class IntermediateMemberStrategy implements IMemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		
		System.out.println("对于中级会员的折扣为10%");
        return booksPrice * 0.9;
	}

}
