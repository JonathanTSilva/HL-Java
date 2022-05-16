<!-- LOGO DIREITO -->
<a href="#"><img width="200px" src="https://miro.medium.com/max/600/0*7zMicw-FfThCbN35.png" align="right" /></a>

# O nível avançado de conhecimento em Programação Orientada a Objetos

<p align="left">
  <a href="https://github.com/JonathanTSilva/HL-Java">
    <img src="https://img.shields.io/static/v1?label=HomeLab&message=Java&color=red&logo=java&logoColor=white&labelColor=grey&style=flat" alt="HL-Java">
  </a>
</p>

🏛 Tudo o que você precisa saber para dominar a Programação Orientada a Objetos (POO).

<!-- SUMÁRIO -->
- [O nível avançado de conhecimento em Programação Orientada a Objetos](#o-nível-avançado-de-conhecimento-em-programação-orientada-a-objetos)
  - [1. Enumeração](#1-enumeração)
    - [1.1. Conversão de `String` para `Enum`](#11-conversão-de-string-para-enum)
    - [1.2. Notação UML](#12-notação-uml)
  - [Bônus: Design do código](#bônus-design-do-código)
    - [Categoria de classes](#categoria-de-classes)
  - [2. Composição](#2-composição)
  - [3. Herança](#3-herança)
  - [4. Polimorfismo](#4-polimorfismo)
  - [5. Tratamento de exceções](#5-tratamento-de-exceções)

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 1. Enumeração

Uma enumeração é um tipo especial que serve para especificar de forma literal um conjunto de constantes relacionadas. A palavra chave da enumeração em Java é `enum`

Possui como vantagem uma melhor semântica e um código mais legível e auxiliado pelo compilador

Para referência, verificar o tutorial de [Enum Types][1] e documentação da classe [Enum][2].

**Exemplo:** ciclo de vida de um pedido.

![cicloPedido][A]

```java
package entities.enums;

public enum OrderStatus {
    PENDING_PAYMENT,
    PROCESSING,
    SHIPPED,
    DELIVERED;
}
```

```java
package entities;

import java.util.Date;
import entities.enums.OrderStatus;

public class Order {
    private Integer id;
    private Date moment;
    private OrderStatus status;
    (...)
}
```

### 1.1. Conversão de `String` para `Enum`

Essa conversão é importante, pois a aplicação que utiliza o `Enum` pede que o usuário entre com algum valor para ele, e fatalmente o usuário entra com esse valor na forma de `String`. Assim, essa string é convertida para uma instância do tipo `Enum`.

```java
OrderStatus os1 = OrderStatus.DELIVERED;
OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
```

### 1.2. Notação UML

A notação UML para o tipo `Enum` é dada em dois tipos, conforme imagem abaixo:

![notUMLEnum][B]

## Bônus: Design do código

### Categoria de classes

Em um sistema orientado a objetos, de modo geral, "tudo" é objeto.

Por questões de design tais como organização, flexibilidade, reutilização, delegação, etc., há várias categorias de classes:

- Views - telas do sistema;
- Controllers - o elemento que intermedeia as telas e o sistema;
- Entities - entidades de negócios, como: produtos, clientes, pedidos, etc.;
- Services - elementos que executa ações, como: enviar emails, autenticação, etc.;
- Repositories - objetos responsáveis por acessar os dados do banco de dados;
- Entre outros.

**Exemplo de *Entities***

![entitiesEx][C]

**Exemplo de *Services***

![servicesEx][D]

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 2. Composição

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 3. Herança

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 4. Polimorfismo

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 5. Tratamento de exceções

<!-- MARKDOWN LINKS -->
<!-- SITES -->
[1]: https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
[2]: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/Enum.html

<!-- IMAGES -->
[A]: ../../Images/cicloPedido.png
[B]: ../../Images/umlEnum.png
[C]: ../../Images/entitiesEx.png
[D]: ../../Images/servicesEx.png