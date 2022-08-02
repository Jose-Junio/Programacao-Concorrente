package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import model.Evento;

public class DadosEvento{
  /*********************************************************************
  * Metodo: cadastrarEvento
  * Funcao: cadastrar evento em arquivo serealizavel 
  * Parametros: evento cadastrado com o construtor, somente na memoria cache
  * Retorno: void
  ******************************************************************* */
  public void cadastrarEvento(Evento e)throws IOException, FileNotFoundException, ClassNotFoundException{
    ArrayList <Evento> evento = new ArrayList<Evento>(); // cria lista de eventos
    File arq = new File("listarEvento.ser"); //atribui o arquivo que ira ser lido
    if(arq.exists()){ // verifica a existencia do arquivo
      evento = listarEvento(); // lista os eventos ja cadastrados no arquivo com o metodo listarEvento()
    }
    evento.add(e); // adiciona o novo evento na lista
    FileOutputStream fluxo = new FileOutputStream(arq);
    try(ObjectOutputStream gravarObj = new ObjectOutputStream(fluxo)){ 
      gravarObj.writeObject(evento); //escreve os eventos no arquivo
    }
  }

  /*********************************************************************
  * Metodo: listarEvento
  * Funcao: lista eventos do arquivo serealizavel 
  * Parametros: sem parametros
  * Retorno: array list com eventos do arquivo
  ******************************************************************* */
  public ArrayList <Evento> listarEvento() throws FileNotFoundException, IOException, ClassNotFoundException{
    ArrayList<Evento> evento;// cria lista de eventos
    File arq = new File("listarEvento.ser");//atribui o arquivo que ira ser lido
    FileInputStream fluxo = new FileInputStream(arq);
    ObjectInputStream lerObj = new ObjectInputStream(fluxo);
    evento = (ArrayList<Evento>) lerObj.readObject();//atribui lista do arquivo ser na lista evento
    return evento;
  }
    
  /*********************************************************************
  * Metodo: removerEvento
  * Funcao: exclui evento do arquivo serealizavel 
  * Parametros: evento cadastrado com o construtor, somente na memoria cache
  * Retorno: void
  ******************************************************************* */
  public void removerEvento (Evento e) throws FileNotFoundException, IOException, ClassNotFoundException{
    ArrayList <Evento> evento;// cria lista de eventos
    File arq = new File ("listarEvento.ser");//atribui o arquivo que ira ser lido
    FileInputStream fluxo = new FileInputStream(arq);
    ObjectInputStream lerObj = new ObjectInputStream(fluxo);
    evento = (ArrayList<Evento>) lerObj.readObject();//atribui lista do arquivo ser na lista evento
    for(int i = 0; i<evento.size();i++){//percorre todos os eventos cadastrados
      if(evento.get(i).getId()== e.getId()){//verifica se os ids sao iguais
        evento.remove(i);//remove o evento escolhido
      }
    }
    FileOutputStream fl = new FileOutputStream(arq);
    try (ObjectOutputStream gravarObj = new ObjectOutputStream(fl)) {
      gravarObj.writeObject(evento);//reescreve a lista atualizada
    }
        
  }
}