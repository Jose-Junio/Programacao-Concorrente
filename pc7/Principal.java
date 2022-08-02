/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 13/05/2022
* Ultima alteracao.: 20/05/2022
* Nome.............: Transito Automato
* Funcao...........: O programa e utilizado resolver o problema de gerenciamento de procesos 
em um transito automato com 7 carros e varias regioes criticas
*************************************************************** */
import javafx.application.Application;
import javafx.stage.Stage;

public class Principal extends Application{

  public static void main(String[] args){
    launch(args);
  }

  /*********************************************************************
  * Metodo: start
  * Funcao: instatancia a classe controller do fxml principal 
  * e inicia o a tela com o metodo start
  * Parametros: Stage que inicia a cena
  * Retorno: void
  ******************************************************************* */
  @Override
  public void start(Stage stage) throws Exception {
    // instatancia a classe controller do fxml principal e inicia o a tela com o metodo start
    TelaInicialController ti = new TelaInicialController();
    ti.start(new Stage());
  }
}