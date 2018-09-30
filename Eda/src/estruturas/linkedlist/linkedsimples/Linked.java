package estruturas.linkedlist.linkedsimples;

public class Linked<T extends Comparable<T>> implements LinkedList<T> {

	private Celula head;
	private int size;
	
	public Linked() {
		this.head = null;
	}
	
	@Override
	public boolean isEmpty() {
		return this.head == null;
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
			Celula aux = this.head;
			while(aux != null) {
				if (aux.getElemento().equals(element)) {
					res = (T) aux.getElemento();
				}
				aux = aux.getProximo();
			}
		}
		return res;
	}

	@Override
	public void insert(T element) {
		Celula<T> nova = new Celula<T>(null, element);
		if (this.head == null) {
			this.head = nova;
		} else {
			Celula<T> aux;
			aux = this.head;
			while(aux.getProximo() != null) {
				aux = aux.getProximo();
			}
			aux.setProximo(nova);
			this.size++;
		}
		
	}

	@Override
	public void remove(T element) {
		if (this.isEmpty()) {
			throw new NullPointerException("Lista esta vazia");
		} else if(this.head.getElemento().equals(element)) {
			this.head = this.head.getProximo();
		} else {
			Celula aux = this.head;
			Celula anterior = null;
			while(aux != null && aux.getElemento() != element) {
				anterior = aux;
				aux = aux.getProximo();
			}
			if (aux != null) {
				anterior.setProximo(aux.getProximo());
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] res = (T[]) new Comparable[this.size+1];
		if (this.isEmpty()) {
			throw new NullPointerException("Lista esta vazia");
		} else {
			int i = 0;
			Celula<T> aux = this.head;
			while(i <= this.size && aux != null) {
				res[i] = aux.getElemento();
				aux = aux.getProximo();
				i++;
			}
		}
		return res;
	}
	
	@Override
	public T maiorElemento() {
		T maior = null;
		if (this.isEmpty()) {
			throw new NullPointerException("Lista esta vazia");
		} else {
			Celula aux = this.head;
			maior = (T) aux.getElemento();
			while(aux != null) {
				if (aux.getElemento().compareTo(maior) > 0) {
					maior = (T) aux.getElemento();
				}
				aux = aux.getProximo();
			}
		}
		return maior;
	}
}
