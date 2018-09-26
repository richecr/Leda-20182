package estruturas.pilhas;

import estruturas.exceptions.StackOverflowException;
import estruturas.exceptions.StackUnderflowException;

public class Pilha<T> implements Stack<T>{

	private int top;
	private int tamanho;
	private T[] elementos;
	
	public Pilha(int tamanho) {
		this.top = -1;
		this.tamanho = tamanho;
		this.elementos = (T[]) new Comparable[this.tamanho];
	}
	
	@Override
	public void push(T e) throws StackOverflowException {
		if (this.isFull()) {
			throw new StackOverflowException();
		}
		this.top++;
		this.elementos[top] = e;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new StackUnderflowException();
		}
		T res = this.elementos[this.top];
		this.elementos[this.top] = null;
		this.top--;
		return res;
	}

	@Override
	public T top() {
		return this.elementos[this.top];
	}

	@Override
	public boolean isEmpty() {
		boolean vazia = true;
		if (this.top >= 0) {
			vazia = false;
		}
		return vazia;
	}

	@Override
	public boolean isFull() {
		boolean full = false;
		if (this.top == this.tamanho-1) {
			full = true;
		}
		return full;
	}

}
