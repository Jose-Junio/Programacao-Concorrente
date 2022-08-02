package model;

import java.io.Serializable;

public class Evento implements Serializable{
  private String data;
  private String hora;
  private String titulo;
  private int id;
  private static int totId = 0; 
  
  /*********************************************************************
  * Metodo: Construtor Evento
  * Funcao: inicia variaveis com as recebidas e atribui o id a cada novo evento,
  * id auto incremento com o total de eventos
  * Parametros: data, hora e titulo do evento
  * Retorno: void
  ******************************************************************* */
  public Evento(String datae, String horae, String tituloe){
    // inicia variaveis com as recebidas e atribui o id a cada novo evento,
    // id auto incremento com o total de eventos
    this.data = datae;
    this.hora = horae;
    this.titulo = tituloe;
    id = totId;
    totId++;  
  }

  /*********************************************************************
  * Metodo: getData, getHora, getTitulo e getId
  * Funcao: metodos get utilizados para obter dados do evento
  * Parametros: sem parametros
  * Retorno: String e int, valores de data, hora, titulo e id do evento
  ******************************************************************* */
  // metodos get utilizados para obter dados do evento
  public String getData(){
      return this.data;
  }

  public String getHora(){
    return this.hora;
  }   

  public String getTitulo(){
    return this.titulo;
  }
  
  public int getId(){
    return this.id;
  }
}
