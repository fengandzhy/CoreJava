package com.citi.java8.stream;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

/**
* <p>className: StreamMatch</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月21日
*/
public class StreamMatch {
	static Logger logger = Logger.getLogger(StreamMatch.class);
	
	
	
	private StreamMatch() {
		super();		
	}

	public static void main(String[] args){
		allMatch();
		anyMatch();
		noneMatch();
	}
	
	/**
	 * 所有的都match才true
	 * */
	public static void allMatch(){
		Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});		
		Predicate<Integer> p1 = i -> i > 10;
		boolean matched = stream.allMatch(p1);
		logger.info(matched);
		stream.close();
	}
	
	/**
	 * 只有一个match就true
	 * */
	public static void anyMatch(){
		Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});		
		Predicate<Integer> p1 = i -> i > 10;
		boolean matched = stream.anyMatch(p1);
		logger.info(matched);
		stream.close();
	}
	
	/**
	 * 没有一个满足返回true
	 * */
	public static void noneMatch(){
		Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});	
		Predicate<Integer> p1 = i -> i > 10;
		boolean matched = stream.noneMatch(p1);
		logger.info(matched);
		stream.close();
	}
}
