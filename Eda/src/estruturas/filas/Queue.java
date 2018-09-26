package estruturas.filas;

import estruturas.exceptions.*;

public interface Queue<T> {
	
	public void enqueue(T e) throws QueueOverflowException;
	
	public T dequeue() throws QueueUnderflowException;
	
	public T head();
	
	public boolean isEmpty();
	
	public boolean isFull();

}
