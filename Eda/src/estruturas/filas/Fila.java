package estruturas.filas;

import java.util.Arrays;

import estruturas.exceptions.*;

public class Fila<T> implements Queue<T> {

	private int tail;
	private int calda;
	private int tamanho;
	private T[] elementos;
	
	public Fila(int tamanho) {
		this.tail = -1;
		this.calda = 0;
		this.tamanho = tamanho;
		this.elementos = (T[]) new Comparable[this.tamanho];
	}
	
	@Override
	public void enqueue(T e) throws QueueOverflowException {
		if (this.isFull()) {
			throw new QueueOverflowException();
		}
		if (this.tail == this.tamanho-1) {
			this.tail = -1;
		}
		this.tail++;
		this.elementos[this.tail] = e;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (this.isEmpty()) {
			throw new QueueUnderflowException();
		}
		T res = this.elementos[this.calda];
		this.elementos[this.calda] = null;
		if (this.calda == this.tamanho-1) {
			this.calda = 0;
		} else {
			this.calda++;
		}
		//this.shift();
		return res;
	}

	@Override
	public T head() {
		return this.elementos[this.calda];
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return false;
		//return this.tail == this.calda;
	}
	
	private void shift() {
		for (int i = this.calda; i < this.tail; i++) {
			swap(i, i++);
		}
		this.tail--;
	}
	
	private void swap(int i, int j) {
		this.elementos[i] = this.elementos[j];
		this.elementos[j] = null;
	}
	
	public String toString() {
		return Arrays.toString(this.elementos);
	}
}