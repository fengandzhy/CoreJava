package com.citi.hz41382.datastructure.array.md01;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
* <p>Title: abc</p>
* <p>Description: </p>
* <p>Company: Citi</p>
* @author hz41382
* @date 2018年10月3日
*/
public class ArrayRepeatableTest {

	ArrayRepeatable arrayRepeatable;
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testRemoveByData1() {
		arrayRepeatable = new ArrayRepeatable();
		arrayRepeatable.insertData(5);
		arrayRepeatable.insertData(4);
		arrayRepeatable.insertData(3);
		arrayRepeatable.insertData(2);
		arrayRepeatable.insertData(1);
		arrayRepeatable.insertData(6);		
		boolean flag = arrayRepeatable.removeByData(7);
		assertFalse(flag);
	}
	
	@Test
	public void testRemoveByData2() {
		arrayRepeatable = new ArrayRepeatable();
		arrayRepeatable.insertData(5);
		arrayRepeatable.insertData(4);
		arrayRepeatable.insertData(3);
		arrayRepeatable.insertData(2);
		arrayRepeatable.insertData(1);
		arrayRepeatable.insertData(6);
		assertEquals(10, arrayRepeatable.datas.length);
		boolean flag = arrayRepeatable.removeByData(6);
		assertTrue(flag);
		assertEquals(5, arrayRepeatable.datas.length);
	}
	
	@Test
	public void testRemoveByData3() {
		arrayRepeatable = new ArrayRepeatable();
		arrayRepeatable.insertData(5);
		arrayRepeatable.insertData(4);
		arrayRepeatable.insertData(3);
		arrayRepeatable.insertData(2);
		arrayRepeatable.insertData(1);
		arrayRepeatable.insertData(5);		
		boolean flag = arrayRepeatable.removeByData(5);	
		assertTrue(flag);
		assertEquals(3, arrayRepeatable.currentIndex);
		List<Integer> letList = arrayRepeatable.searchAll(5);
		assertTrue(letList.isEmpty());
	}
	
	@Test
	public void testfindAll1() {
		arrayRepeatable = new ArrayRepeatable();
		arrayRepeatable.insertData(5);
		arrayRepeatable.insertData(4);
		arrayRepeatable.insertData(3);
		arrayRepeatable.insertData(2);
		arrayRepeatable.insertData(1);
		arrayRepeatable.insertData(5);		
		List<Integer> letList = arrayRepeatable.searchAll(6);		
		assertTrue(letList.isEmpty());
	}
	
	@Test
	public void testfindAll2() {
		arrayRepeatable = new ArrayRepeatable();
		arrayRepeatable.insertData(5);
		arrayRepeatable.insertData(4);
		arrayRepeatable.insertData(3);
		arrayRepeatable.insertData(2);
		arrayRepeatable.insertData(1);
		arrayRepeatable.insertData(5);		
		List<Integer> letList = arrayRepeatable.searchAll(5);		
		assertEquals(2, letList.size());
	}

}
