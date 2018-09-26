package estruturas;

public class StackOverflowException extends Exception {

	public StackOverflowException() {
		super("Stack está cheia");
	}
	
}
