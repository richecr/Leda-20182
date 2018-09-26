package ordenacao;

public class BucketSort {

	public void sort(Integer[] array, int left, int right) {
		int maximo = this.acharMaximo(array, left, right);
		int[] bucket = new int[maximo+1];
	 
	    for (int i = left; i <= right; i++) {
	    	bucket[array[i]]++;
	    }
	 
	    int outPos=left;
	    for (int i = 0; i < bucket.length; i++) {
	       for (int j = 0; j < bucket[i]; j++) {
	    	   array[outPos++] = i;
	       }
	    }
	}
	
	private int acharMaximo(Integer[] array, int left, int right) {
		int maximo = array[left];
		for (int i = left+1; i <= right; i++) {
			if (array[i] > maximo) {
				maximo = array[i];
			}
		}
		return maximo;
	}
	
}
