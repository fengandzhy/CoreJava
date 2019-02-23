package com.citi.java8.lambda.interfaces;
/**
* <p>className: Creator</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月24日
*/
@FunctionalInterface
public interface Creator<A,B,C,D> {
	D create(A a, B b, C c);
}
