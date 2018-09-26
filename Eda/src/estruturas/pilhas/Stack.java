package estruturas.pilhas;

import estruturas.*;

public interface Stack<T> {
	
	public void push(T e) throws StackOverflowException;
	public T pop() throws StackUnderflowException;
	public T top();
	public boolean isEmpty();
	public boolean isFull();

}
