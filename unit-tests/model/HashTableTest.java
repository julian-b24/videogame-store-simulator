package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import datastructure.HashTable;

class HashTableTest {

	HashTable<Integer, Integer> hashTest;
	
	@BeforeEach
	void setUp1HT() throws Exception {
	}
	
	void setUp2HT() throws Exception {
		hashTest = new HashTable<>();
	}
	
	void setUp3HT() throws Exception {
		hashTest = new HashTable<>();
		hashTest.add(1, 1);
	}
	
	void setUp4HT() throws Exception {
		hashTest = new HashTable<>();
		for (int i = 0; i < hashTest.MAX_SIZE; i++) {
			hashTest.add(i, i);
		}
	}

	@Test
	void testHashTable() throws Exception {
		setUp1HT();
		hashTest = new HashTable<>();
		assertNotNull(hashTest);
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
		hashTest.add(232, 500);
		assertTrue(hashTest.get(232) == 500);
		
		setUp4HT();
		hashTest.add(1, 500);
		assertTrue(hashTest.get(1) != 500);		
	}

	@Test
	void testGet() throws Exception {
		setUp2HT();
		assertNull(hashTest.get(1));
		
		setUp3HT();
		assertEquals(hashTest.get(232), 11);
		
		setUp4HT();
		assertEquals(hashTest.get(1), 1);	
	}

	@Test
	void testSet() throws Exception {
		setUp3HT();
		hashTest.set(232, 5);
		assertEquals(hashTest.get(232), 5);
		
		setUp4HT();
		hashTest.set(1, 500);
		assertEquals(hashTest.get(1), 500);
	}

	@Test
	void testDelete() throws Exception {
		setUp2HT();
		
		
		setUp3HT();
		

	}

	@Test
	void testContainsValue() throws Exception {
		setUp2HT();
		assertFalse(hashTest.containsValue(2));
		
		setUp3HT();
		assertTrue(hashTest.containsValue(11));
	}

	@Test
	void testContainsKey() throws Exception {
		setUp2HT();
		assertFalse(hashTest.containsKey(1));
		
		setUp3HT();
		assertTrue(hashTest.containsKey(232));
	}

}
