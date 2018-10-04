package estruturas.pilhas;

import estruturas.exceptions.StackOverflowException;
import estruturas.exceptions.StackUnderflowException;
import estruturas.linkedlist.linkeddupla.LinkedDupla;
import estruturas.linkedlist.linkedsimples.LinkedList;

public class PilhaLinkedList<T extends Comparable<T>> implements Stack<T> {

	private LinkedList<T> lista;
	private int size;
	
	public PilhaLinkedList(int size) {
		this.size = size;
		this.lista = new LinkedDupla<>();
	}
	
	@Override
	public void push(T e) throws StackOverflowException {
		if (this.isFull()) {
			throw new StackOverflowException();
		} else {
			((LinkedDupla<T>) this.lista).insert(e);
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T result;
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		} else {
			result = ((LinkedDupla<T>) this.lista).getLast().getElemento();
			((LinkedDupla<T>) this.lista).removeLast();
		}
		return result;
	}

	@Override
	public T top() {
		return ((LinkedDupla<T>) this.lista).getLast().getElemento();
	}

	@Override
	public boolean isEmpty() {
		return this.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.lista.size() == this.size;
	}
}
