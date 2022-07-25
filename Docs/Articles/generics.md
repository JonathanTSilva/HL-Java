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

<!-- MARKDOWN LINKS -->
<!-- SITES -->

<!-- IMAGES -->