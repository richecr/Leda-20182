package estruturas.linkedlist.linkeddupla;

public class Celula<T extends Comparable<T>> {

	/**
	 * Atributo que representa a proxima celula na lista.
	 */
	private Celula<T> proxima;
	/**
	 * Atributo que representa a celula anterior na lista.
	 */
	private Celula<T> anterior;
	/**
	 * Atributo que representa o elemento desta celula.
	 */
	private T elemento;
	
	/**
	 * Construtor.
	 * 
	 * @param elemento Elemento desta celula.
	 */
	public Celula(T elemento) {
		this(null, null, elemento);
	}
	
	/**
	 * Construtor.
	 * 
	 * @param anterior Celula anterior a esta celula.
	 * @param proxima Celula depois desta. 
	 * @param elemento Elemento desta celula.
	 */
	public Celula(Celula<T> anterior, Celula<T> proxima, T elemento) {
		this.proxima = proxima;
		this.anterior = anterior;
		this.elemento = elemento;
	}
	
	/**
	 * Método que altera a celula anterior a esta.
	 * 
	 * @param anterior Celula anterior.
	 */
	public void setAnterior(Celula<T> anterior) {
		this.anterior = anterior;
	}
	
	/**
	 * Método que altera a proxima celula depois dessa.
	 * 
	 * @param celula Proxima celula.
	 */
	public void setProximo(Celula<T> proximo) {
		this.proxima = proximo;
	}
	
	/**
	 * Método que retorna a celula anterior a esta.
	 * 
	 * @return Celula A celula anterior.
	 */
	public Celula<T> getAnterior(){
		return this.anterior;
	}
	
	/**
	 * Método que retorna proxima celula depois dessa.
	 * 
	 * @return Celula A proxima celula.
	 */
	public Celula<T> getProximo(){
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