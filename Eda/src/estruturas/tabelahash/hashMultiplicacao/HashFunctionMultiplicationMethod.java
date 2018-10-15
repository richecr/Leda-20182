package estruturas.tabelahash.hashMultiplicacao;

import estruturas.tabelahash.HashFunctionClosedAddress;

public class HashFunctionMultiplicationMethod<T> implements HashFunctionClosedAddress<T> {

	protected int tableSize;
	private static final double A = (Math.sqrt(5)-1)/2; 
	
	public HashFunctionMultiplicationMethod(int tableSize){
		this.tableSize = tableSize;
	}

	
	@Override
	public int hash(T element) {
		int hashKey = -1;
		int key = element.hashCode();
		double fractionalPart = key*A - Math.floor(key*A);
		hashKey = (int) (tableSize * fractionalPart);;
		return hashKey;
	}

}
