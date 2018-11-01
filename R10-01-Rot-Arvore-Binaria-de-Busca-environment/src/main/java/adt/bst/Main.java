package adt.bst;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		BSTImpl<Integer> bst = new BSTImpl<>();
		Integer[] array = { 6, 23, -34, 5, 9, 2, 0, 76, 12, 67, 232, -40 };
		for (int i : array) {
			bst.insert(i);
		}
		System.out.println(bst.maximum());
		bst.remove(6);
		System.out.println(bst.getRoot());
		
		System.out.println(Arrays.toString(bst.preOrder()));
		
		/*BSTImpl<Integer> bst = new BSTImpl<>();
		bst.insert(10);
		bst.insert(5);
		bst.insert(1);
		bst.insert(3);
		bst.insert(20);
		bst.insert(25);
		
		/*System.out.println(bst.search(15));
		System.out.println(bst.maximum());
		System.out.println(bst.minimum());
		System.out.println(Arrays.toString(bst.preOrder()));
		System.out.println(Arrays.toString(bst.order()));
		System.out.println(Arrays.toString(bst.postOrder()));
		System.out.println(bst.sucessor(50));
		System.out.println(bst.predecessor(-5));
		System.out.println(bst.height());
		
		bst.remove(10);
		System.out.println(Arrays.toString(bst.preOrder()));*/
	}

}
