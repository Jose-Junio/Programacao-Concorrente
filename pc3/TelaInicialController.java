/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 20/03/2021
* Ultima alteracao.: 25/03/2022
* Nome.............: Gerenciador de Peocessos Trem
* Funcao...........: O programa e utilizado gerencia os procesos que fazem com que os trens se colidam em momentos criticos
*************************************************************** */
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class TelaInicialController implements Initializable{
  @FXML
  private Label bandeiraDireita;

  @FXML
  private Label bandeiraEsquerda;

  @FXML
  private Button btStart;

  @FXML
  private ImageView trem1;
  
  @FXML
  private ImageView trem2;

  @FXML
  private Slider sldTrem1;

  @FXML
  private Slider sldTrem2;

  public Label getBandeiraDireita() {
      return bandeiraDireita;
  }

  //importacao das rotas do trem 
  Rotas rotas = new Rotas();
    
  int velocidadeTrem1, velocidadeTrem2;
  
  /*********************************************************************
  * Metodo: IniciarSimulacao
  * Funcao: Instancia e chama os metodos das threads para comecar a simulacao 
  * Parametros: ActionEvent do clicar do botao
  * Retorno: void
  ******************************************************************* */
  @FXML
  void IniciarSimulacao(ActionEvent event){
    trem1.setX(-130);
    trem2.setX(-130);
    trem1.setY(0);
    trem2.setY(0);

    btStart.setDisable(true);

    Threads tt = new Threads(btStart);//instancia classe com as classes threads trem
    tt.atribuiBandeiras(bandeiraDireita, bandeiraEsquerda);

    Threads.Trem1 threadTrem1 = tt.new Trem1(trem1, velocidadeTrem1);//instancia e inicia a classe thread de trem 1
    Threads.Trem2 threadTrem2 = tt.new Trem2(trem2, velocidadeTrem2);//instancia e inicia a classe thread de trem 2
    threadTrem1.start();//inicia trem 1
    threadTrem2.start();//inicia trem 2
  }

  /*********************************************************************
  * Metodo: Initializable
  * Funcao: Instancia e tudo que estiver dentro quando a classe é chamada
  * Parametros: URL location, ResourceBundle resources
  * Retorno: void
  ******************************************************************* */
  @Override
  public void initialize(URL location, ResourceBundle resources) {

    velocidadeTrem1 = 10;
    velocidadeTrem2 = 10;

    bandeiraDireita.setVisible(false); 
    bandeiraEsquerda.setVisible(false); 

    sldTrem1.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        velocidadeTrem1 = (int) sldTrem1.getValue();
      }
    });

    sldTrem2.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        velocidadeTrem2 = (int) sldTrem2.getValue();
      }
    });

  }

  /*********************************************************************
  * Metodo: start
  * Funcao: chama a tela de fxml quando a classe é iniciada
  * Parametros: novo Stages
  * Retorno: void
  ******************************************************************* */
  public void start(Stage stage) throws IOException {
    stage.setTitle("Gerenciamento de Processos trem");//coloca titulo na tela

    Parent root = FXMLLoader.load(getClass().getResource("/Inicial.fxml"));//captura a classe com o fxml
      
    Scene scene = new Scene(root);//coloca tela fxml na cena
      
    stage.setScene(scene);//coloca sena no estado
    stage.show();  //mostra o estado
  }   
}