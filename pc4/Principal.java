/* *********************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 29/03/2021
* Ultima alteracao.: 05/03/2022
* Nome.............: Sala de Espera
* Funcao...........: Utiliza conceitos de produtor consumidor para gerenciar uma sala de espera qualquer
* em que o produtor manda as pessoas para a sala e o consumidor tira elas de la
********************* */
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