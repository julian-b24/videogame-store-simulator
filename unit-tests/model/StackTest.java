package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datastructure.Stack;

class StackTest {
	Stack<Integer> testStackT;
	public final static int NUM1 = 9;
	public final static int NUM2 = 7;
	
	@BeforeEach
	void setUp1ST() throws Exception {
	}
	
	void setUp2ST() throws Exception {
		testStackT = new Stack<>();
	}
	
	void setUp3ST() throws Exception {
		testStackT = new Stack<>();
		testStackT.push(NUM1);
		testStackT.push(NUM2);
	}

	@Test
	void testTop() throws Exception {
		setUp1ST();
		try {
			testStackT.top();
			fail("Failed");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
		
		setUp2ST();
		try {
			testStackT.top();
			fail("Failed");
		} catch (NullPointerException e) {
			assertTrue(true);
		}

		setUp3ST();
		assertTrue(testStackT.top()==NUM2);
	}

	@Test
	void testPush() throws Exception {
		setUp2ST();
		int newVal = 8;
		testStackT.push(newVal);
		assertFalse(testStackT.isEmpty());
		assertTrue(testStackT.top() == newVal);
		
		setUp3ST();
		testStackT.push(newVal);
		assertTrue(testStackT.top() == newVal);
	}

	@Test
	void testPop() throws Exception {
		setUp2ST();
		try {
			testStackT.pop();
			fail("failed");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
		
		setUp3ST();
		testStackT.pop();
		assertEquals(testStackT.top(), NUM1);
	}

	@Test
	void testIsEmpty() throws Exception {
		setUp2ST();
		assertTrue(testStackT.isEmpty());
		
		setUp3ST();
		assertFalse(testStackT.isEmpty());
	}
}
