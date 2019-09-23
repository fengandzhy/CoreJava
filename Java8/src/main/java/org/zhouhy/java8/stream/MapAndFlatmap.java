package org.zhouhy.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
* <p>className: MapAndFlatmap</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年5月17日
*/
public class MapAndFlatmap {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("welcome java8","hello world");

		List<String> list2 = Arrays.asList("hello", "hi", "你好");
        List<String> list3 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");
        map(list);
        //map1(list2,list3);
        
	}
	
	public static void map(List<String> list){
		Stream<Stream<String>> stream = list.stream().map(item->Arrays.stream(item.split(" ")));
	}
	
	public static void flatmap(List<String> list){
		Stream<String> stream = list.stream().flatMap(item->Arrays.stream(item.split(" ")));
	}
	
	public static void map1(List<String> list2,List<String> list3){
		Stream<Stream<String>> stream = list2.stream().map(item-> list3.stream().map(item2 -> item + " " + item2));
	}
	
	public static void flatmap1(List<String> list2,List<String> list3){
		Stream<String> stream = list2.stream().flatMap(item->list3.stream().map(item2 -> item+" "+item2));
	}
}
