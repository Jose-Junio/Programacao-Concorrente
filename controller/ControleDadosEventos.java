package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import data.DadosEvento;
import model.Evento;

public class ControleDadosEventos {
  
  /*********************************************************************
  * Metodo: cadastrarEvento
  * Funcao: chama metodo de cadastro em arquivos
  * Parametros: evento cadastrado
  * Retorno: void
  ******************************************************************* */
  public void cadastrarEvento(Evento e) throws Exception {
    DadosEvento dc = new DadosEvento();
    dc.cadastrarEvento(e);
  }

  /*********************************************************************
  * Metodo: cadastrarEvento
  * Funcao: cadastra evento com construtor posteriormente chama outro metodo de cadastro
  * Parametros: data, hora e titulo
  * Retorno: void
  ******************************************************************* */
  public void cadastrarEvento(String data, String hora, String titulo) throws Exception {
    Evento e = new Evento(data, hora, titulo);
    DadosEvento dc = new DadosEvento();
    dc.cadastrarEvento(e);
  }
    
  /*********************************************************************
  * Metodo: removerEvento
  * Funcao: pesquisa evento e remove chamando outro metodo de exclusao do arquivo
  * Parametros: data, hora
  * Retorno: void
  ******************************************************************* */
  public void removerEvento (String data, String hora) throws IOException, FileNotFoundException, ClassNotFoundException{
    Evento e = pesquisarEvento(data, hora);
    int id = e.getId();
    DadosEvento de = new DadosEvento();
    Evento d = pesquisarEvento(id);
    de.removerEvento(d);
  }
    
  /*********************************************************************
  * Metodo: pesquisarEvento
  * Funcao: pesquisa evento atravez do id percorrendo e comparando com toda a lista
  * Parametros: id
  * Retorno: Evento pesquisado
  ******************************************************************* */
  public Evento pesquisarEvento (int id) throws IOException, FileNotFoundException, ClassNotFoundException{
    Evento e = null;
    ArrayList <Evento> ev = listarEvento();
    for (int i=0; i<ev.size(); i++){
      if (id==ev.get(i).getId()){
        e= ev.get(i);
        break;
      }
    }
    return e;
  }

  /*********************************************************************
  * Metodo: imprimirEvento
  * Funcao: imprime informacoes do evento atravez do id pesquisado
  * Parametros: id
  * Retorno: dados do evento
  ******************************************************************* */
  public String imprimirEvento (int codigo) throws IOException, FileNotFoundException, ClassNotFoundException{
    Evento e = pesquisarEvento(codigo);
    return e.toString();
  }

  /*********************************************************************
  * Metodo: listarEvento
  * Funcao: lista todos os eventos existentes
  * Parametros: sem parametros
  * Retorno: ArrayList de eventos
  ******************************************************************* */
  public ArrayList<Evento> listarEvento() throws IOException, FileNotFoundException, ClassNotFoundException{
    DadosEvento de = new DadosEvento();
    return de.listarEvento();
  }

  /*********************************************************************
  * Metodo: pesquisarEvento
  * Funcao: pesquisa evento atravez da data e hora percorrendo e comparando com toda a lista
  * Parametros: data e hora
  * Retorno: Evento pesquisado
  ******************************************************************* */
  public Evento pesquisarEvento (String data, String hora) throws IOException, FileNotFoundException, ClassNotFoundException{
    Evento e = null;
    ArrayList <Evento> ev = listarEvento();
    for (int i=0; i<ev.size(); i++){
      if(data.equals(ev.get(i).getData())){
        if(hora.equals(ev.get(i).getHora())){
          e= ev.get(i);
          break;
        }
      }
    }
    return e;
  }

  /*********************************************************************
  * Metodo: pesquisarEventoData
  * Funcao: pesquisa evento atravez da data percorrendo e comparando com toda a lista
  * Parametros: data 
  * Retorno: lista com eventos da data pesquisada
  ******************************************************************* */
  public ArrayList<Evento> pesquisarEventoData (String data) throws IOException, FileNotFoundException, ClassNotFoundException{
    ArrayList <Evento> eventos = new ArrayList<Evento>();
    ArrayList <Evento> ev = listarEvento();
    for (int i=0; i<ev.size(); i++){
      if(data.equals(ev.get(i).getData())){
          eventos.add(ev.get(i));
      }
    }
    return eventos;
  }

}