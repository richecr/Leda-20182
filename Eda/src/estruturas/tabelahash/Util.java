package estruturas.tabelahash;

public class Util {
	
	public static <T> T[] makeArray(int size) {
		T[] array = (T[]) new Object[size];
		return array;
	}
	
	public static boolean isPrime(int number) {
		boolean res = false;
		int cont = 0;
		for (int i = 1; i <= number; i++) {
			if(number % i == 0) {
				cont++;
			}
		}
		return cont == 2;
	}

}
