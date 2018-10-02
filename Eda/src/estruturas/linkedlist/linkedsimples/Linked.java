package estruturas.linkedlist.linkedsimples;

public class Linked<T extends Comparable<T>> implements LinkedList<T> {

	protected CelulaSimples head;
	private int size;
	
	public Linked() {
		this.head = new CelulaSimples<>();
	}
	
	@Override
	public boolean isEmpty() {
		return this.head.isNil();
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public T search(T element) {
		T res = null;
		CelulaSimples<T> aux = this.head;
		while(!aux.isNil() && aux.getElemento().equals(element)) {
			res = (T) aux.getElemento();
			aux = aux.getProximo();
		}
		return res;
	}

	@Override
	public void insert(T element) {
		CelulaSimples<T> aux = this.head;
		if (this.isEmpty()) {
			CelulaSimples<T> nova = new CelulaSimples<T>(null, element);
			nova.setProximo(new CelulaSimples<>());
			this.head = nova;
		} else {
			while(!aux.getProximo().isNil()) {
				aux = aux.getProximo();
			}
			CelulaSimples<T> novaCelula = new CelulaSimples<>(null, element);
			novaCelula.setProximo(aux.getProximo());
			aux.setProximo(novaCelula);
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
			CelulaSimples<T> aux = this.head;
			CelulaSimples<T> anterior = new CelulaSimples<>();
			while(!aux.isNil() && aux.getElemento() != element) {
				anterior = aux;
				aux = aux.getProximo();
			}
			if (!aux.isNil()) {
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
			CelulaSimples<T> aux = this.head;
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
			CelulaSimples<T> aux = this.head;
			maior = (T) aux.getElemento();
			while(!aux.isNil()) {
				if (aux.getElemento().compareTo(maior) > 0) {
					maior = (T) aux.getElemento();
				}
				aux = aux.getProximo();
			}
		}
		return maior;
	}
}
