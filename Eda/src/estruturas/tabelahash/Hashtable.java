package estruturas.tabelahash;

public interface Hashtable<T> {
	
	public boolean isEmpty();
	public boolean isFull();
	public int capacity();
	public int size();
	public void insert(T element);
	public void remove(T element) ;
	public T search(T element);
	public int indexOf(T element);
	
}
