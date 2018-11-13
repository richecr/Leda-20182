package adt.avltree;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		AVLCountAndFillImpl<Integer> tree = new AVLCountAndFillImpl<Integer>();
		Integer[] array = {10, 50, 40, 7, -5};
		tree.fillWithoutRebalance(array);
		
	}
}
