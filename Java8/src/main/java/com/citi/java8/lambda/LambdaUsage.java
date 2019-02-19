package com.citi.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;

import org.apache.log4j.Logger;

import com.citi.java8.lambda.interfaces.AppleFilter;

/**
* <p>className: LambdaUsage</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月19日
*/
public class LambdaUsage {
	static Logger logger = Logger.getLogger(LambdaUsage.class);
	
	private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate) {
	    List<Apple> result = new ArrayList<>();
	    for (Apple a : source) {
	        if (predicate.test(a))
	            result.add(a);
	    }
	    return result;
	}
	
	//自定义的接口
	private static List<Apple> filterByAppleFilter(List<Apple> source, AppleFilter filter) {
		 List<Apple> result = new ArrayList<>();
		    for (Apple a : source) {
		        if (filter.filter(a))
		            result.add(a);
		    }
		    return result;
	}
	
	private static List<Apple> filterByBiPredicate(List<Apple> source, BiPredicate<String, Double> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : source) {
            if (predicate.test(a.getColor(), a.getWeight()))
                result.add(a);
        }
        return result;
    }
	
	
	private static void simpleTestConsumer(List<Apple> source, Consumer<Apple> consumer) {
        for (Apple a : source) {
            consumer.accept(a);            
        }
    }
	
	private static void simpleBiConsumer(List<Apple> source, BiConsumer<Apple, String> consumer) {
        for (Apple a : source) {
            consumer.accept(a, "abc:");
        }
    }
	
	private static String testFunction(Apple apple, Function<Apple, String> fun) {
        return fun.apply(apple);
    }
	
	private static Apple testBiFunction(String color, double weight, BiFunction<String, Double, Apple> fun) {
        return fun.apply(color, weight);
    }
	
	public static void main(String[] args) {
		List<Apple> apples = Arrays.asList(new Apple("green", 12.0), new Apple("red", 10.50),new Apple("yellow", 12.0));
		
		//相当于传了一个匿名内部类进去
		List<Apple> list1 = filter(apples,(apple) -> apple.getColor().equals("green"));
		logger.info(list1);
		
		//相当于传了一个匿名内部类进去
		List<Apple> list2 = filterByAppleFilter(apples,(apple) -> apple.getColor().equals("red"));
		logger.info(list2);
		
		List<Apple> list3 = filterByBiPredicate(apples,(w,c) -> w.equals("yellow")&&c>10.0);
		logger.info(list3);
		
		simpleTestConsumer(apples,a->System.out.print(a));
		
		//这里面的两个参数就相当于BiConsumer接口里面的accept方法里面的两个参数
		simpleBiConsumer(apples,(apple,color)-> logger.info(color + apple.getColor() + ":Weight=>" + apple.getWeight()));
		
		//(a)是apply方法里传的参数,a.toString()方法里实现的逻辑 
		String result = testFunction(new Apple("yellow", 100), (a) -> a.toString());
        logger.info(result);
        
        //这里的apply方法必须要用int类型，
        IntFunction<Apple> f = i -> {
        	Apple apple = new Apple("blue", i*2.5); 
        	return apple;};
        Apple apple = f.apply(8);
        logger.info(apple);
        
        Apple apple1 = testBiFunction("green",15.5, (color,weight)->{return new Apple(color,weight);});
        logger.info(apple1);
        
	}

}
