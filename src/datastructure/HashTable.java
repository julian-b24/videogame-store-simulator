package datastructure;

public class HashTable<K,V> implements IHashTable<K, V>{

	public final static int MAX_SIZE = 200;
	
	private HashNode<K, V>[] table;
	
	public HashTable(){
		table = new HashNode[MAX_SIZE];
	}
	
	@Override
	public void add(K key, V value) {
		int hashCode = key.hashCode();
		int i = 0;
		boolean added = false;
		while(i < MAX_SIZE && !added) {
			int index = i + hashCode;
			if(table[index] == null) {
				table[index] = new HashNode<K, V>(key, value);
				added = true;
			}else {
				i++;
			}
		}
	}

	@Override
	public V get(K key) {
		int i = 0;
		V value = null;
		boolean founded = false;
		int hashCode = key.hashCode();
		
		while(i < MAX_SIZE && !founded) {
			int index = hashCode + i;
			if(table[index] != null && table[index].getKey().equals(key)) {
				founded = true;
				value = table[index].getValue();
			}else {
				i++;
			}
		}

		return value;
	}

	@Override
	public void delete(K key) {
		int i = 0;
		int hashCode = key.hashCode();
		boolean founded = false;
		while(i < MAX_SIZE && !founded) {
			int index = hashCode + i;
			if(table[index] == null && table[index].getKey().equals(key)) {
				founded = true;
				table[index] = null;
			}else {
				i++;
			}
		}
	}

	@Override
	public boolean contains(K key) {
		boolean contains = false;
		for (int i = 0; i < table.length && !contains; i++) {
			if(table[i] != null && table[i].getKey().equals(key)) {
				contains = true;
			}
		}
		return contains;
	}

}
