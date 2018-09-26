package ordenacao;

public interface Sorting<T extends Comparable> {
	
	public void sort(T[] array, int left, int right);
	
	public void sortRecursivo(T[] array);

}
