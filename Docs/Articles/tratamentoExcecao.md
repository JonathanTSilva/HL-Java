<!-- LOGO DIREITO -->
<a href="#"><img width="200px" src="http://www.universidadejava.com.br/images/2020-05-14-java-excecoes.png" align="right" /></a>

# Tratamento de exceções

<p align="left">
  <a href="https://github.com/JonathanTSilva/HL-Java">
    <img src="https://img.shields.io/static/v1?label=HomeLab&message=Java&color=red&logo=java&logoColor=white&labelColor=grey&style=flat" alt="HL-Java">
  </a>
</p>

🔕 Uma abordagem prática para entender o tratamento de exceções no Java.

<!-- SUMÁRIO -->


<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 1. Introdução

Para projetar uma boa solução de programação, é necessário conhecer qual a solução ruim para contornar tais problemas, começando com uma solução muito ruim, posteriormente, apresentando melhorias, e por fim, chegando à melhor solução, na qual foram tratadas todas as exceções anteriormente encontradas.

Uma exceção é qualquer condição de erro ou comportamento inesperado encontrado por um programa em execução. Em Java, uma exceção é um objeto herdado da classe:

- `java.lang.Exception` - o compilador obriga a tratar ou propagar;
- `java.lang.RuntimeException` - o compilador não obriga a tratar ou propagar.

Quando lançada, uma exceção é propagada na pilha de chamadas de métodos em execução, até que seja capturada (tratada) ou o programa seja encerrado.

O tratamento de exceções permite gerenciar os erros durante a execução de uma forma organizada. Assim, pode-se invocar uma rotina de tratamento de erro quando um erro ocorrer, pois fornece um meio de transferir o controle e as informações de um ponto na execução de um programa para um "tratador de exceções" associado a um ponto previamente passado pela execução.

Um tratamento de exceções pode ser usado para suportar noções de tratamento de erros e computação tolerante a falhas.

O mecanismo de tratamento de exceções requer o uso de três palavras chave: `try`, `catch` e `throw`. Nos termos mais gerais, os comandos de programa que devem ser monitorados para as exceções estão contidos em um bloco de prova (try). Se uma exceção (ou erro) ocorrer dentro do bloco de prova, será disparada usando throw. A exceção é pega, usando catch, e processada.

Em suma, qualquer comando que dispara uma exceção precisa ter sido executado dentro de um bloco try. Qualquer exceção precisa ser pega por um comando catch que segue imediatamente o comando try que dispara a exceção, isto é, se uma exceção é chamada no bloco try, o controle do programa é transferido para o gerenciador de exceção apropriado. É importante citar que as funções chamadas a partir de dentro de um bloco try também podem disparar uma exceção, e que o comando catch irá gerenciar qualquer exceção, independente do tipo

O modelo de tratamento de exceções permite que erros sejam tratados de forma consistente e flexível, usando boas práticas. Esse modelo apresenta as seguintes vantagens:

- Delega a lógica do erro para a classe responsável por conhecer as regras que podem ocasionar o erro;
- Trata de forma organizada (inclusive hierárquica) exceções de tipos diferentes;
- A exceção pode carregar dados quaisquer.

### 1.1. Hierarquia de exceções do Java

Segue abaixo, uma amostra da hierarquia de exceções do Java. Para maiores informações, visite a página da qual ela foi extraída: [Hierarchy For Package java.lang][1], da Oracle.

![hie][A]

Tem-se uma superclass `Throwable` (classe genérica de todas as exceções e erros) e subclasses: `Error` (agrupa todos os erros que não espera-se tratamento pelo programador) e `Exception`, cujo o programa tem a possibilidade do programa tratar (sendo que na `RuntimeException`, o compilador não obriga a tratar os erros)

## 2. Estrutura try-catch

Como visto na introdução deste artigo, para tratar as exceções em Java são utilizados os comandos `try` e `catch`. Esses comandos apresentam a sintaxe abaixo:

```java
try {
 // Bloco de prova - inclui qualquer código que pode chamar uma exceção (throw)
}
catch (ExceptionType arg) {
 // Executa algumas ações
}
catch (ExceptionType arg) {
 // Executa algumas ações
}
catch (ExceptionType arg) {
 // Executa algumas ações
}
```

O bloco `try` contém o código que representa a execução normal do trecho de código que pode acarretar em uma exceção. Complementarmente, o bloco `catch` contém o código a ser executado caso uma exceção ocorra. Deve ser especificado o tipo de exceção a ser tratada (aqui, o *upcasting* é permitido).

**Exemplo:**

```java
Scanner sc = new Scanner(System.in);

try {
  String[] vect = sc.nextLine().split(" ");
  int position = sc.nextInt(); // Uma das exceções é digitar uma letra ao invés de um número
  // ou, digitar uma posição que não está dentro do limite do vetor
  System.out.println(vect[position]);
}
catch (ArrayIndexOutOfBoundsException e) {
  System.out.println("Invalid position");
}
catch (InputMismatchException e) {
  System.out.println("Input error");
}

System.out.println("End of program");

sc.close();
```

<!-- MARKDOWN LINKS -->
<!-- SITES -->
[1]: https://docs.oracle.com/javase/8/docs/api/java/lang/package-tree.html

<!-- IMAGES -->
[A]: ../../Images/exceptionHie.png