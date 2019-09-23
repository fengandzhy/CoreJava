package org.zhouhy.java8.collector;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
* <p>className: TestMySetCollector</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年5月5日
*/
public class TestMySetCollector {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("hello", "world", "hello", "welcome");
		Set<String> set = list.stream().collect(new MySetCollector<>());
        System.out.println("set = " + set);
	}
}
