/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 26/04/2022
* Ultima alteracao.: 04/05/2022
* Nome.............: Barbeiro dorminhoco
* Funcao...........: O programa e utilizado resolver o problema classico de barbeiro dorminhoco
* com a espera de processos e concorrencia em acessar determinada regiao
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