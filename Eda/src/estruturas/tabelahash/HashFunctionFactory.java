package estruturas.tabelahash;

import estruturas.tabelahash.hashImplClosed.HashFunctionClosedAddressMethod;
import estruturas.tabelahash.hashMultiplicacao.HashFunctionMultiplicationMethod;
import estruturas.tabelahash.hashdivisao.HashFunctionDivisionMethod;

public class HashFunctionFactory<T> {

	public static HashFunction createHashFunction(HashFunctionClosedAddressMethod method, int tableSize) {
		HashFunction result = null;
		switch (method) {
			case DIVISION:
				result = new HashFunctionDivisionMethod(tableSize);
			case MULTIPLICATION:
				result = new HashFunctionMultiplicationMethod(tableSize);
		}
		return result;
	}
}
