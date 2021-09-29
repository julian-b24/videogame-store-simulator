package datastructure;

public class Stack<V extends Comparable<V>> implements IStack<V> {

	private ListNode<V> top;

	public Stack() {}

	public V top() {
		return top.getValue();
	}

	@Override
	public void push(V element) {
		ListNode<V> newListNode = new ListNode<V>(element);
		if(isEmpty()) {
			top = newListNode;
		}else {
			newListNode.setNext(top);
			top = newListNode;
		}
	}

	@Override
	public void pop() {
			top = top.getNext();
	}

	@Override
	public boolean isEmpty() {
		if(top == null) {
			return true;
		}else {
			return false;
		}
	}

}
