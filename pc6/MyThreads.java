/* ***************************************************************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 26/04/2022
* Ultima alteracao.: 04/05/2022
* Nome.............: Barbeiro dorminhoco
* Funcao...........: O programa e utilizado resolver o problema classico de barbeiro dorminhoco
* com a espera de processos e concorrencia em acessar determinada regiao
*************************************************************** */
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/***********************
  * Classe: MyThreads 
  * Funcao: Agrupa os metodos e as classes compartilhadas das threads 
  * Parametros: 
  * Retorno: 
  *********************** */
public class MyThreads {
  private static final Semaphore mutex = new Semaphore(1);//semaforo 
  private static final Semaphore cheio = new Semaphore(0);//semaforo que bloqueia o vazio
  private static final Semaphore vazio = new Semaphore(3);//semaforo que bloqueia o cheio

  private double velocidadeBarbeiro, frequenciaCliente, tempoMinimo=500;//tempo de espera das threads
  private Queue<ImageView> clientes = new LinkedList<>();//"array" que armazena os clientes
  private ImageView[] iv; 
  private int[] x = {-300,-225,-150};//posicao dos bancos dos clientes
  private int[] y = {10,10,10};
  private ImageView barbeiro; 
  private Label ronco; 
  private int estadoBarbeiro = 0;// estado que o barbeiro esta(dormindo ou acordado)

  /***********************
  * Metodo: setImagens
  * Funcao: adiciona as imagens recebidas para o array com as imagens dos clientes
  * Parametros: ImageView vetor de imagens
  * Retorno: void
  *********************** */

  public void setImagens(ImageView[] imagens) {
    this.iv = imagens;
  }

  /***********************
  * Metodo: setVelocidade
  * Funcao: adiciona o tempo recebido para as variaveis
  * Parametros: Double tempo de espera
  * Retorno: void
  *********************** */
  public void setVelocidade(Double value) {
    this.velocidadeBarbeiro = value;
  }

  /***********************
  * Metodo: setFrequenciaCliente
  * Funcao: adiciona o tempo recebido para as variaveis
  * Parametros: Double tempo de espera
  * Retorno: void
  *********************** */
  public void setFrequenciaCliente(Double value) {
    this.frequenciaCliente = value;
  }

  /***********************
  * Metodo: setBarbeiro
  * Funcao: adiciona as imagens recebidas para o as variaveis da imagem do barbeiro e seu ronco
  * Parametros: ImageView de imagens
  * Retorno: void
  *********************** */
  public void setBarbeiro(ImageView imagem, Label ronco) {
    this.barbeiro = imagem;
    this.ronco = ronco;
  }

  /***********************
  * Classe: Barbeiro 
  * Funcao: Agrupa os metodos da thread responsavel pelo barbeiro
  * Parametros: 
  * Retorno: 
  *********************** */
  public class Barbeiro extends Thread{

    /***********************
    * Metodo: run
    * Funcao: executa cada funcao do barbeiro para cortar e dormir
    * Parametros: sem parametros
    * Retorno: void
    *********************** */
    public void run(){
      System.out.println("barbeiro");
      while(true){
        try {
          
          cheio.acquire();
          mutex.acquire();

          ImageView im = clientes.remove();//retira a primeira pessoa da fila e armazena em uma variavel temporaria
      
          im.setX(-510);//coloca o cliente na posisao da cadeira
    
          mutex.release();
          vazio.release();

          Thread.sleep((long) (1000*velocidadeBarbeiro));//faz o barbeiro esperar determinado tempo para cortar o cabelo 

          mutex.acquire();
          
          im.setX(0);//retorna o clente para a posicao inicial
          im.setY(0);

          im.setVisible(false);//deixa o cliente invisivel
          verificaClientes();//funcao que verifica se ainda existe algum cliente na fila
        
          System.out.println("Cabelo Cortado");

          mutex.release();
          

          
          
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

    }

    /***********************
    * Metodo: verificaClientes
    * Funcao: funcao que verifica se ainda existe algum cliente na fila
    * Parametros: sem parametros
    * Retorno: void
    *********************** */
    private void verificaClientes() {
      if(clientes.size() == 0){//se a lista for vazia entao
        barbeiro.setX(-60); //coloca o barbeiro na cadeira
        barbeiro.setY(50);
        estadoBarbeiro = 1;//coloca o estado como dormindo 
        ronco.setVisible(true);//deixa o ronco visivel 
      }
    }    
  }

  /***********************
  * Classe: Cliente 
  * Funcao: responsavel por deixar mandar os cliente e trabalha com eles
  * Parametros: 
  * Retorno: 
  *********************** */
  public class Cliente extends Thread{

    /***********************
    * Metodo: run
    * Funcao: executa a thread dos clientes e suas funcoes
    * Parametros: sem parametros
    * Retorno: void
    *********************** */
    public void run(){

      int i = 0;//variavel de controle dos clientes para exibir imagens 
      int a = 0;//variavel de controle para posicao nas cadeiras
      System.out.println("cliente");
      
      while(true){  
        try {

          Thread.sleep((long) ((11-frequenciaCliente)*1000));//espera um determinado tempo para mandar outro cliente
          
          if(clientes.size() < 3){//se o barbeiro não esta cheio
            vazio.acquire();
            mutex.acquire();

            if(estadoBarbeiro == 1){
              barbeiro.setX(0);
              barbeiro.setY(0);
              estadoBarbeiro = 0;
              ronco.setVisible(false);
            }
            
            clientes.add(iv[i]);//adiciona as pessoas a sala de espera
            iv[i].setVisible(true);//exibe, na tela, as pessoas adicionadas a sala
            Thread.sleep((long) tempoMinimo);//espera um tempo para a percepsao de adicionado

            iv[i].setX(x[a]);//adiciona na cadeira de espera, em cada posicao especifica
            iv[i].setY(y[a]);
            Thread.sleep((long) tempoMinimo);//espera um tempo para a percepsao de adicionado

            mutex.release();
            cheio.release();

            System.out.println("Cliente em espera");
            System.out.println(""+clientes.size());
            i++;
            a = (a+1)%3;//soma circular

          }else{//se esta cheio. porem não bloqueia o processo pois os cliente ainda chegam
            mutex.acquire();

            iv[i].setVisible(true);

            Thread.sleep((long) tempoMinimo);//tempo de percepcao para o cliente entrar e sair 

            iv[i].setVisible(false);

            System.out.println("Barbearia cheia");

            mutex.release();
          }
          
          if(i == 5){//retorna o valor das imagens a 0 quando chega ai fim 
            i=0;
          }

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}