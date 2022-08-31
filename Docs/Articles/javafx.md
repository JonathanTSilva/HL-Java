<!-- LOGO DIREITO -->
<a href="#"><img width="300px" src="http://taverna.devall.com.br/uploads/default/original/1X/c80c3b40f56c23824504e7c2a3e0d081f9ff2087.png" align="right" /></a>

# Interface gráfica com JavaFX

<p align="left">
  <a href="https://github.com/JonathanTSilva/HL-Java">
    <img src="https://img.shields.io/static/v1?label=HomeLab&message=Java&color=red&logo=java&logoColor=white&labelColor=grey&style=flat" alt="HL-Java">
  </a>
</p>

📚 Conheça um pouco sobre a interface gráfica do Java: JavaFx.

<!-- SUMÁRIO -->
- [Interface gráfica com JavaFX](#interface-gráfica-com-javafx)
  - [1. Visão geral do JavaFx](#1-visão-geral-do-javafx)
  - [2. Preparando ambiente](#2-preparando-ambiente)
  - [3. Criando novo projeto](#3-criando-novo-projeto)
    - [3.1. Teste do FXML](#31-teste-do-fxml)
  - [4. Tratando eventos com JavaFX](#4-tratando-eventos-com-javafx)
  - [5. Mostrar alerta](#5-mostrar-alerta)
  - [5. App básico para calcular soma](#5-app-básico-para-calcular-soma)

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 1. Visão geral do JavaFx

- JavaFX é o sucessor do Swing e Java AWT para interfaces gráficas com Java
- JavaFX pode ser usado para desktop, web e mobile
- Uma tela JavaFX pode ser montada via código Java, ou via código FXML
- Com o lançamento do Java 11, JavaFX não é mais parte do JDK
  - O JavaFX precisa ser baixado e configurado separadamente
  - É mantido pela [Gluon][1]
- [Hierarquia do JavaFx][2]
- JavaFX é projetado sobre o padrão **MVC**
  - **Model** - consiste nos dados de domínio e toda lógica de transformação desses dados
  - **Views** - São as telas de interação com o usuário (UI)
  - **Controllers** - São as classes responsáveis por tratar as interações do usuário com as views(manipulação de eventos de interação com as telas)

![A]

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 2. Preparando ambiente

ATENÇÃO: [Eclipse 4.9 ou superior][3]

- Baixar o [JavaFX SDK][4]
  - Salvar em uma pasta "fácil", de preferência com nome sem espaços
    - Exemplo: `/home/jonathan/.java-libs`
- Instalar o plug-in E(fx)clipse no Eclipse (ATENÇÃO: versão 3.4.1 ou superior)
  - Help -> Install new Software
  - Work with: escolha o correspondente à versão do seu Eclipse
    - Exemplo: [2022-03][5]
    - Exemplo de [link direto][6]
  - Localize e(fx)clipse
  - `Next -> Next -> etc.`
  - Reinicie o Eclipse
- Referenciar o SceneBuilder no Eclipse
  - `Window -> Preferences -> JavaFX`
  - Entrar o caminho completo do arquivo executável do Scene Builder
    - Exemplo: `/opt/scenebuilder/bin/SceneBuilder`
- Criar uma User Library no Eclipse com o nome de JavaFX:
  - `Window -> Preferences -> Java -> Build Path -> User Libraries -> New`
  - Dê o nome de User Library
  - Add External Jars (aponte para a pasta bin do JavaFX)

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 3. Criando novo projeto

- Criação do projeto:
  - `File -> New -> Other -> JavaFX Project`
  - Dê um nome ao projeto e clique Next
  - Na aba Libraries, selecione Modulepath, clique Add Library, e selecione JavaFX
  - Clique Finish
  - Module Info: Don't Create
- Configuração do build:
  - Botão direito no projeto -> Run As -> Run Configurations -> Arguments -> VM Arguments
  - Copiar o conteúdo abaixo, adaptando para sua pasta:
  - `--module-path C:\java-libs\javafx-sdk\lib --add-modules=javafx.fxml,javafx.controls`

**src > application > Main.java**

```java
package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
  @Override
  public void start(Stage primaryStage) {
    try {
      BorderPane root = new BorderPane();
      Scene scene = new Scene(root,400,400);
      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
```

### 3.1. Teste do FXML

- Criar um pacote **gui**
- Criar um FXML no projeto: Botão direito no pacote `gui -> New -> Other -> New FXML Document`
  - Nome: `View`
- Abra o FXML no SceneBuilder: `Botão direito -> Open in SceneBuilder`
- Observe as guias: **Library**, **Document** e **Inspector**
  - `Inspector -> Layout`: defina largura e altura, depois salve
  - `Library -> Control`: acrescente alguns controles (ex: TextField, Button)
- De volta ao Eclipse, na classe Main, refazer o método start:

**src > application > Main.java**

```java
package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/gui/View.fxml"));
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

>**Nota:** se estiver utilizando algum `module-info.java`, é necessário acrescentar a os requires corretos lá, como: `requires javafx.controls; requires javafx.fxml;`

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 4. Tratando eventos com JavaFX

- Crie uma classe controladora da sua view (ex: **ViewController.java**)
- No controlador:
  - Criar um atributo correspondente ao controle desejado e anotá-lo com @FXML
  - Criar um método para tratar o evento desejado do controle e anotá-lo com @FXML
- Na view (Scene Builder):
  - Associar a view ao controller (aba **Controller**)
  - Selecione o controle e associe a ele o id (aba **Code**)
  - Selecione o controle e associe o método ao evento desejado (aba **Code**)

>**Dica:** quando mudar algo no SceneBuilder, use `Project -> Clean` no Eclipse para forçar a atualização do projeto

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 5. Mostrar alerta

```java
package gui.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
    public static void showAlert(String title, String header, String content, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }
}
```

<!-- VOLTAR AO INÍCIO -->
<a href="#"><img width="40px" src="https://github.com/JonathanTSilva/JonathanTSilva/blob/main/Images/back-to-top.png" align="right" /></a>

## 5. App básico para calcular soma

- Desenhar tela no SceneBuilder (usar um label para resultado)
  - Propriedade "promptText"
- Criar um controller e implementar código para mostrar a soma
  - Tratar exceção NumberFormatException
- De volta ao Scene Builder, fazer as associações de id e evento

> **DICA:** quando mudar algo no SceneBuilder, use Project -> Clean no Eclipse para forçar a atualização do projeto

<!-- MARKDOWN LINKS -->
<!-- SITES -->
[1]: https://gluonhq.com/products/javafx/
[2]: https://docs.oracle.com/javase/8/javafx/api/overview-tree.html
[3]: http://www.eclipse.org/downloads/packages/
[4]: https://gluonhq.com/products/javafx/
[5]: http://download.eclipse.org/releases/2022-03
[6]: http://download.eclipse.org/efxclipse/updates-released/3.7.0/site/

<!-- IMAGES -->
[A]: ../../Images/javafx1.png
