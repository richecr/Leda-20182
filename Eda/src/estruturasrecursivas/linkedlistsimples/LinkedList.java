package estruturasrecursivas.linkedlistsimples;

public interface LinkedList<T> {
	
	public boolean isEmpty();
	public int size();
	public void insert(T e);
	public void remove(T e);
	public T search(T e);
	public T[] toArray();
	
}
