package estruturas.pilhas;

import estruturas.*;
import estruturas.exceptions.StackOverflowException;
import estruturas.exceptions.StackUnderflowException;

public interface Stack<T> {
	
	public void push(T e) throws StackOverflowException;
	public T pop() throws StackUnderflowException;
	public T top();
	public boolean isEmpty();
	public boolean isFull();

}
