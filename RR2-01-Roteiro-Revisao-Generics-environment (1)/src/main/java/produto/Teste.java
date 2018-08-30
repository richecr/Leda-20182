package produto;

import java.util.Collection;

public class Teste<T> {

	public void m(Collection<? extends T> obj) {
		System.out.println("bavav");
	}

}
