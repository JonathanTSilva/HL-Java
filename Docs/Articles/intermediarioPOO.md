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
  - [6. Listas](#6-listas)
  - [7. Matrizes](#7-matrizes)
  - [8. Tópicos especiais em Java](#8-tópicos-especiais-em-java)
    - [8.1. Trabalhando com datas](#81-trabalhando-com-datas)
    - [8.2. Manipulando datas com Calendar](#82-manipulando-datas-com-calendar)
      - [8.2.1. Somando uma unidade de tempo](#821-somando-uma-unidade-de-tempo)
      - [8.2.2. Obtendo uma unidade de tempo](#822-obtendo-uma-unidade-de-tempo)

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

## 6. Listas

Lista é uma estrutura de dados:

- Homogênea (dados do mesmo tipo);
- Ordenada (elementos acessados por meio de posições);
- Inicia vazia, e seus elementos são alocados sob demanda;
- Cada elemento ocupa um "nó" (ou nodo) da lista.

> Tipo (interface): List
>
> Classes que implementam: ArrayList, LinkedList, etc.

Diferentemente dos vetores, as vantagens da utilização das listas se dão pelo tamanho variável e facilidade para se realizar inserções e deleções. Já como desvantagem, apresenta acesso sequencial aos elementos.

> **Nota:** as listas, diferente dos vetores, não aceitam tipos primitivos. Caso queira uma lista de números inteiros, por exemplo, é necessário utilizar a *wrapper class* para o int: `Integer`.

Alguns exemplos de manuseio de listas:

1. Tamanho da lista: `size()`;
2. Obter o elemento de uma posição: `get(position)`;
3. Inserir elemento na lista: `add(obj)`, `add(int, obj)`;
4. Remover elementos da lista: `remove(obj)`, `remove(int)`, `removeIf(Predicate)`;
5. Encontrar posição de elemento: `indexOf(obj)`, `lastIndexOf(obj)`;
6. Filtrar lista com base em predicado: `List<Integer> result = list.stream().filter(x -> x > 4).collect(Collectors.toList())`;
7. Encontrar primeira ocorrência com base em predicado: `Integer result = list.stream().filter(x -> x > 4).findFirst().orElse(null)`;

> **Nota:** assuntos pendentes: interfaces, generics e predicados (lambda).

```java
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
  public static void main(String[] args) {

    List<String> list = new ArrayList<>();

    list.add("Maria");
    list.add("Alex");
    list.add("Bob");
    list.add("Anna");
    list.add(2, "Marco"); // Adicionar um elemento na posição 2 da lista

    System.out.println(list.size()); // Imprime o tamanho da lista

    for (String x : list) { // Imprime todos os elementos da lista
      System.out.println(x);
    }

    System.out.println("---------------------");
    list.remove("Anna");
    list remove(1) // Remover elemento da posição 1
      list.removeIf(x -> x.charAt(0) == 'M'); // Remover o Predicado que pega o valor x e retorna se esse x.charAt(0) é igual 'M'
    for (String x : list) {
      System.out.println(x);
    }

    System.out.println("---------------------");
    System.out.println("Index of Bob: " + list.indexOf("Bob")); // Retorna o index do Bob na lista
    System.out.println("Index of Marco: " + list.indexOf("Marco")); // Quando o indexOf não encontra o elemento, ele retorna -1

    System.out.println("---------------------");
    List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList()); // Filtra a lista list e retorna em result todos os elementos que começão com o predicado
    for (String x : result) {
      System.out.println(x);
    }

    System.out.println("---------------------");
    String name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null); // Pega o primeiro elemento que atenda o predicado
    System.out.println(name);

  }
}
```

**Exercício resolvido:** fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de N funcionários. Não deve haver repetição de id. Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário. Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários,conforme exemplos.

Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de aumento por porcentagem dada.

**Exemplo**

```plaintext
How many employees will be registered? 3

Emplyoee #1:
Id: 333
Name: Maria Brown
Salary: 4000.00

Emplyoee #2:
Id: 536
Name: Alex Grey
Salary: 3000.00

Emplyoee #3:
Id: 772
Name: Bob Green
Salary: 5000.00

Enter the employee id that will have salary increase : 536
Enter the percentage: 10.0

List of employees:
333, Maria Brown, 4000.00
536, Alex Grey, 3300.00
772, Bob Green, 5000.00
```

**src > application > Program.java**

```java
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);
    
    List<Employee> list = new ArrayList<>();
    
    // PART 1 - READING DATA:
    
    System.out.print("How many employees will be registered? ");
    int n = sc.nextInt();
    
    for (int i = 1; i <= n; i++) {
      System.out.println();
      System.out.println("Employee #" + i + ":");
      
      System.out.print("ID: ");
      int id = sc.nextInt();
      while (hasId(list, id)) {
        System.out.print("Id already taken. Try again: ");
        id = sc.nextInt();
      }
      
      System.out.print("Name: ");
      sc.nextLine();
      String name = sc.nextLine();
      
      System.out.print("Salary: ");
      double salary = sc.nextDouble();
      
      list.add(new Employee(id, name, salary));
    }
    
    // PART 2 - UPDATING SALARY OF GIVEN EMPLOYEE:

    System.out.println();
    System.out.print("Enter the employee ID that will have slaray increase: ");
    int id = sc.nextInt();
    Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    if (emp == null) {
      System.out.println("This id does not exist!");
    }
    else {
      System.out.print("Enter the percentage: ");
      double percentage = sc.nextDouble();
      emp.increaseSalary(percentage);
    }
    
    // PART 3 - LISTING EMPLOYEES:
    System.out.println();
    System.out.println("List of employees:");
    for (Employee obj : list) {
      System.out.println(obj);
    }
    
    sc.close();
  }

  public static boolean hasId(List<Employee> list, int id) {
    Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    return emp != null;
  }
}
```

**src > entities > Employee.java**

```java
package entities;

public class Employee {
  private Integer id;
  private String name;
  private Double salary;

  public Employee() {
  }

  public Employee(Integer id, String name, Double salary) {
    this.id = id;
    this.name = name;
    this.salary = salary;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public void increaseSalary(double percentage) {
    salary += salary * percentage / 100.0;
  }

  public String toString() {
    return id + ", " + name + ", " + String.format("%.2f", salary);
  }

}
```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 7. Matrizes

Em programação, "matriz" é o nome dado a arranjos bidimensionais. "Vetor de Vetores"

Arranjo (array) é uma estrutura de dados:

- Homogênea (dados do mesmo tipo);
- Ordenada (elementos acessados por meio de posições);
- Alocada de uma vez só, em um bloco contíguo de memória;

Por ser um vetor de vetores, ela possui as mesmas vantagens e desvantagens deles: vantagem de acesso imediato aos elementos pela sua posição e desvantagens do tamanho fixo e da dificuldade para se realizar inserções e deleções.

**Exercício resolvido:** fazer um programa para ler um número inteiro N e uma matriz de ordem N contendo números inteiros. Em seguida, mostrar a diagonal principal e a quantidade de valores negativos da matriz.

**Exemplo:**

| Input   | Output               |
| :------ | :------------------- |
| 3       | Main diagonal:       |
| 5 -3 10 | 5 8 -4               |
| 15 8 2  | Negative numbers = 2 |
| 7 9 -4  |                      |

**src > application > Program.java**

```java
Locale.setDefault(Locale.US);
Scanner sc = new Scanner(System.in);

int n = sc.nextInt();

// Create the Matrix - two-dimensional arrangement
int[][] mat = new int[n][n];

for (int i = 0; i < mat.length; i++) {
  for (int j = 0; j < mat[i].length; j++) {
    mat[i][j] = sc.nextInt();
  }
}

System.out.println("Main diagonal:");
for (int i = 0; i < mat.length; i++) {
  System.out.println(mat[i][i] + " ");
}
System.out.println();

int count = 0;
for (int i = 0; i < mat.length; i++) {
  for (int j = 0; j < mat[i].length; j++) {
    if (mat[i][j] < 0) {
      count++;
    }
  }
}

System.out.println("Negative number = " + count);

sc.close();
```

**Exercício proposto:** fazer um programa para ler dois números inteiros M e N, e depois ler uma matriz de M linhas por N colunas contendo números inteiros, podendo haver repetições. Em seguida, ler um número inteiro X que pertence à matriz. Para cada ocorrência de X, mostrar os valores à esquerda, acima, à direita e abaixo de X, quando houver, conforme exemplo.

**Exemplo:**

```plaintext
3 4
10 8 15 12
21 11 23 8
14 5 13 19
8

Position 0,1:
Left: 10
Right: 15
Down: 11
Position 1,3:
Left: 23
Up: 12
Down: 19
```

**src > application > Program2.java**

```java
Locale.setDefault(Locale.US);
Scanner sc = new Scanner(System.in);

int m = sc.nextInt();
int n = sc.nextInt();

int[][] mat = new int[m][n];

for (int i = 0; i < mat.length; i++) {
  for (int j = 0; j < mat[i].length; j++) {
    mat[i][j] = sc.nextInt();
  }
}

int x = sc.nextInt();

for (int i = 0; i < mat.length; i++) {
  for (int j = 0; j < mat[i].length; j++) {
    if (mat[i][j] == x) {
      System.out.println("Position " + i + "," + j + ":");
      if (j > 0) {
        System.out.println("Left: " + mat[i][j-1]);
      }
      if (i > 0) {
        System.out.println("Up: " + mat[i-1][j]);
      }
      if (j < mat[i].length-1) {
        System.out.println("Right: " + mat[i][j+1]);
      }
      if (i < mat.length-1) {
        System.out.println("Down: " + mat[i+1][j]);
      }
    }
  }
}

sc.close();
```

## 8. Tópicos especiais em Java

### 8.1. Trabalhando com datas

A data representa um INSTANTE. O tipo mais utilizado para este armazenamento de data é o tipo `Date`, que pertence ao pacote `java.util`.

Um objeto Date internamente armazena o número de milissegundos desde a meia noite do dia 1 de janeiro de 1970 GMT (UTC) (onde, GMT: *Greenwich Mean Time - time zone* e UTC: *Coordinated Universal Time - time standard*).

**SimpleDateFormat** - classe que define formatos para conversão entre Date e String.

- dd/MM/yyyy - 23/07/2034;
- dd/MM/yyyy HH:mm:ss - 23/07/2034 10:34:03;

**Padrão ISO 8601 e classe Instant**

- Formato: yyyy-MM-ddTHH:mm:ssZ;
  - Exemplo: "2034-07-23T10:34:03Z".
- `Date y3 = Date.from(Instant.parse("2034-07-23T10:34:03Z"));`.

**Exemplos:**

```java
SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));

Date x1 = new Date(); // Cria uma data com o horário atual
Date x2 = new Date(System.currentTimeMillis()); // Outra forma de obter data atual
Date x3 = new Date(0L); // Da mesma forma que foi passado os millis de agora, é possível passar qualquer
// Em 0 millisegundos, significa o primeiro horário de armazenamento do Date (01/01/1970 GMT), mas como estamos
// três horas atrasados, esse horário será diferente.
// O sufixo L indica que é Long
Date x4 = new Date(1000L * 60L * 60L * 5); // 5 horas da manhã do primeiro dia

Date y1 = sdf1.parse("10/04/2050"); // Faz um parse da data passada para o tipo Date
Date y2 = sdf2.parse("10/04/2050 04:55:07");
Date y3 = Date.from(Instant.parse("2034-07-23T10:34:03Z")); // Data no formato ISO 8601. O Z diz que o time zone é o padrão
// Para converter problema, criar um novo formato setando o TimeZone - sdf3

System.out.println(x1); // Imprime a data no padrão local
System.out.println(y1);
System.out.println("----------------------");
System.out.println("x1: " + sdf2.format(x1)); // Para imprimir no padrão sdf2, utilizar o parametro format
System.out.println("x2: " + sdf2.format(x2));
System.out.println("x3: " + sdf2.format(x3));
System.out.println("x4: " + sdf2.format(x4));
System.out.println("y1: " + sdf2.format(y1));
System.out.println("y2: " + sdf2.format(y2));
System.out.println("y2: " + sdf2.format(y3)); // Note que será impresso com diferença de -3 GTM
System.out.println("----------------------");
System.out.println("x1: " + sdf3.format(x1)); // Todos agora no formato UTC
System.out.println("x2: " + sdf3.format(x2));
System.out.println("x3: " + sdf3.format(x3));
System.out.println("x4: " + sdf3.format(x4));
System.out.println("y1: " + sdf3.format(y1));
System.out.println("y2: " + sdf3.format(y2));
System.out.println("y2: " + sdf3.format(y3));
```

### 8.2. Manipulando datas com Calendar

#### 8.2.1. Somando uma unidade de tempo

```java
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

Date d = Date.from(Instant.parse("2050-06-25T15:42:07Z"));

System.out.println(sdf.format(d)); // 25/06/2050 12:42:07

Calendar cal = Calendar.getInstance();
cal.setTime(d);
cal.add(Calendar.HOUR_OF_DAY, 4); 
d = cal.getTime();

System.out.println(sdf.format(d)); // 25/06/2050 16:42:07
```

#### 8.2.2. Obtendo uma unidade de tempo

```java
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));

System.out.println(sdf.format(d)); // 25/06/2050 12:42:07

Calendar cal = Calendar.getInstance();
cal.setTime(d);
int minutes = cal.get(Calendar.MINUTE);
int month = 1 + cal.get(Calendar.MONTH); // Soma 1 pois o Calendar começa o mês em 0

System.out.println("Minutes: " + minutes); // Minutes: 42
System.out.println("Month: " + month); // Minutes: 06
```

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
