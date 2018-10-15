package estruturas.tabelahash;

import java.util.LinkedList;

public abstract class AbstractHashtableClosedAddress<T> extends AbstractHashtable<T> {

	public AbstractHashtableClosedAddress(){
		super();
	}
	
	@Override
	protected void initiateInternalTable(int size){
		this.table = Util.<LinkedList<T>>makeArray(size);
	}

}
