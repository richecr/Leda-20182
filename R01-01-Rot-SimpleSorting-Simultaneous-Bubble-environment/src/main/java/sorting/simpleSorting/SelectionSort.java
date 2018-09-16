package sorting.simpleSorting;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i <= rightIndex; i++) {
			int menor = i;
			for (int j = i; j <= rightIndex; j++) {
				if (array[j].compareTo(array[menor]) < 0) {
					menor = j;
				}
			}
			Util.swap(array, i, menor);
		}
	}
	
    public void sortMaiorEMenor(T[] array, int leftIndex, int rightIndex) {
	    int i = leftIndex;
	    int fim = rightIndex;
	    while (i <= fim) {
	    	int min = i;
	    	int maior = fim;
	    	for (int j = i; j <= fim; j++) {
	    		if (array[j].compareTo(array[min]) < 0) {
				    min = j;
				}
			    if (array[j].compareTo(array[maior]) > 0) {
			    	maior = j;
			    }
			}
	    	if (maior == i) {
	    		Util.swap(array, i, min);
	    		maior = min;
	    	} else {
	    		Util.swap(array, i, min);
	    	}
	    	Util.swap(array, fim, maior);
		    i++;
		    fim--;
	    }
	}
	
	public static void main(String[] args) {
		SelectionSort<Integer> a = new SelectionSort<>();
		Integer[] b = {6, 41, 32, 7, 26, 4, 37, 49, 11, 18, 36};
		a.sortMaiorEMenor(b, 1, 5);
		System.out.println(Arrays.toString(b));
	}
}
