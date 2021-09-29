package datastructure;

public class HashTable<K,V> implements IHashTable<K, V>{

	public final static int MAX_SIZE = 233;

	private HashNode<K, V>[] table;

	@SuppressWarnings("unchecked")
	public HashTable(){
		table = (HashNode<K, V>[]) new HashNode[MAX_SIZE];
	}

	@Override
	public void add(K key, V value) {
		int hashCode = hashFunction(key);
		int i = 0;
		boolean added = false;
		while(i < MAX_SIZE && !added) {
			int index = i + hashCode;
			try {
				if(table[index] == null) {
					table[index] = new HashNode<K, V>(key, value);
					added = true;
				}else {
					i++;
				}
			}catch(IndexOutOfBoundsException e){
				
			}
		}
	}

	@Override
	public V get(K key) {
		int i = 0;
		V value = null;
		boolean found = false;
		int hashCode = hashFunction(key);
		
		while(i < MAX_SIZE && !found) {
			int index = hashCode + i;
			if(table[index] != null && table[index].getKey().equals(key)) {
				found = true;
				value = table[index].getValue();
			}else {
				i++;
			}
		}

		return value;
	}

	@Override
	public void set(K key, V value) {
		int i = 0;
		boolean found = false;
		int hashCode = hashFunction(key);
		while(i < MAX_SIZE && !found) {
			int index = hashCode + i;
			if(table[index] != null && table[index].getKey().equals(key)) {
				found = true;
				table[index].setValue(value);
			}
			i++;
		}
	}

	@Override
	public boolean containsValue(V value) {
		boolean contains = false;
		int i = 0;
		while(i < MAX_SIZE && !contains) {
			if(table[i] != null && table[i].getValue().equals(value)) {
				contains = true;
			}
			i++;
		}
		return contains;
	}

	@Override
	public boolean containsKey(K key) {
		boolean contains = false;
		int hashCode = hashFunction(key);
		for (int i = hashCode; i < table.length && !contains; i++) {
			if(table[i] != null && table[i].getKey().equals(key)) {
				contains = true;
			}
		}
		return contains;
	}
	
	@Override
	public int hashFunction(K key) {
		int keyCode = key.hashCode();
		int hashCode = keyCode % MAX_SIZE;
		return hashCode;
	}

}
