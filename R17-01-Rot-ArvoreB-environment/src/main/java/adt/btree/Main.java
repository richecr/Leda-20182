package adt.btree;

public class Main {

	public static void main(String[] args) {
		BTreeImpl<Integer> b = new BTreeImpl<>(3);
		b.insert(10);
		b.insert(11);
		b.insert(12);
		b.insert(13);
		b.insert(5);
		b.insert(6);
		b.insert(9);
		b.insert(4);
		
		System.out.println(b.search(13).node);
	}

}
