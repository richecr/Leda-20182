package estruturas.linkedlist.linkeddupla;

import estruturas.linkedlist.linkedsimples.LinkedList;

public interface LinkedListDupla<T extends Comparable<T>> extends LinkedList<T>{
	
	/**
	 * Método que insere no inicio da lista.
	 * 
	 * @param element Elemento a ser adicionado.
	 */
	public void insertFirst(T element);
	/**
	 * Método que remove o primeiro elemento.
	 */
	public void removeFirst();
	/**
	 * Método que remove o último elemento.
	 */
	public void removeLast();
	
}