package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor<T extends Comparable<T>> {

	// O array interno onde os objetos manipulados são guardados
	private T[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.arrayInterno = (T[]) new Comparable[tamanho];
		this.tamanho = tamanho;
		this.indice = 0;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(T o) {
		this.arrayInterno[this.indice] = o;
		this.indice++;
	}

	// Remove um objeto do vetor
	public T remover(T o) {
		T res = null;
		int i = 0;
		boolean achou = false;
		while ((i < this.arrayInterno.length) && !achou) {
			if (this.arrayInterno[i].equals(o)) {
				res = this.arrayInterno[i];
				this.arrayInterno[i] = this.arrayInterno[this.indice-1];
				this.arrayInterno[this.indice-1] = null;
				this.indice--;
				achou = true;
			}
			i++;
		}
		return res;
	}

	// Procura um elemento no vetor
	public T procurar(T o) {
		T res = null;
		int i = 0;
		boolean achou = false;
		while ((i < this.indice) && !achou) {
			if (this.arrayInterno[i].equals(o)) {
				res = this.arrayInterno[i];
				achou = true;
			}
			i++;
		}
		return res;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		return (this.indice == 0);
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return (this.indice == tamanho);
	}
	
	public T maximo() {
		T res = null;
		if(!this.isVazio()) {
			res = this.arrayInterno[0];
			for (int i = 1; i < this.indice; i++) {
				if (this.comparadorMaximo.compare(res, this.arrayInterno[i]) < 0) {
					res = this.arrayInterno[i];
				}
			}
		}
		return res;
	}
	
	public T minimo() {
		T res = null;
		if(!this.isVazio()) {
			res = this.arrayInterno[0];
			for (int i = 0; i < this.indice-1; i++) {
				if (this.comparadorMinimo.compare(res, this.arrayInterno[i]) < 0) {
					res = this.arrayInterno[i];
				}
			}
		}
		return res;
	}

}
