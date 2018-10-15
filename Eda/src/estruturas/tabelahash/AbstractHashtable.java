package estruturas.tabelahash;

public abstract class AbstractHashtable<T> implements Hashtable<T> {

	protected Object[] table;
	protected int elements;
	protected int collisions;
	protected HashFunction<T> hashFunction;
	
	public AbstractHashtable(){
		this.elements = 0;
		this.collisions = 0;
	}
	
	protected void initiateInternalTable(int size){
		this.table = Util.<T>makeArray(size);
		}
	
	@Override
	public boolean isEmpty() {
		return (elements == 0);
	}
	
	@Override
	public boolean isFull() {
		return (elements == table.length);
	}
	
	@Override
	public int size() {
		return elements;
	}
	
	@Override
	public int capacity(){
		return this.table.length;
	}
	
	public int getCOLLISIONS() {
		return this.collisions;
	}

	
}
