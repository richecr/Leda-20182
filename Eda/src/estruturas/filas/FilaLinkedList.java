package estruturas.filas;

import estruturas.exceptions.QueueOverflowException;
import estruturas.exceptions.QueueUnderflowException;
import estruturas.linkedlist.linkeddupla.LinkedDupla;
import estruturas.linkedlist.linkedsimples.LinkedList;

public class FilaLinkedList<T extends Comparable<T>> implements Queue<T>  {

	private LinkedList<T> lista;
	private int size;
	
	@Override
	public void enqueue(T e) throws QueueOverflowException {
		if (this.isFull()) {
			throw new QueueOverflowException();
		} else {
			this.lista.insert(e);
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = null;
		if (this.isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			result = ((LinkedDupla<T>) this.lista).getHead().getElemento();
			((LinkedDupla<T>) this.lista).removeFirst();
		}
		return result;
	}

	@Override
	public T head() {
		return ((LinkedDupla<T>) this.lista).getHead().getElemento();
	}

	@Override
	public boolean isEmpty() {
		return this.lista.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.lista.size() == this.size;
	}
}
