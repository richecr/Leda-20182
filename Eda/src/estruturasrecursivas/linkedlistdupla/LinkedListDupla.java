package estruturasrecursivas.linkedlistdupla;

import estruturasrecursivas.linkedlistsimples.LinkedList;

public interface LinkedListDupla<T> extends LinkedList<T>{

	public void insertFirst(T element);
	public void removeFirst();
	public void removeLast();
	
}
