package datastructure;

public interface IQueue<V extends Comparable<V>> {

	public V front();
	public V rear();
	public void enqueue(V value);
	public void dequeue();
	public boolean isEmpty();

}
