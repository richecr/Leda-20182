package adt.linkedList;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		RecursiveDoubleLinkedListImpl<Integer> l = new RecursiveDoubleLinkedListImpl<>();
		
		l.insert(0);
		l.insert(1);
		l.insert(2);
		l.insert(3);
		l.insert(4);
		l.insert(5);
		l.insertFirst(-5);
		System.out.println(Arrays.toString(l.toArray()));
		
	}
	
}
