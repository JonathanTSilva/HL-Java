<!-- LOGO DIREITO -->
<a href="#"><img width="300px" src="https://miro.medium.com/max/582/1*UbiDJBxhB0oOej8VOMGh3A.png" align="right" /></a>

# Programação funcional e expressões lambda

<p align="left">
  <a href="https://github.com/JonathanTSilva/HL-Java">
    <img src="https://img.shields.io/static/v1?label=HomeLab&message=Java&color=red&logo=java&logoColor=white&labelColor=grey&style=flat" alt="HL-Java">
  </a>
</p>

🔎 Desvendando um novo paradigma de programação que trata a computação como uma avaliação de funções matemáticas.

<!-- SUMÁRIO -->
- [Programação funcional e expressões lambda](#programação-funcional-e-expressões-lambda)
  - [1. Uma experiência com Comparator](#1-uma-experiência-com-comparator)
  - [2. Introdução](#2-introdução)
    - [2.1. Paradigmas de programação](#21-paradigmas-de-programação)
    - [2.2. Paradigma funcional](#22-paradigma-funcional)
    - [2.3. Transparência referencial](#23-transparência-referencial)
    - [2.4. Funções são objetos de primeira ordem (ou primeira classe)](#24-funções-são-objetos-de-primeira-ordem-ou-primeira-classe)
    - [2.5. Expressividade / código consiso](#25-expressividade--código-consiso)
    - [2.6. Tipagem dinâmica / Inferências de tipos](#26-tipagem-dinâmica--inferências-de-tipos)
    - [2.7. O que são expressões lambda?](#27-o-que-são-expressões-lambda)
  - [3. Interface funcional](#3-interface-funcional)
    - [3.1. Predicate](#31-predicate)
    - [3.2. Consumer](#32-consumer)
    - [3.3. Function](#33-function)
    - [3.4. Criando funções que recebem funções como parâmetros](#34-criando-funções-que-recebem-funções-como-parâmetros)
  - [4. Stream](#4-stream)
    - [4.1. Características](#41-características)
    - [4.2. Operações intermediárias e terminais](#42-operações-intermediárias-e-terminais)
    - [4.3. Criar uma stream](#43-criar-uma-stream)
      - [4.3.1. Demonstração de stream](#431-demonstração-de-stream)
      - [4.3.2. Demonstração de pipeline](#432-demonstração-de-pipeline)

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 1. Uma experiência com Comparator

- Suponha uma classe Product com os atributos name e price.
- Podemos implementar a comparação de produtos por meio da implementação da interface `Comparable<Product>`.
- Entretanto, desta forma nossa classe não fica fechada para alteração: se o critério de comparação mudar, precisaremos alterar a classe Product.
- Podemos então usar o default method "sort" da interface List: `default void sort(Comparator<? super E> c)`.

**src > application > Program.java**

```java
package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));

        // Implementação 1 - MyComparator
        // list.sort(new MyComparator());

        // Implementação 2 - Classe anônima
        // Comparator<Product> comp = new Comparator<Product>() {
        //     @Override
        //     public int compare(Product p1, Product p2) {
        //         return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        //     }
        // }
        // list.sort(comp);
        
        // Implementação 3 - Expressões lambda; arrow function
        // Comparator<Product> comp = (p1, p2) -> {
        //     return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        // };
        // ou
        // Comparator<Product> comp = (p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        // list.sort(comp);

        // Implementação 4 - Resumir ainda mais o código acima
        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));

        for (Product p : list) {
            System.out.println(p);
        }
    }
}
```

**src > application > MyComparator.java**

```java
package application;

import java.util.Comparator;

import entities.Product;

public class MyComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    }

}
```

**src > entities > Product.java**

```java
package entities;

public class Product {

    private String name;
    private Double price;

    [Generate Constructor using Fields...]

    [Generate Getters and Setters...]

    [Generate toString()...]

}
```

Logo, nesta seção vimos:

- Comparator objeto de classe separada
- Comparator objeto de classe anônima
- Comparator objeto de expressão lambda com chaves
- Comparator objeto de expressão lambda sem chaves
- Comparator expressão lambda "direto no argumento"

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 2. Introdução

### 2.1. Paradigmas de programação

- **Imperativo** (C, Pascal, Fortran, Cobol)
- **Orientado a objetos** (C++, Object Pascal, Java (< 8), C# (< 3))
- **Funcional** (Haskell, Closure, Clean, Erlang)
- **Lógico** (Prolog)
- **Multi-paradigma** (JavaScript, Java (8+), C# (3+), Ruby, Python, Go)

### 2.2. Paradigma funcional

Baseado no formalismo matemático Cálculo Lambda (Church 1930)

![B]

Programação funcional é o processo de construir software através de composição de funções puras, evitando compartilhamento de estados, dados mutáveis e efeitos colaterais. É declarativa ao invés de Imperativa.

A inspiração do paradigma funcional veio dos matemáticos teóricos que lidam com grandes abstrações:

![A]

Eles costumam trabalhar com sistemas complexos e a maneira como eles encontraram para se manterem organizados e chegar no objetivo final foi através das funções. Se trouxermos para nosso mundo de desenvolvimento, existe uma certa analogias de que trabalhamos com sistemas complexos e com abstrações.

Então o paradigma funcional foi inspirado nesse modelo de trabalho onde as funções são utilizadas para lidar com abstrações e aplicou no desenvolvimento de sistemas.

### 2.3. Transparência referencial

Uma função possui transparência referencial se seu resultado for sempre o mesmo para os mesmos dados de entrada. Benefícios: simplicidade e previsibilidade.

Exemplo de função que não é referencialmente transparente, ou seja, o resultado da função não depende exclusivamente dos valores de entrada:

```java
package application;

import java.util.Arrays;

public class Program {

    public static int globalValue = 3;

    public static void main(String[] args) {
        int[] vect = new int[] {3, 4, 5};
        changeOddValues(vect);
        System.out.println(Arrays.toString(vect));
    }

    public static void changeOddValues(int[] numbers) {
        for (int i=0; i<numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                numbers[i] += globalValue;
            }
        }
    }
}
```

### 2.4. Funções são objetos de primeira ordem (ou primeira classe)

Isso significa que funções podem, por exemplo, serem passadas como parâmetros de métodos, bem como retornadas como resultado de métodos.

Utilizamos aqui "method references"
`Operador::`

Sintaxe: `Classe::método`

```java
public class Program {
    public static int compareProducts(Product p1, Product p2) {
        return p1.getPrice().compareTo(p2.getPrice());
    }

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));
        list.sort(Program::compareProducts);
        list.forEach(System.out::println);
    }
}
```

### 2.5. Expressividade / código consiso

```java
Integer sum = 0;
for (Integer x : list) {
    sum += x;
}
```

vs.

```java
Integer sum = list.stream().reduce(0, Integer::sum);
```

### 2.6. Tipagem dinâmica / Inferências de tipos

Não é preciso declarar que variáveis são de algum tipo, o próprio compilador já o faz.

```java
list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
```

### 2.7. O que são expressões lambda?

Em programação funcional, expressões lambda corresponde a uma função anônima de primeira classe.

```java
public class Program {
    public static int compareProducts(Product p1, Product p2) {
        return p1.getPrice().compareTo(p2.getPrice());
    }

    public static void main(String[] args) {
    (...)

    list.sort(Program::compareProducts);
    list.sort((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()));

    (...)
```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 3. Interface funcional

É uma interface que possui um único método abstrato. Suas implementações serão tratadas como expressões lambda.

```java
public class MyComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    }
}
```

```java
public static void main(String[] args) {
    (...)
    list.sort(new MyComparator());
```

Algumas outras interfaces funcionais comuns:

- [Predicate][1]
- [Function][2]
- [Consumer][3]
  - Nota: ao contrário das outras interfaces funcionais, no caso do Consumer, é esperado que ele possa gerar efeitos colaterais.

### 3.1. Predicate

Uma interface funcional generics, parametrizada com o tipo T, e contém apenas um método abstrato `test`, que retornará verdadeiro ou falso.

```java
public interface Predicate<T> {
    boolean test(T t);
}
```

**Problema exemplo com `removeIf`:**

Fazer um programa que, a partir de uma lista de produtos, remova da lista somente aqueles cujo preço mínimo seja 100.

```java
List<Product> list = new ArrayList<>();
list.add(new Product("Tv", 900.00));
list.add(new Product("Mouse", 50.00));
list.add(new Product("Tablet", 350.50));
list.add(new Product("HD Case", 80.90));
```

**Versões:**

- Implementação da interface
  - `ProductPredicate`
  - `list.removeIf(new ProductPredicate())`
- Reference method com método estático (trabalha com o argumento)
  - `public static boolean staticProductPredicate(Product p)`
  - `list.removeIf(Product::staticProductPredicate)`
- Reference method com método não estático (trabalha com o próprio objeto)
  - `public boolean nonStaticProductPredicate()`
  - `list.removeIf(Product::nonStaticProductPredicate)`
- Expressão lambda declarada
  - `Predicate<Product> pred = p -> p.getPrice() >= 100.0`
  - `list.removeIf(pred)`
- Expressão lambda inline
  - `list.removeIf(p -> p.getPrice() >= 100.0)`

### 3.2. Consumer

Uma interface funcional generics, parametrizada com o tipo T, e contém apenas um método abstrato `accept`, que é um void.

```java
public interface Consumer<T> {
    void accept(T t);
}
```

**Problema exemplo com `forEach`**

Fazer um programa que, a partir de uma lista de produtos, aumente o preço dos produtos em 10%.

```java
List<Product> list = new ArrayList<>();
list.add(new Product("Tv", 900.00));
list.add(new Product("Mouse", 50.00));
list.add(new Product("Tablet", 350.50));
list.add(new Product("HD Case", 80.90));
```

- Implementação da interface
  - `PriceUpdate`
  - `list.forEach(new PriceUpdate())`
- Reference method com método estático (trabalha com o argumento)
  - `public static boolean staticPriceUpdate(Product p)`
  - `list.removeIf(Product::staticPriceUpdate)`
- Reference method com método não estático (trabalha com o próprio objeto)
  - `public boolean nonStaticPriceUpdate()`
  - `list.removeIf(Product::nonStaticPriceUpdate)`
- Expressão lambda declarada
  - `Consumer<Product> cons = p -> p.setPrice(p.getPrice() * 1.1)`
  - `list.removeIf(cons)`
- Expressão lambda inline
  - `list.removeIf(p -> p.setPrice(p.getPrice() * 1.1))`

### 3.3. Function

Uma interface funcional generics, parametrizada com o tipo T e tipo R, e contém apenas um método abstrato `apply`, que recebe um T e retorna um R.

```java
public interface Function<T, R> {
    R apply(T t);
}
```

**Problema exemplo com `map`**

Fazer um programa que, a partir de uma lista de produtos, gere uma nova lista contendo os nomes dos produtos em caixa alta.

```java
List<Product> list = new ArrayList<>();
list.add(new Product("Tv", 900.00));
list.add(new Product("Mouse", 50.00));
list.add(new Product("Tablet", 350.50));
list.add(new Product("HD Case", 80.90));
```

A função "map" (não confunda com a estrutura de dados Map) é uma função que aplica uma função a todos elementos de uma stream.

- Conversões:
  - List para stream: `.stream()`
  - Stream para List: `.collect(Collectors.toList())`

- Implementação da interface
  - `list.stream().map(new UpperCaseName()).collect(Collectors.toList())`
- Reference method com método estático (trabalha com o argumento)
  - `list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList())`
- Reference method com método não estático (trabalha com o próprio objeto)
  - `list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList())`
- Expressão lambda declarada
  - `Function<Product, String> func = p -> p.getName().toUpperCase()`
  - `list.stream().map(func).collect(Collectors.toList())`
- Expressão lambda inline
  - `list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList())`

### 3.4. Criando funções que recebem funções como parâmetros

**Problema exemplo**

Fazer um programa que, a partir de uma lista de produtos, calcule a soma dos preços somente dos produtos cujo nome começa com "T".

```java
List<Product> list = new ArrayList<>();
list.add(new Product("Tv", 900.00));
list.add(new Product("Mouse", 50.00));
list.add(new Product("Tablet", 350.50));
list.add(new Product("HD Case", 80.90));
```

**src > application > Program.java**

```java
Locale.setDefault(Locale.US);
List<Product> list = new ArrayList<>();

list.add(new Product("Tv", 900.00));
list.add(new Product("Mouse", 50.00));
list.add(new Product("Tablet", 350.50));
list.add(new Product("HD Case", 80.90));

ProductService ps = new ProductService();

double sum = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');

System.out.println("Sum = " + String.format("%.2f", sum));
```

**src > model.entities > Product.java**

```java
package entities;

public class Product {

    private String name;
    private Double price;

    [Generate Constructor using Fields...]

    [Generate Getters and Setters...]

    [Generate toString()...]

}
```

**src > modal.services > ProductService.java**

```java
public double filteredSum(List<Product> list, Predicate<Product> criteria) {
    double sum = 0.0;
    for (Product p : list) {
        if (criteria.test(p)) {
            sum += p.getPrice();
        }
    }
    return sum;
}
```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 4. Stream

É uma sequencia de elementos advinda de uma fonte de dados que oferece suporte a "operações agregadas".

Fonte de dados: coleção, array, função de iteração, recurso de E/S.

Leitura complementar: [Java 8: Iniciando o desenvolvimento com a Streams API][4].

### 4.1. Características

- Stream é uma solução para processar sequências de dados de forma:
  - Declarativa (iteração interna: escondida do programador)
  - Parallel-friendly (imutável -> thread safe) - paralelizado de forma segura
  - Sem efeitos colaterais
  - Sob demanda (lazy evaluation - avaliação tardia - os dados de uma stream serão consumidos apenas quando necessário)
- Acesso sequencial (não há índices)
- Single-use: só pode ser "usada" uma vez
- **Pipeline**: operações em streams retornam novas streams. Então é possível criar uma cadeia de operações (fluxo de processamento).

### 4.2. Operações intermediárias e terminais

- O pipeline é composto por zero ou mais operações intermediárias e uma terminal.
- Operação intermediária:
  - Produz uma nova streams (encadeamento)
  - Só executa quando uma operação terminal é invocada (lazy evaluation)
  - São operações intermediárias:
    - `filter`
    - `map`
    - `flatmap`
    - `peek`
    - `distinct`
    - `sorted`
    - `skip`
    - `limit` (*)
    - (*) *short-circuit* - param assim que encontrarem o que satisfaz condição.
- Operação terminal:
  - Produz um objeto não-stream (coleção ou outro)
  - Determina o fim do processamento da stream
  - São operações terminais:
    - `forEach`
    - `forEachOrdered`
    - `toArray`
    - `reduce`
    - `collect`
    - `min`
    - `max`
    - `count`
    - `anyMatch` (*)
    - `allMatch` (*)
    - `noneMatch` (*)
    - `findFirst` (*)
    - `findAny` (*)
    - (*) *short-circuit*

### 4.3. Criar uma stream

Basta chamar o método stream() ou parallelStream() a partir de qualquer objeto Collection.
- Outras formas de se criar uma stream incluem:
  - Stream.of
  - Stream.ofNullable
  - Stream.iterate
  
#### 4.3.1. Demonstração de stream

```java
List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
Stream<Integer> st1 = list.stream();
System.out.println(Arrays.toString(st1.toArray()));

Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
System.out.println(Arrays.toString(st2.toArray()));

Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
System.out.println(Arrays.toString(st3.limit(10).toArray()));

// Sequencia de Fibonacci
Stream<Long> st4 = Stream.iterate(new long[]{ 0L, 1L }, p->new long[]{ p[1], p[0]+p[1] }).map(p -> p[0]);
System.out.println(Arrays.toString(st4.limit(10).toArray()));
```

#### 4.3.2. Demonstração de pipeline

```java
List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);

Stream<Integer> st1 = list.stream().map(x -> x * 10);
System.out.println(Arrays.toString(st1.toArray()));

int sum = list.stream().reduce(0, (x, y) -> x + y);
System.out.println("Sum = " + sum);

List<Integer> newList = list.stream()
.filter(x -> x % 2 == 0)
.map(x -> x * 10)
.collect(Collectors.toList());
System.out.println(Arrays.toString(newList.toArray()));
```

<!-- MARKDOWN LINKS -->
<!-- SITES -->
[1]: https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
[2]: https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
[3]: https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html
[4]: https://www.oracle.com/br/technical-resources/articles/java-stream-api.html
[5]: https://docs.oracle.com/javase/10/docs/api/java/util/Collection.html

<!-- IMAGES -->
[A]: https://www.alura.com.br/artigos/assets/programacao-funcional-o-q-e/imagem1.png
[B]: ../../Images/paradigmas.png