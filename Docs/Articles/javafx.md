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
Checklist:

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
