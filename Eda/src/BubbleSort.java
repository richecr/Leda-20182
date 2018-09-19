
public class BubbleSort<T extends Comparable> implements Sorting<T> {

	public void sort(T[] array, int left, int right) {
		boolean ordenado = false;
		while(!ordenado) {
			ordenado = true;
			for (int i = left; i < right-1; i++) {
				if (array[i].compareTo(array[i+1]) > 0) {
					this.swap(array, i, i+1);
					ordenado = false;
				}
			}
		}
	}
	
	public void sortRecursivo(T[] array) {
		this.sortRecursivo(array, array.length);
	}
	
	private void sortRecursivo(T[] array, int n) {
		// CASO BASE.
		if (n == 0) {
			return;
		}
		for (int i = 0; i < n-1; i++) {
			if ((array[i].compareTo(array[i+1])) > 0) {
				this.swap(array, i, i+1);
			}
		}
		sortRecursivo(array, n-1);
	}

	public void swap(T[] array, int i, int j) {
		T res = array[i];
		array[i] = array[j];
		array[j] = res;
	}
}
