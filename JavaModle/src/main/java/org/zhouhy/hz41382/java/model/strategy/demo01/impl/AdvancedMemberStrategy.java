package org.zhouhy.hz41382.java.model.strategy.demo01.impl;

import org.zhouhy.hz41382.java.model.strategy.demo01.IMemberStrategy;

/**
* <p>className: AdvancedMemberStrategy</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月17日
*/
public class AdvancedMemberStrategy implements IMemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("对于高级会员的折扣为20%");
        return booksPrice * 0.8;
	}

}
