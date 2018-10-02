package estruturas.linkedlist.linkedsimples;

public class CelulaSimples<T extends Comparable<T>> {
	
	/**
	 * Atributo que representa a proxima celula da lista.
	 */
	protected CelulaSimples proxima;
	/**
	 * Atributo que representa o elemento dessa celula na lista.
	 */
	private T elemento;
	
	public CelulaSimples() {
		this(null, null);
	}
	
	/**
	 * Construtor.
	 * 
	 * @param prox Proxima celula depois dessa celula na lista.
	 * @param elemento Elemento da lista
	 */
	public CelulaSimples(CelulaSimples prox, T elemento) {
		this.proxima = prox;
		this.elemento = elemento;
	}
	
	/**
	 * Método que altera a proxima celula depois dessa.
	 * 
	 * @param celula Proxima celula.
	 */
	public void setProximo(CelulaSimples celula) {
		this.proxima = celula;
	}
	
	/**
	 * Método que retorna proxima celula depois dessa.
	 * 
	 * @return Celula A proxima celula.
	 */
	public CelulaSimples getProximo() {
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
	
	public boolean isNil() {
		return this.elemento == null;
	}
}