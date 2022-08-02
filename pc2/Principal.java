/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 27/12/2021
* Ultima alteracao.: 30/01/2022
* Nome.............: Calendario de eventos
* Funcao...........: O programa e utilizado para agendar eventos nos dias do mes
*************************************************************** */


// caso possua muitos erros nos comentarios é pelo fato de o notebook quebrar o teclado e 
// todos os comentarios foram escritos com o teclado virtual
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
    ArvoreController ce = new ArvoreController();
    ce.start(new Stage());
  }
}