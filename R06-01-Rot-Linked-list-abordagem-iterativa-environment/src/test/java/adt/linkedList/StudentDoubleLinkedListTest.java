package adt.linkedList;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;
	private LinkedList<Integer> lista4;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista3.insert(1);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new DoubleLinkedListImpl<>();
		lista2 = new DoubleLinkedListImpl<>();
		lista3 = new DoubleLinkedListImpl<>();
		lista4 = new DoubleLinkedListImpl<>();
	}

	@Test
	public void teste1() {
		this.lista4.insert(1);
		((DoubleLinkedList<Integer>) this.lista4).insertFirst(0);
		assertArrayEquals(new Integer[] {0, 1}, this.lista4.toArray());
	}
	
	@Test
	public void teste2() {
		((DoubleLinkedList<Integer>) this.lista4).insertFirst(0);
		this.lista4.insert(1);
		((DoubleLinkedList<Integer>) this.lista4).removeFirst();
		assertArrayEquals(new Integer[] {1}, this.lista4.toArray());
	}
	
	@Test
	public void teste3() {
		this.lista4.insert(1);
		this.lista4.insert(2);
		this.lista4.insert(3);
		((DoubleLinkedList<Integer>) this.lista4).insertFirst(0);
		((DoubleLinkedList<Integer>) this.lista4).removeFirst();
		((DoubleLinkedList<Integer>) this.lista4).removeLast();
		((DoubleLinkedList<Integer>) this.lista4).remove(2);
		System.out.println(Arrays.toString(this.lista4.toArray()));
		
		assertArrayEquals(new Integer[] {1}, this.lista4.toArray());
	}
	
	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
	}
}