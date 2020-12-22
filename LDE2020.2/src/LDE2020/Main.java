package LDE2020;

public class Main {

	public static void main(String[] args) {
		LDE lista = new LDE();
		lista.inserir(new Produto("Coca-cola 2L", 7.0), 0);
		lista.inserir(new Produto("Açucar 1Kg", 4.0), 0);
		lista.inserir(new Produto("Feijão 2Kg", 5.0), 1);
		lista.inserir(new Produto("Arroz 1Kg", 4.5), 1);
		lista.inserir(new Produto("Cervaja itaipava lata", 2.5), 0);
		lista.inserir(new Produto("Doce de leite", 4.25), lista.getTamanho());
		lista.inserirOrdenadoPeloPreco(new Produto("Vinho 1L", 4.6));
		lista.inserirOrdenadoPeloPreco(new Produto("Pitú", 4.25));
		lista.inserirMelhorComplexidade(new Produto("Vinho 1L", 3.99));
		lista.imprimir();
		
		lista.removerInicio();
		System.out.println("Impressão depois da remoção inicio /n");
		lista.imprimir();
		lista.removerFinal();
		System.out.println("Impressão depois da remoção final /n");
		lista.imprimir();
		lista.remover(1);
		System.out.println("Impressão depois da remoção indice 1 /n");
		lista.imprimir();
	
		System.out.println("Impressão inversa");
		lista.imprimirIniciandoNaCauda();
		
	}

}
