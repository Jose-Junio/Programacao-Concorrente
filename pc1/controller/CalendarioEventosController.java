package controller;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import model.Evento;

public class CalendarioEventosController {
  @FXML
 private TextArea eventosDia3;

  @FXML
  private Button btOrganizarEvento;

  @FXML
  private Label dataDia1;

  @FXML
  private Label dataDia3;

  @FXML
  private Label dataDia2;

  @FXML
  private TextArea eventosDia1;

  @FXML
  private TextArea eventosDia2;

  @FXML
  private Label mesAno;

  /*********************************************************************
  * Metodo: organizarEvento
  * Funcao: abre a tela de organizacao de eventos 
  * Parametros: event do botao
  * Retorno: void
  ******************************************************************* */
  @FXML
  void organizarEvento(ActionEvent event) throws Exception {
    OrganizarEventosController oe = new OrganizarEventosController();//instancia o controller do fxml chamado
    oe.start(new Stage());//chama o metodo de abri a tela do fxml

    Stage stage = (Stage) btOrganizarEvento.getScene().getWindow(); // pega a tela em que o botao clicado esta
    stage.close(); //fecha a tela atual
  }

  public void initialize() {
    System.out.println("Carregando dados");

    LocalDate localDate = LocalDate.now();//pega variavel com data atual
    System.out.println(localDate);
    String dia =  localDate.getDayOfWeek().name();//pega nome do dia de hoje na semana
    int diaMes =  localDate.getDayOfMonth();//pega dia do mes
    String mes = localDate.getMonth().name();//pega nome do mes
    int ano = localDate.getYear();//pega ano atual
    LocalDate diaSeguinte = localDate.plusDays(1);//data do dia seguinte
    LocalDate diaSeguinte2 = diaSeguinte.plusDays(1);//data do dia seguinte ao seguinte
    String eventosData1, eventosData2, eventosData3;

    try{
      ControleDadosEventos cd = new ControleDadosEventos();
      ArrayList<Evento> e = cd.pesquisarEventoData(localDate.toString());//pesquisa evento de hoje por data

      String data = "";

      for (int i=0; i<e.size(); i++){//passa por todos os eventos de hoje
        data = data +"Hota: "+e.get(i).getHora()+", Titulo: "+e.get(i).getTitulo()+"\n";//adiciona asinformacoes na string data
      }
      eventosData1 = data;
    }catch(Exception e){//se nao ouver eventos
      eventosData1 = "Sem eventos Hoje";
    }
    try{
      ControleDadosEventos cd = new ControleDadosEventos();
      ArrayList<Evento> e = cd.pesquisarEventoData(diaSeguinte.toString());

      String data = "";

      for (int i=0; i<e.size(); i++){
        data = data +"Hota: "+e.get(i).getHora()+", Titulo: "+e.get(i).getTitulo()+"\n";
      }
      eventosData2 = data;
    }catch(Exception e){
      eventosData2 = "Sem eventos Hoje";
    }
    try{
      ControleDadosEventos cd = new ControleDadosEventos();
      ArrayList<Evento> e = cd.pesquisarEventoData(diaSeguinte2.toString());

      String data = "";

      for (int i=0; i<e.size(); i++){
        data = data +"Hota: "+e.get(i).getHora()+", Titulo: "+e.get(i).getTitulo()+"\n";
      }
      eventosData3 = data;
    }catch(Exception e){
      eventosData3 = "Sem eventos Hoje";
    }  
    
    //adiciona informacoes aos labels
    mesAno.setText(mes+"/"+ano);

    dataDia1.setText("Hoje\n"+ dia +"\n"+diaMes);
    eventosDia1.setText(eventosData1);

    dataDia2.setText("Amanha\n"+ diaSeguinte.getDayOfWeek().name()+"\n"+diaSeguinte.getDayOfMonth());
    eventosDia2.setText(eventosData2);

    dataDia3.setText("Depois de amanha\n"+ diaSeguinte2.getDayOfWeek().name()+"\n"+diaSeguinte2.getDayOfMonth());
    eventosDia3.setText(eventosData3);

    
  }

  /*********************************************************************
  * Metodo: start
  * Funcao: inicia tela do fxml
  * Parametros: stage para tela
  * Retorno: void
  ******************************************************************* */
  public void start(Stage stage) throws Exception {
    stage.setTitle("Calendario");

    Parent root = FXMLLoader.load(getClass().getResource("/view/CalendarioEventos.fxml"));

    Scene scene = new Scene(root);

    stage.setScene(scene);
    stage.show();
  }
}