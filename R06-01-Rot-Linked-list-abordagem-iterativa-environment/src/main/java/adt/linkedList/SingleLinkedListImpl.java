package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.isNIL();
	}

	@Override
	public int size() {
		int i = 0;
		SingleLinkedListNode<T> aux = this.head;
		while(!aux.isNIL()) {
			i++;
			aux = aux.next;
		}
		return i;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = this.head;
		while (!aux.isNIL() && !aux.getData().equals(element)) {
			aux = aux.getNext();
		}
		return aux.getData();
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> aux = this.head;
		if (this.isEmpty()) {
			SingleLinkedListNode<T> auxNovo = new SingleLinkedListNode<>();
			auxNovo.setData(element);
			auxNovo.setNext(this.head);
			this.head = auxNovo;
		} else {
			while(!aux.next.isNIL()) {
				aux = aux.next;
			}
			SingleLinkedListNode<T> novoNode = new SingleLinkedListNode<>();
			novoNode.setData(element);
			novoNode.setNext(aux.next);
			aux.setNext(novoNode);
		}
	}

	@Override
	public void remove(T element) {
		if (this.head.getData().equals(element)) {
			this.head = this.head.next;
		} else {
			SingleLinkedListNode<T> aux = this.head;
			SingleLinkedListNode<T> previous = new SingleLinkedListNode<>();
			while(!aux.isNIL() && !aux.getData().equals(element)) {
				previous = aux;
				aux = aux.next;
			}
			if (!aux.isNIL()) {
				previous.setNext(aux.next);
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> aux = this.head;
		int i = 0;
		while(!aux.isNIL()) {
			result[i] = aux.getData();
			aux = aux.next;
			i++;
		}
		return result;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
