package estruturas.tabelahash;

public interface HashFunctionClosedAddress<T> extends HashFunction<T> {

	public int hash(T element);
	
}
