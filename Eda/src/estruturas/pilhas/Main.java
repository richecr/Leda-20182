package estruturas.pilhas;

import estruturas.exceptions.StackOverflowException;
import estruturas.exceptions.StackUnderflowException;

public class Main {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		
		Stack<Integer> pilha = new Pilha<>(5);
		pilha.push(10);
		System.out.println(pilha.pop()); // 10 e remove.
		pilha.push(5);
		System.out.println(pilha.top()); // 5
		pilha.push(6);
		pilha.push(7);
		pilha.push(8);
		pilha.push(9);
		pilha.pop();
		//System.out.println(pilha.pop()); // 8 e remove.
		pilha.push(12);
		//pilha.push(2); // Erro
		System.out.println(pilha.top());
		
	}

}
