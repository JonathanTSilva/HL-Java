<!-- LOGO DIREITO -->
<a href="#"><img width="300px" src="https://miro.medium.com/max/1400/1*bX30BRMq1oiz2v_rkOIoQA.png" align="right" /></a>

# Interfaces

<p align="left">
  <a href="https://github.com/JonathanTSilva/HL-Java">
    <img src="https://img.shields.io/static/v1?label=HomeLab&message=Java&color=red&logo=java&logoColor=white&labelColor=grey&style=flat" alt="HL-Java">
  </a>
</p>

🔎 Assunto intermediário, mas de grande importância para sua aplicação Java.

<!-- SUMÁRIO -->
- [Interfaces](#interfaces)
  - [1. Introdução](#1-introdução)
    - [1.1. Programa exemplo](#11-programa-exemplo)

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 1. Introdução

A interface é um recurso muito utilizado em Java, bem como na maioria das linguagens orientadas a objeto, para “obrigar” um determinado grupo de classes a ter métodos ou propriedades em comum para existir em um determinado contexto, contudo os métodos podem ser implementados em cada classe de uma maneira diferente. Pode-se dizer, a grosso modo, que uma interface é um contrato que quando assumido por uma classe deve ser implementado.

A partir do Java 8, interfaces podem ter "default methods" ou "defender methods". Isso possui implicações conceituais e práticas, que serão discutidas mais à frente neste capítulo. Primeiro vamos trabalhar com a definição "clássica" de interfaces. Depois vamos acrescentar o conceito de default methods.

Em suma, interface é um tipo que define um conjunto de operações que uma classe deve implementar. A interface estabelece um contrato que a classe deve cumprir.

**Pra quê interfaces?**

Para criar sistemas com baixo acoplamento e flexíveis.

```java
interface Shape {
  double area();
  double perimeter();
}
```

### 1.1. Programa exemplo

Uma locadora brasileira de carros cobra um valor por hora para locações de até
12 horas. Porém, se a duração da locação ultrapassar 12 horas, a locação será
cobrada com base em um valor diário. Além do valor da locação, é acrescido no
preço o valor do imposto conforme regras do país que, no caso do Brasil, é 20%
para valores até 100.00, ou 15% para valores acima de 100.00. Fazer um
programa que lê os dados da locação (modelo do carro, instante inicial e final da
locação), bem como o valor por hora e o valor diário de locação. O programa
deve então gerar a nota de pagamento (contendo valor da locação, valor do
imposto e valor total do pagamento) e informar os dados na tela. Veja os
exemplos.

<details close="close" align="left">
  <summary><b>Exemplo 1</b></summary>
  <pre>
    <code>
Enter rental data
Car model: Civic
Pickup (dd/MM/yyyy hh:mm): 25/06/2018 10:30
Return (dd/MM/yyyy hh:mm): 25/06/2018 14:40
Enter price per hour: 10.00
Enter price per day: 130.00
INVOICE:
Basic payment: 50.00
Tax: 10.00
Total payment: 60.00
    </code>
  </pre>
</details>

<details close="close" align="left">
  <summary><b>Cálculos do exemplo 1</b></summary>
  <pre>
    <code>
Duration = (25/06/2018 14:40) - (25/06/2018 10:30) = 4:10 = 5 hours
Basic payment = 5 * 10 = 50
Tax = 50 * 20% = 50 * 0,2 = 10
    </code>
  </pre>
</details>


<details close="close" align="left">
  <summary><b>Exemplo 2</b></summary>
  <pre>
    <code>
Enter rental data
Car model: Civic
Pickup (dd/MM/yyyy hh:mm): 25/06/2018 10:30
Return (dd/MM/yyyy hh:mm): 27/06/2018 11:40
Enter price per hour: 10.00
Enter price per day: 130.00
INVOICE:
Basic payment: 390.00
Tax: 58.50
Total payment: 448.50
    </code>
  </pre>
</details>

<details close="close" align="left">
  <summary><b>Cálculos do exemplo 2</b></summary>
  <pre>
    <code>
Duration = (27/06/2018 11:40) - (25/06/2018 10:30) = 2 days + 1:10 = 3 days
Basic payment = 3 * 130 = 390
Tax = 390 * 15% = 390 * 0.15 = 58.50
    </code>
  </pre>
</details>

<details close="close" align="left">
  <summary><b>Diagrama UML - Design da camada de domínio</b></summary>
  <p float="left">
    <img src="../../Images/interfaces01.png"/>
  </p>
</details>

<details close="close" align="left">
  <summary><b>Diagrama UML - Design da camada de serviço (sem interface)</b></summary>
  <p float="left">
    <img src="../../Images/interfaces02.png"/>
  </p>
</details>

<details close="close" align="left">
  <summary><b>Diagrama UML - Design da camada de serviço (com interface)</b></summary>
  <p float="left">
    <img src="../../Images/interfaces03.png"/>
  </p>
</details>

Os códigos de resolução para essa atividade podem ser encontrados na subpasta do projeto `Build/Course-JCPOO/ExRes15-Interface`.

<!-- MARKDOWN LINKS -->
<!-- SITES -->

<!-- IMAGES -->
