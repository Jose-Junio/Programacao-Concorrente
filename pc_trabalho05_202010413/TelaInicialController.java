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
import javafx.stage.Stage;

public class TelaInicialController implements Initializable{

  @FXML
  private Slider pensar1;

  @FXML
  private Slider comer1;

  @FXML
  private Slider pensar2;

  @FXML
  private Slider comer2;

  @FXML
  private Slider pensar3;

  @FXML
  private Slider comer3;

  @FXML
  private Slider pensar4;

  @FXML
  private Slider comer4;

  @FXML
  private Slider pensar5;

  @FXML
  private Slider comer5;

  @FXML
  private Label garfo1;

  @FXML
  private Label garfo2;

  @FXML
  private Label garfo3;

  @FXML
  private Label garfo4;

  @FXML
  private Label garfo5;

  @FXML
  private Button iniciar;

  @FXML
  private Button pausar;

  //iniciando variaveis e instanciando classes que serao utilizadas no programa
  //variaveis de tempo de comer e pensar iniciadas com valor de 1 segundo
  private double varComer1 =1,varComer2 =1, varComer3 =1, varComer4 = 1, varComer5 =1;
  private double varPensar1 =1,varPensar2 =1, varPensar3 =1, varPensar4 = 1, varPensar5 =1;
  //variavel que verifica o inicio do programa ou a continuação para sua pausa 
  private int inicia;
  //vetor que aponta aos garfos
  private Label[] garfos = new Label[5];
  //instanciando classes
  MyThreads t = new MyThreads();
  MyThreads.Estado estado = t.new Estado();
  MyThreads.Filosofo filosofo1 = t.new Filosofo(0);
  MyThreads.Filosofo filosofo2 = t.new Filosofo(1);
  MyThreads.Filosofo filosofo3 = t.new Filosofo(2);
  MyThreads.Filosofo filosofo4 = t.new Filosofo(3);
  MyThreads.Filosofo filosofo5 = t.new Filosofo(4);

  /***********************
  * Metodo: iniciaProcesso
  * Funcao: iniciar o processo que e continuar o processo quando pausado
  * Parametros: ActionEvent do botao
  * Retorno: void
  *********************** */
  @FXML
  void iniciaProcesso(ActionEvent event) {  
    
    if(inicia == 0){//se for a primeira inicializacao
      inicia = 1;
      //adiciona os tempos aos determinados filosofos 
      filosofo1.setTempos(varPensar1, varComer1);
      filosofo2.setTempos(varPensar2, varComer2);
      filosofo3.setTempos(varPensar3, varComer3);
      filosofo4.setTempos(varPensar4, varComer4);
      filosofo5.setTempos(varPensar5, varComer5);
      //adiciona os garfos
      t.setGarfos(garfos);
      
      //inicializa as threads
      filosofo1.start();
      filosofo2.start();
      filosofo3.start();
      filosofo4.start();
      filosofo5.start();
      estado.start();

      iniciar.setDisable(true);//deixa o botao iniciar como invisivel
      pausar.setDisable(false);//deixa o botao pausar como visivel
      
    }else if(inicia == 1){//se o sistema foi pausado 
      //adiciona os tempos aos determinados filosofos 
      filosofo1.setTempos(varPensar1, varComer1);
      filosofo2.setTempos(varPensar2, varComer2);
      filosofo3.setTempos(varPensar3, varComer3);
      filosofo4.setTempos(varPensar4, varComer4);
      filosofo5.setTempos(varPensar5, varComer5);
      
      //despausar os processos
      filosofo1.resume();
      filosofo2.resume();
      filosofo3.resume();
      filosofo4.resume();
      filosofo5.resume();

      iniciar.setDisable(true);//deixa o botao iniciar como invisivel
      pausar.setDisable(false);//deixa o botao pausar como visivel
    }
  }

  @FXML
  void pausarProcesso(ActionEvent event) {
    pausar.setDisable(true);//deixa o botao iniciar como visivel
    iniciar.setDisable(false);//deixa o botao pausar como invisivel

    //pausa os processos 
    filosofo1.suspend();
    filosofo2.suspend();
    filosofo3.suspend();
    filosofo4.suspend();
    filosofo5.suspend();

  }


  public void initialize(URL location, ResourceBundle resources) { 
    //coloca os garfos em um array que sera passado para as threads
    garfos[0]=garfo1;
    garfos[1]=garfo2;
    garfos[2]=garfo3;
    garfos[3]=garfo4;
    garfos[4]=garfo5;

    //inicializa os sliders que seram utilizados para alterar a velicidade 
    pensar1.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        varPensar1 = (Double) pensar1.getValue();
        filosofo1.setTempoPensar((Double) pensar1.getValue());
      }
    });

    pensar2.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        varPensar2 = (Double) pensar2.getValue();
        filosofo2.setTempoPensar((Double) pensar2.getValue());
      }
    });

    pensar3.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        varPensar3 = (Double) pensar3.getValue();
        filosofo3.setTempoPensar((Double) pensar3.getValue());
      }
    });
    
    pensar4.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        varPensar4 = (Double) pensar4.getValue();
        filosofo4.setTempoPensar((Double) pensar4.getValue());
      }
    });

    pensar5.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        varPensar5 = (Double) pensar5.getValue();
        filosofo5.setTempoPensar((Double) pensar5.getValue());
      }
    });

    //slider temoo de comer
    comer1.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        varComer1 = (Double) comer1.getValue();
        filosofo1.setTemposComer((Double) comer1.getValue());
      }
    });

    comer2.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        varComer2 = (Double) comer2.getValue();
        filosofo2.setTemposComer((Double) comer2.getValue());
      }
    });

    comer3.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        varComer3 = (Double) comer3.getValue();
        filosofo3.setTemposComer((Double) comer3.getValue());
      }
    });

    comer4.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        varComer4 = (Double) comer4.getValue();
        filosofo4.setTemposComer((Double) comer4.getValue());
      }
    });

    comer5.valueProperty().addListener(new ChangeListener<Number>(){
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        varComer5 = (Double) comer5.getValue();
        filosofo5.setTemposComer((Double) comer5.getValue());
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
    stage.setTitle("Piquenique dos filosofos");

    Parent root = FXMLLoader.load(getClass().getResource("/Inicial.fxml"));

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
  }

}