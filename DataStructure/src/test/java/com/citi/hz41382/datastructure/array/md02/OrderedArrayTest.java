package com.citi.hz41382.datastructure.array.md02;

import java.util.List;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

/**
* <p>className: OrderedArrayTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2018年10月3日
*/
public class OrderedArrayTest {

	OrderedArray orderedArray;
	
	@Before
	public void setUp() throws Exception {
		orderedArray = new OrderedArray(true);
	}
	@Test
	public void testInsertData3() {		
		Random random = new Random();
		for(int i=0;i<100;i++){
			int data = random.nextInt(100);			
			orderedArray.insertData(data);
		}
		orderedArray.printData();
		int data = 101;
		List<Integer> retList = orderedArray.findAllByBinarySearch(data);
		System.out.println(retList.size());
	}
	
}
