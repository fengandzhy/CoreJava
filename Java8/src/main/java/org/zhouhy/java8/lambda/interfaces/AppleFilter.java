package org.zhouhy.java8.lambda.interfaces;

import org.zhouhy.java8.lambda.Apple;

/**
* <p>className: AppleFilter</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月19日
*/

@FunctionalInterface
public interface AppleFilter {	
	public boolean filter(Apple apple);
}
