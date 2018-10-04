package com.citi.hz41382.datastructure.array.md03;

import java.util.Random;
import org.junit.Test;

/**
* <p>className: BubbleSortTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2018年10月4日
*/
public class BubbleSortTest {

	BubbleSort bubbleSort;
	
	@Test
	public void testBubbleSortAsc() {
		bubbleSort = new BubbleSort();
		Random random = new Random();
		int[] array = new int[100];
		for(int i=0;i<100;i++){
			int data = random.nextInt(100);			
			array[i] = data;
		}
		bubbleSort.bubbleSortAsc(array);
		bubbleSort.printData(array);
	}
	
	@Test
	public void testBubbleSortDesc() {
		bubbleSort = new BubbleSort();
		Random random = new Random();
		int[] array = new int[100];
		for(int i=0;i<100;i++){
			int data = random.nextInt(100);			
			array[i] = data;
		}
		bubbleSort.bubbleSortDesc(array);
		bubbleSort.printData(array);
	}
	
	@Test
	public void testBubbleSortAsc2() {
		bubbleSort = new BubbleSort();
		Random random = new Random();
		int[] array = new int[100];
		for(int i=0;i<100;i++){
			int data = random.nextInt(100);			
			array[i] = data;
		}
		bubbleSort.bubbleSortAsc2(array);
		bubbleSort.printData(array);
	}

}
