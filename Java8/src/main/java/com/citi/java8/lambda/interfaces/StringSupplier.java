package com.citi.java8.lambda.interfaces;
/**
* <p>className: StringSupplier</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月19日
*/

@FunctionalInterface
public interface StringSupplier<T> {
	T get(T t);
}
