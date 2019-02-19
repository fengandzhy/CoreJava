package com.citi.java8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;


import org.apache.log4j.Logger;

import com.citi.java8.lambda.interfaces.StringSupplier;

/**
* <p>className: MethodReference</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月19日
*/
public class MethodReference {
	static Logger logger = Logger.getLogger(MethodReference.class);
	
	public static void main(String[] args) {
		useConsumer(s->logger.info(s),"hello world");	
		testStaticMethod();
		testMethod();
		testNew();
		List<Apple> list = Arrays.asList(new Apple("abc", 123), new Apple("Green", 110), new Apple("red", 123));
	
	}
	
	//这里的Integer.parseInt必须是静态方法
	public static void testStaticMethod(){		
		Function<String, Integer> f = Integer::parseInt;
		Integer a = f.apply("123");
		logger.info(a);
	}
	
	public static void testMethod(){
		String str = new String("Hello");
		Function<Integer, Character> fun = str::charAt;
		logger.info(fun.apply(3));
	}
	
	/**
	 * supplier是这个接口StringSupplier的实现类,
	 * 并且在这个实现类里面的get方法内容是new一个String对象
	 * 
	 * */
	public static void testNew(){
		StringSupplier<String> supplier = String::new;
		String s = supplier.get("abc");
		logger.info(s);
	}
	
	public static void testSort(List<Apple> list){
		
	}
	
	private static <T> void useConsumer(Consumer<T> consumer, T t) {
        consumer.accept(t);
        consumer.accept(t);
    }
	
}
