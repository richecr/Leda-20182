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

		ArrayList<T> aux = new ArrayList<>();
		T[] a = order();
		
		for (T t : a) {
			aux.add(t);
		}
		
		this.root = new BSTNode<T>();
		
		for (T t : array) {
			aux.add(t);
		}
		
		array = (T[]) aux.toArray(new Comparable[aux.size()]);
		Arrays.sort(array);
		T[] arrayAux = (T[]) new Comparable[array.length * 2];
		fillWithoutRebalace(array, arrayAux, 0, array.length - 1, 0);
		
		for (T t : arrayAux) {
			if (t != null) {
				this.insert(t);
			}
		}
		
	}

	public void fillWithoutRebalace(T[] array, T[] arrayAux, int comeco, int fim, int indice) {
		if (comeco <= fim) {
			int index = (int) ((comeco + fim) / 2);
			T aux = array[index];
			arrayAux[indice] = aux;
			fillWithoutRebalace(array, arrayAux, comeco, index - 1, (2 * indice) + 1);
			fillWithoutRebalace(array, arrayAux, index + 1, fim, (2 * indice) + 2);
		}
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
