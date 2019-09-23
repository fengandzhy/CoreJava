package org.zhouhy.java8.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

/**
* <p>className: StreamReduce</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月20日
*/
public class StreamReduce {
	static Logger logger = Logger.getLogger(StreamReduce.class);
	
	public static void main(String[] args) {	
		sum();
		ifPresent();
		max();
		filter();
	}
	
	//reduce 的第一个参数是循环计算的初始值
	
	public static void sum(){
		BinaryOperator<Integer> accumulator = (i,j)->{return i+j;};
		Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		Integer result = stream.reduce(0, accumulator);
		logger.info(result);
	}
	
	public static void ifPresent(){
		BinaryOperator<Integer> accumulator = (i,j)->i+j;
		Consumer<Integer> consumer = logger::info;
		Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		stream.reduce(accumulator).ifPresent(consumer);
	}
	
	public static void max(){
		BinaryOperator<Integer> accumulator = (i,j)->Integer.max(i, j);
		Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		stream.reduce(accumulator).ifPresent(logger::info);
	}
	
	public static void filter(){
		BinaryOperator<Integer> accumulator = (i, j) -> i * j;
		Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		int result2 = stream.filter(i -> i % 2 == 0).reduce(1, accumulator);
		Optional.of(result2).ifPresent(logger::info);
	}
	
}
