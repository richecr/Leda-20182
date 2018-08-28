package respostas.questao2;

public class Circulo implements Forma {

	private double raio;

	public Circulo(double raio) {
		this.raio = raio;
	}
	
	@Override
	public double calcularArea() {
		return Math.pow(raio, 2) * Math.PI;
	}

}
