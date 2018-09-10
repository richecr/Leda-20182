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
			int m = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, m);
			sort(array, m + 1, rightIndex);
			
			mergeSort(array, leftIndex, m, rightIndex);
		}
	}
	
	public void mergeSort(T[] array, int left, int middle, int right) {
		int limite1 = middle - left;
		int limite2 = right - middle;
		
		List<T> lista1 = new LinkedList<T>();
		List<T> lista2 = new LinkedList<T>();
		
		for (int i = 0; i <= limite1; i++) {
			lista1.add(array[left + i]);
		}
		
		for (int i = 0; i < limite2; i++) {
			lista2.add(array[middle + 1 + i]);
		}
		
		int i = 0;
		int j = 0;
		int k = left;
		
		while (i <= limite1 && j < limite2) {
			if (lista1.get(i).compareTo(lista2.get(j)) < 0) {
				array[k] = lista1.get(i);
				i++;
			} else {
				array[k] = lista2.get(j);
				j++;
			}
			k++;
		}
		
		while(i <= limite1) {
			array[k] = lista1.get(i);
			i++;
			k++;
		}
		
		while(j < limite2) {
			array[k] = lista2.get(j);
			j++;
			k++;
		}
	}
	
}
