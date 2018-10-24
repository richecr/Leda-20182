package adt.linkedList;

import java.util.Arrays;

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
		T[] result = (T[]) new Comparable[this.size()];
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

	public void merge(SingleLinkedListImpl<Integer> l1, SingleLinkedListImpl<Integer> l2) {
		SingleLinkedListNode<Integer> aux1 = l1.head;
		SingleLinkedListNode<Integer> aux2 = l2.head;
		while(!aux1.isNIL() && !aux2.isNIL()) {
			Integer temp = aux1.data;
			if (temp > aux2.data) {
				while(temp > aux2.data) {
					swap(l1, l2, aux1, aux2, temp);
					aux2 = aux2.next;
					if (aux2.isNIL()) {
						break;
					}
				}
				aux2 = l2.head;
			}
			aux1 = aux1.next;
		}
		aux2 = l2.head;
		while(!aux2.isNIL()) {
			l1.insert(aux2.data);
			aux2 = aux2.next;
		}
	}

	private void swap(SingleLinkedListImpl<Integer> l1, SingleLinkedListImpl<Integer> l2,
			SingleLinkedListNode<Integer> aux1, SingleLinkedListNode<Integer> aux2, Integer data) {
		if ((l1.search(data) == data) && (l2.search(aux2.data) == aux2.data)) {
			Integer temp = aux1.data;
			aux1.data = aux2.data;
			aux2.data = temp;
		} else {
			SingleLinkedListNode<Integer> aux = l2.head;
			while(aux.data != data) {
				aux = aux.next;
			}
			aux.data = aux2.data;
			aux2.data = data;
		}
	}
}
