package estruturas.tabelahash.hashdivisao;

import estruturas.tabelahash.hashclosed.HashFunctionClosedAddress;

public class HashFunctionDivisionMethod<T> implements HashFunctionClosedAddress<T> {

	protected int tableSize;
	
	public HashFunctionDivisionMethod(int size) {
		this.tableSize = size;
	}
	
	@Override
	public int hash(T element) {
		int hashKey = -1;
		int key = element.hashCode();
		hashKey = (int) key % tableSize;
		return hashKey;
	}

}
