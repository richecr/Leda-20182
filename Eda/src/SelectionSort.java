
public class SelectionSort<T extends Comparable> implements Sorting<T> {

	public void sort(T[] array, int left, int right) {
		for (int i = left; i < right; i++) {
			int min = i;
			for (int j = i+1; j < right; j++) {
				if (array[j].compareTo(array[min]) < 0) {
					min = j;
				}
			}
			this.swap(array, i, min);
		}
	}
	
	public void sortRecursivo(T[] array) {
		this.sortRecursivo(array, 0);
	}
	
	private void sortRecursivo(T[] array, int comeco) {
		if (comeco == array.length) {
			return;
		}
		int min = comeco;
		for (int i = comeco; i < array.length; i++) {
			if (array[i].compareTo(array[min]) < 0) {
				min = i;
			}
		}
		this.swap(array, comeco, min);
		this.sortRecursivo(array, ++comeco);
	}

	public void swap(T[] array, int i, int j) {
		T res = array[i];
		array[i] = array[j];
		array[j] = res;
	}
}
