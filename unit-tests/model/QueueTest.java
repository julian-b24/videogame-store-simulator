package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datastructure.Queue;

class QueueTest {

	Queue<Integer> testQueue;
	public final static int NUM1 = 9;
	public final static int NUM2 = 7;
	
	@BeforeEach
	void setUp1Q() throws Exception {
	}
	
	void setUp2Q() throws Exception {
		testQueue = new Queue<>();
	}
	
	void setUp3Q() throws Exception {
		testQueue = new Queue<>();
		testQueue.enqueue(NUM2);
		testQueue.enqueue(NUM1);
	}

	@Test
	void testFront() throws Exception {
		setUp2Q();
		assertNull(testQueue.front());
		
		setUp3Q();
		assertEquals(testQueue.front(), NUM2);
	}

	@Test
	void testRear() throws Exception {
		setUp2Q();
		assertNull(testQueue.rear());
		
		setUp3Q();
		assertEquals(testQueue.rear(), NUM1);
	}

	@Test
	void testEnqueue() throws Exception {
		setUp2Q();
		int newVal = 15;
		testQueue.enqueue(newVal);
		assertEquals(testQueue.front(), newVal);
		assertEquals(testQueue.rear(), newVal);
		
		setUp3Q();
		testQueue.enqueue(newVal);
		assertEquals(testQueue.rear(), newVal);
	}

	@Test
	void testDequeue() throws Exception {
		setUp2Q();
		try {
			testQueue.dequeue();
			fail("failed");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
		
		setUp3Q();
		testQueue.dequeue();
		assertEquals(testQueue.front(), testQueue.rear());
		assertEquals(testQueue.front(), NUM1);
	}

	@Test
	void testIsEmpty() throws Exception {
		setUp2Q();
		assertTrue(testQueue.isEmpty());
		
		setUp3Q();
		assertFalse(testQueue.isEmpty());
	}

}
