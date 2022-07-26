<!-- LOGO DIREITO -->
<a href="#"><img width="300px" src="https://www.edureka.co/blog/wp-content/uploads/2017/05/Collection-framework-hierarchy.png" align="right" /></a>

# Generics

<p align="left">
  <a href="https://github.com/JonathanTSilva/HL-Java">
    <img src="https://img.shields.io/static/v1?label=HomeLab&message=Java&color=red&logo=java&logoColor=white&labelColor=grey&style=flat" alt="HL-Java">
  </a>
</p>

🔎 Introdução ao Generics, Set e Map.

<!-- SUMÁRIO -->
- [Generics](#generics)
  - [1. Introdução ao Generics](#1-introdução-ao-generics)
    - [1.1. Problemas motivadores](#11-problemas-motivadores)
      - [1.1.1 Reuso](#111-reuso)
      - [1.1.2. *Type safety* & performance](#112-type-safety--performance)
    - [1.2. Solução com Generics](#12-solução-com-generics)
  - [2. Genéricos delimitados](#2-genéricos-delimitados)
    - [2.1. Solução não genérica simples](#21-solução-não-genérica-simples)
  - [3. Tipos curinga (*wildcard types*)](#3-tipos-curinga-wildcard-types)
  - [4. Curingas delimitadas (*bounded wildcards*)](#4-curingas-delimitadas-bounded-wildcards)
    - [4.1. Problemas motivadores](#41-problemas-motivadores)
      - [4.1.1. Tipos curinga](#411-tipos-curinga)
      - [4.1.2. Princípio *get/put*](#412-princípio-getput)
  - [5. `hashCode` e `equals`](#5-hashcode-e-equals)
    - [5.1. `equals`](#51-equals)
    - [5.2. `hashCode`](#52-hashcode)
    - [5.3. Personalizados](#53-personalizados)

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 1. Introdução ao Generics

Generics permitem que **classes**, **interfaces** e **métodos** possam ser parametrizados por tipo. Seus benefícios são:

- Reuso
- *Type safety*
- Performance
- Uso comum: **coleções**

```java
List<String> list = new ArrayList<>();
list.add("Maria");
String name = list.get(0);
```

### 1.1. Problemas motivadores

#### 1.1.1 Reuso

Deseja-se fazer um programa que leia uma quantidade N, e depois N números inteiros. Ao final, imprima esses números de forma organizada conforme exemplo. Em seguida, informar qual foi o primeiro valor informado.

<details close="close" align="left">
  <summary><b>Exemplo</b></summary>
  <pre>
    <code>
How many values? 3
10
8
23
[10, 8, 23]
First: 10
    </code>
  </pre>
</details>

**src > application > Program.java**

```java
package application;

import java.util.Scanner;

import services.PrintService;

public class Program {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        PrintService ps = new PrintService();
        
        System.out.print("How many values? ");
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            ps.addValue(value);
        }
        
        ps.print();
        System.out.println("First: " + ps.first());
        
        sc.close();
        
    }

}
```

**src > services > PrintServiceInteger.java**

```java
package services;

import java.util.ArrayList;
import java.util.List;

public class PrintService {

    private List<Integer> list = new ArrayList<>();
    
    public void addValue(Integer value) {
        list.add(value);
    }
    
    public Integer first() {
        if (list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return list.get(0);
    }
    
    public void print() {
        System.out.print("[");
        if (!list.isEmpty()) {
            System.out.print(list.get(0));
        }
        for (int i = 1; i < list.size(); i++) {
            System.out.print(", " + list.get(i));
        }
        System.out.println("]");
    }
    
}
```

#### 1.1.2. *Type safety* & performance

Deseja-se fazer um programa que leia uma quantidade N, e depois N nomes de pessoas. Ao final, imprima esses números de forma organizada conforme exemplo. Em seguida, informar qual foi o primeiro valor informado.

Caso queira desenvolver uma solução pelo problema anterior, é só copiar o serviço PrintServiceInteger.java para outro PrintServiceString.java, alterando tudo de Integer para String. No caso, para generalizar, utilizaremos o tipo Object.

<details close="close" align="left">
  <summary><b>Exemplo</b></summary>
  <pre>
    <code>
How many values? 3
Ana
Maria
Pedro
[Ana, Maria, Pedro]
First: Ana
    </code>
  </pre>
</details>

**src > application > Program.java**

```java
package application;

import java.util.Scanner;

import services.PrintService;

public class Program {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        PrintService ps = new PrintService();
        
        System.out.print("How many values? ");
        int n = sc.nextInt();
        
        // Problema na segurança de tipos (type safety)
        ps.addValue("Maria");
        
        for (int i = 0; i < n; i++) {
            Integer value = sc.nextInt();
            ps.addValue(value);
        }
        
        ps.print();
        Integer x = (Integer) ps.first();
        System.out.println("First: " + x);
        
        sc.close();
        
    }
    
}
```

**src > services > PrintService.java**

```java
package services;

import java.util.ArrayList;
import java.util.List;

public class PrintService {

    private List<Object> list = new ArrayList<>();
    
    public void addValue(Object value) {
        list.add(value);
    }
    
    public Object first() {
        if (list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return list.get(0);
    }
    
    public void print() {
        System.out.print("[");
        if (!list.isEmpty()) {
            System.out.print(list.get(0));
        }
        for (int i = 1; i < list.size(); i++) {
            System.out.print(", " + list.get(i));
        }
        System.out.println("]");
    }
    
}
```

### 1.2. Solução com Generics

A melhor solução para os problemas supracitados é utilizando o Generics, criando um serviço de impressão parametrizado com um tipo X (tipo qualquer - qualquer letra ou nome), o que garante o reuso e *type safety*:

**src > application > Program.java**

```java
package application;

import java.util.Scanner;

import services.PrintService;

public class Program {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        PrintService<String> ps = new PrintService<>();
        
        System.out.print("How many values? ");
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            String value = sc.next();
            ps.addValue(value);
        }
        
        ps.print();
        String x = ps.first();
        System.out.println("First: " + x);
        
        sc.close();
        
    }
    
}
```

**src > services > PrintService.java**

```java
package services;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {

    private List<T> list = new ArrayList<>();
    
    public void addValue(T value) {
        list.add(value);
    }
    
    public T first() {
        if (list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return list.get(0);
    }
    
    public void print() {
        System.out.print("[");
        if (!list.isEmpty()) {
            System.out.print(list.get(0));
        }
        for (int i = 1; i < list.size(); i++) {
            System.out.print(", " + list.get(i));
        }
        System.out.println("]");
    }
    
}
```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 2. Genéricos delimitados

Uma empresa de consultoria deseja avaliar a performance de produtos, funcionários, dentre outras coisas. Um dos cálculos que ela precisa é encontrar o maior dentre um conjunto de elementos. Fazer um programa que leia um conjunto de produtos a partir de um arquivo, conforme exemplo, e depois mostre o mais caro deles.

<details close="close" align="left">
  <summary><b>Exemplo</b></summary>
  <pre>
    <code>
Computer,890.50
IPhone X,910.00
Tablet,550.00
Most expensive:
IPhone, 910.00
    </code>
  </pre>
</details>

### 2.1. Solução não genérica simples

**src > application > Program.java**

```java
package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;
import services.CalculationService;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        
        List<Product> list = new ArrayList<>();

        String path = "/tmp/in.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }
            
            Product x = CalculationService.max(list);
            System.out.println("Most expensive:");
            System.out.println(x);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } 
    }

}
```

**src > entities > Product.java**

```java
package entities;

public class Product implements Comparable<Product> {

    private String name;
    private Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", " + String.format("%.2f", price);
    }

    @Override
    public int compareTo(Product other) {
        return price.compareTo(other.getPrice());
    }
    
}
```

**src > services > CalculationService.java**

```java
package services;

import java.util.List;

public class CalculationService {

    public static <T extends Comparable<T>> T max(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException("List can't be empty");
        } 
        T max = list.get(0);
        for (T item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }

}
```

Para uma versão alternativa (completa), o certo é dizer que T extends Comparable<? super T>, ou seja, é um tipo comparável T ou qualquer superclasse de T.

```java
public static <T extends Comparable<? super T>> T max(List<T> list) {
    if (list.isEmpty()) {
        throw new IllegalStateException("List can't be empty");
    }
    T max = list.get(0);
    for (T item : list) {
        if (item.compareTo(max) > 0) {
            max = item;
        }
    }
    return max;
}
```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 3. Tipos curinga (*wildcard types*)

`List<Object>` não é o super-tipo de qualquer tipo de lista:

```java
List<Object> myObjs = new ArrayList<Object>();
List<Integer> myNumbers = new ArrayList<Integer>();
myObjs = myNumbers; // erro de compilação
```

O super-tipo de qualquer tipo de lista é `List<?>`. Este é um tipo curinga:

```java
List<?> myObjs = new ArrayList<Object>();
List<Integer> myNumbers = new ArrayList<Integer>();
myObjs = myNumbers;
```

Com tipos curinga podemos fazer métodos que recebem um genérico de "qualquer tipo":

```java
package application;

import java.util.Arrays;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Integer> myInts = Arrays.asList(5, 2, 10);
        printList(myInts);
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
```

Porém não é possível adicionar dados a uma coleção de tipo curinga:

```java
package application;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<?> list = new ArrayList<Integer>();
        list.add(3); // erro de compilação
    }
}
```

O compilador não sabe qual é o tipo específico do qual a lista foi instanciada.

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 4. Curingas delimitadas (*bounded wildcards*)

### 4.1. Problemas motivadores

#### 4.1.1. Tipos curinga

Vamos fazer um método para retornar a soma das áreas de uma lista de figuras.

> **Nota 1:** soluções impróprias:
> `public double totalArea(List<Shape> list)`
> `public double totalArea(List<?> list)`
>
> **Nota 2:** não conseguiremos adicionar elementos na lista do método

**src > application > Program.java**

```java
package application;

import java.util.ArrayList;
import java.util.List;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;

public class Program {

    public static void main(String[] args) {
        
        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));
        
        List<Circle> myCircles = new ArrayList<>();
        myCircles.add(new Circle(2.0));
        myCircles.add(new Circle(3.0));
        
        System.out.println("Total area: " + totalArea(myCircles));
    }

    public static double totalArea(List<? extends Shape> list) {
        double sum = 0.0;
        for (Shape s : list) {
            sum += s.area();
        }
        return sum;
    }

}
```

**src > entities > Shape.java**

```java
package entities;

public interface Shape {

    double area();

}
```

**src > entities > Circle.java**

```java
package entities;

public class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
    
}
```

**src > entities > Rectangle.java**

```java
package entities;

public class Rectangle implements Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

}
```

#### 4.1.2. Princípio *get/put*

Vamos fazer um método que copia os elementos de uma lista para uma outra lista que pode ser mais genérica que a primeira.

```java
List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
List<Double> myDoubles = Arrays.asList(3.14, 6.28);
List<Object> myObjs = new ArrayList<Object>();

copy(myInts, myObjs);
copy(myDoubles, myObjs);
```

![wrapperTypes][A]

> **Nota:** os tipos numéricos possuem uma superclasse intermediária `Number`

**Covariância**

- *get* - **OK**
- *put* - **FAIL**, pois o compilador não sabe se o número inteiro adicionado será compatível com algum outro possível tipo `Number` que possa ser a lista.

```java
List<Integer> intList = new ArrayList<Integer>();
intList.add(10);
intList.add(5);
List<? extends Number> list = intList;
Number x = list.get(0);
list.add(20); // erro de compilacao
```

**Contra-variância**

- *get* - **FAIL**, a atribuição não pode ser realizada pois o tipo da lista pode ser um tipo que seja um super tipo de `Number`.
- *put* - **OK**

```java
List<Object> myObjs = new ArrayList<Object>();
myObjs.add("Maria");
myObjs.add("Alex");
List<? super Number> myNums = myObjs;
myNums.add(10);
myNums.add(3.14);
Number x = myNums.get(0); // erro de compilacao
```

**Solução**

```java
package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs = new ArrayList<Object>();

        copy(myInts, myObjs);
        printList(myObjs);
        copy(myDoubles, myObjs);
        printList(myObjs);
    }

    public static void copy(List<? extends Number> source, List<? super Number> destiny) {
        for(Number number : source) {
            destiny.add(number);
        }
    }

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

}
```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 5. `hashCode` e `equals`

São operações da classe Object utilizadas para comparar se um objeto é igual a outro

- equals: lento, resposta 100%
- hashCode: rápido, porém resposta positiva não é 100% - pequena probabilidade de dar um falso positivo

Tipos comuns (`String`, `Date`, `Integer`, `Double`, etc.) já possuem implementação para essas operações. Classes personalizadas precisam sobrepô-las.

### 5.1. `equals`

Método que compara se o objeto é igual a outro, retornando true ou false.

```java
String a = "Maria";
String b = "Alex";
System.out.println(a.equals(b));
```

### 5.2. `hashCode`

Método que retorna um número inteiro representando um código gerado a partir das informações do objeto

```java
String a = "Maria";
String b = "Alex";
System.out.println(a.hashCode());
System.out.println(b.hashCode());
```

Se o hashCode de dois objetos for diferente, então os dois objetos são diferentes

![hashCode][B]

Se o código de dois objetos for igual, muito provavelmente os objetos são iguais (pode haver colisão)

### 5.3. Personalizados

```java
public class Client {
    private String name;
    private String email;

    [Generate Constructor using Fields...]

    [Generate Getters and Setters...]

    [Generate hashCode() and equals()...]
}
```

<!-- MARKDOWN LINKS -->
<!-- SITES -->

<!-- IMAGES -->
[A]: ../../Images/javaWrapperTypes.png
[B]: ../../Images/hashCode.png
