package org.zhouhy.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

/**
* <p>className: TestMapAndFlatmap</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月31日
*/
public class TestMapAndFlatmap {
	
	static Logger logger = Logger.getLogger(TestMapAndFlatmap.class);
	
	public static void main(String[] args) {
		String[] strings = {"Hello", "World"};
		map(strings);		
	}
	
	/**
	 * List<Stream<String>> 里面就相当于有两个stream， 
	 * 一个stream相当于一个list， 那么此时就相当于两个list
	 * */
	public static void map(String[] strings){
		 Stream<String[]> stream = Arrays.asList(strings).stream().map(str -> str.split(""));
		 Stream<Stream<String>> streamStream = stream.map(strings1 -> Arrays.stream(strings1));
		 List<Stream<String>> streamList1 = streamStream.collect(Collectors.toList());
		 //streamList1.forEach(logger::info);
		 for(Stream<String> stm:streamList1){
			 stm.forEach(logger::info);
		 }
		 
		 new Thread(new Runnable(){
			 @Override
			 public void run(){
				 System.out.println("abc");
			 }
		 });
		 
		 new Thread(()->System.out.println("abc"));
	}
	
	public static void flatmap(String[] strings){
		Stream<String[]> stream1 = Arrays.asList(strings).stream().map(str -> str.split(""));
		Stream<String> stringStream = stream1.flatMap(strings1 -> Arrays.stream(strings1));
		List<String> stringList1 = stringStream.collect(Collectors.toList());
	}

}
