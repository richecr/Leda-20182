package respostas.questao2;

public class Main {
	
	private static Forma forma;
	
	public static void main(String[] args) {
		
		// Retangulo.
		forma = new Retangulo(5, 6);
		System.out.println(forma.calcularArea()); // 30
		
		// Quadrado.
		forma = new Quadrado(5);
		System.out.println(forma.calcularArea()); // 25
		
		// Triangulo.
		forma = new Triangulo(5, 10);
		System.out.println(forma.calcularArea()); // 25
		
		// Circulo.
		forma = new Circulo(5);
		System.out.println(forma.calcularArea()); // 78.53...
		
	}

}
