package vetor;

public class TestarVetor {

	public static void main(String[] args) {
		
		Aluno a1 = new Aluno("a1", 10);
		Aluno a2 = new Aluno("a2", 8.4);
		Aluno a3 = new Aluno("a3", 2);
		Aluno a4 = new Aluno("a4", 5);
		Aluno a5 = new Aluno("a5", 8);
		Vetor<Aluno> testeVetor = new Vetor<>(10);
		testeVetor.setComparadorMaximo(new Maximo());
		testeVetor.setComparadorMinimo(new Minimo());
		testeVetor.inserir(a1);
		testeVetor.inserir(a2);
		testeVetor.inserir(a3);
		testeVetor.inserir(a4);
		testeVetor.inserir(a5);
		System.out.println(testeVetor.maximo().getNome());
		System.out.println(testeVetor.minimo().getNome());
		
		// Removendo...
		System.out.println(testeVetor.remover(a1).getNome());
		
		// Adicionando apos remover...
		Aluno a6 = new Aluno("a6", 7.8);
		testeVetor.inserir(a6);
		System.out.println(testeVetor.procurar(a6).getNome());
		
	}
}
