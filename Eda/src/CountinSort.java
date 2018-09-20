
public class CountinSort {
	
	public void sort(Integer[] array, int left, int right) {
		int maximo = this.acharMaximo(array, left, right);
		int[] c = new int[maximo+1];
		int[] b = new int[array.length];
		
		for (int i = left; i < array.length; i++) {
			c[array[i]]++;
		}
		
		for (int i = left+1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		
		for (int i = right; i >= left; i--) {
			c[array[i]]--;
			b[c[array[i]]] = array[i];
		}
		// COPIANDO.
		int index = 0;
		for (int i = left; i <= right; i++) {
			array[i] = b[index];
			index++;
		}
	}
	
	public void sortMelhorado(Integer[] array, int left, int right) {
		int maximo = this.acharMaximo(array, left, right);
		int minimo = this.acharMinimo(array, left, right);
		
		int tamanho = maximo - minimo + 1;
		
		int[] c = new int[tamanho];
		int[] b = new int[array.length];
		int offset = minimo;
		
		for (int i = left; i < array.length; i++) {
			c[array[i] - offset]++;
		}
		
		for (int i = left+1; i < tamanho; i++) {
			c[i] += c[i - 1];
		}
		
		for (int i = right; i >= left; i--) {
			c[array[i] - offset]--;
			b[c[array[i] - offset]] = array[i];
		}
		
		// COPIANDO.
		int index = 0;
		for (int i = left; i <= right; i++) {
			array[i] = b[index];
			index++;
		}
	}

	private int acharMinimo(Integer[] array, int left, int right) {
		int minimo = array[left];
		for (int i = left+1; i <= right; i++) {
			if (array[i] < minimo) {
				minimo = array[i];
			}
		}
		return minimo;
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
