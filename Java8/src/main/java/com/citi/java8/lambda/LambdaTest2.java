package com.citi.java8.lambda;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import org.apache.log4j.Logger;

import com.citi.java8.lambda.interfaces.Creator;

/**
* <p>className: LambdaTest2</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月24日
*/
public class LambdaTest2 {
	
	static Logger logger = Logger.getLogger(LambdaTest2.class);
	
	public static void main(String[] args) {
		Consumer<Apple> consumer = a->{logger.info(a);}; 
		Optional.ofNullable(testBiFunction("green",15.5, Apple::new)).ifPresent(consumer);
		Optional.ofNullable(createObj("A","B","C", Address::new)).ifPresent(logger::info);
		Optional.ofNullable(createObj("1","ww",createObj("A","B","C", Address::new), Person::new)).ifPresent(logger::info);		
	}
	
	private static Apple testBiFunction(String color, double weight, BiFunction<String, Double, Apple> fun) {
        return fun.apply(color, weight);
    }
	
	private static Address createAddress(String province, String city, String street, Creator<String,String,String,Address> creator){
		return  creator.create(province, city, street);
	}
	
	private static<A,B,C,D> D createObj(A province, B city, C street, Creator<A,B,C,D> creator){
		return  creator.create(province, city, street);
	}
	
}
