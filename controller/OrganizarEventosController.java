package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Evento;

public class OrganizarEventosController {

  @FXML
  private Button adicionarEventoId;

  @FXML
  private DatePicker dataEvento;

  @FXML
  private Button excluirEventoId;

  @FXML
  private TextField horarioEvento;

  @FXML
  private TextArea listaEventos;

  @FXML
  private Button pesquisarEventoId;

  @FXML
  private TextField tituloEvento;

  @FXML
  private Button btVoltar;

  /*********************************************************************
  * Metodo: voltarTela
  * Funcao: volta para tela inicial de calendario
  * Parametros: stage para tela
  * Retorno: void
  ******************************************************************* */
  @FXML
  void voltarTela(ActionEvent event) throws Exception {
    CalendarioEventosController ce = new CalendarioEventosController();
    ce.start(new Stage());

    Stage stage = (Stage) btVoltar.getScene().getWindow(); 
    stage.close(); 
  }

  /*********************************************************************
  * Metodo: adicionarEvento
  * Funcao: adiciona evento na lista chamando controle do arquivo que escreve as serializacoes
  * Parametros: evento do botao
  * Retorno: void
  ******************************************************************* */
  @FXML
  void adicionarEvento(ActionEvent event) throws Exception {
    //pega valoea do campo de texto
    LocalDate dataEvent = dataEvento.getValue(); 
    String hora = horarioEvento.getText();
    String titulo = tituloEvento.getText();

    ControleDadosEventos cd = new ControleDadosEventos();
    cd.cadastrarEvento(dataEvent.toString(), hora, titulo);//metodo que chama o cadastro de eventos no arquivo

    CalendarioEventosController ce = new CalendarioEventosController();
    ce.start(new Stage());//inicia tela inicial de calendario 

    Stage stage = (Stage) adicionarEventoId.getScene().getWindow(); 
    stage.close(); //fecha tela atual
  }

  /*********************************************************************
  * Metodo: excluirEvento
  * Funcao: exclui evento na lista chamando controle do arquivo que escreve as serializacoes
  * Parametros: evento do botao
  * Retorno: void
  ******************************************************************* */
  @FXML
  void excluirEvento(ActionEvent event) throws Exception {
    //pega valoea do campo de texto
    LocalDate dataEvent = dataEvento.getValue();
    String hora = horarioEvento.getText();

    ControleDadosEventos cd = new ControleDadosEventos();
    cd.removerEvento(dataEvent.toString(), hora);//metodo que chama o excluir de eventos no arquivo
    
    CalendarioEventosController ce = new CalendarioEventosController();
    ce.start(new Stage());//inicia tela inicial de calendario 

    Stage stage = (Stage) excluirEventoId.getScene().getWindow(); 
    stage.close(); //fecha tela atual
  }

  /*********************************************************************
  * Metodo: pesquisarEvento
  * Funcao: pesquisar evento na lista chamando controle do arquivo que escreve as serializacoes
  * Parametros: evento do botao
  * Retorno: void
  ******************************************************************* */
  @FXML
  void pesquisarEvento(ActionEvent event) throws Exception {
    //pega valoea do campo de texto
    LocalDate dataEvent = dataEvento.getValue();
    String hora = horarioEvento.getText();

    if(hora.isEmpty()){//se a pesquisa for por data somente 
      ControleDadosEventos cd = new ControleDadosEventos();
      ArrayList<Evento> e = cd.pesquisarEventoData(dataEvent.toString());//metodo que chama o pesquisar de eventos no arquivo

      String data = "";

      for (int i=0; i<e.size(); i++){//passa por todos os eventos de hoje
        data = data + "Titulo: "+e.get(i).getTitulo()+", Data: "+e.get(i).getData()+", Hota: "+e.get(i).getHora()+"\n";
      }//adiciona as informacoes na string data
      listaEventos.setText(data);//adiciona string de informacoes no label
    }else{//se a pesquisa for por data e hora (dois campos preenchidos)
      ControleDadosEventos cd = new ControleDadosEventos();
      Evento e = cd.pesquisarEvento(dataEvent.toString(), hora);//metodo que chama o pesquisar de eventos no arquivo

      listaEventos.setText("Titulo: "+e.getTitulo()+", Data: "+e.getData()+", Hota: "+e.getHora()+"\n");//adiciona as informacoes na string data
    }
  }

  /*********************************************************************
  * Metodo: start
  * Funcao: inicia tela do fxml
  * Parametros: stage para tela
  * Retorno: void
  ******************************************************************* */
  public void start(Stage stage) throws Exception{
    stage.setTitle("Organizar eventos");

    Parent root = FXMLLoader.load(getClass().getResource("/view/OrganizarEventos.fxml"));

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
  }

  public void initialize() {
  }
}

