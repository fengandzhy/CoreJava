package com.citi.hz41382.java.model.strategy.demo01.test;

import com.citi.hz41382.java.model.strategy.demo01.IMemberStrategy;
import com.citi.hz41382.java.model.strategy.demo01.context.Price;
import com.citi.hz41382.java.model.strategy.demo01.impl.AdvancedMemberStrategy;

/**
* <p>className: Client</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月17日
* Client是计算图书价格的消费类，但是它不直接去调用计算图书价格的类，而是通过这个Price中间商
* 代理去调用，它给Price注入的是要告诉Price究竟要调用哪个类来计算图书。
*/
public class StrategyClient {

	private StrategyClient(){
		
	}
	
	public static void main(String[] args) {
		IMemberStrategy strategy = new AdvancedMemberStrategy();
		
		Price price = new Price();
		price.setStrategy(strategy);
		
		double quote = price.quote(300);
		System.out.println("图书的最终价格为：" + quote);
	}

}
