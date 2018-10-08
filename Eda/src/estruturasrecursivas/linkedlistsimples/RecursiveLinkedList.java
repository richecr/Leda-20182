package estruturasrecursivas.linkedlistsimples;

public class RecursiveLinkedList<T> implements LinkedList<T> {

	private T data;
	private RecursiveLinkedList<T> next;
	
	@Override
	public boolean isEmpty() {
		boolean saida = false;
		if (this.data == null) {
			saida = true;
		}
		return saida;
	}

	@Override
	public int size() {
		if (this.isEmpty()) {
			return 0;
		} else {
			return 1 + this.next.size();
		}
	}

	@Override
	public void insert(T e) {
		if (this.isEmpty()) {
			this.data = e;
			this.next = new RecursiveLinkedList<T>();
		} else {
			this.next.insert(e);
		}
	}

	@Override
	public void remove(T e) {
		if (this.isEmpty()) {
			
		} else {
			if (this.data.equals(e)) {
				this.data = this.next.data;
				this.next = this.next.next;
			} else {
				this.next.remove(e);
			}
		}
	}

	@Override
	public T search(T e) {
		T saida = null;
		if (this.isEmpty()) {
			saida = null;
		} else {
			if (this.data.equals(e)) {
				saida = this.data;
			} else {
				saida = this.next.search(e);
			}
		}
		return saida;
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		this.toArray(array, this, 0);
		return array;
	}

	private void toArray(T[] array, RecursiveLinkedList<T> recursiveLinkedList, int i) {
		if (!recursiveLinkedList.isEmpty()) {
			array[i] = recursiveLinkedList.data;
			toArray(array, recursiveLinkedList.next, ++i);
		}
	}

}
