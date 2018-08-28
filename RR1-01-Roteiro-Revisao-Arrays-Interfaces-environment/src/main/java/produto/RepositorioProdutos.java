package produto;

public class RepositorioProdutos {

	private Produto[] produtos;

	private int index = -1;

	public RepositorioProdutos(int size) {
		this.produtos = new ProdutoNaoPerecivel[size];
	}

	/**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou -1
	 * caso ele nao se encontre no array. Esse método é util apenas na implementacao
	 * com arrays por questoes de localizacao. Outras classes que utilizam outras
	 * estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo
	 * @return Inteiro Posicao do produto no array.
	 */
	private int procurarIndice(int codigo) {
		int res = -1;
		int posicao = 0;
		boolean achou = false;

		while (!(achou) && (posicao <= this.produtos.length)) {
			if (this.produtos[posicao].getCodigo() == codigo) {
				res = posicao;
				achou = true;
			}
			posicao++;
		}
		return res;
	}

	/**
	 * Recebe o codigo e diz se tem produto com esse codigo armazenado
	 * 
	 * @param codigo
	 * @return Boolean Se o produto existir, true, caso contrario, false.
	 */
	public boolean existe(int codigo) {
		boolean existe = false;
		if (this.procurarIndice(codigo) != -1) {
			existe = true;
		}
		return existe;
	}

	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	public void inserir(ProdutoNaoPerecivel produto) {
		if (this.index < this.produtos.length) {
			this.index++;
			this.produtos[this.index] = produto;
		}
	}

	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao esteja
	 * no array. Note que, para localizacao, o código do produto será utilizado.
	 */
	public void atualizar(ProdutoNaoPerecivel produto) {
		if (this.existe(produto.getCodigo())) {
			int indice = this.procurarIndice(produto.getCodigo());
			this.produtos[indice] = produto;
		} else {
			throw new RuntimeException("Produto nao cadastrado!");
		}
	}

	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um erro,
	 * caso contrário. Note que a remoção NÃO pode deixar "buracos" no array.
	 * 
	 * @param codigo
	 */
	public void remover(int codigo) {
		if (this.existe(codigo)) {
			int indice = this.procurarIndice(codigo);
			this.produtos[indice] = null;
			this.aposRemover(indice);
		} else {
			throw new RuntimeException("Produto nao cadastrado!");
		}
	}

	/**
	 * Metodo que apos remover um produto, ele corrige o array para nao ficar
	 * "buracos".
	 * 
	 * @param indice
	 */
	private void aposRemover(int indice) {
		for (int i = indice; i < this.produtos.length - 1; i++) {
			this.produtos[i] = this.produtos[i + 1];
		}
		this.produtos[this.produtos.length - 1] = null;
	}

	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o produto
	 * nao esteja armazenado
	 * 
	 * @param codigo
	 * @return Produto Que possui o codigo desejado. Caso nao exista, retorna um
	 *         erro.
	 */
	public Produto procurar(int codigo) {
		if (this.existe(codigo)) {
			int indice = this.procurarIndice(codigo);
			Produto p = this.produtos[indice];
			if (p instanceof ProdutoNaoPerecivel) {
				p = (ProdutoNaoPerecivel) p;
			} else if (p instanceof ProdutoPerecivel) {
				p = (ProdutoPerecivel) p;
			}
			return p;
		}
		throw new RuntimeException("Produto nao cadastrado!");
	}
}