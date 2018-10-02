package adt.linkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.queue.Queue;
import adt.queue.QueueDoubleLinkedListImpl;
import adt.queue.QueueOverflowException;
import adt.queue.QueueUnderflowException;

public class StudentQueueTest {
	
	private Queue<Integer> fila1;

	@Before
	public void test() {
		this.fila1 = new QueueDoubleLinkedListImpl<>(3);
	}
	
	@Test
	public void teste1() throws QueueOverflowException {
		this.fila1.enqueue(0);
		assertTrue(this.fila1.head() == 0);
	}
	
	@Test
	public void teste2() throws QueueOverflowException, QueueUnderflowException {
		this.fila1.enqueue(0);
		this.fila1.enqueue(1);
		this.fila1.enqueue(2);
		this.fila1.dequeue();
		this.fila1.dequeue();
		this.fila1.dequeue();
		try {
			this.fila1.dequeue();
		} catch(QueueUnderflowException e) {
			assertEquals("Fila vazia", e.getMessage());
		}
	}
	
	@Test
	public void teste3() throws QueueOverflowException {
		this.fila1.enqueue(0);
		this.fila1.enqueue(1);
		this.fila1.enqueue(2);
		try {
			this.fila1.enqueue(3);
			fail("Não deve chegar aqui");
		} catch(QueueOverflowException e) {
			assertEquals("Fila cheia", e.getMessage());
		}
	}
	
	@Test
	public void teste4() throws QueueOverflowException, QueueUnderflowException {
		this.fila1.enqueue(0);
		this.fila1.enqueue(1);
		this.fila1.enqueue(2);
		this.fila1.dequeue();
		assertTrue(this.fila1.head() == 1);
	}
	
	@Test
	public void teste5() throws QueueOverflowException, QueueUnderflowException {
		this.fila1.enqueue(0);
		this.fila1.enqueue(1);
		this.fila1.enqueue(2);
		this.fila1.dequeue();
		this.fila1.dequeue();
		this.fila1.dequeue();
		try {
			this.fila1.dequeue();
			fail("Nao deve chegar aqui");
		} catch (QueueUnderflowException e) {
			assertEquals("Fila vazia", e.getMessage());
		}
	}
}