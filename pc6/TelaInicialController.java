/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 26/04/2022
* Ultima alteracao.: 04/05/2022
* Nome.............: Barbeiro dorminhoco
* Funcao...........: O programa e utilizado resolver o problema classico de barbeiro dorminhoco
* com a espera de processos e concorrencia em acessar determinada regiao
*************************************************************** */

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
import javafx.stage.Stage;

public class TelaInicialController implements Initializable{

  @FXML
  private Slider frequenciaCliente;

  @FXML
  private Slider velocidadeBarbeiro;

  @FXML
  private Button iniciar;

  @FXML
  private ImageView cliente3;

  @FXML
  private ImageView cliente2;

  @FXML
  private ImageView cliente5;

  @FXML
  private ImageView barbeiro;

  @FXML
  private ImageView cliente4;

  @FXML
  private ImageView cliente1;

  @FXML
  private Label ronco;

  private double varFrequenciaCliente = 1, varVelocidadeBarbeiro = 1;//inicializacao de variaveis de tempo
  private ImageView[] clientes = new ImageView[5];
  MyThreads myThreads = new MyThreads();
  MyThreads.Barbeiro thBarbeiro = myThreads.new Barbeiro();
  MyThreads.Cliente thCliente = myThreads.new Cliente();

  /***********************
  * Metodo: iniciaProcesso
  * Funcao: iniciar o processo que e continuar o processo quando pausado
  * Parametros: ActionEvent do botao
  * Retorno: void
  *********************** */
  @FXML
  void iniciaProcesso(ActionEvent event) {  
    
    myThreads.setImagens(clientes);
    myThreads.setBarbeiro(barbeiro, ronco);
      
    myThreads.setVelocidade(varVelocidadeBarbeiro);
    myThreads.setFrequenciaCliente(varFrequenciaCliente);

    thBarbeiro.start();
    thCliente.start();

    iniciar.setDisable(true);//deixa o botao iniciar como invisivel
  }


  public void initialize(URL location, ResourceBundle resources) { 
    clientes[0] = cliente1;//inicia os clientes em um array de imagens(ImageView)
    clientes[1] = cliente2;
    clientes[2] = cliente3;
    clientes[3] = cliente4;
    clientes[4] = cliente5;

    //inicializa os sliders que seram utilizados para alterar a velicidade 
    velocidadeBarbeiro.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        varVelocidadeBarbeiro = (Double) velocidadeBarbeiro.getValue();
        myThreads.setVelocidade((Double) velocidadeBarbeiro.getValue());
      }
    });

    frequenciaCliente.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        varFrequenciaCliente = (Double) frequenciaCliente.getValue();
        myThreads.setFrequenciaCliente((Double) frequenciaCliente.getValue());
      }
    });
  }

  /*********************************************************************
  * Metodo: start
  * Funcao: inicia tela do fxml
  * Parametros: stage para tela
  * Retorno: void
  ******************************************************************* */
  public void start(Stage stage) throws Exception {
    stage.setTitle("Barbeiro dorminhoco");

    Parent root = FXMLLoader.load(getClass().getResource("/Inicial.fxml"));

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
  }

}