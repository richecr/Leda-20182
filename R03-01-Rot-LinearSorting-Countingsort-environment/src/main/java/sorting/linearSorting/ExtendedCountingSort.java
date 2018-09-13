package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (rightIndex - leftIndex > 0) {
			int max = encontraMax(array, leftIndex, rightIndex);
			int min = encontraMin(array, leftIndex, rightIndex);
			
			int tamanho = max - min + 1;
			
			Integer[] result = new Integer[array.length];
			int[] aux = new int[tamanho];
			int offset = min;
			
			for(int i = 0; i < array.length; i++) {
				aux[array[i] - offset]++;
			}
			
			for(int i = 1; i < tamanho; i++) {
				aux[i] += aux[i - 1];
			}
			
			for(int k = array.length - 1; k >= 0; k--) {
				aux[array[k] - offset]--;
				result[aux[array[k] - offset]] = array[k];
			}
		
			System.arraycopy(result, leftIndex, array, leftIndex, result.length);
		}
	}
	
	private int encontraMax(Integer[] array, int leftIndex, int rightIndex) {
		int max = 0;
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			if(array[i] > max) {
				max = array[i];
			}
		}
		
		return max;
	}
	
	private int encontraMin(Integer[] array, int leftIndex, int rightIndex) {
		int min = array[0];
		
		for (int i = leftIndex; i <= rightIndex; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		
		return min;
	}

}
