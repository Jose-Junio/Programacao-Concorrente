/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 13/05/2022
* Ultima alteracao.: 21/05/2022
* Nome.............: Transito Automato
* Funcao...........: O programa e utilizado resolver o problema de gerenciamento de procesos 
em um transito automato com 7 carros e varias regioes criticas
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
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class TelaInicialController implements Initializable{

  @FXML
  private ImageView carro2;

  @FXML
  private ImageView carro3;

  @FXML
  private ImageView carro4;

  @FXML
  private ImageView carro5;

  @FXML
  private ImageView carro6;

  @FXML
  private ImageView carro7;

  @FXML
  private ImageView carro1;

  @FXML
  private Slider velocidadeCarro1;

  @FXML
  private Slider velocidadeCarro2;

  @FXML
  private Slider velocidadeCarro3;

  @FXML
  private Slider velocidadeCarro4;

  @FXML
  private Slider velocidadeCarro5;

  @FXML
  private Slider velocidadeCarro6;

  @FXML
  private Slider velocidadeCarro7;

  @FXML
  private Button btStart;
  
  //inicializacao de variaveis de tempo
  private ImageView[] carros = new ImageView[7];
  MyThreads myThreads = new MyThreads();//instancia a classe com as threads
  MyThreads.Carro1 tCarro1 = myThreads.new Carro1();
  MyThreads.Carro2 tCarro2 = myThreads.new Carro2();
  MyThreads.Carro3 tCarro3 = myThreads.new Carro3();
  MyThreads.Carro4 tCarro4 = myThreads.new Carro4();
  MyThreads.Carro5 tCarro5 = myThreads.new Carro5();
  MyThreads.Carro6 tCarro6 = myThreads.new Carro6();
  MyThreads.Carro7 tCarro7 = myThreads.new Carro7();

  /***********************
  * Metodo: actionStart
  * Funcao: iniciar o processo
  * Parametros: ActionEvent do botao
  * Retorno: void
  *********************** */
  @FXML
  void actionStart(ActionEvent event) {
    myThreads.setCarros(carros);
    
    tCarro1.start();
    tCarro2.start();
    tCarro3.start();
    tCarro4.start();
    tCarro5.start();
    tCarro6.start();
    tCarro7.start();

    btStart.setDisable(true);
  }

  /*********************************************************************
  * Metodo: initialize
  * Funcao: executar as primeiras funcoes do projeto
  * Parametros: URL location, ResourceBundle resources
  * Retorno: void
  ******************************************************************* */
  public void initialize(URL location, ResourceBundle resources) { 
    carros[0] = carro1;//inicia os carros em um array de imagens(ImageView)
    carros[1] = carro2;
    carros[2] = carro3;
    carros[3] = carro4;
    carros[4] = carro5;
    carros[5] = carro6;
    carros[6] = carro7;

    //inicializa os sliders que seram utilizados para alterar a velicidade 
    velocidadeCarro1.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        tCarro1.setVelocidade((Double) velocidadeCarro1.getValue());
      }
    });

    velocidadeCarro2.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        tCarro2.setVelocidade((Double) velocidadeCarro2.getValue());
      }
    });

    velocidadeCarro3.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        tCarro3.setVelocidade((Double) velocidadeCarro3.getValue());
      }
    });

    velocidadeCarro4.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        tCarro4.setVelocidade((Double) velocidadeCarro4.getValue());
      }
    });

    velocidadeCarro5.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        tCarro5.setVelocidade((Double) velocidadeCarro5.getValue());
      }
    });

    velocidadeCarro6.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        tCarro6.setVelocidade((Double) velocidadeCarro6.getValue());
      }
    });

    velocidadeCarro7.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        tCarro7.setVelocidade((Double) velocidadeCarro7.getValue());
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
    stage.setTitle("Transito autonomo");

    Parent root = FXMLLoader.load(getClass().getResource("/Inicial.fxml"));

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
  }

}