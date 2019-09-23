package org.zhouhy.hz41382.datastructure.stack.md01;

import static org.junit.Assert.*;

import org.junit.Test;

/**
* <p>className: MyStackTest</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2018年10月4日
*/
public class MyStackTest {

	MyStack myStack;
	@Test
	public void testPush() {
		myStack = new MyStack(1);
		assertTrue(myStack.push(2));
		assertFalse(myStack.push(3));
	}

	@Test
	public void testPop() {
		myStack = new MyStack(2);
		myStack.push(2);
		myStack.push(3);
		int data = myStack.pop();
		assertEquals(3, data);
		assertEquals(0, myStack.topIndex);
	}

	@Test
	public void testPeek() {
		myStack = new MyStack(2);
		myStack.push(2);
		myStack.push(3);
		int data = myStack.peek();
		assertEquals(3, data);
		assertEquals(1, myStack.topIndex);
	}

	@Test
	public void testIsEmpty() {
		myStack = new MyStack(2);
		assertTrue(myStack.isEmpty());
	}

	@Test
	public void testIsFull() {
		myStack = new MyStack(1);
		myStack.push(5);
		assertTrue(myStack.isFull());
	}

}
