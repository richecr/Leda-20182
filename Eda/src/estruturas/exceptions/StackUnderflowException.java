package estruturas.exceptions;

public class StackUnderflowException extends Exception {

	public StackUnderflowException() {
		super("Stack esta vazia");
	}
	
}
