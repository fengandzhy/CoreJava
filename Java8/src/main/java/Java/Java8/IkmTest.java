package Java.Java8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import javax.security.auth.x500.X500Principal;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
* <p>className: Test2</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年3月31日
*/
public class IkmTest {
	int data;
	public IkmTest(){
		this(10);
	}
	public IkmTest(int data){
		this.data = data;
	}
	
	void display(){
		System.out.println("data="+data);
	}
	
	class Decrementer{
		public void decrement(double data){
			data = data -1.0;
		}
	}
	
	public static void main(String[] args) {
		int data =0;
		IkmTest test = new IkmTest(data);
		IkmTest.Decrementer d = test.new Decrementer();
		d.decrement(data);
		test.display();
		
////		Supplier<String> i = ()->"Car";
////		Consumer<String> c = x->System.out.print(x.toLowerCase());
////		Consumer<String> d = x->System.out.print(x.toUpperCase());
////		c.andThen(d).accept(i.get());
////		System.out.println();
//		
////		Map<Integer, Integer> countMap = new HashMap<>();
////		Integer key =5;
////		Integer value = key;
////		countMap.put(key++, value);
////		countMap.put(300, 300);
////		int count =0;
////		for(Integer i :countMap.keySet()){
////			for(Integer j:countMap.values()){
////				count++;
////				if(i==countMap.get(i)){
////					break;
////				}else{
////					continue;
////				}
////			}
////		}
////		System.out.println("Count"+count);
//		
//		Runnable r = ()->System.out.println("HI");
//		new Thread(r).start();
		
		
	}
	
	public static void main() {
		System.out.println("main 2");
	}
}
