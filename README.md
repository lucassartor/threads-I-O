<a name="br1"></a> 

UNIVERSIDADE DE SÃO PAULO

SISTEMAS DE INFORMAÇÃO

GABRIEL BERNARDINI SCHMIDT - 12873188

LUCAS SARTOR CHAUVIN - 11796718

TAMYRIS AYUMI NASCIMENTO ONODA - 12731401

ACH2044 - SISTEMAS OPERACIONAIS

**RELATÓRIO EXERCÍCIO-PROGRAMA 2**

SÃO PAULO

2022



<a name="br2"></a> 

**1. Solução adotada para o problema de Leitores e Escritores**

A solução adotada para o problema de leitores e escritores pode ser conferida no

seguinte [l](https://wiki.eecs.yorku.ca/course_archive/2007-08/F/6490A/readers-writers)[ink](https://wiki.eecs.yorku.ca/course_archive/2007-08/F/6490A/readers-writers). O mesmo código e ideia de resolução foram utilizados neste projeto.

Essa solução permite que várias threads concorrentes leiam e escrevam na região

crítica ao mesmo tempo, desde que não haja nenhuma thread escrevendo. Além disso, as

threads de leitura têm prioridade sobre as threads de escrita, ou seja, as threads de escrita

ficam "em espera" até que todas as threads de leitura tenham sido finalizadas.

**2. Estrutura e definição de classes do projeto**

Tanto a solução com leitor e escritor quanto a sem leitor e escritor foram

desenvolvidas no projeto para usar as mesmas classes, as quais possuem os mesmos

atributos e métodos - o que muda é a implementação e código nos métodos. Como decisão

de projeto, foram implementadas as seguintes classes:

**2.1 Database**

A classe Database é responsável por armazenar as palavras lidas do arquivo "bd.txt"

em um ArrayList. Como a estrutura é uma região crítica que pode ser acessada por

diferentes threads concorrentemente, a classe implementa um mecanismo de controle de

acesso. O tipo de mecanismo implementado depende da solução escolhida (com leitor e

escritor ou sem). A classe também é responsável por ler o arquivo e inicializar e carregar os

dados no ArrayList.

A classe possui os atributos "list" (um ArrayList que armazena as palavras) e

"leitores" (que armazena a quantidade de leitores que acessam a região crítica no

momento). Ela também possui os métodos "carregaEstruturaRAM" (que lê o arquivo e

carrega os dados no ArrayList), "read" (que permite a leitura dos dados do ArrayList) e

"write" (que permite a atualização dos dados do ArrayList por apenas uma thread por vez).

**2.2 Writer**

A classe Writer (de escritor) é responsável por representar uma thread de escrita no

ArrayList de palavras (região crítica).

Ela possui o atributo "database" que armazena uma instância da classe que

armazena o ArrayList de palavras. Como a classe estende a classe Thread do Java, ela

possui apenas o método "run" que faz uma chamada ao método "read" da classe Database.



<a name="br3"></a> 

**2.3 Reader**

A classe Reader (de leitor) é responsável por representar uma thread de leitura dos

dados armazenados no ArrayList de palavras (região crítica).

Ela possui o atributo "database" que armazena uma instância da classe que

armazena o ArrayList de palavras. Como a classe estende a classe Thread do Java, ela

possui apenas o método "run" que faz uma chamada ao método "write" da classe Database.

**2.4 Sistema**

A classe Sistema é responsável por representar a thread principal que executará

todas as threads leitoras e escritoras necessárias para os experimentos. Ela armazena um

array com todas as 100 threads necessárias e o popula com threads leitoras e escritoras de

forma aleatória, seguindo as proporções especificadas para os experimentos.

Para isso, a classe possui os atributos "numeroLeitores" e "numeroEscritores" (que

são usados para controlar a proporção de threads leitoras e escritoras), "mediaTempo" (que

é usado para calcular o tempo médio de execução para cada proporção de threads leitoras

e escritoras), "threads" (um array que armazena as threads) e "database" (uma instância da

classe que armazena o ArrayList de palavras).

Ela também possui os métodos "buscaPosicao", que busca uma posição aleatória

no array de threads que ainda não foi preenchida, "populaObjetoThreads", que popula o

array de threads com instâncias de threads leitoras ou escritoras de forma aleatória e de

acordo com uma certa proporção para os experimentos, "executaThreads", que executa

cada thread armazenada no array de threads, e "run", que por estender a classe Thread do

Java, implementa o método "run" que, nesse projeto, realiza a medição dos tempos de

execução dos experimentos.

**3. Execução do Projeto**

Para a correta execução das soluções, siga os seguintes passos:

1\. Descompacte o arquivo .zip;

2\. Acesse, em um terminal, o diretório do projeto;

3\. a solução desejada MUDAR ISSO (**semLeitorEscritor** ou **comLeitorEscritor**;

4\. Compile a classe com o comando:

a. Solução sem leitor-escritor: **javac semLeitorEscritor/Main.java**

b. Solução com leitor-escritor: **javac comLeitorEscritor/Main.java**

5\. Execute a classe compilada com o comando:

a. Solução sem leitor-escritor: **java semLeitorEscritor/Main.java**

b. Solução com leitor-escritor: **java comLeitorEscritor/Main.java**



<a name="br4"></a> 

6\. O resultado da execução será apresentado na tela do terminal.

**4. Resultados**

Rodando as duas soluções (com leitor e escritor e sem leitor e escritor) obteve-se os

seguintes resultados:

**Proporção**

**Leitor-Escritor**

**Tempo médio com**

**Leitores-Escritores**

**Tempo médio sem**

**Leitores-Escritores**

100-0

99-1

14,02

13,6

127,14

127,66

124,64

122,68

121,98

123,80

122,34

124,88

123,48

122,32

126,06

123,50

125,40

124,54

124,38

123,80

125,16

123,92

124,98

125,88

126,46

124,00

119,92

125,30

125,14

123,28

126,10

123,54

123,70

98-2

15,38

12,56

14,16

15,12

16,18

20,3

97-3

96-4

95-5

94-6

93-7

92-8

19,94

19,26

20,5

91-9

90-10

89-11

88-12

87-13

86-14

85-15

84-16

83-17

82-18

81-19

80-20

79-21

78-22

77-23

76-24

75-25

74-26

73-27

72-28

23,2

22,8

26,62

25,34

26,72

27,84

29,02

31,14

34,66

33,86

34,48

34,66

36,84

38,62

40,00

39,78

41,12

41,76



<a name="br5"></a> 

71-29

70-30

69-31

68-32

67-33

66-34

65-35

64-36

63-37

62-38

61-39

60-40

59-41

58-42

57-43

56-44

55-45

54-46

53-47

52-48

51-49

50-50

49-51

48-52

47-53

46-54

45-55

44-56

43-57

42-58

41-59

40-60

39-61

38-62

37-63

36-64

35-65

44,40

45,96

45,46

46,74

48,04

52,48

50,50

52,24

52,62

54,50

55,34

58,00

56,60

59,02

60,26

60,66

63,00

65,22

64,54

65,24

67,94

67,68

69,94

70,04

71,72

72,16

74,84

75,18

77,42

77,12

80,94

80,30

79,96

82,28

83,70

83,42

85,82

125,14

121,00

123,46

122,52

126,92

123,00

126,90

127,44

127,00

128,84

121,62

122,24

125,04

124,10

122,64

128,98

120,44

122,44

125,98

124,36

123,50

124,76

125,04

126,14

120,62

122,12

120,66

123,58

122,20

122,00

124,00

121,80

126,22

124,72

124,46

121,60

120,48



<a name="br6"></a> 

34-66

33-67

32-68

31-69

30-70

29-71

28-72

27-73

26-74

25-75

24-76

23-77

22-78

21-79

20-80

19-81

18-82

17-83

16-84

15-85

14-86

13-87

12-88

11-89

10-90

9-91

86,08

89,70

121,46

123,98

121,32

125,26

125,34

124,82

125,68

126,10

128,66

126,08

125,58

123,60

127,06

123,94

123,92

125,12

122,66

123,22

122,50

123,60

124,12

124,22

126,14

124,60

125,40

125,88

123,46

129,70

131,42

129,54

128,42

132,20

131,34

131,74

131,32

88,60

90,32

92,20

90,76

95,52

93,36

96,04

96,12

98,96

96,48

100,26

99,70

102,42

102,76

106,08

104,72

105,60

106,44

108,80

108,56

111,46

111,78

110,90

113,78

112,86

115,86

117,14

117,62

119,40

119,92

118,10

122,86

122,48

8-92

7-93

6-94

5-95

4-96

3-97

2-98

1-99

0-100



<a name="br7"></a> 

**5. Análise e conclusão dos resultados**

Através dos resultados anteriores, foi possível gerar o seguinte gráfico:

A análise do gráfico mostra que o tempo médio de execução sem leitores e

escritores na solução se mantém estável com variações sutis para todas as proporções de

leitores-escritores testadas nos experimentos. Isso era esperado, pois enquanto acessam a

região crítica, tanto leitores quanto escritores a mantêm bloqueada, evitando o acesso

concorrente.

No entanto, isso não ocorre nos testes realizados com leitores e escritores na

solução. Através do gráfico, é possível observar que a proporção de leitores-escritores

influencia diretamente no tempo de execução: quanto mais escritores, mais lenta a

execução, pois eles não permitem que múltiplos leitores acessem os dados da região crítica

de forma concorrente. Portanto, a partir da proporção 13-87 (13 leitores e 87 escritores), o

tempo de execução com leitores-escritores na solução (108,56 ms) tende a igualar o tempo

de execução sem eles na solução (124,22 ms). A tabela de resultados apresentada

anteriormente mostra justamente isso.

Portanto, em um sistema que utilize principalmente operações de escrita, com uma

proporção de leitor-escritor superior a 14-86, é possível que a implementação sem a

solução com leitores e escritores seja mais vantajosa por ser mais fácil de implementar.

Para verificar se há outliers nos tempos medidos, foi registrado o tempo mínimo e

máximo atingido durante as 50 iterações para cada proporção de leitor-escritor nas duas

soluções. Isso permitiu a criação dos seguintes gráficos, que mostram que a presença de



<a name="br8"></a> 

outliers é mínima, o que confirma a precisão dos valores calculados para as médias dos

tempos de execução.

