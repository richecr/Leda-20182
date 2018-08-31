package vetor;

import java.util.Comparator;

public class Minimo implements Comparator<Aluno> {

	@Override
	public int compare(Aluno o1, Aluno o2) {
		return (int) (o2.getMedia() - o1.getMedia());
	}

}
