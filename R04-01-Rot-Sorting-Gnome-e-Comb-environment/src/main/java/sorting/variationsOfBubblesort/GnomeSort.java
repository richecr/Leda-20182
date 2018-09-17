package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * The implementation of the algorithm must be in-place!
 */
public class GnomeSort<T extends Comparable<T>> extends AbstractSorting<T> {
	
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		int pos = leftIndex + 1;
		while (pos <= rightIndex) {
			if (array[pos].compareTo(array[pos - 1]) >= 0) {
				pos++;
			} else {
				Util.swap(array, pos, pos - 1);

				if (pos > leftIndex + 1) {
					pos--;
				} else {
					pos++;
				}
			}
		}
	}
}
