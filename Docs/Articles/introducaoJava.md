<!-- LOGO DIREITO -->
<a href="#"><img width="200px" src="https://intellipaat.com/mediaFiles/2018/12/1.png" align="right" /></a>

# Introdução à linguagem Java

<p align="left">
  <a href="https://github.com/JonathanTSilva/HL-Java">
    <img src="https://img.shields.io/static/v1?label=HomeLab&message=Java&color=red&logo=java&logoColor=white&labelColor=grey&style=flat" alt="HL-Java">
  </a>
</p>

☕ Uma introdução à linguagem de programação Java.

<!-- SUMÁRIO -->
- [Conceitos de programação](#conceitos-de-programação)
  - [1. O que é o Java](#1-o-que-é-o-java)
    - [1.1. Aspectos notáveis](#11-aspectos-notáveis)
  - [2. História](#2-história)
  - [3. Terminologia Java](#3-terminologia-java)
    - [3.1. Edições do Java](#31-edições-do-java)
  - [4. Recursos primários/principais do Java](#4-recursos-primáriosprincipais-do-java)
  - [5. Estrutura](#5-estrutura)
  - [6. Instalação](#6-instalação)
  - [7. Primeiro projeto no Eclipse](#7-primeiro-projeto-no-eclipse)
    - [7.1. Como utilizar o debug](#71-como-utilizar-o-debug)
  - [8. Outros tópicos básicos no Java](#8-outros-tópicos-básicos-no-java)
    - [8.1. Restrições e convenções para nomes](#81-restrições-e-convenções-para-nomes)
    - [8.2. Operadores bitwise](#82-operadores-bitwise)
    - [8.3. Funções interessantes para String](#83-funções-interessantes-para-string)
    - [8.4. Comentários em Java](#84-comentários-em-java)
    - [8.5. A sintaxe das funções](#85-a-sintaxe-das-funções)

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 1. O que é o Java

Java é uma linguagem de programação simples (regras sintáticas), mas também uma plataforma de desenvolvimento e execução. Java torna fácil escrever, compilar e depurar a programação, ajudando a criar código reutilizável e programas modulares.

Além disso, é linguagem de programação orientada a objetos baseada em classes e projetada para ter o menor número possível de dependências de implementação. Se destaca por ser de uso geral e feita para desenvolvedores escreverem códigos multiplataformas e de alto desempenho. A sintaxe de Java é semelhante a C/C++.

### 1.1. Aspectos notáveis

- Código compilado para bytecode e executado em máquina virtual (JVM);
- Portável, segura, robusta;
- Roda em vários tipos de dispositivos;
- Domina o mercado corporativo desde o fim do século 20;
- Padrão Android por muitos anos.

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 2. História

Em suma, surgiu com o propósito de resolver os seguintes problemas apresentados por outras linguagens de programação:
- ponteiros/gerenciamento de memória;
- portabilidade falha: reescrever parte do código ao mudar de Sistema Operacional;
- utilização em dispositivos diversos;
- custo.

Assim, **James Gosling**, Mike Sheridan e Patrick Naughton, uma equipe de engenheiros da **Sun Microsystems Inc** conhecida como **equipe verde**, iniciou a linguagem Java em 1991. A empresa lançou sua primeira implementação pública em 1996 como Java 1.0, que foi reescrito em Java por Arthur Van Hoff para cumprir estritamente com suas especificações. Com a chegada do Java 2, novas versões passaram a ter múltiplas configurações construídas para diferentes tipos de plataformas. Em 13 de novembro de 2006, a Sun lançou grande parte de sua máquina virtual Java como software livre e de código aberto. Em 8 de maio de 2007, a Sun concluiu o processo, disponibilizando todo o código principal de sua JVM sob termos de distribuição de código aberto. O java foi adquirido pela Oracle Corporation em 2010.

Os princípios para a criação de Java eram simples, robustos, seguros, de alto desempenho, portáteis, multi-threaded, interpretados, dinâmicos, etc. Atualmente, o Java é usado em dispositivos móveis, programação de internet, jogos, e-business, etc.

> **Curiosidade:** Java é o nome de uma ilha na Indonésia onde o primeiro café (chamado de café java) foi produzido. E este nome foi escolhido por James Gosling enquanto tomava café perto de seu escritório. Observe que Java é apenas um nome, não um acrônimo.

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 3. Terminologia Java

Antes de aprender Java, é preciso estar familiarizado com esses termos comuns de Java.

- **Java Virtual Machine (JVM):** geralmente chamado de JVM, é a máquina virtual do java - necessária para executar sistemas Java. Existem três fases de execução de um programa: escrita, compilação e execução:
  - a escrita é realizada por um programador java;
  - a compilação é feita pelo compilador **JAVAC**, que é um compilador Java primário incluído no **kit de desenvolvimento Java (JDK)**. Recebe o programa Java como entrada e gera *bytecode* como saída;
  - Na fase de execução de um programa, a JVM executa o *bytecode* gerado pelo compilador.

Cada sistema operacional tem uma JVM diferente, mas a saída que eles produzem após a execução do *bytecode* é a mesma em todos os sistemas operacionais. É por isso que Java é conhecida como uma linguagem independente de plataforma.

- ***Bytecode* no processo de Desenvolvimento:** o compilador Javac do JDK compila o código fonte java em *bytecode* para que possa ser executado pela JVM, que por usa vez, é salvo como arquivo `.class` pelo compilador. Para visualizar o *bytecode*, um desmontador como [javap][1] pode ser usado.

- **Java Development Kit (JDK):** um kit de desenvolvimento Java completo que inclui tudo, incluindo compilador, Java Runtime Environment (JRE), depuradores java, documentos java, etc. Para desenvolver um programa em java, precisa-se instalar o JDK no computador para criar, compilar e executa-lo.

- **Java Runtime Environment (JRE):** permite que o programa java seja executado, porém, não permite compilá-lo. O JRE inclui um navegador, JVM, suporte a miniaplicativos e plug-ins. Para executar o programa java, um computador precisa do JRE.

- **Garbage Collector (Coletor de lixo):** os programadores não podem excluir os objetos em java. Para tal exclusão ou recuperação de memória, a JVM possui um programa chamado Garbage Collector, que podem recuperar os objetos que não são referenciados, facilitando a vida de um programador ao lidar com o gerenciamento de memória. No entanto, estes devem ter cuidado com seu código se estiverem usando objetos que são usados ​​há muito tempo, pois o Garbage não pode recuperar a memória dos objetos referenciados.

- **ClassPath:** é o caminho do arquivo onde o Java Runtime e o compilador Java procuram arquivos `.class` para carregar. Por padrão, o JDK fornece muitas bibliotecas; caso deseje incluir bibliotecas externas, estas devem ser adicionadas ao caminho de classe.

### 3.1. Edições do Java

- [Java ME - Java Micro Edition][3] - dispositivos embarcados e móveis - IoT
- [Java SE - Java Standard Edition][2] - **core** - desktop e servidores
- [Java EE - Java Enterprise Edition][4] - aplicações corporativas

> **Nota:** para mais informações das versões Java, verifique a [página no site oficial da Oracle][2]. A versão **LTS** significa **Long Term Support**.

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 4. Recursos primários/principais do Java

- **Independente de plataforma:** o compilador converte o código fonte em *bytecode* para então o JVM executá-lo. Este *bytecode* pode ser executado em qualquer plataforma, seja Windows, Linux, macOS, o que significa que se compilarmos um programa no Windows, podemos executá-lo no Linux e vice-versa. Cada sistema operacional possui uma JVM diferente, mas a saída produzida por todos os SOs é a mesma após a execução do *bytecode*. É por isso que chamamos java de linguagem independente de plataforma.

- **Linguagem de Programação Orientada a Objetos (POO):** organizar o programa em termos de coleção de objetos é uma forma de programação orientada a objetos, cada um dos quais representa uma instância da classe. Os quatro principais conceitos da programação orientada a objetos são:
  - Abstração;
  - Encapsulamento;
  - Herança;
  - Polimorfismo.

- **Simples:** não possui recursos complexos como ponteiros, sobrecarga de operadores, heranças múltiplas, alocação explícita de memória, entre outros.

- **Robusto:** a robustez traz a confiança. É desenvolvido de tal forma que se esforça muito para verificar os erros o mais cedo possível, é por isso que o compilador java é capaz de detectar até mesmo os erros que não são fáceis de detectar por outra linguagem de programação. Os principais recursos do java que o tornam robusto são: Garbage Collector, manipulação de exceções e alocação de memória.

- **Seguro:** como não se tem ponteiros em java, não pode-se acessar arrays fora do limite, ou seja, é mostrada a mensagem `ArrayIndexOutOfBound Exception` ao tentar fazê-lo. É por isso que várias falhas de segurança, como corrupção de pilha ou estouro de *buffer*, são impossíveis de explorar em Java.

- **Distribuído:** é possível criar aplicativos distribuídos usando a linguagem de programação java. *Remote Method Invocation* e *Enterprise Java Beans* são utilizados para criar tais aplicativos. Os programas java podem ser facilmente distribuídos em um ou mais sistemas conectados entre si por meio da internet.

***Multithreading*:** suporta *multithreading*. É um recurso Java que permite a execução simultânea de duas ou mais partes de um programa para utilização máxima da CPU.

- **Portátil:** como já discutido, o código Java escrito em uma máquina pode ser executado em outra máquina. O recurso independente de plataforma do java, no qual seu *bytecode* independente de plataforma pode ser levado para qualquer plataforma para execução, torna-o portátil.

- **Alto desempenho:** a arquitetura Java é definida de tal forma que reduz a sobrecarga durante o tempo de execução e, em algum momento, o Java usa o compilador **Just In Time (JIT)**, no qual compila o código básico sob demanda, ou seja, apenas os métodos que são chamados, fazendo os aplicativos serem executados mais rápido.

- **Flexibilidade dinâmica:** sendo completamente orientado a objetos, é dada a flexibilidade de adicionar classes, novos métodos a classes existentes e até mesmo criar novas classes através de subclasses. Java ainda suporta funções escritas em outras linguagens (como C, C++), que são chamadas de métodos nativos.

- **Execução Sandbox:** programas Java são executados em um espaço separado, permitindo ao usuário a execução dos aplicativos sem afetar o sistema subjacente com a ajuda de um verificador de *bytecode*, que por sua vez, também fornece segurança adicional, pois sua função é verificar o código quanto a qualquer violação de acesso.

- ***Write Once Run Anywhere*:** como visto anteriormente, o aplicativo java gera um arquivo `.class`, que corresponde aos nossos aplicativos (programas), mas contém código em formato binário. Ele fornece facilidade de arquitetura neutra, pois o *bytecode* não depende de nenhuma arquitetura de máquina. É a principal razão pela qual o java é usado na indústria de TI empresarial globalmente.

- **Poder de compilação e interpretação:** a maioria das linguagens é projetada com um propósito ou linguagem compilada ou linguagem interpretada. Mas o java integra um enorme poder, pois o compilador Java compila o código-fonte para *bytecode* e a JVM executa esse *bytecode* para o código executável dependente do SO da máquina.

> Tudo em java é representado em Class como um objeto, incluindo a função principal.

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 5. Estrutura

Os tópicos a seguir mostram a principal estrutura de uma aplicação Java:

- Composto por classes: unidade lógica básica de um POO;
- Package: agrupamento lógico de classes relacionadas;
- Módulo (Java 9+): agrupamento lógico de pacotes relacionados;
- Runtime: agrupamento físico (build - arquivos);
- Aplicação: agrupamento de módulos relacionados.

![structure][A]

> **Nota:** agrupamento lógico se trata do nível conceitual e código.

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 6. Instalação

Para realizar a instalação de um ambiente de programação Java, realizar as seguintes etapas:

1. Baixar e instalar o [Java JDK][5]
2. Configurar variáveis de ambiente do sistema
   - Painel de Controle -> Variáveis de Ambiente
     - JAVA_HOME: C:\Program Files\Java\jdk-11.0.4
     - Path: C:\Program Files\Java\jdk-11.0.4\bin
   - Testar no terminal de comando: java -version
3. Instalar uma IDE:
   - [NetBeans][6]
   - [Eclipse][7] - Eclipse IDE for Enterprise Java and Web Developers
   - ou até mesmo no VSCode, com algumas extensões

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 7. Primeiro projeto no Eclipse

- Workspace (selecione a pasta aonde os projetos serão salvos)
- Mudar o layout: Window -> Perspective -> Open Perspective -> Java
- Zerar o layout: Window -> Perspective -> Reset Perspective
- Mostrar a aba Console: Window -> Show View -> Console
- Criar projeto: File -> New -> Java Project
- Criar classe:
  - Botão direito na pasta "src" -> New -> Class
  - Package: deixe em branco
  - Nome da classe: Main (com M maiúsculo)
  - Marque a opção: public static void main(String[] args)
    - Essa função é o ponto de entrada do código java. Pode-se imprimir um Olá mundo e executar clicando com o botão direito na classe e "Run As" -> Java Application
- Mudar o tamanho da fonte:
  - CTRL +
  - CTRL -

> **Dica:** é possível criar algumas templates para melhor utilização indo em **Windows** > **Preferences** > **Java** > **Editor** > **Templates** > **New**.
> Exemplos:
> ```
> Scanner sc = new Scanner(System.in);
>
> sc.close();
> ```
> ```
> Locale.setDefault(Locale.US);
> ```

### 7.1. Como utilizar o debug

- Para marcar uma linha de breakpoint:
  - Run > Toggle Breakpoint
- Para iniciar o debug:
  - Botão direito na classe > Debug as > Java Application;
- Para executar uma linha:
  - F6;
- Para interromper o debug:
  - Botão Parar na barra de ferramentas.

## 8. Outros tópicos básicos no Java

### 8.1. Restrições e convenções para nomes

- Não pode começar com um dígito: usar uma letra ou _;
- Não pode ter espaço em branco;
- Não usar acentos ou til;
- Iniciar com letra minúscula;
- Sugestão: use o padrão "camel case" e "pascal case"; nomes que tenham um significado:
  - CamelCase: lastName
    - pacotes;
    - atributos;
    - métodos;
    - variáveis e parâmetros.
  - PascalCase: ProductService
    - classes.

### 8.2. Operadores bitwise

Operadores bitwise são utilizados quando precisamos realizar operações em nível de bits com números inteiros, ou seja, trabalhar com sua representação binária.

Caso ambos os operandos sejam strings, esses operadores irão trabalhar com os valores ASCII de seus caracteres.

| Operador Bitwise    | Significado              |
| :------------------ | :----------------------- |
| `&`                 | Operação "AND" bit a bit |
| <code>&#124;</code> | Operação "OR" bit a bit  |
| `^`                 | Operação "XOR" bit a bit |
| `~`                 | Operação "NOT" bit a bit |

| Operador Bit Shift | Significado         |
| :----------------- | :------------------ |
| `>>`               | Bitwise right shift |
| `<<`               | Bitwise left shift  |

> **Nota:** não confunda os operadores bitwise com operadores lógicos, algumas representações são parecidas, mas suas funcionalidades são diferentes.

**Aplicação comum:** verificar um bit.

```java
Scanner sc = new Scanner(System.in);

int mask = 0b100000;
int n = sc.nextInt();

if ((n & mask) != 0) {
  System.out.println("6th bit is true!");
} 
else {
  System.out.println("6th bit is false!");
}
```

### 8.3. Funções interessantes para String

- Formatar:
  - toLowerCase();
  - toUpperCase();
  - trim();
- Recortar:
  - substring(inicio);
  - substring(inicio, fim);
- Substituir:
  - Replace(char, char);
  - Replace(string, string);
- Buscar:
  - IndexOf;
  - LastIndexOf;
- str.Split("");

```java
String str = "asdb ÇKLAbcJj AJSKD abc asdf IOAJ SbcKJ snd        ";

String s01 = str.toLowerCase();
String s02 = str.toUpperCase();
String s03 = str.trim();
String s04 = str.substring(2);
String s05 = str.substring(2, 9);
String s06 = str.replace('a', 'x');
String s07 = str.replace("asdf", "xy");
int i = str.indexOf("bc");
int j = str.lastIndexOf("bc");

String[] vect = str.split(" ");
String s08 = vect[4];

System.out.printf("String original: -%s-%n", str);
System.out.printf("toLowerCase(): -%s-%n", s01);
System.out.printf("toUpperCase(): -%s-%n", s02);
System.out.printf("trim(): -%s-%n", s03);
System.out.printf("substring(2): -%s-%n", s04);
System.out.printf("substring(2, 9): -%s-%n", s05);
System.out.printf("replace('a', 'x'): -%s-%n", s06);
System.out.printf("replace(\"asdf\", \"xy\"): -%s-%n", s07);
System.out.printf("indexOf(\"bc\"): %s%n", i);
System.out.printf("lastIndexOf(\"bc\"): %s%n", j);
System.out.printf("split (5th word): %s%n", s08);
```

### 8.4. Comentários em Java

Comentário em bloco:

```java
/*
* Linha 1 do comentário em bloco
* Linha 2 do comentário em bloco
* Linha 3 do comentário em bloco
*/
```

Comentário em linha:

```java
// Comentário em única linha
```

> **Nota:** constitui-se uma boa prática de programação evitar o excesso de comentário, devendo ser utilizados com parcimônia.

### 8.5. A sintaxe das funções

- Representam um processamento que possui um significado:
  - `Math.sqrt(double)`;
  - `System.out.println(string)`.
- Principais vantagens da utilização de funções;
  - modularização;
  - delegação;
  - aproveitamento.
- Dados de entrada e saída:
  - Funções podem receber dados de entrada (parâmetros ou argumentos);
  - Funções podem ou não retornar uma saída.
- Em orientação a objetos, funções em classes recebem o nome de "métodos".

**Problema exemplo:** fazer uma função para ler três números inteiros e mostrar na tela o maior deles.

```java
public static int max(int x, int y, int z) {
  int aux;

  if (x > y && y > z) {
    aux = x;
  }
  else if (y > z) {
    aux = y;
  }
  else {
    aux = z
  }
  return aux;
}

public static void showResult(int value) {
  System.ou.println("Higher = " + value);
}
```

<!-- MARKDOWN LINKS -->
<!-- SITES -->
[1]: https://www.geeksforgeeks.org/javap-tool-in-java-with-examples/
[2]: https://www.oracle.com/java/technologies/java-se-glance.html
[3]: https://www.oracle.com/java/technologies/javameoverview.html
[4]: https://www.oracle.com/java/technologies/java-ee-glance.html
[5]: https://www.oracle.com/java/technologies/downloads/
[6]: https://netbeans.apache.org/download/index.html
[7]: https://www.eclipse.org/downloads/

<!-- IMAGES -->
[A]: ../../Images/structure.png
