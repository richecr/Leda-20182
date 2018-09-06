
public interface Sorting<T extends Comparable> {
	
	public void sort(T[] array, int right, int left);
	
	public void sortRecursivo(T[] array);

}
