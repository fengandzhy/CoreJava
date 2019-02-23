package com.citi.java8.optional;

import java.util.Optional;

/**
* <p>className: Person</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月22日
*/
public class Person {
	private Optional<Car> car;
	
	public Optional<Car> getCar() {
        return this.car;
    }
	
}
