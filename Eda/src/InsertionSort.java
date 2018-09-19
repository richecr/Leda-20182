
public class InsertionSort<T extends Comparable> implements Sorting<T> {

	public void sort(T[] array, int left, int right) {
		 for (int i = left+1; i <= right; i++) {
			T key = array[i];
			int j = i - 1;
			while((j >= 0) && (array[j].compareTo(key) > 0)) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = key;
		}
	}
	
	public void sortRecursivo(T[] array) {
		this.sortRecursivo(array, array.length);
	}
	
	private void sortRecursivo(T[] array, int n) {
	    if (n <= 1)
	        return;
	 
	    sortRecursivo(array, n-1);

	    T ultimo = array[n-1];
	    int j = n-2;
	 
	    while (j >= 0 && array[j].compareTo(ultimo) > 0) {
	    	array[j+1] = array[j];
	        j--;
	    }
	    array[j+1] = ultimo;
	}

	public void swap(T[] array, int i, int j) {
		T res = array[i];
		array[i] = array[j];
		array[j] = res;
	}
}
