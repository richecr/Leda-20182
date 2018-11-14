package adt.avltree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import adt.bst.BSTNode;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {

	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		if (array != null) {
			T[] rootPreOrder = this.preOrder();
			List<T> allElements = new ArrayList<>();
			Collections.addAll(allElements, array);
			Collections.addAll(allElements, rootPreOrder);
			Collections.sort(allElements);
			removeRepeated(allElements);
			this.root = new BSTNode<>();

			T[] aux = getArrayInsert((T[]) allElements.toArray(new Comparable[allElements.size()]));
			for (int i = 0; i < aux.length; i++) {
				this.insert(aux[i]);
			}
		}
	}

	private void removeRepeated(List<T> lista) {
		for (int i = 0; i < lista.size(); i++) {
			for (int j = i + 1; j < lista.size() && lista.get(i).equals(lista.get(j)); j++) {
				lista.remove(lista.get(j));
			}
		}
	}

	private T[] getArrayInsert(T[] array) {
		ArrayList<ArrayList<T>> lista = new ArrayList<>();
		T[] aux = (T[]) new Comparable[array.length];
		lista.add(new ArrayList<T>(Arrays.asList(array)));
		int i = 0;
		while (i < array.length) {
			int middle = lista.get(i).size() / 2;
			aux[i] = lista.get(i).get(middle);
			lista.add(newArrayList(lista.get(i), 0, middle));
			lista.add(newArrayList(lista.get(i), middle + 1, lista.get(i).size()));
			i += 1;
		}
		return aux;
	}

	private ArrayList<T> newArrayList(ArrayList<T> array, int left, int right) {
		ArrayList<T> aux = new ArrayList<>();
		for (int i = left; i < right; i++) {
			aux.add(array.get(i));
		}
		return aux;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int height = calculateBalance(node);
		if (height > 1) {
			if (calculateBalance((BSTNode<T>) node.getRight()) < 0) {
				rightRotation((BSTNode<T>) node.getRight());
				leftRotation(node);
				this.RLcounter++;
			} else {
				leftRotation(node);
				this.RRcounter++;
			}
		} else if (height < -1) {
			if (calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
				leftRotation((BSTNode<T>) node.getLeft());
				rightRotation(node);
				this.LRcounter++;
			} else {
				rightRotation(node);
				this.LLcounter++;
			}
		}
	}
}
