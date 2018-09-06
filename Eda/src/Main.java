import java.util.Arrays;
import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		
		Integer[] array = {4, 5, 3, 2, 7, 1, -4};
		Sorting b = new InsertionSort<Integer>();
		
		b.sortRecursivo(array);
		System.out.println(Arrays.toString(array));
	}

	private static void moveImpostor(int[] array) {
		int indImpostor = achaImpostor(array);
		if (indImpostor != -1) {
			for (int i = indImpostor; i > 0; i--) {
				if (array[i] < array[i-1]) {
					int res = array[i];
					array[i] = array[i-1];
					array[i-1] = res;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}
	
	private static int achaImpostor(int[] array) {
	    int res= -1;
		int i = 0;
		boolean achou = false;
		while (i < array.length - 1 && !achou) {
			if (array[i] > array[i+1]) {
				res = i+1;
				achou = true;
			}
			i++;
		}
		return res;
	}
	
	private static boolean temRepetido(String[] array) {
		boolean repete = false;
		for (int i = 0; i < array.length; i++) {
			int j = i+1;
			while ((j < array.length) && !repete) {
				if (array[i].equals(array[j])) {
					repete = true;
				}
				j++;
			}
		}
		return repete;
	}
}
