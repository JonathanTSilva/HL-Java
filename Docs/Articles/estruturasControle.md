<!-- LOGO DIREITO -->
<a href="#"><img width="200px" src="https://miro.medium.com/max/1400/1*BENOXzD3k4_-nzgYEkyDTw.png" align="right" /></a>

# Estruturas de Controle

<p align="left">
  <a href="https://github.com/JonathanTSilva/HL-Java">
    <img src="https://img.shields.io/static/v1?label=HomeLab&message=Java&color=red&logo=java&logoColor=white&labelColor=grey&style=flat" alt="HL-Java">
  </a>
</p>

🏛 Estruturas que definem a ordem em que os comados são executados em um programa.

<!-- SUMÁRIO -->
- [Estruturas de Controle](#estruturas-de-controle)
  - [1. Estrutura Sequencial](#1-estrutura-sequencial)
    - [1.1. Expressões aritméticas](#11-expressões-aritméticas)
    - [1.2. Variáveis](#12-variáveis)
    - [1.3. Operações básicas de programação](#13-operações-básicas-de-programação)
      - [1.3.1. Saída de dados](#131-saída-de-dados)
      - [1.3.2. Processamento de dados](#132-processamento-de-dados)
      - [1.3.3. Entrada de dados](#133-entrada-de-dados)
    - [1.4. Funções matemáticas](#14-funções-matemáticas)
  - [2. Estrutura Condicional](#2-estrutura-condicional)
    - [2.1. Expressões Comparativas](#21-expressões-comparativas)
    - [2.2. Expressões Lógicas](#22-expressões-lógicas)
    - [2.3. Operadores de atribuição cumulativa](#23-operadores-de-atribuição-cumulativa)
    - [2.4. Switch-case](#24-switch-case)
    - [2.5. Expressão condicional ternária](#25-expressão-condicional-ternária)
    - [2.6. Escopo e inicialização em nível de estrutura de controle](#26-escopo-e-inicialização-em-nível-de-estrutura-de-controle)
  - [3. Estrutura Repetitiva](#3-estrutura-repetitiva)
    - [3.1. While](#31-while)
    - [3.2. For](#32-for)
  - [Referências](#referências)

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 1. Estrutura Sequencial

### 1.1. Expressões aritméticas

As expressões aritméticas na programação se desenvolvem da mesma forma que na matemática, até mesmo nos precedentes. A única diferença é que na programação, não se utiliza chaves {} e colchetes [] para alterar a precedência, mas apenas parênteses (). Outro detalhe é a adição de um novo operador aritmético para simbolizar o resto da divisão, `%`, chamado "mod".

### 1.2. Variáveis

Em programação, uma variável é uma porção de memória (RAM) utilizada para armazenar dados durante a execução dos programas. A declaração de uma variável em java é feita da seguinte forma:

```java
<tipo> <nome> = <valor inicial>
```

> **Nota:** apesar de não ser visível, a variável possui um endereço de alocação na memória.

A tabela abaixo lista todos os tipos primitivos de variáveis na linguagem Java.

| Descrição                    | Tipo      | Tamanho | Valores                  | Valor padrão |
| :--------------------------- | :-------- | :------ | :----------------------- | :----------- |
| Numérico inteiro             | `byte`    | 8 bits  | -128 a 127               | 0            |
| Numérico inteiro             | `short`   | 16 bits | -32768 a 32767           | 0            |
| Numérico inteiro             | `int`     | 32 bits | -2147483648 a 2147483648 | 0            |
| Numérico inteiro             | `long`    | 64 bits | -9.2...E-18 + 9.2...E+18 | 0L           |
| Numérico com ponto flutuante | `float`   | 32 bits | -1.4024E-37 a 3.4028E+38 | 0.0f         |
| Numérico com ponto flutuante | `double`  | 64 bits | -4.94E-307 a 1.79E+308   | 0.0          |
| Um caractere Unicode         | `char`    | 16 bits | '\u0000' a '\uFFFF'      | '\u0000'     |
| Valor verdade                | `boolean` | 1 bit   | {false, true}            | false        |

> **Nota:** também há o tipo String, que é uma cadeia de caracteres para armazenar palavras ou textos

Os nomes das variáveis devem respeitar as seguintes regras:

- Não pode começar com um dígito: usar uma letra ou _;
- Não pode ter espaço em branco;
- Não usar acentos ou til;
- Iniciar com letra minúscula;
- Sugestão: use o padrão "camel case".

### 1.3. Operações básicas de programação

Um programa de computador é capaz de realizar essencialmente três operações:

1. Entrada de dados (leitura): usuário informa dados para o programa (salvos em variáveis) através de um teclado, por exemplo;
2. Processamento de dados (atribuição): programa realiza os cálculos;
3. Saída de dados (escrita): programa informa dados para o usuário.

#### 1.3.1. Saída de dados

Dois comandos básicos para saída de dados em Java: `System.out.print("Texto!");` e `System.out.println("Texto!");`, sendo o primeiro sem quebra de linha e o segundo com a quebra de linha no final. Segue abaixo as seguintes configurações para estes comando de saída:

- Para variáveis com valores inteiros e decimais: `System.out.println(x);`;
- Para variáveis com ponto flutuante, controlando a quantidade de casas decimais: `System.out.printf("%.2f%n", x);`. O print**F** significa print FORMATADO;

> **Nota:** o `printf`pega o formato de números utilizado no computador por padrão, podendo aparecer, como separador. Assim, é necessário adicionar o seguinte comando no código: `Locale.setDefault(Locale.US)` e realizar a importação do pacote `import java.util.Locale`.

Os principais marcadores de variáveis no Java são:

| Comando | Descrição       |
| :------ | :-------------- |
| `%f`    | Ponto flutuante |
| `%d`    | Inteiro         |
| `%s`    | Texto           |
| `%n`    | Quebra de linha |

#### 1.3.2. Processamento de dados

A etapa de processamento de dados é muito simples, se resumindo à um único comando de atribuição, no qual lê-se "recebe":

```
<variavel> = <expressao>
```

> **Nota:** pelas boas práticas, sempre sinalizar o que é minha variável, como: se `double`, registrar valor `6.0`, caso `float`, registrar valor `6f`

*Casting* é a conversão explícita de um tipo para outro. É necessário quando o compilador não é capaz de “adivinhar” que o resultado de uma expressão deve ser de outro tipo. Para realizar o *casting* dos valores, no caso de uma divisão de dois números `int`, como exemplo, caso o processamento seja realizado para uma variável, o resultado também será inteiro, assim, basta colocar na frente da expressão a ser calculado o *casting* para o novo tipo de dado `(double)`.

Outro caso muito frequente em que é necessário utilizar o *casting*, é quando o compilador acha que você vai perder informação. Por exemplo:

```java
public static void main(String[] args) {
  double a;
  int b;
  
  a = 5.0
  b = (int) a;

  System.out.println(b);
}
```

#### 1.3.3. Entrada de dados

O java apresenta uma particularidade para realizar a entrada de dados: é necessário criar um objeto do tipo "Scanner" da seguinte forma:

```java
Scanner sc = new Scanner(System.in);
```

Para que essa variável funcione corretamente, é necessário criar importá-la no início com `import java.util.Scanner` e também precisa-se encerrar o objeto com `sc.close()` para quando não for mais necessário sua utilização.

Assim, tendo realizado todos estes pré-requisitos, entrar com os dados em uma variável utilizando:

```java
x = sc.next();
```

As variações de entrada são:

- `sc.next();`: para entrada qualquer;
- `sc.nextInt();`: para números inteiros;
- `sc.nextDouble();`: para números com ponto flutuante, pegando a localidade do sistema. Caso queira utilizar o padrão americano, declarar `Locale.setDefault(Locale.US)` anteriormente;
- `sc.next().charAt(0);`: para o primeiro caractere da entrada;
- `sc.nextLine();`: ler a linha inteira.

Já para ler um texto até a quebra de linha, seguir com a seguinte formatação:

```java
import java.util.Scanner;

  public class Main {

    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      String s1, s2, s3;

      s1 = sc.nextLine();
      s2 = sc.nextLine();
      s3 = sc.nextLine();

      System.out.println(s1);
      System.out.println(s2);
      System.out.println(s3);

      sc.close();
  }
}
```

> **Nota:** quando utilizar um comando de leitura diferente do `nextLine()` e dar alguma quebra de linha, essa quebra fica "pendente" na entrada padrão.
> Se fizer então um `nextLine()`, aquela quebra de linha será absorvida por ele.
> Para contornar tal problema, fazer um `sc.nextLine()` extra antes de realizar o do seu interesse.

### 1.4. Funções matemáticas

A tabela abaixo apresenta algumas das principais funções matemáticas do Java:

| Função                | Descrição                                      |
| :-------------------- | :--------------------------------------------- |
| `A = Math.sqrt(x);`   | Variável A recebe a raiz quadrada de x         |
| `A = Math.pow(x, y);` | Variável A recebe o resultado de x elevado a y |
| `A = Math.abs(x);`    | Variável A recebe o valor absoluto de x        |

**Exemplo 1**

Faça um programa em Java para encontrar as raízes de uma função de segundo grau.

```java
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    double a, b, c, delta, x1, x2;

    System.out.println("Entre com os valores de sua expressão do segundo grau:");
    System.out.print("A = ");
    a = sc.nextDouble();
    System.out.print("B = ");
    b = sc.nextDouble();
    System.out.print("C = ");
    c = sc.nextDouble();

    delta = Math.pow(b, 2.0) - 4 * a * c;
    x1 = ((-b + Math.sqrt(delta))/ (2.0 * a));
    x2 = ((-b - Math.sqrt(delta))/ (2.0 * a));

    System.out.printf("Os resultados da função de bhaskara para sua função é: x1 = %.2f e x2 = %.2f%n", x1, x2);

    sc.close();
  }
}

```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 2. Estrutura Condicional

É uma estrutura de controle que permite definir que um certo bloco de comandos somente será executado dependendo de uma condição. Há dois tipos de estrutura condicional: a simples e a composta. A simples apresenta a seguinte sintaxe:

```java
if ( condição ) {
  comando1
  comando2
}
```

Já a composta é acrescida de outro comando principal na função, o else. Note no código abaixo que é possível realizar um encadeamento de estruturas condicionais:

```java
if ( condição ) {
  comando1
  comando2
} 
else if ( condição ) {
  comando3
  comando4
} 
else {
  comando5
  comando6
}
```

### 2.1. Expressões Comparativas

Como o próprio nome diz, são expressões que comparam um elemento à outro. Quando se avalia uma expressão comparativa, o resultado é um valor verdade (`boolean`). Na programação em geral, há pelo menos seis operadores comparativos:

| Operador | Significado    |
| :------- | :------------- |
| `>`      | maior          |
| `<`      | menor          |
| `>=`     | maior ou igual |
| `<=`     | menor ou igual |
| `==`     | igual          |
| `!=`     | diferente      |

### 2.2. Expressões Lógicas

Assim como as expressões comparativas, quando avaliadas, as expressões lógicas também resultam em um valor verdade. Os operadores lógicos são:

| Operador | Significado                                      |
| :------- | :----------------------------------------------- |
| `&&`     | AND - todas as condições precisam ser verdadeira |
| `||`     | OR - pelo menos uma condição deve ser verdadeira |
| `!`      | NOT                                              |

> **Nota:** a tabela verdade é uma ferramenta para se lembrar e entender todos os operadores lógicos

### 2.3. Operadores de atribuição cumulativa

| Operadores | Significado |
| :--------- | :---------- |
| `a += b;`  | a = a + b;  |
| `a -= b;`  | a = a - b;  |
| `a *= b;`  | a = a * b;  |
| `a /= b;`  | a = a / b;  |
| `a %= b;`  | a = a % b;  |

Exemplo:

```java
conta = conta + (mintos - 100) * 2.0;
conta += (minutos - 100) * 2.0;
```

### 2.4. Switch-case

Quando se tem várias opções de fluxo a serem tratadas com base no valor de uma variável, ao invés de várias estruturas if-else encadeadas, alguns preferem utilizar a estrutura switch-case.

```java
switch ( expressão ) {
  case valor1:
    comando1
    comando2
    break;
  case valor2:
    comando3
    comando4
    break;
  
  default:
    comandoN
    break;
}
```

### 2.5. Expressão condicional ternária

Estrutura opcional ao if-else quando se deseja decidir um VALOR com base em uma condição.

**Sintaxe:**

```java
( condição ) ? valor_se_verdadeiro : valor_se_falso
```

**Exemplos:**

```java
( 2 > 4 ) ? 50 : 80  ---------> Resultado: 80 
```

```java
double preco = 34.5;
double desconto = (preco < 20.0) ? preco * 0.1 : preco * 0.05;
```

### 2.6. Escopo e inicialização em nível de estrutura de controle

Escopo de uma variável: é a região do programa onde a variável é valida, ou seja, onde ela pode ser referenciada. Em Java, uma variável não pode ser usada se não for iniciada. Este assunto será tratado mais detalhadamente em outro artigo.

**Exemplo** errado de uma variável não iniciada:

```java
double preco;
System.out.println(preco);
```

**Exemplo** errado de uma variável fora do escopo do método:

```java
double preco = 400.00;

if (price < 200.00) {
  double desconto = preco * 0.1;
}

System.out.println(desconto);
```

> **Nota:** todas as variáveis que forem declaradas dentro da estrutura, elas só vão existir enquanto a estrutura não for finalizada.

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 3. Estrutura Repetitiva

As estruturas de repetição também são conhecidas como laços (loops) e são utilizados para executar, repetidamente, uma instrução ou bloco de instrução enquanto determinada condição estiver sendo satisfeita.

Qualquer que seja a estrutura de repetição, ela contém quatro elementos fundamentais: inicialização, condição, corpo e iteração. A inicialização compõe-se de todo código que determina a condição inicial da repetição. A condição é uma expressão **booleana** avaliada após cada leitura do corpo e determina se uma nova leitura deve ser feita ou se a estrutura de repetição deve ser encerrada. O corpo compõe-se de todas as instruções que são executadas repetidamente. A iteração é a instrução que deve ser executada depois do corpo e antes de uma nova repetição.

### 3.1. While

É uma estrutura de controle que repete um bloco de comandos enquanto uma condição for verdadeira.

Quando utilizar: quando não se sabe previamente a quantidade de repetições que será realizada.

```java
while (condicao) {
  comando1
  comando2
}
```

**Exemplo**: fazer um programa que lê números inteiros até que um zero seja lido. Ao final mostra a soma dos números lidos

```java
import java.util.Locale;
import java.util.Scanner;

public class EX02 {
  public static void main (String[] args) {
    
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    
    int x = sc.nextInt();
    int soma = 0;
    
    while (x != 0) {
      soma += x;
      x = sc.nextInt();
    }
    
    System.out.println(soma);
    
    sc.close();
  }
}
```

### 3.2. For

## Referências

<!-- MARKDOWN LINKS -->
<!-- SITES -->

<!-- IMAGES -->
