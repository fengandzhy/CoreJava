package com.citi.hz41382.java.scanner.md01;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.citi.hz41382.java.keyboardinput.md01.ScannerTest;

public class ScannerTester {

	private Scanner scn;

//	@Before
//	public void setUp() throws Exception {
//		// 模拟PersonDao对象
//	mockDao = mock(PersonDao.class);
//	when(mockDao.getPerson(1)).thenReturn(new Person(1, "Person1"));
//	when(mockDao.update(isA(Person.class))).thenReturn(true);
//
//	personService = new PersonService(mockDao);
//	}

	@Test
	public void testAddInput() {

		fail("Not yet implemented");

	}

	@Test
	public void testProcessInput() {
		
		
	}

	@Test
	public void testAddNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetResult() {
		fail("Not yet implemented");
	}

	@Test
	public void testProcessLargerThanOneThoundequal() {
		int number = 1000;
		int testLargeNumber = ScannerTest.processLargerThanOneThound(number);
		assertEquals(0,testLargeNumber);
	}

	@Test
	public void testProcessLargerThanOneThoundlarge() {
		int number = 1010;
		int testLargeNumber = ScannerTest.processLargerThanOneThound(number);
		assertEquals(0,testLargeNumber);
	}
	
	public void testProcessLargerThanOneThoundsmall() {
		int number = 25;
		int testLargeNumber = ScannerTest.processLargerThanOneThound(number);
		assertEquals(0,testLargeNumber);
	}
	
	@Test
	public void testProcessNegativeNumber() {
		int number = 2;
		int negativenumber = ScannerTest.processNegativeNumber(number);
		assertEquals(2,negativenumber);
		
		}
	
	@Test
	public void testProcessNegativeNumber1() {
		int number = -2;
		int negativenumber = ScannerTest.processNegativeNumber(number);
		assertEquals(0,negativenumber);
	
		}
	
}
