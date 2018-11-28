package adt.avltree;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		AVLCountAndFillImpl<Integer> tree = new AVLCountAndFillImpl<Integer>();
		Integer[] array = { 0,1,2,3,4,5,6,7,8,9 };

		tree.fillWithoutRebalance(array);
		
		//System.out.println(Arrays.toString(tree.preOrder()));
		
		assertEquals(0, tree.LLcount());
		assertEquals(0, tree.RRcount());
		assertEquals(0, tree.LRcount());
		assertEquals(0, tree.RLcount());
		
		System.out.println(tree.getRoot());
		
	}
}
