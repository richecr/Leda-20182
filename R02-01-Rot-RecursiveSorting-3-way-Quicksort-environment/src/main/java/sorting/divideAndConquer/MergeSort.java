package sorting.divideAndConquer;

import java.util.LinkedList;
import java.util.List;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int meio = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, meio);
			sort(array, meio+1, rightIndex);
			
			merge(array, leftIndex, meio, rightIndex);
		}
	}
	
	private void merge(T[] array, int leftIndex, int meio, int rightIndex) {
		int limite1 = meio - leftIndex;
		int limite2 = rightIndex - meio;
		
		List<T> lista1 = new LinkedList<T>();
		List<T> lista2 = new LinkedList<T>();
		
		// Copiando itens.
		for (int i = 0; i <= limite1; i++) {
			lista1.add(array[leftIndex + i]);
		}
		
		for (int i = 0; i < limite2; i++) {
			lista2.add(array[meio + 1 + i]);
		}
		
		int i = 0;
		int j = 0;
		int k = leftIndex;
		// Comparando as objetos das duas listas e organizando corretamente no array original.
		while(i <= limite1 && j < limite2) {
			if (lista1.get(i).compareTo(lista2.get(j)) < 0) {
				array[k] = lista1.get(i);
				i++;
			} else {
				array[k] = lista2.get(j);
				j++;
			}
			k++;
		}
		
		// Adiconando os objetos que faltam da lista1 no array original.
		while (i <= limite1) {
			array[k] = lista1.get(i);
			i++;
			k++;
		}
		
		// Adiconando os objetos que faltam da lista2 no array original.
		while (j < limite2) {
			array[k] = lista2.get(j);
			j++;
			k++;
		}
	}
}