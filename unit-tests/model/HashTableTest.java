package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import datastructure.HashTable;

class HashTableTest {

	HashTable<Integer, Integer> hashTest;
	
	void setUp1HT() throws Exception {
	}
	
	void setUp2HT() throws Exception {
		hashTest = new HashTable<>();
	}
	
	void setUp3HT() throws Exception {
		hashTest = new HashTable<>();
		hashTest.add(232, 1);
	}
	
	@SuppressWarnings("static-access")
	void setUp4HT() throws Exception {
		hashTest = new HashTable<>();
		for (int i = 0; i < hashTest.MAX_SIZE; i++) {
			hashTest.add(i, i);
		}
	}

	@Test
	void testAdd() throws Exception {
		setUp2HT();
		hashTest.add(1, 5);
		assertTrue(hashTest.containsKey(1));
		assertTrue(hashTest.containsValue(5));
		
		setUp3HT();
		hashTest.add(1, 5);
		assertTrue(hashTest.containsKey(1));
		assertTrue(hashTest.containsValue(5));
		
		setUp3HT();
		try {
			hashTest.add(232, 500);
			fail("failed");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
		
		setUp4HT();
		try {
			hashTest.add(1, 500);
			fail("failed");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}

	@Test
	void testGet() throws Exception {
		setUp2HT();
		try {
			hashTest.get(1);
			fail("failed");
		} catch (Exception e) {
			assertTrue(true);
		}
		
		setUp3HT();
		assertEquals(hashTest.get(232), 1);
		
		setUp4HT();
		assertEquals(hashTest.get(232), 232);
	}

	
	@Test
	void testSet() throws Exception {
		setUp2HT();
		try {
			hashTest.set(1, 5);
			fail("failed");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
				
		setUp3HT();
		hashTest.set(232, 5);
		assertEquals(hashTest.get(232), 5);
		
		setUp4HT();
		hashTest.set(1, 500);
		assertEquals(hashTest.get(1), 500);
	}

	
	@Test
	void testContainsValue() throws Exception {
		setUp2HT();
		assertFalse(hashTest.containsValue(2));
		
		
		setUp3HT();
		assertTrue(hashTest.containsValue(1));
	}

	
	@Test
	void testContainsKey() throws Exception {
		setUp2HT();
		assertFalse(hashTest.containsKey(1));
		
		setUp3HT();
		assertTrue(hashTest.containsKey(232));
	}

}
