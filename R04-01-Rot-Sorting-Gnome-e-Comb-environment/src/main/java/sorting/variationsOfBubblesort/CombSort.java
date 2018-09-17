package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The combsort algoritm.
 */
public class CombSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int gap = rightIndex - leftIndex + 1;
		boolean swapped = false;

		while (gap >= 1) {
			gap = (int) (gap / 1.25);

			if (gap < 1) {
				gap = 1;
			}

			swapped = false;
			int i = 0;

			while ((i + gap) <= rightIndex) {
				if (array[i].compareTo(array[i + gap]) > 0) {
					Util.swap(array, i, i + gap);
					swapped = true;
				}
				i++;
			}

			if (gap == 1 && !swapped) {
				gap = 0;
			}
		}
	}
}
