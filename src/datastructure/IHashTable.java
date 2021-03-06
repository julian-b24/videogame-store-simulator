package datastructure;

public interface IHashTable<K,V> {

	public void add(K key, V value);
	public V get(K key);
	public void set(K key, V value);
	public boolean containsValue(V value);
	public boolean containsKey(K key);
	public int hashFunction(K key);
}
