package com.citi.hz41382.java.clone.md01;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* <p>className: CloneTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2019年1月31日
* 假克隆109
*/
public class CloneTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(CloneTest.class);
	
	private CloneTest() {
		
	}

	@Test
	public static void main(String[] args) {
		LOGGER.info("克隆之前：");
        Employee employee1 = new Employee();
        employee1.setName("明日科技");
        employee1.setAge(12);
        LOGGER.info("员工1的信息：");
        LOGGER.info(employee1.toString());
        LOGGER.info("克隆之后：");
        Employee employee2 = employee1;
        employee2.setName("西南交通大学");
        employee2.setAge(114);
        LOGGER.info("员工2的信息：");
        LOGGER.info(employee2.toString());
        LOGGER.info("员工1的信息：");
        LOGGER.info(employee1.toString());
	}

}
