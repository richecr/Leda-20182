
public class InsertionSort<T extends Comparable> implements Sorting<T> {

	public void sort(T[] array, int right, int left) {
		 for (int i = right; i < left - 1; i++) {
	        int index = i;
	        for (int j = i + 1; j < left; j++) {
	            if (array[j].compareTo(array[index]) < 0) { 
	                index = j;
	            }
	        }
	        this.swap(array, index, i);
		 }
	}
	
	public void sortRecursivo(T[] array) {
		this.sortRecursivo(array, 0);
	}
	
	private void sortRecursivo(T[] array, int n) {
		if (n == array.length-1) {
			return;
		}
		int index = n;
		for (int j = index+1; j < array.length; j++) {
			if (array[j].compareTo(array[index]) < 0) { 
                index = j;
            }
		}
		this.swap(array, n, index);
		this.sortRecursivo(array, n+1);
	}

	public void swap(T[] array, int i, int j) {
		T res = array[i];
		array[i] = array[j];
		array[j] = res;
	}
}
