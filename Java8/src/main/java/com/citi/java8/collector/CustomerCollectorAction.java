package com.citi.java8.collector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;

/**
* <p>className: CustomerCollectorAction</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月23日
*/
public class CustomerCollectorAction {

	public static void main(String[] args) {
		Collector<String, List<String>, List<String>> collector = new ToListCollector<>();

        String[] arrs = new String[]{"Alex", "Wang", "Hello", "Lambda", "Collector", "Java 8", "Stream"};

        List<String> result = Arrays.asList("Alex", "Wang", "Hello", "Lambda", "Collector", "Java 8", "Stream")
                .parallelStream()
                .filter(s -> s.length() >= 5)
                .collect(collector);

        System.out.println(result);

	}

}
