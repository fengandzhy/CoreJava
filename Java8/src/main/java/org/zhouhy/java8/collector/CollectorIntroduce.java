package org.zhouhy.java8.collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;

import org.zhouhy.java8.lambda.Apple;
import static java.util.stream.Collectors.groupingBy;


/**
* <p>className: CollectorIntroduce</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月23日
*/
public class CollectorIntroduce {
	static Logger logger = Logger.getLogger(CollectorIntroduce.class);
	
	public static void main(String[] args) {
		List<Apple> list = Arrays.asList(new Apple("green", 150)
                , new Apple("yellow", 120)
                , new Apple("green", 170)
                , new Apple("green", 150)
                , new Apple("yellow", 120)
                , new Apple("green", 170));
		Optional.ofNullable(groupByNormal(list)).ifPresent(logger::info);
		
		Optional.ofNullable(groupByFunction(list)).ifPresent(logger::info);
		
		Optional.ofNullable(groupByCollector(list)).ifPresent(logger::info);
	}
	
	private static Map<String, List<Apple>> groupByNormal(List<Apple> apples) {
		Map<String, List<Apple>> map = new HashMap<>();
		Iterator<Apple> iterator = apples.iterator();
		while(iterator.hasNext()){
			Apple apple = iterator.next();
			if(null!= map.get(apple.getColor())){
				map.get(apple.getColor()).add(apple);
			}else{
				List<Apple> app = new ArrayList<>();
				app.add(apple);
				map.put(apple.getColor(), app);
			}
		}
		return map;
	}
	
	private static Map<String, List<Apple>> groupByFunction(List<Apple> apples) {
		final Map<String, List<Apple>> map = new HashMap<>();
		apples.stream().forEach(apple->{
			List<Apple> colorList = Optional.ofNullable(map.get(apple.getColor())).orElseGet(()->{
				List<Apple> list = new ArrayList<>();
                map.put(apple.getColor(), list);
                return list;
			});
			colorList.add(apple);
		});
		return map;
	}
	
	private static Map<String, List<Apple>> groupByCollector(List<Apple> apples) {
        return apples.parallelStream().collect(groupingBy(Apple::getColor));
    }
}
