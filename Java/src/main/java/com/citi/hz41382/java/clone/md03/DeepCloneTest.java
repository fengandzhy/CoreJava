package com.citi.hz41382.java.clone.md03;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
* <p>className: DeepCloneTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月31日
*/
public class DeepCloneTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DeepCloneTest.class);
	
	private DeepCloneTest(){
		
	}
	
	@Test
	public static void main(String[] args) {
		LOGGER.info("克隆之前：");
        Address address = new Address("中国", "吉林", "长春");
        Employee employee1 = new Employee("明日科技", 12, address);
        LOGGER.info("员工1的信息：");
        LOGGER.info(employee1.toString());
        LOGGER.info("克隆之后：");
        Employee employee2 = employee1.clone();
        employee2.getAddress().setState("中国");
        employee2.getAddress().setProvince("四川");
        employee2.getAddress().setCity("成都");
        employee2.setName("西南交通大学");
        employee2.setAge(114);
        LOGGER.info("员工2的信息：");
        LOGGER.info(employee2.toString());
        LOGGER.info("员工1的信息：");
        LOGGER.info(employee1.toString());
	}
	
}
