<!-- LOGO DIREITO -->
<a href="#"><img width="200px" src="http://webinsider.com.br/wp-content/uploads/2014/06/325px-Searchgraph-found.svg_.png" align="right" /></a>

# Conceitos de programação

<p align="left">
  <a href="https://github.com/JonathanTSilva/HL-Java">
    <img src="https://img.shields.io/static/v1?label=HomeLab&message=Java&color=red&logo=java&logoColor=white&labelColor=grey&style=flat" alt="HL-Java">
  </a>
</p>

🔎 Entenda quais são os conceitos por trás das linguagens de programação.

<!-- SUMÁRIO -->
- [Conceitos de programação](#conceitos-de-programação)
  - [1. Conceitos básicos](#1-conceitos-básicos)
    - [1.1. Algoritmo](#11-algoritmo)
    - [1.2. Automação](#12-automação)
    - [1.3. Computador](#13-computador)
  - [2. Componentes do desenvolvimento de um programa](#2-componentes-do-desenvolvimento-de-um-programa)
    - [2.1. Linguagem de programação](#21-linguagem-de-programação)
      - [2.1.1. C](#211-c)
      - [2.1.2. C++](#212-c)
      - [2.1.3. C](#213-c)
      - [2.1.4. Java](#214-java)
    - [2.2. IDE](#22-ide)
    - [2.3. Compilador, Interpretador e Máquina Virtual](#23-compilador-interpretador-e-máquina-virtual)

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 1. Conceitos básicos

### 1.1. Algoritmo

Sequência finita de instruções para se resolver um problema. Aplica-se a diversas áreas de conhecimento. Exemplo:

- **Problema:** lavar roupa suja
- **Algoritmo:**
    1. Colocar a roupa em um recipiente;
    2. Colocar um pouco de sabão e amaciante;
    3. Encher de água;
    4. Mexer tudo até dissolver todo o sabão;
    5. Deixar de molho por vinte minutos;
    6. Esfregar a roupa;
    7. Enxaguar;
    8. Torcer.

### 1.2. Automação

Consiste em utilizar máquina(s) para executar o procedimento desejado de forma automática ou semiautomática. Como a automação de uma máquina de lavar roupa para o algoritmo supracitado, que realiza as etapas 3 a 8.

### 1.3. Computador

- **Hardware:** parte física (a máquina em si);
- **Software:** parte lógica (programas):
  - Sistema operacional (Windows, Linux, iOS);
  - Aplicativos (apps de escritório, app de câmera, navegador web);
  - Jogos;
  - Utilitários (antivírus, compactador de arquivos);
  - Outros.

> **Nota:** Similaridade entre programa e algoritmo: programas de computador são algoritmos executados pelo computador (em linhas gerais). Como conclusão, o computador é uma máquina que automatiza a execução de algoritmos, mas apenas de algoritmos computacionais, nos quais incluem processamento de dados e cálculos.

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 2. Componentes do desenvolvimento de um programa

Nas seções abaixo, estão todos os componentes precisos para desenvolver um programa de computador.

### 2.1. Linguagem de programação

Regras léxicas (ortografia) e sintáticas (gramática) para se escrever um programa. A primeira, diz respeito à correção das palavras **isoladas**, conforme exemplos da tabela abaixo:

| Português | Linguagem de programação |
| :-------- | :----------------------- |
| cachorro  | `main`                   |
| caxorro   | `maim`                   |

Já a segunda, se remete à correção das **sentenças**:

| Português                | Linguagem de programação |
| :----------------------- | :----------------------- |
| O cachorro está com fome | `x = 2 + y`              |
| A cachorro está com fome | `x = + 2 y`              |

Exemplos de linguagens de programação resolvendo o mesmo algoritmo: mostrar a média aritmética de dois números.

#### 2.1.1. C

```c
#include <stdio.h>

int main() {
    double x, y, media;

    printf("Digite o primeiro numero: ");
    scanf("%lf", &x);
    printf("Digite o segundo numero: ");
    scanf("%lf", &y);
    media = (x + y) / 2.0;
    printf("Media = %.lf\n", media);
    return 0;
}
```

#### 2.1.2. C++

```c++
#include <iostream>

using namespace std;

int main() {
    double x, y, media;

    cout << "Digite o primeiro numero: ";
    cin >> x;
    cout << "Digite o segundo numero: ";
    cin >> y;
    media = (x + y) / 2.0;
    cout << "Media = " << media << end1;
    return 0;
}
```

#### 2.1.3. C#

```cs
using System;

namespace programa {
    class Program {
        static void Main(string[] args) {
            double x, y, media;

            Console.Write("Digite o primeiro numero: ");
            x = double.Parse(Console.ReadLine());
            Console.Write("Digite o segundo numero: ");
            y = double.Parse(Console.ReadLine());
            media = (x + y) / 2.0;
            Console.WriteLine("Media = " + media);
        }
    }
}
```

#### 2.1.4. Java

```java
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double x, y, media;

        System.out.print("Digite o primeiro numero: ");
        x = sc.nextDouble();
        System.out.print("Digite o segundo numero: ");
        y = sc.nextDouble();
        media = (x + y) / 2.0;
        System.ou.println("Media = " + media);
        sc.close();
    }
}
```


### 2.2. IDE

Software para editar e testar o programa. Exemplos:

- C/C++: **Code Blocks**;
- Java: **Eclipse, NetBeans**;
- C#: **Microsoft Visual Studio**.

Uma IDE possui as seguintes funcionalidades:

- Edição de código fonte (endentação, autocompletar, destaque de palavras, etc.);
- Depuração e testes;
- Construção do produto final (build);
- Sugestão de modelos (templates);
- Auxiliar em várias tarefas do seu projeto;
- Entre outras.

### 2.3. Compilador, Interpretador e Máquina Virtual

O compilador é um software para transformar o código fonte em código objeto. A figura abaixo mostra as etapas de uma compilação de código.

![compiler][compiler01]

Vale ressaltar que compilar é diferente de interpretar o código. A interpretação ocorre quando o uso (comumente a execução) do código se dá junto à análise do mesmo. Diferentemente da compilação, como verificado acima, que é o processo de análise e possivelmente transformação do código fonte em código alvo, ou seja, o uso (execução, por exemplo) se dá em processo separado posterior, ainda que não tão posterior assim. A próxima figura, mostra as etapas da interpretação do código.

![interpretation][interpretation01]

Já o gerador de código ou máquina virtal é o software que permite que o programa seja executado. Une as melhores características da compilação e interpretação (anteriormente abordadas). A figura abaixo mostra um diagrama que resume essa abordagem híbrida.

![hybrid][hybrid01]

Segue uma imagem representativa da arquitetura básica para cada linguagem.

![diagramProgramming][diagramProgramming]

As principais linguagens de cada tipo e suas características:

- **Linguagens compiladas:** C, C++
  - velocidade do programa;
  - auxílio do compilador antes da execução;
  - sem portabilidade.
- **Linguagens interpretadas:** PHP, JavaScript;
  - flexibilidade de manutenção do aplicativo em produção;
  - expressividade da linguagem;
  - código fonte não precisa ser recompilado para rodar em plataformas diferentes;
  - programa mais lento, mas com muita portabilidade.
- **Linguagens pré-compiladas + máquina virtual:** Java, C#.

![compiler][compiler02]

![interpretation][interpretation02]

![hybrid][hybrid02]

<!-- MARKDOWN LINKS -->
<!-- SITES -->

<!-- IMAGES -->
[compiler01]: ../../Images/compiler01.png
[interpretation01]: ../../Images/interpretation01.png
[hybrid01]: ../../Images/hybrid01.png
[diagramProgramming]: ../../Images/diagramProgramming.png
[compiler02]: ../../Images/compiler02.png
[interpretation02]: ../../Images/interpretation02.png
[hybrid02]: ../../Images/hybrid02.png
[execution]: ../../Images/execution.png