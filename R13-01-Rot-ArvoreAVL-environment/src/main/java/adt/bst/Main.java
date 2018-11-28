package adt.bst;

public class Main {

	public static void main(String[] args) {
		BSTImpl<Integer> b = new BSTImpl<>();
		
		b.insert(10);
		b.insert(5);
		b.insert(4);
		b.insert(2);
		b.insert(12);
		b.insert(14);
		b.insert(16);
		
		System.out.println(b.k_esimo(3));
	}
	
}
