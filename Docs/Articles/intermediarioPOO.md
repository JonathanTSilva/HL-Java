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

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## . Arrays

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