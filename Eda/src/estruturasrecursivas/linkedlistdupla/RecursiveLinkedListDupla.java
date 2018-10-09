package estruturasrecursivas.linkedlistdupla;

import estruturasrecursivas.linkedlistsimples.RecursiveLinkedList;

public class RecursiveLinkedListDupla<T> extends RecursiveLinkedList<T> 
										implements LinkedListDupla<T> {

	protected RecursiveLinkedListDupla<T> previous;
	
	@Override
	public void insert(T e) {
		if (this.isEmpty()) {
			this.data = e;
			RecursiveLinkedListDupla<T> nil = new RecursiveLinkedListDupla<>();
			this.next = nil;
			nil.previous = this;
			if (this.previous == null) {
				this.previous = nil;
			}
		} else {
			this.next.insert(e);
		}
	}
	
	@Override
	public void remove(T e) {
		if (this.isEmpty()) {
			
		} else {
			if (this.data.equals(e)) {
				if (this.previous.isEmpty() && this.next.isEmpty()) {
					this.previous = null;
					this.next = null;
					this.data = null;
				} else {
					this.data = ((RecursiveLinkedListDupla<T>) this.next).data;
					this.next = ((RecursiveLinkedListDupla<T>) this.next).next;
					if (this.next != null) {
						((RecursiveLinkedListDupla<T>) this.next).previous = this;
					}
				}
			} else {
				this.next.remove(e);
			}
		}
	}
	
	@Override
	public void insertFirst(T element) {
		if (this.isEmpty()) {

		} else {
			((RecursiveLinkedListDupla<T>) this.next).data = this.data;
			
		}
	}

	@Override
    public void removeFirst() {
		if (this.isEmpty()) {
			// Nao faz nada.
		} else {
			this.data = ((RecursiveLinkedListDupla<T>) this.next).data;
			((RecursiveLinkedListDupla<T>) this.next).removeFirst();
		}
	}

	@Override
	public void removeLast() {
		if (this.isEmpty()) {
			this.previous.previous.next = new RecursiveLinkedListDupla<>();
		} else {
			((RecursiveLinkedListDupla<T>) this.next).removeLast();
		}
	}

}
