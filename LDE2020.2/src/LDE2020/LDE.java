package LDE2020;

public class LDE {
	public Produto cabeca;
	public Produto cauda;
	public int tamanho = 0;
	
	public void inserirInicio(Produto novo) {
		if(cabeca == null) {
			cabeca = novo;
			cauda = novo;
			tamanho ++;
		} else {
			novo.proximo = cabeca;
			cabeca.anterior = novo;
			cabeca = novo;
			tamanho++;
		}
	}
	
	public void inserirFinal(Produto novo) {
		if (cabeca == null) {
			cabeca = novo;
			cauda = novo;
			tamanho++;
		} else {
			cauda.proximo = novo;
			novo.anterior = cauda;
			cauda = novo;
			tamanho++;
		}
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void inserir(Produto novo, int indice) {
		if(tamanho == 0 || indice <= 0) {
			inserirInicio (novo);
		} else if (indice >= tamanho) {
			inserirFinal (novo);
		} else {
			Produto aux = cabeca;
			for(int i = 0; i < indice-1; i++) {
				aux=aux.proximo;
			}
			(aux.proximo).anterior = novo;
			novo.proximo = aux.proximo;
			aux.proximo = novo;
			novo.anterior = aux;
			tamanho++;
		}
	}
	
	public void imprimir () {
		Produto aux = cabeca;
		for(int i = 0; i<tamanho; i++) {
			System.out.print(" | "+ aux.descricao +" R$ "+aux.preco+" | ");
			aux = aux.proximo;
			
		}
		System.out.println(" ");
	}
	
	public void imprimirIniciandoNaCauda() {
		Produto aux = cauda;
		for(int i = 0;i<tamanho;i++) {
			System.out.print(" | "+aux.descricao+" R$ "+aux.preco+" | ");
			aux = aux.anterior;
		}
		System.out.println(" ");
	}
	
	public Produto removerInicio() {
		if(tamanho == 0) {
			System.out.println(" Lista vazia! ");
			return null;
		} 
		else if (tamanho == 1) {
			Produto remova = cabeca;
			cabeca = null;
			cauda = null;
			tamanho--;
			return remova;
		}
		else {
			Produto remova = cabeca;
			cabeca = cabeca.proximo;
			cabeca.anterior.proximo = null;
			cabeca.anterior = null;
			tamanho--;
			return remova;
		}
	}
	
	public Produto removerFinal() {
		if(tamanho == 0) {
			System.out.println(" Lista vazia! ");
			return null;
		}
		else if (tamanho == 1) {
			Produto remova = cabeca;
			cabeca = null;
			cauda = null;
			tamanho--;
			return remova;
		}
		else {
			Produto u = cauda;
			cauda = u.anterior;
			cauda.proximo.anterior = null;
			cauda.proximo = null;
			tamanho--;
			return u;
		}
	}
	
	public Produto remover (int i) {
		if (i<=0) {
			return removerInicio();
		}
		else if (i >= tamanho - 1) {
			return removerFinal();
		}
		else {
			Produto aux = cabeca;
			for(int j = 0; j < i - 1; j++) {
				aux = aux.proximo;
			}
			Produto remova = aux.proximo;
			aux.proximo = remova.proximo;
			aux.proximo.anterior = aux;
			remova.proximo = null;
			remova.anterior = null;
			tamanho--;
			return remova;
		}
	}
	
	public void inserirOrdenadoPeloPreco (Produto novo) {
		Produto aux = cabeca;
	if(novo.preco <= aux.preco) {
		    inserirInicio (novo);
	}
	while(aux.preco<novo.preco ) {
				aux=aux.proximo;
			}
			if (aux.preco>novo.preco) {
				aux=aux.anterior;
			}
			aux.proximo.anterior = novo;
			novo.proximo = aux.proximo;
			aux.proximo = novo;
			novo.anterior = aux;
			tamanho++;
	}
	
	public void inserirMelhorComplexidade (Produto novo) {
		Produto aux = cabeca.proximo.proximo.proximo;
		Produto aux1 = cabeca;
		Produto aux2 = cauda;
		if(novo.preco<=cabeca.preco) {
			inserirInicio(novo);
		} else if (novo.preco>=cauda.preco) {
			inserirFinal(novo);
		}
		else if (aux.preco >= novo.preco) {
			while(aux1.preco<novo.preco) {
				aux1 = aux1.proximo;
			}
			aux1.anterior.proximo = novo;
			novo.anterior = aux1.anterior;
			aux1.anterior = novo;
			novo.proximo = aux1;
			tamanho++;
		}else if (aux.preco <= novo.preco) {
			while(aux2.preco>novo.preco) {
				aux2 = aux2.anterior;
			}
			aux2.proximo.anterior = novo;
			novo.proximo = aux2.proximo;
			aux2.proximo = novo;
			novo.anterior = aux2;
			tamanho++;
		}
	}


}
