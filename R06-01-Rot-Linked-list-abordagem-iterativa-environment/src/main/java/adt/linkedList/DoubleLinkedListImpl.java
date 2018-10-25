package adt.linkedList;

public class DoubleLinkedListImpl<T extends Comparable<T>> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) this.head;
	}
	
	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>(element, null, null);
		newHead.setNext(this.head);
		newHead.setPrevious(new DoubleLinkedListNode<>());
		((DoubleLinkedListNode<T>) this.head).setPrevious(newHead);
		if (this.head.isNIL()) {
			this.last = newHead;
		}
		this.head = newHead;
	}

	@Override
	public void removeFirst() {
		if (!this.head.isNIL()) {
			this.head = this.head.next;
			if (this.head.isNIL()) {
				this.last = (DoubleLinkedListNode<T>) this.head;
			}
			((DoubleLinkedListNode<T>) this.head).setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {
		if (!this.last.isNIL()) {
			this.last = this.last.getPrevious();
			if (this.last.isNIL()) {
				this.head = this.last;
			}
			this.last.setNext(new DoubleLinkedListNode<>());
		}
	}
	
	@Override
	public void insert(T element) {
		DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<T>(element, null, null);
		newLast.setPrevious(this.last);
		newLast.setNext(new DoubleLinkedListNode<T>());
		this.last.setNext(newLast);
		if (this.last.isNIL()) {
			this.head = newLast;
		}
		this.last = newLast;
	}
	
	@Override
	public T search(T element) {
		T result = null;
		DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.head;
		DoubleLinkedListNode<T> auxLast = this.last;
		while(!auxHead.equals(auxLast) && !auxHead.getNext().equals(auxLast) && 
				!auxHead.getData().equals(element) && !auxLast.getData().equals(element)) {
			auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
			auxLast = auxLast.getPrevious();
		}
		if (auxHead.getData().equals(element)) {
			result = auxHead.getData();
		}
		if (auxLast.getData().equals(element)) {
			result = auxLast.getData();
		}
		return result;
	}
	
	@Override
	public void remove(T element) {
		if (this.head.getData().equals(element)) {
			this.removeFirst();
		} else {
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) this.head;
			while(!auxHead.isNIL() && !auxHead.getData().equals(element)) {
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
			}
			if (!auxHead.isNIL()) {
				auxHead.getPrevious().setNext(auxHead.getNext());
				((DoubleLinkedListNode<T>) auxHead.getNext()).setPrevious(auxHead.getPrevious());
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}
}