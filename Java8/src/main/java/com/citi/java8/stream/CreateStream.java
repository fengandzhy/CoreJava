package com.citi.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

/**
* <p>className: CreateStream</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月20日
*/
public class CreateStream {
	static Logger logger = Logger.getLogger(CreateStream.class);
	
	public static void main(String args[]){
//		createStreamFromCollection().forEach(logger::info);		
//		createStreamFromIterator().forEach(logger::info);
//		createStreamFromValues().forEach(logger::info);
//		createStreamFromGenerate().forEach(logger::info);
		createObjStreamFromGenerate().forEach(logger::info);
	}
	
	private static Stream<String> createStreamFromCollection() {
        List<String> list = Arrays.asList("hello", "alex", "wangwenjun", "world", "stream");
        return list.stream();
    }
	
	private static Stream<String> createStreamFromValues() {
        return Stream.of("hello", "alex", "wangwenjun", "world", "stream");
    }
	
	private static Stream<Integer> createStreamFromIterator() {
		//传入以n返回一个n+2 UnaryOperator继承的一个Function<T,T>
		UnaryOperator<Integer> unaryOperator = n -> n+2;
        Stream<Integer> stream = Stream.iterate(0, unaryOperator).limit(10);
        return stream;
    }
	
	/**
	 * 创建stream一定要有supplier
	 * */
	private static Stream<Double> createStreamFromGenerate() {
		Supplier<Double> s = ()->{return Math.random();};
        return Stream.generate(s).limit(10);
    }

    private static Stream<Obj> createObjStreamFromGenerate() {
        return Stream.generate(new ObjSupplier()).limit(10);
    }
	

}
