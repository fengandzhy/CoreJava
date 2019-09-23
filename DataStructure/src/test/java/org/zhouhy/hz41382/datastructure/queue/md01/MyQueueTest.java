package org.zhouhy.hz41382.datastructure.queue.md01;

import static org.junit.Assert.*;

import org.junit.Test;

/**
* <p>className: MyQueueTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2018年10月6日
*/
public class MyQueueTest {

	MyQueue myQueue;
	
	@Test
	public void testInsert() {
		myQueue = new MyQueue(2);
		assertTrue(myQueue.insert(1));
		assertTrue(myQueue.insert(2));
		assertFalse(myQueue.insert(2));
	}
	@Test
	public void testRemove() {
		myQueue = new MyQueue(2);
		myQueue.insert(1);
		myQueue.insert(2);
		
		assertTrue(myQueue.remove());
		assertTrue(myQueue.remove());
		assertFalse(myQueue.remove());
	}
	
	@Test
	public void testInsert1() {
		myQueue = new MyQueue(2);
		assertTrue(myQueue.insert(1));
		assertTrue(myQueue.insert(2));
		myQueue.remove();
		assertTrue(myQueue.insert(3));
		int[] datas = myQueue.getDatas();
		assertEquals(2, datas[1]);
		assertEquals(3, datas[0]);
		myQueue.remove();
		assertTrue(myQueue.insert(4));
		assertEquals(4, datas[1]);
		assertEquals(3, datas[0]);
	}
	
	@Test
	public void testInsert2() {
		myQueue = new MyQueue(5);
		assertTrue(myQueue.insert(1));
		assertTrue(myQueue.insert(2));
		assertTrue(myQueue.insert(3));
		assertTrue(myQueue.insert(4));
		assertTrue(myQueue.insert(5));
		myQueue.remove();
		myQueue.remove();
		myQueue.remove();
		assertTrue(myQueue.insert(6));
		assertTrue(myQueue.insert(7));
		assertTrue(myQueue.insert(8));
		int[] datas = myQueue.getDatas();
		assertEquals(6, datas[0]);
		assertEquals(7, datas[1]);
		assertEquals(8, datas[2]);		
	}
}
