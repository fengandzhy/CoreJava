package com.citi.hz41382.java.model.strategy.demo01.context;

import com.citi.hz41382.java.model.strategy.demo01.IMemberStrategy;

/**
* <p>className: Price</p>
* <p>Description: 这个类是计算图书的类，但是 究竟哪个strategy计算，就看给它注入哪个</p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月17日
* 
*/
public class Price {
	private IMemberStrategy strategy;
	
	public Price(IMemberStrategy strategy){
		this.strategy = strategy;
	}
	
	public Price(){
		// empty constructor
	}
	
	/**
     * 计算图书的价格
     * @param booksPrice    图书的原价
     * @return    计算出打折后的价格
     */
    public double quote(double booksPrice){
        return this.strategy.calcPrice(booksPrice);
    }

	public IMemberStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(IMemberStrategy strategy) {
		this.strategy = strategy;
	}	
}
