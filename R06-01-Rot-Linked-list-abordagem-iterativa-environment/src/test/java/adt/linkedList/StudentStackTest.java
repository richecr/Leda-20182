package adt.linkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import adt.stack.Stack;
import adt.stack.StackDoubleLinkedListImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class StudentStackTest {

	private Stack<Integer> pilha;
	
	@Before
	public void test() {
		this.pilha = new StackDoubleLinkedListImpl<>(3);
	}
	
	@Test
	public void teste1() throws StackOverflowException {
		this.pilha.push(0);
		this.pilha.push(1);
		this.pilha.push(2);
		assertTrue(this.pilha.top() == 2);
	}
	
	@Test
	public void teste2() throws StackOverflowException, StackUnderflowException {
		this.pilha.push(0);
		this.pilha.push(1);
		this.pilha.push(2);
		this.pilha.pop();
		assertTrue(this.pilha.top() == 1);
	}
	
	@Test
	public void teste3() throws StackOverflowException {
		this.pilha.push(0);
		this.pilha.push(1);
		this.pilha.push(2);
		try {
			this.pilha.push(3);
		} catch(StackOverflowException e) {
			assertEquals("Stack is full", e.getMessage());
		}
	}
	
	@Test
	public void teste4() throws StackOverflowException, StackUnderflowException {
		this.pilha.push(0);
		this.pilha.push(1);
		this.pilha.push(2);
		this.pilha.pop();
		this.pilha.pop();
		this.pilha.pop();
		try {
			this.pilha.pop();
			fail("Nao deve chegar aqui");
		} catch(StackUnderflowException e) {
			assertEquals("Stack is empty", e.getMessage());
		}
	}
}
