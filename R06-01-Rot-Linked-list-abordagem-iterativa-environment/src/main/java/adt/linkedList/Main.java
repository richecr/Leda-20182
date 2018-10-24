package adt.linkedList;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		SingleLinkedListImpl<Integer> l1 = new SingleLinkedListImpl<>();
		l1.insert(1);
		l1.insert(1);
		l1.insert(4);
		l1.insert(5);
		
		SingleLinkedListImpl<Integer> l2 = new SingleLinkedListImpl<>();
		l2.insert(-5);
		l2.insert(0);
		l2.insert(4);
		l2.insert(8);
		
		l1.merge(l1, l2);
		System.out.println(Arrays.toString(l1.toArray()));
	}

}
