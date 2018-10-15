package estruturas.tabelahash.hashclosed;

import java.util.LinkedList;

import estruturas.tabelahash.AbstractHashtable;
import estruturas.tabelahash.Util;

public abstract class AbstractHashtableClosedAddress<T> extends AbstractHashtable<T> {

	public AbstractHashtableClosedAddress(){
		super();
	}
	
	@Override
	protected void initiateInternalTable(int size){
		this.table = Util.<LinkedList<T>>makeArray(size);
	}

}
