package datastructure;

public interface IStack<V extends Comparable<V>> {

	public V top();
	public void push(V value);
	public void pop();
	public boolean isEmpty();

}
