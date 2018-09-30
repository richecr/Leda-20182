package estruturas.linkedlist.linkedsimples;

public class Celula<T extends Comparable<T>> {
	
	/**
	 * Atributo que representa a proxima celula da lista.
	 */
	private Celula proxima;
	/**
	 * Atributo que representa o elemento dessa celula na lista.
	 */
	private T elemento;
	
	/**
	 * Construtor.
	 * 
	 * @param prox Proxima celula depois dessa celula na lista.
	 * @param elemento Elemento da lista
	 */
	public Celula(Celula prox, T elemento) {
		this.proxima = prox;
		this.elemento = elemento;
	}
	
	/**
	 * Método que altera a proxima celula depois dessa.
	 * 
	 * @param celula Proxima celula.
	 */
	public void setProximo(Celula celula) {
		this.proxima = celula;
	}
	
	/**
	 * Método que retorna proxima celula depois dessa.
	 * 
	 * @return Celula A proxima celula.
	 */
	public Celula getProximo() {
		return this.proxima;
	}
	
	/**
	 * Método que retorna o elemento desta celula.
	 * 
	 * @return T O elemento dessa celula.
	 */
	public T getElemento() {
		return this.elemento;
	}
}