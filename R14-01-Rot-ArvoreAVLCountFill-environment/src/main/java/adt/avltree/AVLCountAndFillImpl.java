package adt.avltree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
