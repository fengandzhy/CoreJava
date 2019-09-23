package org.zhouhy.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

/**
* <p>className: StreamTest2</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月24日
*/
public class StreamTest2 {
	static Logger logger = Logger.getLogger(StreamTest2.class);
	
	public static void main(String[] args) {
		List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
		filter(menu);
		map(menu);

	}
	
	public static void filter(List<Dish> menu){
		Optional.ofNullable(menu.stream()
				.filter(m->m.getType().equals(Dish.Type.FISH))
				.collect(Collectors.toList())).ifPresent(logger::info);
	}
	
	public static void map(List<Dish> menu){
		Optional.ofNullable(menu.stream()
				.sorted(Comparator.comparing(Dish::getCalories))
				.map(Dish::getName)
				.collect(Collectors.toList())).ifPresent(logger::info);
		
	}

}
