package org.zhouhy.java8.stream;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

/**
* <p>className: NumericStream</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月21日
*/
public class NumericStream {
	static Logger logger = Logger.getLogger(NumericStream.class);
	
	
	private NumericStream() {
		super();		
	}


	public static void main(String[] args) {
//		intSteam();
		intArrayTest1();
		
	}
	
	public static void intSteam(){
		ToIntFunction<Integer> t = a->a.intValue();
		Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		IntStream intStream = stream.mapToInt(t);
		intStream.forEach(logger::info);
	}
	
	//这里找到了两个数组
	public static void intArrayTest1(){
		int a = 9;
		IntPredicate predicate = b -> Math.sqrt(a * a + b * b) % 1 == 0;
		Function<Integer, int[]> mapper = b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)};
		Consumer<int[]> consumer = r -> logger.info("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]);
		IntStream.rangeClosed(1, 100).filter(predicate).boxed()
        .map(mapper) //这步得到的是一个int[]，所以下面的r应该是int[]
        .forEach(consumer);
	}
	
	public static void intArrayTest2(){
		int a = 9;
		IntPredicate predicate = b -> Math.sqrt(a * a + b * b) % 1 == 0;
		IntFunction<int[]> intFun = b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)};
		Consumer<int[]> consumer = r -> logger.info("a=" + r[0] + ",b=" + r[1] + ",c=" + r[2]);
		IntStream.rangeClosed(1, 100)
        .filter(predicate)
        .mapToObj(intFun)
        .forEach(consumer);
	}
}
