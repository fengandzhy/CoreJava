package org.zhouhy.java8.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

/**
* <p>className: StreamFind</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月21日
*/
public class StreamFind {
	static Logger logger = Logger.getLogger(StreamFind.class);
	
	private StreamFind() {
		super();		
	}

	public static void main(String[] args) {
		findAny();
		findFirst();
		orElse();
	}
	
	/**
	 * 返回其中之一
	 * */
	public static void findAny(){
		Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		Optional<Integer> optional1 = stream.filter(i -> i % 2 == 0).findAny();
		logger.info(optional1.get());
		close(stream);
	}
	
	public static void findFirst(){
		Consumer<Integer> consumer = logger::info;
		Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		Optional<Integer> optional1 = stream.filter(i -> i % 2 == 0).findFirst();
		optional1.ifPresent(consumer);
		close(stream);
	}
	
	/**
	 * 如果没有就返回-1
	 * */
	public static void orElse(){
		Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		Optional<Integer> optional1 = stream.filter(i -> i>10).findFirst();
		logger.info(optional1.orElse(-1));
		close(stream);
	}
	
	public static <Y> void close(Stream<Y> stream){
		if(stream!=null){
			stream.close();
		}		
	}
}
