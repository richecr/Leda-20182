package estruturas.tabelahash.hashclosed;

import estruturas.tabelahash.HashFunction;

public interface HashFunctionClosedAddress<T> extends HashFunction<T> {

	public int hash(T element);
	
}
