package datastructure;

public class HashNode<K, V> extends Node<V>{

	private K key;
	private boolean deleted;

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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
