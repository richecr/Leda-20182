package estruturas.exceptions;

public class QueueUnderflowException extends Exception {
	
	public QueueUnderflowException() {
		super("Queue está vazia");
	}

}
