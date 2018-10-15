package estruturas.tabelahash.hashImplClosed;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

import estruturas.tabelahash.HashFunction;
import estruturas.tabelahash.HashFunctionFactory;
import estruturas.tabelahash.Util;
import estruturas.tabelahash.hashclosed.AbstractHashtableClosedAddress;
import estruturas.tabelahash.hashclosed.HashFunctionClosedAddress;

public class HashtableClosedAddressImpl<T> extends AbstractHashtableClosedAddress<T> {

	public HashtableClosedAddressImpl(int desiredSize, HashFunctionClosedAddressMethod method) {
			int realSize = desiredSize;
			if(method == HashFunctionClosedAddressMethod.DIVISION){
				realSize = this.getPrimeAbove(desiredSize);
			}
			initiateInternalTable(realSize);
			HashFunction function = HashFunctionFactory.createHashFunction(method,realSize);
			this.hashFunction = function;
	}
	
	public int getPrimeAbove(int number){
		int i = number+1;
		boolean continua = true;
		while (continua) {
			if (Util.isPrime(i)) {
				continua = false;
			} else {
				i++;
			}
		}
		return i;
	}
	
	@Override
	public void insert(T element) {
		LinkedList<T> lista = (LinkedList<T>) this.table[((HashFunctionClosedAddress<T>) this.hashFunction).hash(element)];
		if (lista == null) {
			this.table[((HashFunctionClosedAddress<T>) this.hashFunction).hash(element)] = new LinkedList<T>();
		}
		((LinkedList<T>) this.table[((HashFunctionClosedAddress<T>) this.hashFunction).hash(element)]).add(element);
	}

	@Override
	public void remove(T element) {
		((LinkedList<T>) this.table[((HashFunctionClosedAddress<T>) this.hashFunction).hash(element)]).remove(element);
	}

	@Override
	public T search(T element) {
		int aux = this.indexOf(element);
		T res = null;
		
		Iterator<T> auxiliar = ((LinkedList<T>) this.table[aux]).iterator();
		while(auxiliar.hasNext()) {
			T type = (T) auxiliar.next();
			if (type.equals(element)) {
				res = type;
			}
		}
		return res;
	}
	
	public String toString() {
		return Arrays.toString(this.table);
	}

	@Override
	public int indexOf(T element) {
		int res = ((HashFunctionClosedAddress<T>) this.hashFunction).hash(element);
		return res;
	}
}
