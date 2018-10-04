package estruturas.linkedlist.linkeddupla;

import estruturas.linkedlist.linkedsimples.Linked;

public class LinkedDupla<T extends Comparable<T>> extends Linked<T> implements LinkedListDupla<T> {

	private CelulaDupla<T> last;
	private int size;
	
	public LinkedDupla() {
		this.head = new CelulaDupla<T>();
		this.last = (CelulaDupla<T>) head;
	}
	
	@Override
	public boolean isEmpty() {
		return this.last.isNil();
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public T search(T element) {
		T res = null;
		CelulaDupla<T> aux = (CelulaDupla<T>) this.head;
		CelulaDupla<T> auxFim = this.last;
		while (!aux.equals(auxFim) && (!aux.getProximo().equals(auxFim)) && 
				!aux.getElemento().equals(element) && !auxFim.getElemento().equals(element)) {
			aux = aux.getProximo();
			auxFim = auxFim.getAnterior();
		}
		if (aux.getElemento().equals(element)) {
			res = aux.getElemento();
		}
		if (auxFim.getElemento().equals(element)) {
			res = auxFim.getElemento();
		}
		return res;
	}

	@Override
	public void insert(T element) {
		CelulaDupla<T> newLast = new CelulaDupla<T>(element);
		newLast.setAnterior(this.last);
		newLast.setProximo(new CelulaDupla<>());
		this.last.setProximo(newLast);
		if (this.last.isNil()) {
			this.head = newLast;
		}
		this.last = newLast;
		this.size++;
	}

	@Override
	public void remove(T element) {
		if (this.isEmpty()) {
			throw new NullPointerException("Lista esta vazia");
		} else  if (this.head.getElemento().equals(element)) {
			this.removeFirst();
		} else {
			CelulaDupla<T> aux = (CelulaDupla<T>) this.head;
			while (!aux.isNil() && !aux.getElemento().equals(element)) {
				aux = aux.getProximo();
			}
			if (!aux.isNil()) {
				aux.getAnterior().setProximo(aux.getProximo());
				aux.getProximo().setAnterior(aux.getAnterior());
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] res = (T[]) new Comparable[this.size];
		if (this.isEmpty()) {
			throw new NullPointerException("Lista esta vazia");
		} else {
			int i = 0;
			CelulaDupla<T> aux = (CelulaDupla<T>) this.head;
			while (i < this.size && aux != null) {
				res[i] = (T) aux.getElemento();
				aux = aux.getProximo();
				i++;
			}
		}
		return res;
	}

	@Override
	public void insertFirst(T element) {
		CelulaDupla<T> newHead = new CelulaDupla<T>(element);
		newHead.setProximo((CelulaDupla<T>) this.head);
		newHead.setAnterior(new CelulaDupla<>());
		((CelulaDupla<T>) this.head).setAnterior(newHead);
		if (this.head.isNil()) {
			this.last = newHead;
		}
		this.head = newHead;
		this.size++;
	}

	@Override
	public void removeFirst() {
		if(this.isEmpty()) {
			throw new NullPointerException("Lista esta vazia");
		} else {
			if (!this.head.isNil()) {
				this.head = this.head.getProximo();
				if (this.head.isNil()) {
					this.last = (CelulaDupla<T>) this.head;
				}
				((CelulaDupla<T>) this.head).setAnterior(new CelulaDupla<>());
			}
		}
	}

	@Override
	public void removeLast() {
		if(this.isEmpty()) {
			throw new NullPointerException("Lista esta vazia");
		} else {
			if (!this.last.isNil()) {
				this.last = this.last.getProximo();
				if (this.last.isNil()) {
					this.head = this.last;
				}
				this.last.setProximo(new CelulaDupla<>());
			}
		}
	}
	
	@Override
	public T maiorElemento() {
		T maior = null;
		if (this.isEmpty()) {
			throw new NullPointerException("Lista esta vazia");
		} else {
			CelulaDupla<T> aux = (CelulaDupla<T>) this.head;
			maior = aux.getElemento();
			while (!aux.isNil()) {
				if (aux.getElemento().compareTo(maior) > 0) {
					maior = aux.getElemento();
				}
				aux = aux.getProximo();
			}
		}
		return maior;
	}
	
	@Override
	public boolean contains(T element) {
		boolean result = false;
		T res = this.search(element);
		if (res != null) {
			result = true;
		}
		return result;
	}
}
