/* *********************
* Autor............: José Júnio Barbosa de Jesus 
* Matricula........: 202010413
* Inicio...........: 29/03/2021
* Ultima alteracao.: 05/03/2022
* Nome.............: Sala de Espera
* Funcao...........: Utiliza conceitos de produtor consumidor para gerenciar uma sala de espera qualquer
* em que o produtor manda as pessoas para a sala e o consumidor tira elas de la
********************* */
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

import javafx.scene.image.ImageView;

/***********************
  * Classe: Threads 
  * Funcao: Agrupa os metodos e as classes compartilhadas das threads 
  * Parametros: 
  * Retorno: 
  *********************** */
public class Threads{
  private static final Semaphore sem = new Semaphore(1);//mutex
  private static final Semaphore cheio = new Semaphore(0);
  private static final Semaphore vazio = new Semaphore(7);

  Queue<ImageView> pessoas = new LinkedList<>();
  ImageView[] iv; 

  /***********************
  * Metodo: Threads(Construtor)
  * Funcao: Inicia as variaveis que são passadas pela classe acima 
  * Parametros: array de ImageView das pessoas
  * Retorno: void
  *********************** */
  public Threads(ImageView[] imagens) {
    this.iv = imagens;
  }

  /***********************
  * Classe: Produtor 
  * Funcao: Agrupa os metodos responsaveis pela producao de objetos/pessoas
  * Parametros: 
  * Retorno: 
  *********************** */
  public class Produtor extends Thread{
    private int velocidade;


  /***********************
  * Metodo: Produtor(Construtor)
  * Funcao: chamadas pela classe acima 
  * Parametros: sem parametros
  * Retorno: void
  *********************** */
    public Produtor(){
    }

  /***********************
  * Metodo: run
  * Funcao: adiciona as pessoas na sala de espera
  * Parametros: sem parametros
  * Retorno: void
  *********************** */
    @Override
    public void run() {
      System.out.println("Iniciando");
      int i = 0;
      while(true){
        try {
          Thread.sleep(velocidade*1000);//espera pela quantidade de tempo estipulada pelo usuario 
          
          vazio.acquire();
          sem.acquire();
          pessoas.add(iv[i]);//adiciona as pessoas a sala de espera
          iv[i].setVisible(true);//exibe, na tela, as pessoas adicionadas a sala
          Thread.sleep(100);//espera um tempo para a percepsao de adicionado
          sem.release();
          cheio.release();

          i++;

          System.out.println("Pessoa adicionada");
         
          if(i == 7){//retorna o valor das imagens a 0 quando chega ai fim 
            i=0;
          }

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

    /***********************
    * Metodo: setVelocidade
    * Funcao: adiciona a velocidade a variavel utilizada
    * Parametros: int velocidadeEntrada
    * Retorno: void
    *********************** */
    public void setVelocidade(int velocidadeEntrada) {
      this.velocidade = velocidadeEntrada;
    }    
  }
  
  /***********************
  * Classe: Consumidor 
  * Funcao: Agrupa os metodos responsaveis pelo consumo de objetos/pessoas
  * Parametros: 
  * Retorno: 
  *********************** */
  public class Consumidor extends Thread{
    private int velocidade;
    
  /***********************
  * Metodo: Consumidor(Construtor)
  * Funcao: chamadas pela classe acima 
  * Parametros: sem parametros
  * Retorno: void
  *********************** */
    public Consumidor(){
    }

    /***********************
    * Metodo: run
    * Funcao: retira as pessoas da sala de espera 
    * Parametros: sem parametros
    * Retorno: void
    *********************** */
    @Override
    public void run() {
      while(true){
        try {
          Thread.sleep(velocidade*1000);//espera pelo tempo informado pelo usuario

          cheio.acquire();
          sem.acquire();
          pessoas.remove().setVisible(false);//retira a primeira pessoa da fila e retira da tela
          Thread.sleep(100);//espera um tempo para a percepsao de retirada
          sem.release();
          vazio.release();

          System.out.println("Pessoa retirada");

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }

    /***********************
    * Metodo: setVelocidade
    * Funcao: adiciona a velocidade a variavel utilizada
    * Parametros: int velocidadeChamada
    * Retorno: void
    *********************** */
    public void setVelocidade(int velocidadeChamada) {
      this.velocidade = velocidadeChamada;
    }    
  }
}