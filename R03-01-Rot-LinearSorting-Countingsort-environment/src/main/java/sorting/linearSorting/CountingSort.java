package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

   @Override
   public void sort(Integer[] array, int leftIndex, int rightIndex) {
      int max = encontraMax(array, leftIndex, rightIndex);

      Integer[] result = new Integer[array.length];
      int[] aux = new int[max + 1];

      for (int i = 0; i < array.length; i++) {
         aux[array[i]]++;
      }

      for (int j = 1; j < aux.length; j++) {
         aux[j] += aux[j - 1];
      }

      for (int k = array.length - 1; k >= 0; k--) {
         aux[array[k]]--;
         result[aux[array[k]]] = array[k];
      }

      System.arraycopy(result, leftIndex, array, leftIndex, result.length);
   }

   private int encontraMax(Integer[] array, int leftIndex, int maxIndex) {
      int max = 0;

      for (int i = leftIndex; i <= maxIndex; i++) {
         if (array[i] > max) {
            max = array[i];
         }
      }

      return max;
   }
}
