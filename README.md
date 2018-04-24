# betterFriendshipGroup
Calcula o melhor grafo de amizade numa rede social

Algoritmo de recomendação de amigos em uma rede social, dadas as relações de amizade entre os usuários, e as medidas de distância física entre os amigos e o nível de amizade entre eles.
O algoritmo propõe a solução para o problema de saber se todos os usuários estão conectados, mesmo que de forma indireta; e também achar o subconjunto de relacionamentos que conecta todos os amigos, de forma que a divisão do somatório de níveis de amizade pelo somatório de distâncias seja o máximo possível.

O problema foi modelado com um grafo onde os vértices são os usuários e as arestas indicam uma amizade direta entre dois usuários. Cada aresta tem dois atributos: friendship e distance.
A qualidade q é definida pela função:

q = (f1 + f2 + ... + fe) / (d1 + d2 + ... + de)

Os elementos de 1 a e representam as arestas da solução.

Então, f1 - q d1 + f2 - q d2 + ... + fe - q de = 0

Para um valor qualquer q, se o valor desta soma for maior que zero, significa que q pode ser maior, já que esse valor diminui o somatório. Ao contrário, se o somatório for menor que zero, significa que não é possível obter aquele valor e q deve ser menor.
Atribuindo o peso fi - qdi para cada aresta do grafo, para que os vértices estejam conectados, é preciso encontrar a árvore geradora máxima.

Atribuindo o peso fi - qdi para cada aresta do grafo, para que os vértices estejam conectados, é preciso encontrar a árvore geradora máxima. Para que a função seja a máxima possível, deve-se incluir na árvore as arestas com peso positivo, mesmo que elas não sejam selecionadas no algoritmo da árvore geradora máxima. A solução então, é encontrar o valor de q que zera o somatório dos pesos da aresta. Para isto, faz-se uma busca binária de q, procurando em cada passo, a árvore geradora máxima e calculando o somatório das arestas selecionadas até que esse seja nulo.

A entrada do programa é um arquivo onde cada linha foi representada como uma aresta do grafo. A primeira linha determina o número de usuários da rede social. As linhas seguintes determinam uma relação de amizade entre dois usuários. Os dois primeiros valores são os vértices, o terceiro o valor de friendship e o quarto, a distância. Todos os números devem ser inteiros positivos diferentes de zero.

O programa resolve várias instâncias do problema. Então, cada rede deve ser separada por uma linha em branco. O programa lê esse arquivo e gera uma lista de vértices e arestas com seus atributos friendship e distance.
Para verificar se o grafo é conexo, é feita uma busca em largura. Somente se o grafo for conexo o programa vai retornar uma solução.
Para buscar o valor de q é preciso definir os limites. Como friendship e distance são números inteiros positivos, o valor mínimo de q é zero e o máximo é o somatório dos friendships de todas as arestas. Como q é decimal, a cada passo da busca, q foi incrementado ou decrementado de
10^-15.

Para encontrar a árvore geradora máxima, foi usado o algoritmo de Kruskal em uma versão modificada. Tradicionalmente ele é usado para encontrar a árvore geradora mínima.
Percorre-se cada aresta atribuindo uma cor diferente e ordenando-as de modo decrescente. Nessa ordem, para cada aresta, se os vértices têm cores diferentes a aresta é acrescentada no subconjunto e as cores são unificadas. Senão, caso o peso da aresta seja positivo, ela também é acrescentada ao subconjunto.

O valor do somatório dos pesos das arestas neste subconjunto é passado para a busca binária, a fim de verificar se atingiu zero, com uma precisão de quatro casas decimais. Ao final da busca binária, o valor da função de qualidade é retornada levando em conta as arestas do subconjunto.
Caso o grafo seja desconexo, ou a busca binária não convirja, ou o arquivo não esteja dentro do padrão, será retornado o valor -1000.
