package org.zhouhy.java8.optional;

import java.util.Arrays;
import java.util.List;

/**
* <p>className: TestorElseAndorElseGet</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月31日
* 
* 可以发现，当Optonal的值是空值时，无论orElse还是orElseGet都会执行；
* 而当返回的Optional有值时，orElse会执行，而orElseGet不会执行。
*/
public class TestorElseAndorElseGet {

	public static void main(String[] args) {
		createList2();
	}
	
	public static void createList1(){
		List<Integer> list = Arrays.asList(10,20,30);
		int a =  list.stream().reduce(Integer::sum).orElse(get("a"));
        int b =  list.stream().reduce(Integer::sum).orElseGet(() -> get("b"));
        System.out.println("a  "+a);
        System.out.println("b  "+b);
	}
	
	public static void createList2(){
		List<Integer> list = Arrays.asList();
		int a =  list.stream().reduce(Integer::sum).orElse(get("a"));
        int b =  list.stream().reduce(Integer::sum).orElseGet(() -> get("b"));
        System.out.println("a  "+a);
        System.out.println("b  "+b);
	}
	
	public static int get(String name){
        System.out.println(name+"执行了方法");
        return 1;
    }

}
