package datastructure;

public abstract class Node<V> {

	private V value;

	public Node(V value) {
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
