package estruturas.linkedlist.linkeddupla;

import estruturas.linkedlist.linkedsimples.CelulaSimples;

public class CelulaDupla<T extends Comparable<T>> extends CelulaSimples<T> {

	/**
	 * Atributo que representa a celula anterior na lista.
	 */
	private CelulaDupla<T> anterior;
	/**
	 * Atributo que representa o elemento desta celula.
	 */
	private T elemento;
	
	public CelulaDupla() {
		this(null, null, null);
	}
	
	/**
	 * Construtor.
	 * 
	 * @param elemento Elemento desta celula.
	 */
	public CelulaDupla(T elemento) {
		this(null, null, elemento);
	}
	
	/**
	 * Construtor.
	 * 
	 * @param anterior Celula anterior a esta celula.
	 * @param proxima Celula depois desta. 
	 * @param elemento Elemento desta celula.
	 */
	public CelulaDupla(CelulaDupla<T> anterior, CelulaDupla<T> proxima, T elemento) {
		super(proxima, elemento);
		this.anterior = anterior;
	}
	
	/**
	 * Método que altera a celula anterior a esta.
	 * 
	 * @param anterior Celula anterior.
	 */
	public void setAnterior(CelulaDupla<T> anterior) {
		this.anterior = anterior;
	}
	
	/**
	 * Método que altera a proxima celula depois dessa.
	 * 
	 * @param celula Proxima celula.
	 */
	public void setProximo(CelulaDupla<T> proximo) {
		this.proxima = proximo;
	}
	
	/**
	 * Método que retorna a celula anterior a esta.
	 * 
	 * @return Celula A celula anterior.
	 */
	public CelulaDupla<T> getAnterior(){
		return this.anterior;
	}
	
	/**
	 * Método que retorna proxima celula depois dessa.
	 * 
	 * @return Celula A proxima celula.
	 */
	public CelulaDupla<T> getProximo(){
		return (CelulaDupla<T>) this.proxima;
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