package estruturas.tabelahash.impl;

import estruturas.tabelahash.AbstractHashtable;
import estruturas.tabelahash.hashImplClosed.HashFunctionClosedAddressMethod;
import estruturas.tabelahash.hashImplClosed.HashtableClosedAddressImpl;

public class Main {

	public static void main(String[] args) {
		HashtableClosedAddressImpl<Integer> hash = new HashtableClosedAddressImpl<Integer>(20, HashFunctionClosedAddressMethod.DIVISION);
		hash.insert(0);
		hash.insert(10);
		hash.insert(10);
		hash.insert(20);
		hash.insert(30);
		hash.insert(40);
		hash.remove(10);
		hash.remove(10);
		System.out.println(hash.search(10));
		
		System.out.println(hash.search(20));
		hash.remove(20);
		System.out.println(hash.toString());
	}

}
