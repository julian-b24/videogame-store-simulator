package datastructure;

public class ListNode<V> extends Node<V> {

	private ListNode<V> next;

	private ListNode<V> previous;

	public ListNode(V value) {
		super(value);
	}

	public ListNode<V> getNext() {
		return next;
	}

	public void setNext(ListNode<V> next) {
		this.next = next;
	}

	public ListNode<V> getPrevious() {
		return previous;
	}

	public void setPrevious(ListNode<V> previous) {
		this.previous = previous;
	}

}
