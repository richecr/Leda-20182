
public class CountinSort {

	/**
	 * Metodo que utiliza o algoritmo CountingSort para ordenar um array de inteiros
	 * em um intervalo passado ou ele por inteiro. O array nao pode conter números
	 * negativos.
	 * 
	 * @param array Array para ser ordenado.
	 * @param left  Posicao inicial que voce quer ordenar o array.
	 * @param right posicao final que voce quer ordenar o array.
	 */
	public void sort(Integer[] array, int left, int right) {
		int maximo = this.acharMaximo(array, left, right);
		int[] c = new int[maximo + 1];
		int[] b = new int[array.length];

		/*
		 * Contando as ocorrencias dos numeros do array original e somando com seus
		 * respectivos indices(o proprio numero) no array c. Ex: Se no array original
		 * tem duas ocorrencias de 4, no array c no indice 4 vai ta 2.
		 */
		for (int i = left; i < array.length; i++) {
			c[array[i]]++;
		}

		/*
		 * Somando o numero atual com seu anterior, para garantir que o algoritmo seja
		 * estavel.
		 */
		for (int i = left + 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}

		/*
		 * Percorre o array original de tras pra frente pegando o numero, e o proprio
		 * numero é o indice no array c. Subtrai um do array c nessa posicao e então é
		 * adicionado no array b o valor(numero do array original).
		 */
		for (int i = right; i >= left; i--) {
			c[array[i]]--;
			b[c[array[i]]] = array[i];
		}

		// Copiando o resultado do array b para o array originaol.
		int index = 0;
		for (int i = left; i <= right; i++) {
			array[i] = b[index];
			index++;
		}
	}

	/**
	 * Metodo que utiliza o algoritmo CountingSort para ordenar um array de inteiros
	 * em um intervalo passado ou ele por inteiro. O array pode conter números
	 * negativos.
	 * 
	 * @param array Array para ser ordenado.
	 * @param left  Posicao inicial que voce quer ordenar o array.
	 * @param right posicao final que voce quer ordenar o array.
	 */
	public void sortMelhorado(Integer[] array, int left, int right) {
		int maximo = this.acharMaximo(array, left, right);
		int minimo = this.acharMinimo(array, left, right);

		int tamanho = maximo - minimo + 1;

		int[] c = new int[tamanho];
		int[] b = new int[array.length];
		// Para controlar na hora que for adicionar no array.
		int offset = minimo;

		/*
		 * Contando as ocorrencias dos numeros do array original e somando com seus
		 * respectivos indices(o proprio numero) no array c. Ex: Se no array original
		 * tem duas ocorrencias de 4, no array c no indice 4 vai ta 2.
		 */
		for (int i = left; i < array.length; i++) {
			c[array[i] - offset]++;
		}

		/*
		 * Somando o numero atual com seu anterior, para garantir que o algoritmo seja
		 * estavel.
		 */
		for (int i = left + 1; i < tamanho; i++) {
			c[i] += c[i - 1];
		}

		/*
		 * Percorre o array original de tras pra frente pegando o numero, e o proprio
		 * numero é o indice no array c. Subtrai um do array c nessa posicao e então é
		 * adicionado no array b o valor(numero do array original).
		 */
		for (int i = right; i >= left; i--) {
			c[array[i] - offset]--;
			b[c[array[i] - offset]] = array[i];
		}

		// Copiando o resultado do array b para o array originaol.
		int index = 0;
		for (int i = left; i <= right; i++) {
			array[i] = b[index];
			index++;
		}
	}

	/**
	 * Metodo que retorna o menor numero contido no array.
	 * 
	 * @param array Array de inteiros.
	 * @param left  Posicao inicial que voce quer que a busca comece.
	 * @param right Posicao final que voce quer que a busca acabe.
	 * @return O menor numero contido no array.
	 */
	private int acharMinimo(Integer[] array, int left, int right) {
		int minimo = array[left];
		for (int i = left + 1; i <= right; i++) {
			if (array[i] < minimo) {
				minimo = array[i];
			}
		}
		return minimo;
	}

	/**
	 * Metodo que retorna o maior numero contido no array.
	 * 
	 * @param array Array de inteiros.
	 * @param left  Posicao inicial que voce quer que a busca comece.
	 * @param right Posicao final que voce quer que a busca acabe.
	 * @return O maior numero contido no array.
	 */
	private int acharMaximo(Integer[] array, int left, int right) {
		int maximo = array[left];
		for (int i = left + 1; i <= right; i++) {
			if (array[i] > maximo) {
				maximo = array[i];
			}
		}
		return maximo;
	}
}
