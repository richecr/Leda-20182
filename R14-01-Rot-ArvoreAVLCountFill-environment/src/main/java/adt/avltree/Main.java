package adt.avltree;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		AVLCountAndFillImpl<Integer> tree = new AVLCountAndFillImpl<Integer>();
		Integer[] array = { 4, 8, 12, 2, 6, 10, 14, 1, 3, 5, 7, 9, 11, 13, 15 };

		tree.fillWithoutRebalance(array);
		
		assertEquals(0, tree.LLcount());
		assertEquals(0, tree.RRcount());
		assertEquals(0, tree.LRcount());
		assertEquals(0, tree.RLcount());
		
		System.out.println(Arrays.toString(tree.preOrder()) + " -");
		
	}
}
