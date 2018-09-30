package estruturas.linkedlist.linkeddupla;

public class LinkedDupla<T extends Comparable<T>> implements LinkedListDupla<T> {

	private Celula<T> head;
	private Celula<T> last;
	private int size;
	
	public LinkedDupla() {
		this.head = new Celula<T>(null);
		this.last = head;
	}
	
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public T search(T element) {
		T res = null;
		if (this.isEmpty()) {
			throw new NullPointerException("Lista esta vazia"); 
		} else {
			Celula<T> aux = this.head.getProximo();
			Celula<T> auxFim = this.last;
			boolean achou = false;
			while (!aux.equals(auxFim) && (!achou)) {
				if (aux.getElemento().equals(element)) {
					res = aux.getElemento();
					achou = true;
				}
				if (auxFim.getElemento().equals(element)) {
					res = auxFim.getElemento();
					achou = true;
				}
				aux = aux.getProximo();
				auxFim = auxFim.getAnterior();
			}
			if (aux.getElemento().equals(element)) {
				res = aux.getElemento();
			}
		}
		return res;
	}

	@Override
	public void insert(T element) {
		Celula<T> newLast = new Celula<T>(element);
		newLast.setAnterior(this.last);
		newLast.setProximo(null);
		this.last.setProximo(newLast);
		if (this.isEmpty()) {
			this.head = newLast;
		}
		this.last = newLast;
		this.size++;
	}

	@Override
	public void remove(T element) {
		if (this.isEmpty()) {
			throw new NullPointerException("Lista esta vazia");
		} else {
			Celula<T> aux = this.head;
			while (aux != null) {
				if (aux.getAnterior() != null) {
					if (aux.getElemento().equals(element)) {
						Celula<T> anterior = aux.getAnterior();
						Celula<T> proximo = aux.getProximo();
						anterior.setProximo(proximo);
					}
				} else {
					if (aux.getElemento().equals(element)) {
						Celula<T> proximo = aux.getProximo();
						this.head = proximo;
					}
				}
				aux = aux.getProximo();
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
			Celula aux = this.head;
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
		Celula<T> novo = new Celula<T>(null, this.head, element);
		this.head = novo;
	}

	@Override
	public void removeFirst() {
		if(this.isEmpty()) {
			throw new NullPointerException("Lista esta vazia");
		} else {
			Celula<T> proximo = this.head.getProximo();
			this.head = proximo;
		}
	}

	@Override
	public void removeLast() {
		if (this.isEmpty()) {
			throw new NullPointerException("Lista esta vazia");
		} else {
			Celula<T> anterior = this.last.getAnterior();
			anterior.setProximo(null);
			this.last = anterior;
		}
	}
	
	@Override
	public T maiorElemento() {
		T maior = null;
		if (this.isEmpty()) {
			throw new NullPointerException("Lista esta vazia");
		} else {
			Celula<T> aux = this.head;
			maior = aux.getElemento();
			while (aux != null) {
				if (aux.getElemento().compareTo(maior) > 0) {
					maior = aux.getElemento();
				}
				aux = aux.getProximo();
			}
		}
		return maior;
	}

}
