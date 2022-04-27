<!-- LOGO DIREITO -->
<a href="#"><img width="200px" src="https://miro.medium.com/max/600/0*7zMicw-FfThCbN35.png" align="right" /></a>

# O nível intermediário de conhecimento em Programação Orientada a Objetos

<p align="left">
  <a href="https://github.com/JonathanTSilva/HL-Java">
    <img src="https://img.shields.io/static/v1?label=HomeLab&message=Java&color=red&logo=java&logoColor=white&labelColor=grey&style=flat" alt="HL-Java">
  </a>
</p>

🏛 Tudo o que você precisa saber para completar a introdução dada em Programação Orientada a Objetos (POO).

<!-- SUMÁRIO -->
- [O nível intermediário de conhecimento em Programação Orientada a Objetos](#o-nível-intermediário-de-conhecimento-em-programação-orientada-a-objetos)
  - [1. Alocação de memória](#1-alocação-de-memória)
    - [1.1. Tipos referência](#11-tipos-referência)
    - [1.2. Valor `null`](#12-valor-null)
    - [1.3. Tipos valor](#13-tipos-valor)
      - [1.3.1. Inicialização de tipos primitivos](#131-inicialização-de-tipos-primitivos)
    - [1.4. Valores padrão](#14-valores-padrão)
    - [1.5. Tipos referência vs. Tipos valor](#15-tipos-referência-vs-tipos-valor)
  - [2. Desalocação de memória](#2-desalocação-de-memória)
    - [2.1. *Garbage Collector*](#21-garbage-collector)
    - [2.2. Escopo](#22-escopo)
  - [3. Vetores](#3-vetores)
  - [4. Boxing, unboxing e wrapper classes](#4-boxing-unboxing-e-wrapper-classes)
  - [5. Laço "for each"](#5-laço-for-each)
  - [. Arrays](#-arrays)
  - [. Listas](#-listas)

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 1. Alocação de memória

### 1.1. Tipos referência

Em Java, classes são tipos referência. Variáveis cujo tipo são classes não devem ser entendidas como caixas, mas sim "tentáculos" (ponteiros) para caixas.

```java
// Essas variáveis estarão alocadas na área de memória Stack
Product p1, p2;

// Quando é instanciado, ela passa a ser um ponteiro dentro da memória HEAP
p1 = new Product("TV", 900.00, 0);

// p2 passa a apontar para onde p1 aponta
p2 = p1
```

![ref][A]

### 1.2. Valor `null`

Tipos referência aceitam o valor `null`, que indica que a variável aponta para ninguém.

```java
Product p1, p2;

p1 = new Product("TV", 900.00, 0);

p2 = null;
```

![null][B]

### 1.3. Tipos valor

Em Java, tipos primitivos são tipos valor. Tipos valor são CAIXAS e não ponteiros.

```java
double x, y;

x = 10;

// y recebe uma cópia de x, e não o endereço
y = x;
```

![valor][C]

**Revisão:**

![tabPrim][F]

#### 1.3.1. Inicialização de tipos primitivos

```java
int p;
System.out.println(p); //erro: variável não iniciada

p = 10;
System.out.println(p);
```

### 1.4. Valores padrão

Quando alocamos (`new`) qualquer tipo estruturado (classe ou array), são atribuídos valores padrão aos seus elementos:

- números: 0;
- boolean: false;
- char: caractere código 0;
- objeto: null.

```java
Product p = new Product();
```

![padrao][D]

### 1.5. Tipos referência vs. Tipos valor

![refXval][E]

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 2. Desalocação de memória

### 2.1. *Garbage Collector*

É um processo que automatiza o gerenciamento de memória de um programa em execução.

O *garbage collector* monitora os objetos alocados dinamicamente pelo programa (no `heap`), desalocando aqueles que não estão mais sendo utilizados.

![garbage][G]

### 2.2. Escopo

A desalocação por escopo acontece com as variáveis estaticamente declaras.

```java
void method1() {
  int x = 10;
    if (x > 0) {
    int y = 20; // A imagem abaixo representa o debug de memória neste nível.
  }
  System.out.println(x);
}
```

![escopo][H]

Quando a execução passar para a próxima linha da declaração da variável `y`, imediatamente a variável irá sumir (assim como todas as outras dentro do escopo do `if`, neste caso). A mesma coisa acontecerá para o método, que ao finalizar, todas as variáveis locais deste métodos também serão desalocadas.

**Outro exemplo**

![escopo2][I]

Em suma, Objetos alocados dinamicamente, quando não possuem mais referência para eles, serão desalocados pelo garbage collector.

Variáveis locais são desalocadas imediatamente assim que seu escopo local sai de execução.

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 3. Vetores

Em programação, "vetor" é o nome dado a arranjos unidimensionais.

**Arranjo (array)** é uma estrutura de dados:

- Homogênea (dados do mesmo tipo);
- Ordenada (elementos acessados por meio de posições);
- Alocada de uma vez só, em um bloco contíguo de memória.

Possui como **vantagem** o acesso imediato aos elementos pela sua posição. Entretanto, as **desvantagens** se dão pelo tamanho fixo e a dificuldade para realizar inserções e deleções.

**Exemplo 1:** fazer um programa para ler um número inteiro N e a altura de N pessoas. Armazene as N alturas em um vetor. Em seguida, mostrar a altura média dessas pessoas.

| Input | Output                |
| :---- | :-------------------- |
| 3     | AVERAGE HEIGHT = 1.69 |
| 1.72  |                       |
| 1.56  |                       |
| 1.80  |                       |

![vect][J]

```java
package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
  public static void main(String[] args) {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    double sum = 0.0;
    double[] vect = new double[n];

    for (int i=0; i<n; i++) {
      vect[i] = sc.nextDouble();
      sum += vect[i];
    }

    double avg = sum / n;

    System.out.printf("AVERAGE HEIGHT: %.2f%n", avg);

    sc.close();
  }
}
```

**Exemplo 2:** fazer um programa para ler um número inteiro N e os dados (nome e preço) de N Produtos. Armazene os N produtos em um vetor. Em seguida, mostrar o preço médio dos produtos.

| Input  | Output                 |
| :----- | :--------------------- |
| 3      | AVERAGE PRICE = 700.00 |
| TV     |                        |
| 900.00 |                        |
| Fryer  |                        |
| 400.00 |                        |
| Stove  |                        |
| 800.00 |                        |

![vect2][K]

```java
package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class Program {
  public static void main(String[] args) {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    double sum = 0.0;
    Product[] vect = new Product[n];

    for (int i=0; i<vect.length; i++) {
      sc.nextLine();
      String name = sc.nextLine();
      double price = sc.nextDouble();
      vect[i] = new Product(name, price);
      sum += vect[i].getPrice();
    }

    double avg = sum / vect.length;

    System.out.printf("AVERAGE PRICE = %.2f%n", avg);

    sc.close();
  }
}
```

> **Nota:** a classe **Product** é básica, apresentando apenas os métodos `Getters` e `Setter` e o `Construtor(name, price)`.

**Exercício de fixação:**

A dona de um pensionato possui dez quartos para alugar para estudantes, sendo esses quartos identificados pelos números 0 a 9.

Fazer um programa que inicie com todos os dez quartos vazios, e depois leia uma quantidade N representando o número de estudantes que vão alugar quartos (N pode ser de 1 a 10). Em seguida, registre o aluguel dos N estudantes. Para cada registro de aluguel, informar o nome e email do estudante, bem como qual dos quartos ele escolheu (de 0 a 9). Suponha que seja escolhido um quarto vago. Ao final, seu programa deve imprimir um relatório de todas ocupações do pensionato, por ordem de quarto, conforme exemplo.

**Exemplo:**

```console
How many rooms will be rented? 3

Rent #1:
Name: Maria Green
Email: maria@gmail.com
Room: 5

Rent #2:
Name: Marco Antonio
Email: marco@gmail.com
Room: 1

Rent #3:
Name: Alex Brown
Email: alex@gmail.com
Room: 8

Busy rooms:
1: Marco Antonio, marco@gmail.com
5: Maria Green, maria@gmail.com
8: Alex Brown, alex@gmail.com
```

**src > application > Program.java**

```java
package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Rent;

public class Program {

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    
    int n, room;
    String name, email;
    
    Rent[] vect = new Rent[10];
    
    System.out.print("How many rooms will be rented? ");
    n = sc.nextInt();
    
    for (int i = 1; i <= n ; i++) {
      System.out.println();
      System.out.println("Rent #" + i + ";");
      sc.nextLine();
      System.out.print("Name: ");
      name = sc.nextLine();
      System.out.print("Email: ");
      email = sc.nextLine();
      System.out.print("Room: ");
      room = sc.nextInt();
      vect[room] = new Rent(name, email);
    }
    
    System.out.println();
    System.out.println("Busy rooms:");
    for (int i = 0; i < 10; i++) {
      if (vect[i] != null) {
        System.out.println(i + ": " + vect[i]);
      }
    }
    
    sc.close();
  }

}
```

**src > entities > Rent.java**

```java
package entities;

public class Rent {

  private String name, email;

  public Rent(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String toString() {
    return name + ", " + email;
  }

}

```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 4. Boxing, unboxing e wrapper classes

**Boxing** é o processo de conversão de um objeto tipo valor para um objeto tipo referência compatível.

```java
int x = 20;
Object obj = x;
```

![boxing][L]

**Unboxing** é o processo de conversão de um objeto tipo referência para um
objeto tipo valor compatível.

```java
int x = 20;
Object obj = x;
int y = (int) obj;
```

![unboxing][M]

**Wrapper classes** são classes equivalentes aos tipos primitivos:

- Boxing e unboxing é natural na linguagem;
- Uso comum: campos de entidades em sistemas de informação (IMPORTANTE!);
- Pois tipos referência (classes) aceitam valor null e usufruem dos recursos de Orientação a Objetos.

![wrapper][N]

```java
int x = 20;
Integer obj = x;
int y = obj;
```

```java
public class Product {
  public String name;
  public Double price;
  public Integer quantity;

  (...)
}
```

> **Nota:** então, concluí-se que é melhor utilizar o wrapper class no caso acima ao invés de tipo primitivo, pois o wrapper class aceita naturalmente o valor nulo.

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 5. Laço "for each"

Sintaxe opcional e simplificada para percorrer coleções.

```java
for (Tipo apelido : colecao) {
  comando1
  comando2
}
```

**Exemplo:**

```java
String[] vect = new String[] {"Maria", "Bob", "Alex"};

//For normal
for (int i=0; i<vect.length; i++) {
  System.out.println(vect[i]);
}

//For each
for (String obj : vect) {
  System.out.println(obj);
}
```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## . Arrays



<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## . Listas



<!-- MARKDOWN LINKS -->
<!-- SITES -->

<!-- IMAGES -->
[A]: ../../Images/tipoRef.png
[B]: ../../Images/valNull.png
[C]: ../../Images/tipoVal.png
[D]: ../../Images/valPadrao.png
[E]: ../../Images/refXval.png
[F]: ../../Images/tabPrim.png
[G]: ../../Images/garbageCollector.png
[H]: ../../Images/escopo.png
[I]: ../../Images/escopo2.gif
[J]: ../../Images/vetor.png
[K]: ../../Images/vetor2.gif
[L]: ../../Images/boxing.png
[M]: ../../Images/unboxing.png
[N]: ../../Images/wrapper.png
