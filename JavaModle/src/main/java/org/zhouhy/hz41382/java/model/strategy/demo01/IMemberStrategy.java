package org.zhouhy.hz41382.java.model.strategy.demo01;
/**
* <p>className: MemberStrategy</p>
* <p>Description: 策略模式</p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月16日
*/
public interface IMemberStrategy {
	 /**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double calcPrice(double booksPrice);
}
