/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 20/03/2021
* Ultima alteracao.: 25/03/2022
* Nome.............: Gerenciador de Peocessos Trem
* Funcao...........: O programa e utilizado gerencia os procesos que fazem com que os trens se colidam em momentos criticos
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