package estruturas.filas;

import estruturas.exceptions.QueueOverflowException;
import estruturas.exceptions.QueueUnderflowException;

public class Main {

	public static void main(String[] args) throws QueueOverflowException, QueueUnderflowException {
		Queue<Integer> a = new Fila<>(5);
		a.enqueue(1);
		a.enqueue(2);
		a.enqueue(3);
		a.enqueue(4);
		a.enqueue(5);
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.enqueue(6);
		a.enqueue(1);
		a.dequeue();
		a.dequeue();
		a.dequeue();
		a.enqueue(8);
		a.dequeue();
		a.dequeue();
		System.out.println(a.toString());
	}

}
