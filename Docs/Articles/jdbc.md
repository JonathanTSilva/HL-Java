<!-- LOGO DIREITO -->
<a href="#"><img width="300px" src="https://darvishdarab.github.io/cs421_f20/assets/images/jdbc-b56f22932c17065dd130df67bee45bb0.png" align="right" /></a>

# Acesso ao banco de dados com JDBC

<p align="left">
  <a href="https://github.com/JonathanTSilva/HL-Java">
    <img src="https://img.shields.io/static/v1?label=HomeLab&message=Java&color=red&logo=java&logoColor=white&labelColor=grey&style=flat" alt="HL-Java">
  </a>
</p>

📚 A base de conhecimento em JDBC, abordando os principais recursos, estrutura básica de um projeto e padrão DAO.

<!-- SUMÁRIO -->
- [Programação funcional e expressões lambda](#programação-funcional-e-expressões-lambda)
  - [1.](#1)

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 1. Visão geral do JDBC

JDBC (Java Database Connectivity): API padrão do Java para acesso a dados

JDBC significa Java™ EE Database Connectivity. No desenvolvimento Java EE, esta é uma tecnologia bem conhecida e comumente utilizada para a implementação da interação do banco de dados. JDBC é uma API de nível de chamada, o que significa que as instruções SQL são transmitidas como sequências para a API que, então, se encarrega de executá-las no RDMS. Consequentemente, o valor dessas sequências pode ser alterado no tempo de execução, tornando o JDBC dinâmico.

Embora os programas JDBC sejam executados mais lentamente do que seus equivalentes SQLJ, uma vantagem dessa abordagem é um conceito conhecido como Escreva uma vez, chame em qualquer lugar. Isso significa que, como nenhuma interação é necessária até o tempo de execução, um programa JDBC é bastante móvel e pode ser levado entre diferentes sistemas, com gastos mínimos.

- Páginas oficiais ([1][1], [2][2])
- Pacotes: `java.sql` e `javax.sql` (API suplementar para servidores)

![A]

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 2. Algebra relacional e SQL - Nivelamento

Diagrama de classes exemplo para o tópico:

![B]

Diagrama de objetos da UML:

![C]

Modelo de dados em um nível relacional; tabelas com chaves primárias e chaves estrangeiras para fazer relacionamento entre as tabelas, entre outras:

![D]

### 2.1. Operações básicas da álgebra relacional

- Produto cartesiano: (resultado da combinação de cada registro de categoria com cada registro de produto)

```sql
SELECT * 
FROM PRODUCT, CATEGORY
```

![E]

- Junção (na verdade uma combinação do produto cartesiano e restrição de chaves correspondentes):

```sql
SELECT *
FROM PRODUCT, CATEGORY
WHERE
    PRODUCT.CATEGORY_ID = CATEGORY.ID 
```

```sql
SELECT *
FROM PRODUCT
INNER JOIN CATEGORY cat
    ON PRODUCT.CATEGORY_ID = cat.ID
```

![F]

- Restrição

```sql
SELECT * 
FROM PRODUCT
INNER JOIN CATEGORY cat ON PRODUCT.CATEGORY_ID = cat.ID
WHERE CATEGORY.NAME = 'Computers'
```

![G]

- Projeção

```sql
SELECT PRODUCT.*, CATEGORY.NAME
FROM PRODUCT
INNER JOIN CATEGORY cat ON PRODUCT.CATEGORY_ID = cat.ID
WHERE CATEGORY.NAME = 'Computers'
```

![H]

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 3. Prática com JDBC

<!-- MARKDOWN LINKS -->
<!-- SITES -->
[1]: https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/
[2]: https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html

<!-- IMAGES -->
[A]: ../../Images/jdbc.png
[B]: ../../Images/sql.png
[C]: ../../Images/sql2.png
[D]: ../../Images/sql3.png
[E]: ../../Images/prodCartesiano.png
[F]: ../../Images/juncao.png
[G]: ../../Images/restricao.png
[H]: ../../Images/projecao.png