package LDE2020;

public class Produto {
	public String descricao;
	public double preco;
	public Produto anterior, proximo;
	
	public Produto (String descricao, double p) {
		System.out.println(" Construindo um produto ..." );
		this.descricao = descricao;
		preco = p;
	}


}
