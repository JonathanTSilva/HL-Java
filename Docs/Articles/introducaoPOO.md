<!-- LOGO DIREITO -->
<a href="#"><img width="200px" src="https://miro.medium.com/max/600/0*7zMicw-FfThCbN35.png" align="right" /></a>

# Introdução à Programação Orientada a Objetos

<p align="left">
  <a href="https://github.com/JonathanTSilva/HL-Java">
    <img src="https://img.shields.io/static/v1?label=HomeLab&message=Java&color=red&logo=java&logoColor=white&labelColor=grey&style=flat" alt="HL-Java">
  </a>
</p>

🏛 Uma introdução à Programação Orientada a Objetos (POO).

<!-- SUMÁRIO -->
- [Introdução à Programação Orientada a Objetos](#introdução-à-programação-orientada-a-objetos)
  - [1. O que é a POO?](#1-o-que-é-a-poo)
  - [2. Recursos da POO](#2-recursos-da-poo)
    - [2.1. Classe](#21-classe)
    - [2.2. Instanciação](#22-instanciação)
  - [3. Membros estáticos](#3-membros-estáticos)
    - [3.1. Métodos na própria classe do programa](#31-métodos-na-própria-classe-do-programa)
    - [3.2. Métodos em outra classe com membros de instância](#32-métodos-em-outra-classe-com-membros-de-instância)
    - [3.3. Métodos em outra classe com membros estáticos](#33-métodos-em-outra-classe-com-membros-estáticos)
  - [4. Exemplos práticos](#4-exemplos-práticos)
    - [4.1. Área triângulo](#41-área-triângulo)
      - [4.1.1. Sem POO](#411-sem-poo)
      - [4.1.2. Com classe](#412-com-classe)
      - [4.1.3. Com método](#413-com-método)
    - [4.2. Produto no estoque](#42-produto-no-estoque)
  - [5. Construtores](#5-construtores)
  - [6. Palavra *this*](#6-palavra-this)
  - [7. Sobrecarga](#7-sobrecarga)
  - [8. Encapsulamento](#8-encapsulamento)
    - [8.1. Como gerar os métodos `set` e `get` automaticamente?](#81-como-gerar-os-métodos-set-e-get-automaticamente)
  - [9. Diagrama UML](#9-diagrama-uml)

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 1. O que é a POO?

Antes de definir o que é Programação Orientada a Objetos, é preciso pontuar algumas questões de outro paradigma de programação: a programação estruturada. Neste tipo de programa, é possível observar três tipos básicos de estruturas:

- sequências: são os comandos a serem executados;
- condições: sequências que só devem ser executadas se uma condição for satisfeita (exemplos: `if-else`, `switch` e comandos parecidos);
- repetições: sequências que devem ser executadas repetidamente até uma condição for satisfeita (`for`, `while`, `do-while` etc).

A diferença principal é que na programação estruturada, um programa é tipicamente escrito em uma única rotina (ou função) podendo, é claro, ser quebrado em subrotinas, mas ainda mantendo o fluxo do programa. Além disso, o acesso às variáveis não possuem muitas restrições em linguagens fortemente baseadas neste paradigma, visto que restringir o acesso à uma variável se limita a dizer se ela é visível ou não dentro de uma função (ou módulo, como no uso da palavra-chave static, na linguagem C), mas não se consegue dizer de forma nativa que uma variável pode ser acessada por apenas algumas rotinas do programa.

A **programação orientada a objetos** surgiu como uma alternativa a essas características da programação estruturada. O intuito da sua criação também foi o de aproximar o manuseio das estruturas de um programa ao manuseio das coisas do mundo real, daí o nome "objeto" como uma algo genérico, que pode representar qualquer coisa tangível.

Esse novo paradigma se baseia principalmente em dois conceitos chave: **classes** e **objetos**. Todos os outros conceitos, igualmente importantes, são construídos em cima desses dois.

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 2. Recursos da POO

### 2.1. Classe

- Classe é um tipo estruturado que pode conter (membros):
  - Atributos (dados/campos);
  - Métodos (funções/operações).
- A classe também pode prover outros recursos, tais como:
  - Construtores;
  - Sobrecarga;
  - Encapsulamento;
  - Herança;
  - Polimorfismo.
- Exemplos:
  - Entidades: Produto, Cliente, Triangulo;
  - Serviços: ProdutoService, ClienteService, EmailService, StorageService;
  - Controladores: ProdutoController, ClienteController;
  - Utilitários: Calculadora, Compactador;
  - Outros (views, repositórios, gerenciadores, etc.)

Toda a classe em Java é uma subclasse da classe `Object`; que por sua vez, possui os seguintes métodos:

- `getClass` - retorna o tipo de objeto;
- `equal` - compara se o objeto é igual a outro;
- `hashCode` - retorna um código hash do objeto;
- `toString` - converto o objeto para string.

### 2.2. Instanciação

A instanciação é um processo por meio do qual se realiza a cópia de um objeto (classe) existente. Uma classe, a qual tem a função de determinar um tipo de dado, deve ser instanciada para que possamos utilizá-la.

![instanciacao][B]

<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 3. Membros estáticos

Os membros são atributos e métodos dentro de uma classe.

- Membros estáticos são chamados de membros de classe, em oposição a membros de instância;
- São membros que fazem sentido independentemente de objetos. Não precisam de objeto para serem chamados. São chamados a partir do próprio nome da classe.
- Aplicações comuns:
  - Classes utilitárias (e.g. `Math.sqrt(double)`);
  - Declaração de constantes.
- Uma classe que possui somente membros estáticos, pode ser uma classe estática também. Esta classe não poderá ser instanciada.

**Problema exemplo:** programa para ler um valor numérico qualquer, e daí mostrar quanto seria o valor de uma circunferência e do volume de uma esfera para um raio daquele valor. Informar também o valor de PI com duas casas decimais.

### 3.1. Métodos na própria classe do programa

> **Nota:** dentro de um método estático você não pode chamar membros de instância da mesma classe.

**application > Program.java**

```java
package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

  public static final double PI = 3.14159; 
  // final para dizer que o valor não pode ser alterado (constante)
  // TUDO EM MAIÚSCULO é o padrão do java para constantes

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter radius: ");
    double radius = sc.nextDouble();

    double c = circumference(radius);
    double v = volume(radius);

    System.out.printf("Circumference: %.2f%n", c);
    System.out.printf("Volume: %.2f%n", v);
    System.out.printf("PI value: %.2f%n", PI);

    sc.close();
  }

  public static double circumference(double radius) {
    return 2.0 * PI * radius;
  }

  public static double volume(double radius) {
    return 4.0 * PI * radius * radius * radius / 3.0;
  }
}
```

> **Nota:** os métodos devem ser estáticos, pois não é possível chamar um método que não é estático da mesma classe, dentro de um outro método que seja estático.

### 3.2. Métodos em outra classe com membros de instância

Aplicar o princípio de delegação para a classe Calculator:

**util > Calculator.java**

```java
package util;

public class Calculator {
  public final double PI = 3.14159;

  public double circumference(double radius) {
    return 2.0 * PI * radius;
  }

  public double volume(double radius) {
    return 4.0 * PI * radius * radius * radius / 3.0;
  }
}
```

**application > Program.java**

```java
package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    // Calculator calc = new Calculator();
    // Não é preciso mais instanciar pois eles são estáticos agora

    System.out.print("Enter radius: ");
    double radius = sc.nextDouble();

    double c = Calculator.circumference(radius);
    double v = Calculator.volume(radius);

    System.out.printf("Circumference: %.2f%n", c);
    System.out.printf("Volume: %.2f%n", v);
    System.out.printf("PI value: %.2f%n", Calculator.PI);

    sc.close();
  }
}
```

### 3.3. Métodos em outra classe com membros estáticos

![discussao][D]

**util > Calculator.java**

```java
package util;

public class Calculator {
  public static final double PI = 3.14159;

  public static double circumference(double radius) {
    return 2.0 * PI * radius;
  }

  public static double volume(double radius) {
    return 4.0 * PI * radius * radius * radius / 3.0;
  }
}
```

**application > Program.java**

```java
package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {

  public static final double PI = 3.14159; 
  // final para dizer que o valor não pode ser alterado (constante)
  // TUDO EM MAIÚSCULO é o padrão do java para constantes

  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    Calculator calc = new Calculator();

    System.out.print("Enter radius: ");
    double radius = sc.nextDouble();

    double c = circumference(radius);
    double v = volume(radius);

    System.out.printf("Circumference: %.2f%n", c);
    System.out.printf("Volume: %.2f%n", v);
    System.out.printf("PI value: %.2f%n", PI);

    sc.close();
  }
}
```

<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 4. Exemplos práticos

### 4.1. Área triângulo

Abaixo, será resolvido o mesmo exercício de exemplo adicionando gradualmente as características da Programação Orientada a Objetos.

O problema consiste em:

Fazer um programa para ler as medidas dos lados de dois triângulos X e Y (suponha medidas válidas). Em seguida, mostrar o valor das áreas dos dois triângulos e dizer qual dos dois triângulos possui a maior área.

A fórmula para calcular a área de um triângulo a partir das medidas de seus lados **a**, **b** e **c** é a seguinte (fórmula de Heron):

![equation][A]

**Exemplo:**

> Enter the measures of triangle X:
> 3.00
> 4.00
> 5.00
> Enter the measures of triangle Y:
> 7.50
> 4.50
> 4.02
> Triangle X area: 6.0000
> Triangle Y area: 7.5638
> Larger area: Y

#### 4.1.1. Sem POO

```java
package application;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double xA, xB, xC, yA, yB, yC;

        System.out.println("Enter the measures of triangle X: ");
        xA = sc.nextDouble();
        xB = sc.nextDouble();
        xC = sc.nextDouble();
        System.out.println("Enter the measures of triangle Y: ");
        yA = sc.nextDouble();
        yB = sc.nextDouble();
        yC = sc.nextDouble();

        double p = (xA + xB + xC) / 2.0;
        double areaX = Math.sqrt(p * (p - xA) * (p - xB) * (p - xC));

        p = (yA + yB + yC) / 2.0;
        double areaY = Math.sqrt(p * (p - yA) * (p - yB) * (p - yC));

        System.out.printf("Triangle X area: %.4f%n", areaX);
        System.out.printf("Triangle Y area: %.4f%n", areaY);

        if (areaX > areaY) {
            System.out.println("Larger area: X");
        }
        else {
            System.out.println("Larger area: Y");
        }

        sc.close();
    }
}
```

#### 4.1.2. Com classe

- Triângulo é uma entidade com três atributos: a, b, c;
- Estamos utilizando três variáveis distintas para representar cada triângulo:
  - `double aX, bX, cX, aY, bY, cY`;
- Para melhorar isso, vamos utilizar uma CLASSE para representar o triângulo.

```java
package entities;

public class Triangle {
    public double a;
    public double b;
    public double c;
}
```

```java
package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class Program {
    [...]
    Triangle x, y;
    x = new Triangle();
    y = new Triangle();

    System.out.println("Enter the measures of triangle X: ");
    x.a = sc.nextDouble();
    x.b = sc.nextDouble();
    x.c = sc.nextDouble();
    System.out.println("Enter the measures of triangle Y: ");
    y.a = sc.nextDouble();
    y.b = sc.nextDouble();
    y.c = sc.nextDouble();

    double p = (x.a + x.b + x.c) / 2.0;
    double areaX = Math.sqrt(p * (p - x.a) * (p - x.b) * (p - x.c));

    p = (y.a + y.b + y.c) / 2.0;
    double areaY = Math.sqrt(p * (p - y.a) * (p - y.b) * (p - y.c));
    [...]
```

> **Nota:** é necessário importar na aplicação principal toda classe que será instanciada. Neste caso, `import entities.Triangle;`.

#### 4.1.3. Com método

Com o uso de classe, agora nós temos uma variável composta do tipo "Triangle" para representar cada triângulo:

```java
Triangle x, y;
x = new Triangle();
y = new Triangle();
```

Agora vamos melhorar nossa classe, acrescentando nela um MÉTODO para calcular a área.

No projeto de entidades:

```java
package entities;

public class Triangle {
    public double a;
    public double b;
    public double c;

    public double area() {
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
```

No projeto principal:

```java
package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Triangle;

public class Program {
    [...]
    double areaX = x.area();
    double areaY = y.area();
    [...]
```

![estrutura][C]

**Quais são os benefícios de utilizar um método dentro da classe?**

1. Reaproveitamento de código: elimina-se o código repetido no programa principal;
2. Delegação de responsabilidades.

### 4.2. Produto no estoque

Fazer um programa para ler os dados de um produto em estoque (nome, preço e quantidade no estoque). Em seguida:

- Mostrar os dados do produto (nome, preço, quantidade no estoque, valor total no
estoque);
- Realizar uma entrada no estoque e mostrar novamente os dados do produto;
- Realizar uma saída no estoque e mostrar novamente os dados do produto.

Para resolver este problema, você deve criar uma CLASSE conforme projeto UML abaixo:

<img width="200px" src="../../Images/uml1.png" align="center">

**Estrutura do projeto**

```plaintext
|- Java Project
||- JRE System Library
||- src
|||- application
||||- Program.java
|||- entities
||||- Product.java
```

**Program.java**

```java
package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
 public static void main(String[] args) {
  
  Locale.setDefault(Locale.US);
  Scanner sc = new Scanner(System.in);
  
  Product product = new Product();
  
  System.out.println("Enter product data:");
  System.out.println("Name:");
  product.name = sc.nextLine();
  System.out.println("Price:");
  product.price = sc.nextDouble();
  System.out.println("Quantity in stock:");
  product.quantity = sc.nextInt();
  
  System.out.println();
  System.out.println("Product data: " + product);
  
  System.out.println();
  System.out.println("Enter the number of products to be added in stock: ");
  int quantity = sc.nextInt();
  product.addProducts(quantity);
  
  System.out.println();
  System.out.println("Updated data: " + product);
  
  System.out.println();
  System.out.println("Enter the number of products to be removed from stock: ");
  quantity = sc.nextInt();
  product.removeProducts(quantity);
  
  System.out.println();
  System.out.println("Updated data: " + product);
  
  sc.close();
 }
}
```

**Product.java**

```java
package entities;

public class Product {
 public String name;
 public double price;
 public int quantity;
 
 public double totalValueInStock() {
  return price * quantity;
 }
 
 public void addProducts( int quantity ) {
  this.quantity += quantity;
 }
 
 public void removeProducts( int quantity ) {
  this.quantity -= quantity;
 }
 
 // Sobrepõe o método toString padrão do Object
 public String toString() {
  return name
   + ", $ "
   + String.format("%.2f", price) // Para deixar formatado como no printf
   + ", "
   + quantity
   + " units, Total: $ "
   + String.format("%.2f", totalValueInStock());
 }
}
```

<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 5. Construtores

- É uma operação especial da classe, que executa no momento da instanciação do objeto;
- Usos comuns:
  - Iniciar valores dos atributos;
  - Permitir ou obrigar que o objeto receba dados / dependências no momento de sua instanciação (injeção de dependência).
- Se um construtor customizado não for especificado, a classe disponibiliza o construtor padrão:

```java
Product p = new Product();
```

- É possível especificar mais de um construtor na mesma classe (sobrecarga).

Para entender melhor, vamos utilizar o programa exemplo apresentado na [seção 4.2](#42-produto-no-estoque) deste documento. Assim, os construtores apresentam a seguinte proposta de melhoria:

Quando executamos o comando acima (`Product p = new Product();`), instanciamos um produto "product" com seus atributos “vazios”:

```java
Product p = new Product();

System.out.println(product.name); // null
System.out.println(product.price); // 0.0
System.out.println(product.quantity); // 0
```

Entretanto, faz sentido um produto que não tem nome? Faz sentido um produto que não tem preço?

Com o intuito de evitar a existência de produtos sem nome e sem preço, é possível fazer com que seja “obrigatória” a iniciação desses valores?

A resposta para a pergunta acima é SIM, com o auxílio dos construtores. Eles são, por boas práticas, alocados depois dos atributos.

```java
public Product(String name, double price, int quantity) {
  this.name = name;
  this.price = price;
  this.quantity = quantity;
}
```

Ao definir estes construtores, é necessário alterar o programa principal obrigando o programador a informar os dados antes de instanciar a classe:

```java
System.out.println("Enter product data: ");
System.out.print("Name: ");
String name = sc.nextLine();
System.out.print("Price: ");
double price = sc.nextDouble();
System.out.print("Quantity in stock: ");
int quantity = sc.nextInt();
Product product = new Product(name, price, quantity);
```

<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 6. Palavra *this*

No capítulo acima, foi mencionada a palavra *this* na melhoria do código com o construtor. Esta palavra é uma referência para o próprio objeto.

- Usos comuns:
  - Diferenciar atributos de variáveis locais;
  - Passar o próprio objeto como argumento na chamada de um método ou construtor.

![this][E]

Um exemplo que será abordado em um próximo artigo:

```java
public class ChessMatch {
  (...)
  placeNewPiece('e', 1, new King(board, Color.WHITE, this));
  (...)
```

<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 7. Sobrecarga

É um recurso que uma classe possui de oferecer mais de uma operação com o mesmo nome, porém com diferentes listas de parâmetros.

Para um melhor entendimento do assunto, uma segunda proposta de melhoria para o programa da [seção 4.2](#42-produto-no-estoque) é realizada: criar um construtor opcional, o qual recebe apenas nome e preço do produto. A quantidade em estoque deste novo produto, por padrão, deverá então ser iniciada com o valor zero.

```java
package entities;

public class Product {

  public String name;
  public double price;
  public int quantity;

  public Product() {
  }
  
  public Product(String name, double price, int quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }

  public Product(String name, double price) {
    this.name = name;
    this.price = price;
  }

  (...)
```

> **Nota:** é possível também incluir um construtor padrão (`Product p = new Product();`)

<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 8. Encapsulamento

É um princípio que consiste em esconder detalhes de implementação de uma classe, expondo apenas operações seguras e que mantenham os objetos em um estado consistente.

**Regra de ouro:** o objeto deve sempre estar em um estado consistente, e a própria classe deve garantir isso.

Um objeto NÃO deve expor nenhum atributo (modificador de acesso `private`)

- Os atributos devem ser acessados por meio de métodos `get` e `set`;
- Padrão JavaBeans: [ARTIGO 1][1] e [ARTIGO 2][2] - padrão que estabelecem algumas regras para o Java;

```java
public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

public double getPrice() {
  return price;
}

public void setPrice(double price) {
  this.price = price;
}

// A quantidade tem somente o getQuantity para proteger o produto com uma quantidade consistente
public int getQuantity() {
  return quantity;
}
```

### 8.1. Como gerar os métodos `set` e `get` automaticamente?



<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 9. Diagrama UML

<!-- MARKDOWN LINKS -->
<!-- SITES -->
[1]: https://en.wikipedia.org/wiki/JavaBeans
[2]: https://www.devmedia.com.br/introducao-aos-javabeans/8621

<!-- IMAGES -->
[A]: https://latex.codecogs.com/svg.image?area&space;=&space;\sqrt{p(p-a)(p-b)(p-c)},&space;\text{&space;onde:&space;}&space;p&space;=&space;\frac{a&plus;b&plus;c}{2}
[B]: ../../Images/instanciacao.png
[C]: ../../Images/estrutura.png
[D]: ../../Images/metodoEstatico.png
[E]: ../../Images/this.png