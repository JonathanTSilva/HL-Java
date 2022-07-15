<!-- LOGO DIREITO -->
<a href="#"><img width="200px" src="../../Images/folders.png" align="right" /></a>

# Trabalhando com arquivos

<p align="left">
  <a href="https://github.com/JonathanTSilva/HL-Java">
    <img src="https://img.shields.io/static/v1?label=HomeLab&message=Java&color=red&logo=java&logoColor=white&labelColor=grey&style=flat" alt="HL-Java">
  </a>
</p>

🔎 Aprenda a manipular arquivos e pastas dentro de um ambiente de programação Java.

<!-- SUMÁRIO -->
- [Trabalhando com arquivos](#trabalhando-com-arquivos)
  - [1. Lendo arquivo de texto com classes File e Scanner](#1-lendo-arquivo-de-texto-com-classes-file-e-scanner)
  - [2. Lendo arquivo de texto com classes FileReader e BufferedReader](#2-lendo-arquivo-de-texto-com-classes-filereader-e-bufferedreader)
  - [3. Bloco `try-with-resources`](#3-bloco-try-with-resources)
  - [4. Escrevendo em arquivos com o FileWriter e BufferedWriter](#4-escrevendo-em-arquivos-com-o-filewriter-e-bufferedwriter)
  - [5. Manipulando pastas com File](#5-manipulando-pastas-com-file)
  - [6. Obter informações do caminho de um arquivo](#6-obter-informações-do-caminho-de-um-arquivo)

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 1. Lendo arquivo de texto com classes File e Scanner

Para este tópico, serão utilizadas as seguintes classes:

- [File][1] - Representação abstrata de um arquivo e seu caminho
- [Scanner][2] - Leitor de texto
- [IOException][3] (Exception - compilador obriga o tratamento dessa exceção)

Um arquivo foi criado na pasta tmp/ do sistema, com o seguinte comando:

```bash
$ mktemp -t testfile.XXXXXX
$ echo "Good morning" > /tmp/testfile.f4XIUQ
$ echo "Good afternoon" >> /tmp/testfile.f4XIUQ
$ cat /tmp/testfile.f4XIUQ
> Good morning
> Good afternoon
```

Assim, a leitura básica de um arquivo pode ser feita da seguinte forma:

```java
package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        File file = new File("/tmp/testfile.f4XIUQ");
        Scanner sc = null;
        
        try {
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Boas práticas para que o recurso seja executado independente de der certo ou não;
            if (sc != null) {
                sc.close();
            }
        }

    }
}
```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 2. Lendo arquivo de texto com classes FileReader e BufferedReader

Para essa seção, serão utilizadas as duas classes:

- [FileReader][4] (stream de leitura de caracteres a partir de arquivos)
- [BufferedReader][5] (mais rápido)
  - [Diferenças entre BufferedReader e FileReader][6]

Em sua implementação, percebe-se o desconforto para manipular tal arquivo (será resolvido nas próximas seções):

```java
package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        String path = "/tmp/testfile.f4XIUQ";
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 3. Bloco `try-with-resources`

É um bloco try que declara um ou mais recursos, e garante que esses recursos serão fechados ao final do bloco. Disponível no [Java 7 em diante][7].

Ainda no código desenvolvido na seção acima, note a simplicidade que ficará ler um arquivo agora:

```java
package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        String path = "/tmp/testfile.AW5Hga";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 4. Escrevendo em arquivos com o FileWriter e BufferedWriter

- [FileWriter][8] (stream de escrita de caracteres em de arquivos)
  - Cria/recria o arquivo: `new FileWriter(path)`
  - Acrescenta ao arquivo existente: `new FileWriter(path, true)`
- [BufferedWriter][9] (mais rápido)

```java
package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        
        String[] lines = new String[] {"Good morning", "Good afternoon", "Good night"};
        
        String path = "/tmp/out.txt";
        
        // O parâmetro true indica que não quer que recrie o arquivo. Semelhante ao >> do bash
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 5. Manipulando pastas com File

```java
package application;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();
        
        File path = new File(strPath);
        
        // Ler as pastas do strPath
        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("FOLDERS:");
        for (File folder : folders) {
            System.out.println(folder);
        }
        
        // Ler os arquivos do strPath
        File[] files = path.listFiles(File::isFile);
        System.out.println("FILES:");
        for (File file : files) {
            System.out.println(file);
        }
        
        // Criar uma subpasta a partir da pasta strPath
        boolean success = new File(strPath + "\\subdir").mkdir();
        System.out.println("Directory created successfully: " + success);
        sc.close();
    }
}
```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 6. Obter informações do caminho de um arquivo

```java
package application;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();
        
        File path = new File(strPath);
        
        System.out.println("getPath: " + path.getPath());
        System.out.println("getParent: " + path.getParent());
        System.out.println("getName: " + path.getName());
        
        sc.close();
    }
}
```

<!-- MARKDOWN LINKS -->
<!-- SITES -->
[1]: https://docs.oracle.com/javase/10/docs/api/java/io/File.html
[2]: https://docs.oracle.com/javase/10/docs/api/java/util/Scanner.html
[3]: https://docs.oracle.com/javase/10/docs/api/java/io/IOException.html
[4]: https://docs.oracle.com/javase/10/docs/api/java/io/FileReader.html
[5]: https://docs.oracle.com/javase/10/docs/api/java/io/BufferedReader.html
[6]: https://stackoverflow.com/questions/9648811/specific-difference-between-bufferedreader-and-filereader
[7]: https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
[8]: https://docs.oracle.com/javase/10/docs/api/java/io/FileWriter.html
[9]: https://docs.oracle.com/javase/10/docs/api/java/io/BufferedWriter.html

<!-- IMAGES -->
