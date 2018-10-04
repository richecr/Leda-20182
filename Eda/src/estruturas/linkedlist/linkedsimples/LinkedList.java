package estruturas.linkedlist.linkedsimples;

public interface LinkedList<T extends Comparable<T>> {
	
	/**
	 * M�todo que verifica se a lista esta vazia.
	 * 
	 * @return Boolean True se estiver fazia, false caso contr�rio.
	 */
	public boolean isEmpty();
	/**
	 * M�todo que retorna a quantidade de itens na lista.
	 * 
	 * @return Integer Quantidade de itens na lista.
	 */
	public int size();
	/**
	 * M�todo que procura um elemento na lista.
	 * 
	 * @param element Elemento a ser procurado.
	 * @return T O pr�prio elemento, se n�o estiver na lista, retorna null.
	 */
	public T search(T element);
	/**
	 * M�todo que insere no final um elemento na lista.
	 * 
	 * @param element Elemento a ser inserido na lista
	 */
	public void insert(T element);
	/**
	 * M�todo que remove o elemento da lista.
	 * 
	 * @param element Elemento a ser removido.
	 */
	public void remove(T element);
	/**
	 * M�todo que retorna os elementos.
	 * 
	 * @return T[] Array de elementos.
	 */
	public T[] toArray();
	/**
	 * M�todo que acha o maior elemento da lista.
	 * 
	 * @return T Maior elemeno.
	 */
	public T maiorElemento();
	/**
	 * Método que verifica se a lista contém o elemento.
	 * 
	 * @param element Elemento a ser verificado.
	 * @return True se o elemento estiver na lista, false caso contrário.
	 */
	public boolean contains(T element);
}
