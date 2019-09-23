package org.zhouhy.hz41382.datastructure.array.md03;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
* <p>className: InsertSortTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2018年10月4日
*/
public class InsertSortTest {

	InsertSort insertSort;
	@Test
	public void testInsertSortAsc() {
		insertSort = new InsertSort();
		Random random = new Random();
		int[] array = new int[100];
		for(int i=0;i<100;i++){
			int data = random.nextInt(100);			
			array[i] = data;
		}
		insertSort.insertSortAsc(array);
		insertSort.printData(array);
	}

}
