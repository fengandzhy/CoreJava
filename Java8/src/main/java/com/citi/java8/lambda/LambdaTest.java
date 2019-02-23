package com.citi.java8.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.apache.log4j.Logger;

import com.citi.java8.lambda.interfaces.Modifier;


/**
* <p>className: LambdaTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月19日
*/
public class LambdaTest {
	static Logger logger = Logger.getLogger(LambdaTest.class);
	public static void main(String[] args) {
		Comparator<Apple> byColor1 = new Comparator<Apple>() {
			public int compare(Apple o1, Apple o2) {
				return o1.getColor().compareTo(o2.getColor());
			}           
        };
        
        //lambda 代替匿名内部类
        Comparator<Apple> byColor2 = (o1, o2) -> o1.getColor().compareTo(o2.getColor());
        
        List<Apple> apples = new ArrayList<>();      
        
        apples.add(new Apple("red", 100.00));
        apples.add(new Apple("green", 120.00));
        
        for(Apple apple:apples){
        	System.out.println(apple);
        }
        
        apples.sort(byColor2);
        
        for(Apple apple:apples){
        	System.out.println(apple);
        }        

        Predicate<Apple> p = (Apple a) -> a.getColor().equals("green");
        lambdaTest1();
        lambdaTest2();
        lambdaTest3();
	}
	
	public static void lambdaTest1(){
		Function<String, Integer> flambda = s -> s.length();
		logger.info(flambda.apply("abc"));
	}
	
	public static void lambdaTest2(){
		Consumer<Apple> consumer = s -> {logger.info(s.getClass());
		logger.info(s.getWeight());};
		consumer.accept(new Apple("red", 100.00));	
	}
	
	public static void lambdaTest3(){
		Modifier<Apple,Integer,String> modifier = (a,b)->{
			return a.getColor()+b;
		};
		String str = modifier.modify(new Apple("red", 100.00), 10);
		logger.info(str);
	}

}
