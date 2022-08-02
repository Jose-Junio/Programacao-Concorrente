/* *********************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 29/03/2021
* Ultima alteracao.: 05/03/2022
* Nome.............: Sala de Espera
* Funcao...........: Utiliza conceitos de produtor consumidor para gerenciar uma sala de espera qualquer
* em que o produtor manda as pessoas para a sala e o consumidor tira elas de la
********************* */
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
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;

public class TelaInicialController implements Initializable{
  @FXML
  private Button btIniciar;

  @FXML
  private Button btParar;

  @FXML
  private ImageView pessoa1;

  @FXML
  private ImageView pessoa2;

  @FXML
  private ImageView pessoa3;

  @FXML
  private ImageView pessoa4;

  @FXML
  private ImageView pessoa5;

  @FXML
  private ImageView pessoa6;

  @FXML
  private ImageView pessoa7;

  @FXML
  private Slider velCham;

  @FXML
  private Slider velEntrada;

  private int inicia = 0;
  private int velocidadeChamada = 4, VelocidadeEntrada = 2;
  ImageView[] iv = new ImageView[7];
  Threads t = new Threads(iv);
  Threads.Produtor prod = t.new Produtor();
  Threads.Consumidor cons = t.new Consumidor();

  /*********************************************************************
  * Metodo: IniciarAnimacao
  * Funcao: chama os metodos para iniciar a simulacao ou retomar a sumulacao pausada
  * Parametros: ActionEvent do clicar do botao
  * Retorno: void
  ******************************************************************* */
  @FXML
  void IniciarAnimacao(ActionEvent event) {
    if(inicia == 0){
      inicia = 1;
      prod.setVelocidade(VelocidadeEntrada);
      cons.setVelocidade(velocidadeChamada);
      
      prod.start();
      cons.start();

      btIniciar.setDisable(true);
      btParar.setDisable(false);
      velCham.setDisable(true);
      velEntrada.setDisable(true);

    }else if(inicia == 1){
      prod.setVelocidade(VelocidadeEntrada);
      cons.setVelocidade(velocidadeChamada);

      prod.resume();
      cons.resume();

      btIniciar.setDisable(true);
      btParar.setDisable(false);
      velCham.setDisable(true);
      velEntrada.setDisable(true);
    }
    
  }

  /*********************************************************************
  * Metodo: pararAnimacao
  * Funcao: chama os metodos para pausar a simulacao
  * Parametros: ActionEvent do clicar do botao
  * Retorno: void
  ******************************************************************* */
  @FXML
  void pararAnimacao(ActionEvent event) {
    btParar.setDisable(true);
    btIniciar.setDisable(false);
    velCham.setDisable(false);
    velEntrada.setDisable(false);

    prod.suspend();
    cons.suspend();
  }

  /*********************************************************************
  * Metodo: Initializable
  * Funcao: Instancia e inicializa as variaveis necessarias para a simulação
  * Parametros: URL location, ResourceBundle resources
  * Retorno: void
  ******************************************************************* */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    btParar.setDisable(true);

    //cria o array com as imagens que serao dispostas na tela
    iv[0] = pessoa1;
    iv[1] = pessoa2;
    iv[2] = pessoa3;
    iv[3] = pessoa4;
    iv[4] = pessoa5;
    iv[5] = pessoa6;
    iv[6] = pessoa7;

    for(int j =0;j<7;j++){
      iv[j].setVisible(false);
    }

    //inicializa os sliders que seram utilizados para alterar a velicidade 
    velCham.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        velocidadeChamada = (int) velCham.getValue();
      }
    });

    velEntrada.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        VelocidadeEntrada = (int) velEntrada.getValue();
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
    stage.setTitle("Produtor Consumidor/ Sala de espera");//coloca titulo na tela

    Parent root = FXMLLoader.load(getClass().getResource("/Inicial.fxml"));//captura a classe com o fxml
      
    Scene scene = new Scene(root);//coloca tela fxml na cena
      
    stage.setScene(scene);//coloca sena no estado
    stage.show();  //mostra o estado
  }   
}