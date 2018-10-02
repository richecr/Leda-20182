package estruturas.linkedlist.linkedsimples;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		
		LinkedList<Integer> lista = new Linked<Integer>();
		
		lista.insert(0);
		lista.insert(1);
		lista.insert(2);
		lista.insert(3);
		System.out.println(Arrays.toString(lista.toArray()));
		System.out.println("-------------");
		System.out.println(lista.search(1));
		System.out.println(lista.search(200));
		
		lista.remove(2);
		lista.remove(0);
		lista.remove(1);
		lista.insert(50);
		System.out.println(Arrays.toString(lista.toArray()));
		System.out.println("MAIOR: " + lista.maiorElemento());
		
	}
}
