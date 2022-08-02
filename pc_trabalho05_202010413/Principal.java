/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 13/04/2022
* Ultima alteracao.: 22/04/2022
* Nome.............: Jantar dos filosofos
* Funcao...........: O programa e utilizado resolver um problema de concorrencia em que 
* dois ou mais processos necessitam acessar o mesmo recurso e alteralo, no caso o garfo que
* varios filosofos tem que pegar
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