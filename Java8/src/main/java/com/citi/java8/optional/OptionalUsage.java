package com.citi.java8.optional;

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

	public static void createOptionalByOf(){
		//of里面传值不能为null
		Optional<Insurance> insuranceOptional = Optional.of(new Insurance());
		Insurance insurance = insuranceOptional.get();
		logger.info(insurance);
	}
	
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
