package com.citi.java8.lambda.interfaces;
/**
* <p>className: Modifier</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月24日
*/
@FunctionalInterface
public interface Modifier<A,B,C> {
	C modify(A a, B b);
}
