package com.citi.java8.collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;
import org.apache.log4j.Logger;
import com.citi.java8.stream.Dish;
import com.citi.java8.stream.Dish.Type;

/**
* <p>className: CollectorsTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月23日
*/
public class CollectorsTest {
	static Logger logger = Logger.getLogger(CollectorIntroduce.class);
	
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
		
//		testAveragingDouble(menu);
//		testAveragingInt(menu);
//		testAveragingLong(menu);
//		testCollectingAndThen(menu);
//		testCounting(menu);
//		testGroupingByFunction(menu);
//		testGroupingByFunctionAndCollector(menu);
//		testGroupingByFunctionAndSupplierAndCollector(menu);
//		testSummarizingInt(menu);
//		testGroupingByConcurrentWithFunction(menu);
//		testGroupingByConcurrentWithFunctionAndCollector(menu);
//		testGroupingByConcurrentWithFunctionAndSupplierAndCollector(menu);
//		testJoining(menu);
//		testJoiningWithDelimiter(menu);
//		testJoiningWithDelimiterAndPrefixAndSuffix(menu);
//		testMapping(menu);
//		testMaxBy(menu);
//		testMinBy(menu);
//		testPartitioningByWithPredicate(menu);
//		testPartitioningByWithPredicateAndCollector(menu);
//		testReducingBinaryOperator(menu);
//		testReducingBinaryOperatorAndIdentiy(menu);
//		testReducingBinaryOperatorAndIdentiyAndFunction(menu);
//		testSummarizingDouble(menu);
//		testSummingDouble(menu);
//		testSummingDouble(menu);
//		testToCollection(menu);
//		testToConcurrentMap(menu);
//		testToConcurrentMapWithBinaryOperator(menu);
//		testToConcurrentMapWithBinaryOperatorAndSupplier(menu);
//		testToList(menu);
//		testToSet(menu);
//		testToMap(menu);
		
	}
	
	private static void testAveragingDouble(List<Dish> menu) {
		ToDoubleFunction<Dish> mapper = (dish)-> dish.getCalories();
		double a = menu.stream().collect(Collectors.averagingDouble(mapper));
		Optional.ofNullable(a).ifPresent(logger::info);
	}

	private static void testAveragingInt(List<Dish> menu) {
		ToIntFunction<Dish> mapper = (dish)-> dish.getCalories();
		double a = menu.stream().collect(Collectors.averagingInt(mapper));
		Optional.ofNullable(a).ifPresent(logger::info);
	}
	
	private static void testAveragingLong(List<Dish> menu) {
		ToLongFunction<Dish> mapper = (dish)-> dish.getCalories();
		double a = menu.stream().collect(Collectors.averagingLong(mapper));
		Optional.ofNullable(a).ifPresent(logger::info);
	}
	
	private static void testCollectingAndThen(List<Dish> menu) {
		Collector<Dish,?,Double> downstream = Collectors.averagingInt(Dish::getCalories);
		Function<Double,String> finisher = a->"The Average Calories is->" + a;
		//先交给downstream处理，返回值交给finisher
		String str = menu.stream().collect(Collectors.collectingAndThen(downstream, finisher));
		Optional.ofNullable(str).ifPresent(logger::info);
		
		 List<Dish> list = menu.stream().filter(d -> d.getType().equals(Dish.Type.MEAT))
	                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
	        list.add(new Dish("", false, 100, Dish.Type.OTHER));
	        System.out.println(list);
	}
	
	private static void testCounting(List<Dish> menu) {
		Long aLong = menu.stream().collect(Collectors.counting());
		Optional.ofNullable(aLong).ifPresent(logger::info);
	}
	
	private static void testGroupingByFunction(List<Dish> menu) {
		Function<Dish,Type> classifier = dish -> dish.getType();
		Map<Type, List<Dish>> map = menu.stream().collect(Collectors.groupingBy(classifier));
		Optional.ofNullable(map).ifPresent(logger::info);
	}
	
	private static void testGroupingByFunctionAndCollector(List<Dish> menu) {
		Function<Dish,Type> classifier = dish -> dish.getType();
		Collector<Dish,?, Long> downstream = Collectors.counting();
		Map<Type, Long> map = menu.stream().collect(Collectors.groupingBy(classifier, downstream));
		Optional.ofNullable(map).ifPresent(logger::info);
	}
	
	
	private static void testGroupingByFunctionAndSupplierAndCollector(List<Dish> menu) {
		Function<Dish,Type> classifier = dish -> dish.getType();
		Collector<Dish,?, Long> downstream = Collectors.counting();
		Supplier<TreeMap<Type, Long>> mapFactory = TreeMap::new;
		TreeMap<Type, Long> map = menu.stream().collect(Collectors.groupingBy(classifier, mapFactory, downstream));
		Optional.ofNullable(map).ifPresent(logger::info);
	}
	
	private static void testSummarizingInt(List<Dish> menu) {
		ToIntFunction<Dish> mapper = dish -> dish.getCalories();		
		IntSummaryStatistics result = menu.stream().collect(Collectors.summarizingInt(mapper));		
		Optional.ofNullable(result).ifPresent(logger::info);
	}
	
	private static void testGroupingByConcurrentWithFunction(List<Dish> menu) {
		Function<Dish,Type> classifier = dish -> dish.getType();		
		ConcurrentMap<Type, List<Dish>> map = menu.stream().collect(Collectors.groupingByConcurrent(classifier));
		Optional.ofNullable(map.getClass()).ifPresent(logger::info);
        Optional.ofNullable(map).ifPresent(logger::info);
	}
	
	private static void testGroupingByConcurrentWithFunctionAndCollector(List<Dish> menu) {
		Function<Dish,Type> classifier = dish -> dish.getType();
		ToIntFunction<Dish> mapper = (dish)-> dish.getCalories();
		Collector<Dish,?, Double> downstream = Collectors.averagingInt(mapper);
		ConcurrentMap<Type, Double> map = menu.stream().collect(Collectors.groupingByConcurrent(classifier, downstream));
		Optional.ofNullable(map).ifPresent(logger::info);		
	}
	
	private static void testGroupingByConcurrentWithFunctionAndSupplierAndCollector(List<Dish> menu) {
		Function<Dish,Type> classifier = dish -> dish.getType();
		ToIntFunction<Dish> mapper = (dish)-> dish.getCalories();
		Collector<Dish,?, Double> downstream = Collectors.averagingInt(mapper);
		Supplier<ConcurrentSkipListMap<Type, Double>> mapFactory = ConcurrentSkipListMap::new;
		ConcurrentMap<Type, Double> map = menu.stream().collect(Collectors.groupingByConcurrent(classifier,mapFactory,downstream));
		Optional.of(map.getClass()).ifPresent(logger::info);
        Optional.ofNullable(map).ifPresent(logger::info);
	}
	
	private static void testJoining(List<Dish> menu) {		
		String str = menu.stream().map(Dish::getName).collect(Collectors.joining());
		Optional.ofNullable(str).ifPresent(logger::info);
	}
	
	private static void testJoiningWithDelimiter(List<Dish> menu) {
		String str = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
		Optional.ofNullable(str).ifPresent(logger::info);
	}
	
	//顺序是分隔符，前缀，后缀
	private static void testJoiningWithDelimiterAndPrefixAndSuffix(List<Dish> menu) {
		Optional.of(menu.stream().map(Dish::getName).collect(Collectors.joining(",", "Names[", "]")))
        .ifPresent(logger::info);
	}
	
	private static void testMapping(List<Dish> menu) {
		String str = menu.stream().collect(Collectors.mapping(Dish::getName, Collectors.joining(",")));
		Optional.ofNullable(str).ifPresent(logger::info);
	}
	
	private static void testMaxBy(List<Dish> menu) {
//		Comparator<Dish> comparator = Comparator.comparing(d->d.getCalories());
		Function<Dish, Integer> keyExtractor = d->d.getCalories();
		Comparator<Dish> comparator = Comparator.comparing(keyExtractor);
		Optional<Dish> optional = menu.stream().collect(Collectors.maxBy(comparator));
		optional.ifPresent(logger::info);
	}
	
	private static void testMinBy(List<Dish> menu) {
		Function<Dish, Integer> keyExtractor = d->d.getCalories();
		Comparator<Dish> comparator = Comparator.comparing(keyExtractor);
		Optional<Dish> optional = menu.stream().collect(Collectors.minBy(comparator));
		optional.ifPresent(logger::info);
	}
	
	/**
	 * 这个也是分组,分成两组
	 * */
	private static void testPartitioningByWithPredicate(List<Dish> menu) {
		Predicate<Dish> predicate = d->d.isVegetarian();
		Map<Boolean, List<Dish>> map = menu.stream().collect(Collectors.partitioningBy(predicate));
		Optional.ofNullable(map).ifPresent(logger::info);
	}
	
	private static void testPartitioningByWithPredicateAndCollector(List<Dish> menu) {
		Predicate<Dish> predicate = Dish::isVegetarian;
		Collector<Dish,?, Double> downstream = Collectors.averagingInt(Dish::getCalories);		
		Map<Boolean, Double> map = menu.stream().collect(Collectors.partitioningBy(predicate, downstream));
		Optional.ofNullable(map).ifPresent(logger::info);
	}
	
	//聚合,找到卡路里最大的那个
	private static void testReducingBinaryOperator(List<Dish> menu){
		BinaryOperator<Dish> op = BinaryOperator.maxBy(Comparator.comparingInt(Dish::getCalories));
		Optional<Dish> optional = menu.stream().collect(Collectors.reducing(op));
		optional.ifPresent(logger::info);
	}	
		
	private static void testReducingBinaryOperatorAndIdentiy(List<Dish> menu) {
		BinaryOperator<Integer> op = (d1,d2)->d1+d2;
		Integer result = menu.stream().map(Dish::getCalories).collect(Collectors.reducing(0, op));
		logger.info(result);
	}
	
	private static void testReducingBinaryOperatorAndIdentiyAndFunction(List<Dish> menu) {
		BinaryOperator<Integer> op = (d1,d2)->d1+d2;
		Function<Dish, Integer> mapper = Dish::getCalories;
		Integer result = menu.stream().collect(Collectors.reducing(0, mapper, op));
		logger.info(result);
	}
	
	private static void testSummarizingDouble(List<Dish> menu) {
		ToDoubleFunction<Dish> mapper = Dish::getCalories;
		DoubleSummaryStatistics sta = menu.stream().collect(Collectors.summarizingDouble(mapper));
		Optional.ofNullable(sta).ifPresent(logger::info);		
	}
	
	private static void testSummarizingLong(List<Dish> menu) {
        System.out.println("testSummarizingLong");
        Optional.of(menu.stream().collect(Collectors.summarizingLong(Dish::getCalories)))
                .ifPresent(System.out::println);
    }
	
	private static void testSummingDouble(List<Dish> menu) {
		ToDoubleFunction<Dish> mapper = Dish::getCalories;
		Double statistics = menu.stream().collect(Collectors.summingDouble(mapper));
		Optional.ofNullable(statistics).ifPresent(logger::info);
		
		Optional.of(menu.stream().map(Dish::getCalories).mapToInt(Integer::intValue).sum())
        .ifPresent(System.out::println);
	}	
	
	private static void testSummingLong(List<Dish> menu) {
		ToLongFunction<Dish> mapper = Dish::getCalories;
		Long statistics = menu.stream().collect(Collectors.summingLong(mapper));
		Optional.ofNullable(statistics).ifPresent(logger::info);
	}	
	
	private static void testSummingInt(List<Dish> menu) {
		ToIntFunction<Dish> mapper = Dish::getCalories;
		int statistics = menu.stream().collect(Collectors.summingInt(mapper));
		Optional.ofNullable(statistics).ifPresent(logger::info);
	}
	
	//产生一个ArrayList
	private static void testToCollection(List<Dish> menu) {
		Supplier<List<Dish>> collectionFactory = ArrayList::new;
		List<Dish> dishs = menu.stream().filter(d->d.getCalories()>600).collect(Collectors.toCollection(collectionFactory));
		Optional.ofNullable(dishs).ifPresent(logger::info);
	}
	
	
	private static void testToConcurrentMap(List<Dish> menu) {
		Function<Dish, String> keyMapper = Dish::getName;
		Function<Dish, Integer> valueMapper = Dish::getCalories;
		ConcurrentMap<String,Integer> map =  menu.stream().collect(Collectors.toConcurrentMap(keyMapper, valueMapper));
		Optional.ofNullable(map).ifPresent(v->{
			logger.info(v.getClass());
			logger.info(v);
		});
	}
	
	private static void testToConcurrentMapWithBinaryOperator(List<Dish> menu) {
		Function<Dish, Type> keyMapper = Dish::getType;
		Function<Dish, Long> valueMapper = v->1L; 
		BinaryOperator<Long> mergeFunction =(a,b)->a+b;
		ConcurrentMap<Type,Long> map = menu.stream().collect(Collectors.toConcurrentMap(keyMapper, valueMapper, mergeFunction));
		Optional.ofNullable(map).ifPresent(v->{
			logger.info(v.getClass());
			logger.info(v);
		});		
	}
	
	private static void testToConcurrentMapWithBinaryOperatorAndSupplier(List<Dish> menu) {
		Function<Dish, Type> keyMapper = Dish::getType;
		Function<Dish, Long> valueMapper = v->1L; 
		BinaryOperator<Long> mergeFunction =(a,b)->a+b;
		Supplier<ConcurrentSkipListMap> mapSupplier = ConcurrentSkipListMap::new;
		ConcurrentSkipListMap<Type,Long> map = menu.stream().collect(Collectors.toConcurrentMap(keyMapper, valueMapper, mergeFunction, mapSupplier));
		Optional.ofNullable(map).ifPresent(v->{
			logger.info(v.getClass());
			logger.info(v);
		});		
	}
	
	private static void testToList(List<Dish> menu) {		
		List<Dish> list = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
		Optional.ofNullable(list).ifPresent(v->{
			logger.info(v.getClass());
			logger.info(v);
		});	
	}	
	
	private static void testToSet(List<Dish> menu) {
		Set<Dish> list = menu.stream().filter(Dish::isVegetarian).collect(Collectors.toSet());
		Optional.ofNullable(list).ifPresent(v->{
			logger.info(v.getClass());
			logger.info(v);
		});	
	}
	
	private static void testToMap(List<Dish> menu) {
		Function<Dish, String> keyMapper = Dish::getName;
		Function<Dish, Integer> valueMapper = Dish::getCalories;
		Map<String,Integer> map =  menu.stream().collect(Collectors.toMap(keyMapper, valueMapper));
		Optional.ofNullable(map).ifPresent(v->{
			logger.info(v.getClass());
			logger.info(v);
		});
	}
	
}

