package org.zhouhy.java8.lambda;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.log4j.Logger;

import org.zhouhy.java8.lambda.interfaces.Creator;

/**
* <p>className: LambdaTest2</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月24日
*/
public class LambdaTest2{
	
	static Logger logger = Logger.getLogger(LambdaTest2.class);
	
	public static void main(String[] args) {
		Consumer<Apple> consumer = a->{logger.info(a);}; 
		Optional.ofNullable(testBiFunction("green",15.5, Apple::new)).ifPresent(consumer);
		
		//Address::new 表示它是一个匿名的实现了Creator接口的实现类，但是在实现连create，它要用到new Address， 也就是Address的构造器
		Optional.ofNullable(createObj("A","B","C", Address::new)).ifPresent(logger::info);
		Optional.ofNullable(createObj("1","ww",createObj("A","B","C", Address::new), Person::new)).ifPresent(logger::info);		
	}
	
	private static Apple testBiFunction(String color, double weight, BiFunction<String, Double, Apple> fun) {
        return fun.apply(color, weight);
    }
	
	//这里将会传进来一个实现了Creator的实现类的实例
	private static<A,B,C,D> D createObj(A province, B city, C street, Creator<A,B,C,D> creator){
		return  creator.create(province, city, street);
	}
	
}
