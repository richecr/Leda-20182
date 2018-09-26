package estruturas.exceptions;

public class QueueOverflowException extends Exception {

	public QueueOverflowException() {
		super("Queue está cheia");
	}
	
}
