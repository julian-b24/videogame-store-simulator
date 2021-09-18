package datastructure;

public class Queue<V extends Comparable<V>> implements IQueue<V> {

	private ListNode<V> front;
	private ListNode<V> rear;

	@Override
	public V front() {
		return front.getValue();
	}

	@Override
	public V rear() {
		return rear.getValue();
	}

	@Override
	public void enqueue(V element) {
		ListNode<V> newListNode = new ListNode<V>(element);
		if(isEmpty()) {
			front = newListNode;
			rear = newListNode;
		}else {
			newListNode.setNext(rear);
			rear = newListNode;
		}
	}

	@Override
	public void dequeue() {

		ListNode<V> previous = null;
		ListNode<V> current = rear;

		while(current.getNext() != null) {
			previous = current;
			current = current.getNext();
		}

		front = previous;
		previous.setNext(null);

	}

	@Override
	public boolean isEmpty() {
		if(front == null) {
			return true;
		}else {
			return false;
		}
	}

}
