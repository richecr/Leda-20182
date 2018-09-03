package recursao;

public class MetodosRecursivos {

	public static void main(String[] args) {
		System.out.println(potenciaDe2(6));
	}
	
	public int calcularSomaArray(int[] array){
		int result = 0;
		// TODO ESCREVA AQUI O CÓDIGO (USANDO RECURSAO) PARA CALCULAR A SOMA
		// DOS EMENTOS DE UM ARRAY
		return result;
	}
	public static long calcularFatorial(int n) {
		long result = 1;
		if (n == 0) {
			result = 1;
			System.out.println(n + "! = " + result);
		} else {
			result = n * calcularFatorial(n-1);
			System.out.println(n + "! = " + result);
		}
		return result;
	}

	public static int calcularFibonacci(int n) {
		int result = 1;
		if (n <= 2) {
			result = 1;
		} else {
			result = calcularFibonacci(n-1) + calcularFibonacci(n-2);
		}
		return result;
	}

	public static int countNotNull(Object[] array) {
		int result = 0;
		result = contador(array, array.length-1);
		return result;
	}

	private static int contador(Object[] array, int i) {
		int res = 0;
		if (i < 0) {
			res = 0;
		} else if (array[i] != null) {
			res = 1 + contador(array, i-1);
		} else {
			res = contador(array, i-1);
		}
		return res;
	}

	public static long potenciaDe2(int expoente) {
		int result = 1;
		if (expoente == 0) {
			
		} else {
			result = (int) (2 * potenciaDe2(expoente-1));
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO ARITMETICA, DADO O TERMO INICIAL E A RAZAO
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		// TODO IMPLEMENTE SEU CODIGO (USANDO RECURSAO) DE ENCONTRAR O n-ESIMO
		// TERMO
		// DA PROGRESSAO GEOMETRICA, DADO O TERMO INICIAL E A RAZAO
		return result;
	}
	
	
}
