package adt.skipList;

public class SkipListImpl<T> implements SkipList<T> {

	protected SkipListNode<T> root;
	protected SkipListNode<T> NIL;

	protected int maxHeight;

	protected double PROBABILITY = 0.5;

	public SkipListImpl(int maxHeight) {
		this.maxHeight = maxHeight;
		root = new SkipListNode(Integer.MIN_VALUE, maxHeight, null);
		NIL = new SkipListNode(Integer.MAX_VALUE, maxHeight, null);
		connectRootToNil();
	}

	/**
	 * Faz a ligacao inicial entre os apontadores forward do ROOT e o NIL Caso
	 * esteja-se usando o level do ROOT igual ao maxLevel esse metodo deve
	 * conectar todos os forward. Senao o ROOT eh inicializado com level=1 e o
	 * metodo deve conectar apenas o forward[0].
	 */
	private void connectRootToNil() {
		for (int i = 0; i < maxHeight; i++) {
			root.forward[i] = NIL;
		}
	}

	
	@Override
	public void insert(int key, T newValue, int height) {
		if (height < this.maxHeight) {
			SkipListNode<T>[] update = new SkipListNode[this.root.height()];
			
			SkipListNode<T> aux = this.root;
			for (int i = this.root.height() - 1; i >= 0; i--) {
				while (aux.forward[i] != null && aux.forward[i].key < key) {
					aux = aux.forward[i];
				}
				update[i] = aux;
			}
			aux = aux.forward[0];
			if (aux.key == key) {
				aux.value = newValue;
			} else {
				aux = new SkipListNode<T>(key, height, newValue);
				for (int i = 0; i < height; i++) {
					aux.forward[i] = update[i].forward[i];
					update[i].forward[i] = aux;
				}
			}
		}
	}

	@Override
	public void remove(int key) {
		SkipListNode<T>[] update = new SkipListNode[this.root.height()];
		SkipListNode<T> aux = this.root;
		for (int i = this.root.height() - 1; i >= 0; i--) {
			while (aux.forward[i] != null && aux.forward[i].key < key) {
				aux = aux.forward[i];
			}
			update[i] = aux;
		}
		aux = aux.forward[0];
		if (aux.key == key) {
			for (int i = 0; i < this.root.height(); i++) {
				if (update[i].forward[i] != aux) {
					break;
				}
				update[i].forward[i] = aux.forward[i];
			}
		}
	}

	@Override
	public int height() {
		SkipListNode<T> aux = this.root;
		int res = 0;
		while (aux.forward[0].key != Integer.MAX_VALUE) {
			aux = aux.forward[0];
			if (aux.height() > res) {
				res = aux.height();
			}
		}
		return res;
	}

	@Override
	public SkipListNode<T> search(int key) {
		SkipListNode<T> aux = this.root;
		for (int i = this.root.height() - 1; i >= 0; i--) {
			while (aux.forward[i] != null && aux.forward[i].key < key) {
				aux = aux.forward[i];
			}
		}
		aux = aux.forward[0];
		if (aux.key == key) {
			return aux;
		} else {
			return null;
		}
	}

	@Override
	public int size() {
		SkipListNode<T> aux = this.root.forward[0];
		int res = 0;
		while (aux.value != null) {
			aux = aux.forward[0];
			res += 1;
		}
		return res;
	}

	@Override
	public SkipListNode<T>[] toArray() {
		SkipListNode<T>[] res = new SkipListNode[this.size() + 2];
		SkipListNode<T> aux = this.root;
		for (int i = 0; i < res.length; i++) {
			res[i] = aux;
			aux = aux.forward[0];
		}
		return res;
	}

}
