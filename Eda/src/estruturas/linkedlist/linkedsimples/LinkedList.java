package estruturas.linkedlist.linkedsimples;

public interface LinkedList<T extends Comparable<T>> {
	
	/**
	 * Método que verifica se a lista esta vazia.
	 * 
	 * @return Boolean True se estiver fazia, false caso contrário.
	 */
	public boolean isEmpty();
	/**
	 * Método que retorna a quantidade de itens na lista.
	 * 
	 * @return Integer Quantidade de itens na lista.
	 */
	public int size();
	/**
	 * Método que procura um elemento na lista.
	 * 
	 * @param element Elemento a ser procurado.
	 * @return T O próprio elemento, se não estiver na lista, retorna null.
	 */
	public T search(T element);
	/**
	 * Método que insere no final um elemento na lista.
	 * 
	 * @param element Elemento a ser inserido na lista
	 */
	public void insert(T element);
	/**
	 * Método que remove o elemento da lista.
	 * 
	 * @param element Elemento a ser removido.
	 */
	public void remove(T element);
	/**
	 * Método que retorna os elementos.
	 * 
	 * @return T[] Array de elementos.
	 */
	public T[] toArray();
	/**
	 * Método que acha o maior elemento da lista.
	 * 
	 * @return T Maior elemeno.
	 */
	public T maiorElemento();
}
