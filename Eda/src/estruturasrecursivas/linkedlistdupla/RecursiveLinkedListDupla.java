package estruturasrecursivas.linkedlistdupla;

import estruturasrecursivas.linkedlistsimples.RecursiveLinkedList;

public class RecursiveLinkedListDupla<T> extends RecursiveLinkedList<T> 
										implements LinkedListDupla<T> {

	protected RecursiveLinkedListDupla<T> previous;
	
	@Override
	public void insert(T e) {
		if (this.isEmpty()) {
			this.data = e;
			this.next = new RecursiveLinkedListDupla<>();
			if (this.previous == null) {
				this.previous = new RecursiveLinkedListDupla<>();
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
		// TODO Auto-generated method stub
		
	}

	@Override
    public void removeFirst() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		
	}

}
