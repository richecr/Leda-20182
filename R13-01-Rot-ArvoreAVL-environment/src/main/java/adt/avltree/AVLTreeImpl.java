package adt.avltree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * 
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements AVLTree<T> {

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	@SuppressWarnings("unchecked")
	@Override
	protected void insert(T element, BSTNode<T> node, BSTNode<T> parent) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode.Builder<T>().parent(node).build());
			node.setRight(new BSTNode.Builder<T>().parent(node).build());
			node.setParent(parent);
		} else {
			if (element.compareTo(node.getData()) < 0) {
				this.insert(element, (BSTNode<T>) node.getLeft(), node);
			} else {
				this.insert(element, (BSTNode<T>) node.getRight(), node);
			}
		}
		this.rebalance(node);
	}
	
	protected void remove(BSTNode<T> node) {
		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				node.setData(null);
				node.setLeft(null);
				node.setRight(null);
				this.rebalanceUp(node);
			} else if (oneChild(node)) {
				if (node != root) {
					if (node.getParent().getLeft() == node) {
						if (node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						} else {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						}
					} else {
						if (node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						} else {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						}
					}
				} else {
					if (root.getLeft().isEmpty())
						root = (BSTNode<T>) root.getRight();
					else {
						root = (BSTNode<T>) root.getLeft();
					}
					this.root.setParent(null);
				}
				this.rebalanceUp(node);
			} else {
				BSTNode<T> sucessor = sucessor(node.getData());
				node.setData(sucessor.getData());
				remove(sucessor);
			}
		}
	}

	// AUXILIARY
	protected int calculateBalance(BSTNode<T> node) {
		if (!node.isEmpty()) {
			return this.height((BSTNode<T>) node.getLeft()) - this.height((BSTNode<T>) node.getRight());
		}
		return 0;
	}

	// AUXILIARY
	protected void rebalance(BSTNode<T> node) {
		int balance = this.calculateBalance(node);
		if (Math.abs(balance) > 1) {
			if (balance > 0 && this.height((BSTNode<T>) node.getLeft()) > 0) {
				this.root.setLeft(this.rotateLeft((BSTNode<T>) node.getLeft()));
			} else if (balance < -1 && this.calculateBalance((BSTNode<T>) node.getRight()) <= 1) {
				this.root = this.rotateLeft(node);
			} else if (balance > 1 && this.calculateBalance((BSTNode<T>) node.getLeft()) < 1) {
				this.rotateLeft((BSTNode<T>) node.getLeft());
				this.root = this.rotateRight((BSTNode<T>) node);
			} else if (balance < -1 && this.calculateBalance((BSTNode<T>) node.getRight()) > -1) {
				this.rotateRight((BSTNode<T>) node.getRight());
				this.root = this.rotateLeft((BSTNode<T>) node);
			}
		}
	}

	// AUXILIARY
	protected void rebalanceUp(BSTNode<T> node) {
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		while (!parent.isEmpty()) {
			this.rebalance(parent);
			parent = (BSTNode<T>) parent.getParent();
		}
	}

	private BSTNode<T> rotateLeft(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getRight();
		node.setRight(pivot.getLeft());
		pivot.setLeft(node);
		return pivot;
	}

	private BSTNode<T> rotateRight(BSTNode<T> node) {
		BSTNode<T> pivot = (BSTNode<T>) node.getLeft();
		node.setLeft(pivot.getRight());
		pivot.setRight(node);
		return pivot;
	}

}