
public class Main {
	
	/***************************************************************************************************************
	 * Entrada esperada pelo programa:
	 * 
	 * Arquivo onde cada linha representa uma aresta do grafo
	 * A primeira linha determina o número de usuários da rede social
	 * As linhas seguintes determinam uma relação de amizade entre dois usuários:
	 * 	os dois primeiros valores são os vértices, 
	 * 	o terceiro, o valor de friendship
	 *  e o quarto, a distância. 
	 * Todos os números devem ser inteiros, positivos e diferentes de zero
	 * O programa resolve várias instâncias do problema, então, cada rede deve ser separada por uma linha em branco
	 * 
	 * nuR1
	 * v1 v2 f1 d1
	 * v3 v4 f2 d2
	 * v5 v6 f3 d3
	 * v7 v8 f4 d4
	 * 
	 * nuR2
	 * v1 v2 f1 d1
	 * v3 v4 f2 d2
	 * v5 v6 f3 d3
	 * .
	 * .
	 * .
	 **************************************************************************************************************
	 */

	
	public static void main(String [] args) {
		new Control().run();
	}
}
