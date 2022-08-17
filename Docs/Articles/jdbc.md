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

### 3.1. Criando uma base de dados

- Usando o MySQL Workbench, crie uma base de dados chamada "coursejdbc"
- Baixar o MySQL Java Connector
- Caso ainda não exista, criar uma User Library contendo o arquivo .jar do driver do MySQL
  - Window -> Preferences -> Java -> Build path -> User Libraries
  - Dê o nome da User Library de MySQLConnector
  - Add external JARs -> (localize o arquivo jar)
- Criar um novo Java Project
  - Acrescentar a User Library MySQLConnector ao projeto
  - Na pasta raiz do projeto, criar um arquivo "db.properties" contendo os dados de conexão:

```plaintext
user=developer
password=1234567
dburl=jdbc:mysql://localhost:3306/coursejdbc
useSSL=false
```

- No pacote "db", criar uma exceção personalizada DbException
- No pacote "db", criar uma classe DB com métodos estáticos auxiliares
  - Obter e fechar uma conexão com o banco

**src > application > Program.java**

```java
package application;

import java.sql.Connection;

import db.DB;

public class Program {

    public static void main(String[] args) {

        Connection conn = DB.getConnection();
        DB.closeConneciton();

    }

}
```

**src > db > DB.java**

```java
package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }

        }
        return conn;
    }

    public static void closeConneciton() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
}
```

**src > db > DdException.java**

```java
package db;

public class DbException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DbException(String msg) {
        super(msg);
    }

}
```

### 3.2. Recuperar dados

- API:
  - Statement
  - ResultSet
    - first() [move para posição 1, se houver]
    - beforeFirst() [move para posição 0]
    - next() [move para o próximo, retorna false se já estiver no último]
    - absolute(int) [move para a posição dada, lembrando que dados reais começam em 1]
- Checklist
  - Usar o script SQL para criar a base de dados "coursejdbc"
  - Fazer um pequeno programa para recuperar os departamentos
  - Na classe DB, criar métodos auxiliares estáticos para fechar ResultSet e Statement

**src > application > Program.java**

```java
package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM department");

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.closeConneciton();
        }
    }

}
```

**src > db > DB.java**

```java
package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
    
    private static Connection conn = null;
    
    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
            
        }
        return conn;
    }

    public static void closeConneciton() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
    
    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
    
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
    
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
```

### 3.3. Inserindo dados

- API:
  - PreparedStatement
  - executeUpdate
  - Statement.RETURN_GENERATED_KEYS
  - getGeneratedKeys
- Checklist:
  - Inserção simples com preparedStatement
  - Inserção com recuperação de Id

**src > application > Program.java**

```java
package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

    public static void main(String[] args) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DB.getConnection();
            /*
            st = conn.prepareStatement(
                    "INSERT INTO seller "
                    + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                    + "VALUES "
                    + "(?,?,?,?,?)",
                    + Statement.RETURN_GENERATED_KEYS);
            
            st.setString(1, "Jene Brown");
            st.setString(2, "jene@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("26/02/1976").getTime()));
            st.setDouble(4, 5000.0);
            st.setInt(5, 4);
            */
            
            st = conn.prepareStatement(
                    "INSERT INTO department (Name) VALUES ('D1'),('D2')",
                    Statement.RETURN_GENERATED_KEYS);
            
            int rowsAffected = st.executeUpdate();
            
            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            } else {
                System.out.println("No rows affected!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
        } finally {
            DB.closeStatement(st);
            DB.closeConneciton();
        }
        
    }

}
```

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
