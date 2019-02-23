package com.citi.java8.optional;

import java.util.Optional;

import org.apache.log4j.Logger;

/**
* <p>className: OptionalInAction</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月22日
*/
public class OptionalInAction {
	static Logger logger = Logger.getLogger(OptionalInAction.class);
	
	public static void main(String[] args) {
		Optional.ofNullable(getInsuranceNameByOptional(null)).ifPresent(logger::info);
	}
	
	private static String getInsuranceNameByOptional(Person person) {
		return Optional.ofNullable(person)
                .flatMap(Person::getCar).flatMap(Car::getInsurance)
                .map(Insurance::getName).orElse("Unknown");
	}

}
