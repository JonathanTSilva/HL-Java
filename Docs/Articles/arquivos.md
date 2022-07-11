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

<!-- MARKDOWN LINKS -->
<!-- SITES -->
[1]: https://docs.oracle.com/javase/10/docs/api/java/io/File.html
[2]: https://docs.oracle.com/javase/10/docs/api/java/util/Scanner.html
[3]: https://docs.oracle.com/javase/10/docs/api/java/io/IOException.html
[4]: https://docs.oracle.com/javase/10/docs/api/java/io/FileReader.html
[5]: https://docs.oracle.com/javase/10/docs/api/java/io/BufferedReader.html
[6]: https://stackoverflow.com/questions/9648811/specific-difference-between-bufferedreader-and-filereader

<!-- IMAGES -->
