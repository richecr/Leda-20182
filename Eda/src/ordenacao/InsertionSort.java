package ordenacao;

public class InsertionSort<T extends Comparable> implements Sorting<T> {

	public void sort(T[] array, int left, int right) {
		for (int i = left+1; i < right; i++) {
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
		this.sortRecursivo(array, 0);
	}
	
	private void sortRecursivo(T[] array, int comeco) {
		// CASO BASE
	    if (comeco == array.length-1)
	        return;
	    T key = array[comeco+1];
	    int j = comeco;
	    while((j >= 0) && (array[comeco].compareTo(key) > 0)){
	    	array[j+1] = array[j];
	    	j--;
	    }
	    array[j+1] = key;
	    sortRecursivo(array, ++comeco);
	}

	public void swap(T[] array, int i, int j) {
		T res = array[i];
		array[i] = array[j];
		array[j] = res;
	}
}
