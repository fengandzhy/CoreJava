package com.citi.java8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static java.util.Comparator.comparing;
/**
* <p>className: StreamTest1</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月20日
*/
public class StreamTest {
	static Logger logger = Logger.getLogger(StreamTest.class);
	
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
		showStream();
		filterStream(menu);
		getDishNamesByStream(menu);
	}
	
	private static void filterStream(List<Dish> menu){		
		
		//务必记住，这里的d是Function里面的方法apply的参数
		Function<Dish, String> mapper = d-> {
			logger.info("map->" + d.getName());
			return d.getName();
		};
		
		//这里的predicate确实返回了一个boolean值,这个值将被用于stream里面的filter
		Predicate<Dish> predicate = d->{
			logger.info(d.getName());
			return d.getCalories()>300;
		};
		
		List<String> result = menu.stream().filter(predicate)
							 .map(mapper).collect(toList());
		logger.info(result);		
	}
	
	private static List<String> getDishNamesByStream(List<Dish> menu) {
		
		Predicate<Dish> predicate = d->{
			try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return d.getCalories() < 400;
		};
		
		//
		Function<Dish, Integer> keyExtractor = (d) -> {
			return d.getCalories();
		};
		
		Function<Dish, String> mapper = d-> {
			logger.info("map->" + d.getName());
			return d.getName();
		};
		
//		return menu.parallelStream().filter(predicate)
//				.sorted(comparing(Dish::getCalories)).map(Dish::getName).collect(toList());
		
		return menu.parallelStream().filter(predicate)
				.sorted(comparing(keyExtractor)).map(mapper).collect(toList());
	}
	
	public static void showStream(){
//		Consumer<Dish> consumer = d->{
//			System.out.println(d);
//		};
		Stream<Dish> dishStream = Stream.of(new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));
        dishStream.forEach(logger::info);
	}

}
