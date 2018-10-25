package adt.linkedList;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		SingleLinkedListImpl<Integer> l1 = new SingleLinkedListImpl<>();
		l1.insert(1);
		l1.insert(1);
		l1.insert(4);
		l1.insert(7);
		
		SingleLinkedListImpl<Integer> l2 = new SingleLinkedListImpl<>();
		l2.insert(-5);
		l2.insert(0);
		l2.insert(7);
		l2.insert(8);
		l2.insert(10);
		
		l1.merge2(l1, l2);
		System.out.println(Arrays.toString(l1.toArray()));
		
		/*SingleLinkedListImpl<Integer> l3 = new SingleLinkedListImpl<>();
		l3.insert(1);
		l3.insert(2);
		l3.insert(4);
		l3.insertOrdenado(0);
		l3.insertOrdenado(3);
		l3.insertOrdenado(5);
		System.out.println(Arrays.toString(l3.toArray()));*/
		
	}
	
}
