package vetor;

import java.util.Comparator;

public class Maximo implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o1.getMedia() - o2.getMedia());
	}
}