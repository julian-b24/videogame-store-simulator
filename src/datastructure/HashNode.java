package datastructure;

public class HashNode<K, V> extends Node<V>{

	private K key;

	public HashNode(K key, V value) {
		super(value);
		this.key = key;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

}
