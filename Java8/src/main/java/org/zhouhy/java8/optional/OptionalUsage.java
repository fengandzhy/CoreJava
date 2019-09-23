package org.zhouhy.java8.optional;

import java.util.Optional;

import org.apache.log4j.Logger;

/**
* <p>className: OptionalUsage</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年2月22日
*/
public class OptionalUsage {
	
	static Logger logger = Logger.getLogger(OptionalUsage.class);
	
	public static void main(String[] args) {
//		createOptionalByEmpty();
//		createOptionalByOf();
//		Map();
		isPresent();
		
		
	}
	
	public static void createOptionalByEmpty(){
		Optional<Insurance> insuranceOptional = Optional.<Insurance>empty();
//		Insurance insurance = insuranceOptional.get();//这里会抛出异常
	}

	/**
	 * Optional.of(obj): 它要求传入的 obj 不能是 null 值的, 否则还没开始进入角色就倒在了 NullPointerException 异常上了.
	 * */
	public static void createOptionalByOf(){
		//of里面传值不能为null
		Optional<Insurance> insuranceOptional = Optional.of(new Insurance());
		Insurance insurance = insuranceOptional.get();
		logger.info(insurance);
	}
	
	/**
	 * Optional.ofNullable(obj): 它以一种智能的, 宽容的方式来构造一个 Optional 实例. 来者不拒, 
	 * 传 null 进到就得到 Optional.empty(), 非 null 就调用 Optional.of(obj).
	 * */
	public static void createOptionalByOfNullable(){
		Optional<Insurance> objectOptional = Optional.ofNullable(null);
		//里面有值就返回值，里面没有值就返回一个新建的insurance
		objectOptional.orElseGet(Insurance::new);		
		objectOptional.orElse(new Insurance());
		objectOptional.orElseThrow(() -> new RuntimeException("Not have reference"));
		
	}
	
	public static void Filter(){
		Optional<Insurance> insuranceOptional = Optional.of(new Insurance());
		Insurance insurance = insuranceOptional.filter(i->i.getName()==null).get();
		logger.info(insurance);
	}
	
	public static void Map(){
		Optional<Insurance> insuranceOptional = Optional.of(new Insurance());
		
		//此时i.getName()返回的是null
		Optional<String> nameOptional = insuranceOptional.map(i -> i.getName());
		logger.info(nameOptional.orElse("unknown"));
	}
	
	public static void isPresent(){
		Optional<Insurance> insuranceOptional = Optional.of(new Insurance());
		Optional<String> nameOptional = insuranceOptional.map(i -> i.getName());
		logger.info(nameOptional.isPresent());
	}
	
	
}
