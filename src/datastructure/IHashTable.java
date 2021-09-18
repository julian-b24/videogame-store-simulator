package datastructure;

public interface IHashTable<K,V> {

	public void add(K key, V Value);
	public V get(K key);
	public void delete(K key);
	public boolean contains(K key);
}
